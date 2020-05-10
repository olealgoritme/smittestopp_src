package d.m.a;

import android.view.View;
import androidx.fragment.app.Fragment;
import d.i.e.a.a;

public final class d
  implements a.a
{
  public d(Fragment paramFragment) {}
  
  public void a()
  {
    if (a.getAnimatingAway() != null)
    {
      View localView = a.getAnimatingAway();
      a.setAnimatingAway(null);
      localView.clearAnimation();
    }
    a.setAnimator(null);
  }
}

/* Location:
 * Qualified Name:     d.m.a.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */