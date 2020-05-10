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
    //   75: ifnull +14 -> 89
    //   78: aload_0
    //   79: aload_1
    //   80: invokevirtual 81	e/c/a/a/b/j/b$h:a	(Ljava/lang/Object;)V
    //   83: goto +6 -> 89
    //   86: astore_1
    //   87: aload_1
    //   88: athrow
    //   89: aload_0
    //   90: monitorenter
    //   91: aload_0
    //   92: iconst_1
    //   93: putfield 26	e/c/a/a/b/j/b$h:b	Z
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_0
    //   99: invokevirtual 83	e/c/a/a/b/j/b$h:b	()V
    //   102: return
    //   103: astore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    //   108: astore_1
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_1
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	h
    //   6	74	1	localObject1	Object
    //   86	2	1	localRuntimeException	RuntimeException
    //   103	4	1	localObject2	Object
    //   108	4	1	localObject3	Object
    //   18	31	2	str	String
    //   23	12	3	i	int
    //   27	37	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   78	83	86	java/lang/RuntimeException
    //   91	98	103	finally
    //   104	106	103	finally
    //   2	72	108	finally
    //   72	74	108	finally
    //   109	111	108	finally
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.b.j.b.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */