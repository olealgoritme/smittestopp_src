package d.t.a;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.List;

public class k
  extends w
{
  public ArrayList<s.x> h = new ArrayList();
  public ArrayList<s.x> i = new ArrayList();
  public ArrayList<k.b> j = new ArrayList();
  public ArrayList<k.a> k = new ArrayList();
  public ArrayList<ArrayList<s.x>> l = new ArrayList();
  public ArrayList<ArrayList<k.b>> m = new ArrayList();
  public ArrayList<ArrayList<k.a>> n = new ArrayList();
  public ArrayList<s.x> o = new ArrayList();
  public ArrayList<s.x> p = new ArrayList();
  public ArrayList<s.x> q = new ArrayList();
  public ArrayList<s.x> r = new ArrayList();
  
  public void a(List<s.x> paramList)
  {
    for (int i1 = paramList.size() - 1; i1 >= 0; i1--) {
      geta.animate().cancel();
    }
  }
  
  public final void a(List<k.a> paramList, s.x paramx)
  {
    for (int i1 = paramList.size() - 1; i1 >= 0; i1--)
    {
      k.a locala = (k.a)paramList.get(i1);
      if ((a(locala, paramx)) && (a == null) && (b == null)) {
        paramList.remove(locala);
      }
    }
  }
  
  public final boolean a(k.a parama, s.x paramx)
  {
    if (b == paramx)
    {
      b = null;
    }
    else
    {
      if (a != paramx) {
        break label60;
      }
      a = null;
    }
    a.setAlpha(1.0F);
    a.setTranslationX(0.0F);
    a.setTranslationY(0.0F);
    a(paramx);
    return true;
    label60:
    return false;
  }
  
  public boolean a(s.x paramx, List<Object> paramList)
  {
    boolean bool;
    if ((paramList.isEmpty()) && (!super.a(paramx, paramList))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void b()
  {
    int i1 = j.size();
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      i1--;
      if (i1 < 0) {
        break;
      }
      localObject1 = (k.b)j.get(i1);
      localObject2 = a.a;
      ((View)localObject2).setTranslationY(0.0F);
      ((View)localObject2).setTranslationX(0.0F);
      a(a);
      j.remove(i1);
    }
    i1 = h.size();
    for (;;)
    {
      i1--;
      if (i1 < 0) {
        break;
      }
      a((s.x)h.get(i1));
      h.remove(i1);
    }
    i1 = i.size();
    for (;;)
    {
      i1--;
      if (i1 < 0) {
        break;
      }
      localObject2 = (s.x)i.get(i1);
      a.setAlpha(1.0F);
      a((s.x)localObject2);
      i.remove(i1);
    }
    i1 = k.size();
    for (;;)
    {
      i1--;
      if (i1 < 0) {
        break;
      }
      localObject2 = (k.a)k.get(i1);
      localObject1 = a;
      if (localObject1 != null) {
        a((k.a)localObject2, (s.x)localObject1);
      }
      localObject1 = b;
      if (localObject1 != null) {
        a((k.a)localObject2, (s.x)localObject1);
      }
    }
    k.clear();
    if (!c()) {
      return;
    }
    int i2;
    Object localObject3;
    for (i1 = m.size();; i1 = i2)
    {
      i2 = i1 - 1;
      if (i2 < 0) {
        break;
      }
      localObject2 = (ArrayList)m.get(i2);
      i1 = ((ArrayList)localObject2).size();
      for (;;)
      {
        i1--;
        if (i1 < 0) {
          break;
        }
        localObject3 = (k.b)((ArrayList)localObject2).get(i1);
        localObject1 = a.a;
        ((View)localObject1).setTranslationY(0.0F);
        ((View)localObject1).setTranslationX(0.0F);
        a(a);
        ((ArrayList)localObject2).remove(i1);
        if (((ArrayList)localObject2).isEmpty()) {
          m.remove(localObject2);
        }
      }
    }
    for (i1 = l.size();; i1 = i2)
    {
      i2 = i1 - 1;
      if (i2 < 0) {
        break;
      }
      localObject1 = (ArrayList)l.get(i2);
      i1 = ((ArrayList)localObject1).size();
      for (;;)
      {
        i1--;
        if (i1 < 0) {
          break;
        }
        localObject2 = (s.x)((ArrayList)localObject1).get(i1);
        a.setAlpha(1.0F);
        a((s.x)localObject2);
        ((ArrayList)localObject1).remove(i1);
        if (((ArrayList)localObject1).isEmpty()) {
          l.remove(localObject1);
        }
      }
    }
    for (i1 = n.size();; i1 = i2)
    {
      i2 = i1 - 1;
      if (i2 < 0) {
        break;
      }
      localObject2 = (ArrayList)n.get(i2);
      i1 = ((ArrayList)localObject2).size();
      for (;;)
      {
        i1--;
        if (i1 < 0) {
          break;
        }
        localObject1 = (k.a)((ArrayList)localObject2).get(i1);
        localObject3 = a;
        if (localObject3 != null) {
          a((k.a)localObject1, (s.x)localObject3);
        }
        localObject3 = b;
        if (localObject3 != null) {
          a((k.a)localObject1, (s.x)localObject3);
        }
        if (((ArrayList)localObject2).isEmpty()) {
          n.remove(localObject2);
        }
      }
    }
    a(q);
    a(p);
    a(o);
    a(r);
    a();
  }
  
  public void b(s.x paramx)
  {
    View localView = a;
    localView.animate().cancel();
    for (int i1 = j.size() - 1; i1 >= 0; i1--) {
      if (j.get(i1)).a == paramx)
      {
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        a(paramx);
        j.remove(i1);
      }
    }
    a(k, paramx);
    if (h.remove(paramx))
    {
      localView.setAlpha(1.0F);
      e(paramx);
    }
    if (i.remove(paramx))
    {
      localView.setAlpha(1.0F);
      a(paramx);
    }
    ArrayList localArrayList;
    for (i1 = n.size() - 1; i1 >= 0; i1--)
    {
      localArrayList = (ArrayList)n.get(i1);
      a(localArrayList, paramx);
      if (localArrayList.isEmpty()) {
        n.remove(i1);
      }
    }
    for (i1 = m.size() - 1; i1 >= 0; i1--)
    {
      localArrayList = (ArrayList)m.get(i1);
      for (int i2 = localArrayList.size() - 1; i2 >= 0; i2--) {
        if (geta == paramx)
        {
          localView.setTranslationY(0.0F);
          localView.setTranslationX(0.0F);
          a(paramx);
          localArrayList.remove(i2);
          if (!localArrayList.isEmpty()) {
            break;
          }
          m.remove(i1);
          break;
        }
      }
    }
    for (i1 = l.size() - 1; i1 >= 0; i1--)
    {
      localArrayList = (ArrayList)l.get(i1);
      if (localArrayList.remove(paramx))
      {
        localView.setAlpha(1.0F);
        a(paramx);
        if (localArrayList.isEmpty()) {
          l.remove(i1);
        }
      }
    }
    q.remove(paramx);
    o.remove(paramx);
    r.remove(paramx);
    p.remove(paramx);
    d();
  }
  
  public boolean c()
  {
    boolean bool;
    if ((i.isEmpty()) && (k.isEmpty()) && (j.isEmpty()) && (h.isEmpty()) && (p.isEmpty()) && (q.isEmpty()) && (o.isEmpty()) && (r.isEmpty()) && (m.isEmpty()) && (l.isEmpty()) && (n.isEmpty())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void d()
  {
    if (!c()) {
      a();
    }
  }
}

/* Location:
 * Qualified Name:     base.d.t.a.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */