package d.m.a;

import android.transition.Transition;
import android.transition.Transition.TransitionListener;

public class f0$d
  implements Transition.TransitionListener
{
  public f0$d(f0 paramf0, Runnable paramRunnable) {}
  
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
 * Qualified Name:     d.m.a.f0.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */