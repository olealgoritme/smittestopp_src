package e.c.a.a.d.c;

import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;
import e.c.a.a.b.i.k.f;
import e.c.a.a.e.b;
import e.c.a.a.e.s;

public final class j
  extends s
{
  public final f<b> a;
  
  public j(f<b> paramf)
  {
    a = paramf;
  }
  
  public final void a(LocationAvailability paramLocationAvailability)
  {
    a.a(new l(paramLocationAvailability));
  }
  
  public final void a(LocationResult paramLocationResult)
  {
    a.a(new k(paramLocationResult));
  }
  
  public final void c()
  {
    try
    {
      a.b = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.d.c.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */