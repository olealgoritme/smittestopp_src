package com.microsoft.identity.client.configuration;

import com.microsoft.identity.client.Logger.LogLevel;
import e.c.c.v.c;

public class LoggerConfiguration
{
  @c("log_level")
  public Logger.LogLevel mLogLevel;
  @c("logcat_enabled")
  public boolean mLogcatEnabled;
  @c("pii_enabled")
  public boolean mPiiEnabled;
  
  public Logger.LogLevel getLogLevel()
  {
    return mLogLevel;
  }
  
  public boolean isLogcatEnabled()
  {
    return mLogcatEnabled;
  }
  
  public boolean isPiiEnabled()
  {
    return mPiiEnabled;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.configuration.LoggerConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */