package com.microsoft.identity.common.adal.internal;

import android.net.Uri;
import com.microsoft.identity.common.adal.internal.util.DateExtensions;
import com.microsoft.identity.common.internal.cache.SchemaUtil;
import com.microsoft.identity.common.internal.dto.IAccountRecord;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAccount;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectoryAccount;
import com.microsoft.identity.common.internal.result.ILocalAuthenticationResult;
import e.a.a.a.a;
import java.util.Date;

public class ADALUserInfo
{
  public String mDisplayableId;
  public String mFamilyName;
  public String mGivenName;
  public String mIdentityProvider;
  public transient Uri mPasswordChangeUrl;
  public transient Date mPasswordExpiresOn;
  public String mUniqueId;
  
  public ADALUserInfo(AzureActiveDirectoryAccount paramAzureActiveDirectoryAccount)
  {
    mUniqueId = paramAzureActiveDirectoryAccount.getUserId();
    mDisplayableId = paramAzureActiveDirectoryAccount.getDisplayableId();
    mGivenName = paramAzureActiveDirectoryAccount.getFirstName();
    mFamilyName = paramAzureActiveDirectoryAccount.getFamilyName();
    mIdentityProvider = paramAzureActiveDirectoryAccount.getIdentityProvider();
    mPasswordChangeUrl = paramAzureActiveDirectoryAccount.getPasswordChangeUrl();
    mPasswordExpiresOn = paramAzureActiveDirectoryAccount.getPasswordExpiresOn();
  }
  
  public ADALUserInfo(ILocalAuthenticationResult paramILocalAuthenticationResult)
  {
    mUniqueId = paramILocalAuthenticationResult.getUniqueId();
    mDisplayableId = paramILocalAuthenticationResult.getAccountRecord().getUsername();
    mGivenName = paramILocalAuthenticationResult.getAccountRecord().getFirstName();
    mFamilyName = paramILocalAuthenticationResult.getAccountRecord().getFamilyName();
    mIdentityProvider = SchemaUtil.getIdentityProvider(paramILocalAuthenticationResult.getIdToken());
  }
  
  public ADALUserInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    mUniqueId = paramString1;
    mGivenName = paramString2;
    mFamilyName = paramString3;
    mIdentityProvider = paramString4;
    mDisplayableId = paramString5;
  }
  
  public String getDisplayableId()
  {
    return mDisplayableId;
  }
  
  public String getFamilyName()
  {
    return mFamilyName;
  }
  
  public String getGivenName()
  {
    return mGivenName;
  }
  
  public String getIdentityProvider()
  {
    return mIdentityProvider;
  }
  
  public Uri getPasswordChangeUrl()
  {
    return mPasswordChangeUrl;
  }
  
  public Date getPasswordExpiresOn()
  {
    return DateExtensions.createCopy(mPasswordExpiresOn);
  }
  
  public String getUserId()
  {
    return mUniqueId;
  }
  
  public void setDisplayableId(String paramString)
  {
    mDisplayableId = paramString;
  }
  
  public void setUserId(String paramString)
  {
    mUniqueId = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = a.a("ADALUserInfo{mUniqueId='");
    a.a(localStringBuilder, mUniqueId, '\'', ", mDisplayableId='");
    a.a(localStringBuilder, mDisplayableId, '\'', ", mGivenName='");
    a.a(localStringBuilder, mGivenName, '\'', ", mFamilyName='");
    a.a(localStringBuilder, mFamilyName, '\'', ", mIdentityProvider='");
    a.a(localStringBuilder, mIdentityProvider, '\'', ", mPasswordChangeUrl=");
    localStringBuilder.append(mPasswordChangeUrl);
    localStringBuilder.append(", mPasswordExpiresOn=");
    localStringBuilder.append(mPasswordExpiresOn);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.adal.internal.ADALUserInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */