package d.i.a;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import java.lang.reflect.Field;

public final class b$c
  implements Application.ActivityLifecycleCallbacks
{
  public boolean A = false;
  public boolean B = false;
  public Object x;
  public Activity y;
  public boolean z = false;
  
  public b$c(Activity paramActivity)
  {
    y = paramActivity;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (y == paramActivity)
    {
      y = null;
      A = true;
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    if ((A) && (!B) && (!z))
    {
      Object localObject1 = x;
      int i = 0;
      try
      {
        Object localObject2 = b.c.get(paramActivity);
        if (localObject2 == localObject1)
        {
          Object localObject3 = b.b.get(paramActivity);
          paramActivity = b.g;
          localObject1 = new d/i/a/c;
          ((c)localObject1).<init>(localObject3, localObject2);
          paramActivity.postAtFrontOfQueue((Runnable)localObject1);
          i = 1;
        }
      }
      finally
      {
        Log.e("ActivityRecreator", "Exception while fetching field values", paramActivity);
      }
      if (i != 0)
      {
        B = true;
        x = null;
      }
    }
  }
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    if (y == paramActivity) {
      z = true;
    }
  }
  
  public void onActivityStopped(Activity paramActivity) {}
}

/* Location:
 * Qualified Name:     base.d.i.a.b.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */