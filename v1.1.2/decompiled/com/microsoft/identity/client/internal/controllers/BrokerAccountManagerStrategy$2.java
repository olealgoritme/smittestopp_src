package com.microsoft.identity.client.internal.controllers;

import android.content.Intent;
import android.os.Bundle;
import com.microsoft.identity.common.internal.request.AcquireTokenOperationParameters;

public class BrokerAccountManagerStrategy$2
  implements BrokerAccountManagerStrategy.OperationInfo<AcquireTokenOperationParameters, Intent>
{
  public BrokerAccountManagerStrategy$2(BrokerAccountManagerStrategy paramBrokerAccountManagerStrategy, AcquireTokenOperationParameters paramAcquireTokenOperationParameters) {}
  
  public String getMethodName()
  {
    return ":getBrokerAuthorizationIntent";
  }
  
  public Bundle getRequestBundle(AcquireTokenOperationParameters paramAcquireTokenOperationParameters)
  {
    paramAcquireTokenOperationParameters = new Bundle();
    paramAcquireTokenOperationParameters.putString("com.microsoft.broker_accountmanager_operation_key", "GET_INTENT_FOR_INTERACTIVE_REQUEST");
    return paramAcquireTokenOperationParameters;
  }
  
  public Intent getResultFromBundle(Bundle paramBundle)
  {
    paramBundle = (Intent)paramBundle.getParcelable("intent");
    return this$0.completeInteractiveRequestIntent(paramBundle, val$parameters);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.internal.controllers.BrokerAccountManagerStrategy.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */