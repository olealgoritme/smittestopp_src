package d.i.c;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.util.Log;
import d.i.b.b.c;
import e.a.a.a.a;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public class f
  extends d
{
  public final Class<?> g;
  public final Constructor<?> h;
  public final Method i;
  public final Method j;
  public final Method k;
  public final Method l;
  public final Method m;
  
  public f()
  {
    Object localObject1 = null;
    try
    {
      Class localClass = Class.forName("android.graphics.FontFamily");
      localObject3 = localClass.getConstructor(new Class[0]);
      localObject4 = a(localClass);
      localObject5 = b(localClass);
      localObject6 = localClass.getMethod("freeze", new Class[0]);
      localObject7 = localClass.getMethod("abortCreation", new Class[0]);
      localObject8 = c(localClass);
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}catch (ClassNotFoundException localClassNotFoundException) {}
    Object localObject3 = a.a("Unable to collect necessary methods for class ");
    ((StringBuilder)localObject3).append(localClassNotFoundException.getClass().getName());
    Log.e("TypefaceCompatApi26Impl", ((StringBuilder)localObject3).toString(), localClassNotFoundException);
    Object localObject9 = null;
    Object localObject2 = localObject9;
    localObject3 = localObject2;
    Object localObject8 = localObject3;
    Object localObject5 = localObject8;
    Object localObject6 = localObject5;
    Object localObject4 = localObject8;
    Object localObject7 = localObject2;
    localObject8 = localObject9;
    localObject2 = localObject1;
    g = ((Class)localObject2);
    h = ((Constructor)localObject3);
    i = ((Method)localObject4);
    j = ((Method)localObject5);
    k = ((Method)localObject6);
    l = ((Method)localObject7);
    m = ((Method)localObject8);
  }
  
  private Object c()
  {
    try
    {
      Object localObject = h.newInstance(new Object[0]);
      return localObject;
    }
    catch (IllegalAccessException|InstantiationException|InvocationTargetException localIllegalAccessException) {}
    return null;
  }
  
  public Typeface a(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2)
  {
    if (!b()) {
      return super.a(paramContext, paramResources, paramInt1, paramString, paramInt2);
    }
    paramResources = c();
    if (paramResources == null) {
      return null;
    }
    if (!a(paramContext, paramResources, paramString, 0, -1, -1, null))
    {
      a(paramResources);
      return null;
    }
    if (!c(paramResources)) {
      return null;
    }
    return b(paramResources);
  }
  
  /* Error */
  public Typeface a(Context paramContext, android.os.CancellationSignal paramCancellationSignal, d.i.f.b.f[] paramArrayOff, int paramInt)
  {
    // Byte code:
    //   0: aload_3
    //   1: arraylength
    //   2: iconst_1
    //   3: if_icmpge +5 -> 8
    //   6: aconst_null
    //   7: areturn
    //   8: aload_0
    //   9: invokevirtual 119	d/i/c/f:b	()Z
    //   12: ifne +101 -> 113
    //   15: aload_0
    //   16: aload_3
    //   17: iload 4
    //   19: invokevirtual 143	d/i/c/i:a	([Ld/i/f/b$f;I)Ld/i/f/b$f;
    //   22: astore_3
    //   23: aload_1
    //   24: invokevirtual 149	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   27: astore_1
    //   28: aload_1
    //   29: aload_3
    //   30: getfield 154	d/i/f/b$f:a	Landroid/net/Uri;
    //   33: ldc -100
    //   35: aload_2
    //   36: invokevirtual 162	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   39: astore_1
    //   40: aload_1
    //   41: ifnonnull +13 -> 54
    //   44: aload_1
    //   45: ifnull +7 -> 52
    //   48: aload_1
    //   49: invokevirtual 167	android/os/ParcelFileDescriptor:close	()V
    //   52: aconst_null
    //   53: areturn
    //   54: new 169	android/graphics/Typeface$Builder
    //   57: astore_2
    //   58: aload_2
    //   59: aload_1
    //   60: invokevirtual 173	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   63: invokespecial 176	android/graphics/Typeface$Builder:<init>	(Ljava/io/FileDescriptor;)V
    //   66: aload_2
    //   67: aload_3
    //   68: getfield 179	d/i/f/b$f:c	I
    //   71: invokevirtual 183	android/graphics/Typeface$Builder:setWeight	(I)Landroid/graphics/Typeface$Builder;
    //   74: aload_3
    //   75: getfield 187	d/i/f/b$f:d	Z
    //   78: invokevirtual 191	android/graphics/Typeface$Builder:setItalic	(Z)Landroid/graphics/Typeface$Builder;
    //   81: invokevirtual 195	android/graphics/Typeface$Builder:build	()Landroid/graphics/Typeface;
    //   84: astore_2
    //   85: aload_1
    //   86: invokevirtual 167	android/os/ParcelFileDescriptor:close	()V
    //   89: aload_2
    //   90: areturn
    //   91: astore_3
    //   92: aload_3
    //   93: athrow
    //   94: astore_2
    //   95: aload_1
    //   96: invokevirtual 167	android/os/ParcelFileDescriptor:close	()V
    //   99: goto +9 -> 108
    //   102: astore_1
    //   103: aload_3
    //   104: aload_1
    //   105: invokevirtual 201	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   108: aload_2
    //   109: athrow
    //   110: astore_1
    //   111: aconst_null
    //   112: areturn
    //   113: aload_1
    //   114: aload_3
    //   115: aload_2
    //   116: invokestatic 206	d/i/f/b:a	(Landroid/content/Context;[Ld/i/f/b$f;Landroid/os/CancellationSignal;)Ljava/util/Map;
    //   119: astore_2
    //   120: aload_0
    //   121: invokespecial 125	d/i/c/f:c	()Ljava/lang/Object;
    //   124: astore_1
    //   125: aload_1
    //   126: ifnonnull +5 -> 131
    //   129: aconst_null
    //   130: areturn
    //   131: aload_3
    //   132: arraylength
    //   133: istore 5
    //   135: iconst_0
    //   136: istore 6
    //   138: iconst_0
    //   139: istore 7
    //   141: iload 6
    //   143: iload 5
    //   145: if_icmpge +136 -> 281
    //   148: aload_3
    //   149: iload 6
    //   151: aaload
    //   152: astore 8
    //   154: aload_2
    //   155: aload 8
    //   157: getfield 154	d/i/f/b$f:a	Landroid/net/Uri;
    //   160: invokeinterface 212 2 0
    //   165: checkcast 214	java/nio/ByteBuffer
    //   168: astore 9
    //   170: aload 9
    //   172: ifnonnull +6 -> 178
    //   175: goto +100 -> 275
    //   178: aload 8
    //   180: getfield 216	d/i/f/b$f:b	I
    //   183: istore 10
    //   185: aload 8
    //   187: getfield 179	d/i/f/b$f:c	I
    //   190: istore 11
    //   192: aload 8
    //   194: getfield 187	d/i/f/b$f:d	Z
    //   197: istore 7
    //   199: aload_0
    //   200: getfield 95	d/i/c/f:j	Ljava/lang/reflect/Method;
    //   203: aload_1
    //   204: iconst_5
    //   205: anewarray 63	java/lang/Object
    //   208: dup
    //   209: iconst_0
    //   210: aload 9
    //   212: aastore
    //   213: dup
    //   214: iconst_1
    //   215: iload 10
    //   217: invokestatic 222	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   220: aastore
    //   221: dup
    //   222: iconst_2
    //   223: aconst_null
    //   224: aastore
    //   225: dup
    //   226: iconst_3
    //   227: iload 11
    //   229: invokestatic 222	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   232: aastore
    //   233: dup
    //   234: iconst_4
    //   235: iload 7
    //   237: invokestatic 222	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   240: aastore
    //   241: invokevirtual 228	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   244: checkcast 230	java/lang/Boolean
    //   247: invokevirtual 233	java/lang/Boolean:booleanValue	()Z
    //   250: istore 12
    //   252: goto +8 -> 260
    //   255: astore 8
    //   257: iconst_0
    //   258: istore 12
    //   260: iload 12
    //   262: ifne +10 -> 272
    //   265: aload_0
    //   266: aload_1
    //   267: invokevirtual 131	d/i/c/f:a	(Ljava/lang/Object;)V
    //   270: aconst_null
    //   271: areturn
    //   272: iconst_1
    //   273: istore 7
    //   275: iinc 6 1
    //   278: goto -137 -> 141
    //   281: iload 7
    //   283: ifne +10 -> 293
    //   286: aload_0
    //   287: aload_1
    //   288: invokevirtual 131	d/i/c/f:a	(Ljava/lang/Object;)V
    //   291: aconst_null
    //   292: areturn
    //   293: aload_0
    //   294: aload_1
    //   295: invokevirtual 134	d/i/c/f:c	(Ljava/lang/Object;)Z
    //   298: ifne +5 -> 303
    //   301: aconst_null
    //   302: areturn
    //   303: aload_0
    //   304: aload_1
    //   305: invokevirtual 137	d/i/c/f:b	(Ljava/lang/Object;)Landroid/graphics/Typeface;
    //   308: astore_1
    //   309: aload_1
    //   310: ifnonnull +5 -> 315
    //   313: aconst_null
    //   314: areturn
    //   315: aload_1
    //   316: iload 4
    //   318: invokestatic 239	android/graphics/Typeface:create	(Landroid/graphics/Typeface;I)Landroid/graphics/Typeface;
    //   321: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	322	0	this	f
    //   0	322	1	paramContext	Context
    //   0	322	2	paramCancellationSignal	android.os.CancellationSignal
    //   0	322	3	paramArrayOff	d.i.f.b.f[]
    //   0	322	4	paramInt	int
    //   133	13	5	n	int
    //   136	140	6	i1	int
    //   139	97	7	i2	int
    //   273	9	7	i3	int
    //   152	41	8	localf	d.i.f.b.f
    //   255	1	8	localIllegalAccessException	IllegalAccessException
    //   168	43	9	localByteBuffer	ByteBuffer
    //   183	33	10	i4	int
    //   190	38	11	i5	int
    //   250	11	12	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   54	85	91	finally
    //   92	94	94	finally
    //   95	99	102	finally
    //   28	40	110	java/io/IOException
    //   48	52	110	java/io/IOException
    //   85	89	110	java/io/IOException
    //   103	108	110	java/io/IOException
    //   108	110	110	java/io/IOException
    //   199	252	255	java/lang/IllegalAccessException
    //   199	252	255	java/lang/reflect/InvocationTargetException
  }
  
  public Typeface a(Context paramContext, c paramc, Resources paramResources, int paramInt)
  {
    if (!b()) {
      return super.a(paramContext, paramc, paramResources, paramInt);
    }
    paramResources = c();
    if (paramResources == null) {
      return null;
    }
    for (Object localObject : a) {
      if (!a(paramContext, paramResources, a, e, b, c, FontVariationAxis.fromFontVariationSettings(d)))
      {
        a(paramResources);
        return null;
      }
    }
    if (!c(paramResources)) {
      return null;
    }
    return b(paramResources);
  }
  
  public Method a(Class<?> paramClass)
  {
    Class localClass1 = Integer.TYPE;
    Class localClass2 = Boolean.TYPE;
    Class localClass3 = Integer.TYPE;
    return paramClass.getMethod("addFontFromAssetManager", new Class[] { AssetManager.class, String.class, localClass1, localClass2, localClass3, localClass3, localClass3, FontVariationAxis[].class });
  }
  
  public final void a(Object paramObject)
  {
    try
    {
      l.invoke(paramObject, new Object[0]);
      return;
    }
    catch (IllegalAccessException|InvocationTargetException paramObject)
    {
      for (;;) {}
    }
  }
  
  public final boolean a(Context paramContext, Object paramObject, String paramString, int paramInt1, int paramInt2, int paramInt3, FontVariationAxis[] paramArrayOfFontVariationAxis)
  {
    try
    {
      boolean bool = ((Boolean)i.invoke(paramObject, new Object[] { paramContext.getAssets(), paramString, Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramArrayOfFontVariationAxis })).booleanValue();
      return bool;
    }
    catch (IllegalAccessException|InvocationTargetException paramContext) {}
    return false;
  }
  
  public Typeface b(Object paramObject)
  {
    try
    {
      Object localObject = Array.newInstance(g, 1);
      Array.set(localObject, 0, paramObject);
      paramObject = (Typeface)m.invoke(null, new Object[] { localObject, Integer.valueOf(-1), Integer.valueOf(-1) });
      return (Typeface)paramObject;
    }
    catch (IllegalAccessException|InvocationTargetException paramObject) {}
    return null;
  }
  
  public Method b(Class<?> paramClass)
  {
    Class localClass = Integer.TYPE;
    return paramClass.getMethod("addFontFromBuffer", new Class[] { ByteBuffer.class, localClass, FontVariationAxis[].class, localClass, localClass });
  }
  
  public final boolean b()
  {
    if (i == null) {
      Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
    }
    boolean bool;
    if (i != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Method c(Class<?> paramClass)
  {
    paramClass = Array.newInstance(paramClass, 1).getClass();
    Class localClass = Integer.TYPE;
    paramClass = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[] { paramClass, localClass, localClass });
    paramClass.setAccessible(true);
    return paramClass;
  }
  
  public final boolean c(Object paramObject)
  {
    try
    {
      boolean bool = ((Boolean)k.invoke(paramObject, new Object[0])).booleanValue();
      return bool;
    }
    catch (IllegalAccessException|InvocationTargetException paramObject) {}
    return false;
  }
}

/* Location:
 * Qualified Name:     d.i.c.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */