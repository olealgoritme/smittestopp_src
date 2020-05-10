package d.x;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import d.m.a.k0;
import java.util.ArrayList;
import java.util.List;

public class d
  extends k0
{
  public static boolean a(h paramh)
  {
    boolean bool;
    if ((k0.a(B)) && (k0.a(D)) && (k0.a(E))) {
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
  
  public void a(Object paramObject, Rect paramRect)
  {
    if (paramObject != null) {
      ((h)paramObject).a(new d.d(this, paramRect));
    }
  }
  
  public void a(Object paramObject, View paramView)
  {
    if (paramObject != null) {
      ((h)paramObject).a(paramView);
    }
  }
  
  public void a(Object paramObject, View paramView, ArrayList<View> paramArrayList)
  {
    ((h)paramObject).a(new d.b(this, paramView, paramArrayList));
  }
  
  public void a(Object paramObject1, Object paramObject2, ArrayList<View> paramArrayList1, Object paramObject3, ArrayList<View> paramArrayList2, Object paramObject4, ArrayList<View> paramArrayList3)
  {
    ((h)paramObject1).a(new d.c(this, paramObject2, paramArrayList1, paramObject3, paramArrayList2, paramObject4, paramArrayList3));
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
    if ((!a((h)paramObject)) && (k0.a(C)))
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
    paramObject = (n)paramObject;
    ArrayList localArrayList = C;
    localArrayList.clear();
    int i = paramArrayList.size();
    for (int j = 0; j < i; j++) {
      k0.a(localArrayList, (View)paramArrayList.get(j));
    }
    localArrayList.add(paramView);
    paramArrayList.add(paramView);
    a(paramObject, paramArrayList);
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
  
  public void c(Object paramObject, View paramView)
  {
    if (paramView != null)
    {
      paramObject = (h)paramObject;
      Rect localRect = new Rect();
      a(paramView, localRect);
      ((h)paramObject).a(new d.a(this, localRect));
    }
  }
}

/* Location:
 * Qualified Name:     base.d.x.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */