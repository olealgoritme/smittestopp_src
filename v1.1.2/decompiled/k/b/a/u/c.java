package k.b.a.u;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import i.k.b.g;
import m.a.a.b;

public final class c
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if ((paramContext != null) && (paramContext.hashCode() == -1530327060) && (paramContext.equals("android.bluetooth.adapter.action.STATE_CHANGED")))
      {
        int i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
        if (i == 10)
        {
          m.a.a.d.a("Bluetooth is off", new Object[0]);
          l.d.a.c.b().a(new k.b.a.w.a(false));
        }
        else if (i == 12)
        {
          l.d.a.c.b().a(new k.b.a.w.a(true));
          m.a.a.d.a("Bluetooth is on", new Object[0]);
        }
      }
      return;
    }
    g.a();
    throw null;
  }
}

/* Location:
 * Qualified Name:     k.b.a.u.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */