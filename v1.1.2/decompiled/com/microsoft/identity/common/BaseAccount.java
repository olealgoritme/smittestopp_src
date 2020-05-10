package com.microsoft.identity.common;

import com.microsoft.identity.common.internal.dto.IAccountRecord;
import java.util.List;

public abstract class BaseAccount
  implements IAccountRecord
{
  public abstract List<String> getCacheIdentifiers();
  
  public abstract String getUniqueIdentifier();
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.BaseAccount
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */