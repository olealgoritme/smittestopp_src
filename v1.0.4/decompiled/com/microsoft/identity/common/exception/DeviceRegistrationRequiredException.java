package com.microsoft.identity.common.exception;

public final class DeviceRegistrationRequiredException
  extends BaseException
{
  public static final String sName = DeviceRegistrationRequiredException.class.getName();
  public String mUsername;
  
  public DeviceRegistrationRequiredException(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1, paramString2);
    mUsername = paramString3;
  }
  
  public String getExceptionName()
  {
    return sName;
  }
  
  public String getUsername()
  {
    return mUsername;
  }
  
  public void setUsername(String paramString)
  {
    mUsername = paramString;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.exception.DeviceRegistrationRequiredException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */