package com.microsoft.identity.common.internal.broker;

import com.microsoft.aad.adal.IBrokerAccountService;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class BrokerAccountServiceFuture
  implements Future<IBrokerAccountService>
{
  public IBrokerAccountService mBrokerAccountService;
  public final CountDownLatch mCountDownLatch = new CountDownLatch(1);
  
  public boolean cancel(boolean paramBoolean)
  {
    return false;
  }
  
  public IBrokerAccountService get()
  {
    mCountDownLatch.await();
    return mBrokerAccountService;
  }
  
  public IBrokerAccountService get(long paramLong, TimeUnit paramTimeUnit)
  {
    if (mCountDownLatch.await(paramLong, paramTimeUnit)) {
      return mBrokerAccountService;
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
  
  public void setBrokerAccountService(IBrokerAccountService paramIBrokerAccountService)
  {
    mBrokerAccountService = paramIBrokerAccountService;
    mCountDownLatch.countDown();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.broker.BrokerAccountServiceFuture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */