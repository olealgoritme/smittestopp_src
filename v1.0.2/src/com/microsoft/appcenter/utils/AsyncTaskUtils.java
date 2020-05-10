package com.microsoft.appcenter.utils;

import android.os.AsyncTask;
import java.util.concurrent.RejectedExecutionException;

public class AsyncTaskUtils
{
  @SafeVarargs
  public static <Params, Type extends AsyncTask<Params, ?, ?>> Type execute(String paramString, Type paramType, Params... paramVarArgs)
  {
    try
    {
      AsyncTask localAsyncTask = paramType.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paramVarArgs);
      return localAsyncTask;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      AppCenterLog.warn(paramString, "THREAD_POOL_EXECUTOR saturated, fall back on SERIAL_EXECUTOR which has an unbounded queue", localRejectedExecutionException);
    }
    return paramType.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, paramVarArgs);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.utils.AsyncTaskUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */