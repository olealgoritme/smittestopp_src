package com.microsoft.identity.common.internal.cache;

import java.util.Map;

public abstract interface ISharedPreferencesFileManager
{
  public abstract void clear();
  
  public abstract boolean contains(String paramString);
  
  public abstract Map<String, String> getAll();
  
  public abstract String getSharedPreferencesFileName();
  
  public abstract String getString(String paramString);
  
  public abstract void putString(String paramString1, String paramString2);
  
  public abstract void remove(String paramString);
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.cache.ISharedPreferencesFileManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */