package h.c.m;

public abstract class a
{
  public static final class a
  {
    public static final a a;
    
    /* Error */
    static
    {
      // Byte code:
      //   0: ldc 12
      //   2: astore_0
      //   3: ldc 12
      //   5: invokestatic 18	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
      //   8: astore_1
      //   9: aload_1
      //   10: astore_2
      //   11: aload_1
      //   12: ifnonnull +36 -> 48
      //   15: ldc 6
      //   17: invokevirtual 24	java/lang/Class:getPackage	()Ljava/lang/Package;
      //   20: astore_1
      //   21: aload_0
      //   22: astore_2
      //   23: aload_1
      //   24: ifnull +17 -> 41
      //   27: aload_0
      //   28: astore_2
      //   29: aload_1
      //   30: invokevirtual 30	java/lang/Package:getName	()Ljava/lang/String;
      //   33: ifnull +8 -> 41
      //   36: aload_1
      //   37: invokevirtual 30	java/lang/Package:getName	()Ljava/lang/String;
      //   40: astore_2
      //   41: aload_2
      //   42: ldc 32
      //   44: invokestatic 38	e/a/a/a/a:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   47: astore_2
      //   48: aload_2
      //   49: invokestatic 42	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
      //   52: invokevirtual 46	java/lang/Class:newInstance	()Ljava/lang/Object;
      //   55: checkcast 6	h/c/m/a
      //   58: astore_0
      //   59: aload_0
      //   60: astore_2
      //   61: goto +19 -> 80
      //   64: astore_0
      //   65: new 48	h/c/m/c
      //   68: dup
      //   69: ldc 50
      //   71: aload_2
      //   72: invokestatic 38	e/a/a/a/a:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   75: aload_0
      //   76: invokespecial 54	h/c/m/c:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   79: astore_2
      //   80: aload_2
      //   81: putstatic 56	h/c/m/a$a:a	Lh/c/m/a;
      //   84: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   2	58	0	localObject1	Object
      //   64	12	0	localThrowable	Throwable
      //   8	29	1	localObject2	Object
      //   10	71	2	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   48	59	64	finally
    }
  }
}

/* Location:
 * Qualified Name:     h.c.m.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */