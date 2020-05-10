package d.g.b;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout.a;
import androidx.constraintlayout.widget.R.styleable;

public class d$a
  extends ConstraintLayout.a
{
  public float m0 = 1.0F;
  public boolean n0;
  public float o0;
  public float p0;
  public float q0;
  public float r0;
  public float s0;
  public float t0;
  public float u0;
  public float v0;
  public float w0;
  public float x0;
  public float y0;
  
  public d$a(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    n0 = false;
    o0 = 0.0F;
    p0 = 0.0F;
    q0 = 0.0F;
    r0 = 0.0F;
    s0 = 1.0F;
    t0 = 1.0F;
    u0 = 0.0F;
    v0 = 0.0F;
    w0 = 0.0F;
    x0 = 0.0F;
    y0 = 0.0F;
  }
  
  public d$a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i = 0;
    n0 = false;
    o0 = 0.0F;
    p0 = 0.0F;
    q0 = 0.0F;
    r0 = 0.0F;
    s0 = 1.0F;
    t0 = 1.0F;
    u0 = 0.0F;
    v0 = 0.0F;
    w0 = 0.0F;
    x0 = 0.0F;
    y0 = 0.0F;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintSet);
    int j = paramContext.getIndexCount();
    while (i < j)
    {
      int k = paramContext.getIndex(i);
      if (k == R.styleable.ConstraintSet_android_alpha)
      {
        m0 = paramContext.getFloat(k, m0);
      }
      else if (k == R.styleable.ConstraintSet_android_elevation)
      {
        o0 = paramContext.getFloat(k, o0);
        n0 = true;
      }
      else if (k == R.styleable.ConstraintSet_android_rotationX)
      {
        q0 = paramContext.getFloat(k, q0);
      }
      else if (k == R.styleable.ConstraintSet_android_rotationY)
      {
        r0 = paramContext.getFloat(k, r0);
      }
      else if (k == R.styleable.ConstraintSet_android_rotation)
      {
        p0 = paramContext.getFloat(k, p0);
      }
      else if (k == R.styleable.ConstraintSet_android_scaleX)
      {
        s0 = paramContext.getFloat(k, s0);
      }
      else if (k == R.styleable.ConstraintSet_android_scaleY)
      {
        t0 = paramContext.getFloat(k, t0);
      }
      else if (k == R.styleable.ConstraintSet_android_transformPivotX)
      {
        u0 = paramContext.getFloat(k, u0);
      }
      else if (k == R.styleable.ConstraintSet_android_transformPivotY)
      {
        v0 = paramContext.getFloat(k, v0);
      }
      else if (k == R.styleable.ConstraintSet_android_translationX)
      {
        w0 = paramContext.getFloat(k, w0);
      }
      else if (k == R.styleable.ConstraintSet_android_translationY)
      {
        x0 = paramContext.getFloat(k, x0);
      }
      else if (k == R.styleable.ConstraintSet_android_translationZ)
      {
        w0 = paramContext.getFloat(k, y0);
      }
      i++;
    }
  }
}

/* Location:
 * Qualified Name:     d.g.b.d.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */