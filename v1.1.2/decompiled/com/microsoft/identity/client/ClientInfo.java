package com.microsoft.identity.client;

import android.util.Base64;
import com.microsoft.identity.client.exception.MsalClientException;
import com.microsoft.identity.client.internal.MsalUtils;
import java.nio.charset.Charset;
import java.util.Map;
import org.json.JSONException;

public final class ClientInfo
{
  public final String mUniqueIdentifier;
  public final String mUniqueTenantIdentifier;
  
  public ClientInfo(String paramString)
  {
    if (MsalUtils.isEmpty(paramString))
    {
      mUniqueIdentifier = "";
      mUniqueTenantIdentifier = "";
      return;
    }
    paramString = new String(Base64.decode(paramString, 8), Charset.forName("UTF-8"));
    try
    {
      paramString = MsalUtils.extractJsonObjectIntoMap(paramString);
      mUniqueIdentifier = ((String)paramString.get("uid"));
      mUniqueTenantIdentifier = ((String)paramString.get("utid"));
      return;
    }
    catch (JSONException paramString)
    {
      throw new MsalClientException("json_parse_failure", "Failed to parse the returned raw client info.");
    }
  }
  
  public String getUniqueIdentifier()
  {
    String str;
    if (MsalUtils.isEmpty(mUniqueIdentifier)) {
      str = "";
    } else {
      str = mUniqueIdentifier;
    }
    return str;
  }
  
  public String getUniqueTenantIdentifier()
  {
    String str;
    if (MsalUtils.isEmpty(mUniqueTenantIdentifier)) {
      str = "";
    } else {
      str = mUniqueTenantIdentifier;
    }
    return str;
  }
  
  public static final class ClientInfoClaim
  {
    public static final String UNIQUE_IDENTIFIER = "uid";
    public static final String UNIQUE_TENANT_IDENTIFIER = "utid";
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.ClientInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */