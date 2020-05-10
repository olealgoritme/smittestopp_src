package com.microsoft.identity.client.exception;

import com.microsoft.identity.client.internal.MsalUtils;
import com.microsoft.identity.common.exception.BaseException;

public class MsalException
  extends BaseException
{
  public MsalException() {}
  
  public MsalException(String paramString)
  {
    super(paramString);
  }
  
  public MsalException(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public MsalException(String paramString1, String paramString2, Throwable paramThrowable)
  {
    super(paramString1, paramString2, paramThrowable);
  }
  
  public String getErrorCode()
  {
    return super.getErrorCode();
  }
  
  public String getMessage()
  {
    if (!MsalUtils.isEmpty(super.getMessage())) {
      return super.getMessage();
    }
    return "";
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.exception.MsalException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */