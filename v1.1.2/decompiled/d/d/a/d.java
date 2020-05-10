package d.d.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import c.a.a.b.a;

public abstract class d
  implements ServiceConnection
{
  public abstract void onCustomTabsServiceConnected(ComponentName paramComponentName, b paramb);
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    onCustomTabsServiceConnected(paramComponentName, new a(b.a.a(paramIBinder), paramComponentName));
  }
  
  public class a
    extends b
  {
    public a(c.a.a.b paramb, ComponentName paramComponentName)
    {
      super(paramComponentName);
    }
  }
}

/* Location:
 * Qualified Name:     d.d.a.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */