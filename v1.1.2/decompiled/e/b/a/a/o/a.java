package e.b.a.a.o;

import e.b.a.a.f;
import e.b.a.a.f.a;
import e.b.a.a.q.b;
import e.b.a.a.q.e;

public abstract class a
  extends f
{
  public int x;
  public boolean y;
  public e z;
  
  static
  {
    f.a.WRITE_NUMBERS_AS_STRINGS.getMask();
    f.a.ESCAPE_NON_ASCII.getMask();
    f.a.STRICT_DUPLICATE_DETECTION.getMask();
  }
  
  public a(int paramInt)
  {
    x = paramInt;
    b localb;
    if (f.a.STRICT_DUPLICATE_DETECTION.enabledIn(paramInt)) {
      localb = new b(this);
    } else {
      localb = null;
    }
    z = new e(0, null, localb);
    y = f.a.WRITE_NUMBERS_AS_STRINGS.enabledIn(paramInt);
  }
  
  public final boolean a(f.a parama)
  {
    int i = x;
    boolean bool;
    if ((parama.getMask() & i) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void close() {}
}

/* Location:
 * Qualified Name:     e.b.a.a.o.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */