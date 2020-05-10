package com.microsoft.identity.common.internal.platform;

import android.os.Build;
import android.os.Build.VERSION;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Device
{
  public static IDevicePopManager sDevicePoPManager;
  
  public static int getApiLevel()
  {
    return Build.VERSION.SDK_INT;
  }
  
  /* Error */
  public static IDevicePopManager getDevicePoPManagerInstance()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 34	com/microsoft/identity/common/internal/platform/Device:sDevicePoPManager	Lcom/microsoft/identity/common/internal/platform/IDevicePopManager;
    //   6: ifnonnull +15 -> 21
    //   9: new 36	com/microsoft/identity/common/internal/platform/DevicePopManager
    //   12: astore_0
    //   13: aload_0
    //   14: invokespecial 37	com/microsoft/identity/common/internal/platform/DevicePopManager:<init>	()V
    //   17: aload_0
    //   18: putstatic 34	com/microsoft/identity/common/internal/platform/Device:sDevicePoPManager	Lcom/microsoft/identity/common/internal/platform/IDevicePopManager;
    //   21: getstatic 34	com/microsoft/identity/common/internal/platform/Device:sDevicePoPManager	Lcom/microsoft/identity/common/internal/platform/IDevicePopManager;
    //   24: astore_0
    //   25: ldc 2
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: astore_0
    //   31: goto +57 -> 88
    //   34: astore_0
    //   35: goto +12 -> 47
    //   38: astore_0
    //   39: goto +8 -> 47
    //   42: astore_0
    //   43: goto +4 -> 47
    //   46: astore_0
    //   47: new 39	com/microsoft/identity/common/exception/ClientException
    //   50: astore_1
    //   51: new 41	java/lang/StringBuilder
    //   54: astore_2
    //   55: aload_2
    //   56: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   59: aload_2
    //   60: ldc 44
    //   62: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_2
    //   67: aload_0
    //   68: invokevirtual 54	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   71: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload_1
    //   76: ldc 56
    //   78: aload_2
    //   79: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: aload_0
    //   83: invokespecial 62	com/microsoft/identity/common/exception/ClientException:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   86: aload_1
    //   87: athrow
    //   88: ldc 2
    //   90: monitorexit
    //   91: aload_0
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	17	0	localObject1	Object
    //   30	1	0	localObject2	Object
    //   34	1	0	localIOException	java.io.IOException
    //   38	1	0	localKeyStoreException	java.security.KeyStoreException
    //   42	1	0	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   46	46	0	localCertificateException	java.security.cert.CertificateException
    //   50	37	1	localClientException	com.microsoft.identity.common.exception.ClientException
    //   54	25	2	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   3	21	30	finally
    //   21	25	30	finally
    //   47	88	30	finally
    //   3	21	34	java/io/IOException
    //   21	25	34	java/io/IOException
    //   3	21	38	java/security/KeyStoreException
    //   21	25	38	java/security/KeyStoreException
    //   3	21	42	java/security/NoSuchAlgorithmException
    //   21	25	42	java/security/NoSuchAlgorithmException
    //   3	21	46	java/security/cert/CertificateException
    //   21	25	46	java/security/cert/CertificateException
  }
  
  public static String getManufacturer()
  {
    return Build.MANUFACTURER;
  }
  
  public static String getModel()
  {
    return Build.MODEL;
  }
  
  public static Map<String, String> getPlatformIdParameters()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("x-client-SKU", "MSAL.Android");
    localHashMap.put("x-client-Ver", "1.4.0");
    String[] arrayOfString = Build.SUPPORTED_ABIS;
    if ((arrayOfString != null) && (arrayOfString.length > 0)) {
      localHashMap.put("x-client-CPU", arrayOfString[0]);
    }
    localHashMap.put("x-client-OS", String.valueOf(Build.VERSION.SDK_INT));
    localHashMap.put("x-client-DM", Build.MODEL);
    return Collections.unmodifiableMap(localHashMap);
  }
  
  public static final class PlatformIdParameters
  {
    public static final String BROKER_VERSION = "x-client-brkrver";
    public static final String CPU_PLATFORM = "x-client-CPU";
    public static final String DEVICE_MODEL = "x-client-DM";
    public static final String OS = "x-client-OS";
    public static final String PRODUCT = "x-client-SKU";
    public static final String PRODUCT_NAME = "MSAL.Android";
    public static final String PRODUCT_VERSION = "1.4.0";
    public static final String VERSION = "x-client-Ver";
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.platform.Device
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */