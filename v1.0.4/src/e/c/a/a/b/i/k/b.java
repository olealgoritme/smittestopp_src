package e.c.a.a.b.i.k;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

public final class b
  implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2
{
  public static final b B = new b();
  @GuardedBy("sInstance")
  public boolean A = false;
  public final AtomicBoolean x = new AtomicBoolean();
  public final AtomicBoolean y = new AtomicBoolean();
  @GuardedBy("sInstance")
  public final ArrayList<b.a> z = new ArrayList();
  
  public static void a(Application paramApplication)
  {
    synchronized (B)
    {
      if (!BA)
      {
        paramApplication.registerActivityLifecycleCallbacks(B);
        paramApplication.registerComponentCallbacks(B);
        BA = true;
      }
      return;
    }
  }
  
  public final void a(b.a parama)
  {
    synchronized (B)
    {
      z.add(parama);
      return;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    synchronized (B)
    {
      ArrayList localArrayList = z;
      int i = localArrayList.size();
      int j = 0;
      while (j < i)
      {
        Object localObject2 = localArrayList.get(j);
        j++;
        ((b.a)localObject2).a(paramBoolean);
      }
      return;
    }
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    boolean bool = x.compareAndSet(true, false);
    y.set(true);
    if (bool) {
      a(false);
    }
  }
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity)
  {
    boolean bool = x.compareAndSet(true, false);
    y.set(true);
    if (bool) {
      a(false);
    }
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onLowMemory() {}
  
  public final void onTrimMemory(int paramInt)
  {
    if ((paramInt == 20) && (x.compareAndSet(false, true)))
    {
      y.set(true);
      a(true);
    }
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.b.i.k.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */