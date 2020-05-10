package d.m.a;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import d.i.i.l;

public class h
  extends AnimationSet
  implements Runnable
{
  public boolean A;
  public boolean B = true;
  public final ViewGroup x;
  public final View y;
  public boolean z;
  
  public h(Animation paramAnimation, ViewGroup paramViewGroup, View paramView)
  {
    super(false);
    x = paramViewGroup;
    y = paramView;
    addAnimation(paramAnimation);
    x.post(this);
  }
  
  public boolean getTransformation(long paramLong, Transformation paramTransformation)
  {
    B = true;
    if (z) {
      return A ^ true;
    }
    if (!super.getTransformation(paramLong, paramTransformation))
    {
      z = true;
      l.a(x, this);
    }
    return true;
  }
  
  public boolean getTransformation(long paramLong, Transformation paramTransformation, float paramFloat)
  {
    B = true;
    if (z) {
      return A ^ true;
    }
    if (!super.getTransformation(paramLong, paramTransformation, paramFloat))
    {
      z = true;
      l.a(x, this);
    }
    return true;
  }
  
  public void run()
  {
    if ((!z) && (B))
    {
      B = false;
      x.post(this);
    }
    else
    {
      x.endViewTransition(y);
      A = true;
    }
  }
}

/* Location:
 * Qualified Name:     base.d.m.a.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */