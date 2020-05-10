package k.b.i.b.g;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import k.b.a.o;

public class b
  implements Serializable
{
  public final Map<Integer, a> x = new TreeMap();
  public transient long y;
  
  public b(long paramLong)
  {
    y = paramLong;
  }
  
  public b(b paramb, long paramLong)
  {
    Iterator localIterator = x.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      x.put(localInteger, new a((a)x.get(localInteger)));
    }
    y = paramLong;
  }
  
  public b(r paramr, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    y = ((1L << c) - 1L);
    for (long l1 = 0L; l1 < paramLong; l1 += 1L)
    {
      w localw = b;
      int i = b;
      long l2 = l1 >> i;
      long l3 = (1L << i) - 1L;
      int j = (int)(l1 & l3);
      Object localObject1 = (j.b)new j.b().a(l2);
      e = j;
      localObject1 = (j)((j.b)localObject1).b();
      int k = 1 << i;
      int m = k - 1;
      Object localObject2;
      if (j < m)
      {
        if (((a)x.get(Integer.valueOf(0)) != null) && (j != 0)) {
          break label221;
        }
        localObject2 = localw.a();
        j = b;
        localObject2 = new a((k)localObject2, j, c, (1 << j) - 1);
        ((a)localObject2).a(paramArrayOfByte1, paramArrayOfByte2, (j)localObject1);
        x.put(Integer.valueOf(0), localObject2);
        label221:
        a(0, paramArrayOfByte1, paramArrayOfByte2, (j)localObject1);
      }
      for (j = 1; j < d; j++)
      {
        int n = (int)(l2 & l3);
        l2 >>= i;
        localObject1 = (j.b)((j.b)new j.b().b(j)).a(l2);
        e = n;
        localObject2 = (j)((j.b)localObject1).b();
        if (x.get(Integer.valueOf(j)) != null)
        {
          if ((l1 != 0L) && (l1 % Math.pow(k, j + 1) == 0L)) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          if (i1 == 0) {
            break label442;
          }
        }
        localObject1 = x;
        Object localObject3 = localw.a();
        int i1 = b;
        localObject3 = new a((k)localObject3, i1, c, (1 << i1) - 1);
        ((a)localObject3).a(paramArrayOfByte1, paramArrayOfByte2, (j)localObject2);
        ((Map)localObject1).put(Integer.valueOf(j), localObject3);
        label442:
        if (n < m)
        {
          if ((l1 != 0L) && ((l1 + 1L) % Math.pow(k, j) == 0L)) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          if (i1 != 0) {
            a(j, paramArrayOfByte1, paramArrayOfByte2, (j)localObject2);
          }
        }
      }
    }
  }
  
  public a a(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, j paramj)
  {
    Map localMap = x;
    a locala = (a)x.get(Integer.valueOf(paramInt));
    if (locala != null) {
      return (a)localMap.put(Integer.valueOf(paramInt), new a(locala, paramArrayOfByte1, paramArrayOfByte2, paramj));
    }
    throw null;
  }
  
  public b a(o paramo)
  {
    b localb = new b(y);
    Iterator localIterator = x.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      Map localMap = x;
      a locala = (a)x.get(localInteger);
      if (locala != null) {
        localMap.put(localInteger, new a(locala, paramo));
      } else {
        throw null;
      }
    }
    return localb;
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.b.g.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */