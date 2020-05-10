package com.microsoft.identity.common.internal.dto;

import e.a.a.a.a;
import e.c.c.j;
import java.util.HashMap;
import java.util.Map;

public abstract class AccountCredentialBase
{
  public transient Map<String, j> mAdditionalFields = new HashMap();
  
  public Map<String, j> getAdditionalFields()
  {
    return mAdditionalFields;
  }
  
  public void setAdditionalFields(Map<String, j> paramMap)
  {
    mAdditionalFields = paramMap;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = a.a("AccountCredentialBase{mAdditionalFields=");
    localStringBuilder.append(mAdditionalFields);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.dto.AccountCredentialBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */