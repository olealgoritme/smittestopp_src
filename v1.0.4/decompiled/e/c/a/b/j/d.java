package e.c.a.b.j;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.TextView;
import d.x.h;
import d.x.p;
import java.util.Map;

public class d
  extends h
{
  public Animator a(ViewGroup paramViewGroup, p paramp1, p paramp2)
  {
    TextView localTextView = null;
    paramViewGroup = localTextView;
    if (paramp1 != null)
    {
      paramViewGroup = localTextView;
      if (paramp2 != null)
      {
        paramViewGroup = localTextView;
        if ((b instanceof TextView))
        {
          paramViewGroup = b;
          if (!(paramViewGroup instanceof TextView))
          {
            paramViewGroup = localTextView;
          }
          else
          {
            localTextView = (TextView)paramViewGroup;
            paramViewGroup = a;
            paramp2 = a;
            paramp1 = paramViewGroup.get("android:textscale:scale");
            float f1 = 1.0F;
            float f2;
            if (paramp1 != null) {
              f2 = ((Float)paramViewGroup.get("android:textscale:scale")).floatValue();
            } else {
              f2 = 1.0F;
            }
            if (paramp2.get("android:textscale:scale") != null) {
              f1 = ((Float)paramp2.get("android:textscale:scale")).floatValue();
            }
            if (f2 == f1) {
              return null;
            }
            paramViewGroup = ValueAnimator.ofFloat(new float[] { f2, f1 });
            paramViewGroup.addUpdateListener(new d.a(this, localTextView));
          }
        }
      }
    }
    return paramViewGroup;
  }
  
  public void a(p paramp)
  {
    d(paramp);
  }
  
  public void c(p paramp)
  {
    d(paramp);
  }
  
  public final void d(p paramp)
  {
    Object localObject = b;
    if ((localObject instanceof TextView))
    {
      localObject = (TextView)localObject;
      a.put("android:textscale:scale", Float.valueOf(((TextView)localObject).getScaleX()));
    }
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.b.j.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */