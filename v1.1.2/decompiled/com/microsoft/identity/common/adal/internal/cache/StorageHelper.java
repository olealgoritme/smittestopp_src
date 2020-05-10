package com.microsoft.identity.common.adal.internal.cache;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.security.KeyPairGeneratorSpec.Builder;
import android.util.Base64;
import com.microsoft.identity.common.adal.internal.AuthenticationSettings;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.internal.logging.Logger;
import e.a.a.a.a;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.DigestException;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.x500.X500Principal;

public class StorageHelper
  implements IStorageHelper
{
  public static final String ADALKS = "adalks";
  public static final String ANDROID_KEY_STORE = "AndroidKeyStore";
  public static final String CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";
  public static final String CURRENT_ACTIVE_BROKER = "current_active_broker";
  public static final int DATA_KEY_LENGTH = 16;
  public static final String ENCODE_VERSION = "E1";
  public static final String HMAC_ALGORITHM = "HmacSHA256";
  public static final String HMAC_KEY_HASH_ALGORITHM = "SHA256";
  public static final int HMAC_LENGTH = 32;
  public static final String KEYSPEC_ALGORITHM = "AES";
  public static final int KEY_FILE_SIZE = 1024;
  public static final int KEY_SIZE = 256;
  public static final String KEY_STORE_CERT_ALIAS = "AdalKey";
  public static final int KEY_VERSION_BLOB_LENGTH = 4;
  public static final String TAG = "StorageHelper";
  public static final String VERSION_ANDROID_KEY_STORE = "A001";
  public static final String VERSION_USER_DEFINED = "U001";
  public static final String WRAP_ALGORITHM = "RSA/ECB/PKCS1Padding";
  public static final boolean sShouldEncryptWithKeyStoreKey = false;
  public String mBlobVersion;
  public SecretKey mCachedKeyStoreEncryptedKey = null;
  public final Context mContext;
  public SecretKey mEncryptionHMACKey = null;
  public SecretKey mEncryptionKey = null;
  public KeyPair mKeyPair;
  public final SecureRandom mRandom;
  public IWpjTelemetryCallback mTelemetryCallback;
  
  public StorageHelper(Context paramContext)
  {
    this(paramContext, null);
  }
  
  @SuppressLint({"TrulyRandom"})
  public StorageHelper(Context paramContext, IWpjTelemetryCallback paramIWpjTelemetryCallback)
  {
    mContext = paramContext.getApplicationContext();
    mRandom = new SecureRandom();
    mTelemetryCallback = paramIWpjTelemetryCallback;
  }
  
  private void assertHMac(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte2.length == paramInt2 - paramInt1)
    {
      int i = 0;
      for (int j = paramInt1; j < paramInt2; j++) {
        i = (byte)(i | paramArrayOfByte2[(j - paramInt1)] ^ paramArrayOfByte1[j]);
      }
      if (i == 0) {
        return;
      }
      throw new DigestException();
    }
    throw new IllegalArgumentException("Unexpected HMAC length");
  }
  
  private String decryptWithSecretKey(byte[] paramArrayOfByte, SecretKey paramSecretKey)
  {
    Object localObject = getHMacKey(paramSecretKey);
    int i = paramArrayOfByte.length - 16 - 32;
    int j = paramArrayOfByte.length - 32;
    int k = i - 4;
    if ((i >= 0) && (j >= 0) && (k >= 0))
    {
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      Mac localMac = Mac.getInstance("HmacSHA256");
      localMac.init((Key)localObject);
      localMac.update(paramArrayOfByte, 0, j);
      localObject = localMac.doFinal();
      assertHMac(paramArrayOfByte, j, paramArrayOfByte.length, (byte[])localObject);
      localCipher.init(2, paramSecretKey, new IvParameterSpec(paramArrayOfByte, i, 16));
      return new String(localCipher.doFinal(paramArrayOfByte, 4, k), "UTF-8");
    }
    throw new IOException("Invalid byte array input for decryption.");
  }
  
  private void emitDecryptionFailureTelemetryIfNeeded(KeyType paramKeyType, Exception paramException)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
    Object localObject = localSharedPreferences.getString("current_active_broker", "");
    String str = mContext.getPackageName();
    if (!((String)localObject).equalsIgnoreCase(str))
    {
      localObject = a.a("Decryption failed with key: ");
      ((StringBuilder)localObject).append(paramKeyType.name());
      ((StringBuilder)localObject).append(" Active broker: ");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(" Exception: ");
      ((StringBuilder)localObject).append(paramException.toString());
      paramException = ((StringBuilder)localObject).toString();
      Logger.info("StorageHelper:emitDecryptionFailureTelemetryIfNeeded", paramException);
      paramKeyType = mTelemetryCallback;
      if (paramKeyType != null) {
        paramKeyType.logEvent(mContext, "decryption_error_v2", Boolean.valueOf(true), paramException);
      }
      localSharedPreferences.edit().putString("current_active_broker", str).apply();
    }
  }
  
  /* Error */
  @TargetApi(18)
  private KeyPair generateKeyPairFromAndroidKeyStore()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: ldc_w 277
    //   6: ldc_w 279
    //   9: invokespecial 282	com/microsoft/identity/common/adal/internal/cache/StorageHelper:logFlowStart	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: ldc 21
    //   14: invokestatic 287	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   17: aconst_null
    //   18: invokevirtual 291	java/security/KeyStore:load	(Ljava/security/KeyStore$LoadStoreParameter;)V
    //   21: ldc_w 293
    //   24: ldc_w 295
    //   27: invokestatic 298	com/microsoft/identity/common/internal/logging/Logger:verbose	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: invokestatic 303	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   33: astore_1
    //   34: invokestatic 303	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   37: astore_2
    //   38: aload_2
    //   39: iconst_1
    //   40: bipush 100
    //   42: invokevirtual 307	java/util/Calendar:add	(II)V
    //   45: ldc_w 309
    //   48: ldc 21
    //   50: invokestatic 314	java/security/KeyPairGenerator:getInstance	(Ljava/lang/String;Ljava/lang/String;)Ljava/security/KeyPairGenerator;
    //   53: astore_3
    //   54: aload_3
    //   55: aload_0
    //   56: aload_0
    //   57: getfield 107	com/microsoft/identity/common/adal/internal/cache/StorageHelper:mContext	Landroid/content/Context;
    //   60: aload_1
    //   61: invokevirtual 318	java/util/Calendar:getTime	()Ljava/util/Date;
    //   64: aload_2
    //   65: invokevirtual 318	java/util/Calendar:getTime	()Ljava/util/Date;
    //   68: invokespecial 322	com/microsoft/identity/common/adal/internal/cache/StorageHelper:getKeyPairGeneratorSpec	(Landroid/content/Context;Ljava/util/Date;Ljava/util/Date;)Ljava/security/spec/AlgorithmParameterSpec;
    //   71: invokevirtual 326	java/security/KeyPairGenerator:initialize	(Ljava/security/spec/AlgorithmParameterSpec;)V
    //   74: aload_3
    //   75: invokevirtual 329	java/security/KeyPairGenerator:generateKeyPair	()Ljava/security/KeyPair;
    //   78: astore_2
    //   79: aload_0
    //   80: ldc_w 277
    //   83: ldc_w 331
    //   86: ldc -66
    //   88: invokespecial 335	com/microsoft/identity/common/adal/internal/cache/StorageHelper:logFlowSuccess	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_2
    //   94: areturn
    //   95: astore_2
    //   96: goto +52 -> 148
    //   99: astore_2
    //   100: aload_0
    //   101: ldc_w 277
    //   104: ldc_w 331
    //   107: aload_2
    //   108: invokevirtual 336	java/lang/IllegalStateException:toString	()Ljava/lang/String;
    //   111: aload_2
    //   112: invokespecial 340	com/microsoft/identity/common/adal/internal/cache/StorageHelper:logFlowError	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V
    //   115: new 342	java/security/KeyStoreException
    //   118: astore_1
    //   119: aload_1
    //   120: aload_2
    //   121: invokespecial 345	java/security/KeyStoreException:<init>	(Ljava/lang/Throwable;)V
    //   124: aload_1
    //   125: athrow
    //   126: astore_2
    //   127: goto +4 -> 131
    //   130: astore_2
    //   131: aload_0
    //   132: ldc_w 277
    //   135: ldc_w 331
    //   138: aload_2
    //   139: invokevirtual 231	java/lang/Exception:toString	()Ljava/lang/String;
    //   142: aload_2
    //   143: invokespecial 340	com/microsoft/identity/common/adal/internal/cache/StorageHelper:logFlowError	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V
    //   146: aload_2
    //   147: athrow
    //   148: aload_0
    //   149: monitorexit
    //   150: aload_2
    //   151: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	StorageHelper
    //   33	92	1	localObject1	Object
    //   37	57	2	localObject2	Object
    //   95	1	2	localObject3	Object
    //   99	22	2	localIllegalStateException	IllegalStateException
    //   126	1	2	localIOException	IOException
    //   130	21	2	localGeneralSecurityException	GeneralSecurityException
    //   53	22	3	localKeyPairGenerator	java.security.KeyPairGenerator
    // Exception table:
    //   from	to	target	type
    //   2	91	95	finally
    //   100	126	95	finally
    //   131	148	95	finally
    //   2	91	99	java/lang/IllegalStateException
    //   2	91	126	java/io/IOException
    //   2	91	130	java/security/GeneralSecurityException
  }
  
  private byte[] getByteArrayFromEncryptedBlob(String paramString)
  {
    int i = paramString.charAt(0) - 'a';
    validateEncodeVersion(paramString, i);
    return Base64.decode(paramString.substring(i + 1), 0);
  }
  
  private char getEncodeVersionLengthPrefix()
  {
    return (char)99;
  }
  
  private SecretKey getHMacKey(SecretKey paramSecretKey)
  {
    byte[] arrayOfByte = paramSecretKey.getEncoded();
    if (arrayOfByte != null) {
      return new SecretKeySpec(MessageDigest.getInstance("SHA256").digest(arrayOfByte), "AES");
    }
    return paramSecretKey;
  }
  
  @TargetApi(18)
  private AlgorithmParameterSpec getKeyPairGeneratorSpec(Context paramContext, Date paramDate1, Date paramDate2)
  {
    String str = String.format(Locale.ROOT, "CN=%s, OU=%s", new Object[] { "AdalKey", getPackageName() });
    return new KeyPairGeneratorSpec.Builder(paramContext).setAlias("AdalKey").setSubject(new X500Principal(str)).setSerialNumber(BigInteger.ONE).setStartDate(paramDate1).setEndDate(paramDate2).build();
  }
  
  public static SecretKey getSecretKey(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      return new SecretKeySpec(paramArrayOfByte, "AES");
    }
    throw new IllegalArgumentException("rawBytes");
  }
  
  @TargetApi(18)
  private SecretKey getUnwrappedSecretKey()
  {
    try
    {
      Logger.verbose("StorageHelper:getUnwrappedSecretKey", "Reading SecretKey");
      byte[] arrayOfByte = readKeyData();
      if (arrayOfByte == null)
      {
        Logger.verbose("StorageHelper:getUnwrappedSecretKey", "Key data is null");
        return null;
      }
      Object localObject1 = readKeyPair();
      mKeyPair = ((KeyPair)localObject1);
      if (localObject1 == null) {
        return null;
      }
      localObject1 = unwrap(arrayOfByte);
      Logger.verbose("StorageHelper:getUnwrappedSecretKey", "Finished reading SecretKey");
      return (SecretKey)localObject1;
    }
    finally {}
  }
  
  private SecretKey loadKeyStoreEncryptedKey()
  {
    try
    {
      SecretKey localSecretKey;
      if (mCachedKeyStoreEncryptedKey != null)
      {
        localSecretKey = mCachedKeyStoreEncryptedKey;
        return localSecretKey;
      }
      try
      {
        localSecretKey = getUnwrappedSecretKey();
        mCachedKeyStoreEncryptedKey = localSecretKey;
        return localSecretKey;
      }
      catch (IOException localIOException) {}catch (GeneralSecurityException localGeneralSecurityException) {}
      Logger.error("StorageHelper:loadKeyStoreEncryptedKey", "android_keystore_failed", localGeneralSecurityException);
      mKeyPair = null;
      mCachedKeyStoreEncryptedKey = null;
      deleteKeyFile();
      resetKeyPairFromAndroidKeyStore();
      throw localGeneralSecurityException;
    }
    finally {}
  }
  
  private void logEvent(String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    String str = a.b("StorageHelper", paramString1);
    paramString1 = new StringBuilder();
    paramString1.append(paramString2);
    paramString1.append(": ");
    paramString1.append(paramString3);
    Logger.verbose(str, paramString1.toString());
    paramString1 = mTelemetryCallback;
    if (paramString1 != null) {
      paramString1.logEvent(mContext, paramString2, Boolean.valueOf(paramBoolean), paramString3);
    }
  }
  
  private void logFlowError(String paramString1, String paramString2, String paramString3, Exception paramException)
  {
    String str = a.b("StorageHelper", paramString1);
    paramString1 = new StringBuilder();
    paramString1.append(paramString2);
    paramString1.append(" failed: ");
    paramString1.append(paramString3);
    Logger.error(str, paramString1.toString(), paramException);
    paramString1 = mTelemetryCallback;
    if (paramString1 != null) {
      paramString1.logEvent(mContext, paramString2, Boolean.valueOf(true), paramString3);
    }
  }
  
  private void logFlowStart(String paramString1, String paramString2)
  {
    String str = a.b("StorageHelper", paramString1);
    paramString1 = new StringBuilder();
    paramString1.append(paramString2);
    paramString1.append(" started.");
    Logger.verbose(str, paramString1.toString());
    paramString1 = mTelemetryCallback;
    if (paramString1 != null) {
      paramString1.logEvent(mContext, paramString2, Boolean.valueOf(false), "");
    }
  }
  
  private void logFlowSuccess(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = a.b("StorageHelper", paramString1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" successfully finished: ");
    localStringBuilder.append(paramString3);
    Logger.verbose(paramString1, localStringBuilder.toString());
    paramString1 = mTelemetryCallback;
    if (paramString1 != null) {
      paramString1.logEvent(mContext, paramString2, Boolean.valueOf(false), paramString3);
    }
  }
  
  private byte[] readKeyData()
  {
    Object localObject1 = new File(mContext.getDir(getPackageName(), 0), "adalks");
    if (!((File)localObject1).exists()) {
      return null;
    }
    Logger.verbose("StorageHelper:readKeyData", "Reading key data from a file");
    localObject1 = new FileInputStream((File)localObject1);
    try
    {
      Object localObject2 = new java/io/ByteArrayOutputStream;
      ((ByteArrayOutputStream)localObject2).<init>();
      byte[] arrayOfByte = new byte['Ѐ'];
      for (;;)
      {
        int i = ((InputStream)localObject1).read(arrayOfByte);
        if (i == -1) {
          break;
        }
        ((ByteArrayOutputStream)localObject2).write(arrayOfByte, 0, i);
      }
      localObject2 = ((ByteArrayOutputStream)localObject2).toByteArray();
      return (byte[])localObject2;
    }
    finally
    {
      ((InputStream)localObject1).close();
    }
  }
  
  private KeyPair readKeyPair()
  {
    try
    {
      Logger.verbose("StorageHelper:readKeyPair", "Reading Key entry");
      try
      {
        logFlowStart(":readKeyPair", "keychain_read_v2_start");
        Object localObject1 = KeyStore.getInstance("AndroidKeyStore");
        ((KeyStore)localObject1).load(null);
        localObject2 = ((KeyStore)localObject1).getCertificate("AdalKey");
        localObject1 = ((KeyStore)localObject1).getKey("AdalKey", null);
        if ((localObject2 != null) && (localObject1 != null))
        {
          KeyPair localKeyPair = new java/security/KeyPair;
          localKeyPair.<init>(((Certificate)localObject2).getPublicKey(), (PrivateKey)localObject1);
          logFlowSuccess(":readKeyPair", "keychain_read_v2_end", "KeyStore KeyPair is loaded.");
          return localKeyPair;
        }
        logFlowSuccess(":readKeyPair", "keychain_read_v2_end", "KeyStore is empty.");
        Logger.verbose("StorageHelper:readKeyPair", "Key entry doesn't exist.");
        return null;
      }
      catch (RuntimeException localRuntimeException)
      {
        logFlowError(":readKeyPair", "keychain_read_v2_end", localRuntimeException.toString(), localRuntimeException);
        Object localObject2 = new java/security/KeyStoreException;
        ((KeyStoreException)localObject2).<init>(localRuntimeException);
        throw ((Throwable)localObject2);
      }
      catch (IOException localIOException) {}catch (GeneralSecurityException localGeneralSecurityException) {}
      logFlowError(":readKeyPair", "keychain_read_v2_end", localGeneralSecurityException.toString(), localGeneralSecurityException);
      throw localGeneralSecurityException;
    }
    finally {}
  }
  
  @SuppressLint({"GetInstance"})
  @TargetApi(18)
  private SecretKey unwrap(byte[] paramArrayOfByte)
  {
    Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    localCipher.init(4, mKeyPair.getPrivate());
    try
    {
      paramArrayOfByte = (SecretKey)localCipher.unwrap(paramArrayOfByte, "AES", 3);
      return paramArrayOfByte;
    }
    catch (IllegalArgumentException paramArrayOfByte)
    {
      throw new KeyStoreException(paramArrayOfByte);
    }
  }
  
  private void validateEncodeVersion(String paramString, int paramInt)
  {
    if (paramInt > 0)
    {
      if (paramString.substring(1, paramInt + 1).equals("E1")) {
        return;
      }
      throw new IllegalArgumentException(String.format("Unsupported encode version received. Encode version supported is: '%s'", new Object[] { "E1" }));
    }
    throw new IllegalArgumentException(String.format("Encode version length: '%s' is not valid, it must be greater of equal to 0", new Object[] { Integer.valueOf(paramInt) }));
  }
  
  @SuppressLint({"GetInstance"})
  @TargetApi(18)
  private byte[] wrap(SecretKey paramSecretKey)
  {
    Logger.verbose("StorageHelper:wrap", "Wrap secret key.");
    Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    localCipher.init(3, mKeyPair.getPublic());
    return localCipher.wrap(paramSecretKey);
  }
  
  private void writeKeyData(byte[] paramArrayOfByte)
  {
    Logger.verbose("StorageHelper:writeKeyData", "Writing key data to a file");
    FileOutputStream localFileOutputStream = new FileOutputStream(new File(mContext.getDir(getPackageName(), 0), "adalks"));
    try
    {
      localFileOutputStream.write(paramArrayOfByte);
      return;
    }
    finally
    {
      localFileOutputStream.close();
    }
  }
  
  public String decrypt(String paramString)
  {
    Logger.verbose("StorageHelper:decrypt", "Starting decryption");
    if (!StringExtensions.isNullOrBlank(paramString))
    {
      if (getEncryptionType(paramString) == EncryptionType.UNENCRYPTED)
      {
        Logger.warn("StorageHelper:decrypt", "This string is not encrypted. Finished decryption.");
        return paramString;
      }
      if (mTelemetryCallback != null) {
        try
        {
          if (loadSecretKey(KeyType.KEYSTORE_ENCRYPTED_KEY) == null) {
            mTelemetryCallback.logEvent(mContext, ":decrypt", Boolean.valueOf(false), "KEY_DECRYPTION_KEYSTORE_KEY_NOT_INITIALIZED");
          }
        }
        catch (Exception localException)
        {
          mTelemetryCallback.logEvent(mContext, ":decrypt", Boolean.valueOf(false), "KEY_DECRYPTION_KEYSTORE_KEY_FAILED_TO_LOAD");
        }
      }
      Object localObject = getKeysForDecryptionType(paramString, getPackageName());
      byte[] arrayOfByte = getByteArrayFromEncryptedBlob(paramString);
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        localObject = (KeyType)localIterator.next();
        try
        {
          paramString = loadSecretKey((KeyType)localObject);
          if (paramString == null) {
            continue;
          }
          String str = decryptWithSecretKey(arrayOfByte, paramString);
          paramString = new java/lang/StringBuilder;
          paramString.<init>();
          paramString.append("Finished decryption with keyType:");
          paramString.append(((Enum)localObject).name());
          Logger.verbose("StorageHelper:decrypt", paramString.toString());
          return str;
        }
        catch (IOException paramString) {}catch (GeneralSecurityException paramString) {}
        emitDecryptionFailureTelemetryIfNeeded((KeyType)localObject, paramString);
      }
      Logger.info("StorageHelper:decrypt", "Tried all decryption keys and decryption still fails. Throw an exception.");
      throw new GeneralSecurityException("decryption_failed");
    }
    throw new IllegalArgumentException("Input is empty or null");
  }
  
  public void deleteKeyFile()
  {
    File localFile = new File(mContext.getDir(getPackageName(), 0), "adalks");
    if (localFile.exists())
    {
      Logger.verbose("StorageHelper:deleteKeyFile", "Delete KeyFile");
      if (!localFile.delete()) {
        Logger.verbose("StorageHelper:deleteKeyFile", "Delete KeyFile failed");
      }
    }
  }
  
  public SecretKey deserializeSecretKey(String paramString)
  {
    return getSecretKey(Base64.decode(paramString, 0));
  }
  
  public String encrypt(String paramString)
  {
    if (!StringExtensions.isNullOrBlank(paramString))
    {
      Logger.verbose("StorageHelper:encrypt", "Starting encryption");
      Object localObject1 = loadSecretKeyForEncryption();
      mEncryptionKey = ((SecretKey)localObject1);
      mEncryptionHMACKey = getHMacKey((SecretKey)localObject1);
      localObject1 = a.a("Encrypt version:");
      ((StringBuilder)localObject1).append(mBlobVersion);
      Logger.verbose("StorageHelper:encrypt", ((StringBuilder)localObject1).toString());
      localObject1 = mBlobVersion.getBytes("UTF-8");
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      paramString = new byte[16];
      mRandom.nextBytes(paramString);
      IvParameterSpec localIvParameterSpec = new IvParameterSpec(paramString);
      Object localObject2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
      Object localObject3 = Mac.getInstance("HmacSHA256");
      ((Cipher)localObject2).init(1, mEncryptionKey, localIvParameterSpec);
      localObject2 = ((Cipher)localObject2).doFinal(arrayOfByte);
      ((Mac)localObject3).init(mEncryptionHMACKey);
      ((Mac)localObject3).update((byte[])localObject1);
      ((Mac)localObject3).update((byte[])localObject2);
      ((Mac)localObject3).update(paramString);
      localObject3 = ((Mac)localObject3).doFinal();
      arrayOfByte = new byte[localObject1.length + localObject2.length + 16 + localObject3.length];
      System.arraycopy(localObject1, 0, arrayOfByte, 0, localObject1.length);
      System.arraycopy(localObject2, 0, arrayOfByte, localObject1.length, localObject2.length);
      System.arraycopy(paramString, 0, arrayOfByte, localObject1.length + localObject2.length, 16);
      System.arraycopy(localObject3, 0, arrayOfByte, localObject1.length + localObject2.length + 16, localObject3.length);
      localObject1 = new String(Base64.encode(arrayOfByte, 2), "UTF-8");
      Logger.verbose("StorageHelper:encrypt", "Finished encryption");
      paramString = new StringBuilder();
      paramString.append(getEncodeVersionLengthPrefix());
      paramString.append("E1");
      paramString.append((String)localObject1);
      return paramString.toString();
    }
    throw new IllegalArgumentException("Input is empty or null");
  }
  
  public SecretKey generateKeyStoreEncryptedKey()
  {
    try
    {
      SecretKey localSecretKey = generateSecretKey();
      mCachedKeyStoreEncryptedKey = localSecretKey;
      saveKeyStoreEncryptedKey(localSecretKey);
      logEvent(":generateKeyStoreEncryptedKey", "key_created_v2", false, "New key is generated.");
      localSecretKey = mCachedKeyStoreEncryptedKey;
      return localSecretKey;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public SecretKey generateSecretKey()
  {
    KeyGenerator localKeyGenerator = KeyGenerator.getInstance("AES");
    localKeyGenerator.init(256, mRandom);
    return localKeyGenerator.generateKey();
  }
  
  public EncryptionType getEncryptionType(String paramString)
  {
    try
    {
      byte[] arrayOfByte = getByteArrayFromEncryptedBlob(paramString);
      try
      {
        paramString = new java/lang/String;
        paramString.<init>(arrayOfByte, 0, 4, "UTF-8");
        if ("U001".equalsIgnoreCase(paramString)) {
          return EncryptionType.USER_DEFINED;
        }
        if ("A001".equalsIgnoreCase(paramString))
        {
          paramString = EncryptionType.ANDROID_KEY_STORE;
          return paramString;
        }
        return EncryptionType.UNENCRYPTED;
      }
      catch (UnsupportedEncodingException paramString)
      {
        Logger.error("StorageHelper:getEncryptionType", "Failed to extract keyVersion.", paramString);
        throw paramString;
      }
      return EncryptionType.UNENCRYPTED;
    }
    catch (Exception paramString)
    {
      Logger.error("StorageHelper:getEncryptionType", "This data is not an encrypted blob. Treat as unencrypted data.", paramString);
    }
  }
  
  public List<KeyType> getKeysForDecryptionType(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    paramString1 = getEncryptionType(paramString1);
    if (paramString1 == EncryptionType.USER_DEFINED)
    {
      if (AuthenticationSettings.INSTANCE.getSecretKeyData() != null)
      {
        localArrayList.add(KeyType.ADAL_USER_DEFINED_KEY);
      }
      else if ("com.microsoft.windowsintune.companyportal".equalsIgnoreCase(paramString2))
      {
        localArrayList.add(KeyType.LEGACY_COMPANY_PORTAL_KEY);
        localArrayList.add(KeyType.LEGACY_AUTHENTICATOR_APP_KEY);
      }
      else if ("com.azure.authenticator".equalsIgnoreCase(paramString2))
      {
        localArrayList.add(KeyType.LEGACY_AUTHENTICATOR_APP_KEY);
        localArrayList.add(KeyType.LEGACY_COMPANY_PORTAL_KEY);
      }
    }
    else if (paramString1 == EncryptionType.ANDROID_KEY_STORE) {
      localArrayList.add(KeyType.KEYSTORE_ENCRYPTED_KEY);
    }
    return localArrayList;
  }
  
  public String getPackageName()
  {
    return mContext.getPackageName();
  }
  
  public SecretKey loadSecretKey(KeyType paramKeyType)
  {
    int i = paramKeyType.ordinal();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            return loadKeyStoreEncryptedKey();
          }
          Logger.verbose("StorageHelper:loadSecretKey", "Unknown KeyType. This code should never be reached.");
          throw new GeneralSecurityException("unknown_error");
        }
        return getSecretKey(AuthenticationSettings.INSTANCE.getSecretKeyData());
      }
      return getSecretKey((byte[])AuthenticationSettings.INSTANCE.getBrokerSecretKeys().get("com.microsoft.windowsintune.companyportal"));
    }
    return getSecretKey((byte[])AuthenticationSettings.INSTANCE.getBrokerSecretKeys().get("com.azure.authenticator"));
  }
  
  public SecretKey loadSecretKeyForEncryption()
  {
    for (;;)
    {
      SecretKey localSecretKey;
      try
      {
        Object localObject1;
        if ((mEncryptionKey != null) && (mEncryptionHMACKey != null))
        {
          localObject1 = mEncryptionKey;
          return (SecretKey)localObject1;
        }
        if (AuthenticationSettings.INSTANCE.getBrokerSecretKeys().containsKey(getPackageName()))
        {
          localObject1 = mTelemetryCallback;
          if (localObject1 != null) {
            try
            {
              if (loadSecretKey(KeyType.KEYSTORE_ENCRYPTED_KEY) == null) {
                mTelemetryCallback.logEvent(mContext, ":loadSecretKeyForEncryption", Boolean.valueOf(false), "KEY_ENCRYPTION_KEYSTORE_KEY_NOT_INITIALIZED");
              }
            }
            catch (Exception localException)
            {
              mTelemetryCallback.logEvent(mContext, ":loadSecretKeyForEncryption", Boolean.valueOf(false), "KEY_ENCRYPTION_KEYSTORE_KEY_FAILED_TO_LOAD");
            }
          }
          setBlobVersion("U001");
          if ("com.azure.authenticator".equalsIgnoreCase(getPackageName()))
          {
            localSecretKey = loadSecretKey(KeyType.LEGACY_AUTHENTICATOR_APP_KEY);
            return localSecretKey;
          }
          localSecretKey = loadSecretKey(KeyType.LEGACY_COMPANY_PORTAL_KEY);
          return localSecretKey;
        }
        if (AuthenticationSettings.INSTANCE.getSecretKeyData() != null)
        {
          setBlobVersion("U001");
          localSecretKey = loadSecretKey(KeyType.ADAL_USER_DEFINED_KEY);
          return localSecretKey;
        }
        setBlobVersion("A001");
      }
      finally {}
      try
      {
        localSecretKey = loadSecretKey(KeyType.KEYSTORE_ENCRYPTED_KEY);
        if (localSecretKey != null) {
          return localSecretKey;
        }
      }
      catch (IOException|GeneralSecurityException localIOException) {}
    }
    Logger.verbose("StorageHelper:loadSecretKeyForEncryption", "Keystore-encrypted key does not exist, try to generate new keys.");
    localSecretKey = generateKeyStoreEncryptedKey();
    return localSecretKey;
  }
  
  @TargetApi(18)
  public void resetKeyPairFromAndroidKeyStore()
  {
    try
    {
      KeyStore localKeyStore = KeyStore.getInstance("AndroidKeyStore");
      localKeyStore.load(null);
      localKeyStore.deleteEntry("AdalKey");
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void saveKeyStoreEncryptedKey(SecretKey paramSecretKey)
  {
    if (mKeyPair == null) {
      mKeyPair = generateKeyPairFromAndroidKeyStore();
    }
    writeKeyData(wrap(paramSecretKey));
  }
  
  public String serializeSecretKey(SecretKey paramSecretKey)
  {
    return Base64.encodeToString(paramSecretKey.getEncoded(), 0);
  }
  
  public void setBlobVersion(String paramString)
  {
    mBlobVersion = paramString;
  }
  
  public static enum EncryptionType
  {
    static
    {
      ANDROID_KEY_STORE = new EncryptionType("ANDROID_KEY_STORE", 1);
      EncryptionType localEncryptionType = new EncryptionType("UNENCRYPTED", 2);
      UNENCRYPTED = localEncryptionType;
      $VALUES = new EncryptionType[] { USER_DEFINED, ANDROID_KEY_STORE, localEncryptionType };
    }
    
    public EncryptionType() {}
  }
  
  public static enum KeyType
  {
    static
    {
      ADAL_USER_DEFINED_KEY = new KeyType("ADAL_USER_DEFINED_KEY", 2);
      KeyType localKeyType = new KeyType("KEYSTORE_ENCRYPTED_KEY", 3);
      KEYSTORE_ENCRYPTED_KEY = localKeyType;
      $VALUES = new KeyType[] { LEGACY_AUTHENTICATOR_APP_KEY, LEGACY_COMPANY_PORTAL_KEY, ADAL_USER_DEFINED_KEY, localKeyType };
    }
    
    public KeyType() {}
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.adal.internal.cache.StorageHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */