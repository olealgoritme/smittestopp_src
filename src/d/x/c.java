package d.x;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
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
  
  public final Animator a(View paramView, float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 == paramFloat2) {
      return null;
    }
    v.a.a(paramView, paramFloat1);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, v.d, new float[] { paramFloat2 });
    localObjectAnimator.addListener(new c.b(paramView));
    a(new c.a(this, paramView));
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
}

/* Location:
 * Qualified Name:     base.d.x.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */