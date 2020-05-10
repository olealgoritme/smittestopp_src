package e.c.c;

import e.c.c.y.a;
import e.c.c.y.b;
import e.c.c.y.d;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public final class o
{
  /* Error */
  public j a(a parama)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 21	e/c/c/y/a:y	Z
    //   4: istore_2
    //   5: aload_1
    //   6: iconst_1
    //   7: putfield 21	e/c/c/y/a:y	Z
    //   10: aload_1
    //   11: invokestatic 25	e/c/a/a/b/l/c:a	(Le/c/c/y/a;)Le/c/c/j;
    //   14: astore_3
    //   15: aload_1
    //   16: iload_2
    //   17: putfield 21	e/c/c/y/a:y	Z
    //   20: aload_3
    //   21: areturn
    //   22: astore_3
    //   23: goto +108 -> 131
    //   26: astore 4
    //   28: new 27	e/c/c/n
    //   31: astore_3
    //   32: new 29	java/lang/StringBuilder
    //   35: astore 5
    //   37: aload 5
    //   39: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   42: aload 5
    //   44: ldc 32
    //   46: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload 5
    //   52: aload_1
    //   53: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload 5
    //   59: ldc 41
    //   61: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload_3
    //   66: aload 5
    //   68: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: aload 4
    //   73: invokespecial 48	e/c/c/n:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   76: aload_3
    //   77: athrow
    //   78: astore_3
    //   79: new 27	e/c/c/n
    //   82: astore 5
    //   84: new 29	java/lang/StringBuilder
    //   87: astore 4
    //   89: aload 4
    //   91: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   94: aload 4
    //   96: ldc 32
    //   98: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload 4
    //   104: aload_1
    //   105: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload 4
    //   111: ldc 41
    //   113: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload 5
    //   119: aload 4
    //   121: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: aload_3
    //   125: invokespecial 48	e/c/c/n:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   128: aload 5
    //   130: athrow
    //   131: aload_1
    //   132: iload_2
    //   133: putfield 21	e/c/c/y/a:y	Z
    //   136: aload_3
    //   137: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	o
    //   0	138	1	parama	a
    //   4	129	2	bool	boolean
    //   14	7	3	localj	j
    //   22	1	3	localObject1	Object
    //   31	46	3	localn	n
    //   78	59	3	localStackOverflowError	StackOverflowError
    //   26	46	4	localOutOfMemoryError	OutOfMemoryError
    //   87	33	4	localStringBuilder	StringBuilder
    //   35	94	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   10	15	22	finally
    //   28	78	22	finally
    //   79	131	22	finally
    //   10	15	26	java/lang/OutOfMemoryError
    //   10	15	78	java/lang/StackOverflowError
  }
  
  public j a(String paramString)
  {
    Object localObject = new StringReader(paramString);
    try
    {
      paramString = new e/c/c/y/a;
      paramString.<init>((Reader)localObject);
      localObject = a(paramString);
      if (localObject != null)
      {
        if ((!(localObject instanceof l)) && (paramString.r() != b.END_DOCUMENT))
        {
          paramString = new e/c/c/s;
          paramString.<init>("Did not consume the entire document.");
          throw paramString;
        }
        return (j)localObject;
      }
      throw null;
    }
    catch (NumberFormatException paramString)
    {
      throw new s(paramString);
    }
    catch (IOException paramString)
    {
      throw new k(paramString);
    }
    catch (d paramString)
    {
      throw new s(paramString);
    }
  }
}

/* Location:
 * Qualified Name:     base.e.c.c.o
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */