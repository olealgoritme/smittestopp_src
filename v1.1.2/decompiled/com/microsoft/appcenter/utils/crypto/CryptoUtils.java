package com.microsoft.appcenter.utils.crypto;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.Base64;
import com.microsoft.appcenter.utils.AppCenterLog;
import e.a.a.a.a;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStore.Entry;
import java.security.Provider;
import java.security.cert.CertificateExpiredException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

public class CryptoUtils
{
  public static final ICryptoFactory DEFAULT_CRYPTO_FACTORY = new ICryptoFactory()
  {
    public CryptoUtils.ICipher getCipher(String paramAnonymousString1, String paramAnonymousString2)
    {
      new CryptoUtils.ICipher()
      {
        public byte[] doFinal(byte[] paramAnonymous2ArrayOfByte)
        {
          return val$cipher.doFinal(paramAnonymous2ArrayOfByte);
        }
        
        public byte[] doFinal(byte[] paramAnonymous2ArrayOfByte, int paramAnonymous2Int1, int paramAnonymous2Int2)
        {
          return val$cipher.doFinal(paramAnonymous2ArrayOfByte, paramAnonymous2Int1, paramAnonymous2Int2);
        }
        
        public String getAlgorithm()
        {
          return val$cipher.getAlgorithm();
        }
        
        public int getBlockSize()
        {
          return val$cipher.getBlockSize();
        }
        
        public byte[] getIV()
        {
          return val$cipher.getIV();
        }
        
        public String getProvider()
        {
          return val$cipher.getProvider().getName();
        }
        
        public void init(int paramAnonymous2Int, Key paramAnonymous2Key)
        {
          val$cipher.init(paramAnonymous2Int, paramAnonymous2Key);
        }
        
        public void init(int paramAnonymous2Int, Key paramAnonymous2Key, AlgorithmParameterSpec paramAnonymous2AlgorithmParameterSpec)
        {
          val$cipher.init(paramAnonymous2Int, paramAnonymous2Key, paramAnonymous2AlgorithmParameterSpec);
        }
      };
    }
    
    public CryptoUtils.IKeyGenerator getKeyGenerator(String paramAnonymousString1, String paramAnonymousString2)
    {
      new CryptoUtils.IKeyGenerator()
      {
        public void generateKey()
        {
          val$keyGenerator.generateKey();
        }
        
        public void init(AlgorithmParameterSpec paramAnonymous2AlgorithmParameterSpec)
        {
          val$keyGenerator.init(paramAnonymous2AlgorithmParameterSpec);
        }
      };
    }
  };
  public static final String M_KEY_EXPIRED_EXCEPTION = "android.security.keystore.KeyExpiredException";
  @SuppressLint({"StaticFieldLeak"})
  public static CryptoUtils sInstance;
  public final int mApiLevel;
  public final Context mContext;
  public final ICryptoFactory mCryptoFactory;
  public final Map<String, CryptoHandlerEntry> mCryptoHandlers = new LinkedHashMap();
  public final KeyStore mKeyStore;
  
  public CryptoUtils(Context paramContext)
  {
    this(paramContext, DEFAULT_CRYPTO_FACTORY, Build.VERSION.SDK_INT);
  }
  
  @TargetApi(23)
  public CryptoUtils(Context paramContext, ICryptoFactory paramICryptoFactory, int paramInt)
  {
    mContext = paramContext.getApplicationContext();
    mCryptoFactory = paramICryptoFactory;
    mApiLevel = paramInt;
    paramContext = null;
    paramICryptoFactory = null;
    if (paramInt >= 19) {}
    try
    {
      paramContext = KeyStore.getInstance("AndroidKeyStore");
      try
      {
        paramContext.load(null);
      }
      catch (Exception paramICryptoFactory) {}
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = paramICryptoFactory;
      }
    }
    AppCenterLog.error("AppCenter", "Cannot use secure keystore on this device.");
    mKeyStore = paramContext;
    if ((paramContext != null) && (paramInt >= 23)) {
      try
      {
        paramICryptoFactory = new com/microsoft/appcenter/utils/crypto/CryptoAesHandler;
        paramICryptoFactory.<init>();
        registerHandler(paramICryptoFactory);
      }
      catch (Exception paramICryptoFactory)
      {
        AppCenterLog.error("AppCenter", "Cannot use modern encryption on this device.");
      }
    }
    if (paramContext != null) {
      try
      {
        paramContext = new com/microsoft/appcenter/utils/crypto/CryptoRsaHandler;
        paramContext.<init>();
        registerHandler(paramContext);
      }
      catch (Exception paramContext)
      {
        AppCenterLog.error("AppCenter", "Cannot use old encryption on this device.");
      }
    }
    paramContext = new CryptoNoOpHandler();
    mCryptoHandlers.put(paramContext.getAlgorithm(), new CryptoHandlerEntry(0, paramContext));
  }
  
  private String getAlias(CryptoHandler paramCryptoHandler, int paramInt)
  {
    StringBuilder localStringBuilder = a.a("appcenter.", paramInt, ".");
    localStringBuilder.append(paramCryptoHandler.getAlgorithm());
    return localStringBuilder.toString();
  }
  
  private DecryptedData getDecryptedData(CryptoHandler paramCryptoHandler, int paramInt, String paramString)
  {
    KeyStore.Entry localEntry = getKeyStoreEntry(paramCryptoHandler, paramInt);
    paramString = new String(paramCryptoHandler.decrypt(mCryptoFactory, mApiLevel, localEntry, Base64.decode(paramString, 0)), "UTF-8");
    if (paramCryptoHandler != mCryptoHandlers.values().iterator().next()).mCryptoHandler) {
      paramCryptoHandler = encrypt(paramString);
    } else {
      paramCryptoHandler = null;
    }
    return new DecryptedData(paramString, paramCryptoHandler);
  }
  
  public static CryptoUtils getInstance(Context paramContext)
  {
    if (sInstance == null) {
      sInstance = new CryptoUtils(paramContext);
    }
    return sInstance;
  }
  
  private KeyStore.Entry getKeyStoreEntry(CryptoHandler paramCryptoHandler, int paramInt)
  {
    if (mKeyStore == null) {
      return null;
    }
    paramCryptoHandler = getAlias(paramCryptoHandler, paramInt);
    return mKeyStore.getEntry(paramCryptoHandler, null);
  }
  
  private KeyStore.Entry getKeyStoreEntry(CryptoHandlerEntry paramCryptoHandlerEntry)
  {
    return getKeyStoreEntry(mCryptoHandler, mAliasIndex);
  }
  
  private void registerHandler(CryptoHandler paramCryptoHandler)
  {
    int i = 0;
    String str = getAlias(paramCryptoHandler, 0);
    Object localObject1 = getAlias(paramCryptoHandler, 1);
    Date localDate1 = mKeyStore.getCreationDate(str);
    Date localDate2 = mKeyStore.getCreationDate((String)localObject1);
    int j = i;
    Object localObject2 = str;
    if (localDate2 != null)
    {
      j = i;
      localObject2 = str;
      if (localDate2.after(localDate1))
      {
        localObject2 = localObject1;
        j = 1;
      }
    }
    if ((mCryptoHandlers.isEmpty()) && (!mKeyStore.containsAlias((String)localObject2)))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Creating alias: ");
      ((StringBuilder)localObject1).append((String)localObject2);
      AppCenterLog.debug("AppCenter", ((StringBuilder)localObject1).toString());
      paramCryptoHandler.generateKey(mCryptoFactory, (String)localObject2, mContext);
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Using ");
    ((StringBuilder)localObject1).append((String)localObject2);
    AppCenterLog.debug("AppCenter", ((StringBuilder)localObject1).toString());
    mCryptoHandlers.put(paramCryptoHandler.getAlgorithm(), new CryptoHandlerEntry(j, paramCryptoHandler));
  }
  
  public DecryptedData decrypt(String paramString)
  {
    if (paramString == null) {
      return new DecryptedData(null, null);
    }
    String[] arrayOfString = paramString.split(":");
    Object localObject;
    if (arrayOfString.length == 2) {
      localObject = (CryptoHandlerEntry)mCryptoHandlers.get(arrayOfString[0]);
    } else {
      localObject = null;
    }
    CryptoHandler localCryptoHandler;
    if (localObject == null) {
      localCryptoHandler = null;
    } else {
      localCryptoHandler = mCryptoHandler;
    }
    if (localCryptoHandler == null)
    {
      AppCenterLog.error("AppCenter", "Failed to decrypt data.");
      return new DecryptedData(paramString, null);
    }
    try
    {
      DecryptedData localDecryptedData = getDecryptedData(localCryptoHandler, mAliasIndex, arrayOfString[1]);
      return localDecryptedData;
    }
    catch (Exception localException2)
    {
      try
      {
        localObject = getDecryptedData(localCryptoHandler, mAliasIndex ^ 0x1, arrayOfString[1]);
        return (DecryptedData)localObject;
      }
      catch (Exception localException1)
      {
        AppCenterLog.error("AppCenter", "Failed to decrypt data.");
      }
    }
    return new DecryptedData(paramString, null);
  }
  
  public String encrypt(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      Object localObject1 = (CryptoHandlerEntry)mCryptoHandlers.values().iterator().next();
      Object localObject2 = mCryptoHandler;
      try
      {
        Object localObject3 = getKeyStoreEntry((CryptoHandlerEntry)localObject1);
        localObject3 = Base64.encodeToString(((CryptoHandler)localObject2).encrypt(mCryptoFactory, mApiLevel, (KeyStore.Entry)localObject3, paramString.getBytes("UTF-8")), 0);
        StringBuilder localStringBuilder2 = new java/lang/StringBuilder;
        localStringBuilder2.<init>();
        localStringBuilder2.append(((CryptoHandler)localObject2).getAlgorithm());
        localStringBuilder2.append(":");
        localStringBuilder2.append((String)localObject3);
        localObject3 = localStringBuilder2.toString();
        return (String)localObject3;
      }
      catch (InvalidKeyException localInvalidKeyException)
      {
        if ((!(localInvalidKeyException.getCause() instanceof CertificateExpiredException)) && (!"android.security.keystore.KeyExpiredException".equals(localInvalidKeyException.getClass().getName()))) {
          throw localInvalidKeyException;
        }
        StringBuilder localStringBuilder1 = new java/lang/StringBuilder;
        localStringBuilder1.<init>();
        localStringBuilder1.append("Alias expired: ");
        localStringBuilder1.append(mAliasIndex);
        AppCenterLog.debug("AppCenter", localStringBuilder1.toString());
        int i = mAliasIndex ^ 0x1;
        mAliasIndex = i;
        localObject1 = getAlias((CryptoHandler)localObject2, i);
        if (mKeyStore.containsAlias((String)localObject1))
        {
          localStringBuilder1 = new java/lang/StringBuilder;
          localStringBuilder1.<init>();
          localStringBuilder1.append("Deleting alias: ");
          localStringBuilder1.append((String)localObject1);
          AppCenterLog.debug("AppCenter", localStringBuilder1.toString());
          mKeyStore.deleteEntry((String)localObject1);
        }
        localStringBuilder1 = new java/lang/StringBuilder;
        localStringBuilder1.<init>();
        localStringBuilder1.append("Creating alias: ");
        localStringBuilder1.append((String)localObject1);
        AppCenterLog.debug("AppCenter", localStringBuilder1.toString());
        ((CryptoHandler)localObject2).generateKey(mCryptoFactory, (String)localObject1, mContext);
        localObject2 = encrypt(paramString);
        return (String)localObject2;
      }
      return paramString;
    }
    catch (Exception localException)
    {
      AppCenterLog.error("AppCenter", "Failed to encrypt data.");
    }
  }
  
  public ICryptoFactory getCryptoFactory()
  {
    return mCryptoFactory;
  }
  
  public static class CryptoHandlerEntry
  {
    public int mAliasIndex;
    public final CryptoHandler mCryptoHandler;
    
    public CryptoHandlerEntry(int paramInt, CryptoHandler paramCryptoHandler)
    {
      mAliasIndex = paramInt;
      mCryptoHandler = paramCryptoHandler;
    }
  }
  
  public static class DecryptedData
  {
    public final String mDecryptedData;
    public final String mNewEncryptedData;
    
    public DecryptedData(String paramString1, String paramString2)
    {
      mDecryptedData = paramString1;
      mNewEncryptedData = paramString2;
    }
    
    public String getDecryptedData()
    {
      return mDecryptedData;
    }
    
    public String getNewEncryptedData()
    {
      return mNewEncryptedData;
    }
  }
  
  public static abstract interface ICipher
  {
    public abstract byte[] doFinal(byte[] paramArrayOfByte);
    
    public abstract byte[] doFinal(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
    
    public abstract String getAlgorithm();
    
    public abstract int getBlockSize();
    
    public abstract byte[] getIV();
    
    public abstract String getProvider();
    
    public abstract void init(int paramInt, Key paramKey);
    
    public abstract void init(int paramInt, Key paramKey, AlgorithmParameterSpec paramAlgorithmParameterSpec);
  }
  
  public static abstract interface ICryptoFactory
  {
    public abstract CryptoUtils.ICipher getCipher(String paramString1, String paramString2);
    
    public abstract CryptoUtils.IKeyGenerator getKeyGenerator(String paramString1, String paramString2);
  }
  
  public static abstract interface IKeyGenerator
  {
    public abstract void generateKey();
    
    public abstract void init(AlgorithmParameterSpec paramAlgorithmParameterSpec);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.utils.crypto.CryptoUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */