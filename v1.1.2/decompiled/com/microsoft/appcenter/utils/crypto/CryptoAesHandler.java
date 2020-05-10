package com.microsoft.appcenter.utils.crypto;

import android.content.Context;
import android.security.keystore.KeyGenParameterSpec.Builder;
import java.security.KeyStore.Entry;
import java.security.KeyStore.SecretKeyEntry;
import java.util.Calendar;
import javax.crypto.spec.IvParameterSpec;

public class CryptoAesHandler
  implements CryptoHandler
{
  public byte[] decrypt(CryptoUtils.ICryptoFactory paramICryptoFactory, int paramInt, KeyStore.Entry paramEntry, byte[] paramArrayOfByte)
  {
    paramICryptoFactory = paramICryptoFactory.getCipher("AES/CBC/PKCS7Padding", "AndroidKeyStoreBCWorkaround");
    paramInt = paramICryptoFactory.getBlockSize();
    IvParameterSpec localIvParameterSpec = new IvParameterSpec(paramArrayOfByte, 0, paramInt);
    paramICryptoFactory.init(2, ((KeyStore.SecretKeyEntry)paramEntry).getSecretKey(), localIvParameterSpec);
    return paramICryptoFactory.doFinal(paramArrayOfByte, paramInt, paramArrayOfByte.length - paramInt);
  }
  
  public byte[] encrypt(CryptoUtils.ICryptoFactory paramICryptoFactory, int paramInt, KeyStore.Entry paramEntry, byte[] paramArrayOfByte)
  {
    CryptoUtils.ICipher localICipher = paramICryptoFactory.getCipher("AES/CBC/PKCS7Padding", "AndroidKeyStoreBCWorkaround");
    localICipher.init(1, ((KeyStore.SecretKeyEntry)paramEntry).getSecretKey());
    paramICryptoFactory = localICipher.getIV();
    paramEntry = localICipher.doFinal(paramArrayOfByte);
    paramArrayOfByte = new byte[paramICryptoFactory.length + paramEntry.length];
    System.arraycopy(paramICryptoFactory, 0, paramArrayOfByte, 0, paramICryptoFactory.length);
    System.arraycopy(paramEntry, 0, paramArrayOfByte, paramICryptoFactory.length, paramEntry.length);
    return paramArrayOfByte;
  }
  
  public void generateKey(CryptoUtils.ICryptoFactory paramICryptoFactory, String paramString, Context paramContext)
  {
    paramContext = Calendar.getInstance();
    paramContext.add(1, 1);
    paramICryptoFactory = paramICryptoFactory.getKeyGenerator("AES", "AndroidKeyStore");
    paramICryptoFactory.init(new KeyGenParameterSpec.Builder(paramString, 3).setBlockModes(new String[] { "CBC" }).setEncryptionPaddings(new String[] { "PKCS7Padding" }).setKeySize(256).setKeyValidityForOriginationEnd(paramContext.getTime()).build());
    paramICryptoFactory.generateKey();
  }
  
  public String getAlgorithm()
  {
    return "AES/CBC/PKCS7Padding/256";
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.utils.crypto.CryptoAesHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */