package com.android.volley;

import android.os.Handler;
import java.util.concurrent.Executor;

public class ExecutorDelivery
  implements ResponseDelivery
{
  public final Executor mResponsePoster;
  
  public ExecutorDelivery(Handler paramHandler)
  {
    mResponsePoster = new ExecutorDelivery.1(this, paramHandler);
  }
  
  public ExecutorDelivery(Executor paramExecutor)
  {
    mResponsePoster = paramExecutor;
  }
  
  public void postError(Request<?> paramRequest, VolleyError paramVolleyError)
  {
    paramRequest.addMarker("post-error");
    paramVolleyError = Response.error(paramVolleyError);
    mResponsePoster.execute(new ExecutorDelivery.ResponseDeliveryRunnable(paramRequest, paramVolleyError, null));
  }
  
  public void postResponse(Request<?> paramRequest, Response<?> paramResponse)
  {
    postResponse(paramRequest, paramResponse, null);
  }
  
  public void postResponse(Request<?> paramRequest, Response<?> paramResponse, Runnable paramRunnable)
  {
    paramRequest.markDelivered();
    paramRequest.addMarker("post-response");
    mResponsePoster.execute(new ExecutorDelivery.ResponseDeliveryRunnable(paramRequest, paramResponse, paramRunnable));
  }
}

/* Location:
 * Qualified Name:     base.com.android.volley.ExecutorDelivery
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */