package e.b.a.a.q;

import e.b.a.a.e;
import e.b.a.a.f.a;
import e.b.a.a.k;
import e.b.a.a.n;
import e.b.a.a.p.b;
import e.b.a.a.s.d;

public abstract class c
  extends e.b.a.a.o.a
{
  public static final int[] F = e.b.a.a.p.a.h;
  public final b A;
  public int[] B = F;
  public int C;
  public n D = d.x;
  public boolean E;
  
  public c(b paramb, int paramInt)
  {
    super(paramInt);
    A = paramb;
    if (f.a.ESCAPE_NON_ASCII.enabledIn(paramInt)) {
      C = 127;
    }
    E = (f.a.QUOTE_FIELD_NAMES.enabledIn(paramInt) ^ true);
  }
  
  public void c(String paramString)
  {
    throw new e(String.format("Can not %s, expecting field name (context: %s)", new Object[] { paramString, z.e() }), this);
  }
}

/* Location:
 * Qualified Name:     e.b.a.a.q.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */