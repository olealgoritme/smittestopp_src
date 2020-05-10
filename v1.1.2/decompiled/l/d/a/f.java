package l.d.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

public class f
  extends Handler
  implements l
{
  public boolean A;
  public final k x;
  public final int y;
  public final c z;
  
  public f(c paramc, Looper paramLooper, int paramInt)
  {
    super(paramLooper);
    z = paramc;
    y = paramInt;
    x = new k();
  }
  
  public void a(q paramq, Object paramObject)
  {
    paramq = j.a(paramq, paramObject);
    try
    {
      x.a(paramq);
      if (!A)
      {
        A = true;
        if (!sendMessage(obtainMessage()))
        {
          paramq = new l/d/a/e;
          paramq.<init>("Could not send handler message");
          throw paramq;
        }
      }
      return;
    }
    finally {}
  }
  
  public void handleMessage(Message paramMessage)
  {
    try
    {
      long l = SystemClock.uptimeMillis();
      do
      {
        j localj = x.a();
        paramMessage = localj;
        if (localj == null) {
          try
          {
            paramMessage = x.a();
            if (paramMessage == null)
            {
              A = false;
              return;
            }
          }
          finally {}
        }
        z.a(paramMessage);
      } while (SystemClock.uptimeMillis() - l < y);
      boolean bool = sendMessage(obtainMessage());
      if (bool)
      {
        A = true;
        return;
      }
      paramMessage = new l/d/a/e;
      paramMessage.<init>("Could not send handler message");
      throw paramMessage;
    }
    finally
    {
      A = false;
    }
  }
}

/* Location:
 * Qualified Name:     l.d.a.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */