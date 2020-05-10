package e.c.a.a.f;

import com.google.android.gms.common.api.Scope;
import d.b.a.r;
import e.c.a.a.b.i.a.a;
import e.c.a.a.b.i.a.g;

public final class c
{
  public static final a.g<e.c.a.a.f.b.a> a = new a.g();
  public static final a.g<e.c.a.a.f.b.a> b = new a.g();
  public static final a.a<e.c.a.a.f.b.a, a> c = new d();
  public static final a.a<e.c.a.a.f.b.a, Object> d = new e();
  
  static
  {
    new Scope(1, "profile");
    new Scope(1, "email");
    Object localObject1 = c;
    Object localObject2 = a;
    r.b(localObject1, "Cannot construct an Api with a null ClientBuilder");
    r.b(localObject2, "Cannot construct an Api with a null ClientKey");
    localObject2 = d;
    localObject1 = b;
    r.b(localObject2, "Cannot construct an Api with a null ClientBuilder");
    r.b(localObject1, "Cannot construct an Api with a null ClientKey");
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.f.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */