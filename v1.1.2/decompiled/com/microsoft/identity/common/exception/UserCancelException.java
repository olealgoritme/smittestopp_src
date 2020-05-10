package com.microsoft.identity.common.exception;

public final class UserCancelException
  extends BaseException
{
  public static final String sName = UserCancelException.class.getName();
  
  public UserCancelException() {}
  
  public UserCancelException(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public String getExceptionName()
  {
    return sName;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.exception.UserCancelException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */