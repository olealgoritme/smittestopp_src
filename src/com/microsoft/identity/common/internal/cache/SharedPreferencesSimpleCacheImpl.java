package com.microsoft.identity.common.internal.cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.gson.Gson;
import com.microsoft.identity.common.internal.logging.Logger;
import e.a.a.a.a;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;

public abstract class SharedPreferencesSimpleCacheImpl<T>
  implements ISimpleCache<T>
{
  public static final String EMPTY_ARRAY = "[]";
  public static final String TAG = "SharedPreferencesSimpleCacheImpl";
  public final Gson mGson = new Gson();
  public final String mKeySingleEntry;
  public final SharedPreferences mSharedPrefs;
  
  public SharedPreferencesSimpleCacheImpl(Context paramContext, String paramString1, String paramString2)
  {
    a.b(new StringBuilder(), TAG, "::ctor", "Init");
    mSharedPrefs = paramContext.getSharedPreferences(paramString1, 0);
    mKeySingleEntry = paramString2;
  }
  
  public boolean clear()
  {
    boolean bool = mSharedPrefs.edit().clear().commit();
    if (!bool) {
      a.c(new StringBuilder(), TAG, ":clear", "Failed to clear cache.");
    } else {
      a.b(new StringBuilder(), TAG, ":clear", "Cache successfully cleared.");
    }
    return bool;
  }
  
  public List<T> getAll()
  {
    Object localObject1 = mSharedPrefs.getString(mKeySingleEntry, "[]");
    Object localObject2 = getListTypeToken();
    localObject1 = (List)mGson.a((String)localObject1, (Type)localObject2);
    localObject2 = a.a(new StringBuilder(), TAG, ":getAll");
    StringBuilder localStringBuilder = a.a("Found [");
    localStringBuilder.append(((List)localObject1).size());
    localStringBuilder.append("] cache entries.");
    Logger.verbose((String)localObject2, localStringBuilder.toString());
    return (List<T>)localObject1;
  }
  
  public abstract Type getListTypeToken();
  
  public boolean insert(T paramT)
  {
    HashSet localHashSet = new HashSet(getAll());
    String str = a.a(new StringBuilder(), TAG, ":insert");
    StringBuilder localStringBuilder = a.a("Existing metadata contained [");
    localStringBuilder.append(localHashSet.size());
    localStringBuilder.append("] elements.");
    Logger.verbose(str, localStringBuilder.toString());
    localHashSet.add(paramT);
    paramT = a.a(new StringBuilder(), TAG, ":insert");
    localStringBuilder = a.a("New metadata set size: [");
    localStringBuilder.append(localHashSet.size());
    localStringBuilder.append("]");
    Logger.verbose(paramT, localStringBuilder.toString());
    paramT = mGson.a(localHashSet);
    a.b(new StringBuilder(), TAG, ":insert", "Writing cache entry.");
    boolean bool = mSharedPrefs.edit().putString(mKeySingleEntry, paramT).commit();
    if (bool) {
      a.b(new StringBuilder(), TAG, ":insert", "Cache successfully updated.");
    } else {
      a.c(new StringBuilder(), TAG, ":insert", "Error writing to cache.");
    }
    return bool;
  }
  
  public boolean remove(T paramT)
  {
    Object localObject = new HashSet(getAll());
    String str = a.a(new StringBuilder(), TAG, ":remove");
    StringBuilder localStringBuilder = a.a("Existing metadata contained [");
    localStringBuilder.append(((HashSet)localObject).size());
    localStringBuilder.append("] elements.");
    Logger.verbose(str, localStringBuilder.toString());
    boolean bool = ((HashSet)localObject).remove(paramT);
    paramT = a.a(new StringBuilder(), TAG, ":remove");
    localStringBuilder = a.a("New metadata set size: [");
    localStringBuilder.append(((HashSet)localObject).size());
    localStringBuilder.append("]");
    Logger.verbose(paramT, localStringBuilder.toString());
    if (!bool)
    {
      a.c(new StringBuilder(), TAG, ":remove", "Nothing to delete -- cache entry is missing!");
      return true;
    }
    paramT = mGson.a(localObject);
    a.b(new StringBuilder(), TAG, ":remove", "Writing new cache values...");
    bool = mSharedPrefs.edit().putString(mKeySingleEntry, paramT).commit();
    localObject = a.a(new StringBuilder(), TAG, ":remove");
    paramT = new StringBuilder();
    paramT.append("Updated cache contents written? [");
    paramT.append(bool);
    paramT.append("]");
    Logger.verbose((String)localObject, paramT.toString());
    return bool;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.cache.SharedPreferencesSimpleCacheImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */