package com.microsoft.identity.common.exception;

import com.microsoft.identity.common.adal.internal.util.StringExtensions;

public class BaseException
  extends Exception
{
  public static final String sName = BaseException.class.getName();
  public String mCliTelemErrorCode;
  public String mCliTelemSubErrorCode;
  public String mCorrelationId;
  public String mErrorCode;
  public String mRefreshTokenAge;
  public String mSpeRing;
  
  public BaseException() {}
  
  public BaseException(String paramString)
  {
    mErrorCode = paramString;
  }
  
  public BaseException(String paramString1, String paramString2)
  {
    super(paramString2);
    mErrorCode = paramString1;
  }
  
  public BaseException(String paramString1, String paramString2, Throwable paramThrowable)
  {
    super(paramString2, paramThrowable);
    mErrorCode = paramString1;
  }
  
  public String getCliTelemErrorCode()
  {
    return mCliTelemErrorCode;
  }
  
  public String getCliTelemSubErrorCode()
  {
    return mCliTelemSubErrorCode;
  }
  
  public String getCorrelationId()
  {
    return mCorrelationId;
  }
  
  public String getErrorCode()
  {
    return mErrorCode;
  }
  
  public String getExceptionName()
  {
    return sName;
  }
  
  public String getMessage()
  {
    if (!StringExtensions.isNullOrBlank(super.getMessage())) {
      return super.getMessage();
    }
    return null;
  }
  
  public String getRefreshTokenAge()
  {
    return mRefreshTokenAge;
  }
  
  public String getSpeRing()
  {
    return mSpeRing;
  }
  
  public void setCliTelemErrorCode(String paramString)
  {
    mCliTelemErrorCode = paramString;
  }
  
  public void setCliTelemSubErrorCode(String paramString)
  {
    mCliTelemSubErrorCode = paramString;
  }
  
  public void setCorrelationId(String paramString)
  {
    mCorrelationId = paramString;
  }
  
  public void setRefreshTokenAge(String paramString)
  {
    mRefreshTokenAge = paramString;
  }
  
  public void setSpeRing(String paramString)
  {
    mSpeRing = paramString;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.exception.BaseException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */