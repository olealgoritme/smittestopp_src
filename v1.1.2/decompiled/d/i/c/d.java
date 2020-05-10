package d.i.c;

import android.graphics.Typeface;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class d
  extends i
{
  public static Class<?> b;
  public static Constructor<?> c;
  public static Method d;
  public static Method e;
  public static boolean f = false;
  
  public static void a()
  {
    if (f) {
      return;
    }
    f = true;
    Object localObject1 = null;
    try
    {
      Class localClass = Class.forName("android.graphics.FontFamily");
      Constructor localConstructor = localClass.getConstructor(new Class[0]);
      localObject3 = localClass.getMethod("addFontWeightStyle", new Class[] { String.class, Integer.TYPE, Boolean.TYPE });
      localMethod = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[] { Array.newInstance(localClass, 1).getClass() });
      localObject1 = localConstructor;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}catch (ClassNotFoundException localClassNotFoundException) {}
    Log.e("TypefaceCompatApi21Impl", localClassNotFoundException.getClass().getName(), localClassNotFoundException);
    Method localMethod = null;
    Object localObject2 = localMethod;
    Object localObject3 = localObject2;
    c = (Constructor)localObject1;
    b = (Class)localObject2;
    d = (Method)localObject3;
    e = localMethod;
  }
  
  public static boolean a(Object paramObject, String paramString, int paramInt, boolean paramBoolean)
  {
    
    try
    {
      paramBoolean = ((Boolean)d.invoke(paramObject, new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) })).booleanValue();
      return paramBoolean;
    }
    catch (InvocationTargetException paramObject) {}catch (IllegalAccessException paramObject) {}
    throw new RuntimeException((Throwable)paramObject);
  }
  
  /* Error */
  public Typeface a(android.content.Context paramContext, android.os.CancellationSignal paramCancellationSignal, d.i.f.b.f[] paramArrayOff, int paramInt)
  {
    // Byte code:
    //   0: aload_3
    //   1: arraylength
    //   2: iconst_1
    //   3: if_icmpge +5 -> 8
    //   6: aconst_null
    //   7: areturn
    //   8: aload_0
    //   9: aload_3
    //   10: iload 4
    //   12: invokevirtual 128	d/i/c/i:a	([Ld/i/f/b$f;I)Ld/i/f/b$f;
    //   15: astore_3
    //   16: aload_1
    //   17: invokevirtual 134	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   20: astore 5
    //   22: aload 5
    //   24: aload_3
    //   25: getfield 139	d/i/f/b$f:a	Landroid/net/Uri;
    //   28: ldc -115
    //   30: aload_2
    //   31: invokevirtual 147	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   34: astore_3
    //   35: aload_3
    //   36: ifnonnull +13 -> 49
    //   39: aload_3
    //   40: ifnull +7 -> 47
    //   43: aload_3
    //   44: invokevirtual 152	android/os/ParcelFileDescriptor:close	()V
    //   47: aconst_null
    //   48: areturn
    //   49: new 154	java/lang/StringBuilder
    //   52: astore_2
    //   53: aload_2
    //   54: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   57: aload_2
    //   58: ldc -99
    //   60: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload_2
    //   65: aload_3
    //   66: invokevirtual 165	android/os/ParcelFileDescriptor:getFd	()I
    //   69: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload_2
    //   74: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 177	android/system/Os:readlink	(Ljava/lang/String;)Ljava/lang/String;
    //   80: astore 5
    //   82: aload 5
    //   84: invokestatic 181	android/system/Os:stat	(Ljava/lang/String;)Landroid/system/StructStat;
    //   87: getfield 187	android/system/StructStat:st_mode	I
    //   90: invokestatic 193	android/system/OsConstants:S_ISREG	(I)Z
    //   93: ifeq +16 -> 109
    //   96: new 195	java/io/File
    //   99: astore_2
    //   100: aload_2
    //   101: aload 5
    //   103: invokespecial 198	java/io/File:<init>	(Ljava/lang/String;)V
    //   106: goto +5 -> 111
    //   109: aconst_null
    //   110: astore_2
    //   111: aload_2
    //   112: ifnull +24 -> 136
    //   115: aload_2
    //   116: invokevirtual 201	java/io/File:canRead	()Z
    //   119: ifne +6 -> 125
    //   122: goto +14 -> 136
    //   125: aload_2
    //   126: invokestatic 205	android/graphics/Typeface:createFromFile	(Ljava/io/File;)Landroid/graphics/Typeface;
    //   129: astore_1
    //   130: aload_3
    //   131: invokevirtual 152	android/os/ParcelFileDescriptor:close	()V
    //   134: aload_1
    //   135: areturn
    //   136: new 207	java/io/FileInputStream
    //   139: astore_2
    //   140: aload_2
    //   141: aload_3
    //   142: invokevirtual 211	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   145: invokespecial 214	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   148: aload_0
    //   149: aload_1
    //   150: aload_2
    //   151: invokespecial 217	d/i/c/i:a	(Landroid/content/Context;Ljava/io/InputStream;)Landroid/graphics/Typeface;
    //   154: astore_1
    //   155: aload_2
    //   156: invokevirtual 218	java/io/FileInputStream:close	()V
    //   159: aload_3
    //   160: invokevirtual 152	android/os/ParcelFileDescriptor:close	()V
    //   163: aload_1
    //   164: areturn
    //   165: astore 5
    //   167: aload 5
    //   169: athrow
    //   170: astore_1
    //   171: aload_2
    //   172: invokevirtual 218	java/io/FileInputStream:close	()V
    //   175: goto +10 -> 185
    //   178: astore_2
    //   179: aload 5
    //   181: aload_2
    //   182: invokevirtual 223	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   185: aload_1
    //   186: athrow
    //   187: astore_2
    //   188: aload_2
    //   189: athrow
    //   190: astore_1
    //   191: aload_3
    //   192: invokevirtual 152	android/os/ParcelFileDescriptor:close	()V
    //   195: goto +9 -> 204
    //   198: astore_3
    //   199: aload_2
    //   200: aload_3
    //   201: invokevirtual 223	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   204: aload_1
    //   205: athrow
    //   206: astore_1
    //   207: aconst_null
    //   208: areturn
    //   209: astore_2
    //   210: goto -101 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	d
    //   0	213	1	paramContext	android.content.Context
    //   0	213	2	paramCancellationSignal	android.os.CancellationSignal
    //   0	213	3	paramArrayOff	d.i.f.b.f[]
    //   0	213	4	paramInt	int
    //   20	82	5	localObject1	Object
    //   165	15	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   148	155	165	finally
    //   167	170	170	finally
    //   171	175	178	finally
    //   49	106	187	finally
    //   115	122	187	finally
    //   125	130	187	finally
    //   136	148	187	finally
    //   155	159	187	finally
    //   179	185	187	finally
    //   185	187	187	finally
    //   188	190	190	finally
    //   191	195	198	finally
    //   22	35	206	java/io/IOException
    //   43	47	206	java/io/IOException
    //   130	134	206	java/io/IOException
    //   159	163	206	java/io/IOException
    //   199	204	206	java/io/IOException
    //   204	206	206	java/io/IOException
    //   49	106	209	android/system/ErrnoException
  }
  
  /* Error */
  public Typeface a(android.content.Context paramContext, d.i.b.b.c paramc, android.content.res.Resources paramResources, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 98	d/i/c/d:a	()V
    //   3: getstatic 85	d/i/c/d:c	Ljava/lang/reflect/Constructor;
    //   6: iconst_0
    //   7: anewarray 68	java/lang/Object
    //   10: invokevirtual 231	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   13: astore 5
    //   15: aload_2
    //   16: getfield 236	d/i/b/b/c:a	[Ld/i/b/b/d;
    //   19: astore 6
    //   21: aload 6
    //   23: arraylength
    //   24: istore 7
    //   26: iconst_0
    //   27: istore 4
    //   29: iload 4
    //   31: iload 7
    //   33: if_icmpge +105 -> 138
    //   36: aload 6
    //   38: iload 4
    //   40: aaload
    //   41: astore 8
    //   43: aload_1
    //   44: invokestatic 241	d/b/a/s:a	(Landroid/content/Context;)Ljava/io/File;
    //   47: astore_2
    //   48: aload_2
    //   49: ifnonnull +5 -> 54
    //   52: aconst_null
    //   53: areturn
    //   54: aload_2
    //   55: aload_3
    //   56: aload 8
    //   58: getfield 245	d/i/b/b/d:f	I
    //   61: invokestatic 248	d/b/a/s:a	(Ljava/io/File;Landroid/content/res/Resources;I)Z
    //   64: istore 9
    //   66: iload 9
    //   68: ifne +10 -> 78
    //   71: aload_2
    //   72: invokevirtual 251	java/io/File:delete	()Z
    //   75: pop
    //   76: aconst_null
    //   77: areturn
    //   78: aload 5
    //   80: aload_2
    //   81: invokevirtual 254	java/io/File:getPath	()Ljava/lang/String;
    //   84: aload 8
    //   86: getfield 256	d/i/b/b/d:b	I
    //   89: aload 8
    //   91: getfield 258	d/i/b/b/d:c	Z
    //   94: invokestatic 260	d/i/c/d:a	(Ljava/lang/Object;Ljava/lang/String;IZ)Z
    //   97: istore 9
    //   99: iload 9
    //   101: ifne +10 -> 111
    //   104: aload_2
    //   105: invokevirtual 251	java/io/File:delete	()Z
    //   108: pop
    //   109: aconst_null
    //   110: areturn
    //   111: aload_2
    //   112: invokevirtual 251	java/io/File:delete	()Z
    //   115: pop
    //   116: iinc 4 1
    //   119: goto -90 -> 29
    //   122: astore_1
    //   123: aload_2
    //   124: invokevirtual 251	java/io/File:delete	()Z
    //   127: pop
    //   128: aload_1
    //   129: athrow
    //   130: astore_1
    //   131: aload_2
    //   132: invokevirtual 251	java/io/File:delete	()Z
    //   135: pop
    //   136: aconst_null
    //   137: areturn
    //   138: invokestatic 98	d/i/c/d:a	()V
    //   141: getstatic 87	d/i/c/d:b	Ljava/lang/Class;
    //   144: iconst_1
    //   145: invokestatic 66	java/lang/reflect/Array:newInstance	(Ljava/lang/Class;I)Ljava/lang/Object;
    //   148: astore_1
    //   149: aload_1
    //   150: iconst_0
    //   151: aload 5
    //   153: invokestatic 264	java/lang/reflect/Array:set	(Ljava/lang/Object;ILjava/lang/Object;)V
    //   156: getstatic 91	d/i/c/d:e	Ljava/lang/reflect/Method;
    //   159: aconst_null
    //   160: iconst_1
    //   161: anewarray 68	java/lang/Object
    //   164: dup
    //   165: iconst_0
    //   166: aload_1
    //   167: aastore
    //   168: invokevirtual 111	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   171: checkcast 58	android/graphics/Typeface
    //   174: astore_1
    //   175: aload_1
    //   176: areturn
    //   177: astore_1
    //   178: goto +4 -> 182
    //   181: astore_1
    //   182: new 117	java/lang/RuntimeException
    //   185: dup
    //   186: aload_1
    //   187: invokespecial 120	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   190: athrow
    //   191: astore_1
    //   192: goto +8 -> 200
    //   195: astore_1
    //   196: goto +4 -> 200
    //   199: astore_1
    //   200: new 117	java/lang/RuntimeException
    //   203: dup
    //   204: aload_1
    //   205: invokespecial 120	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   208: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	this	d
    //   0	209	1	paramContext	android.content.Context
    //   0	209	2	paramc	d.i.b.b.c
    //   0	209	3	paramResources	android.content.res.Resources
    //   0	209	4	paramInt	int
    //   13	139	5	localObject	Object
    //   19	18	6	arrayOfd	d.i.b.b.d[]
    //   24	10	7	i	int
    //   41	49	8	locald	d.i.b.b.d
    //   64	36	9	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   54	66	122	finally
    //   78	99	122	finally
    //   54	66	130	java/lang/RuntimeException
    //   78	99	130	java/lang/RuntimeException
    //   141	175	177	java/lang/reflect/InvocationTargetException
    //   141	175	181	java/lang/IllegalAccessException
    //   3	15	191	java/lang/reflect/InvocationTargetException
    //   3	15	195	java/lang/InstantiationException
    //   3	15	199	java/lang/IllegalAccessException
  }
}

/* Location:
 * Qualified Name:     d.i.c.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */