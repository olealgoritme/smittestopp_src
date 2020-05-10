package k.e.a;

import e.a.a.a.a;

public class q
{
  public static final q n = new q();
  public short a;
  public short b;
  public int[] c;
  public int d;
  public int[] e;
  public short f;
  public short g;
  public short h;
  public short i;
  public n j;
  public q k;
  public k l;
  public q m;
  
  public final q a()
  {
    Object localObject = j;
    if (localObject == null) {
      localObject = this;
    } else {
      localObject = a;
    }
    return (q)localObject;
  }
  
  public final q a(q paramq)
  {
    Object localObject1 = l;
    Object localObject2 = paramq;
    paramq = (q)localObject1;
    while (paramq != null)
    {
      int i1;
      if (((a & 0x10) != 0) && (paramq == l.c)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      localObject1 = localObject2;
      if (i1 == 0)
      {
        q localq = b;
        localObject1 = localObject2;
        if (m == null)
        {
          m = ((q)localObject2);
          localObject1 = localq;
        }
      }
      paramq = c;
      localObject2 = localObject1;
    }
    return (q)localObject2;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (e == null) {
      e = new int[6];
    }
    int[] arrayOfInt1 = e;
    int i1 = arrayOfInt1[0];
    if (i1 + 2 >= arrayOfInt1.length)
    {
      int[] arrayOfInt2 = new int[arrayOfInt1.length + 6];
      System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, arrayOfInt1.length);
      e = arrayOfInt2;
    }
    arrayOfInt1 = e;
    i1++;
    arrayOfInt1[i1] = paramInt1;
    paramInt1 = i1 + 1;
    arrayOfInt1[paramInt1] = (paramInt2 | paramInt3);
    arrayOfInt1[0] = paramInt1;
  }
  
  public final void a(c paramc, int paramInt, boolean paramBoolean)
  {
    if ((a & 0x4) == 0)
    {
      if (paramBoolean)
      {
        a(paramInt, 536870912, b);
        paramc.c(-1);
      }
      else
      {
        a(paramInt, 268435456, b);
        paramc.d(-1);
      }
    }
    else if (paramBoolean) {
      paramc.c(d - paramInt);
    } else {
      paramc.d(d - paramInt);
    }
  }
  
  public final void a(short paramShort)
  {
    m = n;
    Object localObject = this;
    while (localObject != n)
    {
      q localq = m;
      m = null;
      if (i == 0)
      {
        i = ((short)paramShort);
        localObject = ((q)localObject).a(localq);
      }
      else
      {
        localObject = localq;
      }
    }
  }
  
  public final boolean a(byte[] paramArrayOfByte, int paramInt)
  {
    a = ((short)(short)(a | 0x4));
    d = paramInt;
    int[] arrayOfInt = e;
    boolean bool = false;
    if (arrayOfInt == null) {
      return false;
    }
    for (int i1 = arrayOfInt[0]; i1 > 0; i1 -= 2)
    {
      arrayOfInt = e;
      int i2 = arrayOfInt[(i1 - 1)];
      int i3 = arrayOfInt[i1];
      int i4 = paramInt - i2;
      int i5 = 0xFFFFFFF & i3;
      if ((i3 & 0xF0000000) == 268435456)
      {
        if ((i4 < 32768) || (i4 > 32767))
        {
          i3 = paramArrayOfByte[i2] & 0xFF;
          if (i3 < 198) {
            paramArrayOfByte[i2] = ((byte)(byte)(i3 + 49));
          } else {
            paramArrayOfByte[i2] = ((byte)(byte)(i3 + 20));
          }
          bool = true;
        }
        paramArrayOfByte[i5] = ((byte)(byte)(i4 >>> 8));
        paramArrayOfByte[(i5 + 1)] = ((byte)(byte)i4);
      }
      else
      {
        i2 = i5 + 1;
        paramArrayOfByte[i5] = ((byte)(byte)(i4 >>> 24));
        i5 = i2 + 1;
        paramArrayOfByte[i2] = ((byte)(byte)(i4 >>> 16));
        paramArrayOfByte[i5] = ((byte)(byte)(i4 >>> 8));
        paramArrayOfByte[(i5 + 1)] = ((byte)(byte)i4);
      }
    }
    return bool;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = a.a("L");
    localStringBuilder.append(System.identityHashCode(this));
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.k.e.a.q
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */