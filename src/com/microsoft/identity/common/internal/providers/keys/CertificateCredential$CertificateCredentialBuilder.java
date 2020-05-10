package com.microsoft.identity.common.internal.providers.keys;

import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

public class CertificateCredential$CertificateCredentialBuilder
{
  public X509Certificate mCertificate;
  public ClientCertificateMetadata mClientCertificateMetdata;
  public String mClientId;
  public KeyStoreConfiguration mKeyStoreConfiguration;
  public PrivateKey mPrivateKey;
  
  public CertificateCredential$CertificateCredentialBuilder(String paramString)
  {
    mClientId = paramString;
  }
  
  private void getCertificateInfoFromStore(KeyStoreConfiguration paramKeyStoreConfiguration, ClientCertificateMetadata paramClientCertificateMetadata)
  {
    KeyStore localKeyStore = KeyStore.getInstance(paramKeyStoreConfiguration.getKeyStoreType(), paramKeyStoreConfiguration.getKeyStoreProvider());
    localKeyStore.load(null, null);
    if (paramClientCertificateMetadata.getPassword() == null) {
      paramKeyStoreConfiguration = (PrivateKey)localKeyStore.getKey(paramClientCertificateMetadata.getAlias(), null);
    } else {
      paramKeyStoreConfiguration = (PrivateKey)localKeyStore.getKey(paramClientCertificateMetadata.getAlias(), paramClientCertificateMetadata.getPassword());
    }
    paramClientCertificateMetadata = (X509Certificate)localKeyStore.getCertificate(paramClientCertificateMetadata.getAlias());
    mPrivateKey = paramKeyStoreConfiguration;
    mCertificate = paramClientCertificateMetadata;
  }
  
  private void validateCertificateCredential(CertificateCredential paramCertificateCredential)
  {
    if (paramCertificateCredential != null) {
      return;
    }
    throw new IllegalArgumentException("Client ID, Certificate and PrivateKey OR KeyStoreConfiguration and Certificate Metadata are required");
  }
  
  public CertificateCredential build()
  {
    Object localObject1 = mClientId;
    Object localObject2 = null;
    Object localObject3 = localObject2;
    if (localObject1 != null)
    {
      if ((mCertificate != null) && (mPrivateKey != null)) {}
      for (localObject3 = new CertificateCredential(this, null);; localObject3 = new CertificateCredential(this, null))
      {
        break;
        localObject1 = mClientCertificateMetdata;
        localObject3 = localObject2;
        if (localObject1 == null) {
          break;
        }
        KeyStoreConfiguration localKeyStoreConfiguration = mKeyStoreConfiguration;
        localObject3 = localObject2;
        if (localKeyStoreConfiguration == null) {
          break;
        }
        getCertificateInfoFromStore(localKeyStoreConfiguration, (ClientCertificateMetadata)localObject1);
      }
    }
    validateCertificateCredential((CertificateCredential)localObject3);
    return (CertificateCredential)localObject3;
  }
  
  public CertificateCredentialBuilder certificate(X509Certificate paramX509Certificate)
  {
    mCertificate = paramX509Certificate;
    return this;
  }
  
  public CertificateCredentialBuilder clientCertificateMetadata(ClientCertificateMetadata paramClientCertificateMetadata)
  {
    mClientCertificateMetdata = paramClientCertificateMetadata;
    return this;
  }
  
  public CertificateCredentialBuilder keyStoreConfiguration(KeyStoreConfiguration paramKeyStoreConfiguration)
  {
    mKeyStoreConfiguration = paramKeyStoreConfiguration;
    return this;
  }
  
  public CertificateCredentialBuilder privateKey(PrivateKey paramPrivateKey)
  {
    mPrivateKey = paramPrivateKey;
    return this;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.keys.CertificateCredential.CertificateCredentialBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */