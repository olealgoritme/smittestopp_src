package d.g.b;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout.a;
import androidx.constraintlayout.widget.R.styleable;
import java.util.HashMap;

public class d
  extends ViewGroup
{
  public c x;
  
  public ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new a(-2, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new a(getContext(), paramAttributeSet);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new ConstraintLayout.a(paramLayoutParams);
  }
  
  public c getConstraintSet()
  {
    if (x == null) {
      x = new c();
    }
    c localc = x;
    if (localc != null)
    {
      int i = getChildCount();
      a.clear();
      int j = 0;
      while (j < i)
      {
        Object localObject = getChildAt(j);
        a locala = (a)((View)localObject).getLayoutParams();
        int k = ((View)localObject).getId();
        if (k != -1)
        {
          if (!a.containsKey(Integer.valueOf(k))) {
            a.put(Integer.valueOf(k), new c.a());
          }
          c.a locala1 = (c.a)a.get(Integer.valueOf(k));
          if ((localObject instanceof b))
          {
            localObject = (b)localObject;
            locala1.a(k, locala);
            if ((localObject instanceof a))
            {
              t0 = 1;
              localObject = (a)localObject;
              s0 = ((a)localObject).getType();
              u0 = ((b)localObject).getReferencedIds();
            }
          }
          locala1.a(k, locala);
          j++;
        }
        else
        {
          throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
        }
      }
      return x;
    }
    throw null;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public static class a
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
    
    public a(int paramInt1, int paramInt2)
    {
      super(paramInt2);
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
    
    public a(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
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
}

/* Location:
 * Qualified Name:     d.g.b.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */