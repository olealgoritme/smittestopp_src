package com.microsoft.identity.common.internal.controllers;

import com.microsoft.identity.common.exception.BaseException;
import com.microsoft.identity.common.exception.ClientException;
import com.microsoft.identity.common.exception.DeviceRegistrationRequiredException;
import com.microsoft.identity.common.exception.ServiceException;
import com.microsoft.identity.common.exception.UiRequiredException;
import com.microsoft.identity.common.exception.UserCancelException;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.net.HttpResponse;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAuthorizationErrorResponse;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationErrorResponse;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.internal.providers.oauth2.TokenErrorResponse;
import com.microsoft.identity.common.internal.providers.oauth2.TokenResult;
import com.microsoft.identity.common.internal.result.AcquireTokenResult;
import com.microsoft.identity.common.internal.telemetry.CliTelemInfo;
import com.microsoft.identity.common.internal.util.HeaderSerializationUtil;
import com.microsoft.identity.common.internal.util.StringUtil;
import e.a.a.a.a;
import e.c.c.s;
import java.io.IOException;
import org.json.JSONException;

public class ExceptionAdapter
{
  public static final String TAG = "ExceptionAdapter";
  
  public static void applyCliTelemInfo(CliTelemInfo paramCliTelemInfo, BaseException paramBaseException)
  {
    if (paramCliTelemInfo != null)
    {
      paramBaseException.setSpeRing(paramCliTelemInfo.getSpeRing());
      paramBaseException.setRefreshTokenAge(paramCliTelemInfo.getRefreshTokenAge());
      paramBaseException.setCliTelemErrorCode(paramCliTelemInfo.getServerErrorCode());
      paramBaseException.setCliTelemSubErrorCode(paramCliTelemInfo.getServerSubErrorCode());
    }
  }
  
  public static BaseException baseExceptionFromException(Exception paramException)
  {
    if ((paramException instanceof IOException))
    {
      StringBuilder localStringBuilder = a.a("An IO error occurred with message: ");
      localStringBuilder.append(paramException.getMessage());
      return new ClientException("io_error", localStringBuilder.toString(), paramException);
    }
    if ((paramException instanceof BaseException)) {
      return (BaseException)paramException;
    }
    return new ClientException("unknown_error", paramException.getMessage(), paramException);
  }
  
  public static BaseException exceptionFromAcquireTokenResult(AcquireTokenResult paramAcquireTokenResult)
  {
    Object localObject = paramAcquireTokenResult.getAuthorizationResult();
    if (localObject != null)
    {
      AuthorizationErrorResponse localAuthorizationErrorResponse = ((AuthorizationResult)localObject).getAuthorizationErrorResponse();
      if (!((AuthorizationResult)localObject).getSuccess())
      {
        int i = paramAcquireTokenResult.getAuthorizationResult().getAuthorizationStatus().ordinal();
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3)
            {
              if ((localAuthorizationErrorResponse instanceof MicrosoftAuthorizationErrorResponse))
              {
                paramAcquireTokenResult = (MicrosoftAuthorizationErrorResponse)localAuthorizationErrorResponse;
                if (paramAcquireTokenResult.getError().equals("Device needs to be registered to access the resource")) {
                  return new DeviceRegistrationRequiredException(paramAcquireTokenResult.getError(), paramAcquireTokenResult.getErrorDescription(), paramAcquireTokenResult.getUserName());
                }
              }
              paramAcquireTokenResult = localAuthorizationErrorResponse.getError();
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(localAuthorizationErrorResponse.getError());
              ((StringBuilder)localObject).append(";");
              ((StringBuilder)localObject).append(localAuthorizationErrorResponse.getErrorDescription());
              return new ServiceException(paramAcquireTokenResult, ((StringBuilder)localObject).toString(), 0, null);
            }
          }
          else {
            return new ClientException(localAuthorizationErrorResponse.getError(), localAuthorizationErrorResponse.getErrorDescription());
          }
        }
        else {
          return new UserCancelException();
        }
      }
    }
    else
    {
      a.c(new StringBuilder(), TAG, ":exceptionFromAcquireTokenResult", "AuthorizationResult was null -- expected for ATS cases.");
    }
    return exceptionFromTokenResult(paramAcquireTokenResult.getTokenResult());
  }
  
  public static ServiceException exceptionFromTokenResult(TokenResult paramTokenResult)
  {
    Object localObject;
    if ((paramTokenResult != null) && (!paramTokenResult.getSuccess()) && (paramTokenResult.getErrorResponse() != null) && (!StringUtil.isEmpty(paramTokenResult.getErrorResponse().getError())))
    {
      localObject = getExceptionFromTokenErrorResponse(paramTokenResult.getErrorResponse());
      applyCliTelemInfo(paramTokenResult.getCliTelemInfo(), (BaseException)localObject);
      paramTokenResult = (TokenResult)localObject;
    }
    else
    {
      String str = a.a(new StringBuilder(), TAG, ":exceptionFromTokenResult");
      localObject = a.a("Unknown error, Token result is null [");
      boolean bool;
      if (paramTokenResult == null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append("]");
      Logger.warn(str, ((StringBuilder)localObject).toString());
      paramTokenResult = new ServiceException("unknown_error", "Request failed, but no error returned back from service.", null);
    }
    return paramTokenResult;
  }
  
  public static ServiceException getExceptionFromTokenErrorResponse(TokenErrorResponse paramTokenErrorResponse)
  {
    Object localObject;
    if (shouldBeConvertedToUiRequiredException(paramTokenErrorResponse.getError())) {
      localObject = new UiRequiredException(paramTokenErrorResponse.getError(), paramTokenErrorResponse.getErrorDescription());
    } else {
      localObject = new ServiceException(paramTokenErrorResponse.getError(), paramTokenErrorResponse.getErrorDescription(), null);
    }
    ((ServiceException)localObject).setOauthSubErrorCode(paramTokenErrorResponse.getSubError());
    try
    {
      ((ServiceException)localObject).setHttpResponse(synthesizeHttpResponse(paramTokenErrorResponse.getStatusCode(), paramTokenErrorResponse.getResponseHeadersJson(), paramTokenErrorResponse.getResponseBody()));
    }
    catch (JSONException paramTokenErrorResponse)
    {
      a.c(new StringBuilder(), TAG, ":getExceptionFromTokenErrorResponse", "Failed to deserialize error data: status, headers, response body.");
    }
    return (ServiceException)localObject;
  }
  
  public static boolean shouldBeConvertedToUiRequiredException(String paramString)
  {
    boolean bool;
    if ((!paramString.equalsIgnoreCase("invalid_grant")) && (!paramString.equalsIgnoreCase("interaction_required"))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static HttpResponse synthesizeHttpResponse(int paramInt, String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null)) {
      try
      {
        paramString1 = new HttpResponse(paramInt, paramString2, HeaderSerializationUtil.fromJson(paramString1));
        return paramString1;
      }
      catch (s paramString1)
      {
        a.c(new StringBuilder(), TAG, ":applyHttpErrorResponseData", "Failed to deserialize error data: status, headers, response body.");
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.controllers.ExceptionAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */