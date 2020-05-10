package no.simula.corona;

import android.app.Application;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;
import d.o.g;
import d.o.g.a;
import d.o.k;
import d.o.l;
import d.o.s;
import d.o.t;
import d.r.b;
import l.a.a;
import l.a.a.b;

public final class CoronaApp
  extends b
  implements k
{
  public static CoronaApp z;
  public boolean x;
  public boolean y;
  
  @s(g.a.ON_STOP)
  public final void onAppBackgrounded()
  {
    x = true;
  }
  
  @s(g.a.ON_START)
  public final void onAppForegrounded()
  {
    x = false;
  }
  
  public void onCreate()
  {
    super.onCreate();
    z = this;
    t.F.getLifecycle().a(this);
    AppCenter.start(this, "a236c750-5e31-41e9-b5c4-00cf94decfb0", new Class[] { Analytics.class, Crashes.class });
    a.a(new CoronaApp.a());
    a.d.a("starting app", new Object[0]);
  }
}

/* Location:
 * Qualified Name:     base.no.simula.corona.CoronaApp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */