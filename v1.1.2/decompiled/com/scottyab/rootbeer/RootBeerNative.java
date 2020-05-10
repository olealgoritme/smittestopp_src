package com.scottyab.rootbeer;

import e.f.a.c.a;

public class RootBeerNative
{
  public static boolean a = false;
  
  static
  {
    try
    {
      System.loadLibrary("tool-checker");
      a = true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      a.a(localUnsatisfiedLinkError);
    }
  }
  
  public native int checkForRoot(Object[] paramArrayOfObject);
  
  public native int setLogDebugMessages(boolean paramBoolean);
}

/* Location:
 * Qualified Name:     com.scottyab.rootbeer.RootBeerNative
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */