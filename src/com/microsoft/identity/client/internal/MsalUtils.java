package com.microsoft.identity.client.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.microsoft.identity.client.BrowserTabActivity;
import com.microsoft.identity.client.exception.MsalArgumentException;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.util.StringUtil;
import e.a.a.a.a;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public final class MsalUtils
{
  public static final String CHROME_PACKAGE = "com.android.chrome";
  public static final int DEFAULT_EXPIRATION_TIME_SEC = 3600;
  public static final String ENCODING_UTF8 = "UTF-8";
  public static final String QUERY_STRING_DELIMITER = "&";
  public static final String QUERY_STRING_SYMBOL = "?";
  public static final String TAG = "MsalUtils";
  public static final String TOKEN_HASH_ALGORITHM = "SHA256";
  
  public static String appendQueryParameterToUrl(String paramString, Map<String, String> paramMap)
  {
    if (!isEmpty(paramString))
    {
      if (paramMap.isEmpty()) {
        return paramString;
      }
      Object localObject = new HashSet();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localEntry.getKey());
        localStringBuilder.append("=");
        localStringBuilder.append(urlFormEncode((String)localEntry.getValue()));
        ((HashSet)localObject).add(localStringBuilder.toString());
      }
      localObject = StringUtil.convertSetToString((Set)localObject, "&");
      if (paramString.contains("?"))
      {
        if (paramString.endsWith("&")) {
          paramMap = "%s%s";
        } else {
          paramMap = "%s&%s";
        }
      }
      else {
        paramMap = "%s?%s";
      }
      return String.format(paramMap, new Object[] { paramString, localObject });
    }
    throw new IllegalArgumentException("Empty authority string");
  }
  
  public static String base64UrlEncodeToString(String paramString)
  {
    return Base64.encodeToString(paramString.getBytes(Charset.forName("UTF-8")), 10);
  }
  
  public static Date calculateExpiresOn(String paramString)
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    localGregorianCalendar.add(13, getExpiryOrDefault(paramString));
    return localGregorianCalendar.getTime();
  }
  
  public static Set<String> convertArrayToSet(String[] paramArrayOfString)
  {
    HashSet localHashSet = new HashSet();
    if (paramArrayOfString == null) {
      return localHashSet;
    }
    for (int i = 0; i < paramArrayOfString.length; i++) {
      if (!isEmpty(paramArrayOfString[i])) {
        localHashSet.add(paramArrayOfString[i]);
      }
    }
    return localHashSet;
  }
  
  public static String createHash(String paramString)
  {
    if (!isEmpty(paramString)) {
      return new String(Base64.encode(MessageDigest.getInstance("SHA256").digest(paramString.getBytes("UTF-8")), 2), "UTF-8");
    }
    return paramString;
  }
  
  public static Map<String, String> decodeUrlToMap(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    if ((!isEmpty(paramString1)) && (paramString2 != null))
    {
      paramString1 = new StringTokenizer(paramString1, paramString2);
      while (paramString1.hasMoreTokens())
      {
        Object localObject = paramString1.nextToken().split("=");
        if (localObject.length == 2) {
          try
          {
            paramString2 = urlFormDecode(localObject[0]);
            localObject = urlFormDecode(localObject[1]);
            if ((!isEmpty(paramString2)) && (!isEmpty((String)localObject))) {
              localHashMap.put(paramString2, localObject);
            }
          }
          catch (UnsupportedEncodingException paramString2)
          {
            Logger.errorPII(TAG, "URL form decode failed.", paramString2);
          }
        }
      }
    }
    return localHashMap;
  }
  
  public static Map<String, String> extractJsonObjectIntoMap(String paramString)
  {
    JSONObject localJSONObject = new JSONObject(paramString);
    Iterator localIterator = localJSONObject.keys();
    paramString = new HashMap();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramString.put(str, localJSONObject.getString(str));
    }
    return Collections.unmodifiableMap(paramString);
  }
  
  public static ApplicationInfo getApplicationInfo(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      throw new IllegalStateException("Unable to find the package info, unable to proceed");
    }
  }
  
  public static String getChromePackage(Context paramContext)
  {
    String str = "com.android.chrome";
    Object localObject = paramContext.getPackageManager();
    paramContext = null;
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = getPackageInfo"com.android.chrome"1applicationInfo;
      if (localObject != null)
      {
        boolean bool = enabled;
        if (bool)
        {
          paramContext = str;
          break label47;
        }
      }
      paramContext = null;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      label47:
      Logger.error(TAG, "Failed to retrieve chrome package info.", localNameNotFoundException);
    }
    return paramContext;
  }
  
  public static String getChromePackageWithCustomTabSupport(Context paramContext)
  {
    if (paramContext.getPackageManager() == null)
    {
      Logger.warn(TAG, "getPackageManager() returned null.");
      return null;
    }
    Object localObject = new Intent("android.support.customtabs.action.CustomTabsService");
    paramContext = paramContext.getPackageManager().queryIntentServices((Intent)localObject, 0);
    if ((paramContext != null) && (!paramContext.isEmpty()))
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        localObject = nextserviceInfo;
        if ((localObject != null) && ("com.android.chrome".equals(packageName))) {
          return packageName;
        }
      }
      Logger.warn(TAG, "No pkg with CustomTab support found.");
      return null;
    }
    Logger.warn(TAG, "No Service responded to Intent: android.support.customtabs.action.CustomTabsService");
    return null;
  }
  
  public static long getExpiresOn(long paramLong)
  {
    long l = System.currentTimeMillis();
    return TimeUnit.MILLISECONDS.toSeconds(l) + paramLong;
  }
  
  public static int getExpiryOrDefault(String paramString)
  {
    int i;
    if (isEmpty(paramString)) {
      i = 3600;
    } else {
      i = Integer.parseInt(paramString);
    }
    return i;
  }
  
  public static Set<String> getScopesAsSet(String paramString)
  {
    if (isEmpty(paramString)) {
      return new HashSet();
    }
    String[] arrayOfString = paramString.toLowerCase(Locale.US).split(" ");
    paramString = new HashSet();
    for (int i = 0; i < arrayOfString.length; i++) {
      if (!isEmpty(arrayOfString[i])) {
        paramString.add(arrayOfString[i]);
      }
    }
    return paramString;
  }
  
  public static String getUniqueUserIdentifier(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(base64UrlEncodeToString(paramString1));
    localStringBuilder.append(".");
    localStringBuilder.append(base64UrlEncodeToString(paramString2));
    return localStringBuilder.toString();
  }
  
  public static URL getUrl(String paramString)
  {
    try
    {
      URL localURL = new java/net/URL;
      localURL.<init>(paramString);
      paramString = localURL;
    }
    catch (MalformedURLException paramString)
    {
      Logger.errorPII(TAG, "Url is invalid", paramString);
      paramString = null;
    }
    return paramString;
  }
  
  public static boolean hasCustomTabRedirectActivity(Context paramContext, String paramString)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (localPackageManager == null) {
      return false;
    }
    paramContext = new Intent();
    paramContext.setAction("android.intent.action.VIEW");
    paramContext.addCategory("android.intent.category.DEFAULT");
    paramContext.addCategory("android.intent.category.BROWSABLE");
    paramContext.setDataAndNormalize(Uri.parse(paramString));
    paramContext = localPackageManager.queryIntentActivities(paramContext, 64).iterator();
    boolean bool = false;
    while (paramContext.hasNext()) {
      if (nextactivityInfo.name.equals(BrowserTabActivity.class.getName())) {
        bool = true;
      } else {
        return false;
      }
    }
    return bool;
  }
  
  public static boolean isEmpty(String paramString)
  {
    boolean bool;
    if ((paramString != null) && (paramString.trim().length() != 0)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isScopeIntersects(Set<String> paramSet1, Set<String> paramSet2)
  {
    paramSet2 = paramSet2.iterator();
    while (paramSet2.hasNext()) {
      if (paramSet1.contains((String)paramSet2.next())) {
        return true;
      }
    }
    return false;
  }
  
  public static void throwOnMainThread(String paramString)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      return;
    }
    throw new IllegalStateException(a.a("method: ", paramString, " may not be called from main thread."));
  }
  
  public static String urlFormDecode(String paramString)
  {
    if (isEmpty(paramString)) {
      return "";
    }
    return URLDecoder.decode(paramString, "UTF-8");
  }
  
  public static String urlFormEncode(String paramString)
  {
    if (isEmpty(paramString)) {
      return "";
    }
    return URLEncoder.encode(paramString, "UTF-8");
  }
  
  public static void validateNonNullArg(Object paramObject, String paramString)
  {
    if ((paramObject != null) && ((!(paramObject instanceof CharSequence)) || (!TextUtils.isEmpty((CharSequence)paramObject))) && ((!(paramObject instanceof List)) || (!((List)paramObject).isEmpty()))) {
      return;
    }
    throw new MsalArgumentException(paramString, a.b(paramString, " cannot be null or empty"));
  }
  
  public static void validateNonNullArgument(Object paramObject, String paramString)
  {
    if ((paramObject != null) && ((!(paramObject instanceof CharSequence)) || (!TextUtils.isEmpty((CharSequence)paramObject)))) {
      return;
    }
    throw new IllegalArgumentException(a.b(paramString, " cannot be null or empty"));
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.internal.MsalUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */