package com.microsoft.identity.common.internal.broker;

import android.content.Context;

public class BrokerData
{
  public final String packageName;
  public final String signatureHash;
  
  public BrokerData(String paramString1, String paramString2)
  {
    packageName = paramString1;
    signatureHash = paramString2;
  }
  
  public static BrokerData getBrokerDataForBrokerApp(Context paramContext, String paramString)
  {
    return new BrokerData(paramString, new BrokerValidator(paramContext).verifySignatureAndThrow(paramString));
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.broker.BrokerData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */