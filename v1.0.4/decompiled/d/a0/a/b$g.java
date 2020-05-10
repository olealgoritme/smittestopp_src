package d.a0.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;

public class b$g
  extends ViewGroup.LayoutParams
{
  public boolean a;
  public int b;
  public float c = 0.0F;
  public boolean d;
  public int e;
  public int f;
  
  public b$g()
  {
    super(-1, -1);
  }
  
  public b$g(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b.w0);
    b = paramContext.getInteger(0, 48);
    paramContext.recycle();
  }
}

/* Location:
 * Qualified Name:     base.d.a0.a.b.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */