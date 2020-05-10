package d.g.b;

import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout.a;
import java.util.HashMap;

public class d
  extends ViewGroup
{
  public c x;
  
  public ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new d.a(-2, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new d.a(getContext(), paramAttributeSet);
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
        d.a locala = (d.a)((View)localObject).getLayoutParams();
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
}

/* Location:
 * Qualified Name:     base.d.g.b.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */