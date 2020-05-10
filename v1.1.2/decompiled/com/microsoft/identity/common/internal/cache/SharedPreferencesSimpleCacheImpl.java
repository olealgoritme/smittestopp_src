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
    String str = mSharedPrefs.getString(mKeySingleEntry, "[]");
    Object localObject = getListTypeToken();
    List localList = (List)mGson.a(str, (Type)localObject);
    str = a.a(new StringBuilder(), TAG, ":getAll");
    localObject = a.a("Found [");
    ((StringBuilder)localObject).append(localList.size());
    ((StringBuilder)localObject).append("] cache entries.");
    Logger.verbose(str, ((StringBuilder)localObject).toString());
    return localList;
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
    str = a.a(new StringBuilder(), TAG, ":insert");
    paramT = a.a("New metadata set size: [");
    paramT.append(localHashSet.size());
    paramT.append("]");
    Logger.verbose(str, paramT.toString());
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
    Object localObject1 = new HashSet(getAll());
    String str = a.a(new StringBuilder(), TAG, ":remove");
    Object localObject2 = a.a("Existing metadata contained [");
    ((StringBuilder)localObject2).append(((HashSet)localObject1).size());
    ((StringBuilder)localObject2).append("] elements.");
    Logger.verbose(str, ((StringBuilder)localObject2).toString());
    boolean bool = ((HashSet)localObject1).remove(paramT);
    localObject2 = a.a(new StringBuilder(), TAG, ":remove");
    paramT = a.a("New metadata set size: [");
    paramT.append(((HashSet)localObject1).size());
    paramT.append("]");
    Logger.verbose((String)localObject2, paramT.toString());
    if (!bool)
    {
      a.c(new StringBuilder(), TAG, ":remove", "Nothing to delete -- cache entry is missing!");
      return true;
    }
    paramT = mGson.a(localObject1);
    a.b(new StringBuilder(), TAG, ":remove", "Writing new cache values...");
    bool = mSharedPrefs.edit().putString(mKeySingleEntry, paramT).commit();
    paramT = a.a(new StringBuilder(), TAG, ":remove");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Updated cache contents written? [");
    ((StringBuilder)localObject1).append(bool);
    ((StringBuilder)localObject1).append("]");
    Logger.verbose(paramT, ((StringBuilder)localObject1).toString());
    return bool;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.cache.SharedPreferencesSimpleCacheImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */