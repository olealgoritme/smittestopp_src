package d.m.a;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import androidx.fragment.app.Fragment;
import d.i.e.a;

public final class e
  implements Animation.AnimationListener
{
  public e(ViewGroup paramViewGroup, Fragment paramFragment, e0.a parama, a parama1) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    a.post(new a());
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public class a
    implements Runnable
  {
    public a() {}
    
    public void run()
    {
      if (b.getAnimatingAway() != null)
      {
        b.setAnimatingAway(null);
        Object localObject = e.this;
        e0.a locala = c;
        Fragment localFragment = b;
        localObject = d;
        ((p.b)locala).a(localFragment, (a)localObject);
      }
    }
  }
}

/* Location:
 * Qualified Name:     d.m.a.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */