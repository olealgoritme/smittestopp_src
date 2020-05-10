package d.i.c;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import d.b.a.r;
import d.f.h;
import d.i.f.b.f;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

public class e
  extends i
{
  public static final Class<?> b;
  public static final Constructor<?> c;
  public static final Method d;
  public static final Method e;
  
  static
  {
    Object localObject1 = null;
    try
    {
      localClass1 = Class.forName("android.graphics.FontFamily");
      Constructor localConstructor = localClass1.getConstructor(new Class[0]);
      localObject2 = localClass1.getMethod("addFontWeightStyle", new Class[] { ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE });
      Method localMethod = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[] { Array.newInstance(localClass1, 1).getClass() });
      localObject1 = localConstructor;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}catch (ClassNotFoundException localClassNotFoundException) {}
    Log.e("TypefaceCompatApi24Impl", localClassNotFoundException.getClass().getName(), localClassNotFoundException);
    Class localClass1 = null;
    Class localClass2 = localClass1;
    Object localObject2 = localClass2;
    c = (Constructor)localObject1;
    b = localClass1;
    d = (Method)localObject2;
    e = localClass2;
  }
  
  public static Typeface a(Object paramObject)
  {
    try
    {
      Object localObject = Array.newInstance(b, 1);
      Array.set(localObject, 0, paramObject);
      paramObject = (Typeface)e.invoke(null, new Object[] { localObject });
      return (Typeface)paramObject;
    }
    catch (IllegalAccessException|InvocationTargetException paramObject) {}
    return null;
  }
  
  public static boolean a(Object paramObject, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    try
    {
      paramBoolean = ((Boolean)d.invoke(paramObject, new Object[] { paramByteBuffer, Integer.valueOf(paramInt1), null, Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) })).booleanValue();
      return paramBoolean;
    }
    catch (IllegalAccessException|InvocationTargetException paramObject) {}
    return false;
  }
  
  public Typeface a(Context paramContext, CancellationSignal paramCancellationSignal, b.f[] paramArrayOff, int paramInt)
  {
    int i = 0;
    Object localObject2;
    try
    {
      Object localObject1 = c.newInstance(new Object[0]);
    }
    catch (IllegalAccessException|InstantiationException|InvocationTargetException localIllegalAccessException)
    {
      localObject2 = null;
    }
    if (localObject2 == null) {
      return null;
    }
    h localh = new h();
    int j = paramArrayOff.length;
    while (i < j)
    {
      b.f localf = paramArrayOff[i];
      Uri localUri = a;
      ByteBuffer localByteBuffer1 = (ByteBuffer)localh.get(localUri);
      ByteBuffer localByteBuffer2 = localByteBuffer1;
      if (localByteBuffer1 == null)
      {
        localByteBuffer2 = r.a(paramContext, paramCancellationSignal, localUri);
        localh.put(localUri, localByteBuffer2);
      }
      if (localByteBuffer2 == null) {
        return null;
      }
      if (!a(localObject2, localByteBuffer2, b, c, d)) {
        return null;
      }
      i++;
    }
    paramContext = a(localObject2);
    if (paramContext == null) {
      return null;
    }
    return Typeface.create(paramContext, paramInt);
  }
  
  /* Error */
  public Typeface a(Context paramContext, d.i.b.b.c paramc, android.content.res.Resources paramResources, int paramInt)
  {
    // Byte code:
    //   0: getstatic 78	d/i/c/e:c	Ljava/lang/reflect/Constructor;
    //   3: iconst_0
    //   4: anewarray 61	java/lang/Object
    //   7: invokevirtual 124	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   10: astore 5
    //   12: goto +8 -> 20
    //   15: astore 5
    //   17: aconst_null
    //   18: astore 5
    //   20: aload 5
    //   22: ifnonnull +5 -> 27
    //   25: aconst_null
    //   26: areturn
    //   27: aload_2
    //   28: getfield 169	d/i/b/b/c:a	[Ld/i/b/b/d;
    //   31: astore 6
    //   33: aload 6
    //   35: arraylength
    //   36: istore 7
    //   38: iconst_0
    //   39: istore 4
    //   41: iload 4
    //   43: iload 7
    //   45: if_icmpge +180 -> 225
    //   48: aload 6
    //   50: iload 4
    //   52: aaload
    //   53: astore 8
    //   55: aload 8
    //   57: getfield 174	d/i/b/b/d:f	I
    //   60: istore 9
    //   62: aload_1
    //   63: invokestatic 177	d/b/a/r:a	(Landroid/content/Context;)Ljava/io/File;
    //   66: astore 10
    //   68: aload 10
    //   70: ifnonnull +6 -> 76
    //   73: goto +24 -> 97
    //   76: aload 10
    //   78: aload_3
    //   79: iload 9
    //   81: invokestatic 180	d/b/a/r:a	(Ljava/io/File;Landroid/content/res/Resources;I)Z
    //   84: istore 11
    //   86: iload 11
    //   88: ifne +14 -> 102
    //   91: aload 10
    //   93: invokevirtual 185	java/io/File:delete	()Z
    //   96: pop
    //   97: aconst_null
    //   98: astore_2
    //   99: goto +79 -> 178
    //   102: new 187	java/io/FileInputStream
    //   105: astore 12
    //   107: aload 12
    //   109: aload 10
    //   111: invokespecial 190	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   114: aload 12
    //   116: invokevirtual 194	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   119: astore_2
    //   120: aload_2
    //   121: invokevirtual 200	java/nio/channels/FileChannel:size	()J
    //   124: lstore 13
    //   126: aload_2
    //   127: getstatic 206	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   130: lconst_0
    //   131: lload 13
    //   133: invokevirtual 210	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   136: astore_2
    //   137: aload 12
    //   139: invokevirtual 213	java/io/FileInputStream:close	()V
    //   142: goto +30 -> 172
    //   145: astore_2
    //   146: aload_2
    //   147: athrow
    //   148: astore 15
    //   150: aload 12
    //   152: invokevirtual 213	java/io/FileInputStream:close	()V
    //   155: goto +11 -> 166
    //   158: astore 12
    //   160: aload_2
    //   161: aload 12
    //   163: invokevirtual 219	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   166: aload 15
    //   168: athrow
    //   169: astore_2
    //   170: aconst_null
    //   171: astore_2
    //   172: aload 10
    //   174: invokevirtual 185	java/io/File:delete	()Z
    //   177: pop
    //   178: aload_2
    //   179: ifnonnull +5 -> 184
    //   182: aconst_null
    //   183: areturn
    //   184: aload 5
    //   186: aload_2
    //   187: aload 8
    //   189: getfield 221	d/i/b/b/d:e	I
    //   192: aload 8
    //   194: getfield 222	d/i/b/b/d:b	I
    //   197: aload 8
    //   199: getfield 224	d/i/b/b/d:c	Z
    //   202: invokestatic 155	d/i/c/e:a	(Ljava/lang/Object;Ljava/nio/ByteBuffer;IIZ)Z
    //   205: ifne +5 -> 210
    //   208: aconst_null
    //   209: areturn
    //   210: iinc 4 1
    //   213: goto -172 -> 41
    //   216: astore_1
    //   217: aload 10
    //   219: invokevirtual 185	java/io/File:delete	()Z
    //   222: pop
    //   223: aload_1
    //   224: athrow
    //   225: aload 5
    //   227: invokestatic 157	d/i/c/e:a	(Ljava/lang/Object;)Landroid/graphics/Typeface;
    //   230: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	this	e
    //   0	231	1	paramContext	Context
    //   0	231	2	paramc	d.i.b.b.c
    //   0	231	3	paramResources	android.content.res.Resources
    //   0	231	4	paramInt	int
    //   10	1	5	localObject1	Object
    //   15	1	5	localIllegalAccessException	IllegalAccessException
    //   18	208	5	localObject2	Object
    //   31	18	6	arrayOfd	d.i.b.b.d[]
    //   36	10	7	i	int
    //   53	145	8	locald	d.i.b.b.d
    //   60	20	9	j	int
    //   66	152	10	localFile	java.io.File
    //   84	3	11	bool	boolean
    //   105	46	12	localFileInputStream	java.io.FileInputStream
    //   158	4	12	localThrowable	Throwable
    //   124	8	13	l	long
    //   148	19	15	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   0	12	15	java/lang/IllegalAccessException
    //   0	12	15	java/lang/InstantiationException
    //   0	12	15	java/lang/reflect/InvocationTargetException
    //   114	137	145	finally
    //   146	148	148	finally
    //   150	155	158	finally
    //   102	114	169	java/io/IOException
    //   137	142	169	java/io/IOException
    //   160	166	169	java/io/IOException
    //   166	169	169	java/io/IOException
    //   76	86	216	finally
    //   102	114	216	finally
    //   137	142	216	finally
    //   160	166	216	finally
    //   166	169	216	finally
  }
}

/* Location:
 * Qualified Name:     base.d.i.c.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */