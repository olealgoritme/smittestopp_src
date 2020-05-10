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
import com.microsoft.identity.common.internal.controllers.TaskCompletedCallbackWithError;
import com.microsoft.identity.common.internal.controllers.TokenCommand;
import com.microsoft.identity.common.internal.request.AcquireTokenSilentOperationParameters;
import com.microsoft.identity.common.internal.request.OperationParameters;

public class PublicClientApplication$6
  implements Runnable
{
  public PublicClientApplication$6(PublicClientApplication paramPublicClientApplication, AcquireTokenSilentParameters paramAcquireTokenSilentParameters, String paramString) {}
  
  public void run()
  {
    final CommandCallback localCommandCallback = this$0.getCommandCallback(val$acquireTokenSilentParameters.getCallback(), val$acquireTokenSilentParameters);
    try
    {
      this$0.validateAcquireTokenSilentParameters(val$acquireTokenSilentParameters);
      val$acquireTokenSilentParameters.setAccountRecord(PublicClientApplication.access$000(this$0, this$0.mPublicClientConfiguration, val$acquireTokenSilentParameters));
      AcquireTokenSilentOperationParameters localAcquireTokenSilentOperationParameters = OperationParametersAdapter.createAcquireTokenSilentOperationParameters(val$acquireTokenSilentParameters, this$0.mPublicClientConfiguration, this$0.mPublicClientConfiguration.getOAuth2TokenCache());
      TokenCommand localTokenCommand = new com/microsoft/identity/common/internal/controllers/TokenCommand;
      localTokenCommand.<init>(localAcquireTokenSilentOperationParameters, MSALControllerFactory.getAllControllers(this$0.mPublicClientConfiguration.getAppContext(), localAcquireTokenSilentOperationParameters.getAuthority(), this$0.mPublicClientConfiguration), localCommandCallback);
      localTokenCommand.setPublicApiId(val$publicApiId);
      CommandDispatcher.submitSilent(localTokenCommand);
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
 * Qualified Name:     com.microsoft.identity.client.PublicClientApplication.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */