package d.i.f;

import android.os.Handler.Callback;
import android.os.Message;

public class c$a
  implements Handler.Callback
{
  public c$a(c paramc) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = what;
    if (i != 0)
    {
      if (i != 1) {
        return true;
      }
      a.a((Runnable)obj);
      return true;
    }
    a.a();
    return true;
  }
}

/* Location:
 * Qualified Name:     base.d.i.f.c.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */