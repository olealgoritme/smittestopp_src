package d.x;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import d.i.i.n;
import java.util.Map;

public class c
  extends b0
{
  public c(int paramInt)
  {
    if ((paramInt & 0xFFFFFFFC) == 0)
    {
      f0 = paramInt;
      return;
    }
    throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
  }
  
  public final Animator a(final View paramView, float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 == paramFloat2) {
      return null;
    }
    v.a.a(paramView, paramFloat1);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, v.d, new float[] { paramFloat2 });
    localObjectAnimator.addListener(new b(paramView));
    a(new a(paramView));
    return localObjectAnimator;
  }
  
  public Animator a(ViewGroup paramViewGroup, View paramView, p paramp1, p paramp2)
  {
    v.a.c(paramView);
    if (paramp1 != null)
    {
      paramViewGroup = (Float)a.get("android:fade:transitionAlpha");
      if (paramViewGroup != null)
      {
        f = paramViewGroup.floatValue();
        break label42;
      }
    }
    float f = 1.0F;
    label42:
    return a(paramView, f, 0.0F);
  }
  
  public void c(p paramp)
  {
    d(paramp);
    a.put("android:fade:transitionAlpha", Float.valueOf(v.b(b)));
  }
  
  public class a
    extends k
  {
    public a(View paramView) {}
    
    public void d(h paramh)
    {
      View localView = paramView;
      v.a.a(localView, 1.0F);
      localView = paramView;
      v.a.a(localView);
      paramh.b(this);
    }
  }
  
  public static class b
    extends AnimatorListenerAdapter
  {
    public final View a;
    public boolean b = false;
    
    public b(View paramView)
    {
      a = paramView;
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      paramAnimator = a;
      v.a.a(paramAnimator, 1.0F);
      if (b) {
        a.setLayerType(0, null);
      }
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      if ((n.r(a)) && (a.getLayerType() == 0))
      {
        b = true;
        a.setLayerType(2, null);
      }
    }
  }
}

/* Location:
 * Qualified Name:     d.x.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */