package com.microsoft.identity.common.internal.providers.oauth2;

import android.content.Context;

public class OAuth2StrategyParameters
{
  public transient Context mContext;
  
  public Context getContext()
  {
    return mContext;
  }
  
  public void setContext(Context paramContext)
  {
    mContext = paramContext;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.oauth2.OAuth2StrategyParameters
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */