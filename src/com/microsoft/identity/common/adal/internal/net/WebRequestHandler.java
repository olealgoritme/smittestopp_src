package com.microsoft.identity.common.adal.internal.net;

import android.os.Build;
import android.os.Build.VERSION;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import java.net.URL;
import java.util.Map;
import java.util.UUID;

public class WebRequestHandler
  implements IWebRequestHandler
{
  public static final String HEADER_ACCEPT = "Accept";
  public static final String HEADER_ACCEPT_JSON = "application/json";
  public String mCurrentClientVersion = "";
  public UUID mRequestCorrelationId = null;
  
  private Map<String, String> updateHeaders(Map<String, String> paramMap)
  {
    Object localObject = mRequestCorrelationId;
    if (localObject != null) {
      paramMap.put("client-request-id", ((UUID)localObject).toString());
    }
    paramMap.put("x-client-SKU", "Android");
    paramMap.put("x-client-Ver", mCurrentClientVersion);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
    paramMap.put("x-client-OS", ((StringBuilder)localObject).toString());
    paramMap.put("x-client-DM", Build.MODEL);
    return paramMap;
  }
  
  public HttpWebResponse sendGet(URL paramURL, Map<String, String> paramMap)
  {
    return new HttpWebRequest(paramURL, "GET", updateHeaders(paramMap)).send();
  }
  
  public HttpWebResponse sendPost(URL paramURL, Map<String, String> paramMap, byte[] paramArrayOfByte, String paramString)
  {
    return new HttpWebRequest(paramURL, "POST", updateHeaders(paramMap), paramArrayOfByte, paramString).send();
  }
  
  public void setClientVersion(String paramString)
  {
    if (!StringExtensions.isNullOrBlank(paramString)) {
      mCurrentClientVersion = paramString;
    }
  }
  
  public void setRequestCorrelationId(UUID paramUUID)
  {
    mRequestCorrelationId = paramUUID;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.adal.internal.net.WebRequestHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */