package com.microsoft.appcenter.utils.crypto;

import android.annotation.SuppressLint;
import android.content.Context;
import android.security.KeyPairGeneratorSpec.Builder;
import e.a.a.a.a;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyPairGenerator;
import java.security.KeyStore.Entry;
import java.security.KeyStore.PrivateKeyEntry;
import java.security.cert.CertificateExpiredException;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Date;
import javax.security.auth.x500.X500Principal;

public class CryptoRsaHandler
  implements CryptoHandler
{
  private CryptoUtils.ICipher getCipher(CryptoUtils.ICryptoFactory paramICryptoFactory, int paramInt)
  {
    String str;
    if (paramInt >= 23) {
      str = "AndroidKeyStoreBCWorkaround";
    } else {
      str = "AndroidOpenSSL";
    }
    return paramICryptoFactory.getCipher("RSA/ECB/PKCS1Padding", str);
  }
  
  public byte[] decrypt(CryptoUtils.ICryptoFactory paramICryptoFactory, int paramInt, KeyStore.Entry paramEntry, byte[] paramArrayOfByte)
  {
    paramICryptoFactory = getCipher(paramICryptoFactory, paramInt);
    paramICryptoFactory.init(2, ((KeyStore.PrivateKeyEntry)paramEntry).getPrivateKey());
    return paramICryptoFactory.doFinal(paramArrayOfByte);
  }
  
  public byte[] encrypt(CryptoUtils.ICryptoFactory paramICryptoFactory, int paramInt, KeyStore.Entry paramEntry, byte[] paramArrayOfByte)
  {
    paramICryptoFactory = getCipher(paramICryptoFactory, paramInt);
    paramEntry = (X509Certificate)((KeyStore.PrivateKeyEntry)paramEntry).getCertificate();
    try
    {
      paramEntry.checkValidity();
      paramICryptoFactory.init(1, paramEntry.getPublicKey());
      return paramICryptoFactory.doFinal(paramArrayOfByte);
    }
    catch (CertificateExpiredException paramICryptoFactory)
    {
      throw new InvalidKeyException(paramICryptoFactory);
    }
  }
  
  @SuppressLint({"InlinedApi", "TrulyRandom"})
  public void generateKey(CryptoUtils.ICryptoFactory paramICryptoFactory, String paramString, Context paramContext)
  {
    paramICryptoFactory = Calendar.getInstance();
    paramICryptoFactory.add(1, 1);
    KeyPairGenerator localKeyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
    localKeyPairGenerator.initialize(new KeyPairGeneratorSpec.Builder(paramContext).setAlias(paramString).setSubject(new X500Principal(a.b("CN=", paramString))).setStartDate(new Date()).setEndDate(paramICryptoFactory.getTime()).setSerialNumber(BigInteger.TEN).setKeySize(2048).build());
    localKeyPairGenerator.generateKeyPair();
  }
  
  public String getAlgorithm()
  {
    return "RSA/ECB/PKCS1Padding/2048";
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.utils.crypto.CryptoRsaHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */