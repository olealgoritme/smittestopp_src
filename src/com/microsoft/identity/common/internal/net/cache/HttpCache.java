package com.microsoft.identity.common.internal.net.cache;

import android.net.http.HttpResponseCache;
import com.microsoft.identity.common.internal.logging.Logger;
import e.a.a.a.a;
import java.io.File;
import java.io.IOException;

public class HttpCache
{
  public static final long DEFAULT_HTTP_CACHE_CAPACITY_BYTES = 10485760L;
  public static final String DEFAULT_HTTP_CACHE_NAME = "com.microsoft.identity.http-cache";
  public static final String TAG = "HttpCache";
  
  public static void flush()
  {
    HttpResponseCache localHttpResponseCache = getInstalled();
    if (localHttpResponseCache != null) {
      localHttpResponseCache.flush();
    } else {
      a.c(new StringBuilder(), TAG, ":flush", "Unable to flush cache because none is installed.");
    }
  }
  
  public static HttpResponseCache getInstalled()
  {
    return HttpResponseCache.getInstalled();
  }
  
  public static boolean initialize(File paramFile)
  {
    return initialize(paramFile, "com.microsoft.identity.http-cache", 10485760L);
  }
  
  public static boolean initialize(File paramFile, String paramString, long paramLong)
  {
    boolean bool;
    try
    {
      File localFile = new java/io/File;
      localFile.<init>(paramFile, paramString);
      HttpResponseCache.install(localFile, paramLong);
      bool = true;
    }
    catch (IOException paramFile)
    {
      paramString = new StringBuilder();
      paramString.append(TAG);
      paramString.append(":initialize (File, Filename, Capacity)");
      Logger.error(paramString.toString(), "HTTP Response cache installation failed.", paramFile);
      bool = false;
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.net.cache.HttpCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */