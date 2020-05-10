package d.o;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

public class v$b
  implements Application.ActivityLifecycleCallbacks
{
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityPostCreated(Activity paramActivity, Bundle paramBundle)
  {
    v.a(paramActivity, g.a.ON_CREATE);
  }
  
  public void onActivityPostResumed(Activity paramActivity)
  {
    v.a(paramActivity, g.a.ON_RESUME);
  }
  
  public void onActivityPostStarted(Activity paramActivity)
  {
    v.a(paramActivity, g.a.ON_START);
  }
  
  public void onActivityPreDestroyed(Activity paramActivity)
  {
    v.a(paramActivity, g.a.ON_DESTROY);
  }
  
  public void onActivityPrePaused(Activity paramActivity)
  {
    v.a(paramActivity, g.a.ON_PAUSE);
  }
  
  public void onActivityPreStopped(Activity paramActivity)
  {
    v.a(paramActivity, g.a.ON_STOP);
  }
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}

/* Location:
 * Qualified Name:     base.d.o.v.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */