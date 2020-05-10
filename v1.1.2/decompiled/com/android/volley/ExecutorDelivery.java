package com.android.volley;

import android.os.Handler;
import java.util.concurrent.Executor;

public class ExecutorDelivery
  implements ResponseDelivery
{
  public final Executor mResponsePoster;
  
  public ExecutorDelivery(final Handler paramHandler)
  {
    mResponsePoster = new Executor()
    {
      public void execute(Runnable paramAnonymousRunnable)
      {
        paramHandler.post(paramAnonymousRunnable);
      }
    };
  }
  
  public ExecutorDelivery(Executor paramExecutor)
  {
    mResponsePoster = paramExecutor;
  }
  
  public void postError(Request<?> paramRequest, VolleyError paramVolleyError)
  {
    paramRequest.addMarker("post-error");
    paramVolleyError = Response.error(paramVolleyError);
    mResponsePoster.execute(new ResponseDeliveryRunnable(paramRequest, paramVolleyError, null));
  }
  
  public void postResponse(Request<?> paramRequest, Response<?> paramResponse)
  {
    postResponse(paramRequest, paramResponse, null);
  }
  
  public void postResponse(Request<?> paramRequest, Response<?> paramResponse, Runnable paramRunnable)
  {
    paramRequest.markDelivered();
    paramRequest.addMarker("post-response");
    mResponsePoster.execute(new ResponseDeliveryRunnable(paramRequest, paramResponse, paramRunnable));
  }
  
  public static class ResponseDeliveryRunnable
    implements Runnable
  {
    public final Request mRequest;
    public final Response mResponse;
    public final Runnable mRunnable;
    
    public ResponseDeliveryRunnable(Request paramRequest, Response paramResponse, Runnable paramRunnable)
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
}

/* Location:
 * Qualified Name:     com.android.volley.ExecutorDelivery
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */