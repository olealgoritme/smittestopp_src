package d.m.a;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import d.i.e.a;
import d.i.i.n;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressLint({"UnknownNullness"})
public abstract class k0
{
  public static void a(List<View> paramList, View paramView)
  {
    int i = paramList.size();
    if (a(paramList, paramView, i)) {
      return;
    }
    paramList.add(paramView);
    for (int j = i; j < paramList.size(); j++)
    {
      paramView = (View)paramList.get(j);
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int k = paramView.getChildCount();
        for (int m = 0; m < k; m++)
        {
          View localView = paramView.getChildAt(m);
          if (!a(paramList, localView, i)) {
            paramList.add(localView);
          }
        }
      }
    }
  }
  
  public static boolean a(List paramList)
  {
    boolean bool;
    if ((paramList != null) && (!paramList.isEmpty())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(List<View> paramList, View paramView, int paramInt)
  {
    for (int i = 0; i < paramInt; i++) {
      if (paramList.get(i) == paramView) {
        return true;
      }
    }
    return false;
  }
  
  public abstract Object a(Object paramObject1, Object paramObject2, Object paramObject3);
  
  public void a(View paramView, Rect paramRect)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    int k = arrayOfInt[0];
    int m = paramView.getWidth();
    int n = arrayOfInt[1];
    paramRect.set(i, j, m + k, paramView.getHeight() + n);
  }
  
  public abstract void a(ViewGroup paramViewGroup, Object paramObject);
  
  public void a(Fragment paramFragment, Object paramObject, a parama, Runnable paramRunnable)
  {
    paramRunnable.run();
  }
  
  public abstract void a(Object paramObject, Rect paramRect);
  
  public abstract void a(Object paramObject, View paramView);
  
  public abstract void a(Object paramObject, View paramView, ArrayList<View> paramArrayList);
  
  public abstract void a(Object paramObject1, Object paramObject2, ArrayList<View> paramArrayList1, Object paramObject3, ArrayList<View> paramArrayList2, Object paramObject4, ArrayList<View> paramArrayList3);
  
  public abstract void a(Object paramObject, ArrayList<View> paramArrayList);
  
  public abstract void a(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2);
  
  public void a(ArrayList<View> paramArrayList, View paramView)
  {
    if (paramView.getVisibility() == 0) {
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        if (paramView.isTransitionGroup())
        {
          paramArrayList.add(paramView);
        }
        else
        {
          int i = paramView.getChildCount();
          for (int j = 0; j < i; j++) {
            a(paramArrayList, paramView.getChildAt(j));
          }
        }
      }
      else
      {
        paramArrayList.add(paramView);
      }
    }
  }
  
  public void a(Map<String, View> paramMap, View paramView)
  {
    if (paramView.getVisibility() == 0)
    {
      String str = n.n(paramView);
      if (str != null) {
        paramMap.put(str, paramView);
      }
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int i = paramView.getChildCount();
        for (int j = 0; j < i; j++) {
          a(paramMap, paramView.getChildAt(j));
        }
      }
    }
  }
  
  public abstract boolean a(Object paramObject);
  
  public abstract Object b(Object paramObject);
  
  public abstract Object b(Object paramObject1, Object paramObject2, Object paramObject3);
  
  public abstract void b(Object paramObject, View paramView);
  
  public abstract void b(Object paramObject, View paramView, ArrayList<View> paramArrayList);
  
  public abstract void b(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2);
  
  public abstract Object c(Object paramObject);
  
  public abstract void c(Object paramObject, View paramView);
}

/* Location:
 * Qualified Name:     base.d.m.a.k0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */