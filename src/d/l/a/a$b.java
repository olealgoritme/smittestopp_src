package d.l.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class a$b
  extends ViewGroup.MarginLayoutParams
{
  public int a = 0;
  public float b;
  public boolean c;
  public int d;
  
  public a$b(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public a$b(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.N);
    a = paramContext.getInt(0, 0);
    paramContext.recycle();
  }
  
  public a$b(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public a$b(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
  }
  
  public a$b(b paramb)
  {
    super(paramb);
    a = a;
  }
}

/* Location:
 * Qualified Name:     base.d.l.a.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */