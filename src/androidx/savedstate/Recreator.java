package androidx.savedstate;

import android.annotation.SuppressLint;
import d.o.f;
import d.v.c;

@SuppressLint({"RestrictedApi"})
public final class Recreator
  implements f
{
  public final c x;
  
  public Recreator(c paramc)
  {
    x = paramc;
  }
  
  /* Error */
  public void a(d.o.l paraml, d.o.g.a parama)
  {
    // Byte code:
    //   0: aload_2
    //   1: getstatic 35	d/o/g$a:ON_CREATE	Ld/o/g$a;
    //   4: if_acmpne +214 -> 218
    //   7: aload_1
    //   8: invokeinterface 41 1 0
    //   13: checkcast 43	d/o/m
    //   16: getfield 46	d/o/m:a	Ld/c/a/b/a;
    //   19: aload_0
    //   20: invokevirtual 52	d/c/a/b/a:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: pop
    //   24: aload_0
    //   25: getfield 21	androidx/savedstate/Recreator:x	Ld/v/c;
    //   28: invokeinterface 58 1 0
    //   33: ldc 60
    //   35: invokevirtual 65	d/v/a:a	(Ljava/lang/String;)Landroid/os/Bundle;
    //   38: astore_1
    //   39: aload_1
    //   40: ifnonnull +4 -> 44
    //   43: return
    //   44: aload_1
    //   45: ldc 67
    //   47: invokevirtual 73	android/os/Bundle:getStringArrayList	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   50: astore_1
    //   51: aload_1
    //   52: ifnull +156 -> 208
    //   55: aload_1
    //   56: invokevirtual 79	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   59: astore_3
    //   60: aload_3
    //   61: invokeinterface 85 1 0
    //   66: ifeq +141 -> 207
    //   69: aload_3
    //   70: invokeinterface 89 1 0
    //   75: checkcast 91	java/lang/String
    //   78: astore_1
    //   79: aload_1
    //   80: iconst_0
    //   81: ldc 2
    //   83: invokevirtual 97	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   86: invokestatic 101	java/lang/Class:forName	(Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;
    //   89: ldc 103
    //   91: invokevirtual 107	java/lang/Class:asSubclass	(Ljava/lang/Class;)Ljava/lang/Class;
    //   94: astore_2
    //   95: aload_2
    //   96: iconst_0
    //   97: anewarray 93	java/lang/Class
    //   100: invokevirtual 111	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   103: astore 4
    //   105: aload 4
    //   107: iconst_1
    //   108: invokevirtual 117	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   111: aload 4
    //   113: iconst_0
    //   114: anewarray 4	java/lang/Object
    //   117: invokevirtual 121	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   120: checkcast 103	d/v/a$a
    //   123: astore_2
    //   124: aload_2
    //   125: aload_0
    //   126: getfield 21	androidx/savedstate/Recreator:x	Ld/v/c;
    //   129: invokeinterface 123 2 0
    //   134: goto -74 -> 60
    //   137: astore_2
    //   138: new 125	java/lang/RuntimeException
    //   141: dup
    //   142: ldc 127
    //   144: aload_1
    //   145: invokestatic 133	e/a/a/a/a:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   148: aload_2
    //   149: invokespecial 136	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   152: athrow
    //   153: astore_1
    //   154: ldc -118
    //   156: invokestatic 141	e/a/a/a/a:a	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: astore_3
    //   160: aload_3
    //   161: aload_2
    //   162: invokevirtual 145	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   165: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload_3
    //   170: ldc -104
    //   172: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: new 154	java/lang/IllegalStateException
    //   179: dup
    //   180: aload_3
    //   181: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: aload_1
    //   185: invokespecial 158	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   188: athrow
    //   189: astore_2
    //   190: new 125	java/lang/RuntimeException
    //   193: dup
    //   194: ldc -96
    //   196: aload_1
    //   197: ldc -94
    //   199: invokestatic 165	e/a/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   202: aload_2
    //   203: invokespecial 136	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   206: athrow
    //   207: return
    //   208: new 154	java/lang/IllegalStateException
    //   211: dup
    //   212: ldc -89
    //   214: invokespecial 170	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   217: athrow
    //   218: new 172	java/lang/AssertionError
    //   221: dup
    //   222: ldc -82
    //   224: invokespecial 177	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   227: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	this	Recreator
    //   0	228	1	paraml	d.o.l
    //   0	228	2	parama	d.o.g.a
    //   59	122	3	localObject	Object
    //   103	9	4	localConstructor	java.lang.reflect.Constructor
    // Exception table:
    //   from	to	target	type
    //   111	124	137	java/lang/Exception
    //   95	105	153	java/lang/NoSuchMethodException
    //   79	95	189	java/lang/ClassNotFoundException
  }
}

/* Location:
 * Qualified Name:     base.androidx.savedstate.Recreator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */