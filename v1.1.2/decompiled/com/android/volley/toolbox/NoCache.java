package com.android.volley.toolbox;

import com.android.volley.Cache;
import com.android.volley.Cache.Entry;

public class NoCache
  implements Cache
{
  public void clear() {}
  
  public Cache.Entry get(String paramString)
  {
    return null;
  }
  
  public void initialize() {}
  
  public void invalidate(String paramString, boolean paramBoolean) {}
  
  public void put(String paramString, Cache.Entry paramEntry) {}
  
  public void remove(String paramString) {}
}

/* Location:
 * Qualified Name:     com.android.volley.toolbox.NoCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */