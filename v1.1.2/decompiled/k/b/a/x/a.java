package k.b.a.x;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings.Secure;
import i.k.b.g;
import k.b.a.w.d;
import l.d.a.c;

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
 * Qualified Name:     k.b.a.x.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */