package d.b.e;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.appcompat.R.styleable;

public class g0$a
  extends ViewGroup.MarginLayoutParams
{
  public float a;
  public int b = -1;
  
  public g0$a(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    a = 0.0F;
  }
  
  public g0$a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.LinearLayoutCompat_Layout);
    a = paramContext.getFloat(R.styleable.LinearLayoutCompat_Layout_android_layout_weight, 0.0F);
    b = paramContext.getInt(R.styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
    paramContext.recycle();
  }
  
  public g0$a(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
}

/* Location:
 * Qualified Name:     d.b.e.g0.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */