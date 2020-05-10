package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import d.t.a.b;
import d.t.a.b.a;
import d.t.a.s;
import d.t.a.v;
import java.util.ArrayList;
import java.util.List;

public abstract class RecyclerView$h
{
  public b a = null;
  public ArrayList<a> b = new ArrayList();
  public long c = 120L;
  public long d = 120L;
  public long e = 250L;
  public long f = 250L;
  
  public static int d(RecyclerView.w paramw)
  {
    int i = paramw.i & 0xE;
    if (paramw.l()) {
      return 4;
    }
    int j = i;
    if ((i & 0x4) == 0)
    {
      int k = paramw.h();
      int m = paramw.e();
      j = i;
      if (k != -1)
      {
        j = i;
        if (m != -1)
        {
          j = i;
          if (k != m) {
            j = i | 0x800;
          }
        }
      }
    }
    return j;
  }
  
  public final void a()
  {
    int i = b.size();
    for (int j = 0; j < i; j++) {
      ((a)b.get(j)).a();
    }
    b.clear();
  }
  
  public final void a(RecyclerView.w paramw)
  {
    Object localObject1 = a;
    if (localObject1 != null)
    {
      localObject1 = (RecyclerView.i)localObject1;
      if (localObject1 != null)
      {
        int i = 1;
        paramw.a(true);
        if ((g != null) && (h == null)) {
          g = null;
        }
        h = null;
        if (!paramw.t())
        {
          RecyclerView localRecyclerView = a;
          View localView = a;
          localRecyclerView.q();
          Object localObject2 = B;
          int j = a).a.indexOfChild(localView);
          if (j == -1)
          {
            ((b)localObject2).c(localView);
          }
          else if (b.c(j))
          {
            b.d(j);
            ((b)localObject2).c(localView);
            ((s)a).b(j);
          }
          else
          {
            i = 0;
          }
          if (i != 0)
          {
            localObject2 = RecyclerView.b(localView);
            y.b((RecyclerView.w)localObject2);
            y.a((RecyclerView.w)localObject2);
          }
          localRecyclerView.b(i ^ 0x1);
          if ((i == 0) && (paramw.p())) {
            a.removeDetachedView(a, false);
          }
        }
      }
      else
      {
        throw null;
      }
    }
  }
  
  public boolean a(RecyclerView.w paramw, List<Object> paramList)
  {
    boolean bool;
    if ((g) && (!paramw.l())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public abstract void b();
  
  public abstract void b(RecyclerView.w paramw);
  
  public c c(RecyclerView.t paramt, RecyclerView.w paramw, int paramInt, List<Object> paramList)
  {
    paramw = new c();
    paramt = a;
    a = paramt.getLeft();
    b = paramt.getTop();
    paramt.getRight();
    paramt.getBottom();
    return paramw;
  }
  
  public abstract boolean c();
  
  public static abstract interface a
  {
    public abstract void a();
  }
  
  public static abstract interface b {}
  
  public static class c
  {
    public int a;
    public int b;
  }
}

/* Location:
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */