package e.b.a.a.r;

import e.a.a.a.a;
import e.b.a.a.d.a;
import e.b.a.a.s.e;
import java.util.Arrays;
import java.util.BitSet;
import java.util.concurrent.atomic.AtomicReference;

public final class b
{
  public final b a;
  public final AtomicReference<b.b> b;
  public final int c;
  public final int d;
  public boolean e;
  public String[] f;
  public b.a[] g;
  public int h;
  public int i;
  public int j;
  public int k;
  public boolean l;
  public BitSet m;
  
  public b(int paramInt)
  {
    a = null;
    c = paramInt;
    e = true;
    d = -1;
    l = false;
    k = 0;
    b = new AtomicReference(new b.b(0, 0, new String[64], new b.a[32]));
  }
  
  public b(b paramb, int paramInt1, int paramInt2, b.b paramb1)
  {
    a = paramb;
    c = paramInt2;
    b = null;
    d = paramInt1;
    e = d.a.CANONICALIZE_FIELD_NAMES.enabledIn(paramInt1);
    paramb = c;
    f = paramb;
    g = d;
    h = a;
    k = b;
    paramInt1 = paramb.length;
    i = (paramInt1 - (paramInt1 >> 2));
    j = (paramInt1 - 1);
    l = true;
  }
  
  public int a(int paramInt)
  {
    paramInt += (paramInt >>> 15);
    paramInt ^= paramInt << 7;
    return paramInt + (paramInt >>> 3) & j;
  }
  
  public int a(String paramString)
  {
    int n = paramString.length();
    int i1 = c;
    for (int i2 = 0; i2 < n; i2++) {
      i1 = i1 * 33 + paramString.charAt(i2);
    }
    i2 = i1;
    if (i1 == 0) {
      i2 = 1;
    }
    return i2;
  }
  
  public String a(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 < 1) {
      return "";
    }
    if (!e) {
      return new String(paramArrayOfChar, paramInt1, paramInt2);
    }
    int n = a(paramInt3);
    Object localObject1 = f[n];
    int i1;
    Object localObject2;
    if (localObject1 != null)
    {
      if (((String)localObject1).length() == paramInt2)
      {
        paramInt3 = 0;
        while (((String)localObject1).charAt(paramInt3) == paramArrayOfChar[(paramInt1 + paramInt3)])
        {
          i1 = paramInt3 + 1;
          paramInt3 = i1;
          if (i1 == paramInt2) {
            return (String)localObject1;
          }
        }
      }
      localObject2 = g[(n >> 1)];
      if (localObject2 != null)
      {
        localObject1 = ((b.a)localObject2).a(paramArrayOfChar, paramInt1, paramInt2);
        if (localObject1 != null) {
          return (String)localObject1;
        }
        for (localObject1 = b; localObject1 != null; localObject1 = b)
        {
          localObject2 = ((b.a)localObject1).a(paramArrayOfChar, paramInt1, paramInt2);
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            break label176;
          }
        }
        localObject1 = null;
        label176:
        if (localObject1 != null) {
          return (String)localObject1;
        }
      }
    }
    if (l)
    {
      localObject1 = f;
      f = ((String[])Arrays.copyOf((Object[])localObject1, localObject1.length));
      localObject1 = g;
      g = ((b.a[])Arrays.copyOf((Object[])localObject1, localObject1.length));
      l = false;
      paramInt3 = n;
    }
    else
    {
      paramInt3 = n;
      if (h >= i)
      {
        localObject1 = f;
        int i2 = localObject1.length;
        paramInt3 = i2 + i2;
        int i4;
        if (paramInt3 > 65536)
        {
          h = 0;
          e = false;
          f = new String[64];
          g = new b.a[32];
          j = 63;
          l = false;
        }
        else
        {
          localObject2 = g;
          f = new String[paramInt3];
          g = new b.a[paramInt3 >> 1];
          j = (paramInt3 - 1);
          i = (paramInt3 - (paramInt3 >> 2));
          i1 = 0;
          n = 0;
          String str;
          Object localObject3;
          for (paramInt3 = 0; i1 < i2; paramInt3 = i4)
          {
            str = localObject1[i1];
            i3 = n;
            i4 = paramInt3;
            if (str != null)
            {
              i3 = n + 1;
              n = a(a(str));
              localObject3 = f;
              if (localObject3[n] == null)
              {
                localObject3[n] = str;
                i4 = paramInt3;
              }
              else
              {
                n >>= 1;
                localObject3 = new b.a(str, g[n]);
                g[n] = localObject3;
                i4 = Math.max(paramInt3, c);
              }
            }
            i1++;
            n = i3;
          }
          int i3 = 0;
          i1 = paramInt3;
          i4 = n;
          paramInt3 = i3;
          while (paramInt3 < i2 >> 1)
          {
            localObject1 = localObject2[paramInt3];
            n = i1;
            i1 = i4;
            while (localObject1 != null)
            {
              i1++;
              str = a;
              i4 = a(a(str));
              localObject3 = f;
              if (localObject3[i4] == null)
              {
                localObject3[i4] = str;
              }
              else
              {
                i4 >>= 1;
                localObject3 = new b.a(str, g[i4]);
                g[i4] = localObject3;
                n = Math.max(n, c);
              }
              localObject1 = b;
            }
            paramInt3++;
            i4 = i1;
            i1 = n;
          }
          k = i1;
          m = null;
          if (i4 != h) {
            break label750;
          }
        }
        paramInt3 = c;
        for (n = paramInt1; n < paramInt2 + paramInt1; n++) {
          paramInt3 = paramInt3 * 33 + paramArrayOfChar[n];
        }
        n = paramInt3;
        if (paramInt3 == 0) {
          n = 1;
        }
        paramInt3 = a(n);
        break label785;
        label750:
        throw new IllegalStateException(String.format("Internal error on SymbolTable.rehash(): had %d entries; now have %d", new Object[] { Integer.valueOf(h), Integer.valueOf(i4) }));
      }
    }
    label785:
    localObject1 = new String(paramArrayOfChar, paramInt1, paramInt2);
    paramArrayOfChar = (char[])localObject1;
    if (d.a.INTERN_FIELD_NAMES.enabledIn(d)) {
      paramArrayOfChar = e.y.c((String)localObject1);
    }
    h += 1;
    localObject1 = f;
    if (localObject1[paramInt3] == null)
    {
      localObject1[paramInt3] = paramArrayOfChar;
    }
    else
    {
      paramInt1 = paramInt3 >> 1;
      localObject1 = new b.a(paramArrayOfChar, g[paramInt1]);
      paramInt2 = c;
      if (paramInt2 > 100)
      {
        localObject2 = m;
        if (localObject2 == null)
        {
          localObject2 = new BitSet();
          m = ((BitSet)localObject2);
          ((BitSet)localObject2).set(paramInt1);
        }
        else if (((BitSet)localObject2).get(paramInt1))
        {
          if (!d.a.FAIL_ON_SYMBOL_HASH_OVERFLOW.enabledIn(d))
          {
            e = false;
          }
          else
          {
            paramArrayOfChar = a.a("Longest collision chain in symbol table (of size ");
            paramArrayOfChar.append(h);
            paramArrayOfChar.append(") now exceeds maximum, ");
            paramArrayOfChar.append(100);
            paramArrayOfChar.append(" -- suspect a DoS attack based on hash collisions");
            throw new IllegalStateException(paramArrayOfChar.toString());
          }
        }
        else
        {
          m.set(paramInt1);
        }
        f[(paramInt1 + paramInt1)] = a;
        g[paramInt1] = null;
        h -= c;
        k = -1;
      }
      else
      {
        g[paramInt1] = localObject1;
        k = Math.max(paramInt2, k);
      }
    }
    return paramArrayOfChar;
  }
  
  public b b(int paramInt)
  {
    return new b(this, paramInt, c, (b.b)b.get());
  }
}

/* Location:
 * Qualified Name:     base.e.b.a.a.r.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */