package d.i.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import d.i.b.b.c;
import d.i.f.b.f;
import java.util.concurrent.ConcurrentHashMap;

public class i
{
  public ConcurrentHashMap<Long, c> a = new ConcurrentHashMap();
  
  /* Error */
  public Typeface a(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 25	d/b/a/s:a	(Landroid/content/Context;)Ljava/io/File;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnonnull +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: aload_1
    //   12: aload_2
    //   13: iload_3
    //   14: invokestatic 28	d/b/a/s:a	(Ljava/io/File;Landroid/content/res/Resources;I)Z
    //   17: istore 6
    //   19: iload 6
    //   21: ifne +10 -> 31
    //   24: aload_1
    //   25: invokevirtual 34	java/io/File:delete	()Z
    //   28: pop
    //   29: aconst_null
    //   30: areturn
    //   31: aload_1
    //   32: invokevirtual 38	java/io/File:getPath	()Ljava/lang/String;
    //   35: invokestatic 44	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   38: astore_2
    //   39: aload_1
    //   40: invokevirtual 34	java/io/File:delete	()Z
    //   43: pop
    //   44: aload_2
    //   45: areturn
    //   46: astore_2
    //   47: aload_1
    //   48: invokevirtual 34	java/io/File:delete	()Z
    //   51: pop
    //   52: aload_2
    //   53: athrow
    //   54: astore_2
    //   55: aload_1
    //   56: invokevirtual 34	java/io/File:delete	()Z
    //   59: pop
    //   60: aconst_null
    //   61: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	i
    //   0	62	1	paramContext	Context
    //   0	62	2	paramResources	Resources
    //   0	62	3	paramInt1	int
    //   0	62	4	paramString	String
    //   0	62	5	paramInt2	int
    //   17	3	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   11	19	46	finally
    //   31	39	46	finally
    //   11	19	54	java/lang/RuntimeException
    //   31	39	54	java/lang/RuntimeException
  }
  
  public Typeface a(Context paramContext, CancellationSignal paramCancellationSignal, b.f[] paramArrayOff, int paramInt)
  {
    throw null;
  }
  
  public Typeface a(Context paramContext, c paramc, Resources paramResources, int paramInt)
  {
    throw null;
  }
  
  /* Error */
  public Typeface a(Context paramContext, java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 25	d/b/a/s:a	(Landroid/content/Context;)Ljava/io/File;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnonnull +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: aload_1
    //   12: aload_2
    //   13: invokestatic 50	d/b/a/s:a	(Ljava/io/File;Ljava/io/InputStream;)Z
    //   16: istore_3
    //   17: iload_3
    //   18: ifne +10 -> 28
    //   21: aload_1
    //   22: invokevirtual 34	java/io/File:delete	()Z
    //   25: pop
    //   26: aconst_null
    //   27: areturn
    //   28: aload_1
    //   29: invokevirtual 38	java/io/File:getPath	()Ljava/lang/String;
    //   32: invokestatic 44	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   35: astore_2
    //   36: aload_1
    //   37: invokevirtual 34	java/io/File:delete	()Z
    //   40: pop
    //   41: aload_2
    //   42: areturn
    //   43: astore_2
    //   44: aload_1
    //   45: invokevirtual 34	java/io/File:delete	()Z
    //   48: pop
    //   49: aload_2
    //   50: athrow
    //   51: astore_2
    //   52: aload_1
    //   53: invokevirtual 34	java/io/File:delete	()Z
    //   56: pop
    //   57: aconst_null
    //   58: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	i
    //   0	59	1	paramContext	Context
    //   0	59	2	paramInputStream	java.io.InputStream
    //   16	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   11	17	43	finally
    //   28	36	43	finally
    //   11	17	51	java/lang/RuntimeException
    //   28	36	51	java/lang/RuntimeException
  }
  
  public b.f a(b.f[] paramArrayOff, int paramInt)
  {
    int i;
    if ((paramInt & 0x1) == 0) {
      i = 400;
    } else {
      i = 700;
    }
    int j;
    if ((paramInt & 0x2) != 0) {
      j = 1;
    } else {
      j = 0;
    }
    Object localObject = null;
    int k = Integer.MAX_VALUE;
    int m = paramArrayOff.length;
    paramInt = 0;
    while (paramInt < m)
    {
      b.f localf = paramArrayOff[paramInt];
      int n = Math.abs(c - i);
      int i1;
      if (d == j) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      n = n * 2 + i1;
      if (localObject != null)
      {
        i1 = k;
        if (k <= n) {}
      }
      else
      {
        localObject = localf;
        i1 = n;
      }
      paramInt++;
      k = i1;
    }
    return (b.f)localObject;
  }
}

/* Location:
 * Qualified Name:     d.i.c.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */