package com.microsoft.identity.client;

public class Logger$1
  implements com.microsoft.identity.common.internal.logging.ILoggerCallback
{
  public Logger$1(Logger paramLogger) {}
  
  public void log(String paramString1, com.microsoft.identity.common.internal.logging.Logger.LogLevel paramLogLevel, String paramString2, boolean paramBoolean)
  {
    int i = paramLogLevel.ordinal();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            Logger.access$000(this$0).log(paramString1, Logger.LogLevel.VERBOSE, paramString2, paramBoolean);
          } else {
            throw new IllegalArgumentException("Unknown logLevel");
          }
        }
        else {
          Logger.access$000(this$0).log(paramString1, Logger.LogLevel.INFO, paramString2, paramBoolean);
        }
      }
      else {
        Logger.access$000(this$0).log(paramString1, Logger.LogLevel.WARNING, paramString2, paramBoolean);
      }
    }
    else {
      Logger.access$000(this$0).log(paramString1, Logger.LogLevel.ERROR, paramString2, paramBoolean);
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.Logger.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */