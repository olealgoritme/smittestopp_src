package com.microsoft.identity.common.internal.request;

import android.accounts.Account;
import android.text.TextUtils;
import android.util.Pair;
import com.microsoft.identity.common.exception.ArgumentException;
import com.microsoft.identity.common.internal.authscheme.BearerAuthenticationSchemeInternal;
import com.microsoft.identity.common.internal.broker.BrokerValidator;
import com.microsoft.identity.common.internal.cache.BrokerOAuth2TokenCache;
import java.util.List;
import java.util.Set;

public class BrokerAcquireTokenSilentOperationParameters
  extends AcquireTokenSilentOperationParameters
{
  public Account mAccountManagerAccount;
  public String mBrokerVersion;
  public String mCallerAppVersion;
  public String mCallerPackageName;
  public int mCallerUId;
  public List<Pair<String, String>> mExtraQueryStringParameters;
  public String mHomeAccountId;
  public String mLocalAccountId;
  public String mLoginHint;
  public int mSleepTimeBeforePrtAcquisition;
  
  public BrokerAcquireTokenSilentOperationParameters() {}
  
  public BrokerAcquireTokenSilentOperationParameters(BrokerAcquireTokenOperationParameters paramBrokerAcquireTokenOperationParameters)
  {
    setAppContext(paramBrokerAcquireTokenOperationParameters.getAppContext());
    setTokenCache(paramBrokerAcquireTokenOperationParameters.getTokenCache());
    setScopes(paramBrokerAcquireTokenOperationParameters.getScopes());
    setClientId(paramBrokerAcquireTokenOperationParameters.getClientId());
    setRedirectUri(paramBrokerAcquireTokenOperationParameters.getRedirectUri());
    setAuthority(paramBrokerAcquireTokenOperationParameters.getAuthority());
    setClaimsRequest(paramBrokerAcquireTokenOperationParameters.getClaimsRequestJson());
    setCallerAppVersion(paramBrokerAcquireTokenOperationParameters.getCallerAppVersion());
    setCallerPackageName(paramBrokerAcquireTokenOperationParameters.getCallerPackageName());
    setCallerUId(paramBrokerAcquireTokenOperationParameters.getCallerUId());
    setCorrelationId(paramBrokerAcquireTokenOperationParameters.getCorrelationId());
    setLoginHint(paramBrokerAcquireTokenOperationParameters.getLoginHint());
    setSdkType(paramBrokerAcquireTokenOperationParameters.getSdkType());
    setExtraQueryStringParameters(paramBrokerAcquireTokenOperationParameters.getExtraQueryStringParameters());
    if (paramBrokerAcquireTokenOperationParameters.getAuthenticationScheme() != null) {
      paramBrokerAcquireTokenOperationParameters = paramBrokerAcquireTokenOperationParameters.getAuthenticationScheme();
    } else {
      paramBrokerAcquireTokenOperationParameters = new BearerAuthenticationSchemeInternal();
    }
    setAuthenticationScheme(paramBrokerAcquireTokenOperationParameters);
  }
  
  public Account getAccountManagerAccount()
  {
    return mAccountManagerAccount;
  }
  
  public String getBrokerVersion()
  {
    return mBrokerVersion;
  }
  
  public String getCallerAppVersion()
  {
    return mCallerAppVersion;
  }
  
  public String getCallerPackageName()
  {
    return mCallerPackageName;
  }
  
  public int getCallerUId()
  {
    return mCallerUId;
  }
  
  public List<Pair<String, String>> getExtraQueryStringParameters()
  {
    return mExtraQueryStringParameters;
  }
  
  public String getHomeAccountId()
  {
    return mHomeAccountId;
  }
  
  public String getLocalAccountId()
  {
    return mLocalAccountId;
  }
  
  public String getLoginHint()
  {
    return mLoginHint;
  }
  
  public int getSleepTimeBeforePrtAcquisition()
  {
    return mSleepTimeBeforePrtAcquisition;
  }
  
  public void setAccountManagerAccount(Account paramAccount)
  {
    mAccountManagerAccount = paramAccount;
  }
  
  public void setBrokerVersion(String paramString)
  {
    mBrokerVersion = paramString;
  }
  
  public void setCallerAppVersion(String paramString)
  {
    mCallerAppVersion = paramString;
  }
  
  public void setCallerPackageName(String paramString)
  {
    mCallerPackageName = paramString;
  }
  
  public void setCallerUId(int paramInt)
  {
    mCallerUId = paramInt;
  }
  
  public void setExtraQueryStringParameters(List<Pair<String, String>> paramList)
  {
    mExtraQueryStringParameters = paramList;
  }
  
  public void setHomeAccountId(String paramString)
  {
    mHomeAccountId = paramString;
  }
  
  public void setLocalAccountId(String paramString)
  {
    mLocalAccountId = paramString;
  }
  
  public void setLoginHint(String paramString)
  {
    mLoginHint = paramString;
  }
  
  public void setSleepTimeBeforePrtAcquisition(int paramInt)
  {
    mSleepTimeBeforePrtAcquisition = paramInt;
  }
  
  public void validate()
  {
    if (mCallerUId != 0)
    {
      if (!TextUtils.isEmpty(mCallerPackageName))
      {
        if (getAuthority() != null)
        {
          if ((getScopes() != null) && (!getScopes().isEmpty()))
          {
            if (!TextUtils.isEmpty(getClientId()))
            {
              if (!TextUtils.isEmpty(mCallerPackageName))
              {
                if ((SdkType.MSAL == getSdkType()) && (!BrokerValidator.isValidBrokerRedirect(getRedirectUri(), getAppContext(), getCallerPackageName()))) {
                  throw new ArgumentException("acquireTokenSilent", "mRedirectUri", "The redirect URI doesn't match the uri generated with caller package name and signature");
                }
                if ((getTokenCache() instanceof BrokerOAuth2TokenCache))
                {
                  if (mAccountManagerAccount != null) {
                    return;
                  }
                  throw new ArgumentException("acquireTokenSilent", "mCallerPackageName", "Android Account manager Account is null");
                }
                throw new ArgumentException("acquireTokenSilent", "AcquireTokenSilentOperationParameters", "OAuth2Cache not an instance of BrokerOAuth2TokenCache");
              }
              throw new ArgumentException("acquireTokenSilent", "mCallerPackageName", "Caller package name is not set");
            }
            throw new ArgumentException("acquireTokenSilent", "mClientId", "Client Id is not set");
          }
          throw new ArgumentException("acquireTokenSilent", "mScopes", "Scope or resource is not set");
        }
        throw new ArgumentException("acquireTokenSilent", "mAuthority", "Authority Url is not set");
      }
      throw new ArgumentException("acquireTokenSilent", "mCallerPackageName", "Caller package name is not set");
    }
    throw new ArgumentException("acquireTokenSilent", "mCallerUId", "Caller Uid is not set");
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.request.BrokerAcquireTokenSilentOperationParameters
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */