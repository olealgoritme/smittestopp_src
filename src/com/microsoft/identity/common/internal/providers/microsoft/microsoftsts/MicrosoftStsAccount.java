package com.microsoft.identity.common.internal.providers.microsoft.microsoftsts;

import com.microsoft.identity.common.internal.cache.SchemaUtil;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAccount;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.ClientInfo;
import com.microsoft.identity.common.internal.providers.oauth2.IDToken;
import e.a.a.a.a;
import java.util.Map;

public class MicrosoftStsAccount
  extends MicrosoftAccount
{
  public static final String TAG = "MicrosoftStsAccount";
  
  public MicrosoftStsAccount()
  {
    String str = TAG;
    StringBuilder localStringBuilder = a.a("Init: ");
    localStringBuilder.append(TAG);
    Logger.verbose(str, localStringBuilder.toString());
  }
  
  public MicrosoftStsAccount(IDToken paramIDToken, ClientInfo paramClientInfo)
  {
    super(paramIDToken, paramClientInfo);
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
    return SchemaUtil.getDisplayableId(paramMap);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.microsoft.microsoftsts.MicrosoftStsAccount
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */