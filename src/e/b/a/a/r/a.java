package e.b.a.a.r;

import e.b.a.a.s.e;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public final class a
{
  public final a a;
  public final AtomicReference<a.a> b;
  public final int c;
  public boolean d;
  public final boolean e;
  public int[] f;
  public int g;
  public int h;
  public int i;
  public int j;
  public int k;
  public String[] l;
  public int m;
  public int n;
  public transient boolean o;
  public boolean p;
  
  public a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    a = null;
    c = paramInt2;
    d = paramBoolean1;
    e = paramBoolean2;
    int i1 = 16;
    if (paramInt1 < 16)
    {
      paramInt2 = 16;
    }
    else
    {
      paramInt2 = paramInt1;
      if ((paramInt1 - 1 & paramInt1) != 0)
      {
        paramInt2 = i1;
        while (paramInt2 < paramInt1) {
          paramInt2 += paramInt2;
        }
      }
    }
    b = new AtomicReference(a.a.a(paramInt2));
  }
  
  public a(a parama, boolean paramBoolean1, int paramInt, boolean paramBoolean2, a.a parama1)
  {
    a = parama;
    c = paramInt;
    d = paramBoolean1;
    e = paramBoolean2;
    b = null;
    k = b;
    paramInt = a;
    g = paramInt;
    paramInt <<= 2;
    h = paramInt;
    i = (paramInt + (paramInt >> 1));
    j = c;
    f = d;
    l = e;
    m = f;
    n = g;
    o = false;
    p = true;
  }
  
  public static int d(int paramInt)
  {
    paramInt >>= 2;
    if (paramInt < 64) {
      return 4;
    }
    if (paramInt <= 256) {
      return 5;
    }
    if (paramInt <= 1024) {
      return 6;
    }
    return 7;
  }
  
  public final int a()
  {
    int i1 = g;
    return (i1 << 3) - i1;
  }
  
  public final int a(int paramInt)
  {
    return (paramInt & g - 1) << 2;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    paramInt1 += (paramInt1 >>> 15);
    paramInt1 = c ^ paramInt2 * 33 + (paramInt1 ^ paramInt1 >>> 9);
    paramInt1 += (paramInt1 >>> 16);
    paramInt1 ^= paramInt1 >>> 4;
    return paramInt1 + (paramInt1 << 3);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 ^= c;
    paramInt1 = ((paramInt1 + (paramInt1 >>> 9)) * 31 + paramInt2) * 33;
    paramInt1 = paramInt1 + (paramInt1 >>> 15) ^ paramInt3;
    paramInt1 += (paramInt1 >>> 4);
    paramInt1 += (paramInt1 >>> 15);
    return paramInt1 ^ paramInt1 << 9;
  }
  
  public int a(int[] paramArrayOfInt, int paramInt)
  {
    if (paramInt >= 4)
    {
      int i1 = paramArrayOfInt[0] ^ c;
      i1 = i1 + (i1 >>> 9) + paramArrayOfInt[1];
      i1 = (i1 + (i1 >>> 15)) * 33 ^ paramArrayOfInt[2];
      int i2 = i1 + (i1 >>> 4);
      for (i1 = 3; i1 < paramInt; i1++)
      {
        int i3 = paramArrayOfInt[i1];
        i2 += (i3 ^ i3 >> 21);
      }
      paramInt = i2 * 65599;
      paramInt += (paramInt >>> 19);
      return paramInt << 5 ^ paramInt;
    }
    throw new IllegalArgumentException();
  }
  
  public String a(String paramString, int[] paramArrayOfInt, int paramInt)
  {
    Object localObject1;
    if (p)
    {
      localObject1 = f;
      f = Arrays.copyOf((int[])localObject1, localObject1.length);
      localObject1 = l;
      l = ((String[])Arrays.copyOf((Object[])localObject1, localObject1.length));
      p = false;
      b();
    }
    int i1;
    int i2;
    int i3;
    int i4;
    int i5;
    if (o)
    {
      o = false;
      p = false;
      int[] arrayOfInt = f;
      String[] arrayOfString = l;
      i1 = g;
      i2 = k;
      i3 = i1 + i1;
      i4 = m;
      if (i3 > 65536)
      {
        a(true);
      }
      else
      {
        f = new int[arrayOfInt.length + (i1 << 3)];
        g = i3;
        i1 = i3 << 2;
        h = i1;
        i = (i1 + (i1 >> 1));
        j = d(i3);
        l = new String[arrayOfString.length << 1];
        a(false);
        localObject1 = new int[16];
        i3 = 0;
        i1 = 0;
        while (i3 < i4)
        {
          i5 = arrayOfInt[(i3 + 3)];
          if (i5 != 0)
          {
            i1++;
            String str = arrayOfString[(i3 >> 2)];
            if (i5 != 1)
            {
              if (i5 != 2)
              {
                if (i5 != 3)
                {
                  Object localObject2 = localObject1;
                  if (i5 > localObject1.length) {
                    localObject2 = new int[i5];
                  }
                  System.arraycopy(arrayOfInt, arrayOfInt[(i3 + 1)], localObject2, 0, i5);
                  a(str, (int[])localObject2, i5);
                  localObject1 = localObject2;
                }
                else
                {
                  localObject1[0] = arrayOfInt[i3];
                  localObject1[1] = arrayOfInt[(i3 + 1)];
                  localObject1[2] = arrayOfInt[(i3 + 2)];
                  a(str, (int[])localObject1, 3);
                }
              }
              else
              {
                localObject1[0] = arrayOfInt[i3];
                localObject1[1] = arrayOfInt[(i3 + 1)];
                a(str, (int[])localObject1, 2);
              }
            }
            else
            {
              localObject1[0] = arrayOfInt[i3];
              a(str, (int[])localObject1, 1);
            }
          }
          i3 += 4;
        }
        if (i1 != i2)
        {
          paramString = new StringBuilder();
          paramString.append("Failed rehash(): old count=");
          paramString.append(i2);
          paramString.append(", copyCount=");
          paramString.append(i1);
          throw new IllegalStateException(paramString.toString());
        }
      }
    }
    if (d) {
      paramString = e.y.c(paramString);
    }
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          i1 = a(paramArrayOfInt, paramInt);
          i3 = b(i1);
          localObject1 = f;
          localObject1[i3] = i1;
          i1 = n;
          i2 = i1 + paramInt;
          if (i2 > localObject1.length)
          {
            int i6 = localObject1.length;
            i5 = Math.min(4096, g);
            i4 = f.length;
            i2 = Math.max(i2 - i6, i5);
            f = Arrays.copyOf(f, i2 + i4);
          }
          System.arraycopy(paramArrayOfInt, 0, f, i1, paramInt);
          n += paramInt;
          paramArrayOfInt = f;
          paramArrayOfInt[(i3 + 1)] = i1;
          paramArrayOfInt[(i3 + 3)] = paramInt;
          paramInt = i3;
        }
        else
        {
          paramInt = b(a(paramArrayOfInt[0], paramArrayOfInt[1], paramArrayOfInt[2]));
          localObject1 = f;
          localObject1[paramInt] = paramArrayOfInt[0];
          localObject1[(paramInt + 1)] = paramArrayOfInt[1];
          localObject1[(paramInt + 2)] = paramArrayOfInt[2];
          localObject1[(paramInt + 3)] = 3;
        }
      }
      else
      {
        paramInt = b(a(paramArrayOfInt[0], paramArrayOfInt[1]));
        localObject1 = f;
        localObject1[paramInt] = paramArrayOfInt[0];
        localObject1[(paramInt + 1)] = paramArrayOfInt[1];
        localObject1[(paramInt + 3)] = 2;
      }
    }
    else
    {
      paramInt = paramArrayOfInt[0] ^ c;
      paramInt += (paramInt >>> 16);
      paramInt ^= paramInt << 3;
      paramInt = b(paramInt + (paramInt >>> 12));
      localObject1 = f;
      localObject1[paramInt] = paramArrayOfInt[0];
      localObject1[(paramInt + 3)] = 1;
    }
    l[(paramInt >> 2)] = paramString;
    k += 1;
    b();
    return paramString;
  }
  
  public final void a(boolean paramBoolean)
  {
    k = 0;
    m = a();
    n = (g << 3);
    if (paramBoolean)
    {
      Arrays.fill(f, 0);
      Arrays.fill(l, null);
    }
  }
  
  public final boolean a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = f;
    boolean bool = false;
    switch (paramInt1)
    {
    default: 
      break;
    case 8: 
      if (paramArrayOfInt[0] != arrayOfInt[paramInt2]) {
        return false;
      }
      paramInt2++;
      paramInt1 = 1;
      break;
    case 7: 
      paramInt1 = 0;
      i1 = paramInt1 + 1;
      if (paramArrayOfInt[paramInt1] != arrayOfInt[paramInt2]) {
        return false;
      }
      paramInt2++;
      paramInt1 = i1;
      break;
    case 6: 
      paramInt1 = 0;
      i1 = paramInt1 + 1;
      if (paramArrayOfInt[paramInt1] != arrayOfInt[paramInt2]) {
        return false;
      }
      paramInt2++;
      paramInt1 = i1;
      break;
    case 5: 
      paramInt1 = 0;
      i1 = paramInt1 + 1;
      if (paramArrayOfInt[paramInt1] != arrayOfInt[paramInt2]) {
        return false;
      }
      paramInt2++;
      paramInt1 = i1;
      break;
    }
    paramInt1 = 0;
    int i1 = paramInt1 + 1;
    int i2 = paramArrayOfInt[paramInt1];
    paramInt1 = paramInt2 + 1;
    if (i2 != arrayOfInt[paramInt2]) {
      return false;
    }
    paramInt2 = i1 + 1;
    i1 = paramArrayOfInt[i1];
    i2 = paramInt1 + 1;
    if (i1 != arrayOfInt[paramInt1]) {
      return false;
    }
    if (paramArrayOfInt[paramInt2] != arrayOfInt[i2]) {
      return false;
    }
    return paramArrayOfInt[(paramInt2 + 1)] == arrayOfInt[(i2 + 1)];
    i1 = 0;
    for (;;)
    {
      i2 = i1 + 1;
      if (paramArrayOfInt[i1] == f[paramInt2])
      {
        if (i2 >= paramInt1) {
          bool = true;
        }
      }
      else {
        return bool;
      }
      i1 = i2;
      paramInt2++;
    }
  }
  
  public final int b(int paramInt)
  {
    paramInt = (paramInt & g - 1) << 2;
    Object localObject = f;
    if (localObject[(paramInt + 3)] == 0) {
      return paramInt;
    }
    int i1 = h + (paramInt >> 3 << 2);
    if (localObject[(i1 + 3)] == 0) {
      return i1;
    }
    i1 = i;
    int i2 = j;
    i1 += (paramInt >> i2 + 2 << i2);
    for (paramInt = i1; paramInt < (1 << i2) + i1; paramInt += 4) {
      if (localObject[(paramInt + 3)] == 0) {
        return paramInt;
      }
    }
    i1 = m;
    paramInt = i1 + 4;
    m = paramInt;
    i2 = g;
    if (paramInt >= i2 << 3)
    {
      if ((e) && (i2 > 1024))
      {
        localObject = e.a.a.a.a.a("Spill-over slots in symbol table with ");
        ((StringBuilder)localObject).append(k);
        ((StringBuilder)localObject).append(" entries, hash area of ");
        ((StringBuilder)localObject).append(g);
        ((StringBuilder)localObject).append(" slots is now full (all ");
        ((StringBuilder)localObject).append(g >> 3);
        ((StringBuilder)localObject).append(" slots -- suspect a DoS attack based on hash collisions.");
        ((StringBuilder)localObject).append(" You can disable the check via `JsonFactory.Feature.FAIL_ON_SYMBOL_HASH_OVERFLOW`");
        throw new IllegalStateException(((StringBuilder)localObject).toString());
      }
      o = true;
    }
    return i1;
  }
  
  public String b(int paramInt1, int paramInt2)
  {
    int i1 = a(a(paramInt1, paramInt2));
    Object localObject1 = f;
    int i2 = localObject1[(i1 + 3)];
    Object localObject2 = null;
    if (i2 == 2)
    {
      if ((paramInt1 == localObject1[i1]) && (paramInt2 == localObject1[(i1 + 1)])) {
        return l[(i1 >> 2)];
      }
    }
    else if (i2 == 0) {
      return null;
    }
    i2 = h + (i1 >> 3 << 2);
    int i3 = localObject1[(i2 + 3)];
    if (i3 == 2)
    {
      if ((paramInt1 == localObject1[i2]) && (paramInt2 == localObject1[(i2 + 1)])) {
        return l[(i2 >> 2)];
      }
    }
    else if (i3 == 0) {
      return null;
    }
    i2 = i;
    i3 = j;
    i2 += (i1 >> i3 + 2 << i3);
    int[] arrayOfInt = f;
    for (i1 = i2; i1 < (1 << i3) + i2; i1 += 4)
    {
      int i4 = arrayOfInt[(i1 + 3)];
      if ((paramInt1 == arrayOfInt[i1]) && (paramInt2 == arrayOfInt[(i1 + 1)]) && (2 == i4))
      {
        localObject1 = l[(i1 >> 2)];
        break label305;
      }
      if (i4 == 0)
      {
        localObject1 = localObject2;
        break label305;
      }
    }
    for (i1 = a();; i1 += 4)
    {
      localObject1 = localObject2;
      if (i1 >= m) {
        break;
      }
      if ((paramInt1 == arrayOfInt[i1]) && (paramInt2 == arrayOfInt[(i1 + 1)]) && (2 == arrayOfInt[(i1 + 3)]))
      {
        localObject1 = l[(i1 >> 2)];
        break;
      }
    }
    label305:
    return (String)localObject1;
  }
  
  public String b(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = a(a(paramInt1, paramInt2, paramInt3));
    Object localObject1 = f;
    int i2 = localObject1[(i1 + 3)];
    Object localObject2 = null;
    if (i2 == 3)
    {
      if ((paramInt1 == localObject1[i1]) && (localObject1[(i1 + 1)] == paramInt2) && (localObject1[(i1 + 2)] == paramInt3)) {
        return l[(i1 >> 2)];
      }
    }
    else if (i2 == 0) {
      return null;
    }
    int i3 = h + (i1 >> 3 << 2);
    i2 = localObject1[(i3 + 3)];
    if (i2 == 3)
    {
      if ((paramInt1 == localObject1[i3]) && (localObject1[(i3 + 1)] == paramInt2) && (localObject1[(i3 + 2)] == paramInt3)) {
        return l[(i3 >> 2)];
      }
    }
    else if (i2 == 0) {
      return null;
    }
    i2 = i;
    i3 = j;
    i2 += (i1 >> i3 + 2 << i3);
    int[] arrayOfInt = f;
    for (i1 = i2; i1 < (1 << i3) + i2; i1 += 4)
    {
      int i4 = arrayOfInt[(i1 + 3)];
      if ((paramInt1 == arrayOfInt[i1]) && (paramInt2 == arrayOfInt[(i1 + 1)]) && (paramInt3 == arrayOfInt[(i1 + 2)]) && (3 == i4))
      {
        localObject1 = l[(i1 >> 2)];
        break label369;
      }
      if (i4 == 0)
      {
        localObject1 = localObject2;
        break label369;
      }
    }
    for (i1 = a();; i1 += 4)
    {
      localObject1 = localObject2;
      if (i1 >= m) {
        break;
      }
      if ((paramInt1 == arrayOfInt[i1]) && (paramInt2 == arrayOfInt[(i1 + 1)]) && (paramInt3 == arrayOfInt[(i1 + 2)]) && (3 == arrayOfInt[(i1 + 3)]))
      {
        localObject1 = l[(i1 >> 2)];
        break;
      }
    }
    label369:
    return (String)localObject1;
  }
  
  public String b(int[] paramArrayOfInt, int paramInt)
  {
    if (paramInt < 4)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return "";
          }
          return b(paramArrayOfInt[0], paramArrayOfInt[1], paramArrayOfInt[2]);
        }
        return b(paramArrayOfInt[0], paramArrayOfInt[1]);
      }
      return c(paramArrayOfInt[0]);
    }
    int i1 = a(paramArrayOfInt, paramInt);
    int i2 = a(i1);
    Object localObject1 = f;
    int i3 = localObject1[(i2 + 3)];
    if ((i1 == localObject1[i2]) && (i3 == paramInt) && (a(paramArrayOfInt, paramInt, localObject1[(i2 + 1)]))) {
      return l[(i2 >> 2)];
    }
    Object localObject2 = null;
    if (i3 == 0) {
      return null;
    }
    i3 = h + (i2 >> 3 << 2);
    int i4 = localObject1[(i3 + 3)];
    if ((i1 == localObject1[i3]) && (i4 == paramInt) && (a(paramArrayOfInt, paramInt, localObject1[(i3 + 1)]))) {
      return l[(i3 >> 2)];
    }
    i3 = i;
    i4 = j;
    i3 += (i2 >> i4 + 2 << i4);
    int[] arrayOfInt = f;
    for (i2 = i3; i2 < (1 << i4) + i3; i2 += 4)
    {
      int i5 = arrayOfInt[(i2 + 3)];
      if ((i1 == arrayOfInt[i2]) && (paramInt == i5) && (a(paramArrayOfInt, paramInt, arrayOfInt[(i2 + 1)])))
      {
        localObject1 = l[(i2 >> 2)];
        break label395;
      }
      if (i5 == 0)
      {
        localObject1 = localObject2;
        break label395;
      }
    }
    for (i2 = a();; i2 += 4)
    {
      localObject1 = localObject2;
      if (i2 >= m) {
        break;
      }
      if ((i1 == arrayOfInt[i2]) && (paramInt == arrayOfInt[(i2 + 3)]) && (a(paramArrayOfInt, paramInt, arrayOfInt[(i2 + 1)])))
      {
        localObject1 = l[(i2 >> 2)];
        break;
      }
    }
    label395:
    return (String)localObject1;
  }
  
  public final void b()
  {
    if (k > g >> 1)
    {
      int i1 = m;
      int i2 = a();
      int i3 = k;
      if ((i1 - i2 >> 2 > i3 + 1 >> 7) || (i3 > g * 0.8D)) {
        o = true;
      }
    }
  }
  
  public String c(int paramInt)
  {
    int i1 = c ^ paramInt;
    i1 += (i1 >>> 16);
    i1 ^= i1 << 3;
    i1 = a(i1 + (i1 >>> 12));
    Object localObject1 = f;
    int i2 = localObject1[(i1 + 3)];
    Object localObject2 = null;
    if (i2 == 1)
    {
      if (localObject1[i1] == paramInt) {
        return l[(i1 >> 2)];
      }
    }
    else if (i2 == 0) {
      return null;
    }
    i2 = h + (i1 >> 3 << 2);
    int i3 = localObject1[(i2 + 3)];
    if (i3 == 1)
    {
      if (localObject1[i2] == paramInt) {
        return l[(i2 >> 2)];
      }
    }
    else if (i3 == 0) {
      return null;
    }
    i2 = i;
    i3 = j;
    i2 += (i1 >> i3 + 2 << i3);
    int[] arrayOfInt = f;
    for (i1 = i2; i1 < (1 << i3) + i2; i1 += 4)
    {
      int i4 = arrayOfInt[(i1 + 3)];
      if ((paramInt == arrayOfInt[i1]) && (1 == i4)) {
        return l[(i1 >> 2)];
      }
      if (i4 == 0) {
        return (String)localObject2;
      }
    }
    for (i1 = a();; i1 += 4)
    {
      localObject1 = localObject2;
      if (i1 >= m) {
        break;
      }
      if ((paramInt == arrayOfInt[i1]) && (1 == arrayOfInt[(i1 + 3)]))
      {
        localObject1 = l[(i1 >> 2)];
        break;
      }
    }
    return (String)localObject1;
  }
  
  public String toString()
  {
    int i1 = h;
    int i2 = 3;
    for (int i3 = 0; i2 < i1; i3 = i4)
    {
      i4 = i3;
      if (f[i2] != 0) {
        i4 = i3 + 1;
      }
      i2 += 4;
    }
    i1 = h + 3;
    int i5 = i;
    for (i2 = 0; i1 < i5; i2 = i4)
    {
      i4 = i2;
      if (f[i1] != 0) {
        i4 = i2 + 1;
      }
      i1 += 4;
    }
    int i6 = i + 3;
    int i7 = g;
    i1 = 0;
    int i4 = i6;
    while (i4 < i7 + i6)
    {
      i5 = i1;
      if (f[i4] != 0) {
        i5 = i1 + 1;
      }
      i4 += 4;
      i1 = i5;
    }
    int i8 = m - a() >> 2;
    i7 = g;
    i4 = 3;
    for (i6 = 0; i4 < i7 << 3; i6 = i5)
    {
      i5 = i6;
      if (f[i4] != 0) {
        i5 = i6 + 1;
      }
      i4 += 4;
    }
    return String.format("[%s: size=%d, hashSize=%d, %d/%d/%d/%d pri/sec/ter/spill (=%s), total:%d]", new Object[] { a.class.getName(), Integer.valueOf(k), Integer.valueOf(g), Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i1), Integer.valueOf(i8), Integer.valueOf(i3 + i2 + i1 + i8), Integer.valueOf(i6) });
  }
}

/* Location:
 * Qualified Name:     base.e.b.a.a.r.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */