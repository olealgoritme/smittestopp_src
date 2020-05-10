package com.microsoft.identity.common.internal.broker;

import com.microsoft.identity.common.internal.authscheme.AbstractAuthenticationScheme;

public class BrokerRequest$Builder
{
  public String mApplicationName;
  public String mApplicationVersion;
  public AbstractAuthenticationScheme mAuthenticationScheme;
  public String mAuthority;
  public String mAuthorizationAgent;
  public String mClaims;
  public String mClientId;
  public String mCorrelationId;
  public String mEnvironment;
  public String mExtraQueryStringParameter;
  public boolean mForceRefresh;
  public String mHomeAccountId;
  public String mLocalAccountId;
  public String mMsalVersion;
  public boolean mMultipleCloudsSupported;
  public String mPrompt;
  public String mRedirect;
  public String mScope;
  public String mUserName;
  
  public Builder applicationName(String paramString)
  {
    mApplicationName = paramString;
    return this;
  }
  
  public Builder applicationVersion(String paramString)
  {
    mApplicationVersion = paramString;
    return this;
  }
  
  public Builder authenticationScheme(AbstractAuthenticationScheme paramAbstractAuthenticationScheme)
  {
    mAuthenticationScheme = paramAbstractAuthenticationScheme;
    return this;
  }
  
  public Builder authority(String paramString)
  {
    mAuthority = paramString;
    return this;
  }
  
  public Builder authorizationAgent(String paramString)
  {
    mAuthorizationAgent = paramString;
    return this;
  }
  
  public BrokerRequest build()
  {
    return new BrokerRequest(this, null);
  }
  
  public Builder claims(String paramString)
  {
    mClaims = paramString;
    return this;
  }
  
  public Builder clientId(String paramString)
  {
    mClientId = paramString;
    return this;
  }
  
  public Builder correlationId(String paramString)
  {
    mCorrelationId = paramString;
    return this;
  }
  
  public Builder environment(String paramString)
  {
    mEnvironment = paramString;
    return this;
  }
  
  public Builder extraQueryStringParameter(String paramString)
  {
    mExtraQueryStringParameter = paramString;
    return this;
  }
  
  public Builder forceRefresh(boolean paramBoolean)
  {
    mForceRefresh = paramBoolean;
    return this;
  }
  
  public Builder homeAccountId(String paramString)
  {
    mHomeAccountId = paramString;
    return this;
  }
  
  public Builder localAccountId(String paramString)
  {
    mLocalAccountId = paramString;
    return this;
  }
  
  public Builder msalVersion(String paramString)
  {
    mMsalVersion = paramString;
    return this;
  }
  
  public Builder multipleCloudsSupported(boolean paramBoolean)
  {
    mMultipleCloudsSupported = paramBoolean;
    return this;
  }
  
  public Builder prompt(String paramString)
  {
    mPrompt = paramString;
    return this;
  }
  
  public Builder redirect(String paramString)
  {
    mRedirect = paramString;
    return this;
  }
  
  public Builder scope(String paramString)
  {
    mScope = paramString;
    return this;
  }
  
  public Builder username(String paramString)
  {
    mUserName = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.broker.BrokerRequest.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */