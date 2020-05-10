package com.microsoft.identity.common.internal.platform;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.security.KeyPairGeneratorSpec.Builder;
import android.security.keystore.KeyGenParameterSpec.Builder;
import android.security.keystore.KeyInfo;
import android.security.keystore.StrongBoxUnavailableException;
import android.text.TextUtils;
import android.util.Base64;
import com.microsoft.identity.common.exception.BaseException;
import com.microsoft.identity.common.exception.ClientException;
import com.microsoft.identity.common.internal.controllers.TaskCompletedCallback;
import com.microsoft.identity.common.internal.controllers.TaskCompletedCallbackWithError;
import com.microsoft.identity.common.internal.logging.Logger;
import e.e.a.f;
import e.e.a.l;
import e.e.a.m;
import e.e.a.n;
import e.e.a.u.g;
import e.e.a.u.k;
import e.e.a.u.k.a;
import e.e.b.e;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStore.Entry;
import java.security.KeyStore.PrivateKeyEntry;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.UnrecoverableEntryException;
import java.security.cert.Certificate;
import java.security.interfaces.RSAMultiPrimePrivateCrtKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAKeyGenParameterSpec;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.security.auth.x500.X500Principal;
import org.json.JSONException;
import org.json.JSONObject;

public class DevicePopManager
  implements IDevicePopManager
{
  public static final String ANDROID_KEYSTORE = "AndroidKeyStore";
  public static final String KEYSTORE_ENTRY_ALIAS = "microsoft-device-pop";
  public static final int RSA_KEY_SIZE = 2048;
  public static final String TAG = "DevicePopManager";
  public static final ExecutorService sThreadExecutor = ;
  public final KeyStore mKeyStore;
  
  public DevicePopManager()
  {
    KeyStore localKeyStore = KeyStore.getInstance("AndroidKeyStore");
    mKeyStore = localKeyStore;
    localKeyStore.load(null);
  }
  
  @SuppressLint({"NewApi"})
  public static KeyGenParameterSpec.Builder applyHardwareIsolation(KeyGenParameterSpec.Builder paramBuilder)
  {
    return paramBuilder.setIsStrongBoxBacked(true);
  }
  
  public static String base64UrlEncode(String paramString)
  {
    try
    {
      paramString = Base64.encodeToString(paramString.getBytes("UTF-8"), 11);
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
      paramString = null;
    }
    return paramString;
  }
  
  private KeyPair generateNewKeyPair(Context paramContext, boolean paramBoolean)
  {
    return getInitializedRsaKeyPairGenerator(paramContext, 2048, paramBoolean).generateKeyPair();
  }
  
  @SuppressLint({"NewApi"})
  private KeyPair generateNewRsaKeyPair(Context paramContext, int paramInt)
  {
    int i = 0;
    while (i < 4)
    {
      KeyPair localKeyPair2;
      try
      {
        KeyPair localKeyPair1 = generateNewKeyPair(paramContext, true);
      }
      catch (StrongBoxUnavailableException localStrongBoxUnavailableException)
      {
        Logger.error(TAG, "StrongBox unsupported - skipping hardware flags.", localStrongBoxUnavailableException);
        localKeyPair2 = generateNewKeyPair(paramContext, false);
      }
      int j = e.c.a.a.b.l.c.a(localKeyPair2.getPrivate());
      if ((j < paramInt) && (j >= 0))
      {
        i++;
      }
      else
      {
        logSecureHardwareState(localKeyPair2);
        return localKeyPair2;
      }
    }
    clearAsymmetricKey();
    throw new UnsupportedOperationException("Failed to generate valid KeyPair. Attempted 4 times.");
  }
  
  private j.a.b.d getDevicePopJwkMinifiedJson()
  {
    Object localObject1 = mKeyStore;
    Object localObject2 = null;
    k localk = getRsaKeyForKeyPair(getKeyPairForEntry(((KeyStore)localObject1).getEntry("microsoft-device-pop", null)));
    e.e.a.v.c localc1 = I;
    e.e.a.v.c localc2 = J;
    localObject1 = y;
    Set localSet = z;
    e.e.a.a locala = A;
    String str = B;
    URI localURI = C;
    e.e.a.v.c localc3 = D;
    e.e.a.v.c localc4 = E;
    List localList = F;
    if (localList != null) {
      localObject2 = Collections.unmodifiableList(localList);
    }
    localObject2 = new k(localc1, localc2, null, null, null, null, null, null, null, null, (g)localObject1, localSet, locala, str, localURI, localc3, localc4, (List)localObject2, H).f();
    localObject1 = new j.a.b.d();
    ((HashMap)localObject1).put("jwk", localObject2);
    return (j.a.b.d)localObject1;
  }
  
  private KeyPairGenerator getInitializedRsaKeyPairGenerator(Context paramContext, int paramInt, boolean paramBoolean)
  {
    KeyPairGenerator localKeyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
    initialize(paramContext, localKeyPairGenerator, paramInt, paramBoolean);
    return localKeyPairGenerator;
  }
  
  public static KeyPair getKeyPairForEntry(KeyStore.Entry paramEntry)
  {
    paramEntry = (KeyStore.PrivateKeyEntry)paramEntry;
    PrivateKey localPrivateKey = paramEntry.getPrivateKey();
    return new KeyPair(paramEntry.getCertificate().getPublicKey(), localPrivateKey);
  }
  
  public static Date getNow(Calendar paramCalendar)
  {
    return paramCalendar.getTime();
  }
  
  public static String getReqCnfForRsaKey(k paramk)
  {
    paramk = getThumbprintForRsaKey(paramk);
    return base64UrlEncode(new JSONObject().put("kid", paramk).toString());
  }
  
  public static k getRsaKeyForKeyPair(KeyPair paramKeyPair)
  {
    Object localObject1 = (RSAPublicKey)paramKeyPair.getPublic();
    e.e.a.v.c localc1 = e.e.a.v.c.a(((RSAPublicKey)localObject1).getModulus());
    e.e.a.v.c localc2 = e.e.a.v.c.a(((RSAPublicKey)localObject1).getPublicExponent());
    Object localObject2 = paramKeyPair.getPrivate();
    Object localObject3;
    Object localObject4;
    Object localObject5;
    Object localObject6;
    Object localObject7;
    Object localObject9;
    Object localObject10;
    if ((localObject2 instanceof RSAPrivateKey))
    {
      paramKeyPair = (RSAPrivateKey)localObject2;
      if ((paramKeyPair instanceof RSAPrivateCrtKey))
      {
        localObject3 = (RSAPrivateCrtKey)paramKeyPair;
        paramKeyPair = e.e.a.v.c.a(((RSAPrivateCrtKey)localObject3).getPrivateExponent());
        localObject1 = e.e.a.v.c.a(((RSAPrivateCrtKey)localObject3).getPrimeP());
        localObject4 = e.e.a.v.c.a(((RSAPrivateCrtKey)localObject3).getPrimeQ());
        localObject5 = e.e.a.v.c.a(((RSAPrivateCrtKey)localObject3).getPrimeExponentP());
        localObject2 = e.e.a.v.c.a(((RSAPrivateCrtKey)localObject3).getPrimeExponentQ());
        localObject3 = e.e.a.v.c.a(((RSAPrivateCrtKey)localObject3).getCrtCoefficient());
        localObject6 = null;
      }
      else if ((paramKeyPair instanceof RSAMultiPrimePrivateCrtKey))
      {
        localObject6 = (RSAMultiPrimePrivateCrtKey)paramKeyPair;
        paramKeyPair = e.e.a.v.c.a(((RSAMultiPrimePrivateCrtKey)localObject6).getPrivateExponent());
        localObject1 = e.e.a.v.c.a(((RSAMultiPrimePrivateCrtKey)localObject6).getPrimeP());
        localObject4 = e.e.a.v.c.a(((RSAMultiPrimePrivateCrtKey)localObject6).getPrimeQ());
        localObject5 = e.e.a.v.c.a(((RSAMultiPrimePrivateCrtKey)localObject6).getPrimeExponentP());
        localObject2 = e.e.a.v.c.a(((RSAMultiPrimePrivateCrtKey)localObject6).getPrimeExponentQ());
        localObject3 = e.e.a.v.c.a(((RSAMultiPrimePrivateCrtKey)localObject6).getCrtCoefficient());
        localObject7 = ((RSAMultiPrimePrivateCrtKey)localObject6).getOtherPrimeInfo();
        localObject6 = new ArrayList();
        if (localObject7 != null)
        {
          int i = localObject7.length;
          for (int j = 0; j < i; j++) {
            ((ArrayList)localObject6).add(new k.a(localObject7[j]));
          }
        }
      }
      else
      {
        paramKeyPair = e.e.a.v.c.a(paramKeyPair.getPrivateExponent());
        localObject3 = null;
        localObject1 = localObject3;
        localObject4 = localObject1;
        localObject5 = localObject4;
        localObject2 = localObject5;
        localObject6 = localObject2;
      }
      Object localObject8 = null;
      localObject7 = localObject1;
      localObject1 = paramKeyPair;
      paramKeyPair = (KeyPair)localObject7;
      localObject9 = localObject4;
      localObject4 = localObject5;
      localObject5 = localObject2;
      localObject7 = localObject3;
      localObject10 = localObject6;
      localObject2 = localObject8;
    }
    else
    {
      if (!"RSA".equalsIgnoreCase(((PrivateKey)localObject2).getAlgorithm())) {
        break label462;
      }
      localObject6 = null;
      paramKeyPair = (KeyPair)localObject6;
      localObject1 = paramKeyPair;
      localObject3 = localObject1;
      localObject4 = localObject3;
      localObject5 = localObject4;
      localObject10 = localObject5;
      localObject7 = localObject5;
      localObject5 = localObject4;
      localObject4 = localObject3;
      localObject9 = localObject1;
      localObject1 = localObject6;
    }
    try
    {
      paramKeyPair = new k(localc1, localc2, (e.e.a.v.c)localObject1, paramKeyPair, (e.e.a.v.c)localObject9, (e.e.a.v.c)localObject4, (e.e.a.v.c)localObject5, (e.e.a.v.c)localObject7, (List)localObject10, (PrivateKey)localObject2, null, null, null, null, null, null, null, null, null);
      return paramKeyPair;
    }
    catch (IllegalArgumentException paramKeyPair)
    {
      throw new IllegalStateException(paramKeyPair.getMessage(), paramKeyPair);
    }
    label462:
    throw new IllegalArgumentException("The private key algorithm must be RSA");
  }
  
  public static String getThumbprintForRsaKey(k paramk)
  {
    Object localObject = j.a.b.d.a(paramk.d());
    try
    {
      paramk = MessageDigest.getInstance("SHA-256");
      paramk.update(((String)localObject).getBytes(e.e.a.v.d.a));
      return adigestx;
    }
    catch (NoSuchAlgorithmException paramk)
    {
      localObject = e.a.a.a.a.a("Couldn't compute JWK thumbprint: Unsupported hash algorithm: ");
      ((StringBuilder)localObject).append(paramk.getMessage());
      throw new f(((StringBuilder)localObject).toString(), paramk);
    }
  }
  
  public static void initialize(Context paramContext, KeyPairGenerator paramKeyPairGenerator, int paramInt, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 23) {
      initializePre23(paramContext, paramKeyPairGenerator, paramInt);
    } else {
      initialize23(paramKeyPairGenerator, paramInt, paramBoolean);
    }
  }
  
  @SuppressLint({"InlinedApi"})
  public static void initialize23(KeyPairGenerator paramKeyPairGenerator, int paramInt, boolean paramBoolean)
  {
    KeyGenParameterSpec.Builder localBuilder1 = new KeyGenParameterSpec.Builder("microsoft-device-pop", 15).setKeySize(paramInt).setSignaturePaddings(new String[] { "PKCS1" }).setDigests(new String[] { "SHA-256" });
    KeyGenParameterSpec.Builder localBuilder2 = localBuilder1;
    if (Build.VERSION.SDK_INT >= 28)
    {
      localBuilder2 = localBuilder1;
      if (paramBoolean)
      {
        Logger.verbose(TAG, "Attempting to apply StrongBox isolation.");
        localBuilder2 = applyHardwareIsolation(localBuilder1);
      }
    }
    paramKeyPairGenerator.initialize(localBuilder2.build());
  }
  
  @SuppressLint({"NewApi"})
  public static void initializePre23(Context paramContext, KeyPairGenerator paramKeyPairGenerator, int paramInt)
  {
    Object localObject = Calendar.getInstance();
    Date localDate = getNow((Calendar)localObject);
    ((Calendar)localObject).add(1, 99);
    localObject = ((Calendar)localObject).getTime();
    paramContext = new KeyPairGeneratorSpec.Builder(paramContext).setAlias("microsoft-device-pop").setStartDate(localDate).setEndDate((Date)localObject).setSerialNumber(CertificateProperties.SERIAL_NUMBER).setSubject(new X500Principal("CN=device-pop"));
    paramContext.setAlgorithmParameterSpec(new RSAKeyGenParameterSpec(paramInt, RSAKeyGenParameterSpec.F4));
    paramKeyPairGenerator.initialize(paramContext.build());
  }
  
  private void logSecureHardwareState(KeyPair paramKeyPair)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      try
      {
        paramKeyPair = paramKeyPair.getPrivate();
        boolean bool = ((KeyInfo)KeyFactory.getInstance(paramKeyPair.getAlgorithm(), "AndroidKeyStore").getKeySpec(paramKeyPair, KeyInfo.class)).isInsideSecureHardware();
        paramKeyPair = new java/lang/StringBuilder;
        paramKeyPair.<init>();
        paramKeyPair.append("SecretKey is secure hardware backed? ");
        paramKeyPair.append(bool);
        paramKeyPair = paramKeyPair.toString();
      }
      catch (Exception paramKeyPair)
      {
        paramKeyPair = "Failed to query secure hardware state.";
      }
    } else {
      paramKeyPair = "Cannot query secure hardware state (API unavailable <23)";
    }
    Logger.info(TAG, paramKeyPair);
  }
  
  public boolean asymmetricKeyExists()
  {
    boolean bool;
    try
    {
      bool = mKeyStore.containsAlias("microsoft-device-pop");
    }
    catch (KeyStoreException localKeyStoreException)
    {
      Logger.error(TAG, "Error while querying KeyStore", localKeyStoreException);
      bool = false;
    }
    return bool;
  }
  
  public boolean asymmetricKeyExists(String paramString)
  {
    if (asymmetricKeyExists()) {
      try
      {
        boolean bool = getAsymmetricKeyThumbprint().equals(paramString);
        return bool;
      }
      catch (ClientException paramString)
      {
        Logger.error(TAG, "Error while comparing thumbprints.", paramString);
      }
    }
    return false;
  }
  
  public boolean clearAsymmetricKey()
  {
    boolean bool;
    try
    {
      mKeyStore.deleteEntry("microsoft-device-pop");
      bool = true;
    }
    catch (KeyStoreException localKeyStoreException)
    {
      Logger.error(TAG, "Error while clearing KeyStore", localKeyStoreException);
      bool = false;
    }
    return bool;
  }
  
  public String generateAsymmetricKey(Context paramContext)
  {
    try
    {
      paramContext = getThumbprintForRsaKey(getRsaKeyForKeyPair(generateNewRsaKeyPair(paramContext, 2048)));
      return paramContext;
    }
    catch (f localf)
    {
      paramContext = "failed_to_compute_thumbprint_with_sha256";
    }
    catch (InvalidAlgorithmParameterException localInvalidAlgorithmParameterException)
    {
      paramContext = "keystore_initialization_failed";
    }
    catch (NoSuchProviderException localNoSuchProviderException)
    {
      paramContext = "android_keystore_unavailable";
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      paramContext = "no_such_algorithm";
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      paramContext = "keystore_produced_invalid_cert";
    }
    paramContext = new ClientException(paramContext, localUnsupportedOperationException.getMessage(), localUnsupportedOperationException);
    Logger.error(TAG, paramContext.getMessage(), paramContext);
    throw paramContext;
  }
  
  public void generateAsymmetricKey(final Context paramContext, final TaskCompletedCallbackWithError<String, ClientException> paramTaskCompletedCallbackWithError)
  {
    sThreadExecutor.submit(new Runnable()
    {
      public void run()
      {
        try
        {
          paramTaskCompletedCallbackWithError.onTaskCompleted(generateAsymmetricKey(paramContext));
        }
        catch (ClientException localClientException)
        {
          paramTaskCompletedCallbackWithError.onError(localClientException);
        }
      }
    });
  }
  
  public String getAsymmetricKeyThumbprint()
  {
    String str2;
    try
    {
      String str1 = getThumbprintForRsaKey(getRsaKeyForKeyPair(getKeyPairForEntry(mKeyStore.getEntry("microsoft-device-pop", null))));
      return str1;
    }
    catch (f localf)
    {
      str2 = "failed_to_compute_thumbprint_with_sha256";
    }
    catch (UnrecoverableEntryException localUnrecoverableEntryException)
    {
      str2 = "protection_params_invalid";
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      str2 = "no_such_algorithm";
    }
    catch (KeyStoreException localKeyStoreException)
    {
      str2 = "keystore_not_initialized";
    }
    throw new ClientException(str2, localKeyStoreException.getMessage(), localKeyStoreException);
  }
  
  public String getRequestConfirmation()
  {
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    final String[] arrayOfString = new String[1];
    final ClientException[] arrayOfClientException = new ClientException[1];
    getRequestConfirmation(new TaskCompletedCallbackWithError()
    {
      public void onError(ClientException paramAnonymousClientException)
      {
        arrayOfClientException[0] = paramAnonymousClientException;
        localCountDownLatch.countDown();
      }
      
      public void onTaskCompleted(String paramAnonymousString)
      {
        arrayOfString[0] = paramAnonymousString;
        localCountDownLatch.countDown();
      }
    });
    try
    {
      localCountDownLatch.await();
      if (arrayOfString[0] != null) {
        return arrayOfString[0];
      }
      throw arrayOfClientException[0];
    }
    catch (InterruptedException localInterruptedException)
    {
      Logger.error(TAG, "Interrupted while waiting on callback.", localInterruptedException);
      throw new ClientException("operation_interrupted", localInterruptedException.getMessage(), localInterruptedException);
    }
  }
  
  public void getRequestConfirmation(final TaskCompletedCallbackWithError<String, ClientException> paramTaskCompletedCallbackWithError)
  {
    sThreadExecutor.submit(new Runnable()
    {
      public void run()
      {
        String str2;
        try
        {
          String str1 = DevicePopManager.access$300(DevicePopManager.access$200(DevicePopManager.access$100(DevicePopManager.access$000(DevicePopManager.this).getEntry("microsoft-device-pop", null))));
          paramTaskCompletedCallbackWithError.onTaskCompleted(str1);
          return;
        }
        catch (JSONException localJSONException)
        {
          str2 = "json_construction_failed";
        }
        catch (f localf)
        {
          str2 = "failed_to_compute_thumbprint_with_sha256";
        }
        catch (UnrecoverableEntryException localUnrecoverableEntryException)
        {
          str2 = "protection_params_invalid";
        }
        catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
        {
          str2 = "no_such_algorithm";
        }
        catch (KeyStoreException localKeyStoreException)
        {
          str2 = "keystore_not_initialized";
        }
        ClientException localClientException = new ClientException(str2, localKeyStoreException.getMessage(), localKeyStoreException);
        Logger.error(DevicePopManager.access$400(), localClientException.getMessage(), localClientException);
        paramTaskCompletedCallbackWithError.onError(localClientException);
      }
    });
  }
  
  public String mintSignedAccessToken(String paramString1, URL paramURL, String paramString2, String paramString3)
  {
    try
    {
      Object localObject = new java/util/LinkedHashMap;
      ((LinkedHashMap)localObject).<init>();
      ((HashMap)localObject).put("at", paramString2);
      ((HashMap)localObject).put("ts", Long.valueOf(System.currentTimeMillis() / 1000L));
      ((HashMap)localObject).put("m", paramString1);
      ((HashMap)localObject).put("u", paramURL.getHost());
      ((HashMap)localObject).put("p", paramURL.getPath());
      ((HashMap)localObject).put("cnf", getDevicePopJwkMinifiedJson());
      if (!TextUtils.isEmpty(paramString3)) {
        ((HashMap)localObject).put("nonce", paramString3);
      }
      paramString1 = new e/e/b/c;
      paramString1.<init>((Map)localObject, null);
      try
      {
        paramString2 = ((KeyStore.PrivateKeyEntry)mKeyStore.getEntry("microsoft-device-pop", null)).getPrivateKey();
        paramURL = new e/e/a/s/a;
        paramURL.<init>(paramString2);
        paramString2 = new e/e/b/e;
        paramString3 = l.C;
        if (!x.equals(yx))
        {
          localObject = new e/e/a/m;
          ((m)localObject).<init>(paramString3, null, null, null, null, null, null, null, null, null, null, null, null);
          paramString2.<init>((m)localObject, paramString1);
          paramString2.b(paramURL);
          return paramString2.c();
        }
        paramString1 = new java/lang/IllegalArgumentException;
        paramString1.<init>("The JWS algorithm \"alg\" cannot be \"none\"");
        throw paramString1;
      }
      catch (UnrecoverableEntryException paramString1) {}catch (f paramString1) {}catch (KeyStoreException paramString1) {}catch (NoSuchAlgorithmException paramString1) {}
      paramURL = "no_such_algorithm";
    }
    catch (UnrecoverableEntryException paramString1)
    {
      paramURL = "protection_params_invalid";
    }
    catch (f paramString1)
    {
      paramURL = "failed_to_sign_jwt";
    }
    catch (KeyStoreException paramString1)
    {
      paramURL = "keystore_not_initialized";
    }
    catch (NoSuchAlgorithmException paramString1) {}
    paramString1 = new ClientException(paramURL, paramString1.getMessage(), paramString1);
    Logger.error(TAG, paramString1.getMessage(), paramString1);
    throw paramString1;
  }
  
  public static final class CertificateProperties
  {
    public static final int CERTIFICATE_VALIDITY_YEARS = 99;
    public static final String COMMON_NAME = "CN=device-pop";
    public static final BigInteger SERIAL_NUMBER = BigInteger.ONE;
  }
  
  public static final class KeyPairGeneratorAlgorithms
  {
    public static final String RSA = "RSA";
  }
  
  public static final class SignedHttpRequestJwtClaims
  {
    public static final String ACCESS_TOKEN = "at";
    public static final String CNF = "cnf";
    public static final String HTTP_HOST = "u";
    public static final String HTTP_METHOD = "m";
    public static final String HTTP_PATH = "p";
    public static final String NONCE = "nonce";
    public static final String TIMESTAMP = "ts";
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.platform.DevicePopManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */