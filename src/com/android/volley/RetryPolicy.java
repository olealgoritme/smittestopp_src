package com.android.volley;

public abstract interface RetryPolicy
{
  public abstract int getCurrentRetryCount();
  
  public abstract int getCurrentTimeout();
  
  public abstract void retry(VolleyError paramVolleyError);
}

/* Location:
 * Qualified Name:     base.com.android.volley.RetryPolicy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */