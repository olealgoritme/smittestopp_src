package com.microsoft.identity.common.internal.cache;

import android.content.Context;

public abstract interface BrokerOAuth2TokenCache$ProcessUidCacheFactory
{
  public abstract MsalOAuth2TokenCache getTokenCache(Context paramContext, int paramInt);
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.cache.BrokerOAuth2TokenCache.ProcessUidCacheFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */