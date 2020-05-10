package com.microsoft.appcenter.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.microsoft.appcenter.ingestion.models.WrapperSdk;

public class DeviceInfoHelper
{
  public static final String OS_NAME = "Android";
  public static WrapperSdk sWrapperSdk;
  
  /* Error */
  public static com.microsoft.appcenter.ingestion.models.Device getDeviceInfo(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 24	com/microsoft/appcenter/ingestion/models/Device
    //   6: astore_1
    //   7: aload_1
    //   8: invokespecial 25	com/microsoft/appcenter/ingestion/models/Device:<init>	()V
    //   11: aload_0
    //   12: invokevirtual 31	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   15: aload_0
    //   16: invokevirtual 35	android/content/Context:getPackageName	()Ljava/lang/String;
    //   19: iconst_0
    //   20: invokevirtual 41	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   23: astore_2
    //   24: aload_1
    //   25: aload_2
    //   26: getfield 46	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   29: invokevirtual 50	com/microsoft/appcenter/ingestion/models/Device:setAppVersion	(Ljava/lang/String;)V
    //   32: aload_1
    //   33: aload_2
    //   34: invokestatic 54	com/microsoft/appcenter/utils/DeviceInfoHelper:getVersionCode	(Landroid/content/pm/PackageInfo;)I
    //   37: invokestatic 60	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   40: invokevirtual 63	com/microsoft/appcenter/ingestion/models/Device:setAppBuild	(Ljava/lang/String;)V
    //   43: aload_1
    //   44: aload_0
    //   45: invokevirtual 35	android/content/Context:getPackageName	()Ljava/lang/String;
    //   48: invokevirtual 66	com/microsoft/appcenter/ingestion/models/Device:setAppNamespace	(Ljava/lang/String;)V
    //   51: aload_0
    //   52: ldc 68
    //   54: invokevirtual 72	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   57: checkcast 74	android/telephony/TelephonyManager
    //   60: astore_3
    //   61: aload_3
    //   62: invokevirtual 77	android/telephony/TelephonyManager:getNetworkCountryIso	()Ljava/lang/String;
    //   65: astore_2
    //   66: aload_2
    //   67: invokestatic 83	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   70: ifne +8 -> 78
    //   73: aload_1
    //   74: aload_2
    //   75: invokevirtual 86	com/microsoft/appcenter/ingestion/models/Device:setCarrierCountry	(Ljava/lang/String;)V
    //   78: aload_3
    //   79: invokevirtual 89	android/telephony/TelephonyManager:getNetworkOperatorName	()Ljava/lang/String;
    //   82: astore_2
    //   83: aload_2
    //   84: invokestatic 83	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   87: ifne +20 -> 107
    //   90: aload_1
    //   91: aload_2
    //   92: invokevirtual 92	com/microsoft/appcenter/ingestion/models/Device:setCarrierName	(Ljava/lang/String;)V
    //   95: goto +12 -> 107
    //   98: astore_2
    //   99: ldc 94
    //   101: ldc 96
    //   103: aload_2
    //   104: invokestatic 102	com/microsoft/appcenter/utils/AppCenterLog:error	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   107: aload_1
    //   108: invokestatic 108	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   111: invokevirtual 111	java/util/Locale:toString	()Ljava/lang/String;
    //   114: invokevirtual 114	com/microsoft/appcenter/ingestion/models/Device:setLocale	(Ljava/lang/String;)V
    //   117: aload_1
    //   118: getstatic 119	android/os/Build:MODEL	Ljava/lang/String;
    //   121: invokevirtual 122	com/microsoft/appcenter/ingestion/models/Device:setModel	(Ljava/lang/String;)V
    //   124: aload_1
    //   125: getstatic 125	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   128: invokevirtual 128	com/microsoft/appcenter/ingestion/models/Device:setOemName	(Ljava/lang/String;)V
    //   131: aload_1
    //   132: getstatic 134	android/os/Build$VERSION:SDK_INT	I
    //   135: invokestatic 139	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   138: invokevirtual 143	com/microsoft/appcenter/ingestion/models/Device:setOsApiLevel	(Ljava/lang/Integer;)V
    //   141: aload_1
    //   142: ldc 11
    //   144: invokevirtual 146	com/microsoft/appcenter/ingestion/models/Device:setOsName	(Ljava/lang/String;)V
    //   147: aload_1
    //   148: getstatic 149	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   151: invokevirtual 152	com/microsoft/appcenter/ingestion/models/Device:setOsVersion	(Ljava/lang/String;)V
    //   154: aload_1
    //   155: getstatic 155	android/os/Build:ID	Ljava/lang/String;
    //   158: invokevirtual 158	com/microsoft/appcenter/ingestion/models/Device:setOsBuild	(Ljava/lang/String;)V
    //   161: aload_1
    //   162: aload_0
    //   163: invokestatic 162	com/microsoft/appcenter/utils/DeviceInfoHelper:getScreenSize	(Landroid/content/Context;)Ljava/lang/String;
    //   166: invokevirtual 165	com/microsoft/appcenter/ingestion/models/Device:setScreenSize	(Ljava/lang/String;)V
    //   169: goto +12 -> 181
    //   172: astore_0
    //   173: ldc 94
    //   175: ldc -89
    //   177: aload_0
    //   178: invokestatic 102	com/microsoft/appcenter/utils/AppCenterLog:error	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   181: aload_1
    //   182: ldc -87
    //   184: invokevirtual 172	com/microsoft/appcenter/ingestion/models/Device:setSdkName	(Ljava/lang/String;)V
    //   187: aload_1
    //   188: ldc -82
    //   190: invokevirtual 177	com/microsoft/appcenter/ingestion/models/Device:setSdkVersion	(Ljava/lang/String;)V
    //   193: aload_1
    //   194: invokestatic 182	java/util/TimeZone:getDefault	()Ljava/util/TimeZone;
    //   197: invokestatic 188	java/lang/System:currentTimeMillis	()J
    //   200: invokevirtual 192	java/util/TimeZone:getOffset	(J)I
    //   203: bipush 60
    //   205: idiv
    //   206: sipush 1000
    //   209: idiv
    //   210: invokestatic 139	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   213: invokevirtual 195	com/microsoft/appcenter/ingestion/models/Device:setTimeZoneOffset	(Ljava/lang/Integer;)V
    //   216: getstatic 197	com/microsoft/appcenter/utils/DeviceInfoHelper:sWrapperSdk	Lcom/microsoft/appcenter/ingestion/models/WrapperSdk;
    //   219: ifnull +63 -> 282
    //   222: aload_1
    //   223: getstatic 197	com/microsoft/appcenter/utils/DeviceInfoHelper:sWrapperSdk	Lcom/microsoft/appcenter/ingestion/models/WrapperSdk;
    //   226: invokevirtual 202	com/microsoft/appcenter/ingestion/models/WrapperSdk:getWrapperSdkVersion	()Ljava/lang/String;
    //   229: invokevirtual 205	com/microsoft/appcenter/ingestion/models/WrapperSdk:setWrapperSdkVersion	(Ljava/lang/String;)V
    //   232: aload_1
    //   233: getstatic 197	com/microsoft/appcenter/utils/DeviceInfoHelper:sWrapperSdk	Lcom/microsoft/appcenter/ingestion/models/WrapperSdk;
    //   236: invokevirtual 208	com/microsoft/appcenter/ingestion/models/WrapperSdk:getWrapperSdkName	()Ljava/lang/String;
    //   239: invokevirtual 211	com/microsoft/appcenter/ingestion/models/WrapperSdk:setWrapperSdkName	(Ljava/lang/String;)V
    //   242: aload_1
    //   243: getstatic 197	com/microsoft/appcenter/utils/DeviceInfoHelper:sWrapperSdk	Lcom/microsoft/appcenter/ingestion/models/WrapperSdk;
    //   246: invokevirtual 214	com/microsoft/appcenter/ingestion/models/WrapperSdk:getWrapperRuntimeVersion	()Ljava/lang/String;
    //   249: invokevirtual 217	com/microsoft/appcenter/ingestion/models/WrapperSdk:setWrapperRuntimeVersion	(Ljava/lang/String;)V
    //   252: aload_1
    //   253: getstatic 197	com/microsoft/appcenter/utils/DeviceInfoHelper:sWrapperSdk	Lcom/microsoft/appcenter/ingestion/models/WrapperSdk;
    //   256: invokevirtual 220	com/microsoft/appcenter/ingestion/models/WrapperSdk:getLiveUpdateReleaseLabel	()Ljava/lang/String;
    //   259: invokevirtual 223	com/microsoft/appcenter/ingestion/models/WrapperSdk:setLiveUpdateReleaseLabel	(Ljava/lang/String;)V
    //   262: aload_1
    //   263: getstatic 197	com/microsoft/appcenter/utils/DeviceInfoHelper:sWrapperSdk	Lcom/microsoft/appcenter/ingestion/models/WrapperSdk;
    //   266: invokevirtual 226	com/microsoft/appcenter/ingestion/models/WrapperSdk:getLiveUpdateDeploymentKey	()Ljava/lang/String;
    //   269: invokevirtual 229	com/microsoft/appcenter/ingestion/models/WrapperSdk:setLiveUpdateDeploymentKey	(Ljava/lang/String;)V
    //   272: aload_1
    //   273: getstatic 197	com/microsoft/appcenter/utils/DeviceInfoHelper:sWrapperSdk	Lcom/microsoft/appcenter/ingestion/models/WrapperSdk;
    //   276: invokevirtual 232	com/microsoft/appcenter/ingestion/models/WrapperSdk:getLiveUpdatePackageHash	()Ljava/lang/String;
    //   279: invokevirtual 235	com/microsoft/appcenter/ingestion/models/WrapperSdk:setLiveUpdatePackageHash	(Ljava/lang/String;)V
    //   282: ldc 2
    //   284: monitorexit
    //   285: aload_1
    //   286: areturn
    //   287: astore_1
    //   288: ldc 94
    //   290: ldc -19
    //   292: aload_1
    //   293: invokestatic 102	com/microsoft/appcenter/utils/AppCenterLog:error	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   296: new 6	com/microsoft/appcenter/utils/DeviceInfoHelper$DeviceInfoException
    //   299: astore_0
    //   300: aload_0
    //   301: ldc -19
    //   303: aload_1
    //   304: invokespecial 240	com/microsoft/appcenter/utils/DeviceInfoHelper$DeviceInfoException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   307: aload_0
    //   308: athrow
    //   309: astore_0
    //   310: ldc 2
    //   312: monitorexit
    //   313: aload_0
    //   314: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	paramContext	Context
    //   6	280	1	localDevice	com.microsoft.appcenter.ingestion.models.Device
    //   287	17	1	localException1	Exception
    //   23	69	2	localObject	Object
    //   98	6	2	localException2	Exception
    //   60	19	3	localTelephonyManager	android.telephony.TelephonyManager
    // Exception table:
    //   from	to	target	type
    //   51	78	98	java/lang/Exception
    //   78	95	98	java/lang/Exception
    //   161	169	172	java/lang/Exception
    //   11	43	287	java/lang/Exception
    //   3	11	309	finally
    //   11	43	309	finally
    //   43	51	309	finally
    //   51	78	309	finally
    //   78	95	309	finally
    //   99	107	309	finally
    //   107	161	309	finally
    //   161	169	309	finally
    //   173	181	309	finally
    //   181	282	309	finally
    //   288	309	309	finally
  }
  
  @SuppressLint({"SwitchIntDef"})
  public static String getScreenSize(Context paramContext)
  {
    Display localDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    paramContext = new Point();
    localDisplay.getSize(paramContext);
    int i = localDisplay.getRotation();
    int j;
    if ((i != 1) && (i != 3))
    {
      j = x;
      i = y;
    }
    else
    {
      i = x;
      j = y;
    }
    paramContext = new StringBuilder();
    paramContext.append(j);
    paramContext.append("x");
    paramContext.append(i);
    return paramContext.toString();
  }
  
  public static int getVersionCode(PackageInfo paramPackageInfo)
  {
    return versionCode;
  }
  
  public static void setWrapperSdk(WrapperSdk paramWrapperSdk)
  {
    try
    {
      sWrapperSdk = paramWrapperSdk;
      return;
    }
    finally
    {
      paramWrapperSdk = finally;
      throw paramWrapperSdk;
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.utils.DeviceInfoHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */