package com.microsoft.azure.sdk.iot.deps.util;

public class CustomLogger
{
  public static final int CALLING_METHOD_NAME_DEPTH = 2;
  
  public void LogDebug(String paramString, Throwable paramThrowable, Object... paramVarArgs) {}
  
  public void LogDebug(String paramString, Object... paramVarArgs) {}
  
  public void LogError(String paramString, Object... paramVarArgs) {}
  
  public void LogError(Throwable paramThrowable) {}
  
  public void LogFatal(String paramString, Object... paramVarArgs) {}
  
  public void LogInfo(String paramString, Object... paramVarArgs) {}
  
  public void LogTrace(String paramString, Object... paramVarArgs) {}
  
  public void LogWarn(String paramString, Object... paramVarArgs) {}
  
  public String getMethodName()
  {
    return Thread.currentThread().getStackTrace()[2].getMethodName();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.util.CustomLogger
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */