package com.microsoft.identity.client.exception;

import com.microsoft.identity.common.exception.BaseException;
import com.microsoft.identity.common.exception.IntuneAppProtectionPolicyRequiredException;

public class MsalIntuneAppProtectionPolicyRequiredException
  extends MsalServiceException
{
  public String mAccountUpn;
  public String mAccountUserId;
  public String mAuthorityUrl;
  public String mTenantId;
  
  public MsalIntuneAppProtectionPolicyRequiredException(IntuneAppProtectionPolicyRequiredException paramIntuneAppProtectionPolicyRequiredException)
  {
    super(paramIntuneAppProtectionPolicyRequiredException.getErrorCode(), paramIntuneAppProtectionPolicyRequiredException.getMessage(), paramIntuneAppProtectionPolicyRequiredException);
    mAccountUpn = paramIntuneAppProtectionPolicyRequiredException.getAccountUpn();
    mAccountUserId = paramIntuneAppProtectionPolicyRequiredException.getAccountUserId();
    mAuthorityUrl = paramIntuneAppProtectionPolicyRequiredException.getAuthorityUrl();
    mTenantId = paramIntuneAppProtectionPolicyRequiredException.getTenantId();
  }
  
  public String getAccountUpn()
  {
    return mAccountUpn;
  }
  
  public String getAccountUserId()
  {
    return mAccountUserId;
  }
  
  public String getAuthorityUrl()
  {
    return mAuthorityUrl;
  }
  
  public String getTenantId()
  {
    return mTenantId;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.exception.MsalIntuneAppProtectionPolicyRequiredException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */