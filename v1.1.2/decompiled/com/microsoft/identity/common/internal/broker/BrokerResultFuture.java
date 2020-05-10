package com.microsoft.identity.common.internal.broker;

import android.os.Bundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class BrokerResultFuture
  implements Future<Bundle>
{
  public final CountDownLatch mCountDownLatch = new CountDownLatch(1);
  public Bundle mResultBundle;
  
  public boolean cancel(boolean paramBoolean)
  {
    return false;
  }
  
  public Bundle get()
  {
    mCountDownLatch.await();
    return mResultBundle;
  }
  
  public Bundle get(long paramLong, TimeUnit paramTimeUnit)
  {
    if (mCountDownLatch.await(paramLong, paramTimeUnit)) {
      return mResultBundle;
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
  
  public void setResultBundle(Bundle paramBundle)
  {
    mResultBundle = paramBundle;
    mCountDownLatch.countDown();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.broker.BrokerResultFuture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */