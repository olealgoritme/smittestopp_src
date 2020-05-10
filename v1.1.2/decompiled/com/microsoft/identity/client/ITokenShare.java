package com.microsoft.identity.client;

import com.microsoft.identity.common.adal.internal.tokensharing.ITokenShareInternal;

public abstract interface ITokenShare
  extends ITokenShareInternal
{
  public abstract String getMsaFamilyRefreshToken(String paramString);
  
  public abstract String getOrgIdFamilyRefreshToken(String paramString);
  
  public abstract void saveMsaFamilyRefreshToken(String paramString);
  
  public abstract void saveOrgIdFamilyRefreshToken(String paramString);
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.ITokenShare
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */