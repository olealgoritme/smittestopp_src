package com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory;

import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftTokenResponse;
import e.a.a.a.a;
import java.util.Date;

public class AzureActiveDirectoryTokenResponse
  extends MicrosoftTokenResponse
{
  public Date mExpiresOn;
  public String mNotBefore;
  public String mResource;
  public String mSpeRing;
  
  public Date getExpiresOn()
  {
    return mExpiresOn;
  }
  
  public String getNotBefore()
  {
    return mNotBefore;
  }
  
  public String getResource()
  {
    return mResource;
  }
  
  public String getSpeRing()
  {
    return mSpeRing;
  }
  
  public void setExpiresOn(Date paramDate)
  {
    mExpiresOn = paramDate;
  }
  
  public void setNotBefore(String paramString)
  {
    mNotBefore = paramString;
  }
  
  public void setResource(String paramString)
  {
    mResource = paramString;
  }
  
  public void setSpeRing(String paramString)
  {
    mSpeRing = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = a.a("AzureActiveDirectoryTokenResponse{mExpiresOn=");
    localStringBuilder.append(mExpiresOn);
    localStringBuilder.append(", mResource='");
    a.a(localStringBuilder, mResource, '\'', ", mNotBefore='");
    a.a(localStringBuilder, mNotBefore, '\'', ", mSpeRing='");
    a.a(localStringBuilder, mSpeRing, '\'', "} ");
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectoryTokenResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */