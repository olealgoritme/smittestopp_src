package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.Request;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RequestFuture<T>
  implements Future<T>, Response.Listener<T>, Response.ErrorListener
{
  public VolleyError mException;
  public Request<?> mRequest;
  public T mResult;
  public boolean mResultReceived = false;
  
  private T doGet(Long paramLong)
  {
    try
    {
      if (mException == null)
      {
        if (mResultReceived)
        {
          paramLong = mResult;
          return paramLong;
        }
        if (paramLong == null) {
          while (!isDone()) {
            wait(0L);
          }
        }
        if (paramLong.longValue() > 0L)
        {
          long l1 = SystemClock.uptimeMillis();
          long l2 = paramLong.longValue() + l1;
          while ((!isDone()) && (l1 < l2))
          {
            wait(l2 - l1);
            l1 = SystemClock.uptimeMillis();
          }
        }
        if (mException == null)
        {
          if (mResultReceived)
          {
            paramLong = mResult;
            return paramLong;
          }
          paramLong = new java/util/concurrent/TimeoutException;
          paramLong.<init>();
          throw paramLong;
        }
        paramLong = new java/util/concurrent/ExecutionException;
        paramLong.<init>(mException);
        throw paramLong;
      }
      paramLong = new java/util/concurrent/ExecutionException;
      paramLong.<init>(mException);
      throw paramLong;
    }
    finally {}
  }
  
  public static <E> RequestFuture<E> newFuture()
  {
    return new RequestFuture();
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    try
    {
      Request localRequest = mRequest;
      if (localRequest == null) {
        return false;
      }
      if (!isDone())
      {
        mRequest.cancel();
        return true;
      }
      return false;
    }
    finally {}
  }
  
  public T get()
  {
    try
    {
      Object localObject = doGet(null);
      return (T)localObject;
    }
    catch (TimeoutException localTimeoutException)
    {
      throw new AssertionError(localTimeoutException);
    }
  }
  
  public T get(long paramLong, TimeUnit paramTimeUnit)
  {
    return (T)doGet(Long.valueOf(TimeUnit.MILLISECONDS.convert(paramLong, paramTimeUnit)));
  }
  
  public boolean isCancelled()
  {
    Request localRequest = mRequest;
    if (localRequest == null) {
      return false;
    }
    return localRequest.isCanceled();
  }
  
  public boolean isDone()
  {
    try
    {
      if ((!mResultReceived) && (mException == null))
      {
        bool = isCancelled();
        if (!bool)
        {
          bool = false;
          break label35;
        }
      }
      boolean bool = true;
      label35:
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void onErrorResponse(VolleyError paramVolleyError)
  {
    try
    {
      mException = paramVolleyError;
      notifyAll();
      return;
    }
    finally
    {
      paramVolleyError = finally;
      throw paramVolleyError;
    }
  }
  
  public void onResponse(T paramT)
  {
    try
    {
      mResultReceived = true;
      mResult = paramT;
      notifyAll();
      return;
    }
    finally
    {
      paramT = finally;
      throw paramT;
    }
  }
  
  public void setRequest(Request<?> paramRequest)
  {
    mRequest = paramRequest;
  }
}

/* Location:
 * Qualified Name:     base.com.android.volley.toolbox.RequestFuture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */