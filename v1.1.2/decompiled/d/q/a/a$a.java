package d.q.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class a$a
  extends Handler
{
  public a$a(a parama, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (what != 1) {
      super.handleMessage(paramMessage);
    } else {
      a.a();
    }
  }
}

/* Location:
 * Qualified Name:     d.q.a.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */