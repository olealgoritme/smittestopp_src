package d.g.a.h;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class f
{
  public List<d> a;
  public int b = -1;
  public int c = -1;
  public boolean d = false;
  public final int[] e = { -1, -1 };
  public List<d> f = new ArrayList();
  public List<d> g = new ArrayList();
  public HashSet<d> h = new HashSet();
  public HashSet<d> i = new HashSet();
  public List<d> j = new ArrayList();
  public List<d> k = new ArrayList();
  
  public f(List<d> paramList)
  {
    a = paramList;
  }
  
  public f(List<d> paramList, boolean paramBoolean)
  {
    a = paramList;
    d = paramBoolean;
  }
  
  public final void a(d paramd)
  {
    if (b0)
    {
      if (paramd.j()) {
        return;
      }
      Object localObject1 = u.d;
      int m = 0;
      if (localObject1 != null) {
        n = 1;
      } else {
        n = 0;
      }
      if (n != 0) {
        localObject1 = u.d;
      } else {
        localObject1 = s.d;
      }
      if (localObject1 != null)
      {
        localObject2 = b;
        if (!c0) {
          a((d)localObject2);
        }
        localObject2 = c;
        if (localObject2 == c.c.RIGHT)
        {
          localObject1 = b;
          i1 = I;
          i1 = ((d)localObject1).i() + i1;
          break label146;
        }
        if (localObject2 == c.c.LEFT)
        {
          i1 = b.I;
          break label146;
        }
      }
      int i1 = 0;
      label146:
      if (n != 0)
      {
        i1 -= u.a();
      }
      else
      {
        n = s.a();
        i1 += paramd.i() + n;
      }
      paramd.a(i1 - paramd.i(), i1);
      Object localObject2 = w.d;
      if (localObject2 != null)
      {
        localObject1 = b;
        if (!c0) {
          a((d)localObject1);
        }
        localObject1 = b;
        i1 = J + Q - Q;
        paramd.c(i1, F + i1);
        c0 = true;
        return;
      }
      if (v.d != null) {
        m = 1;
      }
      if (m != 0) {
        localObject1 = v.d;
      } else {
        localObject1 = t.d;
      }
      int n = i1;
      if (localObject1 != null)
      {
        localObject2 = b;
        if (!c0) {
          a((d)localObject2);
        }
        localObject2 = c;
        if (localObject2 == c.c.BOTTOM)
        {
          localObject1 = b;
          n = J + ((d)localObject1).d();
        }
        else
        {
          n = i1;
          if (localObject2 == c.c.TOP) {
            n = b.J;
          }
        }
      }
      if (m != 0)
      {
        i1 = n - v.a();
      }
      else
      {
        i1 = t.a();
        i1 = n + (paramd.d() + i1);
      }
      paramd.c(i1 - paramd.d(), i1);
      c0 = true;
    }
  }
  
  public void a(d paramd, int paramInt)
  {
    if (paramInt == 0) {
      h.add(paramd);
    } else if (paramInt == 1) {
      i.add(paramd);
    }
  }
  
  public final void a(ArrayList<d> paramArrayList, d paramd)
  {
    if (d0) {
      return;
    }
    paramArrayList.add(paramd);
    d0 = true;
    if (paramd.j()) {
      return;
    }
    boolean bool = paramd instanceof h;
    int m = 0;
    Object localObject;
    if (bool)
    {
      localObject = (h)paramd;
      n = l0;
      for (i1 = 0; i1 < n; i1++) {
        a(paramArrayList, k0[i1]);
      }
    }
    int n = A.length;
    for (int i1 = m; i1 < n; i1++)
    {
      localObject = A[i1].d;
      if (localObject != null)
      {
        localObject = b;
        if (localObject != D) {
          a(paramArrayList, (d)localObject);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.d.g.a.h.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */