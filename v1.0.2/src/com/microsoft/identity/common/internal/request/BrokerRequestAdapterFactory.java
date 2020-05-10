package com.microsoft.identity.common.internal.request;

import android.os.Bundle;
import com.microsoft.identity.common.internal.logging.Logger;

public class BrokerRequestAdapterFactory
{
  public static final String TAG = "com.microsoft.identity.common.internal.request.BrokerRequestAdapterFactory";
  
  public static IBrokerRequestAdapter getBrokerRequestAdapter(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.containsKey("broker_request_v2")))
    {
      paramBundle = new StringBuilder();
      paramBundle.append(TAG);
      paramBundle.append(":getBrokerRequestAdapter");
      Logger.info(paramBundle.toString(), "Request from MSAL, returning MsalBrokerRequestAdapter");
      return new MsalBrokerRequestAdapter();
    }
    paramBundle = new StringBuilder();
    paramBundle.append(TAG);
    paramBundle.append(":getBrokerRequestAdapter");
    Logger.info(paramBundle.toString(), "Request from ADAL, returning AdalBrokerRequestAdapter");
    return new AdalBrokerRequestAdapter();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.request.BrokerRequestAdapterFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */