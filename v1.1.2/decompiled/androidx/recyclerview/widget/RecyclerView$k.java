package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class RecyclerView$k
  extends ViewGroup.MarginLayoutParams
{
  public RecyclerView.w a;
  public final Rect b = new Rect();
  public boolean c = true;
  public boolean d = false;
  
  public RecyclerView$k(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public RecyclerView$k(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RecyclerView$k(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public RecyclerView$k(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
  }
  
  public RecyclerView$k(k paramk)
  {
    super(paramk);
  }
  
  public int a()
  {
    return a.g();
  }
}

/* Location:
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */