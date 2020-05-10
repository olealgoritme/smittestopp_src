package com.microsoft.identity.common.internal.cache;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.microsoft.identity.common.adal.internal.cache.IStorageHelper;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.internal.logging.Logger;
import e.a.a.a.a;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SharedPreferencesFileManager
  implements ISharedPreferencesFileManager
{
  public static final String TAG = "SharedPreferencesFileManager";
  public final SharedPreferences mSharedPreferences;
  public final String mSharedPreferencesFileName;
  public final IStorageHelper mStorageHelper;
  
  public SharedPreferencesFileManager(Context paramContext, String paramString)
  {
    String str = TAG;
    StringBuilder localStringBuilder = a.a("Init: ");
    localStringBuilder.append(TAG);
    Logger.verbose(str, localStringBuilder.toString());
    mSharedPreferencesFileName = paramString;
    mSharedPreferences = paramContext.getSharedPreferences(paramString, 0);
    mStorageHelper = null;
  }
  
  public SharedPreferencesFileManager(Context paramContext, String paramString, int paramInt)
  {
    String str = TAG;
    StringBuilder localStringBuilder = a.a("Init with operating mode: ");
    localStringBuilder.append(TAG);
    Logger.verbose(str, localStringBuilder.toString());
    mSharedPreferencesFileName = paramString;
    mSharedPreferences = paramContext.getSharedPreferences(paramString, paramInt);
    mStorageHelper = null;
  }
  
  public SharedPreferencesFileManager(Context paramContext, String paramString, int paramInt, IStorageHelper paramIStorageHelper)
  {
    String str = TAG;
    StringBuilder localStringBuilder = a.a("Init with operating mode and storage helper ");
    localStringBuilder.append(TAG);
    Logger.verbose(str, localStringBuilder.toString());
    mSharedPreferencesFileName = paramString;
    mSharedPreferences = paramContext.getSharedPreferences(paramString, paramInt);
    mStorageHelper = paramIStorageHelper;
  }
  
  public SharedPreferencesFileManager(Context paramContext, String paramString, IStorageHelper paramIStorageHelper)
  {
    String str = TAG;
    StringBuilder localStringBuilder = a.a("Init with storage helper:  ");
    localStringBuilder.append(TAG);
    Logger.verbose(str, localStringBuilder.toString());
    mSharedPreferencesFileName = paramString;
    mSharedPreferences = paramContext.getSharedPreferences(paramString, 0);
    mStorageHelper = paramIStorageHelper;
  }
  
  private String decrypt(String paramString)
  {
    return encryptDecryptInternal(paramString, false);
  }
  
  private String encrypt(String paramString)
  {
    return encryptDecryptInternal(paramString, true);
  }
  
  private String encryptDecryptInternal(String paramString, boolean paramBoolean)
  {
    Object localObject = null;
    if (paramBoolean) {}
    label31:
    try
    {
      paramString = mStorageHelper.encrypt(paramString);
      break label31;
      paramString = mStorageHelper.decrypt(paramString);
    }
    catch (IOException paramString) {}catch (GeneralSecurityException paramString) {}
    String str1 = a.a(new StringBuilder(), TAG, ":", "encryptDecryptInternal");
    StringBuilder localStringBuilder = a.a("Failed to ");
    if (paramBoolean) {
      str2 = "encrypt";
    } else {
      str2 = "decrypt";
    }
    String str2 = a.a(localStringBuilder, str2, " value");
    if (paramBoolean) {
      paramString = null;
    }
    Logger.error(str1, str2, paramString);
    paramString = (String)localObject;
    return paramString;
  }
  
  private void logWarningAndRemoveKey(String paramString)
  {
    Logger.warn(TAG, "Failed to decrypt value! This usually signals an issue with KeyStore or the provided SecretKeys.");
    remove(paramString);
  }
  
  @SuppressLint({"ApplySharedPref"})
  public final void clear()
  {
    SharedPreferences.Editor localEditor = mSharedPreferences.edit();
    localEditor.clear();
    localEditor.commit();
  }
  
  public final boolean contains(String paramString)
  {
    return TextUtils.isEmpty(getString(paramString)) ^ true;
  }
  
  public final Map<String, String> getAll()
  {
    Map localMap = mSharedPreferences.getAll();
    if (mStorageHelper != null)
    {
      Iterator localIterator = localMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str = decrypt((String)localEntry.getValue());
        if (TextUtils.isEmpty(str))
        {
          logWarningAndRemoveKey((String)localEntry.getKey());
          localIterator.remove();
        }
        else
        {
          localEntry.setValue(str);
        }
      }
    }
    return localMap;
  }
  
  public final String getSharedPreferencesFileName()
  {
    return mSharedPreferencesFileName;
  }
  
  public final String getString(String paramString)
  {
    String str1 = mSharedPreferences.getString(paramString, null);
    String str2 = str1;
    if (mStorageHelper != null)
    {
      str2 = str1;
      if (!StringExtensions.isNullOrBlank(str1))
      {
        str1 = decrypt(str1);
        str2 = str1;
        if (StringExtensions.isNullOrBlank(str1))
        {
          logWarningAndRemoveKey(paramString);
          str2 = str1;
        }
      }
    }
    return str2;
  }
  
  @SuppressLint({"ApplySharedPref"})
  public final void putString(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = mSharedPreferences.edit();
    if (mStorageHelper == null) {
      localEditor.putString(paramString1, paramString2);
    } else {
      localEditor.putString(paramString1, encrypt(paramString2));
    }
    localEditor.commit();
  }
  
  @SuppressLint({"ApplySharedPref"})
  public void remove(String paramString)
  {
    Logger.info(TAG, "Removing cache key");
    Object localObject = mSharedPreferences.edit();
    ((SharedPreferences.Editor)localObject).remove(paramString);
    ((SharedPreferences.Editor)localObject).commit();
    localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Removed cache key [");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    Logger.infoPII((String)localObject, localStringBuilder.toString());
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.cache.SharedPreferencesFileManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */