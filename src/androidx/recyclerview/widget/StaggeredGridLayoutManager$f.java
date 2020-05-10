package androidx.recyclerview.widget;

import android.view.View;
import d.t.a.r;
import d.t.a.s.l;
import java.util.ArrayList;

public class StaggeredGridLayoutManager$f
{
  public ArrayList<View> a = new ArrayList();
  public int b = Integer.MIN_VALUE;
  public int c = Integer.MIN_VALUE;
  public int d = 0;
  public final int e;
  
  public StaggeredGridLayoutManager$f(StaggeredGridLayoutManager paramStaggeredGridLayoutManager, int paramInt)
  {
    e = paramInt;
  }
  
  public int a(int paramInt)
  {
    int i = c;
    if (i != Integer.MIN_VALUE) {
      return i;
    }
    if (a.size() == 0) {
      return paramInt;
    }
    a();
    return c;
  }
  
  public StaggeredGridLayoutManager.c a(View paramView)
  {
    return (StaggeredGridLayoutManager.c)paramView.getLayoutParams();
  }
  
  public void a()
  {
    Object localObject = a;
    View localView = (View)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
    localObject = a(localView);
    c = f.s.a(localView);
    if (f)
    {
      localObject = f.B.c(((s.l)localObject).a());
      if ((localObject != null) && (y == 1))
      {
        int i = c;
        int j = e;
        localObject = z;
        if (localObject == null) {
          j = 0;
        } else {
          j = localObject[j];
        }
        c = (i + j);
      }
    }
  }
  
  public int b(int paramInt)
  {
    int i = b;
    if (i != Integer.MIN_VALUE) {
      return i;
    }
    if (a.size() == 0) {
      return paramInt;
    }
    b();
    return b;
  }
  
  public void b()
  {
    Object localObject = a;
    int i = 0;
    localObject = (View)((ArrayList)localObject).get(0);
    StaggeredGridLayoutManager.c localc = a((View)localObject);
    b = f.s.b((View)localObject);
    if (f)
    {
      localObject = f.B.c(localc.a());
      if ((localObject != null) && (y == -1))
      {
        int j = b;
        int k = e;
        localObject = z;
        if (localObject != null) {
          i = localObject[k];
        }
        b = (j - i);
      }
    }
  }
  
  public void c()
  {
    a.clear();
    b = Integer.MIN_VALUE;
    c = Integer.MIN_VALUE;
    d = 0;
  }
}

/* Location:
 * Qualified Name:     base.androidx.recyclerview.widget.StaggeredGridLayoutManager.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */