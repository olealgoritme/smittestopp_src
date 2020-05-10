package l.a.b.a.c;

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
      a.a.b(i);
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
      a.a.b(i);
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
        a.a.c(k & 0xFFFF);
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
      a.a.b(i);
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
      a.a.b(i);
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
    j = localb.a(null) * j + (i + 1);
    a.a.b(j);
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
    i = localb.a(null) * j + (i + 1);
    a.a.b(i);
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
      a.a.b(i);
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
    j = localb.a(null) * j + (i + 1);
    a.a.b(j);
    x localx = a;
    byte b = (byte)j;
    a.a(b);
    localx = a;
    b = (byte)paramArrayOfBoolean.length;
    a.a(b);
    localb.c();
    i = paramArrayOfBoolean.length;
    for (j = 0; j < i; j++) {
      localb.a(paramArrayOfBoolean[j]);
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
      localObject1 = arrayOfObject[j];
      if ((localObject1.getClass().isArray()) && (localObject1.getClass().getComponentType().isPrimitive()))
      {
        e.b localb = (e.b)paramObject;
        Object localObject2 = (e)localb.getType();
        localObject2 = localObject1.getClass().getComponentType();
        if (localObject2 == Boolean.TYPE)
        {
          localb.a((boolean[])localObject1);
        }
        else if (localObject2 == Byte.TYPE)
        {
          localb.a((byte[])localObject1);
        }
        else if (localObject2 == Short.TYPE)
        {
          localb.a((short[])localObject1);
        }
        else if (localObject2 == Integer.TYPE)
        {
          localb.a((int[])localObject1);
        }
        else if (localObject2 == Long.TYPE)
        {
          localb.a((long[])localObject1);
        }
        else if (localObject2 == Float.TYPE)
        {
          localb.a((float[])localObject1);
        }
        else if (localObject2 == Double.TYPE)
        {
          localb.a((double[])localObject1);
        }
        else if (localObject2 == Character.TYPE)
        {
          localb.a((char[])localObject1);
        }
        else
        {
          paramObject = e.a.a.a.a.a("Cannot encode arrays of type ");
          ((StringBuilder)paramObject).append(((Class)localObject2).getName());
          throw new IllegalArgumentException(((StringBuilder)paramObject).toString());
        }
      }
      else
      {
        ((r0)paramObject).b(localObject1);
      }
    }
  }
  
  public void e(Object paramObject)
  {
    int i = a((Object[])paramObject);
    a.a.b(i);
    paramObject = a;
    byte b = (byte)i;
    a.a(b);
  }
  
  public byte f()
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
  
  public Object h()
  {
    r localr = b;
    localr.e();
    return e.a(localr, localr.e() & 0xFF);
  }
  
  public Object i()
  {
    r localr = b;
    localr.e();
    int i = localr.e();
    return e.a(localr, localr.b(true), i & 0xFF);
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.e.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */