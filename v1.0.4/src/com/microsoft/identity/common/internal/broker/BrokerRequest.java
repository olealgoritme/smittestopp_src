package com.microsoft.identity.common.internal.broker;

import com.microsoft.identity.common.internal.authscheme.AbstractAuthenticationScheme;
import e.c.c.v.c;
import java.io.Serializable;

public class BrokerRequest
  implements Serializable
{
  @c("client_app_name")
  public String mApplicationName;
  @c("client_app_version")
  public String mApplicationVersion;
  @c("authentication_scheme")
  public AbstractAuthenticationScheme mAuthenticationScheme;
  @c("authority")
  public String mAuthority;
  @c("authorization_agent")
  public String mAuthorizationAgent;
  @c("claims")
  public String mClaims;
  @c("client_id")
  public String mClientId;
  @c("correlation_id")
  public String mCorrelationId;
  @c("environment")
  public String mEnvironment;
  @c("extra_query_param")
  public String mExtraQueryStringParameter;
  @c("force_refresh")
  public boolean mForceRefresh;
  @c("home_account_id")
  public String mHomeAccountId;
  @c("local_account_id")
  public String mLocalAccountId;
  @c("client_version")
  public String mMsalVersion;
  @c("multiple_clouds_supported")
  public boolean mMultipleCloudsSupported;
  @c("prompt")
  public String mPrompt;
  @c("redirect_uri")
  public String mRedirect;
  @c("scopes")
  public String mScope;
  @c("username")
  public String mUserName;
  
  public BrokerRequest(BrokerRequest.Builder paramBuilder)
  {
    mAuthority = BrokerRequest.Builder.access$000(paramBuilder);
    mScope = BrokerRequest.Builder.access$100(paramBuilder);
    mRedirect = BrokerRequest.Builder.access$200(paramBuilder);
    mClientId = BrokerRequest.Builder.access$300(paramBuilder);
    mHomeAccountId = BrokerRequest.Builder.access$400(paramBuilder);
    mLocalAccountId = BrokerRequest.Builder.access$500(paramBuilder);
    mUserName = BrokerRequest.Builder.access$600(paramBuilder);
    mExtraQueryStringParameter = BrokerRequest.Builder.access$700(paramBuilder);
    mCorrelationId = BrokerRequest.Builder.access$800(paramBuilder);
    mPrompt = BrokerRequest.Builder.access$900(paramBuilder);
    mClaims = BrokerRequest.Builder.access$1000(paramBuilder);
    mForceRefresh = BrokerRequest.Builder.access$1100(paramBuilder);
    mApplicationName = BrokerRequest.Builder.access$1200(paramBuilder);
    mApplicationVersion = BrokerRequest.Builder.access$1300(paramBuilder);
    mMsalVersion = BrokerRequest.Builder.access$1400(paramBuilder);
    mEnvironment = BrokerRequest.Builder.access$1500(paramBuilder);
    mMultipleCloudsSupported = BrokerRequest.Builder.access$1600(paramBuilder);
    mAuthorizationAgent = BrokerRequest.Builder.access$1700(paramBuilder);
    mAuthenticationScheme = BrokerRequest.Builder.access$1800(paramBuilder);
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
  
  public String getAuthority()
  {
    return mAuthority;
  }
  
  public String getAuthorizationAgent()
  {
    return mAuthorizationAgent;
  }
  
  public String getClaims()
  {
    return mClaims;
  }
  
  public String getClientId()
  {
    return mClientId;
  }
  
  public String getCorrelationId()
  {
    return mCorrelationId;
  }
  
  public String getEnvironment()
  {
    return mEnvironment;
  }
  
  public String getExtraQueryStringParameter()
  {
    return mExtraQueryStringParameter;
  }
  
  public boolean getForceRefresh()
  {
    return mForceRefresh;
  }
  
  public String getHomeAccountId()
  {
    return mHomeAccountId;
  }
  
  public String getLocalAccountId()
  {
    return mLocalAccountId;
  }
  
  public String getMsalVersion()
  {
    return mMsalVersion;
  }
  
  public boolean getMultipleCloudsSupported()
  {
    return mMultipleCloudsSupported;
  }
  
  public String getPrompt()
  {
    return mPrompt;
  }
  
  public String getRedirect()
  {
    return mRedirect;
  }
  
  public String getScope()
  {
    return mScope;
  }
  
  public String getUserName()
  {
    return mUserName;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.broker.BrokerRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */