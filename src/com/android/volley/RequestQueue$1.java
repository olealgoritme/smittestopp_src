package com.android.volley;

public class RequestQueue$1
  implements RequestQueue.RequestFilter
{
  public RequestQueue$1(RequestQueue paramRequestQueue, Object paramObject) {}
  
  public boolean apply(Request<?> paramRequest)
  {
    boolean bool;
    if (paramRequest.getTag() == val$tag) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     base.com.android.volley.RequestQueue.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */