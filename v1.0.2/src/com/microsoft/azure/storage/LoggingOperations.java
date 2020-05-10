package com.microsoft.azure.storage;

public enum LoggingOperations
{
  static
  {
    LoggingOperations localLoggingOperations = new LoggingOperations("DELETE", 2);
    DELETE = localLoggingOperations;
    $VALUES = new LoggingOperations[] { READ, WRITE, localLoggingOperations };
  }
  
  public LoggingOperations() {}
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.LoggingOperations
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */