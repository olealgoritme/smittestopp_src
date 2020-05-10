package com.android.volley;

public abstract interface Cache
{
  public abstract void clear();
  
  public abstract Cache.Entry get(String paramString);
  
  public abstract void initialize();
  
  public abstract void invalidate(String paramString, boolean paramBoolean);
  
  public abstract void put(String paramString, Cache.Entry paramEntry);
  
  public abstract void remove(String paramString);
}

/* Location:
 * Qualified Name:     base.com.android.volley.Cache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */