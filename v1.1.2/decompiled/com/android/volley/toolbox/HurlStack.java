package com.android.volley.toolbox;

import com.android.volley.Header;
import com.android.volley.Request;
import e.a.a.a.a;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class HurlStack
  extends BaseHttpStack
{
  public static final int HTTP_CONTINUE = 100;
  public final SSLSocketFactory mSslSocketFactory;
  public final UrlRewriter mUrlRewriter;
  
  public HurlStack()
  {
    this(null);
  }
  
  public HurlStack(UrlRewriter paramUrlRewriter)
  {
    this(paramUrlRewriter, null);
  }
  
  public HurlStack(UrlRewriter paramUrlRewriter, SSLSocketFactory paramSSLSocketFactory)
  {
    mUrlRewriter = paramUrlRewriter;
    mSslSocketFactory = paramSSLSocketFactory;
  }
  
  public static void addBody(HttpURLConnection paramHttpURLConnection, Request<?> paramRequest, byte[] paramArrayOfByte)
  {
    paramHttpURLConnection.setDoOutput(true);
    if (!paramHttpURLConnection.getRequestProperties().containsKey("Content-Type")) {
      paramHttpURLConnection.setRequestProperty("Content-Type", paramRequest.getBodyContentType());
    }
    paramHttpURLConnection = new DataOutputStream(paramHttpURLConnection.getOutputStream());
    paramHttpURLConnection.write(paramArrayOfByte);
    paramHttpURLConnection.close();
  }
  
  public static void addBodyIfExists(HttpURLConnection paramHttpURLConnection, Request<?> paramRequest)
  {
    byte[] arrayOfByte = paramRequest.getBody();
    if (arrayOfByte != null) {
      addBody(paramHttpURLConnection, paramRequest, arrayOfByte);
    }
  }
  
  public static List<Header> convertHeaders(Map<String, List<String>> paramMap)
  {
    ArrayList localArrayList = new ArrayList(paramMap.size());
    Iterator localIterator1 = paramMap.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      if (localEntry.getKey() != null)
      {
        Iterator localIterator2 = ((List)localEntry.getValue()).iterator();
        while (localIterator2.hasNext())
        {
          paramMap = (String)localIterator2.next();
          localArrayList.add(new Header((String)localEntry.getKey(), paramMap));
        }
      }
    }
    return localArrayList;
  }
  
  public static boolean hasResponseBody(int paramInt1, int paramInt2)
  {
    boolean bool;
    if ((paramInt1 != 4) && ((100 > paramInt2) || (paramInt2 >= 200)) && (paramInt2 != 204) && (paramInt2 != 304)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static InputStream inputStreamFromConnection(HttpURLConnection paramHttpURLConnection)
  {
    try
    {
      InputStream localInputStream = paramHttpURLConnection.getInputStream();
      paramHttpURLConnection = localInputStream;
    }
    catch (IOException localIOException)
    {
      paramHttpURLConnection = paramHttpURLConnection.getErrorStream();
    }
    return paramHttpURLConnection;
  }
  
  private HttpURLConnection openConnection(URL paramURL, Request<?> paramRequest)
  {
    HttpURLConnection localHttpURLConnection = createConnection(paramURL);
    int i = paramRequest.getTimeoutMs();
    localHttpURLConnection.setConnectTimeout(i);
    localHttpURLConnection.setReadTimeout(i);
    localHttpURLConnection.setUseCaches(false);
    localHttpURLConnection.setDoInput(true);
    if ("https".equals(paramURL.getProtocol()))
    {
      paramURL = mSslSocketFactory;
      if (paramURL != null) {
        ((HttpsURLConnection)localHttpURLConnection).setSSLSocketFactory(paramURL);
      }
    }
    return localHttpURLConnection;
  }
  
  public static void setConnectionParametersForRequest(HttpURLConnection paramHttpURLConnection, Request<?> paramRequest)
  {
    switch (paramRequest.getMethod())
    {
    default: 
      throw new IllegalStateException("Unknown method type.");
    case 7: 
      paramHttpURLConnection.setRequestMethod("PATCH");
      addBodyIfExists(paramHttpURLConnection, paramRequest);
      break;
    case 6: 
      paramHttpURLConnection.setRequestMethod("TRACE");
      break;
    case 5: 
      paramHttpURLConnection.setRequestMethod("OPTIONS");
      break;
    case 4: 
      paramHttpURLConnection.setRequestMethod("HEAD");
      break;
    case 3: 
      paramHttpURLConnection.setRequestMethod("DELETE");
      break;
    case 2: 
      paramHttpURLConnection.setRequestMethod("PUT");
      addBodyIfExists(paramHttpURLConnection, paramRequest);
      break;
    case 1: 
      paramHttpURLConnection.setRequestMethod("POST");
      addBodyIfExists(paramHttpURLConnection, paramRequest);
      break;
    case 0: 
      paramHttpURLConnection.setRequestMethod("GET");
      break;
    case -1: 
      byte[] arrayOfByte = paramRequest.getPostBody();
      if (arrayOfByte != null)
      {
        paramHttpURLConnection.setRequestMethod("POST");
        addBody(paramHttpURLConnection, paramRequest, arrayOfByte);
      }
      break;
    }
  }
  
  public HttpURLConnection createConnection(URL paramURL)
  {
    paramURL = (HttpURLConnection)paramURL.openConnection();
    paramURL.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
    return paramURL;
  }
  
  public HttpResponse executeRequest(Request<?> paramRequest, Map<String, String> paramMap)
  {
    Object localObject1 = paramRequest.getUrl();
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(paramMap);
    localHashMap.putAll(paramRequest.getHeaders());
    Object localObject2 = mUrlRewriter;
    paramMap = (Map<String, String>)localObject1;
    if (localObject2 != null)
    {
      paramMap = ((UrlRewriter)localObject2).rewriteUrl((String)localObject1);
      if (paramMap == null) {
        throw new IOException(a.b("URL blocked by rewriter: ", (String)localObject1));
      }
    }
    paramMap = openConnection(new URL(paramMap), paramRequest);
    int i = 0;
    int j = i;
    try
    {
      localObject2 = localHashMap.keySet().iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        j = i;
        localObject1 = (String)((Iterator)localObject2).next();
        j = i;
        paramMap.setRequestProperty((String)localObject1, (String)localHashMap.get(localObject1));
      }
      j = i;
      setConnectionParametersForRequest(paramMap, paramRequest);
      j = i;
      int k = paramMap.getResponseCode();
      if (k != -1)
      {
        j = i;
        if (!hasResponseBody(paramRequest.getMethod(), k))
        {
          j = i;
          paramRequest = new HttpResponse(k, convertHeaders(paramMap.getHeaderFields()));
          paramMap.disconnect();
          return paramRequest;
        }
        i = 1;
        j = i;
        localObject1 = convertHeaders(paramMap.getHeaderFields());
        j = i;
        int m = paramMap.getContentLength();
        j = i;
        paramRequest = new com/android/volley/toolbox/HurlStack$UrlConnectionInputStream;
        j = i;
        paramRequest.<init>(paramMap);
        j = i;
        return new HttpResponse(k, (List)localObject1, m, paramRequest);
      }
      j = i;
      paramRequest = new java/io/IOException;
      j = i;
      paramRequest.<init>("Could not retrieve response code from HttpUrlConnection.");
      j = i;
      throw paramRequest;
    }
    finally
    {
      if (j == 0) {
        paramMap.disconnect();
      }
    }
  }
  
  public static class UrlConnectionInputStream
    extends FilterInputStream
  {
    public final HttpURLConnection mConnection;
    
    public UrlConnectionInputStream(HttpURLConnection paramHttpURLConnection)
    {
      super();
      mConnection = paramHttpURLConnection;
    }
    
    public void close()
    {
      super.close();
      mConnection.disconnect();
    }
  }
  
  public static abstract interface UrlRewriter
  {
    public abstract String rewriteUrl(String paramString);
  }
}

/* Location:
 * Qualified Name:     com.android.volley.toolbox.HurlStack
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */