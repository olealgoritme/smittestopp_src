package androidx.recyclerview.widget;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import d.i.i.n;
import d.t.a.b;
import d.t.a.b.a;
import d.t.a.m.b;
import d.t.a.s;
import d.t.a.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class RecyclerView$p
{
  public final ArrayList<RecyclerView.w> a = new ArrayList();
  public ArrayList<RecyclerView.w> b = null;
  public final ArrayList<RecyclerView.w> c = new ArrayList();
  public final List<RecyclerView.w> d = Collections.unmodifiableList(a);
  public int e = 2;
  public int f = 2;
  public RecyclerView.o g;
  
  public RecyclerView$p(RecyclerView paramRecyclerView) {}
  
  public int a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < h.C0.a()))
    {
      localObject = h;
      if (!C0.g) {
        return paramInt;
      }
      return A.a(paramInt, 0);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("invalid position ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(". State ");
    ((StringBuilder)localObject).append("item count is ");
    ((StringBuilder)localObject).append(h.C0.a());
    throw new IndexOutOfBoundsException(e.a.a.a.a.a(h, (StringBuilder)localObject));
  }
  
  public RecyclerView.w a(int paramInt, boolean paramBoolean, long paramLong)
  {
    if ((paramInt >= 0) && (paramInt < h.C0.a()))
    {
      boolean bool = h.C0.g;
      int i = 1;
      if (bool)
      {
        localObject1 = b;
        if (localObject1 != null)
        {
          j = ((ArrayList)localObject1).size();
          if (j != 0)
          {
            for (k = 0; k < j; k++)
            {
              localObject1 = (RecyclerView.w)b.get(k);
              if ((!((RecyclerView.w)localObject1).w()) && (((RecyclerView.w)localObject1).g() == paramInt))
              {
                ((RecyclerView.w)localObject1).a(32);
                break label126;
              }
            }
            throw null;
          }
        }
        localObject1 = null;
        label126:
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          k = 1;
          break label151;
        }
      }
      else
      {
        localObject2 = null;
      }
      int k = 0;
      localObject1 = localObject2;
      label151:
      int j = k;
      Object localObject2 = localObject1;
      Object localObject3;
      if (localObject1 == null)
      {
        int m = a.size();
        for (j = 0; j < m; j++)
        {
          localObject1 = (RecyclerView.w)a.get(j);
          if ((!((RecyclerView.w)localObject1).w()) && (((RecyclerView.w)localObject1).g() == paramInt) && (!((RecyclerView.w)localObject1).l()) && ((h.C0.g) || (!((RecyclerView.w)localObject1).n())))
          {
            ((RecyclerView.w)localObject1).a(32);
            break label698;
          }
        }
        if (!paramBoolean)
        {
          localObject3 = h.B;
          m = c.size();
          j = 0;
          while (j < m)
          {
            localObject1 = (View)c.get(j);
            if ((s)a != null)
            {
              localObject2 = RecyclerView.b((View)localObject1);
              if ((((RecyclerView.w)localObject2).g() == paramInt) && (!((RecyclerView.w)localObject2).l()) && (!((RecyclerView.w)localObject2).n())) {
                break label368;
              }
              j++;
            }
            else
            {
              throw null;
            }
          }
          localObject1 = null;
          label368:
          if (localObject1 != null)
          {
            localObject2 = RecyclerView.b((View)localObject1);
            localObject3 = h.B;
            j = a).a.indexOfChild((View)localObject1);
            if (j >= 0)
            {
              if (b.c(j))
              {
                b.a(j);
                ((b)localObject3).c((View)localObject1);
                j = h.B.a((View)localObject1);
                if (j != -1)
                {
                  h.B.a(j);
                  b((View)localObject1);
                  ((RecyclerView.w)localObject2).a(8224);
                  localObject1 = localObject2;
                  break label698;
                }
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("layout index should not be -1 after unhiding a view:");
                ((StringBuilder)localObject1).append(localObject2);
                throw new IllegalStateException(e.a.a.a.a.a(h, (StringBuilder)localObject1));
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("trying to unhide a view that was not hidden");
              ((StringBuilder)localObject2).append(localObject1);
              throw new RuntimeException(((StringBuilder)localObject2).toString());
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("view is not a child, cannot hide ");
            ((StringBuilder)localObject2).append(localObject1);
            throw new IllegalArgumentException(((StringBuilder)localObject2).toString());
          }
        }
        m = c.size();
        for (j = 0; j < m; j++)
        {
          localObject2 = (RecyclerView.w)c.get(j);
          if ((!((RecyclerView.w)localObject2).l()) && (((RecyclerView.w)localObject2).g() == paramInt))
          {
            localObject1 = localObject2;
            if (paramBoolean) {
              break label698;
            }
            c.remove(j);
            localObject1 = localObject2;
            break label698;
          }
        }
        localObject1 = null;
        label698:
        j = k;
        localObject2 = localObject1;
        if (localObject1 != null) {
          if (((RecyclerView.w)localObject1).n())
          {
            if (!h.C0.g)
            {
              if (!paramBoolean)
              {
                ((RecyclerView.w)localObject1).a(4);
                if (((RecyclerView.w)localObject1).o())
                {
                  h.removeDetachedView(a, false);
                  ((RecyclerView.w)localObject1).v();
                }
                else if (((RecyclerView.w)localObject1).w())
                {
                  ((RecyclerView.w)localObject1).b();
                }
                a((RecyclerView.w)localObject1);
              }
              localObject2 = null;
              j = k;
            }
            else
            {
              j = 1;
              localObject2 = localObject1;
            }
          }
          else
          {
            if (c >= 0) {
              throw null;
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("Inconsistency detected. Invalid view holder adapter position");
            ((StringBuilder)localObject2).append(localObject1);
            throw new IndexOutOfBoundsException(e.a.a.a.a.a(h, (StringBuilder)localObject2));
          }
        }
      }
      if (localObject2 == null)
      {
        k = h.A.a(paramInt, 0);
        if (k >= 0) {
          throw null;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Inconsistency detected. Invalid item position ");
        ((StringBuilder)localObject1).append(paramInt);
        ((StringBuilder)localObject1).append("(offset:");
        ((StringBuilder)localObject1).append(k);
        ((StringBuilder)localObject1).append(").");
        ((StringBuilder)localObject1).append("state:");
        ((StringBuilder)localObject1).append(h.C0.a());
        throw new IndexOutOfBoundsException(e.a.a.a.a.a(h, (StringBuilder)localObject1));
      }
      if ((j != 0) && (!h.C0.g) && (((RecyclerView.w)localObject2).b(8192)))
      {
        ((RecyclerView.w)localObject2).a(0, 8192);
        if (h.C0.j)
        {
          RecyclerView.h.d((RecyclerView.w)localObject2);
          localObject3 = h;
          localObject1 = k0;
          localObject3 = C0;
          ((RecyclerView.w)localObject2).i();
          localObject1 = ((RecyclerView.h)localObject1).c((RecyclerView.w)localObject2);
          h.a((RecyclerView.w)localObject2, (RecyclerView.h.c)localObject1);
        }
      }
      if ((h.C0.g) && (((RecyclerView.w)localObject2).k()))
      {
        f = paramInt;
      }
      else if ((!((RecyclerView.w)localObject2).k()) || (((RecyclerView.w)localObject2).r()) || (((RecyclerView.w)localObject2).l()))
      {
        h.A.a(paramInt, 0);
        q = h;
        paramInt = ((RecyclerView.w)localObject2).f();
        long l1 = h.getNanoTime();
        if (paramLong == Long.MAX_VALUE) {
          break label1326;
        }
        long l2 = g.a(paramInt).d;
        paramInt = i;
        if (l2 != 0L) {
          if (l1 + l2 < paramLong) {
            paramInt = i;
          } else {
            paramInt = 0;
          }
        }
        if (paramInt != 0) {
          break label1326;
        }
      }
      localObject1 = a.getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = (RecyclerView.k)h.generateDefaultLayoutParams();
        a.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      else if (!h.checkLayoutParams((ViewGroup.LayoutParams)localObject1))
      {
        localObject1 = (RecyclerView.k)h.generateLayoutParams((ViewGroup.LayoutParams)localObject1);
        a.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      else
      {
        localObject1 = (RecyclerView.k)localObject1;
      }
      a = ((RecyclerView.w)localObject2);
      d = false;
      return (RecyclerView.w)localObject2;
      label1326:
      throw null;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Invalid item position ");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append("(");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append("). Item count:");
    ((StringBuilder)localObject1).append(h.C0.a());
    throw new IndexOutOfBoundsException(e.a.a.a.a.a(h, (StringBuilder)localObject1));
  }
  
  public void a()
  {
    a.clear();
    c();
  }
  
  public void a(View paramView)
  {
    RecyclerView.w localw = RecyclerView.b(paramView);
    if (localw.p()) {
      h.removeDetachedView(paramView, false);
    }
    if (localw.o()) {
      localw.v();
    } else if (localw.w()) {
      localw.b();
    }
    a(localw);
  }
  
  public void a(RecyclerView.w paramw)
  {
    boolean bool1 = paramw.o();
    boolean bool2 = false;
    int i = 0;
    int j = 1;
    if ((!bool1) && (a.getParent() == null))
    {
      if (!paramw.p())
      {
        if (!paramw.u())
        {
          bool2 = paramw.d();
          if (paramw.m())
          {
            if ((f > 0) && (!paramw.b(526)))
            {
              i = c.size();
              k = i;
              if (i >= f)
              {
                k = i;
                if (i > 0)
                {
                  b(0);
                  k = i - 1;
                }
              }
              i = k;
              if (RecyclerView.X0)
              {
                i = k;
                if (k > 0)
                {
                  i = k;
                  if (!h.B0.a(c))
                  {
                    int m;
                    do
                    {
                      i = k - 1;
                      if (i < 0) {
                        break;
                      }
                      m = c.get(i)).c;
                      k = i;
                    } while (h.B0.a(m));
                    i++;
                  }
                }
              }
              c.add(i, paramw);
              k = 1;
            }
            else
            {
              k = 0;
            }
            i = k;
            if (k == 0)
            {
              a(paramw, true);
              break label249;
            }
          }
          j = 0;
          int k = i;
          label249:
          h.C.a(paramw);
          if ((k == 0) && (j == 0) && (bool2)) {
            q = null;
          }
          return;
        }
        paramw = e.a.a.a.a.a("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
        throw new IllegalArgumentException(e.a.a.a.a.a(h, paramw));
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
      localStringBuilder.append(paramw);
      throw new IllegalArgumentException(e.a.a.a.a.a(h, localStringBuilder));
    }
    StringBuilder localStringBuilder = e.a.a.a.a.a("Scrapped or attached views may not be recycled. isScrap:");
    localStringBuilder.append(paramw.o());
    localStringBuilder.append(" isAttached:");
    if (a.getParent() != null) {
      bool2 = true;
    }
    localStringBuilder.append(bool2);
    throw new IllegalArgumentException(e.a.a.a.a.a(h, localStringBuilder));
  }
  
  public void a(RecyclerView.w paramw, boolean paramBoolean)
  {
    RecyclerView.b(paramw);
    if (paramw.b(16384))
    {
      paramw.a(0, 16384);
      n.a(a, null);
    }
    if (paramBoolean)
    {
      localObject = h.J;
      if (localObject != null) {
        ((RecyclerView.q)localObject).a(paramw);
      }
      localObject = h;
      if (C0 != null) {
        C.a(paramw);
      }
    }
    q = null;
    Object localObject = b();
    if (localObject != null)
    {
      int i = paramw.f();
      ArrayList localArrayList = aa;
      if (a.get(i)).b > localArrayList.size())
      {
        paramw.s();
        localArrayList.add(paramw);
      }
      return;
    }
    throw null;
  }
  
  public RecyclerView.o b()
  {
    if (g == null) {
      g = new RecyclerView.o();
    }
    return g;
  }
  
  public void b(int paramInt)
  {
    a((RecyclerView.w)c.get(paramInt), true);
    c.remove(paramInt);
  }
  
  public void b(View paramView)
  {
    paramView = RecyclerView.b(paramView);
    if ((!paramView.b(12)) && (paramView.q()))
    {
      RecyclerView.h localh = h.k0;
      int i;
      if ((localh != null) && (!localh.a(paramView, paramView.i()))) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0)
      {
        if (b == null) {
          b = new ArrayList();
        }
        paramView.a(this, true);
        b.add(paramView);
        return;
      }
    }
    if ((paramView.l()) && (!paramView.n())) {
      throw null;
    }
    paramView.a(this, false);
    a.add(paramView);
  }
  
  public void b(RecyclerView.w paramw)
  {
    if (n) {
      b.remove(paramw);
    } else {
      a.remove(paramw);
    }
    m = null;
    n = false;
    paramw.b();
  }
  
  public void c()
  {
    for (int i = c.size() - 1; i >= 0; i--) {
      b(i);
    }
    c.clear();
    if (RecyclerView.X0)
    {
      m.b localb = h.B0;
      int[] arrayOfInt = c;
      if (arrayOfInt != null) {
        Arrays.fill(arrayOfInt, -1);
      }
      d = 0;
    }
  }
  
  public void d()
  {
    RecyclerView.LayoutManager localLayoutManager = h.I;
    if (localLayoutManager != null) {
      i = l;
    } else {
      i = 0;
    }
    f = (e + i);
    for (int i = c.size() - 1; (i >= 0) && (c.size() > f); i--) {
      b(i);
    }
  }
}

/* Location:
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.p
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */