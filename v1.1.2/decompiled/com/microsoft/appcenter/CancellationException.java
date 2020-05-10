package com.microsoft.appcenter;

public class CancellationException
  extends Exception
{
  public CancellationException()
  {
    super("Request cancelled because Channel is disabled.");
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.CancellationException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */