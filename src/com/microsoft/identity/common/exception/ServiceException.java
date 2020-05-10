package com.microsoft.identity.common.exception;

import com.microsoft.identity.common.adal.internal.util.HashMapExtensions;
import com.microsoft.identity.common.internal.net.HttpResponse;
import java.util.HashMap;
import java.util.List;

public class ServiceException
  extends BaseException
{
  public static final String ACCESS_DENIED = "access_denied";
  public static final int DEFAULT_STATUS_CODE = 0;
  public static final String INVALID_INSTANCE = "invalid_instance";
  public static final String INVALID_REQUEST = "invalid_request";
  public static final String INVALID_SCOPE = "invalid_scope";
  public static final String OPENID_PROVIDER_CONFIGURATION_FAILED_TO_LOAD = "failed_to_load_openid_configuration";
  public static final String REQUEST_TIMEOUT = "request_timeout";
  public static final String SERVICE_NOT_AVAILABLE = "service_not_available";
  public static final String UNAUTHORIZED_CLIENT = "unauthorized_client";
  public static final String UNKNOWN_ERROR = "unknown_error";
  public static final String sName = ServiceException.class.getName();
  public HashMap<String, String> mHttpResponseBody = null;
  public HashMap<String, List<String>> mHttpResponseHeaders = null;
  public int mHttpStatusCode;
  public String mOauthSubErrorCode;
  
  public ServiceException(String paramString1, String paramString2, int paramInt, Throwable paramThrowable)
  {
    super(paramString1, paramString2, paramThrowable);
    mHttpStatusCode = paramInt;
  }
  
  public ServiceException(String paramString1, String paramString2, Throwable paramThrowable)
  {
    super(paramString1, paramString2, paramThrowable);
    mHttpStatusCode = 0;
  }
  
  public String getExceptionName()
  {
    return sName;
  }
  
  public HashMap<String, String> getHttpResponseBody()
  {
    return mHttpResponseBody;
  }
  
  public HashMap<String, List<String>> getHttpResponseHeaders()
  {
    return mHttpResponseHeaders;
  }
  
  public int getHttpStatusCode()
  {
    return mHttpStatusCode;
  }
  
  public String getOAuthSubErrorCode()
  {
    return mOauthSubErrorCode;
  }
  
  public void setHttpResponse(HttpResponse paramHttpResponse)
  {
    if (paramHttpResponse != null)
    {
      mHttpStatusCode = paramHttpResponse.getStatusCode();
      if (paramHttpResponse.getHeaders() != null) {
        mHttpResponseHeaders = new HashMap(paramHttpResponse.getHeaders());
      }
      if (paramHttpResponse.getBody() != null) {
        mHttpResponseBody = HashMapExtensions.getJsonResponse(paramHttpResponse);
      }
    }
  }
  
  public void setHttpResponseBody(HashMap<String, String> paramHashMap)
  {
    mHttpResponseBody = paramHashMap;
  }
  
  public void setHttpResponseHeaders(HashMap<String, List<String>> paramHashMap)
  {
    mHttpResponseHeaders = paramHashMap;
  }
  
  public void setOauthSubErrorCode(String paramString)
  {
    mOauthSubErrorCode = paramString;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.exception.ServiceException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */