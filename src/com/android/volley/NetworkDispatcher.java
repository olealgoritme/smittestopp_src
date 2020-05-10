package com.android.volley;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

public class NetworkDispatcher
  extends Thread
{
  public final Cache mCache;
  public final ResponseDelivery mDelivery;
  public final Network mNetwork;
  public final BlockingQueue<Request<?>> mQueue;
  public volatile boolean mQuit = false;
  
  public NetworkDispatcher(BlockingQueue<Request<?>> paramBlockingQueue, Network paramNetwork, Cache paramCache, ResponseDelivery paramResponseDelivery)
  {
    mQueue = paramBlockingQueue;
    mNetwork = paramNetwork;
    mCache = paramCache;
    mDelivery = paramResponseDelivery;
  }
  
  @TargetApi(14)
  private void addTrafficStatsTag(Request<?> paramRequest)
  {
    TrafficStats.setThreadStatsTag(paramRequest.getTrafficStatsTag());
  }
  
  private void parseAndDeliverNetworkError(Request<?> paramRequest, VolleyError paramVolleyError)
  {
    paramVolleyError = paramRequest.parseNetworkError(paramVolleyError);
    mDelivery.postError(paramRequest, paramVolleyError);
  }
  
  private void processRequest()
  {
    processRequest((Request)mQueue.take());
  }
  
  public void processRequest(Request<?> paramRequest)
  {
    long l = SystemClock.elapsedRealtime();
    try
    {
      paramRequest.addMarker("network-queue-take");
      if (paramRequest.isCanceled())
      {
        paramRequest.finish("network-discard-cancelled");
        paramRequest.notifyListenerResponseNotUsable();
        return;
      }
      addTrafficStatsTag(paramRequest);
      Object localObject = mNetwork.performRequest(paramRequest);
      paramRequest.addMarker("network-http-complete");
      if ((notModified) && (paramRequest.hasHadResponseDelivered()))
      {
        paramRequest.finish("not-modified");
        paramRequest.notifyListenerResponseNotUsable();
        return;
      }
      localObject = paramRequest.parseNetworkResponse((NetworkResponse)localObject);
      paramRequest.addMarker("network-parse-complete");
      if ((paramRequest.shouldCache()) && (cacheEntry != null))
      {
        mCache.put(paramRequest.getCacheKey(), cacheEntry);
        paramRequest.addMarker("network-cache-written");
      }
      paramRequest.markDelivered();
      mDelivery.postResponse(paramRequest, (Response)localObject);
      paramRequest.notifyListenerResponseReceived((Response)localObject);
    }
    catch (Exception localException)
    {
      VolleyLog.e(localException, "Unhandled exception %s", new Object[] { localException.toString() });
      VolleyError localVolleyError1 = new VolleyError(localException);
      localVolleyError1.setNetworkTimeMs(SystemClock.elapsedRealtime() - l);
      mDelivery.postError(paramRequest, localVolleyError1);
      paramRequest.notifyListenerResponseNotUsable();
    }
    catch (VolleyError localVolleyError2)
    {
      localVolleyError2.setNetworkTimeMs(SystemClock.elapsedRealtime() - l);
      parseAndDeliverNetworkError(paramRequest, localVolleyError2);
      paramRequest.notifyListenerResponseNotUsable();
    }
  }
  
  public void quit()
  {
    mQuit = true;
    interrupt();
  }
  
  public void run()
  {
    Process.setThreadPriority(10);
    try
    {
      for (;;)
      {
        processRequest();
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      if (mQuit)
      {
        Thread.currentThread().interrupt();
        return;
      }
      VolleyLog.e("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
    }
  }
}

/* Location:
 * Qualified Name:     base.com.android.volley.NetworkDispatcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */