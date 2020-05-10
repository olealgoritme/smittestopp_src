package k.b.i.b.g;

import k.b.a.o;

public final class m
{
  public final v a;
  public final int b;
  public final int c;
  public final int d;
  public final int e;
  public final int f;
  public final o g;
  
  public m(o paramo)
  {
    if (paramo != null)
    {
      g = paramo;
      paramo = f.a(paramo);
      Object localObject = paramo.a();
      if (((String)localObject).equals("SHAKE128")) {
        i = 32;
      } else if (((String)localObject).equals("SHAKE256")) {
        i = 64;
      } else {
        i = paramo.b();
      }
      b = i;
      c = 16;
      int i = (int)Math.ceil(i * 8 / k.b.c.e.a.d(16));
      e = i;
      i = (int)Math.floor(k.b.c.e.a.d((c - 1) * i) / k.b.c.e.a.d(c)) + 1;
      f = i;
      d = (e + i);
      localObject = l.b(paramo.a(), b, c, d);
      a = ((v)localObject);
      if (localObject != null) {
        return;
      }
      localObject = e.a.a.a.a.a("cannot find OID for digest algorithm: ");
      ((StringBuilder)localObject).append(paramo.a());
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    throw new NullPointerException("treeDigest == null");
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.b.g.m
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */