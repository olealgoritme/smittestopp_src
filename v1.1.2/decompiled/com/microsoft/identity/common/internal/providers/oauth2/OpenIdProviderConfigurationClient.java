package com.microsoft.identity.common.internal.providers.oauth2;

import android.net.Uri;
import android.net.Uri.Builder;
import com.google.gson.Gson;
import com.microsoft.identity.common.exception.ServiceException;
import com.microsoft.identity.common.internal.controllers.TaskCompletedCallback;
import com.microsoft.identity.common.internal.controllers.TaskCompletedCallbackWithError;
import e.c.c.w.t;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OpenIdProviderConfigurationClient
{
  public static final String TAG = "OpenIdProviderConfigurationClient";
  public static final ExecutorService sBackgroundExecutor = ;
  public static final Map<URL, OpenIdProviderConfiguration> sConfigCache = new HashMap();
  public static final String sWellKnownConfig = "/.well-known/openid-configuration";
  public final Gson mGson = new Gson();
  public final String mIssuer;
  
  public OpenIdProviderConfigurationClient(String paramString)
  {
    mIssuer = Uri.parse(sanitize(paramString)).toString();
  }
  
  public OpenIdProviderConfigurationClient(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, "");
  }
  
  public OpenIdProviderConfigurationClient(String paramString1, String paramString2, String paramString3)
  {
    mIssuer = new Uri.Builder().scheme("https").authority(paramString1).appendPath(paramString2).appendPath(paramString3).build().toString();
  }
  
  private void cacheConfiguration(URL paramURL, OpenIdProviderConfiguration paramOpenIdProviderConfiguration)
  {
    sConfigCache.put(paramURL, paramOpenIdProviderConfiguration);
  }
  
  private OpenIdProviderConfiguration parseMetadata(String paramString)
  {
    paramString = mGson.a(paramString, OpenIdProviderConfiguration.class);
    return (OpenIdProviderConfiguration)t.a(OpenIdProviderConfiguration.class).cast(paramString);
  }
  
  private String sanitize(String paramString)
  {
    String str1 = paramString.trim();
    String str2 = str1;
    if (paramString.endsWith("/")) {
      str2 = paramString.substring(0, str1.length() - 1);
    }
    return str2;
  }
  
  /* Error */
  public OpenIdProviderConfiguration loadOpenIdProviderConfiguration()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 142	java/net/URL
    //   5: astore_1
    //   6: new 144	java/lang/StringBuilder
    //   9: astore_2
    //   10: aload_2
    //   11: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   14: aload_2
    //   15: aload_0
    //   16: getfield 65	com/microsoft/identity/common/internal/providers/oauth2/OpenIdProviderConfigurationClient:mIssuer	Ljava/lang/String;
    //   19: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload_2
    //   24: ldc 21
    //   26: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload_1
    //   31: aload_2
    //   32: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokespecial 152	java/net/URL:<init>	(Ljava/lang/String;)V
    //   38: getstatic 41	com/microsoft/identity/common/internal/providers/oauth2/OpenIdProviderConfigurationClient:sConfigCache	Ljava/util/Map;
    //   41: aload_1
    //   42: invokeinterface 155 2 0
    //   47: checkcast 102	com/microsoft/identity/common/internal/providers/oauth2/OpenIdProviderConfiguration
    //   50: astore_2
    //   51: aload_2
    //   52: ifnull +39 -> 91
    //   55: new 144	java/lang/StringBuilder
    //   58: astore_1
    //   59: aload_1
    //   60: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   63: aload_1
    //   64: getstatic 157	com/microsoft/identity/common/internal/providers/oauth2/OpenIdProviderConfigurationClient:TAG	Ljava/lang/String;
    //   67: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload_1
    //   72: ldc -97
    //   74: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload_1
    //   79: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: ldc -95
    //   84: invokestatic 166	com/microsoft/identity/common/internal/logging/Logger:info	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_2
    //   90: areturn
    //   91: new 144	java/lang/StringBuilder
    //   94: astore_2
    //   95: aload_2
    //   96: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   99: aload_2
    //   100: getstatic 157	com/microsoft/identity/common/internal/providers/oauth2/OpenIdProviderConfigurationClient:TAG	Ljava/lang/String;
    //   103: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload_2
    //   108: ldc -97
    //   110: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload_2
    //   115: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: ldc -88
    //   120: invokestatic 171	com/microsoft/identity/common/internal/logging/Logger:verbose	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: new 144	java/lang/StringBuilder
    //   126: astore_2
    //   127: aload_2
    //   128: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   131: aload_2
    //   132: getstatic 157	com/microsoft/identity/common/internal/providers/oauth2/OpenIdProviderConfigurationClient:TAG	Ljava/lang/String;
    //   135: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload_2
    //   140: ldc -97
    //   142: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload_2
    //   147: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: astore_3
    //   151: new 144	java/lang/StringBuilder
    //   154: astore_2
    //   155: aload_2
    //   156: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   159: aload_2
    //   160: ldc -83
    //   162: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload_2
    //   167: aload_1
    //   168: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload_3
    //   173: aload_2
    //   174: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 179	com/microsoft/identity/common/internal/logging/Logger:verbosePII	(Ljava/lang/String;Ljava/lang/String;)V
    //   180: new 36	java/util/HashMap
    //   183: astore_2
    //   184: aload_2
    //   185: invokespecial 39	java/util/HashMap:<init>	()V
    //   188: aload_1
    //   189: aload_2
    //   190: invokestatic 185	com/microsoft/identity/common/internal/net/HttpRequest:sendGet	(Ljava/net/URL;Ljava/util/Map;)Lcom/microsoft/identity/common/internal/net/HttpResponse;
    //   193: astore_2
    //   194: aload_2
    //   195: invokevirtual 190	com/microsoft/identity/common/internal/net/HttpResponse:getStatusCode	()I
    //   198: istore 4
    //   200: sipush 200
    //   203: iload 4
    //   205: if_icmpne +32 -> 237
    //   208: aload_2
    //   209: invokevirtual 193	com/microsoft/identity/common/internal/net/HttpResponse:getBody	()Ljava/lang/String;
    //   212: invokestatic 199	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   215: ifne +22 -> 237
    //   218: aload_0
    //   219: aload_2
    //   220: invokevirtual 193	com/microsoft/identity/common/internal/net/HttpResponse:getBody	()Ljava/lang/String;
    //   223: invokespecial 201	com/microsoft/identity/common/internal/providers/oauth2/OpenIdProviderConfigurationClient:parseMetadata	(Ljava/lang/String;)Lcom/microsoft/identity/common/internal/providers/oauth2/OpenIdProviderConfiguration;
    //   226: astore_2
    //   227: aload_0
    //   228: aload_1
    //   229: aload_2
    //   230: invokespecial 203	com/microsoft/identity/common/internal/providers/oauth2/OpenIdProviderConfigurationClient:cacheConfiguration	(Ljava/net/URL;Lcom/microsoft/identity/common/internal/providers/oauth2/OpenIdProviderConfiguration;)V
    //   233: aload_0
    //   234: monitorexit
    //   235: aload_2
    //   236: areturn
    //   237: new 205	com/microsoft/identity/common/exception/ServiceException
    //   240: astore_2
    //   241: new 144	java/lang/StringBuilder
    //   244: astore_1
    //   245: aload_1
    //   246: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   249: aload_1
    //   250: ldc -49
    //   252: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: aload_1
    //   257: iload 4
    //   259: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload_2
    //   264: ldc -44
    //   266: aload_1
    //   267: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: aconst_null
    //   271: invokespecial 215	com/microsoft/identity/common/exception/ServiceException:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   274: aload_2
    //   275: athrow
    //   276: astore_1
    //   277: goto +19 -> 296
    //   280: astore_1
    //   281: new 205	com/microsoft/identity/common/exception/ServiceException
    //   284: astore_2
    //   285: aload_2
    //   286: ldc -44
    //   288: ldc -39
    //   290: aload_1
    //   291: invokespecial 215	com/microsoft/identity/common/exception/ServiceException:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   294: aload_2
    //   295: athrow
    //   296: aload_0
    //   297: monitorexit
    //   298: aload_1
    //   299: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	300	0	this	OpenIdProviderConfigurationClient
    //   5	262	1	localObject1	Object
    //   276	1	1	localObject2	Object
    //   280	19	1	localIOException	java.io.IOException
    //   9	286	2	localObject3	Object
    //   150	23	3	str	String
    //   198	60	4	i	int
    // Exception table:
    //   from	to	target	type
    //   2	51	276	finally
    //   55	87	276	finally
    //   91	200	276	finally
    //   208	233	276	finally
    //   237	276	276	finally
    //   281	296	276	finally
    //   2	51	280	java/io/IOException
    //   55	87	280	java/io/IOException
    //   91	200	280	java/io/IOException
    //   208	233	280	java/io/IOException
    //   237	276	280	java/io/IOException
  }
  
  public void loadOpenIdProviderConfiguration(final OpenIdProviderConfigurationCallback paramOpenIdProviderConfigurationCallback)
  {
    sBackgroundExecutor.submit(new Runnable()
    {
      public void run()
      {
        try
        {
          paramOpenIdProviderConfigurationCallback.onTaskCompleted(loadOpenIdProviderConfiguration());
        }
        catch (ServiceException localServiceException)
        {
          paramOpenIdProviderConfigurationCallback.onError(localServiceException);
        }
      }
    });
  }
  
  public static abstract interface OpenIdProviderConfigurationCallback
    extends TaskCompletedCallbackWithError<OpenIdProviderConfiguration, Exception>
  {}
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.oauth2.OpenIdProviderConfigurationClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */