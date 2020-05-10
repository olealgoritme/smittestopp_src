package d.i.a;

import android.app.Activity;
import android.app.Application;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class b
{
  public static final Class<?> a;
  public static final Field b;
  public static final Field c;
  public static final Method d;
  public static final Method e;
  public static final Method f;
  public static final Handler g = new Handler(Looper.getMainLooper());
  
  /* Error */
  static
  {
    // Byte code:
    //   0: new 26	android/os/Handler
    //   3: dup
    //   4: invokestatic 32	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   7: invokespecial 36	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   10: putstatic 38	d/i/a/b:g	Landroid/os/Handler;
    //   13: aconst_null
    //   14: astore_0
    //   15: ldc 40
    //   17: invokestatic 46	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   20: astore_1
    //   21: goto +6 -> 27
    //   24: astore_1
    //   25: aconst_null
    //   26: astore_1
    //   27: aload_1
    //   28: putstatic 48	d/i/a/b:a	Ljava/lang/Class;
    //   31: ldc 50
    //   33: ldc 52
    //   35: invokevirtual 56	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   38: astore_1
    //   39: aload_1
    //   40: iconst_1
    //   41: invokevirtual 62	java/lang/reflect/Field:setAccessible	(Z)V
    //   44: goto +6 -> 50
    //   47: astore_1
    //   48: aconst_null
    //   49: astore_1
    //   50: aload_1
    //   51: putstatic 64	d/i/a/b:b	Ljava/lang/reflect/Field;
    //   54: ldc 50
    //   56: ldc 66
    //   58: invokevirtual 56	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   61: astore_1
    //   62: aload_1
    //   63: iconst_1
    //   64: invokevirtual 62	java/lang/reflect/Field:setAccessible	(Z)V
    //   67: goto +6 -> 73
    //   70: astore_1
    //   71: aconst_null
    //   72: astore_1
    //   73: aload_1
    //   74: putstatic 68	d/i/a/b:c	Ljava/lang/reflect/Field;
    //   77: getstatic 48	d/i/a/b:a	Ljava/lang/Class;
    //   80: astore_1
    //   81: aload_1
    //   82: ifnonnull +8 -> 90
    //   85: aconst_null
    //   86: astore_1
    //   87: goto +35 -> 122
    //   90: aload_1
    //   91: ldc 70
    //   93: iconst_3
    //   94: anewarray 42	java/lang/Class
    //   97: dup
    //   98: iconst_0
    //   99: ldc 72
    //   101: aastore
    //   102: dup
    //   103: iconst_1
    //   104: getstatic 77	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   107: aastore
    //   108: dup
    //   109: iconst_2
    //   110: ldc 79
    //   112: aastore
    //   113: invokevirtual 83	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   116: astore_1
    //   117: aload_1
    //   118: iconst_1
    //   119: invokevirtual 86	java/lang/reflect/Method:setAccessible	(Z)V
    //   122: aload_1
    //   123: putstatic 88	d/i/a/b:d	Ljava/lang/reflect/Method;
    //   126: getstatic 48	d/i/a/b:a	Ljava/lang/Class;
    //   129: astore_1
    //   130: aload_1
    //   131: ifnonnull +8 -> 139
    //   134: aconst_null
    //   135: astore_1
    //   136: goto +30 -> 166
    //   139: aload_1
    //   140: ldc 70
    //   142: iconst_2
    //   143: anewarray 42	java/lang/Class
    //   146: dup
    //   147: iconst_0
    //   148: ldc 72
    //   150: aastore
    //   151: dup
    //   152: iconst_1
    //   153: getstatic 77	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   156: aastore
    //   157: invokevirtual 83	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   160: astore_1
    //   161: aload_1
    //   162: iconst_1
    //   163: invokevirtual 86	java/lang/reflect/Method:setAccessible	(Z)V
    //   166: aload_1
    //   167: putstatic 90	d/i/a/b:e	Ljava/lang/reflect/Method;
    //   170: getstatic 48	d/i/a/b:a	Ljava/lang/Class;
    //   173: astore_2
    //   174: aload_0
    //   175: astore_1
    //   176: invokestatic 93	d/i/a/b:a	()Z
    //   179: ifeq +81 -> 260
    //   182: aload_2
    //   183: ifnonnull +8 -> 191
    //   186: aload_0
    //   187: astore_1
    //   188: goto +72 -> 260
    //   191: aload_2
    //   192: ldc 95
    //   194: bipush 9
    //   196: anewarray 42	java/lang/Class
    //   199: dup
    //   200: iconst_0
    //   201: ldc 72
    //   203: aastore
    //   204: dup
    //   205: iconst_1
    //   206: ldc 97
    //   208: aastore
    //   209: dup
    //   210: iconst_2
    //   211: ldc 97
    //   213: aastore
    //   214: dup
    //   215: iconst_3
    //   216: getstatic 100	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   219: aastore
    //   220: dup
    //   221: iconst_4
    //   222: getstatic 77	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   225: aastore
    //   226: dup
    //   227: iconst_5
    //   228: ldc 102
    //   230: aastore
    //   231: dup
    //   232: bipush 6
    //   234: ldc 102
    //   236: aastore
    //   237: dup
    //   238: bipush 7
    //   240: getstatic 77	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   243: aastore
    //   244: dup
    //   245: bipush 8
    //   247: getstatic 77	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   250: aastore
    //   251: invokevirtual 83	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   254: astore_1
    //   255: aload_1
    //   256: iconst_1
    //   257: invokevirtual 86	java/lang/reflect/Method:setAccessible	(Z)V
    //   260: aload_1
    //   261: putstatic 104	d/i/a/b:f	Ljava/lang/reflect/Method;
    //   264: return
    //   265: astore_1
    //   266: goto -181 -> 85
    //   269: astore_1
    //   270: goto -136 -> 134
    //   273: astore_1
    //   274: aload_0
    //   275: astore_1
    //   276: goto -16 -> 260
    // Local variable table:
    //   start	length	slot	name	signature
    //   14	261	0	localObject1	Object
    //   20	1	1	localClass1	Class
    //   24	1	1	localObject2	Object
    //   26	14	1	localField1	Field
    //   47	1	1	localObject3	Object
    //   49	14	1	localField2	Field
    //   70	1	1	localObject4	Object
    //   72	189	1	localObject5	Object
    //   265	1	1	localObject6	Object
    //   269	1	1	localObject7	Object
    //   273	1	1	localObject8	Object
    //   275	1	1	localObject9	Object
    //   173	19	2	localClass2	Class
    // Exception table:
    //   from	to	target	type
    //   15	21	24	finally
    //   31	44	47	finally
    //   54	67	70	finally
    //   90	122	265	finally
    //   139	166	269	finally
    //   191	260	273	finally
  }
  
  public static boolean a()
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool;
    if ((i != 26) && (i != 27)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      paramActivity.recreate();
      return true;
    }
    if ((a()) && (f == null)) {
      return false;
    }
    if ((e == null) && (d == null)) {
      return false;
    }
    try
    {
      Object localObject1 = c.get(paramActivity);
      if (localObject1 == null) {
        return false;
      }
      Object localObject2 = b.get(paramActivity);
      if (localObject2 == null) {
        return false;
      }
      Application localApplication = paramActivity.getApplication();
      b.c localc = new d/i/a/b$c;
      localc.<init>(paramActivity);
      localApplication.registerActivityLifecycleCallbacks(localc);
      Handler localHandler = g;
      Object localObject3 = new d/i/a/b$a;
      ((b.a)localObject3).<init>(localc, localObject1);
      localHandler.post((Runnable)localObject3);
      try
      {
        if (a()) {
          f.invoke(localObject2, new Object[] { localObject1, null, null, Integer.valueOf(0), Boolean.valueOf(false), null, null, Boolean.valueOf(false), Boolean.valueOf(false) });
        } else {
          paramActivity.recreate();
        }
        return true;
      }
      finally
      {
        localObject2 = g;
        localObject3 = new d/i/a/b$b;
        ((b.b)localObject3).<init>(localApplication, localc);
        ((Handler)localObject2).post((Runnable)localObject3);
      }
      return false;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     base.d.i.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */