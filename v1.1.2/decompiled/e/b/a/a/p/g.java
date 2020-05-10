package e.b.a.a.p;

import e.a.a.a.a;
import e.b.a.a.n;
import e.b.a.a.s.b;
import e.b.a.a.s.c;
import java.io.Serializable;
import java.lang.ref.SoftReference;

public class g
  implements n, Serializable
{
  public final String x;
  public byte[] y;
  
  public g(String paramString)
  {
    if (paramString != null)
    {
      x = paramString;
      return;
    }
    throw new IllegalStateException("Null String illegal for SerializedString");
  }
  
  public final byte[] a()
  {
    Object localObject1 = y;
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      String str = x;
      localObject2 = (SoftReference)b.b.get();
      if (localObject2 == null) {
        localObject2 = null;
      } else {
        localObject2 = (d)((SoftReference)localObject2).get();
      }
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new d();
        b.b.set(new SoftReference(localObject1));
      }
      localObject2 = a;
      Object localObject3 = localObject2;
      if (localObject2 == null)
      {
        localObject3 = new c(null);
        a = ((c)localObject3);
      }
      int i = str.length();
      ((c)localObject3).b();
      localObject2 = z;
      int j = localObject2.length;
      int k = 0;
      int n;
      int i2;
      for (int m = 0;; m = i2 + 1)
      {
        n = m;
        if (k >= i) {
          break;
        }
        n = k + 1;
        int i1 = str.charAt(k);
        while (i1 <= 127)
        {
          k = j;
          i2 = m;
          if (m >= j)
          {
            ((c)localObject3).a();
            localObject2 = z;
            k = localObject2.length;
            i2 = 0;
          }
          m = i2 + 1;
          localObject2[i2] = ((byte)(byte)i1);
          if (n >= i)
          {
            n = m;
            break label766;
          }
          i1 = str.charAt(n);
          n++;
          j = k;
        }
        k = j;
        i2 = m;
        if (m >= j)
        {
          ((c)localObject3).a();
          localObject2 = z;
          k = localObject2.length;
          i2 = 0;
        }
        if (i1 < 2048)
        {
          j = i2 + 1;
          localObject2[i2] = ((byte)(byte)(i1 >> 6 | 0xC0));
          m = k;
          k = j;
        }
        else
        {
          if ((i1 >= 55296) && (i1 <= 57343))
          {
            if (i1 <= 56319)
            {
              if (n < i)
              {
                m = str.charAt(n);
                if ((m >= 56320) && (m <= 57343))
                {
                  j = (i1 - 55296 << 10) + 65536 + (m - 56320);
                  if (j <= 1114111)
                  {
                    i3 = i2 + 1;
                    localObject2[i2] = ((byte)(byte)(j >> 18 | 0xF0));
                    m = k;
                    i1 = i3;
                    if (i3 >= k)
                    {
                      ((c)localObject3).a();
                      localObject2 = z;
                      m = localObject2.length;
                      i1 = 0;
                    }
                    i2 = i1 + 1;
                    localObject2[i1] = ((byte)(byte)(j >> 12 & 0x3F | 0x80));
                    k = m;
                    i1 = i2;
                    if (i2 >= m)
                    {
                      ((c)localObject3).a();
                      localObject2 = z;
                      k = localObject2.length;
                      i1 = 0;
                    }
                    i2 = i1 + 1;
                    localObject2[i1] = ((byte)(byte)(j >> 6 & 0x3F | 0x80));
                    i1 = j;
                    n++;
                    m = k;
                    k = n;
                    n = i2;
                    break label709;
                  }
                  d.a(j);
                  throw null;
                }
                localObject2 = a.a("Broken surrogate pair: first char 0x");
                ((StringBuilder)localObject2).append(Integer.toHexString(i1));
                ((StringBuilder)localObject2).append(", second 0x");
                ((StringBuilder)localObject2).append(Integer.toHexString(m));
                ((StringBuilder)localObject2).append("; illegal combination");
                throw new IllegalArgumentException(((StringBuilder)localObject2).toString());
              }
              d.a(i1);
              throw null;
            }
            d.a(i1);
            throw null;
          }
          int i3 = i2 + 1;
          localObject2[i2] = ((byte)(byte)(i1 >> 12 | 0xE0));
          m = k;
          j = i3;
          if (i3 >= k)
          {
            ((c)localObject3).a();
            localObject2 = z;
            m = localObject2.length;
            j = 0;
          }
          localObject2[j] = ((byte)(byte)(i1 >> 6 & 0x3F | 0x80));
          k = j + 1;
        }
        j = n;
        n = k;
        k = j;
        label709:
        j = m;
        i2 = n;
        if (n >= m)
        {
          ((c)localObject3).a();
          localObject2 = z;
          j = localObject2.length;
          i2 = 0;
        }
        localObject2[i2] = ((byte)(byte)(i1 & 0x3F | 0x80));
      }
      label766:
      localObject2 = a;
      A = n;
      localObject2 = ((c)localObject2).c();
      y = ((byte[])localObject2);
    }
    return (byte[])localObject2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject != null) && (paramObject.getClass() == g.class))
    {
      paramObject = (g)paramObject;
      return x.equals(x);
    }
    return false;
  }
  
  public final int hashCode()
  {
    return x.hashCode();
  }
  
  public final String toString()
  {
    return x;
  }
}

/* Location:
 * Qualified Name:     e.b.a.a.p.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */