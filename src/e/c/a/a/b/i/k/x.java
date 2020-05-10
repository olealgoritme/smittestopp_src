package e.c.a.a.b.i.k;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.google.android.gms.common.api.Scope;
import d.b.a.r;
import e.c.a.a.b.i.a.a;
import e.c.a.a.b.i.a.f;
import e.c.a.a.b.i.d.a;
import e.c.a.a.b.i.d.b;
import e.c.a.a.f.b.k;
import e.c.a.a.f.c;
import e.c.a.a.f.f;
import java.util.Set;

public final class x
  extends e.c.a.a.f.b.d
  implements d.a, d.b
{
  public static a.a<? extends f, e.c.a.a.f.a> h = c.c;
  public final Context a;
  public final Handler b;
  public final a.a<? extends f, e.c.a.a.f.a> c;
  public Set<Scope> d;
  public e.c.a.a.b.j.d e;
  public f f;
  public a0 g;
  
  public x(Context paramContext, Handler paramHandler, e.c.a.a.b.j.d paramd)
  {
    a = paramContext;
    b = paramHandler;
    r.b(paramd, "ClientSettings must not be null");
    e = paramd;
    d = b;
    c = locala;
  }
  
  public final void a(int paramInt)
  {
    f.e();
  }
  
  public final void a(Bundle paramBundle)
  {
    f.a(this);
  }
  
  public final void a(e.c.a.a.b.a parama)
  {
    ((c.c)g).b(parama);
  }
  
  public final void a(k paramk)
  {
    b.post(new z(this, paramk));
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.b.i.k.x
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */