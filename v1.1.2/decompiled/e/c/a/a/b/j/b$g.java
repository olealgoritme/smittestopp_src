package e.c.a.a.b.j;

import android.app.PendingIntent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import e.c.a.a.b.a;
import e.c.a.a.b.i.d.a;
import e.c.a.a.d.b.d;
import java.util.concurrent.atomic.AtomicInteger;

public final class b$g
  extends d
{
  public b$g(b paramb, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public static void a(Message paramMessage)
  {
    paramMessage = (b.h)obj;
    if ((b.f)paramMessage != null)
    {
      paramMessage.b();
      return;
    }
    throw null;
  }
  
  public static boolean b(Message paramMessage)
  {
    int i = what;
    return (i == 2) || (i == 1) || (i == 7);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (a.t.get() != arg1)
    {
      if (b(paramMessage)) {
        a(paramMessage);
      }
      return;
    }
    int i = what;
    if ((i != 1) && (i != 7)) {
      if (i == 4)
      {
        if (a == null) {
          throw null;
        }
      }
      else {
        if (i != 5) {
          break label82;
        }
      }
    }
    if (!a.d())
    {
      a(paramMessage);
      return;
    }
    label82:
    i = what;
    if (i == 4)
    {
      a.q = new a(arg2);
      if (b.b(a))
      {
        paramMessage = a;
        if (!r)
        {
          paramMessage.b(3, null);
          return;
        }
      }
      paramMessage = a.q;
      if (paramMessage == null) {
        paramMessage = new a(8);
      }
      a.h.a(paramMessage);
      if (a != null)
      {
        System.currentTimeMillis();
        return;
      }
      throw null;
    }
    if (i == 5)
    {
      paramMessage = a.q;
      if (paramMessage == null) {
        paramMessage = new a(8);
      }
      a.h.a(paramMessage);
      if (a != null)
      {
        System.currentTimeMillis();
        return;
      }
      throw null;
    }
    Object localObject;
    if (i == 3)
    {
      localObject = obj;
      if ((localObject instanceof PendingIntent)) {
        localObject = (PendingIntent)localObject;
      } else {
        localObject = null;
      }
      paramMessage = new a(arg2, (PendingIntent)localObject);
      a.h.a(paramMessage);
      if (a != null)
      {
        System.currentTimeMillis();
        return;
      }
      throw null;
    }
    if (i == 6)
    {
      a.b(5, null);
      localObject = a.m;
      if (localObject != null)
      {
        i = arg2;
        a.a(i);
      }
      if (a != null)
      {
        System.currentTimeMillis();
        a.a(5, 1, null);
        return;
      }
      throw null;
    }
    if ((i == 2) && (!a.a()))
    {
      a(paramMessage);
      return;
    }
    if (b(paramMessage))
    {
      ((b.h)obj).c();
      return;
    }
    i = what;
    paramMessage = new StringBuilder(45);
    paramMessage.append("Don't know how to handle message: ");
    paramMessage.append(i);
    Log.wtf("GmsClient", paramMessage.toString(), new Exception());
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.b.j.b.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */