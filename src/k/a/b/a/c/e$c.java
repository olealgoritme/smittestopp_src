package k.a.b.a.c;

public class e$c
  extends m0<Object[]>
  implements e.b
{
  public Object[] c;
  public r0 d;
  public int e;
  
  public e$c(e parame, x paramx, r paramr)
  {
    super(paramx, paramr);
  }
  
  public int a(Object[] paramArrayOfObject)
  {
    if (c != paramArrayOfObject)
    {
      c = paramArrayOfObject;
      r0 localr0 = e.a(paramArrayOfObject, a);
      d = localr0;
      e = e.a(paramArrayOfObject, localr0);
    }
    return e + 1;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    j.a locala = f.c.a;
    if (locala != null)
    {
      int i = paramArrayOfByte.length * 1 + 2;
      a.a.c(i);
      x localx = a;
      byte b = (byte)i;
      a.a(b);
      localx = a;
      b = (byte)paramArrayOfByte.length;
      a.a(b);
      locala.c();
      int j = paramArrayOfByte.length;
      for (i = 0; i < j; i++)
      {
        b = paramArrayOfByte[i];
        a.a.a(b);
      }
      return;
    }
    throw null;
  }
  
  public void a(char[] paramArrayOfChar)
  {
    k.a locala = f.i.a;
    if (locala != null)
    {
      int i = paramArrayOfChar.length * 4 + 2;
      a.a.c(i);
      x localx = a;
      byte b = (byte)i;
      a.a(b);
      localx = a;
      b = (byte)paramArrayOfChar.length;
      a.a(b);
      locala.c();
      int j = paramArrayOfChar.length;
      for (i = 0; i < j; i++)
      {
        int k = paramArrayOfChar[i];
        a.a.b(k & 0xFFFF);
      }
      return;
    }
    throw null;
  }
  
  public void a(double[] paramArrayOfDouble)
  {
    t.a locala = f.h.a;
    if (locala != null)
    {
      int i = paramArrayOfDouble.length * 8 + 2;
      a.a.c(i);
      x localx = a;
      byte b = (byte)i;
      a.a(b);
      localx = a;
      b = (byte)paramArrayOfDouble.length;
      a.a(b);
      locala.c();
      int j = paramArrayOfDouble.length;
      for (i = 0; i < j; i++)
      {
        double d1 = paramArrayOfDouble[i];
        a.a.a(d1);
      }
      return;
    }
    throw null;
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    a0.a locala = f.g.a;
    if (locala != null)
    {
      int i = paramArrayOfFloat.length * 4 + 2;
      a.a.c(i);
      x localx = a;
      byte b = (byte)i;
      a.a(b);
      localx = a;
      b = (byte)paramArrayOfFloat.length;
      a.a(b);
      locala.c();
      int j = paramArrayOfFloat.length;
      for (i = 0; i < j; i++)
      {
        float f1 = paramArrayOfFloat[i];
        a.a.a(f1);
      }
      return;
    }
    throw null;
  }
  
  public void a(int[] paramArrayOfInt)
  {
    c0.b localb = f.c(paramArrayOfInt);
    int i = localb.d();
    int j = paramArrayOfInt.length;
    j = localb.b(null) * j + (i + 1);
    a.a.c(j);
    x localx = a;
    byte b = (byte)j;
    a.a(b);
    localx = a;
    b = (byte)paramArrayOfInt.length;
    a.a(b);
    localb.c();
    i = paramArrayOfInt.length;
    for (j = 0; j < i; j++) {
      localb.a(paramArrayOfInt[j]);
    }
  }
  
  public void a(long[] paramArrayOfLong)
  {
    f0.b localb = f.c(paramArrayOfLong);
    int i = localb.d();
    int j = paramArrayOfLong.length;
    i = localb.b(null) * j + (i + 1);
    a.a.c(i);
    x localx = a;
    byte b = (byte)i;
    a.a(b);
    localx = a;
    b = (byte)paramArrayOfLong.length;
    a.a(b);
    localb.c();
    j = paramArrayOfLong.length;
    for (i = 0; i < j; i++) {
      localb.a(paramArrayOfLong[i]);
    }
  }
  
  public void a(Object[] paramArrayOfObject, r0 paramr0, int paramInt)
  {
    c = paramArrayOfObject;
    d = paramr0;
    e = paramInt;
  }
  
  public void a(short[] paramArrayOfShort)
  {
    l0.a locala = f.d.a;
    if (locala != null)
    {
      int i = paramArrayOfShort.length * 2 + 2;
      a.a.c(i);
      x localx = a;
      byte b = (byte)i;
      a.a(b);
      localx = a;
      b = (byte)paramArrayOfShort.length;
      a.a(b);
      locala.c();
      int j = paramArrayOfShort.length;
      for (i = 0; i < j; i++)
      {
        short s = paramArrayOfShort[i];
        a.a.a(s);
      }
      return;
    }
    throw null;
  }
  
  public void a(boolean[] paramArrayOfBoolean)
  {
    h.b localb = f.b(paramArrayOfBoolean);
    int i = localb.d();
    int j = paramArrayOfBoolean.length;
    i = localb.b(null) * j + (i + 1);
    a.a.c(i);
    x localx = a;
    byte b = (byte)i;
    a.a(b);
    localx = a;
    b = (byte)paramArrayOfBoolean.length;
    a.a(b);
    localb.c();
    j = paramArrayOfBoolean.length;
    for (i = 0; i < j; i++) {
      localb.a(paramArrayOfBoolean[i]);
    }
  }
  
  public boolean a(r0<Object[]> paramr0)
  {
    boolean bool;
    if (f == paramr0.getType()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void d(Object paramObject)
  {
    Object[] arrayOfObject = (Object[])paramObject;
    if (c != arrayOfObject)
    {
      c = arrayOfObject;
      paramObject = e.b(arrayOfObject, a);
      d = ((r0)paramObject);
      e = e.a(arrayOfObject, (r0)paramObject);
    }
    else
    {
      paramObject = d;
    }
    Object localObject1 = a;
    byte b = (byte)arrayOfObject.length;
    a.a(b);
    ((r0)paramObject).c();
    int i = arrayOfObject.length;
    for (int j = 0; j < i; j++)
    {
      Object localObject2 = arrayOfObject[j];
      if ((localObject2.getClass().isArray()) && (localObject2.getClass().getComponentType().isPrimitive()))
      {
        e.b localb = (e.b)paramObject;
        localObject1 = (e)localb.getType();
        localObject1 = localObject2.getClass().getComponentType();
        if (localObject1 == Boolean.TYPE)
        {
          localb.a((boolean[])localObject2);
        }
        else if (localObject1 == Byte.TYPE)
        {
          localb.a((byte[])localObject2);
        }
        else if (localObject1 == Short.TYPE)
        {
          localb.a((short[])localObject2);
        }
        else if (localObject1 == Integer.TYPE)
        {
          localb.a((int[])localObject2);
        }
        else if (localObject1 == Long.TYPE)
        {
          localb.a((long[])localObject2);
        }
        else if (localObject1 == Float.TYPE)
        {
          localb.a((float[])localObject2);
        }
        else if (localObject1 == Double.TYPE)
        {
          localb.a((double[])localObject2);
        }
        else if (localObject1 == Character.TYPE)
        {
          localb.a((char[])localObject2);
        }
        else
        {
          paramObject = e.a.a.a.a.a("Cannot encode arrays of type ");
          ((StringBuilder)paramObject).append(((Class)localObject1).getName());
          throw new IllegalArgumentException(((StringBuilder)paramObject).toString());
        }
      }
      else
      {
        ((r0)paramObject).a(localObject2);
      }
    }
  }
  
  public void e(Object paramObject)
  {
    int i = a((Object[])paramObject);
    a.a.c(i);
    paramObject = a;
    byte b = (byte)i;
    a.a(b);
  }
  
  public byte g()
  {
    return -32;
  }
  
  public a getType()
  {
    return f;
  }
  
  public i0 getType()
  {
    return f;
  }
  
  public Object j()
  {
    r localr = b;
    localr.e();
    return e.a(localr, localr.e() & 0xFF);
  }
  
  public Object k()
  {
    r localr = b;
    localr.e();
    int i = localr.e();
    return e.a(localr, localr.b(true), i & 0xFF);
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.e.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */