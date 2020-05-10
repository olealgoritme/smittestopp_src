package com.android.volley.toolbox;

import com.android.volley.Request;
import java.util.Map;
import org.apache.http.HttpResponse;

@Deprecated
public abstract interface HttpStack
{
  public abstract HttpResponse performRequest(Request<?> paramRequest, Map<String, String> paramMap);
}

/* Location:
 * Qualified Name:     com.android.volley.toolbox.HttpStack
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */