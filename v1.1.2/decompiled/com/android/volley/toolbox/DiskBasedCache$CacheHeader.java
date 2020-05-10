package com.android.volley.toolbox;

import com.android.volley.Cache.Entry;
import com.android.volley.Header;
import com.android.volley.VolleyLog;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;

public class DiskBasedCache$CacheHeader
{
  public final List<Header> allResponseHeaders;
  public final String etag;
  public final String key;
  public final long lastModified;
  public final long serverDate;
  public long size;
  public final long softTtl;
  public final long ttl;
  
  public DiskBasedCache$CacheHeader(String paramString, Cache.Entry paramEntry)
  {
    this(paramString, etag, serverDate, lastModified, ttl, softTtl, getAllResponseHeaders(paramEntry));
    size = data.length;
  }
  
  public DiskBasedCache$CacheHeader(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, List<Header> paramList)
  {
    key = paramString1;
    paramString1 = paramString2;
    if ("".equals(paramString2)) {
      paramString1 = null;
    }
    etag = paramString1;
    serverDate = paramLong1;
    lastModified = paramLong2;
    ttl = paramLong3;
    softTtl = paramLong4;
    allResponseHeaders = paramList;
  }
  
  public static List<Header> getAllResponseHeaders(Cache.Entry paramEntry)
  {
    List localList = allResponseHeaders;
    if (localList != null) {
      return localList;
    }
    return HttpHeaderParser.toAllHeaderList(responseHeaders);
  }
  
  public static CacheHeader readHeader(DiskBasedCache.CountingInputStream paramCountingInputStream)
  {
    if (DiskBasedCache.readInt(paramCountingInputStream) == 538247942) {
      return new CacheHeader(DiskBasedCache.readString(paramCountingInputStream), DiskBasedCache.readString(paramCountingInputStream), DiskBasedCache.readLong(paramCountingInputStream), DiskBasedCache.readLong(paramCountingInputStream), DiskBasedCache.readLong(paramCountingInputStream), DiskBasedCache.readLong(paramCountingInputStream), DiskBasedCache.readHeaderList(paramCountingInputStream));
    }
    throw new IOException();
  }
  
  public Cache.Entry toCacheEntry(byte[] paramArrayOfByte)
  {
    Cache.Entry localEntry = new Cache.Entry();
    data = paramArrayOfByte;
    etag = etag;
    serverDate = serverDate;
    lastModified = lastModified;
    ttl = ttl;
    softTtl = softTtl;
    responseHeaders = HttpHeaderParser.toHeaderMap(allResponseHeaders);
    allResponseHeaders = Collections.unmodifiableList(allResponseHeaders);
    return localEntry;
  }
  
  public boolean writeHeader(OutputStream paramOutputStream)
  {
    try
    {
      DiskBasedCache.writeInt(paramOutputStream, 538247942);
      DiskBasedCache.writeString(paramOutputStream, key);
      String str;
      if (etag == null) {
        str = "";
      } else {
        str = etag;
      }
      DiskBasedCache.writeString(paramOutputStream, str);
      DiskBasedCache.writeLong(paramOutputStream, serverDate);
      DiskBasedCache.writeLong(paramOutputStream, lastModified);
      DiskBasedCache.writeLong(paramOutputStream, ttl);
      DiskBasedCache.writeLong(paramOutputStream, softTtl);
      DiskBasedCache.writeHeaderList(allResponseHeaders, paramOutputStream);
      paramOutputStream.flush();
      return true;
    }
    catch (IOException paramOutputStream)
    {
      VolleyLog.d("%s", new Object[] { paramOutputStream.toString() });
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.android.volley.toolbox.DiskBasedCache.CacheHeader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */