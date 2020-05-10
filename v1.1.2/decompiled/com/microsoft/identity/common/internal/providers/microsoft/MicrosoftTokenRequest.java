package com.microsoft.identity.common.internal.providers.microsoft;

import com.microsoft.identity.common.internal.providers.oauth2.TokenRequest;
import e.c.c.v.a;
import e.c.c.v.c;
import java.util.UUID;

public class MicrosoftTokenRequest
  extends TokenRequest
{
  public static final String CLAIMS = "claims";
  public static final String CLIENT_APP_NAME = "x-app-name";
  public static final String CLIENT_APP_VERSION = "x-app-ver";
  public static final String CLIENT_INFO = "client_info";
  public static final String CODE_VERIFIER = "code_verifier";
  public static final String CORRELATION_ID = "client-request-id";
  public static final String ID_TOKEN_VERSION = "itver";
  public static final String INSTANCE_AWARE = "instance_aware";
  public static final String MAM_VERSION = "mamver";
  public transient String mBrokerVersion;
  @a
  @c("claims")
  public String mClaims;
  @a
  @c("x-app-name")
  public String mClientAppName;
  @a
  @c("x-app-ver")
  public String mClientAppVersion;
  @a
  @c("client_info")
  public String mClientInfoEnabled = "1";
  @c("code_verifier")
  public String mCodeVerifier;
  @a
  @c("client-request-id")
  public UUID mCorrelationId;
  @a
  @c("itver")
  public String mIdTokenVersion;
  @a
  @c("instance_aware")
  public String mInstanceAware;
  @a
  @c("mamver")
  public String mMamVersion;
  public String mTokenScope;
  
  public String getBrokerVersion()
  {
    return mBrokerVersion;
  }
  
  public String getClaims()
  {
    return mClaims;
  }
  
  public String getClientAppName()
  {
    return mClientAppName;
  }
  
  public String getClientAppVersion()
  {
    return mClientAppVersion;
  }
  
  public String getClientInfoEnabled()
  {
    return mClientInfoEnabled;
  }
  
  public String getCodeVerifier()
  {
    return mCodeVerifier;
  }
  
  public UUID getCorrelationId()
  {
    return mCorrelationId;
  }
  
  public String getIdTokenVersion()
  {
    return mIdTokenVersion;
  }
  
  public String getInstanceAware()
  {
    return mInstanceAware;
  }
  
  public String getMamVersion()
  {
    return mMamVersion;
  }
  
  public String getTokenScope()
  {
    return mTokenScope;
  }
  
  public void setBrokerVersion(String paramString)
  {
    mBrokerVersion = paramString;
  }
  
  public void setClaims(String paramString)
  {
    mClaims = paramString;
  }
  
  public void setClientAppName(String paramString)
  {
    mClientAppName = paramString;
  }
  
  public void setClientAppVersion(String paramString)
  {
    mClientAppVersion = paramString;
  }
  
  public void setCodeVerifier(String paramString)
  {
    mCodeVerifier = paramString;
  }
  
  public void setCorrelationId(UUID paramUUID)
  {
    mCorrelationId = paramUUID;
  }
  
  public void setIdTokenVersion(String paramString)
  {
    mIdTokenVersion = paramString;
  }
  
  public void setInstanceAware(String paramString)
  {
    mInstanceAware = paramString;
  }
  
  public void setMamversion(String paramString)
  {
    mMamVersion = paramString;
  }
  
  public void setTokenScope(String paramString)
  {
    mTokenScope = paramString;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.microsoft.MicrosoftTokenRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */