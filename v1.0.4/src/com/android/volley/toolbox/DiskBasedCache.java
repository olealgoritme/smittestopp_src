package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.Cache;
import com.android.volley.Cache.Entry;
import com.android.volley.Header;
import com.android.volley.VolleyLog;
import e.a.a.a.a;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DiskBasedCache
  implements Cache
{
  public static final int CACHE_MAGIC = 538247942;
  public static final int DEFAULT_DISK_USAGE_BYTES = 5242880;
  public static final float HYSTERESIS_FACTOR = 0.9F;
  public final Map<String, DiskBasedCache.CacheHeader> mEntries = new LinkedHashMap(16, 0.75F, true);
  public final int mMaxCacheSizeInBytes;
  public final File mRootDirectory;
  public long mTotalSize = 0L;
  
  public DiskBasedCache(File paramFile)
  {
    this(paramFile, 5242880);
  }
  
  public DiskBasedCache(File paramFile, int paramInt)
  {
    mRootDirectory = paramFile;
    mMaxCacheSizeInBytes = paramInt;
  }
  
  private String getFilenameForKey(String paramString)
  {
    int i = paramString.length() / 2;
    StringBuilder localStringBuilder = a.a(String.valueOf(paramString.substring(0, i).hashCode()));
    localStringBuilder.append(String.valueOf(paramString.substring(i).hashCode()));
    return localStringBuilder.toString();
  }
  
  private void pruneIfNeeded(int paramInt)
  {
    long l1 = mTotalSize;
    long l2 = paramInt;
    if (l1 + l2 < mMaxCacheSizeInBytes) {
      return;
    }
    if (VolleyLog.DEBUG) {
      VolleyLog.v("Pruning old cache entries.", new Object[0]);
    }
    l1 = mTotalSize;
    long l3 = SystemClock.elapsedRealtime();
    Iterator localIterator = mEntries.entrySet().iterator();
    paramInt = 0;
    int i;
    for (;;)
    {
      i = paramInt;
      if (!localIterator.hasNext()) {
        break;
      }
      Object localObject = (DiskBasedCache.CacheHeader)((Map.Entry)localIterator.next()).getValue();
      if (getFileForKey(key).delete())
      {
        mTotalSize -= size;
      }
      else
      {
        localObject = key;
        VolleyLog.d("Could not delete cache entry for key=%s, filename=%s", new Object[] { localObject, getFilenameForKey((String)localObject) });
      }
      localIterator.remove();
      paramInt++;
      if ((float)(mTotalSize + l2) < mMaxCacheSizeInBytes * 0.9F)
      {
        i = paramInt;
        break;
      }
    }
    if (VolleyLog.DEBUG) {
      VolleyLog.v("pruned %d files, %d bytes, %d ms", new Object[] { Integer.valueOf(i), Long.valueOf(mTotalSize - l1), Long.valueOf(SystemClock.elapsedRealtime() - l3) });
    }
  }
  
  private void putEntry(String paramString, DiskBasedCache.CacheHeader paramCacheHeader)
  {
    if (!mEntries.containsKey(paramString))
    {
      mTotalSize += size;
    }
    else
    {
      DiskBasedCache.CacheHeader localCacheHeader = (DiskBasedCache.CacheHeader)mEntries.get(paramString);
      long l = mTotalSize;
      mTotalSize = (size - size + l);
    }
    mEntries.put(paramString, paramCacheHeader);
  }
  
  public static int read(InputStream paramInputStream)
  {
    int i = paramInputStream.read();
    if (i != -1) {
      return i;
    }
    throw new EOFException();
  }
  
  public static List<Header> readHeaderList(DiskBasedCache.CountingInputStream paramCountingInputStream)
  {
    int i = readInt(paramCountingInputStream);
    if (i >= 0)
    {
      Object localObject;
      if (i == 0) {
        localObject = Collections.emptyList();
      } else {
        localObject = new ArrayList();
      }
      for (int j = 0; j < i; j++) {
        ((List)localObject).add(new Header(readString(paramCountingInputStream).intern(), readString(paramCountingInputStream).intern()));
      }
      return (List<Header>)localObject;
    }
    throw new IOException(a.a("readHeaderList size=", i));
  }
  
  public static int readInt(InputStream paramInputStream)
  {
    int i = read(paramInputStream);
    int j = read(paramInputStream);
    int k = read(paramInputStream);
    return read(paramInputStream) << 24 | i << 0 | 0x0 | j << 8 | k << 16;
  }
  
  public static long readLong(InputStream paramInputStream)
  {
    return (read(paramInputStream) & 0xFF) << 0 | 0L | (read(paramInputStream) & 0xFF) << 8 | (read(paramInputStream) & 0xFF) << 16 | (read(paramInputStream) & 0xFF) << 24 | (read(paramInputStream) & 0xFF) << 32 | (read(paramInputStream) & 0xFF) << 40 | (read(paramInputStream) & 0xFF) << 48 | (0xFF & read(paramInputStream)) << 56;
  }
  
  public static String readString(DiskBasedCache.CountingInputStream paramCountingInputStream)
  {
    return new String(streamToBytes(paramCountingInputStream, readLong(paramCountingInputStream)), "UTF-8");
  }
  
  private void removeEntry(String paramString)
  {
    paramString = (DiskBasedCache.CacheHeader)mEntries.remove(paramString);
    if (paramString != null) {
      mTotalSize -= size;
    }
  }
  
  public static byte[] streamToBytes(DiskBasedCache.CountingInputStream paramCountingInputStream, long paramLong)
  {
    long l = paramCountingInputStream.bytesRemaining();
    if ((paramLong >= 0L) && (paramLong <= l))
    {
      int i = (int)paramLong;
      if (i == paramLong)
      {
        byte[] arrayOfByte = new byte[i];
        new DataInputStream(paramCountingInputStream).readFully(arrayOfByte);
        return arrayOfByte;
      }
    }
    paramCountingInputStream = new StringBuilder();
    paramCountingInputStream.append("streamToBytes length=");
    paramCountingInputStream.append(paramLong);
    paramCountingInputStream.append(", maxLength=");
    paramCountingInputStream.append(l);
    throw new IOException(paramCountingInputStream.toString());
  }
  
  public static void writeHeaderList(List<Header> paramList, OutputStream paramOutputStream)
  {
    if (paramList != null)
    {
      writeInt(paramOutputStream, paramList.size());
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (Header)localIterator.next();
        writeString(paramOutputStream, paramList.getName());
        writeString(paramOutputStream, paramList.getValue());
      }
    }
    writeInt(paramOutputStream, 0);
  }
  
  public static void writeInt(OutputStream paramOutputStream, int paramInt)
  {
    paramOutputStream.write(paramInt >> 0 & 0xFF);
    paramOutputStream.write(paramInt >> 8 & 0xFF);
    paramOutputStream.write(paramInt >> 16 & 0xFF);
    paramOutputStream.write(paramInt >> 24 & 0xFF);
  }
  
  public static void writeLong(OutputStream paramOutputStream, long paramLong)
  {
    paramOutputStream.write((byte)(int)(paramLong >>> 0));
    paramOutputStream.write((byte)(int)(paramLong >>> 8));
    paramOutputStream.write((byte)(int)(paramLong >>> 16));
    paramOutputStream.write((byte)(int)(paramLong >>> 24));
    paramOutputStream.write((byte)(int)(paramLong >>> 32));
    paramOutputStream.write((byte)(int)(paramLong >>> 40));
    paramOutputStream.write((byte)(int)(paramLong >>> 48));
    paramOutputStream.write((byte)(int)(paramLong >>> 56));
  }
  
  public static void writeString(OutputStream paramOutputStream, String paramString)
  {
    paramString = paramString.getBytes("UTF-8");
    writeLong(paramOutputStream, paramString.length);
    paramOutputStream.write(paramString, 0, paramString.length);
  }
  
  public void clear()
  {
    try
    {
      File[] arrayOfFile = mRootDirectory.listFiles();
      if (arrayOfFile != null)
      {
        int i = arrayOfFile.length;
        for (int j = 0; j < i; j++) {
          arrayOfFile[j].delete();
        }
      }
      mEntries.clear();
      mTotalSize = 0L;
      VolleyLog.d("Cache cleared.", new Object[0]);
      return;
    }
    finally {}
  }
  
  public InputStream createInputStream(File paramFile)
  {
    return new FileInputStream(paramFile);
  }
  
  public OutputStream createOutputStream(File paramFile)
  {
    return new FileOutputStream(paramFile);
  }
  
  /* Error */
  public Cache.Entry get(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 45	com/android/volley/toolbox/DiskBasedCache:mEntries	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 182 2 0
    //   12: checkcast 8	com/android/volley/toolbox/DiskBasedCache$CacheHeader
    //   15: astore_2
    //   16: aload_2
    //   17: ifnonnull +7 -> 24
    //   20: aload_0
    //   21: monitorexit
    //   22: aconst_null
    //   23: areturn
    //   24: aload_0
    //   25: aload_1
    //   26: invokevirtual 142	com/android/volley/toolbox/DiskBasedCache:getFileForKey	(Ljava/lang/String;)Ljava/io/File;
    //   29: astore_3
    //   30: new 11	com/android/volley/toolbox/DiskBasedCache$CountingInputStream
    //   33: astore 4
    //   35: new 336	java/io/BufferedInputStream
    //   38: astore 5
    //   40: aload 5
    //   42: aload_0
    //   43: aload_3
    //   44: invokevirtual 338	com/android/volley/toolbox/DiskBasedCache:createInputStream	(Ljava/io/File;)Ljava/io/InputStream;
    //   47: invokespecial 339	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   50: aload 4
    //   52: aload 5
    //   54: aload_3
    //   55: invokevirtual 341	java/io/File:length	()J
    //   58: invokespecial 344	com/android/volley/toolbox/DiskBasedCache$CountingInputStream:<init>	(Ljava/io/InputStream;J)V
    //   61: aload 4
    //   63: invokestatic 348	com/android/volley/toolbox/DiskBasedCache$CacheHeader:readHeader	(Lcom/android/volley/toolbox/DiskBasedCache$CountingInputStream;)Lcom/android/volley/toolbox/DiskBasedCache$CacheHeader;
    //   66: astore 5
    //   68: aload_1
    //   69: aload 5
    //   71: getfield 138	com/android/volley/toolbox/DiskBasedCache$CacheHeader:key	Ljava/lang/String;
    //   74: invokestatic 354	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   77: ifne +46 -> 123
    //   80: ldc_w 356
    //   83: iconst_3
    //   84: anewarray 4	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: aload_3
    //   90: invokevirtual 359	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   93: aastore
    //   94: dup
    //   95: iconst_1
    //   96: aload_1
    //   97: aastore
    //   98: dup
    //   99: iconst_2
    //   100: aload 5
    //   102: getfield 138	com/android/volley/toolbox/DiskBasedCache$CacheHeader:key	Ljava/lang/String;
    //   105: aastore
    //   106: invokestatic 157	com/android/volley/VolleyLog:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   109: aload_0
    //   110: aload_1
    //   111: invokespecial 361	com/android/volley/toolbox/DiskBasedCache:removeEntry	(Ljava/lang/String;)V
    //   114: aload 4
    //   116: invokevirtual 366	java/io/FilterInputStream:close	()V
    //   119: aload_0
    //   120: monitorexit
    //   121: aconst_null
    //   122: areturn
    //   123: aload_2
    //   124: aload 4
    //   126: aload 4
    //   128: invokevirtual 261	com/android/volley/toolbox/DiskBasedCache$CountingInputStream:bytesRemaining	()J
    //   131: invokestatic 250	com/android/volley/toolbox/DiskBasedCache:streamToBytes	(Lcom/android/volley/toolbox/DiskBasedCache$CountingInputStream;J)[B
    //   134: invokevirtual 370	com/android/volley/toolbox/DiskBasedCache$CacheHeader:toCacheEntry	([B)Lcom/android/volley/Cache$Entry;
    //   137: astore_2
    //   138: aload 4
    //   140: invokevirtual 366	java/io/FilterInputStream:close	()V
    //   143: aload_0
    //   144: monitorexit
    //   145: aload_2
    //   146: areturn
    //   147: astore_2
    //   148: aload 4
    //   150: invokevirtual 366	java/io/FilterInputStream:close	()V
    //   153: aload_2
    //   154: athrow
    //   155: astore 4
    //   157: ldc_w 372
    //   160: iconst_2
    //   161: anewarray 4	java/lang/Object
    //   164: dup
    //   165: iconst_0
    //   166: aload_3
    //   167: invokevirtual 359	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   170: aastore
    //   171: dup
    //   172: iconst_1
    //   173: aload 4
    //   175: invokevirtual 373	java/io/IOException:toString	()Ljava/lang/String;
    //   178: aastore
    //   179: invokestatic 157	com/android/volley/VolleyLog:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   182: aload_0
    //   183: aload_1
    //   184: invokevirtual 375	com/android/volley/toolbox/DiskBasedCache:remove	(Ljava/lang/String;)V
    //   187: aload_0
    //   188: monitorexit
    //   189: aconst_null
    //   190: areturn
    //   191: astore_1
    //   192: aload_0
    //   193: monitorexit
    //   194: aload_1
    //   195: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	DiskBasedCache
    //   0	196	1	paramString	String
    //   15	131	2	localObject1	Object
    //   147	7	2	localObject2	Object
    //   29	138	3	localFile	File
    //   33	116	4	localCountingInputStream	DiskBasedCache.CountingInputStream
    //   155	19	4	localIOException	IOException
    //   38	63	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   61	114	147	finally
    //   123	138	147	finally
    //   30	61	155	java/io/IOException
    //   114	119	155	java/io/IOException
    //   138	143	155	java/io/IOException
    //   148	155	155	java/io/IOException
    //   2	16	191	finally
    //   24	30	191	finally
    //   30	61	191	finally
    //   114	119	191	finally
    //   138	143	191	finally
    //   148	155	191	finally
    //   157	187	191	finally
  }
  
  public File getFileForKey(String paramString)
  {
    return new File(mRootDirectory, getFilenameForKey(paramString));
  }
  
  /* Error */
  public void initialize()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 49	com/android/volley/toolbox/DiskBasedCache:mRootDirectory	Ljava/io/File;
    //   6: invokevirtual 382	java/io/File:exists	()Z
    //   9: istore_1
    //   10: iconst_0
    //   11: istore_2
    //   12: iload_1
    //   13: ifne +36 -> 49
    //   16: aload_0
    //   17: getfield 49	com/android/volley/toolbox/DiskBasedCache:mRootDirectory	Ljava/io/File;
    //   20: invokevirtual 385	java/io/File:mkdirs	()Z
    //   23: ifne +23 -> 46
    //   26: ldc_w 387
    //   29: iconst_1
    //   30: anewarray 4	java/lang/Object
    //   33: dup
    //   34: iconst_0
    //   35: aload_0
    //   36: getfield 49	com/android/volley/toolbox/DiskBasedCache:mRootDirectory	Ljava/io/File;
    //   39: invokevirtual 359	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   42: aastore
    //   43: invokestatic 390	com/android/volley/VolleyLog:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: aload_0
    //   50: getfield 49	com/android/volley/toolbox/DiskBasedCache:mRootDirectory	Ljava/io/File;
    //   53: invokevirtual 318	java/io/File:listFiles	()[Ljava/io/File;
    //   56: astore_3
    //   57: aload_3
    //   58: ifnonnull +6 -> 64
    //   61: aload_0
    //   62: monitorexit
    //   63: return
    //   64: aload_3
    //   65: arraylength
    //   66: istore 4
    //   68: iload_2
    //   69: iload 4
    //   71: if_icmpge +102 -> 173
    //   74: aload_3
    //   75: iload_2
    //   76: aaload
    //   77: astore 5
    //   79: aload 5
    //   81: invokevirtual 341	java/io/File:length	()J
    //   84: lstore 6
    //   86: new 11	com/android/volley/toolbox/DiskBasedCache$CountingInputStream
    //   89: astore 8
    //   91: new 336	java/io/BufferedInputStream
    //   94: astore 9
    //   96: aload 9
    //   98: aload_0
    //   99: aload 5
    //   101: invokevirtual 338	com/android/volley/toolbox/DiskBasedCache:createInputStream	(Ljava/io/File;)Ljava/io/InputStream;
    //   104: invokespecial 339	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   107: aload 8
    //   109: aload 9
    //   111: lload 6
    //   113: invokespecial 344	com/android/volley/toolbox/DiskBasedCache$CountingInputStream:<init>	(Ljava/io/InputStream;J)V
    //   116: aload 8
    //   118: invokestatic 348	com/android/volley/toolbox/DiskBasedCache$CacheHeader:readHeader	(Lcom/android/volley/toolbox/DiskBasedCache$CountingInputStream;)Lcom/android/volley/toolbox/DiskBasedCache$CacheHeader;
    //   121: astore 9
    //   123: aload 9
    //   125: lload 6
    //   127: putfield 150	com/android/volley/toolbox/DiskBasedCache$CacheHeader:size	J
    //   130: aload_0
    //   131: aload 9
    //   133: getfield 138	com/android/volley/toolbox/DiskBasedCache$CacheHeader:key	Ljava/lang/String;
    //   136: aload 9
    //   138: invokespecial 392	com/android/volley/toolbox/DiskBasedCache:putEntry	(Ljava/lang/String;Lcom/android/volley/toolbox/DiskBasedCache$CacheHeader;)V
    //   141: aload 8
    //   143: invokevirtual 366	java/io/FilterInputStream:close	()V
    //   146: goto +21 -> 167
    //   149: astore 9
    //   151: aload 8
    //   153: invokevirtual 366	java/io/FilterInputStream:close	()V
    //   156: aload 9
    //   158: athrow
    //   159: astore 8
    //   161: aload 5
    //   163: invokevirtual 147	java/io/File:delete	()Z
    //   166: pop
    //   167: iinc 2 1
    //   170: goto -102 -> 68
    //   173: aload_0
    //   174: monitorexit
    //   175: return
    //   176: astore_3
    //   177: aload_0
    //   178: monitorexit
    //   179: aload_3
    //   180: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	DiskBasedCache
    //   9	4	1	bool	boolean
    //   11	157	2	i	int
    //   56	19	3	arrayOfFile	File[]
    //   176	4	3	localObject1	Object
    //   66	6	4	j	int
    //   77	85	5	localFile	File
    //   84	42	6	l	long
    //   89	63	8	localCountingInputStream	DiskBasedCache.CountingInputStream
    //   159	1	8	localIOException	IOException
    //   94	43	9	localObject2	Object
    //   149	8	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   116	141	149	finally
    //   79	116	159	java/io/IOException
    //   141	146	159	java/io/IOException
    //   151	159	159	java/io/IOException
    //   2	10	176	finally
    //   16	46	176	finally
    //   49	57	176	finally
    //   64	68	176	finally
    //   79	116	176	finally
    //   141	146	176	finally
    //   151	159	176	finally
    //   161	167	176	finally
  }
  
  public void invalidate(String paramString, boolean paramBoolean)
  {
    try
    {
      Cache.Entry localEntry = get(paramString);
      if (localEntry != null)
      {
        softTtl = 0L;
        if (paramBoolean) {
          ttl = 0L;
        }
        put(paramString, localEntry);
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public void put(String paramString, Cache.Entry paramEntry)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_2
    //   4: getfield 411	com/android/volley/Cache$Entry:data	[B
    //   7: arraylength
    //   8: invokespecial 413	com/android/volley/toolbox/DiskBasedCache:pruneIfNeeded	(I)V
    //   11: aload_0
    //   12: aload_1
    //   13: invokevirtual 142	com/android/volley/toolbox/DiskBasedCache:getFileForKey	(Ljava/lang/String;)Ljava/io/File;
    //   16: astore_3
    //   17: new 415	java/io/BufferedOutputStream
    //   20: astore 4
    //   22: aload 4
    //   24: aload_0
    //   25: aload_3
    //   26: invokevirtual 417	com/android/volley/toolbox/DiskBasedCache:createOutputStream	(Ljava/io/File;)Ljava/io/OutputStream;
    //   29: invokespecial 420	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   32: new 8	com/android/volley/toolbox/DiskBasedCache$CacheHeader
    //   35: astore 5
    //   37: aload 5
    //   39: aload_1
    //   40: aload_2
    //   41: invokespecial 422	com/android/volley/toolbox/DiskBasedCache$CacheHeader:<init>	(Ljava/lang/String;Lcom/android/volley/Cache$Entry;)V
    //   44: aload 5
    //   46: aload 4
    //   48: invokevirtual 426	com/android/volley/toolbox/DiskBasedCache$CacheHeader:writeHeader	(Ljava/io/OutputStream;)Z
    //   51: ifeq +27 -> 78
    //   54: aload 4
    //   56: aload_2
    //   57: getfield 411	com/android/volley/Cache$Entry:data	[B
    //   60: invokevirtual 428	java/io/BufferedOutputStream:write	([B)V
    //   63: aload 4
    //   65: invokevirtual 429	java/io/BufferedOutputStream:close	()V
    //   68: aload_0
    //   69: aload_1
    //   70: aload 5
    //   72: invokespecial 392	com/android/volley/toolbox/DiskBasedCache:putEntry	(Ljava/lang/String;Lcom/android/volley/toolbox/DiskBasedCache$CacheHeader;)V
    //   75: aload_0
    //   76: monitorexit
    //   77: return
    //   78: aload 4
    //   80: invokevirtual 429	java/io/BufferedOutputStream:close	()V
    //   83: ldc_w 431
    //   86: iconst_1
    //   87: anewarray 4	java/lang/Object
    //   90: dup
    //   91: iconst_0
    //   92: aload_3
    //   93: invokevirtual 359	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   96: aastore
    //   97: invokestatic 157	com/android/volley/VolleyLog:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   100: new 228	java/io/IOException
    //   103: astore_1
    //   104: aload_1
    //   105: invokespecial 432	java/io/IOException:<init>	()V
    //   108: aload_1
    //   109: athrow
    //   110: astore_1
    //   111: aload_3
    //   112: invokevirtual 147	java/io/File:delete	()Z
    //   115: ifne +20 -> 135
    //   118: ldc_w 434
    //   121: iconst_1
    //   122: anewarray 4	java/lang/Object
    //   125: dup
    //   126: iconst_0
    //   127: aload_3
    //   128: invokevirtual 359	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   131: aastore
    //   132: invokestatic 157	com/android/volley/VolleyLog:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   135: aload_0
    //   136: monitorexit
    //   137: return
    //   138: astore_1
    //   139: aload_0
    //   140: monitorexit
    //   141: aload_1
    //   142: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	DiskBasedCache
    //   0	143	1	paramString	String
    //   0	143	2	paramEntry	Cache.Entry
    //   16	112	3	localFile	File
    //   20	59	4	localBufferedOutputStream	java.io.BufferedOutputStream
    //   35	36	5	localCacheHeader	DiskBasedCache.CacheHeader
    // Exception table:
    //   from	to	target	type
    //   17	75	110	java/io/IOException
    //   78	110	110	java/io/IOException
    //   2	17	138	finally
    //   17	75	138	finally
    //   78	110	138	finally
    //   111	135	138	finally
  }
  
  public void remove(String paramString)
  {
    try
    {
      boolean bool = getFileForKey(paramString).delete();
      removeEntry(paramString);
      if (!bool) {
        VolleyLog.d("Could not delete cache entry for key=%s, filename=%s", new Object[] { paramString, getFilenameForKey(paramString) });
      }
      return;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     base.com.android.volley.toolbox.DiskBasedCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */