package com.microsoft.appcenter.crashes.model;

public class TestCrashException
  extends RuntimeException
{
  public static final String CRASH_MESSAGE = "Test crash exception generated by SDK";
  
  public TestCrashException()
  {
    super("Test crash exception generated by SDK");
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.crashes.model.TestCrashException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */