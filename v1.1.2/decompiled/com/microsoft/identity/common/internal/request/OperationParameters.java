package com.microsoft.identity.common.internal.request;

import android.content.Context;
import com.microsoft.identity.common.exception.ArgumentException;
import com.microsoft.identity.common.internal.authorities.Authority;
import com.microsoft.identity.common.internal.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.internal.dto.IAccountRecord;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2TokenCache;
import com.microsoft.identity.common.internal.ui.browser.BrowserDescriptor;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class OperationParameters
{
  public static final String TAG = "OperationParameters";
  @e.c.c.v.a
  public String clientId;
  public IAccountRecord mAccount;
  public transient Context mAppContext;
  @e.c.c.v.a
  public String mApplicationName;
  @e.c.c.v.a
  public String mApplicationVersion;
  @e.c.c.v.a
  public AbstractAuthenticationScheme mAuthenticationScheme;
  @e.c.c.v.a
  public Authority mAuthority;
  public transient List<BrowserDescriptor> mBrowserSafeList;
  @e.c.c.v.a
  public String mClaimsRequestJson;
  @e.c.c.v.a
  public String mCorrelationId;
  @e.c.c.v.a
  public boolean mForceRefresh;
  public transient boolean mIsSharedDevice;
  @e.c.c.v.a
  public String mRequiredBrokerProtocolVersion;
  @e.c.c.v.a
  public Set<String> mScopes;
  @e.c.c.v.a
  public SdkType mSdkType = SdkType.MSAL;
  @e.c.c.v.a
  public String mSdkVersion;
  public transient OAuth2TokenCache mTokenCache;
  @e.c.c.v.a
  public String redirectUri;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (OperationParameters)paramObject;
      if (mForceRefresh != mForceRefresh) {
        return false;
      }
      Object localObject = mScopes;
      if (localObject != null ? !((Set)localObject).equals(mScopes) : mScopes != null) {
        return false;
      }
      localObject = mAccount;
      if (localObject != null ? !localObject.equals(mAccount) : mAccount != null) {
        return false;
      }
      if (!clientId.equals(clientId)) {
        return false;
      }
      localObject = redirectUri;
      if (localObject != null ? !((String)localObject).equals(redirectUri) : redirectUri != null) {
        return false;
      }
      localObject = mAuthority;
      if (localObject != null ? !((Authority)localObject).equals(mAuthority) : mAuthority != null) {
        return false;
      }
      localObject = mClaimsRequestJson;
      if (localObject != null ? !((String)localObject).equals(mClaimsRequestJson) : mClaimsRequestJson != null) {
        return false;
      }
      localObject = mAuthenticationScheme;
      paramObject = mAuthenticationScheme;
      if (localObject != null) {
        bool = localObject.equals(paramObject);
      } else if (paramObject != null) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public IAccountRecord getAccount()
  {
    return mAccount;
  }
  
  public Context getAppContext()
  {
    return mAppContext;
  }
  
  public String getApplicationName()
  {
    return mApplicationName;
  }
  
  public String getApplicationVersion()
  {
    return mApplicationVersion;
  }
  
  public AbstractAuthenticationScheme getAuthenticationScheme()
  {
    return mAuthenticationScheme;
  }
  
  public Authority getAuthority()
  {
    return mAuthority;
  }
  
  public List<BrowserDescriptor> getBrowserSafeList()
  {
    return mBrowserSafeList;
  }
  
  public String getClaimsRequestJson()
  {
    return mClaimsRequestJson;
  }
  
  public String getClientId()
  {
    return clientId;
  }
  
  public String getCorrelationId()
  {
    return mCorrelationId;
  }
  
  public boolean getForceRefresh()
  {
    return mForceRefresh;
  }
  
  public boolean getIsSharedDevice()
  {
    return mIsSharedDevice;
  }
  
  public String getRedirectUri()
  {
    return redirectUri;
  }
  
  public String getRequiredBrokerProtocolVersion()
  {
    return mRequiredBrokerProtocolVersion;
  }
  
  public Set<String> getScopes()
  {
    return mScopes;
  }
  
  public SdkType getSdkType()
  {
    return mSdkType;
  }
  
  public String getSdkVersion()
  {
    return mSdkVersion;
  }
  
  public OAuth2TokenCache getTokenCache()
  {
    return mTokenCache;
  }
  
  public int hashCode()
  {
    Object localObject = mScopes;
    int i = 0;
    int j;
    if (localObject != null) {
      j = ((Set)localObject).hashCode();
    } else {
      j = 0;
    }
    localObject = mAccount;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    int m = clientId.hashCode();
    localObject = redirectUri;
    int n;
    if (localObject != null) {
      n = ((String)localObject).hashCode();
    } else {
      n = 0;
    }
    localObject = mAuthority;
    int i1;
    if (localObject != null) {
      i1 = ((Authority)localObject).hashCode();
    } else {
      i1 = 0;
    }
    localObject = mClaimsRequestJson;
    int i2;
    if (localObject != null) {
      i2 = ((String)localObject).hashCode();
    } else {
      i2 = 0;
    }
    int i3 = mForceRefresh;
    localObject = mAuthenticationScheme;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return (((((m + (j * 31 + k) * 31) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i;
  }
  
  public void setAccount(IAccountRecord paramIAccountRecord)
  {
    mAccount = paramIAccountRecord;
  }
  
  public void setAppContext(Context paramContext)
  {
    mAppContext = paramContext;
  }
  
  public void setApplicationName(String paramString)
  {
    mApplicationName = paramString;
  }
  
  public void setApplicationVersion(String paramString)
  {
    mApplicationVersion = paramString;
  }
  
  public void setAuthenticationScheme(AbstractAuthenticationScheme paramAbstractAuthenticationScheme)
  {
    mAuthenticationScheme = paramAbstractAuthenticationScheme;
  }
  
  public void setAuthority(Authority paramAuthority)
  {
    mAuthority = paramAuthority;
  }
  
  public void setBrowserSafeList(List<BrowserDescriptor> paramList)
  {
    mBrowserSafeList = paramList;
  }
  
  public void setClaimsRequest(String paramString)
  {
    mClaimsRequestJson = paramString;
  }
  
  public void setClientId(String paramString)
  {
    clientId = paramString;
  }
  
  public void setCorrelationId(String paramString)
  {
    mCorrelationId = paramString;
  }
  
  public void setForceRefresh(boolean paramBoolean)
  {
    mForceRefresh = paramBoolean;
  }
  
  public void setIsSharedDevice(boolean paramBoolean)
  {
    mIsSharedDevice = paramBoolean;
  }
  
  public void setRedirectUri(String paramString)
  {
    redirectUri = paramString;
  }
  
  public void setRequiredBrokerProtocolVersion(String paramString)
  {
    mRequiredBrokerProtocolVersion = paramString;
  }
  
  public void setScopes(Set<String> paramSet)
  {
    mScopes = paramSet;
  }
  
  public void setSdkType(SdkType paramSdkType)
  {
    mSdkType = paramSdkType;
  }
  
  public void setSdkVersion(String paramString)
  {
    mSdkVersion = paramString;
  }
  
  public void setTokenCache(OAuth2TokenCache paramOAuth2TokenCache)
  {
    mTokenCache = paramOAuth2TokenCache;
  }
  
  public void validate()
  {
    e.a.a.a.a.b(new StringBuilder(), TAG, ":validate", "Validating operation params...");
    Set localSet = mScopes;
    if (localSet != null)
    {
      localSet.removeAll(Arrays.asList(new String[] { "", null }));
      if (mScopes.size() > 0)
      {
        i = 1;
        break label68;
      }
    }
    int i = 0;
    label68:
    if (i == 0) {
      if (!(this instanceof AcquireTokenSilentOperationParameters))
      {
        if ((this instanceof AcquireTokenOperationParameters)) {
          throw new ArgumentException("acquireToken", "scopes", "scope is empty or null");
        }
      }
      else {
        throw new ArgumentException("acquireTokenSilent", "scopes", "scope is empty or null");
      }
    }
    if (mAuthenticationScheme == null) {
      if (!(this instanceof AcquireTokenSilentOperationParameters))
      {
        if ((this instanceof AcquireTokenOperationParameters)) {
          throw new ArgumentException("acquireToken", "authentication_scheme", "authentication scheme is undefined");
        }
      }
      else {
        throw new ArgumentException("acquireTokenSilent", "authentication_scheme", "authentication scheme is undefined");
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.request.OperationParameters
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */