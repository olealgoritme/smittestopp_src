package g.c;

import java.nio.charset.Charset;

public abstract class g
{
  public static final Charset b = Charset.forName("UTF-8");
  public final g.c a;
  
  static
  {
    Charset.forName("ASCII");
  }
  
  public g(f paramf)
  {
    a = new g.c(paramf);
  }
  
  /* Error */
  public String toString()
  {
    // Byte code:
    //   0: new 78	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: invokevirtual 83	java/lang/Object:getClass	()Ljava/lang/Class;
    //   12: invokevirtual 89	java/lang/Class:getDeclaredFields	()[Ljava/lang/reflect/Field;
    //   15: astore_2
    //   16: aload_1
    //   17: aload_0
    //   18: invokevirtual 83	java/lang/Object:getClass	()Ljava/lang/Class;
    //   21: invokevirtual 92	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   24: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_1
    //   29: ldc 98
    //   31: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_2
    //   36: arraylength
    //   37: istore_3
    //   38: iconst_0
    //   39: istore 4
    //   41: iload 4
    //   43: iload_3
    //   44: if_icmpge +72 -> 116
    //   47: aload_2
    //   48: iload 4
    //   50: aaload
    //   51: astore 5
    //   53: aload_1
    //   54: ldc 100
    //   56: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload_1
    //   61: aload 5
    //   63: invokevirtual 105	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   66: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload_1
    //   71: ldc 107
    //   73: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload_1
    //   78: aload 5
    //   80: aload_0
    //   81: invokevirtual 111	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   84: invokevirtual 113	java/lang/Object:toString	()Ljava/lang/String;
    //   87: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload_1
    //   92: ldc 115
    //   94: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: iinc 4 1
    //   101: goto -60 -> 41
    //   104: astore 5
    //   106: new 117	java/lang/RuntimeException
    //   109: dup
    //   110: aload 5
    //   112: invokespecial 120	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   115: athrow
    //   116: aload_1
    //   117: ldc 122
    //   119: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload_1
    //   124: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	g
    //   7	117	1	localStringBuilder	StringBuilder
    //   15	33	2	arrayOfField	java.lang.reflect.Field[]
    //   37	8	3	i	int
    //   39	60	4	j	int
    //   51	28	5	localField	java.lang.reflect.Field
    //   104	7	5	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   53	98	104	finally
  }
}

/* Location:
 * Qualified Name:     base.g.c.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */