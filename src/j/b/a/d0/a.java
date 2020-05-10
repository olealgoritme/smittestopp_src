package j.b.a.d0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings.Secure;
import h.k.b.g;
import j.b.a.c0.d;
import k.d.a.c;

public final class a
  extends BroadcastReceiver
{
  public static final boolean a(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getContentResolver();
      boolean bool = false;
      if (Settings.Secure.getInt(paramContext, "location_mode", 0) != 0) {
        bool = true;
      }
      return bool;
    }
    g.a("context");
    throw null;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getAction();
      if ((paramIntent != null) && (paramIntent.equals("android.location.PROVIDERS_CHANGED") == true))
      {
        paramIntent = c.b();
        if (paramContext != null)
        {
          paramIntent.a(new d(a(paramContext)));
        }
        else
        {
          g.a();
          throw null;
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.j.b.a.d0.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */