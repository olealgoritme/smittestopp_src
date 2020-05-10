package k.b.a.u;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.microsoft.appcenter.crashes.Crashes;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import m.a.a.b;

@SuppressLint({"HandlerLeak"})
public final class i$a
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage != null)
    {
      super.handleMessage(paramMessage);
      int i = what;
      Object localObject;
      if (i != 3)
      {
        if (i == 4)
        {
          m.a.a.d.b("MSG_RESTART", new Object[0]);
          try
          {
            paramMessage = new java/lang/StringBuilder;
            paramMessage.<init>();
            paramMessage.append(a.b);
            paramMessage.append(' ');
            paramMessage.append(a.a);
            paramMessage = paramMessage.toString();
            m.a.a.d.b(paramMessage, new Object[0]);
            if (!a.b) {
              break label452;
            }
            paramMessage = new java/lang/StringBuilder;
            paramMessage.<init>();
            paramMessage.append("Called from thread:  ");
            localObject = Thread.currentThread();
            i.k.b.g.a(localObject, "Thread.currentThread()");
            paramMessage.append(((Thread)localObject).getName());
            paramMessage = paramMessage.toString();
            m.a.a.d.a(paramMessage, new Object[0]);
            a.a();
            a.d.sendEmptyMessageDelayed(3, 35000L);
          }
          catch (Exception paramMessage)
          {
            m.a.a.d.b(paramMessage);
            localObject = new LinkedHashMap();
            ((HashMap)localObject).put("where", "ScanScheduler::handleMsgRestart");
            Crashes.trackError(paramMessage, (Map)localObject, null);
          }
        }
      }
      else
      {
        paramMessage = e.a.a.a.a.a("MSG_TIMEOUT ");
        paramMessage.append(a.b);
        paramMessage = paramMessage.toString();
        m.a.a.d.b(paramMessage, new Object[0]);
        try
        {
          if (a.b)
          {
            localObject = new java/lang/StringBuilder;
            ((StringBuilder)localObject).<init>();
            ((StringBuilder)localObject).append("Called from thread:  ");
            paramMessage = Thread.currentThread();
            i.k.b.g.a(paramMessage, "Thread.currentThread()");
            ((StringBuilder)localObject).append(paramMessage.getName());
            paramMessage = ((StringBuilder)localObject).toString();
            m.a.a.d.b(paramMessage, new Object[0]);
            paramMessage = a.a;
            if (paramMessage != null)
            {
              paramMessage = e;
              if (paramMessage != null)
              {
                if (System.currentTimeMillis() - a < 35000L) {
                  i = 1;
                } else {
                  i = 0;
                }
                if (i == 0) {
                  a.c = false;
                }
              }
              else
              {
                throw null;
              }
            }
            a.b();
            paramMessage = a;
            if (!c)
            {
              d.sendEmptyMessageDelayed(4, 120000L);
            }
            else
            {
              d.sendEmptyMessageDelayed(4, 360000L);
              c = false;
            }
          }
        }
        catch (Exception localException)
        {
          m.a.a.d.b(localException);
          paramMessage = new LinkedHashMap();
          paramMessage.put("where", "ScanScheduler::handleMsgTimeout");
          Crashes.trackError(localException, paramMessage, null);
        }
      }
      label452:
      return;
    }
    i.k.b.g.a("msg");
    throw null;
  }
}

/* Location:
 * Qualified Name:     k.b.a.u.i.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */