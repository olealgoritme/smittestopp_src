package com.microsoft.identity.common.internal.logging;

public enum Logger$LogLevel
{
  static
  {
    INFO = new LogLevel("INFO", 2);
    LogLevel localLogLevel = new LogLevel("VERBOSE", 3);
    VERBOSE = localLogLevel;
    $VALUES = new LogLevel[] { ERROR, WARN, INFO, localLogLevel };
  }
  
  public Logger$LogLevel() {}
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.logging.Logger.LogLevel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */