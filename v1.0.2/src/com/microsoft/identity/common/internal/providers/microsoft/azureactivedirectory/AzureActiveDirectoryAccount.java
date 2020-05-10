package com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory;

import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAccount;
import com.microsoft.identity.common.internal.providers.oauth2.IDToken;
import e.a.a.a.a;
import java.util.Map;

public class AzureActiveDirectoryAccount
  extends MicrosoftAccount
{
  public static final String TAG = "AzureActiveDirectoryAccount";
  public String mIdentityProvider;
  
  public AzureActiveDirectoryAccount() {}
  
  public AzureActiveDirectoryAccount(IDToken paramIDToken, ClientInfo paramClientInfo)
  {
    super(paramIDToken, paramClientInfo);
    mIdentityProvider = ((String)paramIDToken.getTokenClaims().get("idp"));
    paramIDToken = TAG;
    paramClientInfo = a.a("Init: ");
    paramClientInfo.append(TAG);
    Logger.verbose(paramIDToken, paramClientInfo.toString());
  }
  
  public String getAuthorityType()
  {
    return "MSSTS";
  }
  
  public String getDisplayableId(Map<String, ?> paramMap)
  {
    StringBuilder localStringBuilder;
    if (!StringExtensions.isNullOrBlank((String)paramMap.get("upn")))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(TAG);
      localStringBuilder.append(":");
      localStringBuilder.append("getDisplayableId");
      Logger.info(localStringBuilder.toString(), "Returning upn as displayableId");
      paramMap = (String)paramMap.get("upn");
    }
    else if (!StringExtensions.isNullOrBlank((String)paramMap.get("email")))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(TAG);
      localStringBuilder.append(":");
      localStringBuilder.append("getDisplayableId");
      Logger.info(localStringBuilder.toString(), "Returning email as displayableId");
      paramMap = (String)paramMap.get("email");
    }
    else
    {
      paramMap = null;
    }
    return paramMap;
  }
  
  public String getIdentityProvider()
  {
    return mIdentityProvider;
  }
  
  public void setIdentityProvider(String paramString)
  {
    mIdentityProvider = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = a.a("AzureActiveDirectoryAccount{} ");
    localStringBuilder.append(super.toString());
    localStringBuilder.append(", mIdentityProvider='");
    localStringBuilder.append(mIdentityProvider);
    localStringBuilder.append('\'');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectoryAccount
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */