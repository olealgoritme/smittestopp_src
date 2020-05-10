package com.microsoft.identity.common.internal.providers.keys;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;

public final class CertificateCredential
{
  public static final int MIN_KEYSIZE_IN_BITS = 2048;
  public final String mClientId;
  public final PrivateKey mPrivateKey;
  public final X509Certificate mPublicCertificate;
  
  public CertificateCredential(CertificateCredential.CertificateCredentialBuilder paramCertificateCredentialBuilder)
  {
    mClientId = CertificateCredential.CertificateCredentialBuilder.access$000(paramCertificateCredentialBuilder);
    mPublicCertificate = CertificateCredential.CertificateCredentialBuilder.access$100(paramCertificateCredentialBuilder);
    mPrivateKey = CertificateCredential.CertificateCredentialBuilder.access$200(paramCertificateCredentialBuilder);
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
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.keys.CertificateCredential
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */