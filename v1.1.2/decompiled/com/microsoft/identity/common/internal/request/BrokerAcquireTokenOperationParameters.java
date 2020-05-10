package com.microsoft.identity.common.internal.request;

import android.text.TextUtils;
import com.microsoft.identity.common.exception.ArgumentException;
import com.microsoft.identity.common.internal.broker.BrokerValidator;
import com.microsoft.identity.common.internal.cache.BrokerOAuth2TokenCache;
import java.util.Set;

public class BrokerAcquireTokenOperationParameters
  extends AcquireTokenOperationParameters
{
  public String mCallerAppVersion;
  public String mCallerPackageName;
  public int mCallerUId;
  public RequestType mRequestType = RequestType.REGULAR;
  public boolean mShouldResolveInterrupt;
  
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
  
  public RequestType getRequestType()
  {
    return mRequestType;
  }
  
  public boolean getShouldResolveInterrupt()
  {
    return mShouldResolveInterrupt;
  }
  
  public boolean isRequestFromBroker()
  {
    RequestType localRequestType = mRequestType;
    boolean bool;
    if ((localRequestType != RequestType.BROKER_RT_REQUEST) && (localRequestType != RequestType.RESOLVE_INTERRUPT)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
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
  
  public void setRequestType(RequestType paramRequestType)
  {
    mRequestType = paramRequestType;
  }
  
  public void setShouldResolveInterrupt(boolean paramBoolean)
  {
    mShouldResolveInterrupt = paramBoolean;
  }
  
  public void validate()
  {
    super.validate();
    if (getAuthority() != null)
    {
      if ((getScopes() != null) && (!getScopes().isEmpty()))
      {
        if (!TextUtils.isEmpty(getClientId()))
        {
          if (!isRequestFromBroker()) {
            if (mCallerUId != 0)
            {
              if (!TextUtils.isEmpty(mCallerPackageName))
              {
                if ((getTokenCache() instanceof BrokerOAuth2TokenCache))
                {
                  if ((SdkType.MSAL == getSdkType()) && (!BrokerValidator.isValidBrokerRedirect(getRedirectUri(), getAppContext(), getCallerPackageName()))) {
                    throw new ArgumentException("acquireToken", "mRedirectUri", "The redirect URI doesn't match the uri generated with caller package name and signature");
                  }
                }
                else {
                  throw new ArgumentException("acquireToken", "AcquireTokenSilentOperationParameters", "OAuth2Cache not an instance of BrokerOAuth2TokenCache");
                }
              }
              else {
                throw new ArgumentException("acquireToken", "mCallerPackageName", "Caller package name is not set");
              }
            }
            else {
              throw new ArgumentException("acquireToken", "mCallerUId", "Caller Uid is not set");
            }
          }
          return;
        }
        throw new ArgumentException("acquireToken", "mClientId", "Client Id is not set");
      }
      throw new ArgumentException("acquireToken", "mScopes", "Scope or resource is not set");
    }
    throw new ArgumentException("acquireToken", "mAuthority", "Authority Url is not set");
  }
  
  public static enum RequestType
  {
    static
    {
      BROKER_RT_REQUEST = new RequestType("BROKER_RT_REQUEST", 1);
      RequestType localRequestType = new RequestType("RESOLVE_INTERRUPT", 2);
      RESOLVE_INTERRUPT = localRequestType;
      $VALUES = new RequestType[] { REGULAR, BROKER_RT_REQUEST, localRequestType };
    }
    
    public RequestType() {}
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.request.BrokerAcquireTokenOperationParameters
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */