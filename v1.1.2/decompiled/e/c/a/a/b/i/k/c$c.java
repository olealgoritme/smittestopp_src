package e.c.a.a.b.i.k;

import android.os.Handler;
import com.google.android.gms.common.api.Scope;
import e.c.a.a.b.a;
import e.c.a.a.b.i.a.f;
import e.c.a.a.b.j.b.c;
import e.c.a.a.b.j.k;
import java.util.Map;
import java.util.Set;

public final class c$c
  implements a0, b.c
{
  public final a.f a;
  public final h0<?> b;
  public k c = null;
  public Set<Scope> d = null;
  public boolean e = false;
  
  public c$c(a.f paramf, h0<?> paramh0)
  {
    a = paramh0;
    h0 localh0;
    b = localh0;
  }
  
  public final void a(a parama)
  {
    f.m.post(new s(this, parama));
  }
  
  public final void b(a parama)
  {
    c.a locala = (c.a)f.i.get(b);
    d.b.a.s.a(m.m);
    b.g();
    locala.a(parama);
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.b.i.k.c.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */