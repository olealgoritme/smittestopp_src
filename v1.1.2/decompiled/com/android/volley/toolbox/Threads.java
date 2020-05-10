package com.android.volley.toolbox;

import android.os.Looper;

public final class Threads
{
  public static void throwIfNotOnMainThread()
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      return;
    }
    throw new IllegalStateException("Must be invoked from the main thread.");
  }
}

/* Location:
 * Qualified Name:     com.android.volley.toolbox.Threads
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */