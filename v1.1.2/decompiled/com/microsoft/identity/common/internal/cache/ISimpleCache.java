package com.microsoft.identity.common.internal.cache;

import java.util.List;

public abstract interface ISimpleCache<T>
{
  public abstract boolean clear();
  
  public abstract List<T> getAll();
  
  public abstract boolean insert(T paramT);
  
  public abstract boolean remove(T paramT);
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.cache.ISimpleCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */