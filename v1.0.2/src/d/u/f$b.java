package d.u;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.Executor;

public class f$b
  implements ServiceConnection
{
  public f$b(f paramf) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    a.f = d.a.a(paramIBinder);
    paramComponentName = a;
    g.execute(k);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    paramComponentName = a;
    g.execute(l);
    a.f = null;
  }
}

/* Location:
 * Qualified Name:     base.d.u.f.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */