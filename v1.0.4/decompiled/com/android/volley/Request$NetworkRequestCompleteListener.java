package com.android.volley;

public abstract interface Request$NetworkRequestCompleteListener
{
  public abstract void onNoUsableResponseReceived(Request<?> paramRequest);
  
  public abstract void onResponseReceived(Request<?> paramRequest, Response<?> paramResponse);
}

/* Location:
 * Qualified Name:     base.com.android.volley.Request.NetworkRequestCompleteListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */