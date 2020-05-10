package com.android.volley.toolbox;

import com.android.volley.Request;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.conn.ConnectTimeoutException;

public class AdaptedHttpStack
  extends BaseHttpStack
{
  public final HttpStack mHttpStack;
  
  public AdaptedHttpStack(HttpStack paramHttpStack)
  {
    mHttpStack = paramHttpStack;
  }
  
  public HttpResponse executeRequest(Request<?> paramRequest, Map<String, String> paramMap)
  {
    try
    {
      paramRequest = mHttpStack.performRequest(paramRequest, paramMap);
      int i = paramRequest.getStatusLine().getStatusCode();
      org.apache.http.Header[] arrayOfHeader = paramRequest.getAllHeaders();
      ArrayList localArrayList = new ArrayList(arrayOfHeader.length);
      int j = arrayOfHeader.length;
      for (int k = 0; k < j; k++)
      {
        paramMap = arrayOfHeader[k];
        localArrayList.add(new com.android.volley.Header(paramMap.getName(), paramMap.getValue()));
      }
      if (paramRequest.getEntity() == null) {
        return new HttpResponse(i, localArrayList);
      }
      long l = paramRequest.getEntity().getContentLength();
      if ((int)l == l) {
        return new HttpResponse(i, localArrayList, (int)paramRequest.getEntity().getContentLength(), paramRequest.getEntity().getContent());
      }
      paramRequest = new StringBuilder();
      paramRequest.append("Response too large: ");
      paramRequest.append(l);
      throw new IOException(paramRequest.toString());
    }
    catch (ConnectTimeoutException paramRequest)
    {
      throw new SocketTimeoutException(paramRequest.getMessage());
    }
  }
}

/* Location:
 * Qualified Name:     base.com.android.volley.toolbox.AdaptedHttpStack
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */