package com.microsoft.azure.storage.core;

import com.microsoft.azure.storage.ResultContinuation;

public class SegmentedStorageRequest
{
  public ResultContinuation token = null;
  
  public final ResultContinuation getToken()
  {
    return token;
  }
  
  public final void setToken(ResultContinuation paramResultContinuation)
  {
    token = paramResultContinuation;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.core.SegmentedStorageRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */