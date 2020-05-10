package com.microsoft.identity.common.internal.authscheme;

import com.microsoft.identity.common.internal.platform.Device;
import com.microsoft.identity.common.internal.platform.IDevicePopManager;
import e.c.c.v.c;
import java.net.URL;

public class PopAuthenticationSchemeInternal
  extends TokenAuthenticationScheme
  implements IPoPAuthenticationSchemeParams
{
  public static final String SCHEME_POP = "PoP";
  @c("http_method")
  public String mHttpMethod;
  @c("nonce")
  public String mNonce;
  @c("url")
  public URL mUrl;
  
  public PopAuthenticationSchemeInternal()
  {
    super("PoP");
  }
  
  public PopAuthenticationSchemeInternal(String paramString1, URL paramURL, String paramString2)
  {
    super("PoP");
    mHttpMethod = paramString1;
    mUrl = paramURL;
    mNonce = paramString2;
  }
  
  public String getAccessTokenForScheme(String paramString)
  {
    return Device.getDevicePoPManagerInstance().mintSignedAccessToken(getHttpMethod(), getUrl(), paramString, getNonce());
  }
  
  public String getHttpMethod()
  {
    return mHttpMethod;
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
 * Qualified Name:     base.com.microsoft.identity.common.internal.authscheme.PopAuthenticationSchemeInternal
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */