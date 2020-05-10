package d.t.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;

public final class p
  extends r
{
  public p(s.k paramk)
  {
    super(paramk, null);
  }
  
  public int a()
  {
    s.k localk = a;
    return o - localk.h();
  }
  
  public int a(View paramView)
  {
    s.l locall = (s.l)paramView.getLayoutParams();
    if (a != null) {
      return paramView.getRight() + getLayoutParamsb.right + rightMargin;
    }
    throw null;
  }
  
  public int b()
  {
    return a.g();
  }
  
  public int b(View paramView)
  {
    s.l locall = (s.l)paramView.getLayoutParams();
    if (a != null) {
      return paramView.getLeft() - getLayoutParamsb.left - leftMargin;
    }
    throw null;
  }
  
  public int c()
  {
    s.k localk = a;
    return o - localk.g() - a.h();
  }
}

/* Location:
 * Qualified Name:     base.d.t.a.p
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */