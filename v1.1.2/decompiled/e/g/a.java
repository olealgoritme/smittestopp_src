package e.g;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Build;
import android.preference.PreferenceManager;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import e.h.a.a.a.c;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a
  implements SharedPreferences
{
  public static final String d = a.class.getName();
  public SharedPreferences a;
  public a.c b;
  public String c;
  
  public a(Context paramContext, String paramString1, String paramString2)
  {
    if (a == null)
    {
      if (TextUtils.isEmpty(paramString2)) {
        paramString2 = PreferenceManager.getDefaultSharedPreferences(paramContext);
      } else {
        paramString2 = paramContext.getSharedPreferences(paramString2, 0);
      }
      a = paramString2;
    }
    c = null;
    if (TextUtils.isEmpty(paramString1)) {
      try
      {
        paramContext = b(e.h.a.a.a.a(paramContext.getPackageName(), a(paramContext).getBytes(), 10000).toString());
        paramString1 = a.getString(paramContext, null);
        if (paramString1 == null)
        {
          b = e.h.a.a.a.b();
          if (!a.edit().putString(paramContext, b.toString()).commit()) {
            Log.w(d, "Key not committed to prefs");
          }
        }
        else
        {
          b = e.h.a.a.a.a(paramString1);
        }
        if (b == null)
        {
          paramContext = new java/security/GeneralSecurityException;
          paramContext.<init>("Problem generating Key");
          throw paramContext;
        }
      }
      catch (GeneralSecurityException paramContext)
      {
        throw new IllegalStateException(paramContext);
      }
    }
    try
    {
      b = e.h.a.a.a.a(paramString1, a(paramContext).getBytes(), 10000);
      return;
    }
    catch (GeneralSecurityException paramContext)
    {
      throw new IllegalStateException(paramContext);
    }
  }
  
  public static String b(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
      paramString = paramString.getBytes("UTF-8");
      localMessageDigest.update(paramString, 0, paramString.length);
      paramString = Base64.encodeToString(localMessageDigest.digest(), 2);
      return paramString;
    }
    catch (NoSuchAlgorithmException|UnsupportedEncodingException paramString) {}
    return null;
  }
  
  public final String a(Context paramContext)
  {
    if (TextUtils.isEmpty(c))
    {
      String str3;
      try
      {
        String str1 = (String)Build.class.getField("SERIAL").get(null);
        String str2 = str1;
        if (TextUtils.isEmpty(str1)) {
          str2 = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
        }
      }
      catch (Exception localException)
      {
        str3 = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      }
      return str3;
    }
    return c;
  }
  
  public final String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    try
    {
      e.h.a.a.a.a locala = new e/h/a/a/a$a;
      locala.<init>(paramString);
      paramString = e.h.a.a.a.a(locala, b);
      return paramString;
    }
    catch (GeneralSecurityException|UnsupportedEncodingException paramString) {}
    return null;
  }
  
  public boolean contains(String paramString)
  {
    return a.contains(b(paramString));
  }
  
  public SharedPreferences.Editor edit()
  {
    return new b(null);
  }
  
  public Map<String, String> getAll()
  {
    Object localObject1 = a.getAll();
    HashMap localHashMap = new HashMap(((Map)localObject1).size());
    localObject1 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
      try
      {
        Object localObject2 = localEntry.getValue();
        if ((localObject2 != null) && (!localObject2.equals(b.toString()))) {
          localHashMap.put(localEntry.getKey(), a(localObject2.toString()));
        }
      }
      catch (Exception localException)
      {
        localHashMap.put(localEntry.getKey(), localEntry.getValue().toString());
      }
    }
    return localHashMap;
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    paramString = a.getString(b(paramString), null);
    if (paramString == null) {
      return paramBoolean;
    }
    try
    {
      paramBoolean = Boolean.parseBoolean(a(paramString));
      return paramBoolean;
    }
    catch (NumberFormatException paramString)
    {
      throw new ClassCastException(paramString.getMessage());
    }
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    paramString = a.getString(b(paramString), null);
    if (paramString == null) {
      return paramFloat;
    }
    try
    {
      paramFloat = Float.parseFloat(a(paramString));
      return paramFloat;
    }
    catch (NumberFormatException paramString)
    {
      throw new ClassCastException(paramString.getMessage());
    }
  }
  
  public int getInt(String paramString, int paramInt)
  {
    paramString = a.getString(b(paramString), null);
    if (paramString == null) {
      return paramInt;
    }
    try
    {
      paramInt = Integer.parseInt(a(paramString));
      return paramInt;
    }
    catch (NumberFormatException paramString)
    {
      throw new ClassCastException(paramString.getMessage());
    }
  }
  
  public long getLong(String paramString, long paramLong)
  {
    paramString = a.getString(b(paramString), null);
    if (paramString == null) {
      return paramLong;
    }
    try
    {
      paramLong = Long.parseLong(a(paramString));
      return paramLong;
    }
    catch (NumberFormatException paramString)
    {
      throw new ClassCastException(paramString.getMessage());
    }
  }
  
  public String getString(String paramString1, String paramString2)
  {
    paramString1 = a.getString(b(paramString1), null);
    String str = a(paramString1);
    if ((paramString1 != null) && (str != null)) {
      return str;
    }
    return paramString2;
  }
  
  @TargetApi(11)
  public Set<String> getStringSet(String paramString, Set<String> paramSet)
  {
    Set localSet = a.getStringSet(b(paramString), null);
    if (localSet == null) {
      return paramSet;
    }
    paramString = new HashSet(localSet.size());
    paramSet = localSet.iterator();
    while (paramSet.hasNext()) {
      paramString.add(a((String)paramSet.next()));
    }
    return paramString;
  }
  
  public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    a.registerOnSharedPreferenceChangeListener(paramOnSharedPreferenceChangeListener);
  }
  
  public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    a.unregisterOnSharedPreferenceChangeListener(paramOnSharedPreferenceChangeListener);
  }
  
  public final class b
    implements SharedPreferences.Editor
  {
    public SharedPreferences.Editor a;
    
    @TargetApi(9)
    public void apply()
    {
      a.apply();
    }
    
    public SharedPreferences.Editor clear()
    {
      a.clear();
      return this;
    }
    
    public boolean commit()
    {
      return a.commit();
    }
    
    public SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
    {
      a.putString(a.b(paramString), a.a(b, Boolean.toString(paramBoolean)));
      return this;
    }
    
    public SharedPreferences.Editor putFloat(String paramString, float paramFloat)
    {
      a.putString(a.b(paramString), a.a(b, Float.toString(paramFloat)));
      return this;
    }
    
    public SharedPreferences.Editor putInt(String paramString, int paramInt)
    {
      a.putString(a.b(paramString), a.a(b, Integer.toString(paramInt)));
      return this;
    }
    
    public SharedPreferences.Editor putLong(String paramString, long paramLong)
    {
      a.putString(a.b(paramString), a.a(b, Long.toString(paramLong)));
      return this;
    }
    
    public SharedPreferences.Editor putString(String paramString1, String paramString2)
    {
      a.putString(a.b(paramString1), a.a(b, paramString2));
      return this;
    }
    
    @TargetApi(11)
    public SharedPreferences.Editor putStringSet(String paramString, Set<String> paramSet)
    {
      HashSet localHashSet = new HashSet(paramSet.size());
      paramSet = paramSet.iterator();
      while (paramSet.hasNext())
      {
        String str = (String)paramSet.next();
        localHashSet.add(a.a(b, str));
      }
      a.putStringSet(a.b(paramString), localHashSet);
      return this;
    }
    
    public SharedPreferences.Editor remove(String paramString)
    {
      a.remove(a.b(paramString));
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     e.g.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */