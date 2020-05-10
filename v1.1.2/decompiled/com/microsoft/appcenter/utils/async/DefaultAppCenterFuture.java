package com.microsoft.appcenter.utils.async;

import com.microsoft.appcenter.utils.HandlerUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class DefaultAppCenterFuture<T>
  implements AppCenterFuture<T>
{
  public Collection<AppCenterConsumer<T>> mConsumers;
  public final CountDownLatch mLatch = new CountDownLatch(1);
  public T mResult;
  
  public void complete(T paramT)
  {
    try
    {
      if (!isDone())
      {
        mResult = paramT;
        mLatch.countDown();
        if (mConsumers != null)
        {
          Runnable local2 = new com/microsoft/appcenter/utils/async/DefaultAppCenterFuture$2;
          local2.<init>(this, paramT);
          HandlerUtils.runOnUiThread(local2);
        }
      }
      return;
    }
    finally
    {
      paramT = finally;
      throw paramT;
    }
  }
  
  public T get()
  {
    for (;;)
    {
      try
      {
        mLatch.await();
        return (T)mResult;
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
  
  public boolean isDone()
  {
    for (;;)
    {
      try
      {
        boolean bool = mLatch.await(0L, TimeUnit.MILLISECONDS);
        return bool;
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
  
  public void thenAccept(AppCenterConsumer<T> paramAppCenterConsumer)
  {
    try
    {
      Object localObject;
      if (isDone())
      {
        localObject = new com/microsoft/appcenter/utils/async/DefaultAppCenterFuture$1;
        ((1)localObject).<init>(this, paramAppCenterConsumer);
        HandlerUtils.runOnUiThread((Runnable)localObject);
      }
      else
      {
        if (mConsumers == null)
        {
          localObject = new java/util/LinkedList;
          ((LinkedList)localObject).<init>();
          mConsumers = ((Collection)localObject);
        }
        mConsumers.add(paramAppCenterConsumer);
      }
      return;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.utils.async.DefaultAppCenterFuture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */