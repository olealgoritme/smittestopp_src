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
  
  public BrokerRequest(Builder paramBuilder)
  {
    mAuthority = Builder.access$000(paramBuilder);
    mScope = Builder.access$100(paramBuilder);
    mRedirect = Builder.access$200(paramBuilder);
    mClientId = Builder.access$300(paramBuilder);
    mHomeAccountId = Builder.access$400(paramBuilder);
    mLocalAccountId = Builder.access$500(paramBuilder);
    mUserName = Builder.access$600(paramBuilder);
    mExtraQueryStringParameter = Builder.access$700(paramBuilder);
    mCorrelationId = Builder.access$800(paramBuilder);
    mPrompt = Builder.access$900(paramBuilder);
    mClaims = Builder.access$1000(paramBuilder);
    mForceRefresh = Builder.access$1100(paramBuilder);
    mApplicationName = Builder.access$1200(paramBuilder);
    mApplicationVersion = Builder.access$1300(paramBuilder);
    mMsalVersion = Builder.access$1400(paramBuilder);
    mEnvironment = Builder.access$1500(paramBuilder);
    mMultipleCloudsSupported = Builder.access$1600(paramBuilder);
    mAuthorizationAgent = Builder.access$1700(paramBuilder);
    mAuthenticationScheme = Builder.access$1800(paramBuilder);
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
  
  public static class Builder
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
  
  public class SerializedNames
  {
    public static final String AUTHENTICATION_SCHEME = "authentication_scheme";
    public static final String AUTHORITY = "authority";
    public static final String AUTHORIZATION_AGENT = "authorization_agent";
    public static final String CLAIMS = "claims";
    public static final String CLIENT_APP_NAME = "client_app_name";
    public static final String CLIENT_APP_VERSION = "client_app_version";
    public static final String CLIENT_ID = "client_id";
    public static final String CLIENT_VERSION = "client_version";
    public static final String CORRELATION_ID = "correlation_id";
    public static final String ENVIRONMENT = "environment";
    public static final String EXTRA_QUERY_STRING_PARAMETER = "extra_query_param";
    public static final String FORCE_REFRESH = "force_refresh";
    public static final String HOME_ACCOUNT_ID = "home_account_id";
    public static final String LOCAL_ACCOUNT_ID = "local_account_id";
    public static final String MULTIPLE_CLOUDS_SUPPORTED = "multiple_clouds_supported";
    public static final String PROMPT = "prompt";
    public static final String REDIRECT = "redirect_uri";
    public static final String SCOPE = "scopes";
    public static final String USERNAME = "username";
    
    public SerializedNames() {}
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.broker.BrokerRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */