package d.t.a;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public abstract class s$h
{
  public s.h.b a = null;
  public ArrayList<s.h.a> b = new ArrayList();
  public long c = 120L;
  public long d = 120L;
  public long e = 250L;
  public long f = 250L;
  
  public static int d(s.x paramx)
  {
    int i = paramx.i & 0xE;
    if (paramx.l()) {
      return 4;
    }
    int j = i;
    if ((i & 0x4) == 0)
    {
      int k = paramx.h();
      int m = paramx.e();
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
      ((s.h.a)b.get(j)).a();
    }
    b.clear();
  }
  
  public final void a(s.x paramx)
  {
    Object localObject1 = a;
    if (localObject1 != null)
    {
      s.i locali = (s.i)localObject1;
      if (locali != null)
      {
        int i = 1;
        paramx.a(true);
        if ((g != null) && (h == null)) {
          g = null;
        }
        h = null;
        if (!paramx.t())
        {
          localObject1 = a;
          Object localObject2 = a;
          ((s)localObject1).q();
          b localb = B;
          int j = a).a.indexOfChild((View)localObject2);
          if (j == -1)
          {
            localb.c((View)localObject2);
          }
          else if (b.c(j))
          {
            b.d(j);
            localb.c((View)localObject2);
            ((t)a).b(j);
          }
          else
          {
            i = 0;
          }
          if (i != 0)
          {
            localObject2 = s.b((View)localObject2);
            y.b((s.x)localObject2);
            y.a((s.x)localObject2);
          }
          ((s)localObject1).b(i ^ 0x1);
          if ((i == 0) && (paramx.p())) {
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
  
  public boolean a(s.x paramx, List<Object> paramList)
  {
    boolean bool;
    if ((g) && (!paramx.l())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public abstract void b();
  
  public abstract void b(s.x paramx);
  
  public s.h.c c(s.u paramu, s.x paramx, int paramInt, List<Object> paramList)
  {
    paramx = new s.h.c();
    paramu = a;
    a = paramu.getLeft();
    b = paramu.getTop();
    paramu.getRight();
    paramu.getBottom();
    return paramx;
  }
  
  public abstract boolean c();
}

/* Location:
 * Qualified Name:     base.d.t.a.s.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */