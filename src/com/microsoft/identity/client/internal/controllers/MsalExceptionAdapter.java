package com.microsoft.identity.client.internal.controllers;

import com.microsoft.identity.client.exception.MsalArgumentException;
import com.microsoft.identity.client.exception.MsalClientException;
import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.identity.client.exception.MsalIntuneAppProtectionPolicyRequiredException;
import com.microsoft.identity.client.exception.MsalServiceException;
import com.microsoft.identity.client.exception.MsalUiRequiredException;
import com.microsoft.identity.client.exception.MsalUserCancelException;
import com.microsoft.identity.common.exception.ArgumentException;
import com.microsoft.identity.common.exception.BaseException;
import com.microsoft.identity.common.exception.ClientException;
import com.microsoft.identity.common.exception.IntuneAppProtectionPolicyRequiredException;
import com.microsoft.identity.common.exception.ServiceException;
import com.microsoft.identity.common.exception.UiRequiredException;
import com.microsoft.identity.common.exception.UserCancelException;

public class MsalExceptionAdapter
{
  public static MsalException msalExceptionFromBaseException(BaseException paramBaseException)
  {
    Object localObject1;
    if ((paramBaseException instanceof MsalException))
    {
      localObject1 = (MsalException)paramBaseException;
    }
    else
    {
      if ((paramBaseException instanceof ClientException))
      {
        localObject1 = (ClientException)paramBaseException;
        localObject1 = new MsalClientException(((BaseException)localObject1).getErrorCode(), ((BaseException)localObject1).getMessage(), (Throwable)localObject1);
      }
      for (;;)
      {
        break;
        if ((paramBaseException instanceof ArgumentException))
        {
          localObject1 = (ArgumentException)paramBaseException;
          localObject1 = new MsalArgumentException(((ArgumentException)localObject1).getArgumentName(), ((ArgumentException)localObject1).getOperationName(), ((BaseException)localObject1).getMessage(), (Throwable)localObject1);
        }
        else if ((paramBaseException instanceof UiRequiredException))
        {
          localObject1 = (UiRequiredException)paramBaseException;
          localObject1 = new MsalUiRequiredException(((BaseException)localObject1).getErrorCode(), ((BaseException)localObject1).getMessage());
        }
        else if ((paramBaseException instanceof IntuneAppProtectionPolicyRequiredException))
        {
          localObject1 = new MsalIntuneAppProtectionPolicyRequiredException((IntuneAppProtectionPolicyRequiredException)paramBaseException);
        }
        else if ((paramBaseException instanceof ServiceException))
        {
          localObject1 = (ServiceException)paramBaseException;
          localObject1 = new MsalServiceException(((BaseException)localObject1).getErrorCode(), ((BaseException)localObject1).getMessage(), ((ServiceException)localObject1).getHttpStatusCode(), (Throwable)localObject1);
        }
        else if ((paramBaseException instanceof UserCancelException))
        {
          localObject1 = new MsalUserCancelException();
        }
        else
        {
          localObject1 = null;
        }
      }
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new MsalClientException("unknown_error", paramBaseException.getMessage(), paramBaseException);
    }
    return (MsalException)localObject2;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.internal.controllers.MsalExceptionAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */