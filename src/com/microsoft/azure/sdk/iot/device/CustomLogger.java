package com.microsoft.azure.sdk.iot.device;

import k.f.b;
import k.f.c;

@Deprecated
public class CustomLogger
{
  public static final int CALLING_METHOD_NAME_DEPTH = 2;
  public final b logger;
  
  public CustomLogger(Class<?> paramClass)
  {
    logger = c.a(paramClass);
  }
  
  public void LogDebug(String paramString, Throwable paramThrowable, Object... paramVarArgs)
  {
    if (logger.d()) {
      logger.d(String.format(paramString, paramVarArgs), paramThrowable);
    }
  }
  
  public void LogDebug(String paramString, Object... paramVarArgs)
  {
    if (logger.d()) {
      logger.b(String.format(paramString, paramVarArgs));
    }
  }
  
  public void LogError(String paramString, Object... paramVarArgs)
  {
    if (logger.f()) {
      logger.a(String.format(paramString, paramVarArgs));
    }
  }
  
  public void LogError(Throwable paramThrowable)
  {
    if (logger.f()) {
      logger.a(paramThrowable.toString());
    }
  }
  
  public void LogFatal(String paramString, Object... paramVarArgs)
  {
    if (logger.f()) {
      logger.a(String.format(paramString, paramVarArgs));
    }
  }
  
  public void LogInfo(String paramString, Object... paramVarArgs)
  {
    if (logger.a()) {
      logger.c(String.format(paramString, paramVarArgs));
    }
  }
  
  public void LogTrace(String paramString, Object... paramVarArgs)
  {
    if (logger.e()) {
      logger.e(String.format(paramString, paramVarArgs));
    }
  }
  
  public void LogWarn(String paramString, Object... paramVarArgs)
  {
    if (logger.b()) {
      logger.d(String.format(paramString, paramVarArgs));
    }
  }
  
  public String getMethodName()
  {
    return Thread.currentThread().getStackTrace()[2].getMethodName();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.CustomLogger
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */