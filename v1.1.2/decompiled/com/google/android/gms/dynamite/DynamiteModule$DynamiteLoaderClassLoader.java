package com.google.android.gms.dynamite;

import com.google.android.gms.common.util.DynamiteApi;
import javax.annotation.concurrent.GuardedBy;

@DynamiteApi
public class DynamiteModule$DynamiteLoaderClassLoader
{
  @GuardedBy("DynamiteLoaderClassLoader.class")
  public static ClassLoader sClassLoader;
}

/* Location:
 * Qualified Name:     com.google.android.gms.dynamite.DynamiteModule.DynamiteLoaderClassLoader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */