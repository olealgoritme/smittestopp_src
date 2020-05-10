package com.microsoft.azure.sdk.iot.device.hsm.parser;

import com.google.gson.Gson;
import e.c.c.e;
import e.c.c.v.a;
import e.c.c.v.c;
import e.c.c.w.t;

public class TrustBundleResponse
{
  public static final String CERTIFICATE_NAME = "certificate";
  @a(deserialize=true, serialize=false)
  @c("certificate")
  public String certificates;
  
  public static TrustBundleResponse fromJson(String paramString)
  {
    paramString = new e().a().a(paramString, TrustBundleResponse.class);
    TrustBundleResponse localTrustBundleResponse = (TrustBundleResponse)t.a(TrustBundleResponse.class).cast(paramString);
    if (localTrustBundleResponse != null)
    {
      paramString = certificates;
      if ((paramString != null) && (!paramString.isEmpty())) {
        return localTrustBundleResponse;
      }
    }
    throw new IllegalArgumentException("The provided json did not contain any certificates");
  }
  
  public String getCertificates()
  {
    return certificates;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.hsm.parser.TrustBundleResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */