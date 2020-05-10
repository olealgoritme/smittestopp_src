package com.microsoft.identity.client;

import com.microsoft.identity.client.exception.MsalClientException;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.providers.oauth2.IDToken;
import com.microsoft.identity.common.internal.util.StringUtil;
import java.util.Map;

public class Account
  implements IAccount
{
  public static final String TAG = Account.class.getSimpleName();
  public String mClientInfo;
  public String mEnvironment;
  public String mHomeOid;
  public String mHomeTenantId;
  public final Map<String, ?> mIdTokenClaims;
  public final String mRawIdToken;
  
  public Account(String paramString, IDToken paramIDToken)
  {
    mClientInfo = paramString;
    if (paramIDToken != null)
    {
      mIdTokenClaims = paramIDToken.getTokenClaims();
      mRawIdToken = paramIDToken.getRawIDToken();
    }
    else
    {
      mIdTokenClaims = null;
      mRawIdToken = null;
    }
  }
  
  public String getAuthority()
  {
    if (getClaims() != null)
    {
      String str = (String)getClaims().get("iss");
      if (!StringUtil.isEmpty(str)) {
        return str;
      }
    }
    return "Missing from the token response";
  }
  
  public Map<String, ?> getClaims()
  {
    return mIdTokenClaims;
  }
  
  public String getEnvironment()
  {
    return mEnvironment;
  }
  
  public String getHomeAccountId()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getId());
    localStringBuilder.append(".");
    localStringBuilder.append(mHomeTenantId);
    return localStringBuilder.toString();
  }
  
  public String getId()
  {
    String str = mClientInfo;
    Object localObject;
    if (str != null) {
      try
      {
        ClientInfo localClientInfo = new com/microsoft/identity/client/ClientInfo;
        localClientInfo.<init>(str);
      }
      catch (MsalClientException localMsalClientException)
      {
        Logger.error(TAG, "Failed to parse ClientInfo", localMsalClientException);
      }
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      localObject = ((ClientInfo)localObject).getUniqueIdentifier();
    }
    else
    {
      localObject = mIdTokenClaims;
      if (localObject != null) {
        localObject = (String)((Map)localObject).get("oid");
      } else {
        localObject = mHomeOid;
      }
    }
    return (String)localObject;
  }
  
  public String getIdToken()
  {
    return mRawIdToken;
  }
  
  public String getTenantId()
  {
    return mHomeTenantId;
  }
  
  public String getUsername()
  {
    if (getClaims() != null)
    {
      String str = (String)getClaims().get("preferred_username");
      if (str != null) {
        return str;
      }
      str = (String)getClaims().get("upn");
      if (str != null) {
        return str;
      }
    }
    return "Missing from the token response";
  }
  
  public void setEnvironment(String paramString)
  {
    mEnvironment = paramString;
  }
  
  public void setId(String paramString)
  {
    mHomeOid = paramString;
  }
  
  public void setTenantId(String paramString)
  {
    mHomeTenantId = paramString;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.Account
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */