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
  
  public static final class SerializedNames
  {
    public static final String LOGCAT_ENABLED = "logcat_enabled";
    public static final String LOG_LEVEL = "log_level";
    public static final String PII_ENABLED = "pii_enabled";
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.configuration.LoggerConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */