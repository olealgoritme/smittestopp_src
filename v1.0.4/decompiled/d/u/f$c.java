package d.u;

import android.os.RemoteException;
import android.util.Log;

public class f$c
  implements Runnable
{
  public f$c(f paramf) {}
  
  public void run()
  {
    try
    {
      d locald = x.f;
      if (locald != null)
      {
        x.c = locald.a(x.h, x.b);
        x.d.a(x.e);
      }
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("ROOM", "Cannot register multi-instance invalidation callback", localRemoteException);
    }
  }
}

/* Location:
 * Qualified Name:     base.d.u.f.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */