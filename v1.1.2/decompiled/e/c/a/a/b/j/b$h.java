package e.c.a.a.b.j;

import java.util.ArrayList;

public abstract class b$h<TListener>
{
  public TListener a;
  public boolean b;
  
  public b$h(TListener paramTListener)
  {
    Object localObject;
    a = localObject;
    b = false;
  }
  
  public final void a()
  {
    try
    {
      a = null;
      return;
    }
    finally {}
  }
  
  public abstract void a(TListener paramTListener);
  
  public final void b()
  {
    a();
    synchronized (c.j)
    {
      c.j.remove(this);
      return;
    }
  }
  
  /* Error */
  public final void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 24	e/c/a/a/b/j/b$h:a	Ljava/lang/Object;
    //   6: astore_1
    //   7: aload_0
    //   8: getfield 26	e/c/a/a/b/j/b$h:b	Z
    //   11: ifeq +61 -> 72
    //   14: aload_0
    //   15: invokestatic 50	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   18: astore_2
    //   19: aload_2
    //   20: invokevirtual 54	java/lang/String:length	()I
    //   23: istore_3
    //   24: new 56	java/lang/StringBuilder
    //   27: astore 4
    //   29: aload 4
    //   31: iload_3
    //   32: bipush 47
    //   34: iadd
    //   35: invokespecial 59	java/lang/StringBuilder:<init>	(I)V
    //   38: aload 4
    //   40: ldc 61
    //   42: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 4
    //   48: aload_2
    //   49: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload 4
    //   55: ldc 67
    //   57: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: ldc 69
    //   63: aload 4
    //   65: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 79	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   71: pop
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: ifnull +16 -> 91
    //   78: aload_0
    //   79: aload_1
    //   80: invokevirtual 81	e/c/a/a/b/j/b$h:a	(Ljava/lang/Object;)V
    //   83: goto +8 -> 91
    //   86: astore 4
    //   88: aload 4
    //   90: athrow
    //   91: aload_0
    //   92: monitorenter
    //   93: aload_0
    //   94: iconst_1
    //   95: putfield 26	e/c/a/a/b/j/b$h:b	Z
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_0
    //   101: invokevirtual 83	e/c/a/a/b/j/b$h:b	()V
    //   104: return
    //   105: astore 4
    //   107: aload_0
    //   108: monitorexit
    //   109: aload 4
    //   111: athrow
    //   112: astore 4
    //   114: aload_0
    //   115: monitorexit
    //   116: aload 4
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	h
    //   6	74	1	localObject1	Object
    //   18	31	2	str	String
    //   23	12	3	i	int
    //   27	37	4	localStringBuilder	StringBuilder
    //   86	3	4	localRuntimeException	RuntimeException
    //   105	5	4	localObject2	Object
    //   112	5	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   78	83	86	java/lang/RuntimeException
    //   93	100	105	finally
    //   107	109	105	finally
    //   2	72	112	finally
    //   72	74	112	finally
    //   114	116	112	finally
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.b.j.b.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */