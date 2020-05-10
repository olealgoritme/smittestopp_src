package com.microsoft.identity.common.internal.broker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.util.Base64;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.internal.logging.Logger;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PackageHelper
{
  public static final String TAG = "CallerInfo";
  public PackageManager mPackageManager;
  
  public PackageHelper(PackageManager paramPackageManager)
  {
    mPackageManager = paramPackageManager;
  }
  
  public static String getBrokerRedirectUrl(String paramString1, String paramString2)
  {
    if ((!StringExtensions.isNullOrBlank(paramString1)) && (!StringExtensions.isNullOrBlank(paramString2)))
    {
      if ((paramString1.equals("com.azure.authenticator")) && (paramString2.equals("ho040S3ffZkmxqtQrSwpTVOn9r0="))) {
        return "urn:ietf:wg:oauth:2.0:oob";
      }
      try
      {
        paramString1 = String.format("%s://%s/%s", new Object[] { "msauth", URLEncoder.encode(paramString1, "UTF-8"), URLEncoder.encode(paramString2, "UTF-8") });
        return paramString1;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        Logger.error("CallerInfo", "", "Encoding is not supported", paramString1);
      }
    }
    return "";
  }
  
  @SuppressLint({"PackageManagerGetSignatures"})
  public String getCurrentSignatureForPackage(String paramString)
  {
    try
    {
      paramString = mPackageManager.getPackageInfo(paramString, 64);
      if ((paramString != null) && (signatures != null) && (signatures.length > 0))
      {
        paramString = signatures[0];
        MessageDigest localMessageDigest = MessageDigest.getInstance("SHA");
        localMessageDigest.update(paramString.toByteArray());
        paramString = Base64.encodeToString(localMessageDigest.digest(), 2);
        return paramString;
      }
    }
    catch (NoSuchAlgorithmException paramString)
    {
      Logger.error("CallerInfo", "Digest SHA algorithm does not exists. ", "", paramString);
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      Logger.error("CallerInfo", "Calling App's package does not exist in PackageManager. ", "", paramString);
    }
    return null;
  }
  
  public int getUIDForPackage(String paramString)
  {
    int i = 0;
    int j;
    try
    {
      ApplicationInfo localApplicationInfo = mPackageManager.getApplicationInfo(paramString, 0);
      j = i;
      if (localApplicationInfo != null) {
        j = uid;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Package name: ");
      localStringBuilder.append(paramString);
      Logger.error("CallerInfo", "Package is not found. ", localStringBuilder.toString(), localNameNotFoundException);
      j = i;
    }
    return j;
  }
  
  public boolean isPackageInstalledAndEnabled(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager();
    boolean bool1 = false;
    boolean bool2;
    try
    {
      paramContext = paramContext.getApplicationInfo(paramString, 0);
      bool2 = bool1;
      if (paramContext != null) {
        bool2 = enabled;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      paramContext = new StringBuilder();
      paramContext.append("Package is not found. Package name: ");
      paramContext.append(paramString);
      Logger.error("CallerInfo#isPackageInstalledAndEnabled", paramContext.toString(), localNameNotFoundException);
      bool2 = bool1;
    }
    paramContext = new StringBuilder();
    paramContext.append(" Is package installed and enabled? [");
    paramContext.append(bool2);
    paramContext.append("]");
    Logger.info("CallerInfo#isPackageInstalledAndEnabled", paramContext.toString());
    return bool2;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.broker.PackageHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */