package e.c.a.a.b.i.k;

import android.os.Looper;
import android.os.Message;
import d.b.a.s;
import e.c.a.a.d.a.c;

public final class f$c
  extends c
{
  public f$c(f paramf, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    int i = what;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    s.a(bool);
    Object localObject = a;
    paramMessage = (f.b)obj;
    localObject = b;
    if (localObject == null) {
      paramMessage.a();
    }
    try
    {
      paramMessage.a(localObject);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      paramMessage.a();
      throw localRuntimeException;
    }
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.b.i.k.f.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */