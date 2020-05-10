package com.microsoft.azure.sdk.iot.device.hsm;

import com.microsoft.azure.sdk.iot.device.auth.SignatureProvider;
import com.microsoft.azure.sdk.iot.device.hsm.parser.SignRequest;
import com.microsoft.azure.sdk.iot.device.hsm.parser.SignResponse;
import java.net.URLEncoder;
import javax.crypto.Mac;
import l.f.b;
import l.f.c;

public class HttpHsmSignatureProvider
  implements SignatureProvider
{
  public static final String DEFAULT_KEY_ID = "primary";
  public static final String ENCODING_CHARSET = "UTF-8";
  public static final String MAC = "HmacSHA256";
  public static final b log = c.a(HttpHsmSignatureProvider.class);
  public String apiVersion;
  public Mac defaultSignRequestAlgo = Mac.getInstance("HmacSHA256");
  public HttpsHsmClient httpClient;
  
  public HttpHsmSignatureProvider(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (!paramString1.isEmpty()))
    {
      if ((paramString2 != null) && (!paramString2.isEmpty()))
      {
        log.d("Creating HttpHsmSignatureProvider with providerUri {}", paramString1);
        httpClient = new HttpsHsmClient(paramString1);
        apiVersion = paramString2;
        return;
      }
      throw new IllegalArgumentException("apiVersion cannot be null or empty");
    }
    throw new IllegalArgumentException("provider uri cannot be null or empty");
  }
  
  public String sign(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString2 != null) && (!paramString2.isEmpty()))
    {
      SignRequest localSignRequest = new SignRequest();
      localSignRequest.setAlgo(defaultSignRequestAlgo);
      localSignRequest.setData(paramString2.getBytes("UTF-8"));
      localSignRequest.setKeyId("primary");
      return URLEncoder.encode(httpClient.sign(apiVersion, paramString1, localSignRequest, paramString3).getDigest(), "UTF-8");
    }
    throw new IllegalArgumentException("Data cannot be null or empty");
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.hsm.HttpHsmSignatureProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */