package no.simula.corona;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.SystemClock;
import h.e;
import h.k.b.g;
import j.b.a.a0;
import l.a.a;
import l.a.a.b;

public final class BootCompletedReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramContext != null)
    {
      if (paramIntent != null)
      {
        if ((g.a("android.intent.action.BOOT_COMPLETED", paramIntent.getAction())) && ((a0.c(paramContext)) || (a0.d(paramContext)))) {
          if (Build.VERSION.SDK_INT >= 26)
          {
            paramIntent = new Intent(paramContext, DataCollectorService.class);
            paramIntent.putExtra("service-command", 4);
            paramIntent.putExtra("auto_start", true);
            paramContext.startForegroundService(paramIntent);
          }
          else
          {
            paramIntent = paramContext.getSystemService("alarm");
            if (paramIntent != null)
            {
              paramIntent = (AlarmManager)paramIntent;
              a.d.a("starting app automatically", new Object[0]);
              Intent localIntent = new Intent(paramContext, DataCollectorService.class);
              localIntent.putExtra("service-command", 4);
              localIntent.putExtra("auto_start", true);
              paramContext = PendingIntent.getService(paramContext, 0, localIntent, 134217728);
              paramIntent.set(1, SystemClock.currentThreadTimeMillis() + '✐', paramContext);
            }
            else
            {
              throw new e("null cannot be cast to non-null type android.app.AlarmManager");
            }
          }
        }
        return;
      }
      g.a("intent");
      throw null;
    }
    g.a("context");
    throw null;
  }
}

/* Location:
 * Qualified Name:     base.no.simula.corona.BootCompletedReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */