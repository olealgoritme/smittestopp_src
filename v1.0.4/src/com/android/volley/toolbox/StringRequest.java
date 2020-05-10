package com.android.volley.toolbox;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import java.io.UnsupportedEncodingException;

public class StringRequest
  extends Request<String>
{
  public Response.Listener<String> mListener;
  public final Object mLock = new Object();
  
  public StringRequest(int paramInt, String paramString, Response.Listener<String> paramListener, Response.ErrorListener paramErrorListener)
  {
    super(paramInt, paramString, paramErrorListener);
    mListener = paramListener;
  }
  
  public StringRequest(String paramString, Response.Listener<String> paramListener, Response.ErrorListener paramErrorListener)
  {
    this(0, paramString, paramListener, paramErrorListener);
  }
  
  public void cancel()
  {
    super.cancel();
    synchronized (mLock)
    {
      mListener = null;
      return;
    }
  }
  
  public void deliverResponse(String paramString)
  {
    synchronized (mLock)
    {
      Response.Listener localListener = mListener;
      if (localListener != null) {
        localListener.onResponse(paramString);
      }
      return;
    }
  }
  
  public Response<String> parseNetworkResponse(NetworkResponse paramNetworkResponse)
  {
    String str2;
    try
    {
      String str1 = new java/lang/String;
      str1.<init>(data, HttpHeaderParser.parseCharset(headers));
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      str2 = new String(data);
    }
    return Response.success(str2, HttpHeaderParser.parseCacheHeaders(paramNetworkResponse));
  }
}

/* Location:
 * Qualified Name:     base.com.android.volley.toolbox.StringRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */