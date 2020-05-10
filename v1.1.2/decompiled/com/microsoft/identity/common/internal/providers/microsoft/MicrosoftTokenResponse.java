package com.microsoft.identity.common.internal.providers.microsoft;

import com.microsoft.identity.common.internal.providers.oauth2.TokenResponse;
import e.c.c.v.c;
import java.util.Date;

public class MicrosoftTokenResponse
  extends TokenResponse
{
  public static final String CLIENT_INFO = "client_info";
  public static final String EXT_EXPIRES_IN = "ext_expires_in";
  public static final String FAMILY_ID = "foci";
  public String mAuthority;
  public String mCliTelemErrorCode;
  public String mCliTelemSubErrorCode;
  public transient String mClientId;
  @c("client_info")
  public String mClientInfo;
  @e.c.c.v.a
  @c("cloud_instance_host_name")
  public String mCloudInstanceHostName;
  public Date mExtExpiresOn;
  @e.c.c.v.a
  @c("ext_expires_in")
  public Long mExtendedExpiresIn;
  @e.c.c.v.a
  @c("foci")
  public String mFamilyId;
  @e.c.c.v.a
  public String mRefreshTokenAge;
  @e.c.c.v.a
  public String mSpeRing;
  
  public final String getAuthority()
  {
    return mAuthority;
  }
  
  public String getCliTelemErrorCode()
  {
    return mCliTelemErrorCode;
  }
  
  public String getCliTelemSubErrorCode()
  {
    return mCliTelemSubErrorCode;
  }
  
  public String getClientId()
  {
    return mClientId;
  }
  
  public String getClientInfo()
  {
    return mClientInfo;
  }
  
  public String getCloudInstanceHostName()
  {
    return mCloudInstanceHostName;
  }
  
  public Long getExtExpiresIn()
  {
    return mExtendedExpiresIn;
  }
  
  public Date getExtExpiresOn()
  {
    return mExtExpiresOn;
  }
  
  public String getFamilyId()
  {
    return mFamilyId;
  }
  
  public String getRefreshTokenAge()
  {
    return mRefreshTokenAge;
  }
  
  public String getSpeRing()
  {
    return mSpeRing;
  }
  
  public void setAuthority(String paramString)
  {
    mAuthority = paramString;
  }
  
  public void setCliTelemErrorCode(String paramString)
  {
    mCliTelemErrorCode = paramString;
  }
  
  public void setCliTelemSubErrorCode(String paramString)
  {
    mCliTelemSubErrorCode = paramString;
  }
  
  public void setClientId(String paramString)
  {
    mClientId = paramString;
  }
  
  public void setClientInfo(String paramString)
  {
    mClientInfo = paramString;
  }
  
  public void setCloudInstanceHostName(String paramString)
  {
    mCloudInstanceHostName = paramString;
  }
  
  public void setExtExpiresIn(Long paramLong)
  {
    mExtendedExpiresIn = paramLong;
  }
  
  public void setExtExpiresOn(Date paramDate)
  {
    mExtExpiresOn = paramDate;
  }
  
  public void setFamilyId(String paramString)
  {
    mFamilyId = paramString;
  }
  
  public void setRefreshTokenAge(String paramString)
  {
    mRefreshTokenAge = paramString;
  }
  
  public void setSpeRing(String paramString)
  {
    mSpeRing = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("MicrosoftTokenResponse{mExtExpiresOn=");
    localStringBuilder.append(mExtExpiresOn);
    localStringBuilder.append(", mClientInfo='");
    e.a.a.a.a.a(localStringBuilder, mClientInfo, '\'', ", mClientId='");
    e.a.a.a.a.a(localStringBuilder, mClientId, '\'', ", mExtendedExpiresIn=");
    localStringBuilder.append(mExtendedExpiresIn);
    localStringBuilder.append(", mFamilyId='");
    e.a.a.a.a.a(localStringBuilder, mFamilyId, '\'', "} ");
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.microsoft.MicrosoftTokenResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */