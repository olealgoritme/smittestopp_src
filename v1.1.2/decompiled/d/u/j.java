package d.u;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build.VERSION;
import d.w.a.b;
import d.w.a.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class j
  implements c
{
  public final Context a;
  public final String b;
  public final File c;
  public final int d;
  public final c e;
  public a f;
  public boolean g;
  
  /* Error */
  public final void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 25	d/u/j:e	Ld/w/a/c;
    //   4: invokeinterface 29 1 0
    //   9: astore_1
    //   10: aload_0
    //   11: getfield 31	d/u/j:a	Landroid/content/Context;
    //   14: aload_1
    //   15: invokevirtual 37	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   18: astore_2
    //   19: aload_0
    //   20: getfield 39	d/u/j:f	Ld/u/a;
    //   23: astore_3
    //   24: aload_3
    //   25: ifnull +19 -> 44
    //   28: aload_3
    //   29: getfield 44	d/u/a:j	Z
    //   32: ifeq +6 -> 38
    //   35: goto +9 -> 44
    //   38: iconst_0
    //   39: istore 4
    //   41: goto +6 -> 47
    //   44: iconst_1
    //   45: istore 4
    //   47: new 46	d/u/m/a
    //   50: dup
    //   51: aload_1
    //   52: aload_0
    //   53: getfield 31	d/u/j:a	Landroid/content/Context;
    //   56: invokevirtual 50	android/content/Context:getFilesDir	()Ljava/io/File;
    //   59: iload 4
    //   61: invokespecial 54	d/u/m/a:<init>	(Ljava/lang/String;Ljava/io/File;Z)V
    //   64: astore_3
    //   65: aload_3
    //   66: getfield 57	d/u/m/a:b	Ljava/util/concurrent/locks/Lock;
    //   69: invokeinterface 62 1 0
    //   74: aload_3
    //   75: getfield 64	d/u/m/a:c	Z
    //   78: istore 4
    //   80: iload 4
    //   82: ifeq +53 -> 135
    //   85: new 66	java/io/FileOutputStream
    //   88: astore 5
    //   90: aload 5
    //   92: aload_3
    //   93: getfield 68	d/u/m/a:a	Ljava/io/File;
    //   96: invokespecial 71	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   99: aload 5
    //   101: invokevirtual 75	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   104: astore 5
    //   106: aload_3
    //   107: aload 5
    //   109: putfield 78	d/u/m/a:d	Ljava/nio/channels/FileChannel;
    //   112: aload 5
    //   114: invokevirtual 83	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   117: pop
    //   118: goto +17 -> 135
    //   121: astore_1
    //   122: new 85	java/lang/IllegalStateException
    //   125: astore_2
    //   126: aload_2
    //   127: ldc 87
    //   129: aload_1
    //   130: invokespecial 90	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   133: aload_2
    //   134: athrow
    //   135: aload_2
    //   136: invokevirtual 96	java/io/File:exists	()Z
    //   139: istore 4
    //   141: iload 4
    //   143: ifne +27 -> 170
    //   146: aload_0
    //   147: aload_2
    //   148: invokevirtual 98	d/u/j:a	(Ljava/io/File;)V
    //   151: aload_3
    //   152: invokevirtual 100	d/u/m/a:a	()V
    //   155: return
    //   156: astore_2
    //   157: new 102	java/lang/RuntimeException
    //   160: astore_1
    //   161: aload_1
    //   162: ldc 104
    //   164: aload_2
    //   165: invokespecial 105	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   168: aload_1
    //   169: athrow
    //   170: aload_0
    //   171: getfield 39	d/u/j:f	Ld/u/a;
    //   174: astore 5
    //   176: aload 5
    //   178: ifnonnull +8 -> 186
    //   181: aload_3
    //   182: invokevirtual 100	d/u/m/a:a	()V
    //   185: return
    //   186: aload_2
    //   187: invokestatic 110	d/u/m/b:a	(Ljava/io/File;)I
    //   190: istore 6
    //   192: aload_0
    //   193: getfield 112	d/u/j:d	I
    //   196: istore 7
    //   198: iload 6
    //   200: iload 7
    //   202: if_icmpne +8 -> 210
    //   205: aload_3
    //   206: invokevirtual 100	d/u/m/a:a	()V
    //   209: return
    //   210: aload_0
    //   211: getfield 39	d/u/j:f	Ld/u/a;
    //   214: iload 6
    //   216: aload_0
    //   217: getfield 112	d/u/j:d	I
    //   220: invokevirtual 115	d/u/a:a	(II)Z
    //   223: istore 4
    //   225: iload 4
    //   227: ifeq +8 -> 235
    //   230: aload_3
    //   231: invokevirtual 100	d/u/m/a:a	()V
    //   234: return
    //   235: aload_0
    //   236: getfield 31	d/u/j:a	Landroid/content/Context;
    //   239: aload_1
    //   240: invokevirtual 119	android/content/Context:deleteDatabase	(Ljava/lang/String;)Z
    //   243: istore 4
    //   245: iload 4
    //   247: ifeq +24 -> 271
    //   250: aload_0
    //   251: aload_2
    //   252: invokevirtual 98	d/u/j:a	(Ljava/io/File;)V
    //   255: goto +54 -> 309
    //   258: astore_1
    //   259: ldc 121
    //   261: ldc 104
    //   263: aload_1
    //   264: invokestatic 127	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   267: pop
    //   268: goto +41 -> 309
    //   271: new 129	java/lang/StringBuilder
    //   274: astore_2
    //   275: aload_2
    //   276: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   279: aload_2
    //   280: ldc -123
    //   282: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload_2
    //   287: aload_1
    //   288: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: aload_2
    //   293: ldc -117
    //   295: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: ldc 121
    //   301: aload_2
    //   302: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokestatic 145	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   308: pop
    //   309: aload_3
    //   310: invokevirtual 100	d/u/m/a:a	()V
    //   313: return
    //   314: astore_1
    //   315: ldc 121
    //   317: ldc -109
    //   319: aload_1
    //   320: invokestatic 127	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   323: pop
    //   324: aload_3
    //   325: invokevirtual 100	d/u/m/a:a	()V
    //   328: return
    //   329: astore_1
    //   330: aload_3
    //   331: invokevirtual 100	d/u/m/a:a	()V
    //   334: aload_1
    //   335: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	336	0	this	j
    //   9	43	1	str	String
    //   121	9	1	localIOException1	IOException
    //   160	80	1	localRuntimeException	RuntimeException
    //   258	30	1	localIOException2	IOException
    //   314	6	1	localIOException3	IOException
    //   329	6	1	localObject1	Object
    //   18	130	2	localObject2	Object
    //   156	96	2	localIOException4	IOException
    //   274	28	2	localStringBuilder	StringBuilder
    //   23	308	3	localObject3	Object
    //   39	207	4	bool	boolean
    //   88	89	5	localObject4	Object
    //   190	25	6	i	int
    //   196	7	7	j	int
    // Exception table:
    //   from	to	target	type
    //   85	118	121	java/io/IOException
    //   146	151	156	java/io/IOException
    //   250	255	258	java/io/IOException
    //   186	192	314	java/io/IOException
    //   65	80	329	finally
    //   85	118	329	finally
    //   122	135	329	finally
    //   135	141	329	finally
    //   146	151	329	finally
    //   157	170	329	finally
    //   170	176	329	finally
    //   186	192	329	finally
    //   192	198	329	finally
    //   210	225	329	finally
    //   235	245	329	finally
    //   250	255	329	finally
    //   259	268	329	finally
    //   271	309	329	finally
    //   315	324	329	finally
  }
  
  public final void a(File paramFile)
  {
    Object localObject;
    if (b != null)
    {
      localObject = Channels.newChannel(a.getAssets().open(b));
    }
    else
    {
      if (c == null) {
        break label294;
      }
      localObject = new FileInputStream(c).getChannel();
    }
    File localFile = File.createTempFile("room-copy-helper", ".tmp", a.getCacheDir());
    localFile.deleteOnExit();
    FileChannel localFileChannel = new FileOutputStream(localFile).getChannel();
    try
    {
      if (Build.VERSION.SDK_INT > 23)
      {
        localFileChannel.transferFrom((ReadableByteChannel)localObject, 0L, Long.MAX_VALUE);
      }
      else
      {
        InputStream localInputStream = Channels.newInputStream((ReadableByteChannel)localObject);
        OutputStream localOutputStream = Channels.newOutputStream(localFileChannel);
        byte[] arrayOfByte = new byte['က'];
        for (;;)
        {
          int i = localInputStream.read(arrayOfByte);
          if (i <= 0) {
            break;
          }
          localOutputStream.write(arrayOfByte, 0, i);
        }
      }
      localFileChannel.force(false);
      ((ReadableByteChannel)localObject).close();
      localFileChannel.close();
      localObject = paramFile.getParentFile();
      if ((localObject != null) && (!((File)localObject).exists()) && (!((File)localObject).mkdirs()))
      {
        localObject = e.a.a.a.a.a("Failed to create directories for ");
        ((StringBuilder)localObject).append(paramFile.getAbsolutePath());
        throw new IOException(((StringBuilder)localObject).toString());
      }
      if (localFile.renameTo(paramFile)) {
        return;
      }
      localObject = e.a.a.a.a.a("Failed to move intermediate file (");
      ((StringBuilder)localObject).append(localFile.getAbsolutePath());
      ((StringBuilder)localObject).append(") to destination (");
      ((StringBuilder)localObject).append(paramFile.getAbsolutePath());
      ((StringBuilder)localObject).append(").");
      throw new IOException(((StringBuilder)localObject).toString());
    }
    finally
    {
      ((ReadableByteChannel)localObject).close();
      localFileChannel.close();
    }
    label294:
    throw new IllegalStateException("copyFromAssetPath and copyFromFile == null!");
  }
  
  public String getDatabaseName()
  {
    return e.getDatabaseName();
  }
  
  public b getWritableDatabase()
  {
    try
    {
      if (!g)
      {
        a();
        g = true;
      }
      b localb = e.getWritableDatabase();
      return localb;
    }
    finally {}
  }
  
  public void setWriteAheadLoggingEnabled(boolean paramBoolean)
  {
    e.setWriteAheadLoggingEnabled(paramBoolean);
  }
}

/* Location:
 * Qualified Name:     d.u.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */