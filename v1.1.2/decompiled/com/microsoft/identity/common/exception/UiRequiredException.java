package com.microsoft.identity.common.exception;

public final class UiRequiredException
  extends ServiceException
{
  public static final String sName = UiRequiredException.class.getName();
  
  public UiRequiredException(String paramString1, String paramString2)
  {
    super(paramString1, paramString2, null);
  }
  
  public UiRequiredException(String paramString1, String paramString2, Throwable paramThrowable)
  {
    super(paramString1, paramString2, paramThrowable);
  }
  
  public String getExceptionName()
  {
    return sName;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.exception.UiRequiredException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */