package d.t.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;

public class s$k$b
  implements x.b
{
  public s$k$b(s.k paramk) {}
  
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
  
  public View a(int paramInt)
  {
    return a.a(paramInt);
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
}

/* Location:
 * Qualified Name:     base.d.t.a.s.k.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */