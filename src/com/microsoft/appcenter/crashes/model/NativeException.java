package com.microsoft.appcenter.crashes.model;

public class NativeException
  extends RuntimeException
{
  public static final String CRASH_MESSAGE = "Native exception read from a minidump file";
  
  public NativeException()
  {
    super("Native exception read from a minidump file");
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.crashes.model.NativeException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */