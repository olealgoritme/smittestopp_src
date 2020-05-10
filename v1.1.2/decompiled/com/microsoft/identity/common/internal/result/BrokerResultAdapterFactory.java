package com.microsoft.identity.common.internal.result;

import com.microsoft.identity.common.internal.request.SdkType;

public class BrokerResultAdapterFactory
{
  public static IBrokerResultAdapter getBrokerResultAdapter(SdkType paramSdkType)
  {
    if (paramSdkType == SdkType.ADAL) {
      return new AdalBrokerResultAdapter();
    }
    return new MsalBrokerResultAdapter();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.result.BrokerResultAdapterFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */