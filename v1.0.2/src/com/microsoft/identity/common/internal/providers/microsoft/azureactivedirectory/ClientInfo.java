package com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory;

import android.util.Base64;
import com.microsoft.identity.common.adal.internal.util.JsonExtensions;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.exception.ServiceException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Map;
import org.json.JSONException;

public class ClientInfo
  implements Serializable
{
  public static final String UNIQUE_IDENTIFIER = "uid";
  public static final String UNIQUE_TENANT_IDENTIFIER = "utid";
  public String mRawClientInfo;
  public String mUid;
  public String mUtid;
  
  public ClientInfo(String paramString)
  {
    if (!StringExtensions.isNullOrBlank(paramString))
    {
      Object localObject = new String(Base64.decode(paramString, 8), Charset.forName("UTF-8"));
      try
      {
        localObject = JsonExtensions.extractJsonObjectIntoMap((String)localObject);
        mUid = ((String)((Map)localObject).get("uid"));
        mUtid = ((String)((Map)localObject).get("utid"));
        mRawClientInfo = paramString;
        return;
      }
      catch (JSONException paramString)
      {
        throw new ServiceException("", "invalid_jwt", paramString);
      }
    }
    throw new IllegalArgumentException("ClientInfo cannot be null or blank.");
  }
  
  public String getRawClientInfo()
  {
    return mRawClientInfo;
  }
  
  public String getUid()
  {
    return mUid;
  }
  
  public String getUtid()
  {
    return mUtid;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.ClientInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */