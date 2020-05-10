package com.microsoft.appcenter.utils.storage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.Set;

public class SharedPreferencesManager
{
  public static final String PREFERENCES_NAME = "AppCenter";
  @SuppressLint({"StaticFieldLeak"})
  public static Context sContext;
  public static SharedPreferences sSharedPreferences;
  
  public static void clear()
  {
    SharedPreferences.Editor localEditor = sSharedPreferences.edit();
    localEditor.clear();
    localEditor.apply();
  }
  
  public static boolean getBoolean(String paramString)
  {
    return getBoolean(paramString, false);
  }
  
  public static boolean getBoolean(String paramString, boolean paramBoolean)
  {
    return sSharedPreferences.getBoolean(paramString, paramBoolean);
  }
  
  public static float getFloat(String paramString)
  {
    return getFloat(paramString, 0.0F);
  }
  
  public static float getFloat(String paramString, float paramFloat)
  {
    return sSharedPreferences.getFloat(paramString, paramFloat);
  }
  
  public static int getInt(String paramString)
  {
    return getInt(paramString, 0);
  }
  
  public static int getInt(String paramString, int paramInt)
  {
    return sSharedPreferences.getInt(paramString, paramInt);
  }
  
  public static long getLong(String paramString)
  {
    return getLong(paramString, 0L);
  }
  
  public static long getLong(String paramString, long paramLong)
  {
    return sSharedPreferences.getLong(paramString, paramLong);
  }
  
  public static String getString(String paramString)
  {
    return getString(paramString, null);
  }
  
  public static String getString(String paramString1, String paramString2)
  {
    return sSharedPreferences.getString(paramString1, paramString2);
  }
  
  public static Set<String> getStringSet(String paramString)
  {
    return getStringSet(paramString, null);
  }
  
  public static Set<String> getStringSet(String paramString, Set<String> paramSet)
  {
    return sSharedPreferences.getStringSet(paramString, paramSet);
  }
  
  public static void initialize(Context paramContext)
  {
    try
    {
      if (sContext == null)
      {
        sContext = paramContext;
        sSharedPreferences = paramContext.getSharedPreferences("AppCenter", 0);
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void putBoolean(String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = sSharedPreferences.edit();
    localEditor.putBoolean(paramString, paramBoolean);
    localEditor.apply();
  }
  
  public static void putFloat(String paramString, float paramFloat)
  {
    SharedPreferences.Editor localEditor = sSharedPreferences.edit();
    localEditor.putFloat(paramString, paramFloat);
    localEditor.apply();
  }
  
  public static void putInt(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = sSharedPreferences.edit();
    localEditor.putInt(paramString, paramInt);
    localEditor.apply();
  }
  
  public static void putLong(String paramString, long paramLong)
  {
    SharedPreferences.Editor localEditor = sSharedPreferences.edit();
    localEditor.putLong(paramString, paramLong);
    localEditor.apply();
  }
  
  public static void putString(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = sSharedPreferences.edit();
    localEditor.putString(paramString1, paramString2);
    localEditor.apply();
  }
  
  public static void putStringSet(String paramString, Set<String> paramSet)
  {
    SharedPreferences.Editor localEditor = sSharedPreferences.edit();
    localEditor.putStringSet(paramString, paramSet);
    localEditor.apply();
  }
  
  public static void remove(String paramString)
  {
    SharedPreferences.Editor localEditor = sSharedPreferences.edit();
    localEditor.remove(paramString);
    localEditor.apply();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.utils.storage.SharedPreferencesManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */