package d.t.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;

public class s$k$a
  implements x.b
{
  public s$k$a(s.k paramk) {}
  
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
  
  public View a(int paramInt)
  {
    return a.a(paramInt);
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
}

/* Location:
 * Qualified Name:     base.d.t.a.s.k.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */