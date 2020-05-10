package d.m.a;

import android.transition.Transition;
import android.transition.Transition.TransitionListener;
import java.util.ArrayList;

public class f0$c
  implements Transition.TransitionListener
{
  public f0$c(f0 paramf0, Object paramObject1, ArrayList paramArrayList1, Object paramObject2, ArrayList paramArrayList2, Object paramObject3, ArrayList paramArrayList3) {}
  
  public void onTransitionCancel(Transition paramTransition) {}
  
  public void onTransitionEnd(Transition paramTransition)
  {
    paramTransition.removeListener(this);
  }
  
  public void onTransitionPause(Transition paramTransition) {}
  
  public void onTransitionResume(Transition paramTransition) {}
  
  public void onTransitionStart(Transition paramTransition)
  {
    paramTransition = a;
    if (paramTransition != null) {
      g.a(paramTransition, b, null);
    }
    paramTransition = c;
    if (paramTransition != null) {
      g.a(paramTransition, d, null);
    }
    paramTransition = e;
    if (paramTransition != null) {
      g.a(paramTransition, f, null);
    }
  }
}

/* Location:
 * Qualified Name:     d.m.a.f0.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */