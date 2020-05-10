package d.x;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import d.m.a.j0;
import java.util.ArrayList;
import java.util.List;

public class d
  extends j0
{
  public static boolean a(h paramh)
  {
    boolean bool;
    if ((j0.a(B)) && (j0.a(D)) && (j0.a(E))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public Object a(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    paramObject1 = (h)paramObject1;
    paramObject2 = (h)paramObject2;
    h localh = (h)paramObject3;
    if ((paramObject1 != null) && (paramObject2 != null))
    {
      paramObject3 = new n();
      ((n)paramObject3).a((h)paramObject1);
      ((n)paramObject3).a((h)paramObject2);
      ((n)paramObject3).b(1);
      paramObject1 = paramObject3;
    }
    else if (paramObject1 == null)
    {
      if (paramObject2 != null) {
        paramObject1 = paramObject2;
      } else {
        paramObject1 = null;
      }
    }
    if (localh != null)
    {
      paramObject2 = new n();
      if (paramObject1 != null) {
        ((n)paramObject2).a((h)paramObject1);
      }
      ((n)paramObject2).a(localh);
      return paramObject2;
    }
    return paramObject1;
  }
  
  public void a(ViewGroup paramViewGroup, Object paramObject)
  {
    l.a(paramViewGroup, (h)paramObject);
  }
  
  public void a(Object paramObject, final Rect paramRect)
  {
    if (paramObject != null) {
      ((h)paramObject).a(new d(paramRect));
    }
  }
  
  public void a(Object paramObject, View paramView)
  {
    if (paramObject != null) {
      ((h)paramObject).a(paramView);
    }
  }
  
  public void a(Object paramObject, final View paramView, final ArrayList<View> paramArrayList)
  {
    ((h)paramObject).a(new b(paramView, paramArrayList));
  }
  
  public void a(Object paramObject1, final Object paramObject2, final ArrayList<View> paramArrayList1, final Object paramObject3, final ArrayList<View> paramArrayList2, final Object paramObject4, final ArrayList<View> paramArrayList3)
  {
    ((h)paramObject1).a(new c(paramObject2, paramArrayList1, paramObject3, paramArrayList2, paramObject4, paramArrayList3));
  }
  
  public void a(Object paramObject, ArrayList<View> paramArrayList)
  {
    paramObject = (h)paramObject;
    if (paramObject == null) {
      return;
    }
    boolean bool = paramObject instanceof n;
    int i = 0;
    int j = 0;
    if (bool)
    {
      paramObject = (n)paramObject;
      i = f0.size();
      while (j < i)
      {
        a(((n)paramObject).a(j), paramArrayList);
        j++;
      }
    }
    if ((!a((h)paramObject)) && (j0.a(C)))
    {
      int k = paramArrayList.size();
      for (j = i; j < k; j++) {
        ((h)paramObject).a((View)paramArrayList.get(j));
      }
    }
  }
  
  public void a(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2)
  {
    h localh = (h)paramObject;
    boolean bool = localh instanceof n;
    int i = 0;
    int j = 0;
    if (bool)
    {
      paramObject = (n)localh;
      i = f0.size();
      while (j < i)
      {
        a(((n)paramObject).a(j), paramArrayList1, paramArrayList2);
        j++;
      }
    }
    if (!a(localh))
    {
      paramObject = C;
      if ((((List)paramObject).size() == paramArrayList1.size()) && (((List)paramObject).containsAll(paramArrayList1)))
      {
        if (paramArrayList2 == null) {
          j = 0;
        } else {
          j = paramArrayList2.size();
        }
        while (i < j)
        {
          localh.a((View)paramArrayList2.get(i));
          i++;
        }
        j = paramArrayList1.size();
        for (;;)
        {
          j--;
          if (j < 0) {
            break;
          }
          localh.d((View)paramArrayList1.get(j));
        }
      }
    }
  }
  
  public boolean a(Object paramObject)
  {
    return paramObject instanceof h;
  }
  
  public Object b(Object paramObject)
  {
    if (paramObject != null) {
      paramObject = ((h)paramObject).clone();
    } else {
      paramObject = null;
    }
    return paramObject;
  }
  
  public Object b(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    n localn = new n();
    if (paramObject1 != null) {
      localn.a((h)paramObject1);
    }
    if (paramObject2 != null) {
      localn.a((h)paramObject2);
    }
    if (paramObject3 != null) {
      localn.a((h)paramObject3);
    }
    return localn;
  }
  
  public void b(Object paramObject, View paramView)
  {
    if (paramObject != null) {
      ((h)paramObject).d(paramView);
    }
  }
  
  public void b(Object paramObject, View paramView, ArrayList<View> paramArrayList)
  {
    n localn = (n)paramObject;
    paramObject = C;
    ((List)paramObject).clear();
    int i = paramArrayList.size();
    for (int j = 0; j < i; j++) {
      j0.a((List)paramObject, (View)paramArrayList.get(j));
    }
    ((List)paramObject).add(paramView);
    paramArrayList.add(paramView);
    a(localn, paramArrayList);
  }
  
  public void b(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2)
  {
    paramObject = (n)paramObject;
    if (paramObject != null)
    {
      C.clear();
      C.addAll(paramArrayList2);
      a(paramObject, paramArrayList1, paramArrayList2);
    }
  }
  
  public Object c(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    n localn = new n();
    localn.a((h)paramObject);
    return localn;
  }
  
  public void c(final Object paramObject, View paramView)
  {
    if (paramView != null)
    {
      h localh = (h)paramObject;
      paramObject = new Rect();
      a(paramView, (Rect)paramObject);
      localh.a(new a((Rect)paramObject));
    }
  }
  
  public class a
    extends h.c
  {
    public a(Rect paramRect) {}
  }
  
  public class b
    implements h.d
  {
    public b(View paramView, ArrayList paramArrayList) {}
    
    public void a(h paramh) {}
    
    public void b(h paramh) {}
    
    public void c(h paramh) {}
    
    public void d(h paramh)
    {
      paramh.b(this);
      paramView.setVisibility(8);
      int i = paramArrayList.size();
      for (int j = 0; j < i; j++) {
        ((View)paramArrayList.get(j)).setVisibility(0);
      }
    }
  }
  
  public class c
    implements h.d
  {
    public c(Object paramObject1, ArrayList paramArrayList1, Object paramObject2, ArrayList paramArrayList2, Object paramObject3, ArrayList paramArrayList3) {}
    
    public void a(h paramh)
    {
      paramh = paramObject2;
      if (paramh != null) {
        a(paramh, paramArrayList1, null);
      }
      paramh = paramObject3;
      if (paramh != null) {
        a(paramh, paramArrayList2, null);
      }
      paramh = paramObject4;
      if (paramh != null) {
        a(paramh, paramArrayList3, null);
      }
    }
    
    public void b(h paramh) {}
    
    public void c(h paramh) {}
    
    public void d(h paramh) {}
  }
  
  public class d
    extends h.c
  {
    public d(Rect paramRect) {}
  }
}

/* Location:
 * Qualified Name:     d.x.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */