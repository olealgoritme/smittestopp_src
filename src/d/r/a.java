package d.r;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
{
  public static final Set<File> a = new HashSet();
  public static final boolean b;
  
  static
  {
    String str = System.getProperty("java.vm.version");
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (str != null)
    {
      Matcher localMatcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(str);
      bool2 = bool1;
      if (localMatcher.matches()) {
        try
        {
          int i = Integer.parseInt(localMatcher.group(1));
          int j = Integer.parseInt(localMatcher.group(2));
          if (i <= 2)
          {
            bool2 = bool1;
            if (i == 2)
            {
              bool2 = bool1;
              if (j < 1) {}
            }
          }
          else
          {
            bool2 = true;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          bool2 = bool1;
        }
      }
    }
    StringBuilder localStringBuilder = e.a.a.a.a.a("VM with version ", str);
    if (bool2) {
      str = " has multidex support";
    } else {
      str = " does not have multidex support";
    }
    localStringBuilder.append(str);
    Log.i("MultiDex", localStringBuilder.toString());
    b = bool2;
  }
  
  public static Field a(Object paramObject, String paramString)
  {
    Object localObject = paramObject.getClass();
    while (localObject != null) {
      try
      {
        Field localField = ((Class)localObject).getDeclaredField(paramString);
        if (!localField.isAccessible()) {
          localField.setAccessible(true);
        }
        return localField;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localObject = ((Class)localObject).getSuperclass();
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Field ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" not found in ");
    ((StringBuilder)localObject).append(paramObject.getClass());
    throw new NoSuchFieldException(((StringBuilder)localObject).toString());
  }
  
  public static void a(Context paramContext)
  {
    paramContext = new File(paramContext.getFilesDir(), "secondary-dexes");
    if (paramContext.isDirectory())
    {
      StringBuilder localStringBuilder1 = e.a.a.a.a.a("Clearing old secondary dex dir (");
      localStringBuilder1.append(paramContext.getPath());
      localStringBuilder1.append(").");
      Log.i("MultiDex", localStringBuilder1.toString());
      File[] arrayOfFile = paramContext.listFiles();
      if (arrayOfFile == null)
      {
        localStringBuilder1 = e.a.a.a.a.a("Failed to list secondary dex dir content (");
        localStringBuilder1.append(paramContext.getPath());
        localStringBuilder1.append(").");
        Log.w("MultiDex", localStringBuilder1.toString());
        return;
      }
      int i = arrayOfFile.length;
      for (int j = 0; j < i; j++)
      {
        localStringBuilder1 = arrayOfFile[j];
        StringBuilder localStringBuilder2 = e.a.a.a.a.a("Trying to delete old file ");
        localStringBuilder2.append(localStringBuilder1.getPath());
        localStringBuilder2.append(" of size ");
        localStringBuilder2.append(localStringBuilder1.length());
        Log.i("MultiDex", localStringBuilder2.toString());
        if (!localStringBuilder1.delete())
        {
          localStringBuilder2 = e.a.a.a.a.a("Failed to delete old file ");
          localStringBuilder2.append(localStringBuilder1.getPath());
          Log.w("MultiDex", localStringBuilder2.toString());
        }
        else
        {
          localStringBuilder2 = e.a.a.a.a.a("Deleted old file ");
          localStringBuilder2.append(localStringBuilder1.getPath());
          Log.i("MultiDex", localStringBuilder2.toString());
        }
      }
      if (!paramContext.delete())
      {
        localStringBuilder1 = e.a.a.a.a.a("Failed to delete secondary dex dir ");
        localStringBuilder1.append(paramContext.getPath());
        Log.w("MultiDex", localStringBuilder1.toString());
      }
      else
      {
        localStringBuilder1 = e.a.a.a.a.a("Deleted old secondary dex dir ");
        localStringBuilder1.append(paramContext.getPath());
        Log.i("MultiDex", localStringBuilder1.toString());
      }
    }
  }
  
  /* Error */
  public static void a(Context paramContext, File paramFile1, File paramFile2, String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: getstatic 20	d/r/a:a	Ljava/util/Set;
    //   3: astore 6
    //   5: aload 6
    //   7: monitorenter
    //   8: getstatic 20	d/r/a:a	Ljava/util/Set;
    //   11: aload_1
    //   12: invokeinterface 214 2 0
    //   17: ifeq +7 -> 24
    //   20: aload 6
    //   22: monitorexit
    //   23: return
    //   24: getstatic 20	d/r/a:a	Ljava/util/Set;
    //   27: aload_1
    //   28: invokeinterface 217 2 0
    //   33: pop
    //   34: new 69	java/lang/StringBuilder
    //   37: astore 7
    //   39: aload 7
    //   41: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   44: aload 7
    //   46: ldc -37
    //   48: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload 7
    //   54: getstatic 225	android/os/Build$VERSION:SDK_INT	I
    //   57: invokevirtual 228	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload 7
    //   63: ldc -26
    //   65: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload 7
    //   71: bipush 20
    //   73: invokevirtual 228	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload 7
    //   79: ldc -24
    //   81: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload 7
    //   87: ldc -22
    //   89: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload 7
    //   95: ldc -20
    //   97: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload 7
    //   103: ldc 22
    //   105: invokestatic 28	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   108: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload 7
    //   114: ldc -18
    //   116: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: ldc 75
    //   122: aload 7
    //   124: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 181	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   130: pop
    //   131: aload_0
    //   132: invokevirtual 242	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   135: astore 8
    //   137: aload 8
    //   139: ifnonnull +15 -> 154
    //   142: ldc 75
    //   144: ldc -12
    //   146: invokestatic 247	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   149: pop
    //   150: aload 6
    //   152: monitorexit
    //   153: return
    //   154: aload_0
    //   155: invokestatic 249	d/r/a:a	(Landroid/content/Context;)V
    //   158: goto +15 -> 173
    //   161: astore 7
    //   163: ldc 75
    //   165: ldc -5
    //   167: aload 7
    //   169: invokestatic 254	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   172: pop
    //   173: new 149	java/io/File
    //   176: astore 7
    //   178: aload 7
    //   180: aload_2
    //   181: ldc_w 256
    //   184: invokespecial 160	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   187: aload 7
    //   189: invokestatic 259	d/r/a:a	(Ljava/io/File;)V
    //   192: aload 7
    //   194: astore_2
    //   195: goto +23 -> 218
    //   198: astore_2
    //   199: new 149	java/io/File
    //   202: astore_2
    //   203: aload_2
    //   204: aload_0
    //   205: invokevirtual 155	android/content/Context:getFilesDir	()Ljava/io/File;
    //   208: ldc_w 256
    //   211: invokespecial 160	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   214: aload_2
    //   215: invokestatic 259	d/r/a:a	(Ljava/io/File;)V
    //   218: new 149	java/io/File
    //   221: astore 7
    //   223: aload 7
    //   225: aload_2
    //   226: aload_3
    //   227: invokespecial 160	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   230: aload 7
    //   232: invokestatic 259	d/r/a:a	(Ljava/io/File;)V
    //   235: new 261	d/r/d
    //   238: astore_2
    //   239: aload_2
    //   240: aload_1
    //   241: aload 7
    //   243: invokespecial 264	d/r/d:<init>	(Ljava/io/File;Ljava/io/File;)V
    //   246: aconst_null
    //   247: astore_1
    //   248: aload_2
    //   249: aload_0
    //   250: aload 4
    //   252: iconst_0
    //   253: invokevirtual 267	d/r/d:a	(Landroid/content/Context;Ljava/lang/String;Z)Ljava/util/List;
    //   256: astore_3
    //   257: aload 8
    //   259: aload 7
    //   261: aload_3
    //   262: invokestatic 270	d/r/a:a	(Ljava/lang/ClassLoader;Ljava/io/File;Ljava/util/List;)V
    //   265: goto +34 -> 299
    //   268: astore_3
    //   269: iload 5
    //   271: ifeq +48 -> 319
    //   274: ldc 75
    //   276: ldc_w 272
    //   279: aload_3
    //   280: invokestatic 254	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   283: pop
    //   284: aload 8
    //   286: aload 7
    //   288: aload_2
    //   289: aload_0
    //   290: aload 4
    //   292: iconst_1
    //   293: invokevirtual 267	d/r/d:a	(Landroid/content/Context;Ljava/lang/String;Z)Ljava/util/List;
    //   296: invokestatic 270	d/r/a:a	(Ljava/lang/ClassLoader;Ljava/io/File;Ljava/util/List;)V
    //   299: aload_2
    //   300: invokevirtual 275	d/r/d:close	()V
    //   303: aload_1
    //   304: astore_0
    //   305: goto +4 -> 309
    //   308: astore_0
    //   309: aload_0
    //   310: ifnonnull +7 -> 317
    //   313: aload 6
    //   315: monitorexit
    //   316: return
    //   317: aload_0
    //   318: athrow
    //   319: aload_3
    //   320: athrow
    //   321: astore_0
    //   322: aload_2
    //   323: invokevirtual 275	d/r/d:close	()V
    //   326: aload_0
    //   327: athrow
    //   328: astore_0
    //   329: ldc 75
    //   331: ldc_w 277
    //   334: aload_0
    //   335: invokestatic 254	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   338: pop
    //   339: aload 6
    //   341: monitorexit
    //   342: return
    //   343: astore_0
    //   344: aload 6
    //   346: monitorexit
    //   347: aload_0
    //   348: athrow
    //   349: astore_1
    //   350: goto -24 -> 326
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	353	0	paramContext	Context
    //   0	353	1	paramFile1	File
    //   0	353	2	paramFile2	File
    //   0	353	3	paramString1	String
    //   0	353	4	paramString2	String
    //   0	353	5	paramBoolean	boolean
    //   3	342	6	localSet	Set
    //   37	86	7	localStringBuilder	StringBuilder
    //   161	7	7	localThrowable	Throwable
    //   176	111	7	localFile	File
    //   135	150	8	localClassLoader	ClassLoader
    // Exception table:
    //   from	to	target	type
    //   154	158	161	finally
    //   187	192	198	java/io/IOException
    //   257	265	268	java/io/IOException
    //   299	303	308	java/io/IOException
    //   248	257	321	finally
    //   257	265	321	finally
    //   274	299	321	finally
    //   319	321	321	finally
    //   131	137	328	java/lang/RuntimeException
    //   8	23	343	finally
    //   24	131	343	finally
    //   131	137	343	finally
    //   142	153	343	finally
    //   163	173	343	finally
    //   173	187	343	finally
    //   187	192	343	finally
    //   199	218	343	finally
    //   218	246	343	finally
    //   299	303	343	finally
    //   313	316	343	finally
    //   317	319	343	finally
    //   322	326	343	finally
    //   326	328	343	finally
    //   329	342	343	finally
    //   344	347	343	finally
    //   322	326	349	java/io/IOException
  }
  
  public static void a(File paramFile)
  {
    paramFile.mkdir();
    if (!paramFile.isDirectory())
    {
      File localFile = paramFile.getParentFile();
      if (localFile == null)
      {
        localStringBuilder = e.a.a.a.a.a("Failed to create dir ");
        localStringBuilder.append(paramFile.getPath());
        localStringBuilder.append(". Parent file is null.");
        Log.e("MultiDex", localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = e.a.a.a.a.a("Failed to create dir ");
        localStringBuilder.append(paramFile.getPath());
        localStringBuilder.append(". parent file is a dir ");
        localStringBuilder.append(localFile.isDirectory());
        localStringBuilder.append(", a file ");
        localStringBuilder.append(localFile.isFile());
        localStringBuilder.append(", exists ");
        localStringBuilder.append(localFile.exists());
        localStringBuilder.append(", readable ");
        localStringBuilder.append(localFile.canRead());
        localStringBuilder.append(", writable ");
        localStringBuilder.append(localFile.canWrite());
        Log.e("MultiDex", localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = e.a.a.a.a.a("Failed to create directory ");
      localStringBuilder.append(paramFile.getPath());
      throw new IOException(localStringBuilder.toString());
    }
  }
  
  public static void a(ClassLoader paramClassLoader, File paramFile, List<? extends File> paramList)
  {
    if (!paramList.isEmpty())
    {
      Object localObject = a(paramClassLoader, "pathList").get(paramClassLoader);
      ArrayList localArrayList = new ArrayList();
      paramClassLoader = new ArrayList(paramList);
      a(localObject, "dexElements", (Object[])a(localObject, "makeDexElements", new Class[] { ArrayList.class, File.class, ArrayList.class }).invoke(localObject, new Object[] { paramClassLoader, paramFile, localArrayList }));
      if (localArrayList.size() > 0)
      {
        paramClassLoader = localArrayList.iterator();
        while (paramClassLoader.hasNext()) {
          Log.w("MultiDex", "Exception in makeDexElement", (IOException)paramClassLoader.next());
        }
        paramFile = a(localObject, "dexElementsSuppressedExceptions");
        paramList = (IOException[])paramFile.get(localObject);
        if (paramList == null)
        {
          paramClassLoader = (IOException[])localArrayList.toArray(new IOException[localArrayList.size()]);
        }
        else
        {
          paramClassLoader = new IOException[localArrayList.size() + paramList.length];
          localArrayList.toArray(paramClassLoader);
          System.arraycopy(paramList, 0, paramClassLoader, localArrayList.size(), paramList.length);
        }
        paramFile.set(localObject, paramClassLoader);
        paramClassLoader = new IOException("I/O exception during makeDexElement");
        paramClassLoader.initCause((Throwable)localArrayList.get(0));
        throw paramClassLoader;
      }
    }
  }
  
  public static void b(Context paramContext)
  {
    Log.i("MultiDex", "Installing application");
    if (b)
    {
      Log.i("MultiDex", "VM has multidex support, MultiDex support library is disabled.");
      return;
    }
    try
    {
      ApplicationInfo localApplicationInfo = paramContext.getApplicationInfo();
    }
    catch (Exception paramContext)
    {
      break label110;
    }
    catch (RuntimeException localRuntimeException)
    {
      Log.w("MultiDex", "Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", localRuntimeException);
      localStringBuilder = null;
    }
    if (localStringBuilder == null)
    {
      Log.i("MultiDex", "No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
      return;
    }
    File localFile1 = new java/io/File;
    localFile1.<init>(sourceDir);
    File localFile2 = new java/io/File;
    localFile2.<init>(dataDir);
    a(paramContext, localFile1, localFile2, "secondary-dexes", "", true);
    Log.i("MultiDex", "install done");
    return;
    label110:
    Log.e("MultiDex", "MultiDex installation failure", paramContext);
    StringBuilder localStringBuilder = e.a.a.a.a.a("MultiDex installation failed (");
    localStringBuilder.append(paramContext.getMessage());
    localStringBuilder.append(").");
    throw new RuntimeException(localStringBuilder.toString());
  }
}

/* Location:
 * Qualified Name:     base.d.r.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */