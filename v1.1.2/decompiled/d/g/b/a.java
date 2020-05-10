package d.g.b;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.R.styleable;

public class a
  extends b
{
  public int D;
  public int E;
  public d.g.a.h.a F;
  
  public a(Context paramContext)
  {
    super(paramContext);
    super.setVisibility(8);
  }
  
  public void a(AttributeSet paramAttributeSet)
  {
    super.a(paramAttributeSet);
    F = new d.g.a.h.a();
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int i = paramAttributeSet.getIndexCount();
      for (int j = 0; j < i; j++)
      {
        int k = paramAttributeSet.getIndex(j);
        if (k == R.styleable.ConstraintLayout_Layout_barrierDirection) {
          setType(paramAttributeSet.getInt(k, 0));
        } else if (k == R.styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
          F.o0 = paramAttributeSet.getBoolean(k, true);
        }
      }
    }
    A = F;
    a();
  }
  
  public int getType()
  {
    return D;
  }
  
  public void setAllowsGoneWidget(boolean paramBoolean)
  {
    F.o0 = paramBoolean;
  }
  
  public void setType(int paramInt)
  {
    D = paramInt;
    E = paramInt;
    if (1 == getResources().getConfiguration().getLayoutDirection()) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0)
    {
      paramInt = D;
      if (paramInt == 5) {
        E = 1;
      } else if (paramInt == 6) {
        E = 0;
      }
    }
    else
    {
      paramInt = D;
      if (paramInt == 5) {
        E = 0;
      } else if (paramInt == 6) {
        E = 1;
      }
    }
    F.m0 = E;
  }
}

/* Location:
 * Qualified Name:     d.g.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */