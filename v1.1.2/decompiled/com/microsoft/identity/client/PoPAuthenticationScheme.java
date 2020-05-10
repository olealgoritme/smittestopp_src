package com.microsoft.identity.client;

import com.microsoft.identity.common.internal.authscheme.IPoPAuthenticationSchemeParams;
import e.a.a.a.a;
import java.net.URL;

public class PoPAuthenticationScheme
  extends AuthenticationScheme
  implements IPoPAuthenticationSchemeParams
{
  public final HttpMethod mHttpMethod;
  public final String mNonce;
  public final URL mUrl;
  
  public PoPAuthenticationScheme(HttpMethod paramHttpMethod, URL paramURL, String paramString)
  {
    super("PoP");
    mHttpMethod = paramHttpMethod;
    mUrl = paramURL;
    mNonce = paramString;
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public String getHttpMethod()
  {
    return mHttpMethod.name();
  }
  
  public String getNonce()
  {
    return mNonce;
  }
  
  public URL getUrl()
  {
    return mUrl;
  }
  
  public static class Builder
  {
    public HttpMethod mHttpMethod;
    public String mNonce;
    public URL mUrl;
    
    public PoPAuthenticationScheme build()
    {
      URL localURL = mUrl;
      if (localURL != null)
      {
        HttpMethod localHttpMethod = mHttpMethod;
        if (localHttpMethod != null) {
          return new PoPAuthenticationScheme(localHttpMethod, localURL, mNonce, null);
        }
        throw new IllegalArgumentException(a.b("PoP authentication scheme param must not be null: ", "HTTP Method"));
      }
      throw new IllegalArgumentException(a.b("PoP authentication scheme param must not be null: ", "URL"));
    }
    
    public Builder withHttpMethod(HttpMethod paramHttpMethod)
    {
      mHttpMethod = paramHttpMethod;
      return this;
    }
    
    public Builder withNonce(String paramString)
    {
      mNonce = paramString;
      return this;
    }
    
    public Builder withUrl(URL paramURL)
    {
      mUrl = paramURL;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.PoPAuthenticationScheme
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */