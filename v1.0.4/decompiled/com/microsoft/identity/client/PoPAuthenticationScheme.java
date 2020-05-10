package com.microsoft.identity.client;

import com.microsoft.identity.common.internal.authscheme.IPoPAuthenticationSchemeParams;
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
  
  public static PoPAuthenticationScheme.Builder builder()
  {
    return new PoPAuthenticationScheme.Builder(null);
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
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.PoPAuthenticationScheme
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */