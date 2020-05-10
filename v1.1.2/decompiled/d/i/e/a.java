package d.i.e;

import d.m.a.d;

public final class a
{
  public boolean a;
  public a b;
  public boolean c;
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	d/i/e/a:a	Z
    //   6: ifeq +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: iconst_1
    //   14: putfield 18	d/i/e/a:a	Z
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 20	d/i/e/a:c	Z
    //   22: aload_0
    //   23: getfield 22	d/i/e/a:b	Ld/i/e/a$a;
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: ifnull +36 -> 66
    //   33: aload_1
    //   34: checkcast 24	d/m/a/d
    //   37: astore_1
    //   38: aload_1
    //   39: invokevirtual 26	d/m/a/d:a	()V
    //   42: goto +24 -> 66
    //   45: astore_1
    //   46: aload_0
    //   47: monitorenter
    //   48: aload_0
    //   49: iconst_0
    //   50: putfield 20	d/i/e/a:c	Z
    //   53: aload_0
    //   54: invokevirtual 29	java/lang/Object:notifyAll	()V
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: athrow
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    //   66: aload_0
    //   67: monitorenter
    //   68: aload_0
    //   69: iconst_0
    //   70: putfield 20	d/i/e/a:c	Z
    //   73: aload_0
    //   74: invokevirtual 29	java/lang/Object:notifyAll	()V
    //   77: aload_0
    //   78: monitorexit
    //   79: return
    //   80: astore_1
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	a
    //   26	13	1	localObject1	Object
    //   45	15	1	localObject2	Object
    //   61	4	1	localObject3	Object
    //   80	4	1	localObject4	Object
    //   85	4	1	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   38	42	45	finally
    //   48	59	61	finally
    //   62	64	61	finally
    //   68	79	80	finally
    //   81	83	80	finally
    //   2	11	85	finally
    //   12	29	85	finally
    //   86	88	85	finally
  }
  
  public void a(a parama)
  {
    for (;;)
    {
      try
      {
        boolean bool = c;
        if (!bool) {}
      }
      finally {}
      try
      {
        wait();
      }
      catch (InterruptedException localInterruptedException) {}
      if (b == parama) {
        return;
      }
      b = parama;
      if ((a) && (parama != null))
      {
        ((d)parama).a();
        return;
      }
      return;
    }
  }
  
  public boolean b()
  {
    try
    {
      boolean bool = a;
      return bool;
    }
    finally {}
  }
  
  public static abstract interface a {}
}

/* Location:
 * Qualified Name:     d.i.e.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */