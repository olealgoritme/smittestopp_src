package com.android.volley;

public class VolleyError
  extends Exception
{
  public final NetworkResponse networkResponse;
  public long networkTimeMs;
  
  public VolleyError()
  {
    networkResponse = null;
  }
  
  public VolleyError(NetworkResponse paramNetworkResponse)
  {
    networkResponse = paramNetworkResponse;
  }
  
  public VolleyError(String paramString)
  {
    super(paramString);
    networkResponse = null;
  }
  
  public VolleyError(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    networkResponse = null;
  }
  
  public VolleyError(Throwable paramThrowable)
  {
    super(paramThrowable);
    networkResponse = null;
  }
  
  public long getNetworkTimeMs()
  {
    return networkTimeMs;
  }
  
  public void setNetworkTimeMs(long paramLong)
  {
    networkTimeMs = paramLong;
  }
}

/* Location:
 * Qualified Name:     com.android.volley.VolleyError
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */