package com.microsoft.azure.sdk.iot.device.edge;

import com.microsoft.azure.sdk.iot.device.hsm.HttpsHsmClient;
import com.microsoft.azure.sdk.iot.device.hsm.parser.TrustBundleResponse;

public class HttpsHsmTrustBundleProvider
  implements TrustBundleProvider
{
  public String getTrustBundleCerts(String paramString1, String paramString2)
  {
    return new HttpsHsmClient(paramString1).getTrustBundle(paramString2).getCertificates();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.edge.HttpsHsmTrustBundleProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */