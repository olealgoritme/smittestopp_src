package com.microsoft.identity.common.internal.authorities;

import android.net.Uri;
import com.microsoft.identity.common.exception.ClientException;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectory;
import com.microsoft.identity.common.internal.providers.oauth2.OpenIdProviderConfiguration;
import com.microsoft.identity.common.internal.providers.oauth2.OpenIdProviderConfigurationClient;
import com.microsoft.identity.common.internal.util.StringUtil;
import e.c.c.v.c;
import java.util.List;

public abstract class AzureActiveDirectoryAudience
{
  public static final String ALL = "common";
  public static final String CONSUMERS = "consumers";
  public static final String MSA_MEGA_TENANT_ID = "9188040d-6c67-4c5b-b112-36a304b66dad";
  public static final String ORGANIZATIONS = "organizations";
  public static final String TAG = "AzureActiveDirectoryAudience";
  public String mCloudUrl;
  @c("tenant_id")
  public String mTenantId;
  
  public static AzureActiveDirectoryAudience getAzureActiveDirectoryAudience(String paramString1, String paramString2)
  {
    Object localObject = paramString2.toLowerCase();
    int i = ((String)localObject).hashCode();
    if (i != -2108114528)
    {
      if (i != -1354814997)
      {
        if ((i == -421004483) && (((String)localObject).equals("consumers")))
        {
          i = 1;
          break label75;
        }
      }
      else if (((String)localObject).equals("common"))
      {
        i = 2;
        break label75;
      }
    }
    else if (((String)localObject).equals("organizations"))
    {
      i = 0;
      break label75;
    }
    i = -1;
    label75:
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(TAG);
          ((StringBuilder)localObject).append(":getAzureActiveDirectoryAudience");
          Logger.verbose(((StringBuilder)localObject).toString(), "Audience: AccountsInOneOrganization");
          paramString1 = new AccountsInOneOrganization(paramString1, paramString2);
        }
        else
        {
          paramString2 = new StringBuilder();
          paramString2.append(TAG);
          paramString2.append(":getAzureActiveDirectoryAudience");
          Logger.verbose(paramString2.toString(), "Audience: AllAccounts");
          paramString1 = new AllAccounts(paramString1);
        }
      }
      else
      {
        paramString2 = new StringBuilder();
        paramString2.append(TAG);
        paramString2.append(":getAzureActiveDirectoryAudience");
        Logger.verbose(paramString2.toString(), "Audience: AnyPersonalAccount");
        paramString1 = new AnyPersonalAccount(paramString1);
      }
    }
    else
    {
      paramString2 = new StringBuilder();
      paramString2.append(TAG);
      paramString2.append(":getAzureActiveDirectoryAudience");
      Logger.verbose(paramString2.toString(), "Audience: AnyOrganizationalAccount");
      paramString1 = new AnyOrganizationalAccount(paramString1);
    }
    return paramString1;
  }
  
  public static boolean isHomeTenantAlias(String paramString)
  {
    boolean bool;
    if ((!paramString.equalsIgnoreCase("common")) && (!paramString.equalsIgnoreCase("consumers")) && (!paramString.equalsIgnoreCase("organizations"))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static OpenIdProviderConfiguration loadOpenIdProviderConfigurationMetadata(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(TAG);
    localStringBuilder.append(":loadOpenIdProviderConfigurationMetadata");
    Logger.info(localStringBuilder.toString(), "Loading OpenId Provider Metadata...");
    return new OpenIdProviderConfigurationClient(paramString).loadOpenIdProviderConfiguration();
  }
  
  public String getCloudUrl()
  {
    String str1 = mCloudUrl;
    String str2 = str1;
    if (str1 == null) {
      str2 = AzureActiveDirectory.getDefaultCloudUrl();
    }
    return str2;
  }
  
  public String getTenantId()
  {
    return mTenantId;
  }
  
  public String getTenantUuidForAlias(String paramString)
  {
    if (StringUtil.isUuid(mTenantId)) {
      return mTenantId;
    }
    paramString = Uri.parse(loadOpenIdProviderConfigurationMetadata(paramString).getIssuer()).getPathSegments();
    if (!paramString.isEmpty())
    {
      paramString = (String)paramString.get(0);
      if (StringUtil.isUuid(paramString)) {
        return paramString;
      }
      Logger.error(TAG, "OpenId Metadata did not contain UUID in the path ", null);
      throw new ClientException("OpenId Metadata did not contain UUID in the path ");
    }
    Logger.error(TAG, "OpenId Metadata did not contain a path to the tenant", null);
    throw new ClientException("OpenId Metadata did not contain a path to the tenant");
  }
  
  public void setCloudUrl(String paramString)
  {
    mCloudUrl = paramString;
  }
  
  public void setTenantId(String paramString)
  {
    mTenantId = paramString;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.authorities.AzureActiveDirectoryAudience
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */