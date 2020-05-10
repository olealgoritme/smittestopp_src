package com.microsoft.azure.sdk.iot.device.hsm;

import com.microsoft.azure.sdk.iot.device.hsm.parser.ErrorResponse;
import com.microsoft.azure.sdk.iot.device.hsm.parser.SignRequest;
import com.microsoft.azure.sdk.iot.device.hsm.parser.SignResponse;
import com.microsoft.azure.sdk.iot.device.hsm.parser.TrustBundleResponse;
import com.microsoft.azure.sdk.iot.device.transport.https.HttpsMethod;
import com.microsoft.azure.sdk.iot.device.transport.https.HttpsRequest;
import com.microsoft.azure.sdk.iot.device.transport.https.HttpsResponse;
import e.a.a.a.a;
import g.e.i;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import k.f.b;
import k.f.c;

public class HttpsHsmClient
{
  public static final String API_VERSION_QUERY_STRING_PREFIX = "api-version=";
  public static final String HTTPS_SCHEME = "https";
  public static final String HTTP_SCHEME = "http";
  public static final String UNIX_SCHEME = "unix";
  public static final b log = c.a(HttpsHsmClient.class);
  public String baseUrl;
  public String scheme;
  
  public HttpsHsmClient(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      log.d("Creating HttpsHsmClient with base url {}", paramString);
      baseUrl = paramString;
      scheme = new URI(paramString).getScheme();
      return;
    }
    throw new IllegalArgumentException("baseUrl cannot be null");
  }
  
  private String readResponseFromChannel(i parami)
  {
    log.b("Reading response from unix socket channel...");
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(10);
    Object localObject1 = "";
    int i = 0;
    if (i >= 0)
    {
      localByteBuffer.rewind();
      int j = parami.read(localByteBuffer);
      localByteBuffer.rewind();
      int k = 0;
      Object localObject2 = localObject1;
      for (;;)
      {
        localObject1 = localObject2;
        i = j;
        if (k >= j) {
          break;
        }
        localObject2 = a.a((String)localObject2);
        int m = localByteBuffer.get();
        localObject1 = StandardCharsets.US_ASCII;
        ((StringBuilder)localObject2).append(new String(new byte[] { m }, (Charset)localObject1));
        localObject2 = ((StringBuilder)localObject2).toString();
        k++;
      }
    }
    return (String)localObject1;
  }
  
  /* Error */
  private HttpsResponse sendHttpRequestUsingUnixSocket(HttpsRequest paramHttpsRequest, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: getstatic 31	com/microsoft/azure/sdk/iot/device/hsm/HttpsHsmClient:log	Lk/f/b;
    //   3: ldc 124
    //   5: invokeinterface 74 2 0
    //   10: aconst_null
    //   11: astore 5
    //   13: aload_1
    //   14: aload_2
    //   15: aload_3
    //   16: aload 4
    //   18: invokestatic 130	com/microsoft/azure/sdk/iot/device/hsm/HttpsRequestResponseSerializer:serializeRequest	(Lcom/microsoft/azure/sdk/iot/device/transport/https/HttpsRequest;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)[B
    //   21: astore_3
    //   22: new 132	g/e/h
    //   25: astore 6
    //   27: aload 6
    //   29: aload 4
    //   31: invokespecial 133	g/e/h:<init>	(Ljava/lang/String;)V
    //   34: new 88	g/e/i
    //   37: astore_2
    //   38: aload_2
    //   39: invokespecial 134	g/e/i:<init>	()V
    //   42: aload_2
    //   43: aload 6
    //   45: invokevirtual 137	g/e/i:a	(Lg/e/h;)Z
    //   48: pop
    //   49: aload_1
    //   50: invokevirtual 143	com/microsoft/azure/sdk/iot/device/transport/https/HttpsRequest:getBody	()[B
    //   53: ifnull +44 -> 97
    //   56: new 145	java/io/ByteArrayOutputStream
    //   59: astore 4
    //   61: aload 4
    //   63: invokespecial 146	java/io/ByteArrayOutputStream:<init>	()V
    //   66: aload 4
    //   68: aload_3
    //   69: invokevirtual 150	java/io/ByteArrayOutputStream:write	([B)V
    //   72: aload 4
    //   74: aload_1
    //   75: invokevirtual 143	com/microsoft/azure/sdk/iot/device/transport/https/HttpsRequest:getBody	()[B
    //   78: invokevirtual 150	java/io/ByteArrayOutputStream:write	([B)V
    //   81: aload_2
    //   82: aload 4
    //   84: invokevirtual 153	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   87: invokestatic 157	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   90: invokevirtual 159	g/e/i:write	(Ljava/nio/ByteBuffer;)I
    //   93: pop
    //   94: goto +12 -> 106
    //   97: aload_2
    //   98: aload_3
    //   99: invokestatic 157	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   102: invokevirtual 159	g/e/i:write	(Ljava/nio/ByteBuffer;)I
    //   105: pop
    //   106: aload_0
    //   107: aload_2
    //   108: invokespecial 161	com/microsoft/azure/sdk/iot/device/hsm/HttpsHsmClient:readResponseFromChannel	(Lg/e/i;)Ljava/lang/String;
    //   111: astore 4
    //   113: new 163	java/io/BufferedReader
    //   116: astore_1
    //   117: new 165	java/io/StringReader
    //   120: astore_3
    //   121: aload_3
    //   122: aload 4
    //   124: invokespecial 166	java/io/StringReader:<init>	(Ljava/lang/String;)V
    //   127: aload_1
    //   128: aload_3
    //   129: invokespecial 169	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   132: aload_1
    //   133: invokestatic 173	com/microsoft/azure/sdk/iot/device/hsm/HttpsRequestResponseSerializer:deserializeResponse	(Ljava/io/BufferedReader;)Lcom/microsoft/azure/sdk/iot/device/transport/https/HttpsResponse;
    //   136: astore_1
    //   137: getstatic 31	com/microsoft/azure/sdk/iot/device/hsm/HttpsHsmClient:log	Lk/f/b;
    //   140: ldc -81
    //   142: invokeinterface 178 2 0
    //   147: aload_2
    //   148: invokevirtual 183	java/nio/channels/SocketChannel:close	()V
    //   151: aload_1
    //   152: areturn
    //   153: astore_1
    //   154: goto +14 -> 168
    //   157: astore_1
    //   158: aload_2
    //   159: invokevirtual 183	java/nio/channels/SocketChannel:close	()V
    //   162: aload_1
    //   163: athrow
    //   164: astore_1
    //   165: aload 5
    //   167: astore_2
    //   168: aload_2
    //   169: ifnull +17 -> 186
    //   172: getstatic 31	com/microsoft/azure/sdk/iot/device/hsm/HttpsHsmClient:log	Lk/f/b;
    //   175: ldc -81
    //   177: invokeinterface 178 2 0
    //   182: aload_2
    //   183: invokevirtual 183	java/nio/channels/SocketChannel:close	()V
    //   186: aload_1
    //   187: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	HttpsHsmClient
    //   0	188	1	paramHttpsRequest	HttpsRequest
    //   0	188	2	paramString1	String
    //   0	188	3	paramString2	String
    //   0	188	4	paramString3	String
    //   11	155	5	localObject	Object
    //   25	19	6	localh	g.e.h
    // Exception table:
    //   from	to	target	type
    //   49	94	153	finally
    //   97	106	153	finally
    //   106	137	153	finally
    //   42	49	157	java/io/IOException
    //   13	42	164	finally
    //   42	49	164	finally
    //   158	164	164	finally
  }
  
  private HttpsResponse sendRequestBasedOnScheme(HttpsMethod paramHttpsMethod, byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3)
  {
    Object localObject;
    if ((!scheme.equalsIgnoreCase("https")) && (!scheme.equalsIgnoreCase("http")))
    {
      if (scheme.equalsIgnoreCase("unix")) {
        localObject = null;
      } else {
        throw new UnsupportedOperationException("unrecognized URI scheme. Only HTTPS, HTTP and UNIX are supported");
      }
    }
    else if ((paramString3 != null) && (!paramString3.isEmpty()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("?");
      ((StringBuilder)localObject).append(paramString3);
      localObject = new URL(((StringBuilder)localObject).toString());
    }
    else
    {
      localObject = new URL(a.b(paramString1, paramString2));
    }
    paramHttpsMethod = new HttpsRequest((URL)localObject, paramHttpsMethod, paramArrayOfByte, "");
    paramHttpsMethod.setHeaderField("Accept", "application/json");
    if (paramArrayOfByte.length > 0) {
      paramHttpsMethod.setHeaderField("Content-Type", "application/json");
    }
    if ((!scheme.equalsIgnoreCase("https")) && (!scheme.equalsIgnoreCase("http")))
    {
      if (scheme.equalsIgnoreCase("unix")) {
        paramHttpsMethod = sendHttpRequestUsingUnixSocket(paramHttpsMethod, paramString2, paramString3, paramString1.substring(paramString1.indexOf("unix://") + 7));
      } else {
        throw new UnsupportedOperationException("unrecognized URI scheme. Only HTTPS, HTTP and UNIX are supported");
      }
    }
    else {
      paramHttpsMethod = paramHttpsMethod.send();
    }
    return paramHttpsMethod;
  }
  
  public TrustBundleResponse getTrustBundle(String paramString)
  {
    log.b("Getting trust bundle...");
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      Object localObject = baseUrl;
      String str = "";
      if (localObject != null) {
        localObject = ((String)localObject).replaceFirst("/*$", "");
      } else {
        localObject = "";
      }
      HttpsMethod localHttpsMethod = HttpsMethod.GET;
      paramString = a.b("api-version=", paramString);
      localObject = sendRequestBasedOnScheme(localHttpsMethod, new byte[0], (String)localObject, "/trust-bundle", paramString);
      int i = ((HttpsResponse)localObject).getStatus();
      paramString = str;
      if (((HttpsResponse)localObject).getBody() != null) {
        paramString = new String(((HttpsResponse)localObject).getBody());
      }
      if ((i >= 200) && (i < 300)) {
        return TrustBundleResponse.fromJson(paramString);
      }
      paramString = ErrorResponse.fromJson(paramString);
      if (paramString != null)
      {
        localObject = a.a("Received error from hsm with status code ", i, " and message ");
        ((StringBuilder)localObject).append(paramString.getMessage());
        throw new HsmException(((StringBuilder)localObject).toString());
      }
      throw new HsmException(a.a("Received error from hsm with status code ", i));
    }
    throw new IllegalArgumentException("api version cannot be null or empty");
  }
  
  public SignResponse sign(String paramString1, String paramString2, SignRequest paramSignRequest, String paramString3)
  {
    log.b("Sending sign request...");
    Object localObject = baseUrl;
    String str = "";
    if (localObject != null) {
      str = ((String)localObject).replaceFirst("/*$", "");
    }
    localObject = new StringBuilder();
    StringBuilder localStringBuilder = a.a("/modules/");
    localStringBuilder.append(URLEncoder.encode(paramString2, "UTF-8"));
    ((StringBuilder)localObject).append(localStringBuilder.toString());
    paramString2 = new StringBuilder();
    paramString2.append("/genid/");
    paramString2.append(URLEncoder.encode(paramString3, "UTF-8"));
    ((StringBuilder)localObject).append(paramString2.toString());
    ((StringBuilder)localObject).append("/sign");
    paramString2 = paramSignRequest.toJson().getBytes();
    paramString1 = sendRequestBasedOnScheme(HttpsMethod.POST, paramString2, str, ((StringBuilder)localObject).toString(), a.b("api-version=", paramString1));
    int i = paramString1.getStatus();
    paramString1 = new String(paramString1.getBody());
    if ((i >= 200) && (i < 300)) {
      return SignResponse.fromJson(paramString1);
    }
    paramString2 = a.b("HttpsHsmClient received status code ", i, " from provided uri.");
    paramSignRequest = ErrorResponse.fromJson(paramString1);
    paramString1 = paramString2;
    if (paramSignRequest != null)
    {
      paramString1 = a.a(paramString2, " Error response message: ");
      paramString1.append(paramSignRequest.getMessage());
      paramString1 = paramString1.toString();
    }
    throw new HsmException(paramString1);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.hsm.HttpsHsmClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */