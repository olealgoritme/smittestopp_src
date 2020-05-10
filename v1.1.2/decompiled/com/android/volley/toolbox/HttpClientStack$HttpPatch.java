package com.android.volley.toolbox;

import java.net.URI;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

public final class HttpClientStack$HttpPatch
  extends HttpEntityEnclosingRequestBase
{
  public static final String METHOD_NAME = "PATCH";
  
  public HttpClientStack$HttpPatch() {}
  
  public HttpClientStack$HttpPatch(String paramString)
  {
    setURI(URI.create(paramString));
  }
  
  public HttpClientStack$HttpPatch(URI paramURI)
  {
    setURI(paramURI);
  }
  
  public String getMethod()
  {
    return "PATCH";
  }
}

/* Location:
 * Qualified Name:     com.android.volley.toolbox.HttpClientStack.HttpPatch
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */