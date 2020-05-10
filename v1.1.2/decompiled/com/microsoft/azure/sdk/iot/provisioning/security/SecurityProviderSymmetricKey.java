package com.microsoft.azure.sdk.iot.provisioning.security;

import com.microsoft.azure.sdk.iot.provisioning.security.exceptions.SecurityProviderException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

public class SecurityProviderSymmetricKey
  extends SecurityProvider
{
  public static final String HMAC_SHA_256 = "HmacSHA256";
  public byte[] primaryKey;
  public String registrationId;
  public byte[] secondaryKey;
  
  public SecurityProviderSymmetricKey(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 != null) && (!paramString1.isEmpty()) && (paramString2 != null) && (!paramString2.isEmpty()))
    {
      if ((paramString3 != null) && (!paramString3.isEmpty()))
      {
        primaryKey = paramString1.getBytes();
        secondaryKey = paramString2.getBytes();
        registrationId = paramString3;
        return;
      }
      throw new IllegalArgumentException("Registration ID cannot be null");
    }
    throw new IllegalArgumentException("Symmetric key cannot be null");
  }
  
  public SecurityProviderSymmetricKey(byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte != null)
    {
      if ((paramString != null) && (!paramString.isEmpty()))
      {
        primaryKey = paramArrayOfByte;
        registrationId = paramString;
        return;
      }
      throw new IllegalArgumentException("Registration ID cannot be null");
    }
    throw new IllegalArgumentException("Symmetric key cannot be null");
  }
  
  private SSLContext generateSSLContext()
  {
    SSLContext localSSLContext = SSLContext.getInstance("TLSv1.2");
    KeyStore localKeyStore = getKeyStoreWithTrustedCerts();
    TrustManagerFactory localTrustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    localTrustManagerFactory.init(localKeyStore);
    localSSLContext.init(null, localTrustManagerFactory.getTrustManagers(), new SecureRandom());
    return localSSLContext;
  }
  
  public byte[] HMACSignData(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length != 0) && (paramArrayOfByte2 != null) && (paramArrayOfByte2.length != 0))
    {
      try
      {
        SecretKeySpec localSecretKeySpec = new javax/crypto/spec/SecretKeySpec;
        localSecretKeySpec.<init>(paramArrayOfByte2, "HmacSHA256");
        paramArrayOfByte2 = Mac.getInstance("HmacSHA256");
        paramArrayOfByte2.init(localSecretKeySpec);
        paramArrayOfByte1 = paramArrayOfByte2.doFinal(paramArrayOfByte1);
        return paramArrayOfByte1;
      }
      catch (InvalidKeyException paramArrayOfByte1) {}catch (NoSuchAlgorithmException paramArrayOfByte1) {}
      throw new SecurityProviderException(paramArrayOfByte1);
    }
    throw new SecurityProviderException("Signature or Key cannot be null or empty");
  }
  
  public String getRegistrationId()
  {
    String str = registrationId;
    if ((str != null) && (!str.isEmpty())) {
      return registrationId;
    }
    throw new SecurityProviderException("Registration is null or empty");
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
  
  public byte[] getSymmetricKey()
  {
    return primaryKey;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.provisioning.security.SecurityProviderSymmetricKey
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */