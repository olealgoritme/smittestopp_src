package com.microsoft.azure.sdk.iot.provisioning.security;

import com.microsoft.azure.sdk.iot.provisioning.security.exceptions.SecurityProviderException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import l.a.a.a.b.a;
import l.a.a.a.b.c;

public abstract class SecurityProviderTpm
  extends SecurityProvider
{
  public static final String EQUALS = "=";
  public static final String SHA_256 = "SHA-256";
  
  private SSLContext generateSSLContext()
  {
    SSLContext localSSLContext = SSLContext.getInstance("TLSv1.2");
    KeyStore localKeyStore = getKeyStoreWithTrustedCerts();
    TrustManagerFactory localTrustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    localTrustManagerFactory.init(localKeyStore);
    localSSLContext.init(null, localTrustManagerFactory.getTrustManagers(), new SecureRandom());
    return localSSLContext;
  }
  
  public abstract byte[] activateIdentityKey(byte[] paramArrayOfByte);
  
  public abstract byte[] getEndorsementKey();
  
  public String getRegistrationId()
  {
    try
    {
      Object localObject1 = getEndorsementKey();
      localObject1 = MessageDigest.getInstance("SHA-256").digest((byte[])localObject1);
      Object localObject2 = new l/a/a/a/b/a;
      ((a)localObject2).<init>();
      localObject2 = ((c)localObject2).b((byte[])localObject1);
      localObject1 = new java/lang/String;
      ((String)localObject1).<init>((byte[])localObject2);
      localObject2 = ((String)localObject1).toLowerCase();
      localObject1 = localObject2;
      if (((String)localObject2).contains("=")) {
        localObject1 = ((String)localObject2).replace("=", "").toLowerCase();
      }
      return (String)localObject1;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new SecurityProviderException(localNoSuchAlgorithmException);
    }
  }
  
  public SSLContext getSSLContext()
  {
    try
    {
      SSLContext localSSLContext = generateSSLContext();
      return localSSLContext;
    }
    catch (KeyManagementException localKeyManagementException) {}catch (IOException localIOException) {}catch (CertificateException localCertificateException) {}catch (KeyStoreException localKeyStoreException) {}catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
    throw new SecurityProviderException(localNoSuchAlgorithmException);
  }
  
  public abstract byte[] getStorageRootKey();
  
  public abstract byte[] signWithIdentity(byte[] paramArrayOfByte);
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.provisioning.security.SecurityProviderTpm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */