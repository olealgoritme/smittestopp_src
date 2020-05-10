package com.microsoft.identity.common.internal.providers.microsoft;

import android.text.TextUtils;
import com.microsoft.identity.common.exception.ServiceException;
import com.microsoft.identity.common.internal.cache.SchemaUtil;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.ClientInfo;
import com.microsoft.identity.common.internal.providers.oauth2.RefreshToken;
import com.microsoft.identity.common.internal.providers.oauth2.TokenResponse;

public class MicrosoftRefreshToken
  extends RefreshToken
{
  public String mClientId;
  public ClientInfo mClientInfo;
  public String mEnvironment;
  public String mFamilyId;
  public String mScope;
  
  public MicrosoftRefreshToken(MicrosoftTokenResponse paramMicrosoftTokenResponse)
  {
    super(paramMicrosoftTokenResponse);
    try
    {
      ClientInfo localClientInfo = new com/microsoft/identity/common/internal/providers/microsoft/azureactivedirectory/ClientInfo;
      localClientInfo.<init>(paramMicrosoftTokenResponse.getClientInfo());
      mClientInfo = localClientInfo;
      mFamilyId = paramMicrosoftTokenResponse.getFamilyId();
      mScope = paramMicrosoftTokenResponse.getScope();
      mClientId = paramMicrosoftTokenResponse.getClientId();
      return;
    }
    catch (ServiceException paramMicrosoftTokenResponse)
    {
      throw new RuntimeException(paramMicrosoftTokenResponse);
    }
  }
  
  public MicrosoftRefreshToken(String paramString1, ClientInfo paramClientInfo, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    super(paramString1);
    mClientInfo = paramClientInfo;
    mScope = paramString2;
    mClientId = paramString3;
    mEnvironment = paramString4;
    mFamilyId = paramString5;
  }
  
  public String getClientId()
  {
    return mClientId;
  }
  
  public ClientInfo getClientInfo()
  {
    return mClientInfo;
  }
  
  public String getEnvironment()
  {
    return mEnvironment;
  }
  
  public String getFamilyId()
  {
    return mFamilyId;
  }
  
  public String getHomeAccountId()
  {
    return SchemaUtil.getHomeAccountId(mClientInfo);
  }
  
  public boolean getIsFamilyRefreshToken()
  {
    return TextUtils.isEmpty(mFamilyId) ^ true;
  }
  
  public String getSecret()
  {
    return getRefreshToken();
  }
  
  public String getTarget()
  {
    return mScope;
  }
  
  public void setEnvironment(String paramString)
  {
    mEnvironment = paramString;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.microsoft.MicrosoftRefreshToken
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */