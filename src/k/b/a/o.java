package k.b.a;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class o
  extends t
{
  public static final ConcurrentMap<o.a, o> z = new ConcurrentHashMap();
  public final String x;
  public byte[] y;
  
  public o(String paramString)
  {
    if (paramString != null)
    {
      int i = paramString.length();
      boolean bool1 = false;
      boolean bool2 = bool1;
      if (i >= 3) {
        if (paramString.charAt(1) != '.')
        {
          bool2 = bool1;
        }
        else
        {
          i = paramString.charAt(0);
          bool2 = bool1;
          if (i >= 48) {
            if (i > 50) {
              bool2 = bool1;
            } else {
              bool2 = a(paramString, 2);
            }
          }
        }
      }
      if (bool2)
      {
        x = paramString;
        return;
      }
      throw new IllegalArgumentException(e.a.a.a.a.a("string ", paramString, " not an OID"));
    }
    throw new NullPointerException("'identifier' cannot be null");
  }
  
  public o(o paramo, String paramString)
  {
    if (a(paramString, 0))
    {
      x = e.a.a.a.a.a(new StringBuilder(), x, ".", paramString);
      return;
    }
    throw new IllegalArgumentException(e.a.a.a.a.a("string ", paramString, " not a valid OID branch"));
  }
  
  public o(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 1;
    long l1 = 0L;
    int j = 0;
    Object localObject1 = null;
    while (j != paramArrayOfByte.length)
    {
      int k = paramArrayOfByte[j] & 0xFF;
      if (l1 <= 72057594037927808L)
      {
        long l2 = l1 + (k & 0x7F);
        if ((k & 0x80) == 0)
        {
          k = i;
          l1 = l2;
          if (i != 0)
          {
            if (l2 < 40L)
            {
              localStringBuffer.append('0');
              l1 = l2;
            }
            else if (l2 < 80L)
            {
              localStringBuffer.append('1');
              l1 = l2 - 40L;
            }
            else
            {
              localStringBuffer.append('2');
              l1 = l2 - 80L;
            }
            k = 0;
          }
          localStringBuffer.append('.');
          localStringBuffer.append(l1);
          l1 = 0L;
          i = k;
        }
        else
        {
          l1 = l2 << 7;
        }
      }
      else
      {
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = BigInteger.valueOf(l1);
        }
        localObject2 = ((BigInteger)localObject2).or(BigInteger.valueOf(k & 0x7F));
        if ((k & 0x80) == 0)
        {
          k = i;
          localObject1 = localObject2;
          if (i != 0)
          {
            localStringBuffer.append('2');
            localObject1 = ((BigInteger)localObject2).subtract(BigInteger.valueOf(80L));
            k = 0;
          }
          localStringBuffer.append('.');
          localStringBuffer.append(localObject1);
          l1 = 0L;
          localObject1 = null;
          i = k;
        }
        else
        {
          localObject1 = ((BigInteger)localObject2).shiftLeft(7);
        }
      }
      j++;
    }
    x = localStringBuffer.toString();
    y = k.b.c.e.a.a(paramArrayOfByte);
  }
  
  public static o a(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof o)))
    {
      Object localObject;
      if ((paramObject instanceof e))
      {
        localObject = ((e)paramObject).c();
        if ((localObject instanceof o)) {
          return (o)localObject;
        }
      }
      if ((paramObject instanceof byte[]))
      {
        paramObject = (byte[])paramObject;
        try
        {
          paramObject = (o)t.a((byte[])paramObject);
          return (o)paramObject;
        }
        catch (IOException paramObject)
        {
          localObject = e.a.a.a.a.a("failed to construct object identifier from byte[]: ");
          ((StringBuilder)localObject).append(((IOException)paramObject).getMessage());
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      throw new IllegalArgumentException(e.a.a.a.a.a(paramObject, e.a.a.a.a.a("illegal object in getInstance: ")));
    }
    return (o)paramObject;
  }
  
  public static o a(b0 paramb0, boolean paramBoolean)
  {
    paramb0 = paramb0.j();
    if ((!paramBoolean) && (!(paramb0 instanceof o)))
    {
      byte[] arrayOfByte = p.a(paramb0).j();
      paramb0 = new o.a(arrayOfByte);
      o localo = (o)z.get(paramb0);
      paramb0 = localo;
      if (localo == null) {
        paramb0 = new o(arrayOfByte);
      }
      return paramb0;
    }
    return a(paramb0);
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    int i = paramString.length();
    int j = 0;
    int k;
    for (;;)
    {
      k = i - 1;
      if (k < paramInt) {
        break label84;
      }
      i = paramString.charAt(k);
      if (i == 46)
      {
        if (j != 0)
        {
          i = k;
          if (j <= 1) {
            break;
          }
          i = k;
          if (paramString.charAt(k + 1) != '0') {
            break;
          }
        }
        return false;
      }
      if ((48 > i) || (i > 57)) {
        break label82;
      }
      j++;
      i = k;
    }
    label82:
    return false;
    label84:
    return (j != 0) && ((j <= 1) || (paramString.charAt(k + 1) != '0'));
  }
  
  public static o b(byte[] paramArrayOfByte)
  {
    Object localObject = new o.a(paramArrayOfByte);
    o localo = (o)z.get(localObject);
    localObject = localo;
    if (localo == null) {
      localObject = new o(paramArrayOfByte);
    }
    return (o)localObject;
  }
  
  public final void a(ByteArrayOutputStream paramByteArrayOutputStream)
  {
    c2 localc2 = new c2(x);
    int i = Integer.parseInt(localc2.a()) * 40;
    String str = localc2.a();
    long l;
    if (str.length() <= 18)
    {
      l = i;
      l = Long.parseLong(str) + l;
      a(paramByteArrayOutputStream, l);
    }
    else
    {
      a(paramByteArrayOutputStream, new BigInteger(str).add(BigInteger.valueOf(i)));
    }
    for (;;)
    {
      if (b != -1) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        return;
      }
      str = localc2.a();
      if (str.length() <= 18)
      {
        l = Long.parseLong(str);
        break;
      }
      a(paramByteArrayOutputStream, new BigInteger(str));
    }
  }
  
  public final void a(ByteArrayOutputStream paramByteArrayOutputStream, long paramLong)
  {
    byte[] arrayOfByte = new byte[9];
    int i = (byte)((int)paramLong & 0x7F);
    int j = 8;
    arrayOfByte[8] = ((byte)i);
    while (paramLong >= 128L)
    {
      paramLong >>= 7;
      j--;
      arrayOfByte[j] = ((byte)(byte)((int)paramLong & 0x7F | 0x80));
    }
    paramByteArrayOutputStream.write(arrayOfByte, j, 9 - j);
  }
  
  public final void a(ByteArrayOutputStream paramByteArrayOutputStream, BigInteger paramBigInteger)
  {
    int i = (paramBigInteger.bitLength() + 6) / 7;
    if (i == 0)
    {
      paramByteArrayOutputStream.write(0);
    }
    else
    {
      byte[] arrayOfByte = new byte[i];
      int j = i - 1;
      for (int k = j; k >= 0; k--)
      {
        arrayOfByte[k] = ((byte)(byte)(paramBigInteger.intValue() & 0x7F | 0x80));
        paramBigInteger = paramBigInteger.shiftRight(7);
      }
      arrayOfByte[j] = ((byte)(byte)(arrayOfByte[j] & 0x7F));
      paramByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  public void a(r paramr, boolean paramBoolean)
  {
    paramr.a(paramBoolean, 6, j());
  }
  
  public boolean a(t paramt)
  {
    if (paramt == this) {
      return true;
    }
    if (!(paramt instanceof o)) {
      return false;
    }
    return x.equals(x);
  }
  
  public int f()
  {
    int i = j().length;
    return d2.a(i) + 1 + i;
  }
  
  public boolean g()
  {
    return false;
  }
  
  public int hashCode()
  {
    return x.hashCode();
  }
  
  public final byte[] j()
  {
    try
    {
      if (y == null)
      {
        localObject1 = new java/io/ByteArrayOutputStream;
        ((ByteArrayOutputStream)localObject1).<init>();
        a((ByteArrayOutputStream)localObject1);
        y = ((ByteArrayOutputStream)localObject1).toByteArray();
      }
      Object localObject1 = y;
      return (byte[])localObject1;
    }
    finally {}
  }
  
  public o k()
  {
    o.a locala = new o.a(j());
    o localo1 = (o)z.get(locala);
    o localo2 = localo1;
    if (localo1 == null)
    {
      localo1 = (o)z.putIfAbsent(locala, this);
      localo2 = localo1;
      if (localo1 == null) {
        localo2 = this;
      }
    }
    return localo2;
  }
  
  public String toString()
  {
    return x;
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.o
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */