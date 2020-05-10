package com.android.volley;

public class ExecutorDelivery$ResponseDeliveryRunnable
  implements Runnable
{
  public final Request mRequest;
  public final Response mResponse;
  public final Runnable mRunnable;
  
  public ExecutorDelivery$ResponseDeliveryRunnable(Request paramRequest, Response paramResponse, Runnable paramRunnable)
  {
    mRequest = paramRequest;
    mResponse = paramResponse;
    mRunnable = paramRunnable;
  }
  
  public void run()
  {
    if (mRequest.isCanceled())
    {
      mRequest.finish("canceled-at-delivery");
      return;
    }
    if (mResponse.isSuccess()) {
      mRequest.deliverResponse(mResponse.result);
    } else {
      mRequest.deliverError(mResponse.error);
    }
    if (mResponse.intermediate) {
      mRequest.addMarker("intermediate-response");
    } else {
      mRequest.finish("done");
    }
    Runnable localRunnable = mRunnable;
    if (localRunnable != null) {
      localRunnable.run();
    }
  }
}

/* Location:
 * Qualified Name:     com.android.volley.ExecutorDelivery.ResponseDeliveryRunnable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */