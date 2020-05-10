package d.t.a;

public class b$a
{
  public long a = 0L;
  public a b;
  
  public final void a()
  {
    if (b == null) {
      b = new a();
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= 64)
    {
      a locala = b;
      if (locala != null) {
        locala.a(paramInt - 64);
      }
    }
    else
    {
      a &= 1L << paramInt;
    }
  }
  
  public int b(int paramInt)
  {
    a locala = b;
    if (locala == null)
    {
      if (paramInt >= 64) {
        return Long.bitCount(a);
      }
      return Long.bitCount(a & (1L << paramInt) - 1L);
    }
    if (paramInt < 64) {
      return Long.bitCount(a & (1L << paramInt) - 1L);
    }
    paramInt = locala.b(paramInt - 64);
    return Long.bitCount(a) + paramInt;
  }
  
  public void b()
  {
    a = 0L;
    a locala = b;
    if (locala != null) {
      locala.b();
    }
  }
  
  public boolean c(int paramInt)
  {
    if (paramInt >= 64)
    {
      a();
      return b.c(paramInt - 64);
    }
    boolean bool;
    if ((a & 1L << paramInt) != 0L) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean d(int paramInt)
  {
    if (paramInt >= 64)
    {
      a();
      return b.d(paramInt - 64);
    }
    long l1 = 1L << paramInt;
    boolean bool;
    if ((a & l1) != 0L) {
      bool = true;
    } else {
      bool = false;
    }
    long l2 = a & l1;
    a = l2;
    l1 -= 1L;
    a = (l2 & l1 | Long.rotateRight(l1 & l2, 1));
    a locala = b;
    if (locala != null)
    {
      if (locala.c(0)) {
        e(63);
      }
      b.d(0);
    }
    return bool;
  }
  
  public void e(int paramInt)
  {
    if (paramInt >= 64)
    {
      a();
      b.e(paramInt - 64);
    }
    else
    {
      a |= 1L << paramInt;
    }
  }
  
  public String toString()
  {
    Object localObject;
    if (b == null)
    {
      localObject = Long.toBinaryString(a);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(b.toString());
      ((StringBuilder)localObject).append("xx");
      ((StringBuilder)localObject).append(Long.toBinaryString(a));
      localObject = ((StringBuilder)localObject).toString();
    }
    return (String)localObject;
  }
}

/* Location:
 * Qualified Name:     d.t.a.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */