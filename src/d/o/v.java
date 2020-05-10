package d.o;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;

public class v
  extends Fragment
{
  public v.a x;
  
  public static v a(Activity paramActivity)
  {
    return (v)paramActivity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
  }
  
  public static void a(Activity paramActivity, g.a parama)
  {
    if ((paramActivity instanceof n))
    {
      ((n)paramActivity).getLifecycle().a(parama);
      return;
    }
    if ((paramActivity instanceof l))
    {
      paramActivity = ((l)paramActivity).getLifecycle();
      if ((paramActivity instanceof m)) {
        ((m)paramActivity).a(parama);
      }
    }
  }
  
  public static void b(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 29) {
      paramActivity.registerActivityLifecycleCallbacks(new v.b());
    }
    paramActivity = paramActivity.getFragmentManager();
    if (paramActivity.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null)
    {
      paramActivity.beginTransaction().add(new v(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
      paramActivity.executePendingTransactions();
    }
  }
  
  public final void a(g.a parama)
  {
    if (Build.VERSION.SDK_INT < 29) {
      a(getActivity(), parama);
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    a(g.a.ON_CREATE);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a(g.a.ON_DESTROY);
    x = null;
  }
  
  public void onPause()
  {
    super.onPause();
    a(g.a.ON_PAUSE);
  }
  
  public void onResume()
  {
    super.onResume();
    Object localObject = x;
    if (localObject != null)
    {
      localObject = a;
      int i = y + 1;
      y = i;
      if (i == 1) {
        if (z)
        {
          C.a(g.a.ON_RESUME);
          z = false;
        }
        else
        {
          B.removeCallbacks(D);
        }
      }
    }
    a(g.a.ON_RESUME);
  }
  
  public void onStart()
  {
    super.onStart();
    Object localObject = x;
    if (localObject != null)
    {
      localObject = a;
      int i = x + 1;
      x = i;
      if ((i == 1) && (A))
      {
        C.a(g.a.ON_START);
        A = false;
      }
    }
    a(g.a.ON_START);
  }
  
  public void onStop()
  {
    super.onStop();
    a(g.a.ON_STOP);
  }
}

/* Location:
 * Qualified Name:     base.d.o.v
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */