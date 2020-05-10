package com.android.volley.toolbox;

import com.android.volley.Header;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class HttpResponse
{
  public final InputStream mContent;
  public final int mContentLength;
  public final List<Header> mHeaders;
  public final int mStatusCode;
  
  public HttpResponse(int paramInt, List<Header> paramList)
  {
    this(paramInt, paramList, -1, null);
  }
  
  public HttpResponse(int paramInt1, List<Header> paramList, int paramInt2, InputStream paramInputStream)
  {
    mStatusCode = paramInt1;
    mHeaders = paramList;
    mContentLength = paramInt2;
    mContent = paramInputStream;
  }
  
  public final InputStream getContent()
  {
    return mContent;
  }
  
  public final int getContentLength()
  {
    return mContentLength;
  }
  
  public final List<Header> getHeaders()
  {
    return Collections.unmodifiableList(mHeaders);
  }
  
  public final int getStatusCode()
  {
    return mStatusCode;
  }
}

/* Location:
 * Qualified Name:     base.com.android.volley.toolbox.HttpResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */