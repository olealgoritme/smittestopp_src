package com.microsoft.identity.common.internal.cache;

import com.microsoft.identity.common.adal.internal.ADALUserInfo;
import com.microsoft.identity.common.internal.dto.IRefreshTokenRecord;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAccount;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectoryAccessToken;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectoryAccount;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectoryAuthorizationRequest;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectoryOAuth2Strategy;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectoryTokenResponse;
import com.microsoft.identity.common.internal.providers.oauth2.AccessToken;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.internal.providers.oauth2.RefreshToken;
import com.microsoft.identity.common.internal.providers.oauth2.TokenResponse;
import com.microsoft.identity.common.internal.util.DateUtilities;
import java.util.Date;

public class ADALTokenCacheItem
  implements ITokenCacheItem
{
  public String mAccessToken;
  public String mAuthority;
  public String mClientId;
  public Date mExpiresOn;
  public Date mExtendedExpiresOn;
  public String mFamilyClientId;
  public boolean mIsMultiResourceRefreshToken;
  public String mRawIdToken;
  public String mRefreshtoken;
  public String mResource;
  public String mSpeRing;
  public String mTenantId;
  public ADALUserInfo mUserInfo;
  
  public ADALTokenCacheItem() {}
  
  public ADALTokenCacheItem(ADALTokenCacheItem paramADALTokenCacheItem)
  {
    mAuthority = paramADALTokenCacheItem.getAuthority();
    mResource = paramADALTokenCacheItem.getResource();
    mClientId = paramADALTokenCacheItem.getClientId();
    mAccessToken = paramADALTokenCacheItem.getAccessToken();
    mRefreshtoken = paramADALTokenCacheItem.getRefreshToken();
    mRawIdToken = paramADALTokenCacheItem.getRawIdToken();
    mUserInfo = paramADALTokenCacheItem.getUserInfo();
    mExpiresOn = paramADALTokenCacheItem.getExpiresOn();
    mIsMultiResourceRefreshToken = paramADALTokenCacheItem.getIsMultiResourceRefreshToken();
    mTenantId = paramADALTokenCacheItem.getTenantId();
    mFamilyClientId = paramADALTokenCacheItem.getFamilyClientId();
    mExtendedExpiresOn = paramADALTokenCacheItem.getExtendedExpiresOn();
    mSpeRing = paramADALTokenCacheItem.getSpeRing();
  }
  
  public ADALTokenCacheItem(AzureActiveDirectoryOAuth2Strategy paramAzureActiveDirectoryOAuth2Strategy, AzureActiveDirectoryAuthorizationRequest paramAzureActiveDirectoryAuthorizationRequest, AzureActiveDirectoryTokenResponse paramAzureActiveDirectoryTokenResponse)
  {
    String str = paramAzureActiveDirectoryOAuth2Strategy.getIssuerCacheIdentifier(paramAzureActiveDirectoryAuthorizationRequest);
    AzureActiveDirectoryAccount localAzureActiveDirectoryAccount = paramAzureActiveDirectoryOAuth2Strategy.createAccount(paramAzureActiveDirectoryTokenResponse);
    localAzureActiveDirectoryAccount.setEnvironment(str);
    AzureActiveDirectoryAccessToken localAzureActiveDirectoryAccessToken = paramAzureActiveDirectoryOAuth2Strategy.getAccessTokenFromResponse(paramAzureActiveDirectoryTokenResponse);
    paramAzureActiveDirectoryOAuth2Strategy = paramAzureActiveDirectoryOAuth2Strategy.getRefreshTokenFromResponse(paramAzureActiveDirectoryTokenResponse);
    mAuthority = str;
    mResource = paramAzureActiveDirectoryAuthorizationRequest.getScope();
    mClientId = paramAzureActiveDirectoryAuthorizationRequest.getClientId();
    mAccessToken = localAzureActiveDirectoryAccessToken.getAccessToken();
    mRefreshtoken = paramAzureActiveDirectoryOAuth2Strategy.getRefreshToken();
    mRawIdToken = paramAzureActiveDirectoryTokenResponse.getIdToken();
    mUserInfo = new ADALUserInfo(localAzureActiveDirectoryAccount);
    mTenantId = localAzureActiveDirectoryAccount.getRealm();
    mExpiresOn = localAzureActiveDirectoryAccessToken.getExpiresOn();
    mExtendedExpiresOn = localAzureActiveDirectoryAccessToken.getExtendedExpiresOn();
    mIsMultiResourceRefreshToken = true;
    mFamilyClientId = paramAzureActiveDirectoryOAuth2Strategy.getFamilyId();
    mSpeRing = paramAzureActiveDirectoryTokenResponse.getSpeRing();
  }
  
  public static ADALTokenCacheItem getAsFRTTokenCacheItem(ADALTokenCacheItem paramADALTokenCacheItem)
  {
    paramADALTokenCacheItem = new ADALTokenCacheItem(paramADALTokenCacheItem);
    paramADALTokenCacheItem.setResource(null);
    paramADALTokenCacheItem.setAccessToken(null);
    paramADALTokenCacheItem.setClientId(null);
    return paramADALTokenCacheItem;
  }
  
  public static ADALTokenCacheItem getAsMRRTTokenCacheItem(ADALTokenCacheItem paramADALTokenCacheItem)
  {
    paramADALTokenCacheItem = new ADALTokenCacheItem(paramADALTokenCacheItem);
    paramADALTokenCacheItem.setResource(null);
    paramADALTokenCacheItem.setAccessToken(null);
    return paramADALTokenCacheItem;
  }
  
  public String getAccessToken()
  {
    return mAccessToken;
  }
  
  public String getAuthority()
  {
    return mAuthority;
  }
  
  public String getClientId()
  {
    return mClientId;
  }
  
  public Date getExpiresOn()
  {
    return DateUtilities.createCopy(mExpiresOn);
  }
  
  public final Date getExtendedExpiresOn()
  {
    return DateUtilities.createCopy(mExtendedExpiresOn);
  }
  
  public final String getFamilyClientId()
  {
    return mFamilyClientId;
  }
  
  public boolean getIsMultiResourceRefreshToken()
  {
    return mIsMultiResourceRefreshToken;
  }
  
  public String getRawIdToken()
  {
    return mRawIdToken;
  }
  
  public String getRefreshToken()
  {
    return mRefreshtoken;
  }
  
  public String getResource()
  {
    return mResource;
  }
  
  public String getSpeRing()
  {
    return mSpeRing;
  }
  
  public String getTenantId()
  {
    return mTenantId;
  }
  
  public ADALUserInfo getUserInfo()
  {
    return mUserInfo;
  }
  
  public void setAccessToken(String paramString)
  {
    mAccessToken = paramString;
  }
  
  public void setAuthority(String paramString)
  {
    mAuthority = paramString;
  }
  
  public void setClientId(String paramString)
  {
    mClientId = paramString;
  }
  
  public void setExpiresOn(Date paramDate)
  {
    mExpiresOn = DateUtilities.createCopy(paramDate);
  }
  
  public final void setExtendedExpiresOn(Date paramDate)
  {
    mExtendedExpiresOn = DateUtilities.createCopy(paramDate);
  }
  
  public final void setFamilyClientId(String paramString)
  {
    mFamilyClientId = paramString;
  }
  
  public void setIsMultiResourceRefreshToken(boolean paramBoolean)
  {
    mIsMultiResourceRefreshToken = paramBoolean;
  }
  
  public void setRawIdToken(String paramString)
  {
    mRawIdToken = paramString;
  }
  
  public void setRefreshToken(String paramString)
  {
    mRefreshtoken = paramString;
  }
  
  public void setResource(String paramString)
  {
    mResource = paramString;
  }
  
  public void setSpeRing(String paramString)
  {
    mSpeRing = paramString;
  }
  
  public void setTenantId(String paramString)
  {
    mTenantId = paramString;
  }
  
  public void setUserInfo(ADALUserInfo paramADALUserInfo)
  {
    mUserInfo = paramADALUserInfo;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.cache.ADALTokenCacheItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */