package com.microsoft.identity.client;

public final class Logger
{
  public static final Logger sINSTANCE = new Logger();
  public ILoggerCallback mExternalLogger;
  
  public static Logger getInstance()
  {
    return sINSTANCE;
  }
  
  public void setEnableLogcatLog(boolean paramBoolean)
  {
    com.microsoft.identity.common.internal.logging.Logger.setAllowLogcat(paramBoolean);
  }
  
  public void setEnablePII(boolean paramBoolean)
  {
    com.microsoft.identity.common.internal.logging.Logger.setAllowPii(paramBoolean);
  }
  
  public void setExternalLogger(ILoggerCallback paramILoggerCallback)
  {
    if (paramILoggerCallback == null) {
      return;
    }
    try
    {
      if (mExternalLogger == null)
      {
        com.microsoft.identity.common.internal.logging.Logger localLogger = com.microsoft.identity.common.internal.logging.Logger.getInstance();
        Logger.1 local1 = new com/microsoft/identity/client/Logger$1;
        local1.<init>(this);
        localLogger.setExternalLogger(local1);
        mExternalLogger = paramILoggerCallback;
        return;
      }
      paramILoggerCallback = new java/lang/IllegalStateException;
      paramILoggerCallback.<init>("External logger is already set, cannot be set again.");
      throw paramILoggerCallback;
    }
    finally {}
  }
  
  public void setLogLevel(Logger.LogLevel paramLogLevel)
  {
    com.microsoft.identity.common.internal.logging.Logger localLogger = com.microsoft.identity.common.internal.logging.Logger.getInstance();
    int i = paramLogLevel.ordinal();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            localLogger.setLogLevel(com.microsoft.identity.common.internal.logging.Logger.LogLevel.VERBOSE);
          } else {
            throw new IllegalArgumentException("Unknown logLevel");
          }
        }
        else {
          localLogger.setLogLevel(com.microsoft.identity.common.internal.logging.Logger.LogLevel.INFO);
        }
      }
      else {
        localLogger.setLogLevel(com.microsoft.identity.common.internal.logging.Logger.LogLevel.WARN);
      }
    }
    else {
      localLogger.setLogLevel(com.microsoft.identity.common.internal.logging.Logger.LogLevel.ERROR);
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.Logger
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */