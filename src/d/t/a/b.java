package d.t.a;

import android.view.View;
import android.view.ViewGroup;
import e.a.a.a.a;
import java.util.ArrayList;
import java.util.List;

public class b
{
  public final b.b a;
  public final b.a b;
  public final List<View> c;
  
  public b(b.b paramb)
  {
    a = paramb;
    b = new b.a();
    c = new ArrayList();
  }
  
  public int a()
  {
    return ((t)a).a() - c.size();
  }
  
  public int a(View paramView)
  {
    int i = a).a.indexOfChild(paramView);
    if (i == -1) {
      return -1;
    }
    if (b.c(i)) {
      return -1;
    }
    return i - b.b(i);
  }
  
  public void a(int paramInt)
  {
    paramInt = c(paramInt);
    b.d(paramInt);
    t localt = (t)a;
    Object localObject = a.getChildAt(paramInt);
    if (localObject != null)
    {
      localObject = s.b((View)localObject);
      if (localObject != null)
      {
        if ((((s.x)localObject).p()) && (!((s.x)localObject).u()))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("called detach on an already detached child ");
          localStringBuilder.append(localObject);
          throw new IllegalArgumentException(a.a(a, localStringBuilder));
        }
        ((s.x)localObject).a(256);
      }
    }
    s.a(a, paramInt);
  }
  
  public int b()
  {
    return ((t)a).a();
  }
  
  public View b(int paramInt)
  {
    paramInt = c(paramInt);
    return ((t)a).a(paramInt);
  }
  
  public boolean b(View paramView)
  {
    return c.contains(paramView);
  }
  
  public final int c(int paramInt)
  {
    if (paramInt < 0) {
      return -1;
    }
    int i = ((t)a).a();
    int j = paramInt;
    while (j < i)
    {
      int k = paramInt - (j - b.b(j));
      if (k == 0)
      {
        while (b.c(j)) {
          j++;
        }
        return j;
      }
      j += k;
    }
    return -1;
  }
  
  public final boolean c(View paramView)
  {
    if (c.remove(paramView))
    {
      t localt = (t)a;
      if (localt != null)
      {
        paramView = s.b(paramView);
        if (paramView != null) {
          paramView.a(a);
        }
        return true;
      }
      throw null;
    }
    return false;
  }
  
  public View d(int paramInt)
  {
    return a).a.getChildAt(paramInt);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b.toString());
    localStringBuilder.append(", hidden list:");
    localStringBuilder.append(c.size());
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.d.t.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */