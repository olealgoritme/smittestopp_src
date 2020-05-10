package l.a.b.a.c;

public class e$a
  extends d0<Object[]>
  implements e.b
{
  public Object[] c;
  public r0 d;
  public int e;
  
  public e$a(e parame, x paramx, r paramr)
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
    return e + 4;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    j.a locala = f.c.a;
    if (locala != null)
    {
      int i = paramArrayOfByte.length * 1 + 5;
      a.a.b(i);
      a.a.c(i);
      x localx = a;
      i = paramArrayOfByte.length;
      a.c(i);
      locala.c();
      int j = paramArrayOfByte.length;
      for (i = 0; i < j; i++)
      {
        byte b = paramArrayOfByte[i];
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
      int i = paramArrayOfChar.length * 4 + 5;
      a.a.b(i);
      a.a.c(i);
      x localx = a;
      i = paramArrayOfChar.length;
      a.c(i);
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
      int i = paramArrayOfDouble.length * 8 + 5;
      a.a.b(i);
      a.a.c(i);
      x localx = a;
      i = paramArrayOfDouble.length;
      a.c(i);
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
      int i = paramArrayOfFloat.length * 4 + 5;
      a.a.b(i);
      a.a.c(i);
      x localx = a;
      i = paramArrayOfFloat.length;
      a.c(i);
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
    i = localb.a(null) * j + (i + 4);
    a.a.b(i);
    a.a.c(i);
    x localx = a;
    i = paramArrayOfInt.length;
    a.c(i);
    localb.c();
    j = paramArrayOfInt.length;
    for (i = 0; i < j; i++) {
      localb.a(paramArrayOfInt[i]);
    }
  }
  
  public void a(long[] paramArrayOfLong)
  {
    f0.b localb = f.c(paramArrayOfLong);
    int i = localb.d();
    int j = paramArrayOfLong.length;
    i = localb.a(null) * j + (i + 4);
    a.a.b(i);
    a.a.c(i);
    x localx = a;
    i = paramArrayOfLong.length;
    a.c(i);
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
      int i = paramArrayOfShort.length * 2 + 5;
      a.a.b(i);
      a.a.c(i);
      x localx = a;
      i = paramArrayOfShort.length;
      a.c(i);
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
    j = localb.a(null) * j + (i + 4);
    a.a.b(j);
    a.a.c(j);
    x localx = a;
    j = paramArrayOfBoolean.length;
    a.c(j);
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
    x localx = a;
    int i = arrayOfObject.length;
    a.c(i);
    ((r0)paramObject).c();
    int j = arrayOfObject.length;
    for (i = 0; i < j; i++) {
      ((r0)paramObject).b(arrayOfObject[i]);
    }
  }
  
  public void e(Object paramObject)
  {
    int i = a((Object[])paramObject);
    a.a.b(i);
    a.a.c(i);
  }
  
  public byte f()
  {
    return -16;
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
    localr.f();
    return e.a(localr, localr.f());
  }
  
  public Object i()
  {
    r localr = b;
    localr.f();
    int i = localr.f();
    return e.a(localr, localr.b(true), i);
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.e.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */