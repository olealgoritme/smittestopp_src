package com.microsoft.identity.common.internal.broker;

import com.microsoft.identity.client.IMicrosoftAuthService;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MicrosoftAuthServiceFuture
  implements Future<IMicrosoftAuthService>
{
  public final CountDownLatch mCountDownLatch = new CountDownLatch(1);
  public IMicrosoftAuthService mMicrosoftAuthService;
  
  public boolean cancel(boolean paramBoolean)
  {
    return false;
  }
  
  public IMicrosoftAuthService get()
  {
    mCountDownLatch.await();
    return mMicrosoftAuthService;
  }
  
  public IMicrosoftAuthService get(long paramLong, TimeUnit paramTimeUnit)
  {
    if (mCountDownLatch.await(paramLong, paramTimeUnit)) {
      return mMicrosoftAuthService;
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
  
  public void setMicrosoftAuthService(IMicrosoftAuthService paramIMicrosoftAuthService)
  {
    mMicrosoftAuthService = paramIMicrosoftAuthService;
    mCountDownLatch.countDown();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.broker.MicrosoftAuthServiceFuture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */