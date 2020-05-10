package com.microsoft.identity.client.exception;

public class MsalServiceException
  extends MsalException
{
  public static final String ACCESS_DENIED = "access_denied";
  public static final int DEFAULT_STATUS_CODE = 0;
  public static final String INVALID_INSTANCE = "invalid_instance";
  public static final String INVALID_REQUEST = "invalid_request";
  public static final String INVALID_SCOPE = "invalid_scope";
  public static final String REQUEST_TIMEOUT = "request_timeout";
  public static final String SERVICE_NOT_AVAILABLE = "service_not_available";
  public static final String UNAUTHORIZED_CLIENT = "unauthorized_client";
  public static final String UNKNOWN_ERROR = "unknown_error";
  public final int mHttpStatusCode;
  
  public MsalServiceException(String paramString1, String paramString2, int paramInt, Throwable paramThrowable)
  {
    super(paramString1, paramString2, paramThrowable);
    mHttpStatusCode = paramInt;
  }
  
  public MsalServiceException(String paramString1, String paramString2, Throwable paramThrowable)
  {
    super(paramString1, paramString2, paramThrowable);
    mHttpStatusCode = 0;
  }
  
  public int getHttpStatusCode()
  {
    return mHttpStatusCode;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.exception.MsalServiceException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */