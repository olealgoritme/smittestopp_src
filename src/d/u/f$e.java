package d.u;

import android.os.RemoteException;
import android.util.Log;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class f$e
  extends e.c
{
  public f$e(f paramf, String[] paramArrayOfString)
  {
    super(paramArrayOfString);
  }
  
  public void a(Set<String> paramSet)
  {
    if (b.i.get()) {
      return;
    }
    try
    {
      d locald = b.f;
      if (locald != null) {
        locald.a(b.c, (String[])paramSet.toArray(new String[0]));
      }
    }
    catch (RemoteException paramSet)
    {
      Log.w("ROOM", "Cannot broadcast invalidation", paramSet);
    }
  }
}

/* Location:
 * Qualified Name:     base.d.u.f.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */