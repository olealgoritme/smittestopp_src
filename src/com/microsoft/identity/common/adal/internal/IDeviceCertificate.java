package com.microsoft.identity.common.adal.internal;

import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.List;

public abstract interface IDeviceCertificate
{
  public abstract X509Certificate getCertificate();
  
  public abstract RSAPrivateKey getRSAPrivateKey();
  
  public abstract RSAPublicKey getRSAPublicKey();
  
  public abstract String getThumbPrint();
  
  public abstract boolean isValidIssuer(List<String> paramList);
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.adal.internal.IDeviceCertificate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */