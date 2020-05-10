package d.t.a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.k;
import androidx.recyclerview.widget.RecyclerView.p;
import androidx.recyclerview.widget.RecyclerView.w;
import java.util.ArrayList;

public class t
  implements a.a
{
  public t(RecyclerView paramRecyclerView) {}
  
  public RecyclerView.w a(int paramInt)
  {
    RecyclerView localRecyclerView = a;
    int i = B.b();
    int j = 0;
    Object localObject2;
    for (Object localObject1 = null;; localObject1 = localObject2)
    {
      localObject2 = localObject1;
      if (j >= i) {
        break;
      }
      RecyclerView.w localw = RecyclerView.b(B.d(j));
      localObject2 = localObject1;
      if (localw != null)
      {
        localObject2 = localObject1;
        if (!localw.n()) {
          if (c != paramInt)
          {
            localObject2 = localObject1;
          }
          else if (B.b(a))
          {
            localObject2 = localw;
          }
          else
          {
            localObject2 = localw;
            break;
          }
        }
      }
      j++;
    }
    if (localObject2 == null) {
      return null;
    }
    if (a.B.b(a)) {
      return null;
    }
    return (RecyclerView.w)localObject2;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    RecyclerView localRecyclerView = a;
    int i = B.b();
    int j = 0;
    RecyclerView.w localw;
    for (int k = 0; k < i; k++)
    {
      localw = RecyclerView.b(B.d(k));
      if ((localw != null) && (!localw.u()) && (c >= paramInt1))
      {
        localw.a(paramInt2, false);
        C0.f = true;
      }
    }
    RecyclerView.p localp = y;
    i = c.size();
    for (k = j; k < i; k++)
    {
      localw = (RecyclerView.w)c.get(k);
      if ((localw != null) && (c >= paramInt1)) {
        localw.a(paramInt2, true);
      }
    }
    localRecyclerView.requestLayout();
    a.F0 = true;
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    RecyclerView localRecyclerView = a;
    int i = B.b();
    int j = paramInt2 + paramInt1;
    RecyclerView.w localw;
    int k;
    for (paramInt2 = 0; paramInt2 < i; paramInt2++)
    {
      View localView = B.d(paramInt2);
      localw = RecyclerView.b(localView);
      if ((localw != null) && (!localw.u()))
      {
        k = c;
        if ((k >= paramInt1) && (k < j))
        {
          localw.a(2);
          localw.a(paramObject);
          getLayoutParamsc = true;
        }
      }
    }
    paramObject = y;
    paramInt2 = c.size();
    for (;;)
    {
      i = paramInt2 - 1;
      if (i < 0) {
        break;
      }
      localw = (RecyclerView.w)c.get(i);
      if (localw == null)
      {
        paramInt2 = i;
      }
      else
      {
        k = c;
        paramInt2 = i;
        if (k >= paramInt1)
        {
          paramInt2 = i;
          if (k < j)
          {
            localw.a(2);
            ((RecyclerView.p)paramObject).b(i);
            paramInt2 = i;
          }
        }
      }
    }
    a.G0 = true;
  }
  
  public void a(a.b paramb)
  {
    int i = a;
    RecyclerView localRecyclerView;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 4)
        {
          if (i == 8)
          {
            localRecyclerView = a;
            I.a(localRecyclerView, b, d, 1);
          }
        }
        else
        {
          localRecyclerView = a;
          I.a(localRecyclerView, b, d, c);
        }
      }
      else
      {
        localRecyclerView = a;
        I.b(localRecyclerView, b, d);
      }
    }
    else
    {
      localRecyclerView = a;
      I.a(localRecyclerView, b, d);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    RecyclerView localRecyclerView = a;
    int i = B.b();
    int j = -1;
    int k;
    int m;
    int n;
    if (paramInt1 < paramInt2)
    {
      k = paramInt1;
      m = paramInt2;
      n = -1;
    }
    else
    {
      m = paramInt1;
      k = paramInt2;
      n = 1;
    }
    for (int i1 = 0; i1 < i; i1++)
    {
      localObject = RecyclerView.b(B.d(i1));
      if (localObject != null)
      {
        int i2 = c;
        if ((i2 >= k) && (i2 <= m))
        {
          if (i2 == paramInt1) {
            ((RecyclerView.w)localObject).a(paramInt2 - paramInt1, false);
          } else {
            ((RecyclerView.w)localObject).a(n, false);
          }
          C0.f = true;
        }
      }
    }
    Object localObject = y;
    if (paramInt1 < paramInt2)
    {
      m = paramInt1;
      n = paramInt2;
      k = j;
    }
    else
    {
      n = paramInt1;
      m = paramInt2;
      k = 1;
    }
    j = c.size();
    for (i1 = 0; i1 < j; i1++)
    {
      RecyclerView.w localw = (RecyclerView.w)c.get(i1);
      if (localw != null)
      {
        i = c;
        if ((i >= m) && (i <= n)) {
          if (i == paramInt1) {
            localw.a(paramInt2 - paramInt1, false);
          } else {
            localw.a(k, false);
          }
        }
      }
    }
    localRecyclerView.requestLayout();
    a.F0 = true;
  }
}

/* Location:
 * Qualified Name:     d.t.a.t
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */