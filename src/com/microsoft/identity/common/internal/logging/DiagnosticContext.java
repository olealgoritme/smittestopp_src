package com.microsoft.identity.common.internal.logging;

import java.util.Map;

public final class DiagnosticContext
{
  public static final String CORRELATION_ID = "correlation_id";
  public static final ThreadLocal<IRequestContext> REQUEST_CONTEXT_THREAD_LOCAL = new DiagnosticContext.1();
  public static final String THREAD_ID = "thread_id";
  
  public static void clear()
  {
    REQUEST_CONTEXT_THREAD_LOCAL.remove();
  }
  
  public static IRequestContext getRequestContext()
  {
    if (!hasThreadId()) {
      setThreadId();
    }
    return (IRequestContext)REQUEST_CONTEXT_THREAD_LOCAL.get();
  }
  
  public static boolean hasThreadId()
  {
    return ((IRequestContext)REQUEST_CONTEXT_THREAD_LOCAL.get()).containsKey("thread_id");
  }
  
  public static void setRequestContext(IRequestContext paramIRequestContext)
  {
    if (paramIRequestContext == null)
    {
      clear();
      return;
    }
    paramIRequestContext.put("thread_id", String.valueOf(Thread.currentThread().getId()));
    REQUEST_CONTEXT_THREAD_LOCAL.set(paramIRequestContext);
  }
  
  public static void setThreadId()
  {
    ((IRequestContext)REQUEST_CONTEXT_THREAD_LOCAL.get()).put("thread_id", String.valueOf(Thread.currentThread().getId()));
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.logging.DiagnosticContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */