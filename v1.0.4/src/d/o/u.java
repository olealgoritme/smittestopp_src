package d.o;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

public class u
  extends c
{
  public u(t paramt) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    ax = x.E;
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    paramActivity = x;
    int i = y - 1;
    y = i;
    if (i == 0) {
      B.postDelayed(D, 700L);
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    paramActivity = x;
    int i = x - 1;
    x = i;
    if ((i == 0) && (z))
    {
      C.a(g.a.ON_STOP);
      A = true;
    }
  }
}

/* Location:
 * Qualified Name:     base.d.o.u
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */