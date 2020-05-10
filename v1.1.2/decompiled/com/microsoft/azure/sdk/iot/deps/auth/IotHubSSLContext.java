package com.microsoft.azure.sdk.iot.deps.auth;

import java.io.IOException;
import java.io.StringReader;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import l.b.a.i2.f;
import l.b.a.n;
import l.b.g.b;
import l.b.g.c;
import l.b.g.e;

public class IotHubSSLContext
{
  public static final String CERTIFICATE_ALIAS = "cert-alias";
  public static final String PRIVATE_KEY_ALIAS = "key-alias";
  public static final String SSL_CONTEXT_INSTANCE = "TLSv1.2";
  public static final String TRUSTED_IOT_HUB_CERT_PREFIX = "trustedIotHubCert-";
  public SSLContext sslContext = null;
  
  public IotHubSSLContext()
  {
    generateDefaultSSLContext(new IotHubCertificateManager());
  }
  
  public IotHubSSLContext(String paramString1, String paramString2)
  {
    generateSSLContextWithKeys(paramString1, paramString2, new IotHubCertificateManager());
  }
  
  public IotHubSSLContext(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    IotHubCertificateManager localIotHubCertificateManager = new IotHubCertificateManager();
    if (paramBoolean) {
      localIotHubCertificateManager.setCertificatesPath(paramString3);
    } else {
      localIotHubCertificateManager.setCertificates(paramString3);
    }
    generateSSLContextWithKeys(paramString1, paramString2, localIotHubCertificateManager);
  }
  
  public IotHubSSLContext(String paramString, boolean paramBoolean)
  {
    IotHubCertificateManager localIotHubCertificateManager = new IotHubCertificateManager();
    if (paramBoolean) {
      localIotHubCertificateManager.setCertificatesPath(paramString);
    } else {
      localIotHubCertificateManager.setCertificates(paramString);
    }
    generateDefaultSSLContext(localIotHubCertificateManager);
  }
  
  public IotHubSSLContext(SSLContext paramSSLContext)
  {
    if (paramSSLContext != null)
    {
      sslContext = paramSSLContext;
      return;
    }
    throw new IllegalArgumentException("sslContext cannot be null");
  }
  
  private void generateDefaultSSLContext(IotHubCertificateManager paramIotHubCertificateManager)
  {
    sslContext = SSLContext.getInstance("TLSv1.2");
    paramIotHubCertificateManager = generateTrustManagerFactory(paramIotHubCertificateManager, null);
    sslContext.init(null, paramIotHubCertificateManager.getTrustManagers(), new SecureRandom());
  }
  
  private void generateSSLContextWithKeys(String paramString1, String paramString2, IotHubCertificateManager paramIotHubCertificateManager)
  {
    paramString2 = parsePrivateKey(paramString2);
    paramString1 = parsePublicKeyCertificate(paramString1);
    X509Certificate[] arrayOfX509Certificate = (X509Certificate[])paramString1.toArray(new X509Certificate[paramString1.size()]);
    char[] arrayOfChar = generateTemporaryPassword();
    paramString1 = KeyStore.getInstance(KeyStore.getDefaultType());
    paramString1.load(null);
    paramString1.setCertificateEntry("cert-alias", arrayOfX509Certificate[0]);
    paramString1.setKeyEntry("key-alias", paramString2, arrayOfChar, arrayOfX509Certificate);
    paramString2 = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
    paramString2.init(paramString1, arrayOfChar);
    Arrays.fill(arrayOfChar, 0, arrayOfChar.length, '0');
    paramString1 = generateTrustManagerFactory(paramIotHubCertificateManager, paramString1);
    paramIotHubCertificateManager = SSLContext.getInstance("TLSv1.2");
    sslContext = paramIotHubCertificateManager;
    paramIotHubCertificateManager.init(paramString2.getKeyManagers(), paramString1.getTrustManagers(), new SecureRandom());
  }
  
  private char[] generateTemporaryPassword()
  {
    byte[] arrayOfByte = new byte['Ā'];
    char[] arrayOfChar = new char['Ā'];
    new SecureRandom().nextBytes(arrayOfByte);
    for (int i = 0; i < 256; i++) {
      arrayOfChar[i] = ((char)(char)arrayOfByte[i]);
    }
    return arrayOfChar;
  }
  
  private TrustManagerFactory generateTrustManagerFactory(IotHubCertificateManager paramIotHubCertificateManager, KeyStore paramKeyStore)
  {
    KeyStore localKeyStore = paramKeyStore;
    if (paramKeyStore == null)
    {
      localKeyStore = KeyStore.getInstance(KeyStore.getDefaultType());
      localKeyStore.load(null);
    }
    paramIotHubCertificateManager = paramIotHubCertificateManager.getCertificateCollection().iterator();
    while (paramIotHubCertificateManager.hasNext())
    {
      paramKeyStore = (Certificate)paramIotHubCertificateManager.next();
      StringBuilder localStringBuilder = e.a.a.a.a.a("trustedIotHubCert-");
      localStringBuilder.append(UUID.randomUUID());
      localKeyStore.setCertificateEntry(localStringBuilder.toString(), paramKeyStore);
    }
    paramIotHubCertificateManager = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    paramIotHubCertificateManager.init(localKeyStore);
    return paramIotHubCertificateManager;
  }
  
  public static Key getPrivateKey(Object paramObject)
  {
    Object localObject3;
    if ((paramObject instanceof c))
    {
      Object localObject1 = new l.b.g.g.a();
      paramObject = (c)paramObject;
      try
      {
        localObject1 = ((l.b.g.g.a)localObject1).a(b.y);
        localObject3 = new java/security/spec/X509EncodedKeySpec;
        ((X509EncodedKeySpec)localObject3).<init>(a.e());
        localObject3 = ((KeyFactory)localObject1).generatePublic((KeySpec)localObject3);
        PKCS8EncodedKeySpec localPKCS8EncodedKeySpec = new java/security/spec/PKCS8EncodedKeySpec;
        localPKCS8EncodedKeySpec.<init>(b.e());
        paramObject = new KeyPair((PublicKey)localObject3, ((KeyFactory)localObject1).generatePrivate(localPKCS8EncodedKeySpec));
        return ((KeyPair)paramObject).getPrivate();
      }
      catch (Exception localException1)
      {
        paramObject = e.a.a.a.a.a("unable to convert key pair: ");
        ((StringBuilder)paramObject).append(localException1.getMessage());
        throw new b(((StringBuilder)paramObject).toString(), localException1);
      }
    }
    if ((paramObject instanceof f))
    {
      Object localObject2 = new l.b.g.g.a();
      paramObject = (f)paramObject;
      try
      {
        localObject3 = ((l.b.g.g.a)localObject2).a(y);
        localObject2 = new java/security/spec/PKCS8EncodedKeySpec;
        ((PKCS8EncodedKeySpec)localObject2).<init>(((n)paramObject).e());
        paramObject = ((KeyFactory)localObject3).generatePrivate((KeySpec)localObject2);
        return (Key)paramObject;
      }
      catch (Exception localException2)
      {
        paramObject = e.a.a.a.a.a("unable to convert key pair: ");
        ((StringBuilder)paramObject).append(localException2.getMessage());
        throw new b(((StringBuilder)paramObject).toString(), localException2);
      }
    }
    throw new IOException("Unable to parse private key, type unknown");
  }
  
  public static Key parsePrivateKey(String paramString)
  {
    try
    {
      Object localObject = new l/b/e/a/a;
      ((l.b.e.a.a)localObject).<init>();
      Security.addProvider((Provider)localObject);
      localObject = new l/b/g/e;
      StringReader localStringReader = new java/io/StringReader;
      localStringReader.<init>(paramString);
      ((e)localObject).<init>(localStringReader);
      paramString = getPrivateKey(((e)localObject).readObject());
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new CertificateException(paramString);
    }
  }
  
  /* Error */
  public static Collection<X509Certificate> parsePublicKeyCertificate(String paramString)
  {
    // Byte code:
    //   0: new 300	java/util/ArrayList
    //   3: astore_1
    //   4: aload_1
    //   5: invokespecial 301	java/util/ArrayList:<init>	()V
    //   8: new 273	l/b/e/a/a
    //   11: astore_2
    //   12: aload_2
    //   13: invokespecial 274	l/b/e/a/a:<init>	()V
    //   16: aload_2
    //   17: invokestatic 280	java/security/Security:addProvider	(Ljava/security/Provider;)I
    //   20: pop
    //   21: ldc_w 303
    //   24: invokestatic 308	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   27: astore_3
    //   28: new 310	l/b/j/h/b/d
    //   31: astore_2
    //   32: new 284	java/io/StringReader
    //   35: astore 4
    //   37: aload 4
    //   39: aload_0
    //   40: invokespecial 285	java/io/StringReader:<init>	(Ljava/lang/String;)V
    //   43: aload_2
    //   44: aload 4
    //   46: invokespecial 311	l/b/j/h/b/d:<init>	(Ljava/io/Reader;)V
    //   49: aload_2
    //   50: invokevirtual 314	l/b/j/h/b/d:a	()Ll/b/j/h/b/b;
    //   53: astore_0
    //   54: aload_0
    //   55: ifnull +60 -> 115
    //   58: aload_0
    //   59: getfield 320	l/b/j/h/b/b:c	[B
    //   62: astore 4
    //   64: aload 4
    //   66: arraylength
    //   67: ifle +48 -> 115
    //   70: new 322	java/io/ByteArrayInputStream
    //   73: astore_0
    //   74: aload_0
    //   75: aload 4
    //   77: invokespecial 323	java/io/ByteArrayInputStream:<init>	([B)V
    //   80: aload_0
    //   81: invokevirtual 326	java/io/ByteArrayInputStream:available	()I
    //   84: ifle -35 -> 49
    //   87: aload_3
    //   88: aload_0
    //   89: invokevirtual 330	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   92: astore 4
    //   94: aload 4
    //   96: instanceof 93
    //   99: ifeq -19 -> 80
    //   102: aload_1
    //   103: aload 4
    //   105: checkcast 93	java/security/cert/X509Certificate
    //   108: invokevirtual 334	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   111: pop
    //   112: goto -32 -> 80
    //   115: aload_2
    //   116: invokevirtual 339	java/io/BufferedReader:close	()V
    //   119: aload_1
    //   120: areturn
    //   121: astore_0
    //   122: aload_2
    //   123: invokevirtual 339	java/io/BufferedReader:close	()V
    //   126: aload_0
    //   127: athrow
    //   128: astore_0
    //   129: new 295	java/security/cert/CertificateException
    //   132: dup
    //   133: aload_0
    //   134: invokespecial 298	java/security/cert/CertificateException:<init>	(Ljava/lang/Throwable;)V
    //   137: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	paramString	String
    //   3	117	1	localArrayList	java.util.ArrayList
    //   11	112	2	localObject1	Object
    //   27	61	3	localCertificateFactory	java.security.cert.CertificateFactory
    //   35	69	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   49	54	121	finally
    //   58	80	121	finally
    //   80	112	121	finally
    //   0	49	128	java/lang/Exception
    //   115	119	128	java/lang/Exception
    //   122	128	128	java/lang/Exception
  }
  
  public SSLContext getSSLContext()
  {
    return sslContext;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.auth.IotHubSSLContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */