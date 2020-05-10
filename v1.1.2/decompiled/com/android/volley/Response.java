package com.android.volley;

public class Response<T>
{
  public final Cache.Entry cacheEntry;
  public final VolleyError error;
  public boolean intermediate = false;
  public final T result;
  
  public Response(VolleyError paramVolleyError)
  {
    result = null;
    cacheEntry = null;
    error = paramVolleyError;
  }
  
  public Response(T paramT, Cache.Entry paramEntry)
  {
    result = paramT;
    cacheEntry = paramEntry;
    error = null;
  }
  
  public static <T> Response<T> error(VolleyError paramVolleyError)
  {
    return new Response(paramVolleyError);
  }
  
  public static <T> Response<T> success(T paramT, Cache.Entry paramEntry)
  {
    return new Response(paramT, paramEntry);
  }
  
  public boolean isSuccess()
  {
    boolean bool;
    if (error == null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static abstract interface ErrorListener
  {
    public abstract void onErrorResponse(VolleyError paramVolleyError);
  }
  
  public static abstract interface Listener<T>
  {
    public abstract void onResponse(T paramT);
  }
}

/* Location:
 * Qualified Name:     com.android.volley.Response
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */