package k.b.a;

import e.a.a.a.a;

public abstract class i
  extends t
{
  public int A;
  public t B;
  public o x;
  public l y;
  public t z;
  
  public i(f paramf)
  {
    int i = 0;
    Object localObject1 = a(paramf, 0);
    Object localObject2 = localObject1;
    if ((localObject1 instanceof o))
    {
      x = ((o)localObject1);
      localObject2 = a(paramf, 1);
      i = 1;
    }
    int j = i;
    localObject1 = localObject2;
    if ((localObject2 instanceof l))
    {
      y = ((l)localObject2);
      j = i + 1;
      localObject1 = a(paramf, j);
    }
    i = j;
    localObject2 = localObject1;
    if (!(localObject1 instanceof b0))
    {
      z = ((t)localObject1);
      i = j + 1;
      localObject2 = a(paramf, i);
    }
    if (b == i + 1)
    {
      if ((localObject2 instanceof b0))
      {
        paramf = (b0)localObject2;
        a(x);
        B = paramf.j();
        return;
      }
      throw new IllegalArgumentException("No tagged object found in vector. Structure doesn't seem to be of type External");
    }
    throw new IllegalArgumentException("input vector too large");
  }
  
  public i(o paramo, l paraml, t paramt1, int paramInt, t paramt2)
  {
    x = paramo;
    y = paraml;
    z = paramt1;
    a(paramInt);
    if (paramt2 != null)
    {
      B = paramt2;
      return;
    }
    throw null;
  }
  
  public final t a(f paramf, int paramInt)
  {
    if (b > paramInt) {
      return paramf.a(paramInt).c();
    }
    throw new IllegalArgumentException("too few objects in input vector");
  }
  
  public final void a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 2))
    {
      A = paramInt;
      return;
    }
    throw new IllegalArgumentException(a.a("invalid encoding value: ", paramInt));
  }
  
  public boolean a(t paramt)
  {
    if (!(paramt instanceof i)) {
      return false;
    }
    if (this == paramt) {
      return true;
    }
    paramt = (i)paramt;
    Object localObject1 = x;
    if (localObject1 != null)
    {
      localObject2 = x;
      if ((localObject2 == null) || (!((t)localObject2).b((t)localObject1))) {
        return false;
      }
    }
    Object localObject2 = y;
    if (localObject2 != null)
    {
      localObject1 = y;
      if ((localObject1 == null) || (!((t)localObject1).b((t)localObject2))) {
        return false;
      }
    }
    localObject2 = z;
    if (localObject2 != null)
    {
      localObject1 = z;
      if ((localObject1 == null) || (!((t)localObject1).b((t)localObject2))) {
        return false;
      }
    }
    return B.b(B);
  }
  
  public int f()
  {
    return e().length;
  }
  
  public boolean g()
  {
    return true;
  }
  
  public t h()
  {
    return new s0(x, y, z, A, B);
  }
  
  public int hashCode()
  {
    Object localObject = x;
    if (localObject != null) {
      i = ((o)localObject).hashCode();
    } else {
      i = 0;
    }
    localObject = y;
    int j = i;
    if (localObject != null) {
      j = i ^ ((l)localObject).hashCode();
    }
    localObject = z;
    int i = j;
    if (localObject != null) {
      i = j ^ ((n)localObject).hashCode();
    }
    return i ^ B.hashCode();
  }
  
  public t i()
  {
    return new o1(x, y, z, A, B);
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */