package d.x;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import e.a.a.a.a;
import java.util.ArrayList;
import java.util.Iterator;

public class n
  extends h
{
  public ArrayList<h> f0 = new ArrayList();
  public boolean g0 = true;
  public int h0;
  public boolean i0 = false;
  public int j0 = 0;
  
  public h a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < f0.size())) {
      return (h)f0.get(paramInt);
    }
    return null;
  }
  
  public h a(View paramView)
  {
    for (int i = 0; i < f0.size(); i++) {
      ((h)f0.get(i)).a(paramView);
    }
    C.add(paramView);
    return this;
  }
  
  public h a(h.d paramd)
  {
    super.a(paramd);
    return this;
  }
  
  public n a(long paramLong)
  {
    z = paramLong;
    if (paramLong >= 0L)
    {
      int i = f0.size();
      for (int j = 0; j < i; j++) {
        ((h)f0.get(j)).a(paramLong);
      }
    }
    return this;
  }
  
  public n a(TimeInterpolator paramTimeInterpolator)
  {
    j0 |= 0x1;
    ArrayList localArrayList = f0;
    if (localArrayList != null)
    {
      int i = localArrayList.size();
      for (int j = 0; j < i; j++) {
        ((h)f0.get(j)).a(paramTimeInterpolator);
      }
    }
    A = paramTimeInterpolator;
    return this;
  }
  
  public n a(h paramh)
  {
    f0.add(paramh);
    O = this;
    long l = z;
    if (l >= 0L) {
      paramh.a(l);
    }
    if ((j0 & 0x1) != 0) {
      paramh.a(A);
    }
    if ((j0 & 0x2) != 0) {
      paramh.a(null);
    }
    if ((j0 & 0x4) != 0) {
      paramh.a(b0);
    }
    if ((j0 & 0x8) != 0) {
      paramh.a(a0);
    }
    return this;
  }
  
  public String a(String paramString)
  {
    Object localObject = super.a(paramString);
    for (int i = 0; i < f0.size(); i++)
    {
      localObject = a.a((String)localObject, "\n");
      h localh = (h)f0.get(i);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("  ");
      ((StringBuilder)localObject).append(localh.a(localStringBuilder.toString()));
      localObject = ((StringBuilder)localObject).toString();
    }
    return (String)localObject;
  }
  
  public void a(ViewGroup paramViewGroup, q paramq1, q paramq2, ArrayList<p> paramArrayList1, ArrayList<p> paramArrayList2)
  {
    long l1 = y;
    int i = f0.size();
    for (int j = 0; j < i; j++)
    {
      h localh = (h)f0.get(j);
      if ((l1 > 0L) && ((g0) || (j == 0)))
      {
        long l2 = y;
        if (l2 > 0L) {
          localh.b(l2 + l1);
        } else {
          localh.b(l1);
        }
      }
      localh.a(paramViewGroup, paramq1, paramq2, paramArrayList1, paramArrayList2);
    }
  }
  
  public void a(e parame)
  {
    if (parame == null) {
      b0 = h.d0;
    } else {
      b0 = parame;
    }
    j0 |= 0x4;
    for (int i = 0; i < f0.size(); i++) {
      ((h)f0.get(i)).a(parame);
    }
  }
  
  public void a(h.c paramc)
  {
    a0 = paramc;
    j0 |= 0x8;
    int i = f0.size();
    for (int j = 0; j < i; j++) {
      ((h)f0.get(j)).a(paramc);
    }
  }
  
  public void a(m paramm)
  {
    Z = paramm;
    j0 |= 0x2;
    int i = f0.size();
    for (int j = 0; j < i; j++) {
      ((h)f0.get(j)).a(paramm);
    }
  }
  
  public void a(p paramp)
  {
    if (b(b))
    {
      Iterator localIterator = f0.iterator();
      while (localIterator.hasNext())
      {
        h localh = (h)localIterator.next();
        if (localh.b(b))
        {
          localh.a(paramp);
          c.add(localh);
        }
      }
    }
  }
  
  public h b(long paramLong)
  {
    y = paramLong;
    return this;
  }
  
  public h b(h.d paramd)
  {
    super.b(paramd);
    return this;
  }
  
  public n b(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        g0 = false;
      } else {
        throw new AndroidRuntimeException(a.a("Invalid parameter for TransitionSet ordering: ", paramInt));
      }
    }
    else {
      g0 = true;
    }
    return this;
  }
  
  public void b(p paramp)
  {
    int i = f0.size();
    for (int j = 0; j < i; j++) {
      ((h)f0.get(j)).b(paramp);
    }
  }
  
  public void c()
  {
    if (f0.isEmpty())
    {
      d();
      a();
      return;
    }
    Object localObject = new b(this);
    Iterator localIterator = f0.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).a((h.d)localObject);
    }
    h0 = f0.size();
    if (!g0)
    {
      for (int i = 1; i < f0.size(); i++) {
        ((h)f0.get(i - 1)).a(new a((h)f0.get(i)));
      }
      localObject = (h)f0.get(0);
      if (localObject != null) {
        ((h)localObject).c();
      }
    }
    else
    {
      localObject = f0.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((h)((Iterator)localObject).next()).c();
      }
    }
  }
  
  public void c(View paramView)
  {
    super.c(paramView);
    int i = f0.size();
    for (int j = 0; j < i; j++) {
      ((h)f0.get(j)).c(paramView);
    }
  }
  
  public void c(p paramp)
  {
    if (b(b))
    {
      Iterator localIterator = f0.iterator();
      while (localIterator.hasNext())
      {
        h localh = (h)localIterator.next();
        if (localh.b(b))
        {
          localh.c(paramp);
          c.add(localh);
        }
      }
    }
  }
  
  public h clone()
  {
    n localn = (n)super.clone();
    f0 = new ArrayList();
    int i = f0.size();
    for (int j = 0; j < i; j++) {
      localn.a(((h)f0.get(j)).clone());
    }
    return localn;
  }
  
  public h d(View paramView)
  {
    for (int i = 0; i < f0.size(); i++) {
      ((h)f0.get(i)).d(paramView);
    }
    C.remove(paramView);
    return this;
  }
  
  public void e(View paramView)
  {
    super.e(paramView);
    int i = f0.size();
    for (int j = 0; j < i; j++) {
      ((h)f0.get(j)).e(paramView);
    }
  }
  
  public class a
    extends k
  {
    public a(h paramh) {}
    
    public void d(h paramh)
    {
      a.c();
      paramh.b(this);
    }
  }
  
  public static class b
    extends k
  {
    public n a;
    
    public b(n paramn)
    {
      a = paramn;
    }
    
    public void a(h paramh)
    {
      paramh = a;
      if (!i0)
      {
        paramh.d();
        a.i0 = true;
      }
    }
    
    public void d(h paramh)
    {
      n localn = a;
      int i = h0 - 1;
      h0 = i;
      if (i == 0)
      {
        i0 = false;
        localn.a();
      }
      paramh.b(this);
    }
  }
}

/* Location:
 * Qualified Name:     d.x.n
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */