package com.microsoft.identity.client;

import android.content.Context;
import android.content.res.Resources;
import com.google.gson.Gson;
import com.microsoft.identity.client.internal.MsalUtils;
import com.microsoft.identity.client.internal.configuration.LogLevelDeserializer;
import com.microsoft.identity.common.internal.authorities.Authority;
import com.microsoft.identity.common.internal.authorities.AuthorityDeserializer;
import com.microsoft.identity.common.internal.authorities.AzureActiveDirectoryAudience;
import com.microsoft.identity.common.internal.authorities.AzureActiveDirectoryAudienceDeserializer;
import com.microsoft.identity.common.internal.cache.MsalOAuth2TokenCache;
import com.microsoft.identity.msal.R.raw;
import e.a.a.a.a;
import e.c.c.e;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class PublicClientApplicationConfigurationFactory
{
  public static final String TAG = "PublicClientApplicationConfigurationFactory";
  
  public static Gson getGsonForLoadingConfiguration()
  {
    e locale = new e();
    locale.a(Authority.class, new AuthorityDeserializer());
    locale.a(AzureActiveDirectoryAudience.class, new AzureActiveDirectoryAudienceDeserializer());
    locale.a(Logger.LogLevel.class, new LogLevelDeserializer());
    return locale.a();
  }
  
  public static PublicClientApplicationConfiguration initializeConfiguration(Context paramContext)
  {
    return initializeConfigurationInternal(paramContext, null);
  }
  
  public static PublicClientApplicationConfiguration initializeConfiguration(Context paramContext, int paramInt)
  {
    return initializeConfigurationInternal(paramContext, loadConfiguration(paramContext, paramInt));
  }
  
  public static PublicClientApplicationConfiguration initializeConfiguration(Context paramContext, File paramFile)
  {
    MsalUtils.validateNonNullArgument(paramFile, "configFile");
    return initializeConfigurationInternal(paramContext, loadConfiguration(paramFile));
  }
  
  public static PublicClientApplicationConfiguration initializeConfigurationInternal(Context paramContext, PublicClientApplicationConfiguration paramPublicClientApplicationConfiguration)
  {
    MsalUtils.validateNonNullArgument(paramContext, "context");
    PublicClientApplicationConfiguration localPublicClientApplicationConfiguration = loadDefaultConfiguration(paramContext);
    if (paramPublicClientApplicationConfiguration != null)
    {
      localPublicClientApplicationConfiguration.mergeConfiguration(paramPublicClientApplicationConfiguration);
      localPublicClientApplicationConfiguration.validateConfiguration();
    }
    localPublicClientApplicationConfiguration.setOAuth2TokenCache(MsalOAuth2TokenCache.create(paramContext));
    return localPublicClientApplicationConfiguration;
  }
  
  public static PublicClientApplicationConfiguration loadConfiguration(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getResources().openRawResource(paramInt);
    boolean bool;
    if (paramInt == R.raw.msal_default_config) {
      bool = true;
    } else {
      bool = false;
    }
    return loadConfiguration(paramContext, bool);
  }
  
  public static PublicClientApplicationConfiguration loadConfiguration(File paramFile)
  {
    try
    {
      Object localObject = new java/io/FileInputStream;
      ((FileInputStream)localObject).<init>(paramFile);
      localObject = loadConfiguration((InputStream)localObject, false);
      return (PublicClientApplicationConfiguration)localObject;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      StringBuilder localStringBuilder = a.a("Provided configuration file path=");
      localStringBuilder.append(paramFile.getPath());
      localStringBuilder.append(" not found.");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
  }
  
  /* Error */
  public static PublicClientApplicationConfiguration loadConfiguration(InputStream paramInputStream, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 149	java/io/InputStream:available	()I
    //   4: newarray <illegal type>
    //   6: astore_2
    //   7: aload_0
    //   8: aload_2
    //   9: invokevirtual 153	java/io/InputStream:read	([B)I
    //   12: pop
    //   13: aload_0
    //   14: invokevirtual 156	java/io/InputStream:close	()V
    //   17: goto +45 -> 62
    //   20: astore_0
    //   21: iload_1
    //   22: ifeq +23 -> 45
    //   25: new 128	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   32: getstatic 159	com/microsoft/identity/client/PublicClientApplicationConfigurationFactory:TAG	Ljava/lang/String;
    //   35: ldc -96
    //   37: ldc -94
    //   39: invokestatic 166	e/a/a/a/a:c	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   42: goto +20 -> 62
    //   45: new 128	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   52: getstatic 159	com/microsoft/identity/client/PublicClientApplicationConfigurationFactory:TAG	Ljava/lang/String;
    //   55: ldc -96
    //   57: ldc -88
    //   59: invokestatic 166	e/a/a/a/a:c	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   62: new 170	java/lang/String
    //   65: dup
    //   66: aload_2
    //   67: invokespecial 173	java/lang/String:<init>	([B)V
    //   70: astore_0
    //   71: invokestatic 175	com/microsoft/identity/client/PublicClientApplicationConfigurationFactory:getGsonForLoadingConfiguration	()Lcom/google/gson/Gson;
    //   74: aload_0
    //   75: ldc 68
    //   77: invokevirtual 180	com/google/gson/Gson:a	(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;
    //   80: astore_0
    //   81: ldc 68
    //   83: invokestatic 185	e/c/c/w/t:a	(Ljava/lang/Class;)Ljava/lang/Class;
    //   86: aload_0
    //   87: invokevirtual 191	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   90: checkcast 68	com/microsoft/identity/client/PublicClientApplicationConfiguration
    //   93: areturn
    //   94: astore_2
    //   95: goto +34 -> 129
    //   98: astore_2
    //   99: iload_1
    //   100: ifeq +16 -> 116
    //   103: new 193	java/lang/IllegalStateException
    //   106: astore_3
    //   107: aload_3
    //   108: ldc -61
    //   110: aload_2
    //   111: invokespecial 198	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   114: aload_3
    //   115: athrow
    //   116: new 135	java/lang/IllegalArgumentException
    //   119: astore_3
    //   120: aload_3
    //   121: ldc -56
    //   123: aload_2
    //   124: invokespecial 201	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   127: aload_3
    //   128: athrow
    //   129: aload_0
    //   130: invokevirtual 156	java/io/InputStream:close	()V
    //   133: goto +45 -> 178
    //   136: astore_0
    //   137: iload_1
    //   138: ifeq +23 -> 161
    //   141: new 128	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   148: getstatic 159	com/microsoft/identity/client/PublicClientApplicationConfigurationFactory:TAG	Ljava/lang/String;
    //   151: ldc -96
    //   153: ldc -94
    //   155: invokestatic 166	e/a/a/a/a:c	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   158: goto +20 -> 178
    //   161: new 128	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   168: getstatic 159	com/microsoft/identity/client/PublicClientApplicationConfigurationFactory:TAG	Ljava/lang/String;
    //   171: ldc -96
    //   173: ldc -88
    //   175: invokestatic 166	e/a/a/a/a:c	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   178: aload_2
    //   179: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	paramInputStream	InputStream
    //   0	180	1	paramBoolean	boolean
    //   6	61	2	arrayOfByte	byte[]
    //   94	1	2	localObject1	Object
    //   98	81	2	localIOException	java.io.IOException
    //   106	22	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   13	17	20	java/io/IOException
    //   0	13	94	finally
    //   103	116	94	finally
    //   116	129	94	finally
    //   0	13	98	java/io/IOException
    //   129	133	136	java/io/IOException
  }
  
  public static PublicClientApplicationConfiguration loadDefaultConfiguration(Context paramContext)
  {
    a.b(new StringBuilder(), TAG, ":loadDefaultConfiguration", "Loading default configuration");
    PublicClientApplicationConfiguration localPublicClientApplicationConfiguration = loadConfiguration(paramContext, R.raw.msal_default_config);
    localPublicClientApplicationConfiguration.setAppContext(paramContext);
    return localPublicClientApplicationConfiguration;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.PublicClientApplicationConfigurationFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */