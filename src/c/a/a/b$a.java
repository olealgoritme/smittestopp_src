package c.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

public abstract class b$a
  extends Binder
  implements b
{
  public static b a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("android.support.customtabs.ICustomTabsService");
    if ((localIInterface != null) && ((localIInterface instanceof b))) {
      return (b)localIInterface;
    }
    return new b.a.a(paramIBinder);
  }
}

/* Location:
 * Qualified Name:     base.c.a.a.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */