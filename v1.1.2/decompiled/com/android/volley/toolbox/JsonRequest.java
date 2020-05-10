package com.android.volley.toolbox;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyLog;
import java.io.UnsupportedEncodingException;

public abstract class JsonRequest<T>
  extends Request<T>
{
  public static final String PROTOCOL_CHARSET = "utf-8";
  public static final String PROTOCOL_CONTENT_TYPE = String.format("application/json; charset=%s", new Object[] { "utf-8" });
  public Response.Listener<T> mListener;
  public final Object mLock = new Object();
  public final String mRequestBody;
  
  public JsonRequest(int paramInt, String paramString1, String paramString2, Response.Listener<T> paramListener, Response.ErrorListener paramErrorListener)
  {
    super(paramInt, paramString1, paramErrorListener);
    mListener = paramListener;
    mRequestBody = paramString2;
  }
  
  @Deprecated
  public JsonRequest(String paramString1, String paramString2, Response.Listener<T> paramListener, Response.ErrorListener paramErrorListener)
  {
    this(-1, paramString1, paramString2, paramListener, paramErrorListener);
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
  
  public void deliverResponse(T paramT)
  {
    synchronized (mLock)
    {
      Response.Listener localListener = mListener;
      if (localListener != null) {
        localListener.onResponse(paramT);
      }
      return;
    }
  }
  
  public byte[] getBody()
  {
    byte[] arrayOfByte = null;
    try
    {
      if (mRequestBody != null) {
        arrayOfByte = mRequestBody.getBytes("utf-8");
      }
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", new Object[] { mRequestBody, "utf-8" });
    }
    return null;
  }
  
  public String getBodyContentType()
  {
    return PROTOCOL_CONTENT_TYPE;
  }
  
  @Deprecated
  public byte[] getPostBody()
  {
    return getBody();
  }
  
  @Deprecated
  public String getPostBodyContentType()
  {
    return getBodyContentType();
  }
  
  public abstract Response<T> parseNetworkResponse(NetworkResponse paramNetworkResponse);
}

/* Location:
 * Qualified Name:     com.android.volley.toolbox.JsonRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */