package j.b.a.b0;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.microsoft.appcenter.crashes.Crashes;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import l.a.a.b;

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
      if (i != 3)
      {
        if (i == 4)
        {
          l.a.a.d.b("MSG_RESTART", new Object[0]);
          try
          {
            paramMessage = new java/lang/StringBuilder;
            paramMessage.<init>();
            paramMessage.append(a.b);
            paramMessage.append(' ');
            paramMessage.append(a.a);
            paramMessage = paramMessage.toString();
            l.a.a.d.b(paramMessage, new Object[0]);
            if (!a.b) {
              break label452;
            }
            paramMessage = new java/lang/StringBuilder;
            paramMessage.<init>();
            paramMessage.append("Called from thread:  ");
            Thread localThread = Thread.currentThread();
            h.k.b.g.a(localThread, "Thread.currentThread()");
            paramMessage.append(localThread.getName());
            paramMessage = paramMessage.toString();
            l.a.a.d.a(paramMessage, new Object[0]);
            a.a();
            a.d.sendEmptyMessageDelayed(3, 35000L);
          }
          catch (Exception localException)
          {
            l.a.a.d.a(localException);
            paramMessage = new LinkedHashMap();
            paramMessage.put("where", "ScanScheduler::handleMsgRestart");
            Crashes.trackError(localException, paramMessage, null);
          }
        }
      }
      else
      {
        paramMessage = e.a.a.a.a.a("MSG_TIMEOUT ");
        paramMessage.append(a.b);
        paramMessage = paramMessage.toString();
        l.a.a.d.b(paramMessage, new Object[0]);
        try
        {
          if (a.b)
          {
            localObject = new java/lang/StringBuilder;
            ((StringBuilder)localObject).<init>();
            ((StringBuilder)localObject).append("Called from thread:  ");
            paramMessage = Thread.currentThread();
            h.k.b.g.a(paramMessage, "Thread.currentThread()");
            ((StringBuilder)localObject).append(paramMessage.getName());
            paramMessage = ((StringBuilder)localObject).toString();
            l.a.a.d.b(paramMessage, new Object[0]);
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
        catch (Exception paramMessage)
        {
          l.a.a.d.a(paramMessage);
          Object localObject = new LinkedHashMap();
          ((HashMap)localObject).put("where", "ScanScheduler::handleMsgTimeout");
          Crashes.trackError(paramMessage, (Map)localObject, null);
        }
      }
      label452:
      return;
    }
    h.k.b.g.a("msg");
    throw null;
  }
}

/* Location:
 * Qualified Name:     base.j.b.a.b0.i.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */