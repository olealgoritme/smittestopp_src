package com.microsoft.identity.common.internal.dto;

import e.c.c.v.c;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class AccessTokenRecord
  extends Credential
{
  @c("access_token_type")
  public String mAccessTokenType;
  @c("authority")
  public String mAuthority;
  @c("expires_on")
  public String mExpiresOn;
  @c("extended_expires_on")
  public String mExtendedExpiresOn;
  @c("kid")
  public String mKid;
  @c("realm")
  public String mRealm;
  @c("target")
  public String mTarget;
  
  private boolean isExpired(String paramString)
  {
    Date localDate = Calendar.getInstance().getTime();
    long l = Long.valueOf(paramString).longValue();
    return new Date(TimeUnit.SECONDS.toMillis(l)).before(localDate);
  }
  
  public String getAccessTokenType()
  {
    return mAccessTokenType;
  }
  
  public String getAuthority()
  {
    return mAuthority;
  }
  
  public String getExpiresOn()
  {
    return mExpiresOn;
  }
  
  public String getExtendedExpiresOn()
  {
    return mExtendedExpiresOn;
  }
  
  public String getKid()
  {
    return mKid;
  }
  
  public String getRealm()
  {
    return mRealm;
  }
  
  public String getTarget()
  {
    return mTarget;
  }
  
  public boolean isExpired()
  {
    return isExpired(getExpiresOn());
  }
  
  public void setAccessTokenType(String paramString)
  {
    mAccessTokenType = paramString;
  }
  
  public void setAuthority(String paramString)
  {
    mAuthority = paramString;
  }
  
  public void setExpiresOn(String paramString)
  {
    mExpiresOn = paramString;
  }
  
  public void setExtendedExpiresOn(String paramString)
  {
    mExtendedExpiresOn = paramString;
  }
  
  public void setKid(String paramString)
  {
    mKid = paramString;
  }
  
  public void setRealm(String paramString)
  {
    mRealm = paramString;
  }
  
  public void setTarget(String paramString)
  {
    mTarget = paramString;
  }
  
  public static class SerializedNames
    extends Credential.SerializedNames
  {
    public static final String ACCESS_TOKEN_TYPE = "access_token_type";
    public static final String AUTHORITY = "authority";
    public static final String EXTENDED_EXPIRES_ON = "extended_expires_on";
    public static final String KID = "kid";
    public static final String REALM = "realm";
    public static final String TARGET = "target";
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.dto.AccessTokenRecord
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */