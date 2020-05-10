package e.c.a.a.b.j;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import d.b.a.s;
import e.c.a.a.b.k.a;
import e.c.a.a.d.b.d;
import java.util.HashMap;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;

public final class c0
  extends i
  implements Handler.Callback
{
  @GuardedBy("mConnectionStatus")
  public final HashMap<i.a, d0> c = new HashMap();
  public final Context d;
  public final Handler e;
  public final a f;
  public final long g;
  public final long h;
  
  public c0(Context paramContext)
  {
    d = paramContext.getApplicationContext();
    e = new d(paramContext.getMainLooper(), this);
    f = a.a();
    g = 5000L;
    h = 300000L;
  }
  
  public final boolean a(i.a parama, ServiceConnection paramServiceConnection, String paramString)
  {
    s.b(paramServiceConnection, "ServiceConnection must not be null");
    synchronized (c)
    {
      d0 locald0 = (d0)c.get(parama);
      if (locald0 == null)
      {
        locald0 = new e/c/a/a/b/j/d0;
        locald0.<init>(this, parama);
        a locala = g.f;
        e.a();
        a.add(paramServiceConnection);
        locald0.a(paramString);
        c.put(parama, locald0);
        parama = locald0;
      }
      else
      {
        e.removeMessages(0, parama);
        if (a.contains(paramServiceConnection)) {
          break label221;
        }
        parama = g.f;
        e.a();
        a.add(paramServiceConnection);
        i = b;
        if (i != 1)
        {
          if (i != 2)
          {
            parama = locald0;
          }
          else
          {
            locald0.a(paramString);
            parama = locald0;
          }
        }
        else
        {
          paramServiceConnection.onServiceConnected(f, d);
          parama = locald0;
        }
      }
      boolean bool = c;
      return bool;
      label221:
      paramServiceConnection = new java/lang/IllegalStateException;
      paramString = String.valueOf(parama);
      int i = paramString.length();
      parama = new java/lang/StringBuilder;
      parama.<init>(i + 81);
      parama.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
      parama.append(paramString);
      paramServiceConnection.<init>(parama.toString());
      throw paramServiceConnection;
    }
  }
  
  public final void b(i.a parama, ServiceConnection paramServiceConnection, String arg3)
  {
    s.b(paramServiceConnection, "ServiceConnection must not be null");
    synchronized (c)
    {
      Object localObject = (d0)c.get(parama);
      if (localObject != null)
      {
        if (a.contains(paramServiceConnection))
        {
          a locala = g.f;
          a.remove(paramServiceConnection);
          if (a.isEmpty())
          {
            parama = e.obtainMessage(0, parama);
            e.sendMessageDelayed(parama, g);
          }
          return;
        }
        paramServiceConnection = new java/lang/IllegalStateException;
        localObject = String.valueOf(parama);
        i = ((String)localObject).length();
        parama = new java/lang/StringBuilder;
        parama.<init>(i + 76);
        parama.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
        parama.append((String)localObject);
        paramServiceConnection.<init>(parama.toString());
        throw paramServiceConnection;
      }
      paramServiceConnection = new java/lang/IllegalStateException;
      parama = String.valueOf(parama);
      int i = parama.length();
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>(i + 50);
      ((StringBuilder)localObject).append("Nonexistent connection status for service config: ");
      ((StringBuilder)localObject).append(parama);
      paramServiceConnection.<init>(((StringBuilder)localObject).toString());
      throw paramServiceConnection;
    }
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    int i = what;
    Object localObject2;
    d0 locald0;
    if (i != 0)
    {
      if (i != 1) {
        return false;
      }
      synchronized (c)
      {
        localObject2 = (i.a)obj;
        locald0 = (d0)c.get(localObject2);
        if ((locald0 != null) && (b == 3))
        {
          paramMessage = String.valueOf(localObject2);
          i = paramMessage.length();
          ??? = new java/lang/StringBuilder;
          ((StringBuilder)???).<init>(i + 47);
          ((StringBuilder)???).append("Timeout waiting for ServiceConnection callback ");
          ((StringBuilder)???).append(paramMessage);
          paramMessage = ((StringBuilder)???).toString();
          ??? = new java/lang/Exception;
          ((Exception)???).<init>();
          Log.e("GmsClientSupervisor", paramMessage, (Throwable)???);
          ??? = f;
          paramMessage = (Message)???;
          if (??? == null) {
            paramMessage = c;
          }
          ??? = paramMessage;
          if (paramMessage == null)
          {
            ??? = new android/content/ComponentName;
            ((ComponentName)???).<init>(b, "unknown");
          }
          locald0.onServiceDisconnected((ComponentName)???);
        }
        return true;
      }
    }
    synchronized (c)
    {
      paramMessage = (i.a)obj;
      locald0 = (d0)c.get(paramMessage);
      if ((locald0 != null) && (a.isEmpty()))
      {
        if (c)
        {
          g.e.removeMessages(1, e);
          localObject2 = g;
          ??? = f;
          localObject2 = d;
          if (??? != null)
          {
            ((Context)localObject2).unbindService(locald0);
            c = false;
            b = 2;
          }
          else
          {
            throw null;
          }
        }
        c.remove(paramMessage);
      }
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.b.j.c0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */