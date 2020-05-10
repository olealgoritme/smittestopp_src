package com.microsoft.azure.sdk.iot.provisioning.security;

import com.microsoft.azure.sdk.iot.provisioning.security.exceptions.SecurityProviderException;
import java.io.IOException;
import java.security.Key;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;

public abstract class SecurityProviderX509
  extends SecurityProvider
{
  public static final String ALIAS_CERT_ALIAS = "ALIAS_CERT";
  
  private SSLContext generateSSLContext(X509Certificate paramX509Certificate, Key paramKey, Collection<X509Certificate> paramCollection)
  {
    if ((paramX509Certificate != null) && (paramKey != null) && (paramCollection != null))
    {
      String str = UUID.randomUUID().toString();
      SSLContext localSSLContext = SSLContext.getInstance("TLSv1.2");
      KeyStore localKeyStore = getKeyStoreWithTrustedCerts();
      if (localKeyStore != null)
      {
        X509Certificate[] arrayOfX509Certificate = new X509Certificate[paramCollection.size() + 1];
        arrayOfX509Certificate[0] = paramX509Certificate;
        paramX509Certificate = paramCollection.iterator();
        for (int i = 1; paramX509Certificate.hasNext(); i++) {
          arrayOfX509Certificate[i] = ((X509Certificate)paramX509Certificate.next());
        }
        localKeyStore.setKeyEntry("ALIAS_CERT", paramKey, str.toCharArray(), arrayOfX509Certificate);
        paramX509Certificate = getDefaultX509KeyManager(localKeyStore, str);
        paramCollection = getDefaultX509TrustManager(localKeyStore);
        paramKey = new SecureRandom();
        localSSLContext.init(new KeyManager[] { paramX509Certificate }, new TrustManager[] { paramCollection }, paramKey);
        return localSSLContext;
      }
      throw new SecurityProviderException("Key store with trusted certs cannot be null");
    }
    throw new IllegalArgumentException("cert or private key cannot be null");
  }
  
  private KeyManager getDefaultX509KeyManager(KeyStore paramKeyStore, String paramString)
  {
    KeyManagerFactory localKeyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
    localKeyManagerFactory.init(paramKeyStore, paramString.toCharArray());
    for (paramKeyStore : localKeyManagerFactory.getKeyManagers()) {
      if ((paramKeyStore instanceof X509KeyManager)) {
        return paramKeyStore;
      }
    }
    throw new SecurityProviderException("Could not retrieve X509 Key Manager");
  }
  
  private TrustManager getDefaultX509TrustManager(KeyStore paramKeyStore)
  {
    TrustManagerFactory localTrustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    localTrustManagerFactory.init(paramKeyStore);
    for (localTrustManagerFactory : localTrustManagerFactory.getTrustManagers()) {
      if ((localTrustManagerFactory instanceof X509TrustManager)) {
        return localTrustManagerFactory;
      }
    }
    throw new SecurityProviderException("Could not retrieve X509 trust manager");
  }
  
  public abstract X509Certificate getClientCertificate();
  
  public abstract String getClientCertificateCommonName();
  
  public abstract Key getClientPrivateKey();
  
  public abstract Collection<X509Certificate> getIntermediateCertificatesChain();
  
  public String getRegistrationId()
  {
    return getClientCertificateCommonName();
  }
  
  public SSLContext getSSLContext()
  {
    try
    {
      SSLContext localSSLContext = generateSSLContext(getClientCertificate(), getClientPrivateKey(), getIntermediateCertificatesChain());
      return localSSLContext;
    }
    catch (CertificateException localCertificateException) {}catch (IOException localIOException) {}catch (KeyManagementException localKeyManagementException) {}catch (KeyStoreException localKeyStoreException) {}catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}catch (UnrecoverableKeyException localUnrecoverableKeyException) {}catch (NoSuchProviderException localNoSuchProviderException) {}
    throw new SecurityProviderException(localNoSuchProviderException);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.provisioning.security.SecurityProviderX509
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */