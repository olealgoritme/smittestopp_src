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
    paramMap = executeRequest(paramRequest, paramMap);
    paramRequest = new BasicHttpResponse(new BasicStatusLine(new ProtocolVersion("HTTP", 1, 1), paramMap.getStatusCode(), ""));
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramMap.getHeaders().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.android.volley.Header)((Iterator)localObject1).next();
      localArrayList.add(new BasicHeader(((com.android.volley.Header)localObject2).getName(), ((com.android.volley.Header)localObject2).getValue()));
    }
    paramRequest.setHeaders((org.apache.http.Header[])localArrayList.toArray(new org.apache.http.Header[localArrayList.size()]));
    Object localObject2 = paramMap.getContent();
    if (localObject2 != null)
    {
      localObject1 = new BasicHttpEntity();
      ((BasicHttpEntity)localObject1).setContent((InputStream)localObject2);
      ((BasicHttpEntity)localObject1).setContentLength(paramMap.getContentLength());
      paramRequest.setEntity((HttpEntity)localObject1);
    }
    return paramRequest;
  }
}

/* Location:
 * Qualified Name:     base.com.android.volley.toolbox.BaseHttpStack
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */