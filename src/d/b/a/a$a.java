package d.b.a;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.R.styleable;

public class a$a
  extends ViewGroup.MarginLayoutParams
{
  public int a = 0;
  
  public a$a(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    a = 8388627;
  }
  
  public a$a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ActionBarLayout);
    a = paramContext.getInt(R.styleable.ActionBarLayout_android_layout_gravity, 0);
    paramContext.recycle();
  }
  
  public a$a(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public a$a(a parama)
  {
    super(parama);
    a = a;
  }
}

/* Location:
 * Qualified Name:     base.d.b.a.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */