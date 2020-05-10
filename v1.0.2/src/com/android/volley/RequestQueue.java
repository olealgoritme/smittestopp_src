package com.android.volley;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestQueue
{
  public static final int DEFAULT_NETWORK_THREAD_POOL_SIZE = 4;
  public final Cache mCache;
  public CacheDispatcher mCacheDispatcher;
  public final PriorityBlockingQueue<Request<?>> mCacheQueue = new PriorityBlockingQueue();
  public final Set<Request<?>> mCurrentRequests = new HashSet();
  public final ResponseDelivery mDelivery;
  public final NetworkDispatcher[] mDispatchers;
  public final List<RequestQueue.RequestFinishedListener> mFinishedListeners = new ArrayList();
  public final Network mNetwork;
  public final PriorityBlockingQueue<Request<?>> mNetworkQueue = new PriorityBlockingQueue();
  public final AtomicInteger mSequenceGenerator = new AtomicInteger();
  
  public RequestQueue(Cache paramCache, Network paramNetwork)
  {
    this(paramCache, paramNetwork, 4);
  }
  
  public RequestQueue(Cache paramCache, Network paramNetwork, int paramInt)
  {
    this(paramCache, paramNetwork, paramInt, new ExecutorDelivery(new Handler(Looper.getMainLooper())));
  }
  
  public RequestQueue(Cache paramCache, Network paramNetwork, int paramInt, ResponseDelivery paramResponseDelivery)
  {
    mCache = paramCache;
    mNetwork = paramNetwork;
    mDispatchers = new NetworkDispatcher[paramInt];
    mDelivery = paramResponseDelivery;
  }
  
  public <T> Request<T> add(Request<T> paramRequest)
  {
    paramRequest.setRequestQueue(this);
    synchronized (mCurrentRequests)
    {
      mCurrentRequests.add(paramRequest);
      paramRequest.setSequence(getSequenceNumber());
      paramRequest.addMarker("add-to-queue");
      if (!paramRequest.shouldCache())
      {
        mNetworkQueue.add(paramRequest);
        return paramRequest;
      }
      mCacheQueue.add(paramRequest);
      return paramRequest;
    }
  }
  
  public <T> void addRequestFinishedListener(RequestQueue.RequestFinishedListener<T> paramRequestFinishedListener)
  {
    synchronized (mFinishedListeners)
    {
      mFinishedListeners.add(paramRequestFinishedListener);
      return;
    }
  }
  
  public void cancelAll(RequestQueue.RequestFilter paramRequestFilter)
  {
    synchronized (mCurrentRequests)
    {
      Iterator localIterator = mCurrentRequests.iterator();
      while (localIterator.hasNext())
      {
        Request localRequest = (Request)localIterator.next();
        if (paramRequestFilter.apply(localRequest)) {
          localRequest.cancel();
        }
      }
      return;
    }
  }
  
  public void cancelAll(Object paramObject)
  {
    if (paramObject != null)
    {
      cancelAll(new RequestQueue.1(this, paramObject));
      return;
    }
    throw new IllegalArgumentException("Cannot cancelAll with a null tag");
  }
  
  public <T> void finish(Request<T> paramRequest)
  {
    synchronized (mCurrentRequests)
    {
      mCurrentRequests.remove(paramRequest);
      synchronized (mFinishedListeners)
      {
        Iterator localIterator = mFinishedListeners.iterator();
        while (localIterator.hasNext()) {
          ((RequestQueue.RequestFinishedListener)localIterator.next()).onRequestFinished(paramRequest);
        }
        return;
      }
    }
  }
  
  public Cache getCache()
  {
    return mCache;
  }
  
  public int getSequenceNumber()
  {
    return mSequenceGenerator.incrementAndGet();
  }
  
  public <T> void removeRequestFinishedListener(RequestQueue.RequestFinishedListener<T> paramRequestFinishedListener)
  {
    synchronized (mFinishedListeners)
    {
      mFinishedListeners.remove(paramRequestFinishedListener);
      return;
    }
  }
  
  public void start()
  {
    stop();
    Object localObject = new CacheDispatcher(mCacheQueue, mNetworkQueue, mCache, mDelivery);
    mCacheDispatcher = ((CacheDispatcher)localObject);
    ((Thread)localObject).start();
    for (int i = 0; i < mDispatchers.length; i++)
    {
      localObject = new NetworkDispatcher(mNetworkQueue, mNetwork, mCache, mDelivery);
      mDispatchers[i] = localObject;
      ((Thread)localObject).start();
    }
  }
  
  public void stop()
  {
    CacheDispatcher localCacheDispatcher = mCacheDispatcher;
    if (localCacheDispatcher != null) {
      localCacheDispatcher.quit();
    }
    for (localCacheDispatcher : mDispatchers) {
      if (localCacheDispatcher != null) {
        localCacheDispatcher.quit();
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.com.android.volley.RequestQueue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */