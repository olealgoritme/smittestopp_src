package com.microsoft.identity.common.internal.result;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ResultFuture<T>
  implements Future<T>
{
  public final CountDownLatch mCountDownLatch = new CountDownLatch(1);
  public T mResult;
  
  public boolean cancel(boolean paramBoolean)
  {
    return false;
  }
  
  public T get()
  {
    mCountDownLatch.await();
    return (T)mResult;
  }
  
  public T get(long paramLong, TimeUnit paramTimeUnit)
  {
    if (mCountDownLatch.await(paramLong, paramTimeUnit)) {
      return (T)mResult;
    }
    throw new TimeoutException();
  }
  
  public boolean isCancelled()
  {
    return false;
  }
  
  public boolean isDone()
  {
    boolean bool;
    if (mCountDownLatch.getCount() == 0L) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void setResult(T paramT)
  {
    mResult = paramT;
    mCountDownLatch.countDown();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.result.ResultFuture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */