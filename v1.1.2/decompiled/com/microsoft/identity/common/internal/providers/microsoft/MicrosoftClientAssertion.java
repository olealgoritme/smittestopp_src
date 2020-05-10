package com.microsoft.identity.common.internal.providers.microsoft;

import com.microsoft.identity.common.internal.providers.keys.CertificateCredential;
import com.microsoft.identity.common.internal.providers.oauth2.ClientAssertion;
import e.e.a.l;
import e.e.a.m;
import e.e.a.n;
import e.e.a.v.b;
import e.e.b.e;
import java.security.MessageDigest;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MicrosoftClientAssertion
  extends ClientAssertion
{
  public static final String CLIENT_ASSERTION_TYPE = "urn:ietf:params:oauth:client-assertion-type:jwt-bearer";
  public static final int ONE_MINUTE_MILLIS = 60000;
  public static final String THUMBPRINT_ALGORITHM = "SHA-1";
  
  public MicrosoftClientAssertion(String paramString, CertificateCredential paramCertificateCredential)
  {
    if (paramCertificateCredential != null)
    {
      setClientAssertion(createSignedJwt(paramCertificateCredential.getClientId(), paramString, paramCertificateCredential).c());
      setClientAssertionType("urn:ietf:params:oauth:client-assertion-type:jwt-bearer");
      return;
    }
    throw new IllegalArgumentException("certificate credential is null");
  }
  
  private e.e.a.v.c createSHA1ThumbPrint(X509Certificate paramX509Certificate)
  {
    MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
    localMessageDigest.reset();
    localMessageDigest.update(paramX509Certificate.getEncoded());
    return new e.e.a.v.c(b.a(localMessageDigest.digest(), false));
  }
  
  private e createSignedJwt(String paramString1, String paramString2, CertificateCredential paramCertificateCredential)
  {
    long l = System.currentTimeMillis();
    Object localObject1 = new LinkedHashMap();
    if (paramString2 == null) {
      ((HashMap)localObject1).put("aud", null);
    } else {
      ((HashMap)localObject1).put("aud", Collections.singletonList(paramString2));
    }
    ((HashMap)localObject1).put("iss", paramString1);
    ((HashMap)localObject1).put("nbf", new Date(l));
    ((HashMap)localObject1).put("exp", new Date(l + 60000L));
    ((HashMap)localObject1).put("sub", paramString1);
    localObject1 = new e.e.b.c((Map)localObject1, null);
    try
    {
      paramString2 = l.C;
      Object localObject2;
      Object localObject3;
      if (!x.equals(yx))
      {
        paramString1 = new java/util/ArrayList;
        paramString1.<init>();
        localObject2 = paramCertificateCredential.getPublicCertificate().getEncoded();
        localObject3 = new e/e/a/v/a;
        ((e.e.a.v.a)localObject3).<init>(b.a((byte[])localObject2, false));
        paramString1.add(localObject3);
        localObject2 = paramCertificateCredential.getPublicCertificate();
      }
      try
      {
        localObject3 = createSHA1ThumbPrint((X509Certificate)localObject2);
        localObject2 = new e/e/b/e;
        m localm = new e/e/a/m;
        localm.<init>(paramString2, null, null, null, null, null, null, (e.e.a.v.c)localObject3, null, paramString1, null, null, null);
        ((e)localObject2).<init>(localm, (e.e.b.c)localObject1);
        paramString1 = new e/e/a/s/a;
        paramString1.<init>(paramCertificateCredential.getPrivateKey());
        ((n)localObject2).b(paramString1);
        return (e)localObject2;
      }
      catch (Exception paramString1) {}
      paramString1 = new java/lang/IllegalArgumentException;
      paramString1.<init>("The JWS algorithm \"alg\" cannot be \"none\"");
      throw paramString1;
    }
    catch (Exception paramString1) {}
    throw new RuntimeException("exception in createSignedJwt", paramString1);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.microsoft.MicrosoftClientAssertion
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */