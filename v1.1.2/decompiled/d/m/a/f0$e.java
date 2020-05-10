package d.m.a;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;

public class f0$e
  extends Transition.EpicenterCallback
{
  public f0$e(f0 paramf0, Rect paramRect) {}
  
  public Rect onGetEpicenter(Transition paramTransition)
  {
    paramTransition = a;
    if ((paramTransition != null) && (!paramTransition.isEmpty())) {
      return a;
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     d.m.a.f0.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */