package d.t.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;

public final class q
  extends r
{
  public q(s.k paramk)
  {
    super(paramk, null);
  }
  
  public int a()
  {
    s.k localk = a;
    return p - localk.f();
  }
  
  public int a(View paramView)
  {
    s.l locall = (s.l)paramView.getLayoutParams();
    if (a != null) {
      return paramView.getBottom() + getLayoutParamsb.bottom + bottomMargin;
    }
    throw null;
  }
  
  public int b()
  {
    return a.i();
  }
  
  public int b(View paramView)
  {
    s.l locall = (s.l)paramView.getLayoutParams();
    if (a != null) {
      return paramView.getTop() - getLayoutParamsb.top - topMargin;
    }
    throw null;
  }
  
  public int c()
  {
    s.k localk = a;
    return p - localk.i() - a.f();
  }
}

/* Location:
 * Qualified Name:     base.d.t.a.q
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */