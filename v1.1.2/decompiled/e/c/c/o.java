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
    //   26: astore_3
    //   27: new 27	e/c/c/n
    //   30: astore 4
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
    //   65: aload 4
    //   67: aload 5
    //   69: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: aload_3
    //   73: invokespecial 48	e/c/c/n:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   76: aload 4
    //   78: athrow
    //   79: astore 4
    //   81: new 27	e/c/c/n
    //   84: astore_3
    //   85: new 29	java/lang/StringBuilder
    //   88: astore 5
    //   90: aload 5
    //   92: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   95: aload 5
    //   97: ldc 32
    //   99: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload 5
    //   105: aload_1
    //   106: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload 5
    //   112: ldc 41
    //   114: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload_3
    //   119: aload 5
    //   121: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: aload 4
    //   126: invokespecial 48	e/c/c/n:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   129: aload_3
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
    //   22	1	3	localObject	Object
    //   26	47	3	localOutOfMemoryError	OutOfMemoryError
    //   84	53	3	localn1	n
    //   30	47	4	localn2	n
    //   79	46	4	localStackOverflowError	StackOverflowError
    //   35	85	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   10	15	22	finally
    //   27	79	22	finally
    //   81	131	22	finally
    //   10	15	26	java/lang/OutOfMemoryError
    //   10	15	79	java/lang/StackOverflowError
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
 * Qualified Name:     e.c.c.o
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */