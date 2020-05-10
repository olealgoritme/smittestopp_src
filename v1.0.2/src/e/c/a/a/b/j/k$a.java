package e.c.a.a.b.j;

import android.os.IBinder;
import android.os.IInterface;
import e.c.a.a.d.b.b;

public abstract class k$a
  extends b
  implements k
{
  public static k a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
    if ((localIInterface instanceof k)) {
      return (k)localIInterface;
    }
    return new k.a.a(paramIBinder);
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.b.j.k.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */