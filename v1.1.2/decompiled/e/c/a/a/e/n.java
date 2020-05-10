package e.c.a.a.e;

import com.google.android.gms.common.api.Status;
import e.c.a.a.b.i.g;
import e.c.a.a.d.c.e;
import e.c.a.a.g.h;

public final class n
  extends e
{
  public n(e.c.a.a.g.b paramb) {}
  
  public final void a(e.c.a.a.d.c.b paramb)
  {
    paramb = x;
    if (paramb == null)
    {
      paramb = a;
      localObject = new e.c.a.a.b.i.b(new Status(8, "Got null status from location service"));
      a.b((Exception)localObject);
      return;
    }
    int i = y;
    int j = 1;
    if (i == 0)
    {
      a.a.a(Boolean.valueOf(true));
      return;
    }
    Object localObject = a;
    if (A == null) {
      j = 0;
    }
    if (j != 0) {
      paramb = new g(paramb);
    } else {
      paramb = new e.c.a.a.b.i.b(paramb);
    }
    a.b(paramb);
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.e.n
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */