package d.r;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import d.b.a.s;
import e.a.a.a.a;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class d
  implements Closeable
{
  public final RandomAccessFile A;
  public final FileChannel B;
  public final FileLock C;
  public final File x;
  public final long y;
  public final File z;
  
  public d(File paramFile1, File paramFile2)
  {
    StringBuilder localStringBuilder = a.a("MultiDexExtractor(");
    localStringBuilder.append(paramFile1.getPath());
    localStringBuilder.append(", ");
    localStringBuilder.append(paramFile2.getPath());
    localStringBuilder.append(")");
    Log.i("MultiDex", localStringBuilder.toString());
    x = paramFile1;
    z = paramFile2;
    y = b(paramFile1);
    paramFile1 = new File(paramFile2, "MultiDex.lock");
    paramFile2 = new RandomAccessFile(paramFile1, "rw");
    A = paramFile2;
    try
    {
      B = paramFile2.getChannel();
      try
      {
        paramFile2 = new java/lang/StringBuilder;
        paramFile2.<init>();
        paramFile2.append("Blocking on lock ");
        paramFile2.append(paramFile1.getPath());
        Log.i("MultiDex", paramFile2.toString());
        C = B.lock();
        paramFile2 = new java/lang/StringBuilder;
        paramFile2.<init>();
        paramFile2.append(paramFile1.getPath());
        paramFile2.append(" locked");
        Log.i("MultiDex", paramFile2.toString());
        return;
      }
      catch (Error paramFile1) {}catch (RuntimeException paramFile1) {}catch (IOException paramFile1) {}
      a(B);
      throw paramFile1;
    }
    catch (Error paramFile1) {}catch (RuntimeException paramFile1) {}catch (IOException paramFile1) {}
    a(A);
    throw paramFile1;
  }
  
  public static long a(File paramFile)
  {
    long l1 = paramFile.lastModified();
    long l2 = l1;
    if (l1 == -1L) {
      l2 = l1 - 1L;
    }
    return l2;
  }
  
  public static void a(Context paramContext, String paramString, long paramLong1, long paramLong2, List<a> paramList)
  {
    paramContext = paramContext.getSharedPreferences("multidex.version", 4).edit();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("timestamp");
    paramContext.putLong(((StringBuilder)localObject).toString(), paramLong1);
    paramContext.putLong(a.a(new StringBuilder(), paramString, "crc"), paramLong2);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("dex.number");
    paramContext.putInt(((StringBuilder)localObject).toString(), paramList.size() + 1);
    int i = 2;
    localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramList = (a)((Iterator)localObject).next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("dex.crc.");
      localStringBuilder.append(i);
      paramContext.putLong(localStringBuilder.toString(), x);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("dex.time.");
      localStringBuilder.append(i);
      paramContext.putLong(localStringBuilder.toString(), paramList.lastModified());
      i++;
    }
    paramContext.commit();
  }
  
  public static void a(Closeable paramCloseable)
  {
    try
    {
      paramCloseable.close();
    }
    catch (IOException paramCloseable)
    {
      Log.w("MultiDex", "Failed to close resource", paramCloseable);
    }
  }
  
  /* Error */
  public static void a(ZipFile paramZipFile, ZipEntry paramZipEntry, File paramFile, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 199	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   5: astore_0
    //   6: ldc -55
    //   8: aload_3
    //   9: invokestatic 204	e/a/a/a/a:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   12: ldc -50
    //   14: aload_2
    //   15: invokevirtual 210	java/io/File:getParentFile	()Ljava/io/File;
    //   18: invokestatic 214	java/io/File:createTempFile	(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;
    //   21: astore_3
    //   22: ldc -40
    //   24: invokestatic 38	e/a/a/a/a:a	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: astore 4
    //   29: aload 4
    //   31: aload_3
    //   32: invokevirtual 44	java/io/File:getPath	()Ljava/lang/String;
    //   35: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: ldc 55
    //   41: aload 4
    //   43: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 64	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   49: pop
    //   50: new 218	java/util/zip/ZipOutputStream
    //   53: astore 4
    //   55: new 220	java/io/BufferedOutputStream
    //   58: astore 5
    //   60: new 222	java/io/FileOutputStream
    //   63: astore 6
    //   65: aload 6
    //   67: aload_3
    //   68: invokespecial 225	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   71: aload 5
    //   73: aload 6
    //   75: invokespecial 228	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   78: aload 4
    //   80: aload 5
    //   82: invokespecial 229	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   85: new 231	java/util/zip/ZipEntry
    //   88: astore 6
    //   90: aload 6
    //   92: ldc -23
    //   94: invokespecial 236	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   97: aload 6
    //   99: aload_1
    //   100: invokevirtual 239	java/util/zip/ZipEntry:getTime	()J
    //   103: invokevirtual 243	java/util/zip/ZipEntry:setTime	(J)V
    //   106: aload 4
    //   108: aload 6
    //   110: invokevirtual 247	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   113: sipush 16384
    //   116: newarray <illegal type>
    //   118: astore_1
    //   119: aload_0
    //   120: aload_1
    //   121: invokevirtual 253	java/io/InputStream:read	([B)I
    //   124: istore 7
    //   126: iload 7
    //   128: iconst_m1
    //   129: if_icmpeq +22 -> 151
    //   132: aload 4
    //   134: aload_1
    //   135: iconst_0
    //   136: iload 7
    //   138: invokevirtual 257	java/util/zip/ZipOutputStream:write	([BII)V
    //   141: aload_0
    //   142: aload_1
    //   143: invokevirtual 253	java/io/InputStream:read	([B)I
    //   146: istore 7
    //   148: goto -22 -> 126
    //   151: aload 4
    //   153: invokevirtual 260	java/util/zip/ZipOutputStream:closeEntry	()V
    //   156: aload 4
    //   158: invokevirtual 261	java/util/zip/ZipOutputStream:close	()V
    //   161: aload_3
    //   162: invokevirtual 264	java/io/File:setReadOnly	()Z
    //   165: ifeq +132 -> 297
    //   168: new 46	java/lang/StringBuilder
    //   171: astore_1
    //   172: aload_1
    //   173: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   176: aload_1
    //   177: ldc_w 266
    //   180: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload_1
    //   185: aload_2
    //   186: invokevirtual 44	java/io/File:getPath	()Ljava/lang/String;
    //   189: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: ldc 55
    //   195: aload_1
    //   196: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokestatic 64	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   202: pop
    //   203: aload_3
    //   204: aload_2
    //   205: invokevirtual 270	java/io/File:renameTo	(Ljava/io/File;)Z
    //   208: istore 8
    //   210: iload 8
    //   212: ifeq +13 -> 225
    //   215: aload_0
    //   216: invokestatic 108	d/r/d:a	(Ljava/io/Closeable;)V
    //   219: aload_3
    //   220: invokevirtual 273	java/io/File:delete	()Z
    //   223: pop
    //   224: return
    //   225: new 24	java/io/IOException
    //   228: astore_1
    //   229: new 46	java/lang/StringBuilder
    //   232: astore 4
    //   234: aload 4
    //   236: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   239: aload 4
    //   241: ldc_w 275
    //   244: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload 4
    //   250: aload_3
    //   251: invokevirtual 278	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   254: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload 4
    //   260: ldc_w 280
    //   263: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload 4
    //   269: aload_2
    //   270: invokevirtual 278	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   273: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload 4
    //   279: ldc_w 282
    //   282: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload_1
    //   287: aload 4
    //   289: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokespecial 283	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   295: aload_1
    //   296: athrow
    //   297: new 24	java/io/IOException
    //   300: astore 4
    //   302: new 46	java/lang/StringBuilder
    //   305: astore_1
    //   306: aload_1
    //   307: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   310: aload_1
    //   311: ldc_w 285
    //   314: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: pop
    //   318: aload_1
    //   319: aload_3
    //   320: invokevirtual 278	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   323: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: pop
    //   327: aload_1
    //   328: ldc_w 287
    //   331: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: aload_1
    //   336: aload_2
    //   337: invokevirtual 278	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   340: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload_1
    //   345: ldc_w 289
    //   348: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: aload 4
    //   354: aload_1
    //   355: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokespecial 283	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   361: aload 4
    //   363: athrow
    //   364: astore_1
    //   365: aload 4
    //   367: invokevirtual 261	java/util/zip/ZipOutputStream:close	()V
    //   370: aload_1
    //   371: athrow
    //   372: astore_1
    //   373: aload_0
    //   374: invokestatic 108	d/r/d:a	(Ljava/io/Closeable;)V
    //   377: aload_3
    //   378: invokevirtual 273	java/io/File:delete	()Z
    //   381: pop
    //   382: aload_1
    //   383: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	384	0	paramZipFile	ZipFile
    //   0	384	1	paramZipEntry	ZipEntry
    //   0	384	2	paramFile	File
    //   0	384	3	paramString	String
    //   27	339	4	localObject1	Object
    //   58	23	5	localBufferedOutputStream	java.io.BufferedOutputStream
    //   63	46	6	localObject2	Object
    //   124	23	7	i	int
    //   208	3	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   85	126	364	finally
    //   132	148	364	finally
    //   151	156	364	finally
    //   50	85	372	finally
    //   156	210	372	finally
    //   225	297	372	finally
    //   297	364	372	finally
    //   365	372	372	finally
  }
  
  public static long b(File paramFile)
  {
    paramFile = new RandomAccessFile(paramFile, "r");
    try
    {
      Object localObject1 = s.a(paramFile);
      CRC32 localCRC32 = new java/util/zip/CRC32;
      localCRC32.<init>();
      long l1 = b;
      paramFile.seek(a);
      int i = (int)Math.min(16384L, l1);
      localObject1 = new byte['䀀'];
      for (i = paramFile.read((byte[])localObject1, 0, i); i != -1; i = paramFile.read((byte[])localObject1, 0, (int)Math.min(16384L, l1)))
      {
        localCRC32.update((byte[])localObject1, 0, i);
        l1 -= i;
        if (l1 == 0L) {
          break;
        }
      }
      long l2 = localCRC32.getValue();
      paramFile.close();
      l1 = l2;
      if (l2 == -1L) {
        l1 = l2 - 1L;
      }
      return l1;
    }
    finally
    {
      paramFile.close();
    }
  }
  
  public final List<a> a()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(x.getName());
    ((StringBuilder)localObject1).append(".classes");
    String str = ((StringBuilder)localObject1).toString();
    Object localObject3 = z.listFiles(new c(this));
    int j;
    if (localObject3 == null)
    {
      localObject1 = a.a("Failed to list secondary dex dir content (");
      ((StringBuilder)localObject1).append(z.getPath());
      ((StringBuilder)localObject1).append(").");
      Log.w("MultiDex", ((StringBuilder)localObject1).toString());
    }
    else
    {
      i = localObject3.length;
      for (j = 0; j < i; j++)
      {
        localObject1 = localObject3[j];
        localObject5 = a.a("Trying to delete old file ");
        ((StringBuilder)localObject5).append(((File)localObject1).getPath());
        ((StringBuilder)localObject5).append(" of size ");
        ((StringBuilder)localObject5).append(((File)localObject1).length());
        Log.i("MultiDex", ((StringBuilder)localObject5).toString());
        if (!((File)localObject1).delete())
        {
          localObject5 = a.a("Failed to delete old file ");
          ((StringBuilder)localObject5).append(((File)localObject1).getPath());
          Log.w("MultiDex", ((StringBuilder)localObject5).toString());
        }
        else
        {
          localObject5 = a.a("Deleted old file ");
          ((StringBuilder)localObject5).append(((File)localObject1).getPath());
          Log.i("MultiDex", ((StringBuilder)localObject5).toString());
        }
      }
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject5 = new ZipFile(x);
    int i = 2;
    try
    {
      localObject1 = ((ZipFile)localObject5).getEntry("classes2.dex");
      while (localObject1 != null)
      {
        localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>();
        ((StringBuilder)localObject3).append(str);
        ((StringBuilder)localObject3).append(i);
        ((StringBuilder)localObject3).append(".zip");
        localObject3 = ((StringBuilder)localObject3).toString();
        a locala = new d/r/d$a;
        locala.<init>(z, (String)localObject3);
        localArrayList.add(locala);
        localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>();
        ((StringBuilder)localObject3).append("Extraction is needed for file ");
        ((StringBuilder)localObject3).append(locala);
        Log.i("MultiDex", ((StringBuilder)localObject3).toString());
        int k = 0;
        int m = 0;
        Object localObject4;
        while ((k < 3) && (m == 0))
        {
          int n = k + 1;
          a((ZipFile)localObject5, (ZipEntry)localObject1, locala, str);
          try
          {
            x = b(locala);
            j = 1;
          }
          catch (IOException localIOException2)
          {
            localStringBuilder = new java/lang/StringBuilder;
            localStringBuilder.<init>();
            localStringBuilder.append("Failed to read crc from ");
            localStringBuilder.append(locala.getAbsolutePath());
            Log.w("MultiDex", localStringBuilder.toString(), localIOException2);
            j = 0;
          }
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          localStringBuilder.append("Extraction ");
          if (j != 0) {
            localObject4 = "succeeded";
          } else {
            localObject4 = "failed";
          }
          localStringBuilder.append((String)localObject4);
          localStringBuilder.append(" '");
          localStringBuilder.append(locala.getAbsolutePath());
          localStringBuilder.append("': length ");
          localStringBuilder.append(locala.length());
          localStringBuilder.append(" - crc: ");
          localStringBuilder.append(x);
          Log.i("MultiDex", localStringBuilder.toString());
          k = n;
          m = j;
          if (j == 0)
          {
            locala.delete();
            k = n;
            m = j;
            if (locala.exists())
            {
              localObject4 = new java/lang/StringBuilder;
              ((StringBuilder)localObject4).<init>();
              ((StringBuilder)localObject4).append("Failed to delete corrupted secondary dex '");
              ((StringBuilder)localObject4).append(locala.getPath());
              ((StringBuilder)localObject4).append("'");
              Log.w("MultiDex", ((StringBuilder)localObject4).toString());
              k = n;
              m = j;
            }
          }
        }
        if (m != 0)
        {
          i++;
          localObject1 = new java/lang/StringBuilder;
          ((StringBuilder)localObject1).<init>();
          ((StringBuilder)localObject1).append("classes");
          ((StringBuilder)localObject1).append(i);
          ((StringBuilder)localObject1).append(".dex");
          localObject1 = ((ZipFile)localObject5).getEntry(((StringBuilder)localObject1).toString());
        }
        else
        {
          localObject1 = new java/io/IOException;
          localObject4 = new java/lang/StringBuilder;
          ((StringBuilder)localObject4).<init>();
          ((StringBuilder)localObject4).append("Could not create zip file ");
          ((StringBuilder)localObject4).append(locala.getAbsolutePath());
          ((StringBuilder)localObject4).append(" for secondary dex (");
          ((StringBuilder)localObject4).append(i);
          ((StringBuilder)localObject4).append(")");
          ((IOException)localObject1).<init>(((StringBuilder)localObject4).toString());
          throw ((Throwable)localObject1);
        }
      }
      return localArrayList;
    }
    finally
    {
      try
      {
        ((ZipFile)localObject5).close();
      }
      catch (IOException localIOException3)
      {
        Log.w("MultiDex", "Failed to close resource", localIOException3);
      }
    }
  }
  
  public final List<a> a(Context paramContext, String paramString)
  {
    Log.i("MultiDex", "loading existing secondary dex files");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(x.getName());
    ((StringBuilder)localObject1).append(".classes");
    localObject1 = ((StringBuilder)localObject1).toString();
    paramContext = paramContext.getSharedPreferences("multidex.version", 4);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append("dex.number");
    int i = paramContext.getInt(((StringBuilder)localObject2).toString(), 1);
    localObject2 = new ArrayList(i - 1);
    int j = 2;
    while (j <= i)
    {
      Object localObject3 = a.b((String)localObject1, j, ".zip");
      localObject3 = new a(z, (String)localObject3);
      if (((File)localObject3).isFile())
      {
        x = b((File)localObject3);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("dex.crc.");
        localStringBuilder.append(j);
        long l1 = paramContext.getLong(localStringBuilder.toString(), -1L);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("dex.time.");
        localStringBuilder.append(j);
        long l2 = paramContext.getLong(localStringBuilder.toString(), -1L);
        long l3 = ((File)localObject3).lastModified();
        if ((l2 == l3) && (l1 == x))
        {
          ((ArrayList)localObject2).add(localObject3);
          j++;
        }
        else
        {
          paramContext = new StringBuilder();
          paramContext.append("Invalid extracted dex: ");
          paramContext.append(localObject3);
          paramContext.append(" (key \"");
          paramContext.append(paramString);
          paramContext.append("\"), expected modification time: ");
          paramContext.append(l2);
          paramContext.append(", modification time: ");
          paramContext.append(l3);
          paramContext.append(", expected crc: ");
          paramContext.append(l1);
          paramContext.append(", file crc: ");
          paramContext.append(x);
          throw new IOException(paramContext.toString());
        }
      }
      else
      {
        paramContext = a.a("Missing extracted secondary dex file '");
        paramContext.append(((File)localObject3).getPath());
        paramContext.append("'");
        throw new IOException(paramContext.toString());
      }
    }
    return (List<a>)localObject2;
  }
  
  public List<? extends File> a(Context paramContext, String paramString, boolean paramBoolean)
  {
    Object localObject = a.a("MultiDexExtractor.load(");
    ((StringBuilder)localObject).append(x.getPath());
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(")");
    Log.i("MultiDex", ((StringBuilder)localObject).toString());
    if (C.isValid())
    {
      if (!paramBoolean)
      {
        File localFile = x;
        long l = y;
        localObject = paramContext.getSharedPreferences("multidex.version", 4);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("timestamp");
        if (((SharedPreferences)localObject).getLong(localStringBuilder.toString(), -1L) == a(localFile))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append("crc");
          if (((SharedPreferences)localObject).getLong(localStringBuilder.toString(), -1L) == l)
          {
            i = 0;
            break label210;
          }
        }
        int i = 1;
        label210:
        if (i == 0) {
          try
          {
            localObject = a(paramContext, paramString);
            paramContext = (Context)localObject;
          }
          catch (IOException localIOException)
          {
            Log.w("MultiDex", "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", localIOException);
            localList = a();
            a(paramContext, paramString, a(x), y, localList);
            paramContext = localList;
          }
        }
      }
      if (paramBoolean) {
        Log.i("MultiDex", "Forced extraction must be performed.");
      } else {
        Log.i("MultiDex", "Detected that extraction must be performed.");
      }
      List localList = a();
      a(paramContext, paramString, a(x), y, localList);
      paramContext = localList;
      paramString = a.a("load found ");
      paramString.append(paramContext.size());
      paramString.append(" secondary dex files");
      Log.i("MultiDex", paramString.toString());
      return paramContext;
    }
    throw new IllegalStateException("MultiDexExtractor was closed");
  }
  
  public void close()
  {
    C.release();
    B.close();
    A.close();
  }
  
  public static class a
    extends File
  {
    public long x = -1L;
    
    public a(File paramFile, String paramString)
    {
      super(paramString);
    }
  }
}

/* Location:
 * Qualified Name:     d.r.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */