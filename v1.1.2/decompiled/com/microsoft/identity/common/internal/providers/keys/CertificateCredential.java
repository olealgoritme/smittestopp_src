package com.microsoft.identity.common.internal.providers.keys;

import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

public final class CertificateCredential
{
  public static final int MIN_KEYSIZE_IN_BITS = 2048;
  public final String mClientId;
  public final PrivateKey mPrivateKey;
  public final X509Certificate mPublicCertificate;
  
  public CertificateCredential(CertificateCredentialBuilder paramCertificateCredentialBuilder)
  {
    mClientId = CertificateCredentialBuilder.access$000(paramCertificateCredentialBuilder);
    mPublicCertificate = CertificateCredentialBuilder.access$100(paramCertificateCredentialBuilder);
    mPrivateKey = CertificateCredentialBuilder.access$200(paramCertificateCredentialBuilder);
  }
  
  public String getClientId()
  {
    return mClientId;
  }
  
  public PrivateKey getPrivateKey()
  {
    return mPrivateKey;
  }
  
  public X509Certificate getPublicCertificate()
  {
    return mPublicCertificate;
  }
  
  public static class CertificateCredentialBuilder
  {
    public X509Certificate mCertificate;
    public ClientCertificateMetadata mClientCertificateMetdata;
    public String mClientId;
    public KeyStoreConfiguration mKeyStoreConfiguration;
    public PrivateKey mPrivateKey;
    
    public CertificateCredentialBuilder(String paramString)
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
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.keys.CertificateCredential
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */