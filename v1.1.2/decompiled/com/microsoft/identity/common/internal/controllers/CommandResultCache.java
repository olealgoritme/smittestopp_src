package com.microsoft.identity.common.internal.controllers;

import android.util.LruCache;

public class CommandResultCache
{
  public static final int DEFAULT_ITEM_COUNT = 250;
  public LruCache<BaseCommand, CommandResultCacheItem> mCache;
  
  public CommandResultCache()
  {
    mCache = new LruCache(250);
  }
  
  public CommandResultCache(int paramInt)
  {
    mCache = new LruCache(paramInt);
  }
  
  public void clear()
  {
    synchronized (mCache)
    {
      LruCache localLruCache2 = new android/util/LruCache;
      localLruCache2.<init>(250);
      mCache = localLruCache2;
      return;
    }
  }
  
  public CommandResult get(BaseCommand paramBaseCommand)
  {
    synchronized (mCache)
    {
      CommandResultCacheItem localCommandResultCacheItem = (CommandResultCacheItem)mCache.get(paramBaseCommand);
      if (localCommandResultCacheItem != null)
      {
        if (localCommandResultCacheItem.isExpired())
        {
          mCache.remove(paramBaseCommand);
          return null;
        }
        paramBaseCommand = localCommandResultCacheItem.getValue();
        return paramBaseCommand;
      }
      return null;
    }
  }
  
  public int getSize()
  {
    return mCache.size();
  }
  
  public void put(BaseCommand paramBaseCommand, CommandResult paramCommandResult)
  {
    paramCommandResult = new CommandResultCacheItem(paramCommandResult);
    mCache.put(paramBaseCommand, paramCommandResult);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.controllers.CommandResultCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */