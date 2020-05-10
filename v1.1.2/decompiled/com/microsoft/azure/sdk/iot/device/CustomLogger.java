package com.microsoft.azure.sdk.iot.device;

import l.f.b;
import l.f.c;

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
    if (logger.c()) {
      logger.d(String.format(paramString, paramVarArgs), paramThrowable);
    }
  }
  
  public void LogDebug(String paramString, Object... paramVarArgs)
  {
    if (logger.c()) {
      logger.e(String.format(paramString, paramVarArgs));
    }
  }
  
  public void LogError(String paramString, Object... paramVarArgs)
  {
    if (logger.d()) {
      logger.a(String.format(paramString, paramVarArgs));
    }
  }
  
  public void LogError(Throwable paramThrowable)
  {
    if (logger.d()) {
      logger.a(paramThrowable.toString());
    }
  }
  
  public void LogFatal(String paramString, Object... paramVarArgs)
  {
    if (logger.d()) {
      logger.a(String.format(paramString, paramVarArgs));
    }
  }
  
  public void LogInfo(String paramString, Object... paramVarArgs)
  {
    if (logger.e()) {
      logger.b(String.format(paramString, paramVarArgs));
    }
  }
  
  public void LogTrace(String paramString, Object... paramVarArgs)
  {
    if (logger.f()) {
      logger.d(String.format(paramString, paramVarArgs));
    }
  }
  
  public void LogWarn(String paramString, Object... paramVarArgs)
  {
    if (logger.a()) {
      logger.c(String.format(paramString, paramVarArgs));
    }
  }
  
  public String getMethodName()
  {
    return Thread.currentThread().getStackTrace()[2].getMethodName();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.CustomLogger
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */