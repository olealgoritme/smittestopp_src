package com.microsoft.identity.common.exception;

public class IntuneAppProtectionPolicyRequiredException
  extends ServiceException
{
  public static final String sName = IntuneAppProtectionPolicyRequiredException.class.getName();
  public String mAccountUpn;
  public String mAccountUserId;
  public String mAuthorityUrl;
  public String mTenantId;
  
  public IntuneAppProtectionPolicyRequiredException(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, null);
  }
  
  public IntuneAppProtectionPolicyRequiredException(String paramString1, String paramString2, Throwable paramThrowable)
  {
    super(paramString1, paramString2, paramThrowable);
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
  
  public String getExceptionName()
  {
    return sName;
  }
  
  public String getTenantId()
  {
    return mTenantId;
  }
  
  public void setAccountUpn(String paramString)
  {
    mAccountUpn = paramString;
  }
  
  public void setAccountUserId(String paramString)
  {
    mAccountUserId = paramString;
  }
  
  public void setAuthorityUrl(String paramString)
  {
    mAuthorityUrl = paramString;
  }
  
  public void setTenantId(String paramString)
  {
    mTenantId = paramString;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.exception.IntuneAppProtectionPolicyRequiredException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */