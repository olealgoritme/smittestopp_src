package com.microsoft.identity.client.internal;

import com.microsoft.identity.client.exception.MsalException;

public class AsyncResult<T>
{
  public MsalException mMsalException;
  public T mResult;
  public boolean mSuccess = false;
  
  public AsyncResult(T paramT, MsalException paramMsalException)
  {
    mResult = paramT;
    mMsalException = paramMsalException;
    if (paramT != null) {
      mSuccess = true;
    }
  }
  
  public MsalException getException()
  {
    return mMsalException;
  }
  
  public T getResult()
  {
    return (T)mResult;
  }
  
  public boolean getSuccess()
  {
    return mSuccess;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.internal.AsyncResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */