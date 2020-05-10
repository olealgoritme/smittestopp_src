package com.microsoft.identity.common.internal.cache;

import android.text.TextUtils;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.exception.BaseException;
import com.microsoft.identity.common.exception.ServiceException;
import com.microsoft.identity.common.internal.dto.CredentialType;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.ClientInfo;
import com.microsoft.identity.common.internal.providers.oauth2.IDToken;
import e.a.a.a.a;
import java.util.Map;

public final class SchemaUtil
{
  public static final String EXCEPTION_CONSTRUCTING_IDTOKEN = "Exception constructing IDToken. ";
  public static final String MISSING_FROM_THE_TOKEN_RESPONSE = "Missing from the token response";
  public static final String TAG = "SchemaUtil";
  
  public static String getAlternativeAccountId(IDToken paramIDToken)
  {
    String str = null;
    if (paramIDToken != null)
    {
      paramIDToken = paramIDToken.getTokenClaims();
      if (paramIDToken != null)
      {
        str = (String)paramIDToken.get("altsecid");
        paramIDToken = a.a(new StringBuilder(), TAG, ":", "getAlternativeAccountId");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("alternative_account_id: ");
        localStringBuilder.append(str);
        Logger.verbosePII(paramIDToken, localStringBuilder.toString());
        paramIDToken = str;
        if (str == null)
        {
          paramIDToken = new StringBuilder();
          paramIDToken.append(TAG);
          paramIDToken.append(":");
          paramIDToken.append("getAlternativeAccountId");
          Logger.warn(paramIDToken.toString(), "alternative_account_id was null.");
          paramIDToken = str;
        }
      }
      else
      {
        paramIDToken = new StringBuilder();
        paramIDToken.append(TAG);
        paramIDToken.append(":");
        paramIDToken.append("getAlternativeAccountId");
        Logger.warn(paramIDToken.toString(), "IDToken claims were null.");
        paramIDToken = str;
      }
    }
    else
    {
      paramIDToken = new StringBuilder();
      paramIDToken.append(TAG);
      paramIDToken.append(":");
      paramIDToken.append("getAlternativeAccountId");
      Logger.warn(paramIDToken.toString(), "IDToken was null.");
      paramIDToken = str;
    }
    return paramIDToken;
  }
  
  public static String getAuthority(IDToken paramIDToken)
  {
    String str = null;
    if (paramIDToken != null)
    {
      paramIDToken = paramIDToken.getTokenClaims();
      if (paramIDToken != null)
      {
        str = (String)paramIDToken.get("iss");
        paramIDToken = a.a(new StringBuilder(), TAG, ":", "getAuthority");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Issuer: ");
        localStringBuilder.append(str);
        Logger.verbosePII(paramIDToken, localStringBuilder.toString());
        paramIDToken = str;
        if (str == null)
        {
          paramIDToken = new StringBuilder();
          paramIDToken.append(TAG);
          paramIDToken.append(":");
          paramIDToken.append("getAuthority");
          Logger.warn(paramIDToken.toString(), "Environment was null or could not be parsed.");
          paramIDToken = str;
        }
      }
      else
      {
        paramIDToken = new StringBuilder();
        paramIDToken.append(TAG);
        paramIDToken.append(":");
        paramIDToken.append("getAuthority");
        Logger.warn(paramIDToken.toString(), "IDToken claims were null");
        paramIDToken = str;
      }
    }
    else
    {
      paramIDToken = new StringBuilder();
      paramIDToken.append(TAG);
      paramIDToken.append(":");
      paramIDToken.append("getAuthority");
      Logger.warn(paramIDToken.toString(), "IDToken was null");
      paramIDToken = str;
    }
    return paramIDToken;
  }
  
  public static String getAvatarUrl(IDToken paramIDToken)
  {
    String str = null;
    if (paramIDToken != null)
    {
      paramIDToken = paramIDToken.getTokenClaims();
      if (paramIDToken != null)
      {
        str = (String)paramIDToken.get("picture");
        paramIDToken = a.a(new StringBuilder(), TAG, ":", "getAvatarUrl");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Avatar URL: ");
        localStringBuilder.append(str);
        Logger.verbosePII(paramIDToken, localStringBuilder.toString());
        paramIDToken = str;
        if (str == null)
        {
          paramIDToken = new StringBuilder();
          paramIDToken.append(TAG);
          paramIDToken.append(":");
          paramIDToken.append("getAvatarUrl");
          Logger.warn(paramIDToken.toString(), "Avatar URL was null.");
          paramIDToken = str;
        }
      }
      else
      {
        paramIDToken = new StringBuilder();
        paramIDToken.append(TAG);
        paramIDToken.append(":");
        paramIDToken.append("getAvatarUrl");
        Logger.warn(paramIDToken.toString(), "IDToken claims were null.");
        paramIDToken = str;
      }
    }
    else
    {
      paramIDToken = new StringBuilder();
      paramIDToken.append(TAG);
      paramIDToken.append(":");
      paramIDToken.append("getAvatarUrl");
      Logger.warn(paramIDToken.toString(), "IDToken was null.");
      paramIDToken = str;
    }
    return paramIDToken;
  }
  
  public static String getCredentialTypeFromVersion(String paramString)
  {
    Object localObject = CredentialType.IdToken;
    boolean bool = TextUtils.isEmpty(paramString);
    String str = "IdToken";
    localObject = str;
    if (!bool) {
      try
      {
        localObject = new com/microsoft/identity/common/internal/providers/oauth2/IDToken;
        ((IDToken)localObject).<init>(paramString);
        paramString = (String)((IDToken)localObject).getTokenClaims().get("ver");
        localObject = str;
        if (!TextUtils.isEmpty(paramString))
        {
          localObject = str;
          if (paramString.equalsIgnoreCase("1.0"))
          {
            paramString = CredentialType.V1IdToken;
            localObject = "V1IdToken";
          }
        }
      }
      catch (ServiceException paramString)
      {
        localObject = a.a(new StringBuilder(), TAG, ":", "getCredentialTypeFromVersion");
        StringBuilder localStringBuilder = a.a("Exception constructing IDToken. ");
        localStringBuilder.append(paramString.getMessage());
        Logger.warn((String)localObject, localStringBuilder.toString());
        localObject = str;
      }
    }
    return (String)localObject;
  }
  
  public static String getDisplayableId(Map<String, ?> paramMap)
  {
    if (!StringExtensions.isNullOrBlank((String)paramMap.get("preferred_username"))) {
      return (String)paramMap.get("preferred_username");
    }
    if (!StringExtensions.isNullOrBlank((String)paramMap.get("email"))) {
      return (String)paramMap.get("email");
    }
    if (!StringExtensions.isNullOrBlank((String)paramMap.get("upn"))) {
      return (String)paramMap.get("upn");
    }
    Logger.warn(TAG, "The preferred username is not returned from the IdToken.");
    return "Missing from the token response";
  }
  
  public static String getHomeAccountId(ClientInfo paramClientInfo)
  {
    Object localObject = null;
    String str1 = null;
    if (paramClientInfo != null)
    {
      localObject = paramClientInfo.getUid();
      String str2 = paramClientInfo.getUtid();
      if (StringExtensions.isNullOrBlank((String)localObject))
      {
        paramClientInfo = new StringBuilder();
        paramClientInfo.append(TAG);
        paramClientInfo.append(":");
        paramClientInfo.append(":getHomeAccountId");
        Logger.warn(paramClientInfo.toString(), "uid was null/blank");
      }
      if (StringExtensions.isNullOrBlank(str2))
      {
        paramClientInfo = new StringBuilder();
        paramClientInfo.append(TAG);
        paramClientInfo.append(":");
        paramClientInfo.append(":getHomeAccountId");
        Logger.warn(paramClientInfo.toString(), "utid was null/blank");
      }
      paramClientInfo = str1;
      if (!StringExtensions.isNullOrBlank((String)localObject))
      {
        paramClientInfo = str1;
        if (!StringExtensions.isNullOrBlank(str2)) {
          paramClientInfo = a.a((String)localObject, ".", str2);
        }
      }
      str1 = a.a(new StringBuilder(), TAG, ":", ":getHomeAccountId");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("home_account_id: ");
      ((StringBuilder)localObject).append(paramClientInfo);
      Logger.verbosePII(str1, ((StringBuilder)localObject).toString());
    }
    else
    {
      paramClientInfo = new StringBuilder();
      paramClientInfo.append(TAG);
      paramClientInfo.append(":");
      paramClientInfo.append(":getHomeAccountId");
      Logger.warn(paramClientInfo.toString(), "ClientInfo was null.");
      paramClientInfo = (ClientInfo)localObject;
    }
    return paramClientInfo;
  }
  
  public static String getIdentityProvider(String paramString)
  {
    Object localObject1 = null;
    if (paramString != null)
    {
      try
      {
        Object localObject2 = new com/microsoft/identity/common/internal/providers/oauth2/IDToken;
        ((IDToken)localObject2).<init>(paramString);
        paramString = ((IDToken)localObject2).getTokenClaims();
        if (paramString != null)
        {
          localObject1 = (String)paramString.get("idp");
          try
          {
            paramString = new java/lang/StringBuilder;
            paramString.<init>();
            paramString.append(TAG);
            paramString.append(":");
            paramString.append("getIdentityProvider");
            paramString = paramString.toString();
            localObject2 = new java/lang/StringBuilder;
            ((StringBuilder)localObject2).<init>();
            ((StringBuilder)localObject2).append("idp: ");
            ((StringBuilder)localObject2).append((String)localObject1);
            Logger.verbosePII(paramString, ((StringBuilder)localObject2).toString());
            paramString = (String)localObject1;
            if (localObject1 != null) {
              break label244;
            }
            paramString = new java/lang/StringBuilder;
            paramString.<init>();
            paramString.append(TAG);
            paramString.append(":");
            paramString.append("getIdentityProvider");
            Logger.info(paramString.toString(), "idp claim was null.");
            paramString = (String)localObject1;
          }
          catch (ServiceException localServiceException1)
          {
            paramString = (String)localObject1;
            break label203;
          }
        }
        else
        {
          paramString = new java/lang/StringBuilder;
          paramString.<init>();
          paramString.append(TAG);
          paramString.append(":");
          paramString.append("getIdentityProvider");
          Logger.warn(paramString.toString(), "IDToken claims were null.");
          paramString = (String)localObject1;
        }
      }
      catch (ServiceException localServiceException2)
      {
        paramString = null;
        label203:
        String str = a.a(new StringBuilder(), TAG, ":", "getIdentityProvider");
        localObject1 = a.a("Exception constructing IDToken. ");
        ((StringBuilder)localObject1).append(localServiceException2.getMessage());
        Logger.warn(str, ((StringBuilder)localObject1).toString());
      }
    }
    else
    {
      label244:
      paramString = new StringBuilder();
      paramString.append(TAG);
      paramString.append(":");
      paramString.append("getIdentityProvider");
      Logger.warn(paramString.toString(), "IDToken was null.");
      paramString = (String)localObject1;
    }
    return paramString;
  }
  
  public static String getTenantId(String paramString1, String paramString2)
  {
    Object localObject1 = null;
    Object localObject2 = localObject1;
    try
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(paramString1))
        {
          localObject2 = new com/microsoft/identity/common/internal/providers/oauth2/IDToken;
          ((IDToken)localObject2).<init>(paramString2);
          paramString2 = new com/microsoft/identity/common/internal/providers/microsoft/azureactivedirectory/ClientInfo;
          paramString2.<init>(paramString1);
          paramString1 = ((IDToken)localObject2).getTokenClaims();
          if (!TextUtils.isEmpty((CharSequence)paramString1.get("tid"))) {}
          for (paramString1 = (String)paramString1.get("tid");; paramString1 = paramString2.getUtid())
          {
            return paramString1;
            if (TextUtils.isEmpty(paramString2.getUtid())) {
              break;
            }
            Logger.warn(TAG, "realm is not returned from server. Use utid as realm.");
          }
          Logger.warn(TAG, "realm and utid is not returned from server. Using empty string as default tid.");
          localObject2 = localObject1;
        }
      }
    }
    catch (ServiceException paramString1)
    {
      Logger.errorPII(TAG, "Failed to construct IDToken or ClientInfo", paramString1);
      localObject2 = localObject1;
    }
    return (String)localObject2;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.cache.SchemaUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */