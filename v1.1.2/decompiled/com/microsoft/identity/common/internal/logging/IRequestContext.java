package com.microsoft.identity.common.internal.logging;

import java.util.Map;

public abstract interface IRequestContext
  extends Map<String, String>
{
  public abstract String toJsonString();
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.logging.IRequestContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */