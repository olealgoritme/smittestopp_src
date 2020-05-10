package com.microsoft.identity.client;

import android.os.Handler;
import android.os.Looper;
import com.microsoft.identity.client.internal.controllers.MSALControllerFactory;
import com.microsoft.identity.client.internal.controllers.OperationParametersAdapter;
import com.microsoft.identity.common.exception.BaseException;
import com.microsoft.identity.common.internal.controllers.BaseCommand;
import com.microsoft.identity.common.internal.controllers.CommandCallback;
import com.microsoft.identity.common.internal.controllers.CommandDispatcher;
import com.microsoft.identity.common.internal.controllers.ExceptionAdapter;
import com.microsoft.identity.common.internal.controllers.InteractiveTokenCommand;
import com.microsoft.identity.common.internal.controllers.TaskCompletedCallbackWithError;
import com.microsoft.identity.common.internal.request.AcquireTokenOperationParameters;
import com.microsoft.identity.common.internal.request.OperationParameters;

public class PublicClientApplication$5
  implements Runnable
{
  public PublicClientApplication$5(PublicClientApplication paramPublicClientApplication, AcquireTokenParameters paramAcquireTokenParameters, String paramString) {}
  
  public void run()
  {
    final CommandCallback localCommandCallback = this$0.getCommandCallback(val$acquireTokenParameters.getCallback(), val$acquireTokenParameters);
    try
    {
      this$0.validateAcquireTokenParameters(val$acquireTokenParameters);
      val$acquireTokenParameters.setAccountRecord(PublicClientApplication.access$000(this$0, this$0.mPublicClientConfiguration, val$acquireTokenParameters));
      AcquireTokenOperationParameters localAcquireTokenOperationParameters = OperationParametersAdapter.createAcquireTokenOperationParameters(val$acquireTokenParameters, this$0.mPublicClientConfiguration, this$0.mPublicClientConfiguration.getOAuth2TokenCache());
      InteractiveTokenCommand localInteractiveTokenCommand = new com/microsoft/identity/common/internal/controllers/InteractiveTokenCommand;
      localInteractiveTokenCommand.<init>(localAcquireTokenOperationParameters, MSALControllerFactory.getDefaultController(this$0.mPublicClientConfiguration.getAppContext(), localAcquireTokenOperationParameters.getAuthority(), this$0.mPublicClientConfiguration), localCommandCallback);
      localInteractiveTokenCommand.setPublicApiId(val$publicApiId);
      CommandDispatcher.beginInteractive(localInteractiveTokenCommand);
    }
    catch (Exception localException)
    {
      final BaseException localBaseException = ExceptionAdapter.baseExceptionFromException(localException);
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public void run()
        {
          localCommandCallback.onError(localBaseException);
        }
      });
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.PublicClientApplication.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */