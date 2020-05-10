package com.android.volley.toolbox;

import com.android.volley.Request;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

public abstract class BaseHttpStack
  implements HttpStack
{
  public abstract HttpResponse executeRequest(Request<?> paramRequest, Map<String, String> paramMap);
  
  @Deprecated
  public final org.apache.http.HttpResponse performRequest(Request<?> paramRequest, Map<String, String> paramMap)
  {
    paramRequest = executeRequest(paramRequest, paramMap);
    paramMap = new BasicHttpResponse(new BasicStatusLine(new ProtocolVersion("HTTP", 1, 1), paramRequest.getStatusCode(), ""));
    Object localObject1 = new ArrayList();
    Iterator localIterator = paramRequest.getHeaders().iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (com.android.volley.Header)localIterator.next();
      ((ArrayList)localObject1).add(new BasicHeader(((com.android.volley.Header)localObject2).getName(), ((com.android.volley.Header)localObject2).getValue()));
    }
    paramMap.setHeaders((org.apache.http.Header[])((ArrayList)localObject1).toArray(new org.apache.http.Header[((ArrayList)localObject1).size()]));
    localObject1 = paramRequest.getContent();
    if (localObject1 != null)
    {
      localObject2 = new BasicHttpEntity();
      ((BasicHttpEntity)localObject2).setContent((InputStream)localObject1);
      ((BasicHttpEntity)localObject2).setContentLength(paramRequest.getContentLength());
      paramMap.setEntity((HttpEntity)localObject2);
    }
    return paramMap;
  }
}

/* Location:
 * Qualified Name:     com.android.volley.toolbox.BaseHttpStack
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */