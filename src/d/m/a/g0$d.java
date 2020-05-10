package d.m.a;

import android.transition.Transition;
import android.transition.Transition.TransitionListener;

public class g0$d
  implements Transition.TransitionListener
{
  public g0$d(g0 paramg0, Runnable paramRunnable) {}
  
  public void onTransitionCancel(Transition paramTransition) {}
  
  public void onTransitionEnd(Transition paramTransition)
  {
    a.run();
  }
  
  public void onTransitionPause(Transition paramTransition) {}
  
  public void onTransitionResume(Transition paramTransition) {}
  
  public void onTransitionStart(Transition paramTransition) {}
}

/* Location:
 * Qualified Name:     base.d.m.a.g0.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */