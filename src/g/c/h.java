package g.c;

import java.nio.charset.Charset;

public class h
  extends i
{
  public final f a;
  public boolean b = false;
  public int c = 0;
  public int d = 0;
  public int e = 1;
  public int f = 0;
  
  static
  {
    Charset.forName("ASCII");
    Charset.forName("UTF-8");
  }
  
  public h(f paramf)
  {
    a = paramf;
  }
  
  /* Error */
  public String toString()
  {
    // Byte code:
    //   0: new 67	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: invokevirtual 74	java/lang/Object:getClass	()Ljava/lang/Class;
    //   12: invokevirtual 80	java/lang/Class:getDeclaredFields	()[Ljava/lang/reflect/Field;
    //   15: astore_2
    //   16: aload_1
    //   17: aload_0
    //   18: invokevirtual 74	java/lang/Object:getClass	()Ljava/lang/Class;
    //   21: invokevirtual 83	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   24: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_1
    //   29: ldc 89
    //   31: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_2
    //   36: arraylength
    //   37: istore_3
    //   38: iconst_0
    //   39: istore 4
    //   41: iload 4
    //   43: iload_3
    //   44: if_icmpge +39 -> 83
    //   47: aload_2
    //   48: iload 4
    //   50: aaload
    //   51: astore 5
    //   53: aload_1
    //   54: ldc 91
    //   56: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload_1
    //   61: bipush 10
    //   63: invokevirtual 94	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: iinc 4 1
    //   70: goto -29 -> 41
    //   73: astore_1
    //   74: new 96	java/lang/RuntimeException
    //   77: dup
    //   78: aload_1
    //   79: invokespecial 99	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   82: athrow
    //   83: aload_1
    //   84: ldc 101
    //   86: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload_1
    //   91: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	h
    //   7	54	1	localStringBuilder	StringBuilder
    //   73	18	1	localThrowable	Throwable
    //   15	33	2	arrayOfField	java.lang.reflect.Field[]
    //   37	8	3	i	int
    //   39	29	4	j	int
    //   51	1	5	localField	java.lang.reflect.Field
    // Exception table:
    //   from	to	target	type
    //   53	67	73	finally
  }
}

/* Location:
 * Qualified Name:     base.g.c.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */