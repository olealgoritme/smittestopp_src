package d.t.a;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.w;
import e.a.a.a.a;
import java.util.ArrayList;
import java.util.List;

public class k
  extends v
{
  public ArrayList<RecyclerView.w> h = new ArrayList();
  public ArrayList<RecyclerView.w> i = new ArrayList();
  public ArrayList<b> j = new ArrayList();
  public ArrayList<a> k = new ArrayList();
  public ArrayList<ArrayList<RecyclerView.w>> l = new ArrayList();
  public ArrayList<ArrayList<b>> m = new ArrayList();
  public ArrayList<ArrayList<a>> n = new ArrayList();
  public ArrayList<RecyclerView.w> o = new ArrayList();
  public ArrayList<RecyclerView.w> p = new ArrayList();
  public ArrayList<RecyclerView.w> q = new ArrayList();
  public ArrayList<RecyclerView.w> r = new ArrayList();
  
  public void a(List<RecyclerView.w> paramList)
  {
    for (int i1 = paramList.size() - 1; i1 >= 0; i1--) {
      geta.animate().cancel();
    }
  }
  
  public final void a(List<a> paramList, RecyclerView.w paramw)
  {
    for (int i1 = paramList.size() - 1; i1 >= 0; i1--)
    {
      a locala = (a)paramList.get(i1);
      if ((a(locala, paramw)) && (a == null) && (b == null)) {
        paramList.remove(locala);
      }
    }
  }
  
  public boolean a(RecyclerView.w paramw, List<Object> paramList)
  {
    boolean bool;
    if ((paramList.isEmpty()) && (!super.a(paramw, paramList))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public final boolean a(a parama, RecyclerView.w paramw)
  {
    if (b == paramw)
    {
      b = null;
    }
    else
    {
      if (a != paramw) {
        break label60;
      }
      a = null;
    }
    a.setAlpha(1.0F);
    a.setTranslationX(0.0F);
    a.setTranslationY(0.0F);
    a(paramw);
    return true;
    label60:
    return false;
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
      localObject1 = (b)j.get(i1);
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
      a((RecyclerView.w)h.get(i1));
      h.remove(i1);
    }
    i1 = i.size();
    for (;;)
    {
      i1--;
      if (i1 < 0) {
        break;
      }
      localObject2 = (RecyclerView.w)i.get(i1);
      a.setAlpha(1.0F);
      a((RecyclerView.w)localObject2);
      i.remove(i1);
    }
    i1 = k.size();
    for (;;)
    {
      i1--;
      if (i1 < 0) {
        break;
      }
      localObject2 = (a)k.get(i1);
      localObject1 = a;
      if (localObject1 != null) {
        a((a)localObject2, (RecyclerView.w)localObject1);
      }
      localObject1 = b;
      if (localObject1 != null) {
        a((a)localObject2, (RecyclerView.w)localObject1);
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
        localObject3 = (b)((ArrayList)localObject2).get(i1);
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
        localObject2 = (RecyclerView.w)((ArrayList)localObject1).get(i1);
        a.setAlpha(1.0F);
        a((RecyclerView.w)localObject2);
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
        localObject1 = (a)((ArrayList)localObject2).get(i1);
        localObject3 = a;
        if (localObject3 != null) {
          a((a)localObject1, (RecyclerView.w)localObject3);
        }
        localObject3 = b;
        if (localObject3 != null) {
          a((a)localObject1, (RecyclerView.w)localObject3);
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
  
  public void b(RecyclerView.w paramw)
  {
    View localView = a;
    localView.animate().cancel();
    for (int i1 = j.size() - 1; i1 >= 0; i1--) {
      if (j.get(i1)).a == paramw)
      {
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        a(paramw);
        j.remove(i1);
      }
    }
    a(k, paramw);
    if (h.remove(paramw))
    {
      localView.setAlpha(1.0F);
      e(paramw);
    }
    if (i.remove(paramw))
    {
      localView.setAlpha(1.0F);
      a(paramw);
    }
    ArrayList localArrayList;
    for (i1 = n.size() - 1; i1 >= 0; i1--)
    {
      localArrayList = (ArrayList)n.get(i1);
      a(localArrayList, paramw);
      if (localArrayList.isEmpty()) {
        n.remove(i1);
      }
    }
    for (i1 = m.size() - 1; i1 >= 0; i1--)
    {
      localArrayList = (ArrayList)m.get(i1);
      for (int i2 = localArrayList.size() - 1; i2 >= 0; i2--) {
        if (geta == paramw)
        {
          localView.setTranslationY(0.0F);
          localView.setTranslationX(0.0F);
          a(paramw);
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
      if (localArrayList.remove(paramw))
      {
        localView.setAlpha(1.0F);
        a(paramw);
        if (localArrayList.isEmpty()) {
          l.remove(i1);
        }
      }
    }
    q.remove(paramw);
    o.remove(paramw);
    r.remove(paramw);
    p.remove(paramw);
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
  
  public static class a
  {
    public RecyclerView.w a;
    public RecyclerView.w b;
    public int c;
    public int d;
    public int e;
    public int f;
    
    public String toString()
    {
      StringBuilder localStringBuilder = a.a("ChangeInfo{oldHolder=");
      localStringBuilder.append(a);
      localStringBuilder.append(", newHolder=");
      localStringBuilder.append(b);
      localStringBuilder.append(", fromX=");
      localStringBuilder.append(c);
      localStringBuilder.append(", fromY=");
      localStringBuilder.append(d);
      localStringBuilder.append(", toX=");
      localStringBuilder.append(e);
      localStringBuilder.append(", toY=");
      localStringBuilder.append(f);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
  
  public static class b
  {
    public RecyclerView.w a;
    public int b;
    public int c;
    public int d;
    public int e;
  }
}

/* Location:
 * Qualified Name:     d.t.a.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */