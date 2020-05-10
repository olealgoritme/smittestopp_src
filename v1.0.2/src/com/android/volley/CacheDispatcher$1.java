package com.android.volley;

import java.util.concurrent.BlockingQueue;

public class CacheDispatcher$1
  implements Runnable
{
  public CacheDispatcher$1(CacheDispatcher paramCacheDispatcher, Request paramRequest) {}
  
  public void run()
  {
    try
    {
      CacheDispatcher.access$100(this$0).put(val$request);
    }
    catch (InterruptedException localInterruptedException)
    {
      Thread.currentThread().interrupt();
    }
  }
}

/* Location:
 * Qualified Name:     base.com.android.volley.CacheDispatcher.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */