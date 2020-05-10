package d.b.d.i;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.appcompat.view.menu.ListMenuItemView;

import java.util.ArrayList;

public class f
  extends BaseAdapter
{
  public final boolean A;
  public final LayoutInflater B;
  public final int C;
  public g x;
  public int y = -1;
  public boolean z;
  
  public f(g paramg, LayoutInflater paramLayoutInflater, boolean paramBoolean, int paramInt)
  {
    A = paramBoolean;
    B = paramLayoutInflater;
    x = paramg;
    C = paramInt;
    a();
  }
  
  public void a()
  {
    Object localObject = x;
    i locali = w;
    if (locali != null)
    {
      ((g)localObject).a();
      localObject = j;
      int i = ((ArrayList)localObject).size();
      for (int j = 0; j < i; j++) {
        if ((i)((ArrayList)localObject).get(j) == locali)
        {
          y = j;
          return;
        }
      }
    }
    y = -1;
  }
  
  public int getCount()
  {
    Object localObject;
    if (A)
    {
      localObject = x;
      ((g)localObject).a();
      localObject = j;
    }
    else
    {
      localObject = x.d();
    }
    if (y < 0) {
      return ((ArrayList)localObject).size();
    }
    return ((ArrayList)localObject).size() - 1;
  }
  
  public i getItem(int paramInt)
  {
    Object localObject;
    if (A)
    {
      localObject = x;
      ((g)localObject).a();
      localObject = j;
    }
    else
    {
      localObject = x.d();
    }
    int i = y;
    int j = paramInt;
    if (i >= 0)
    {
      j = paramInt;
      if (paramInt >= i) {
        j = paramInt + 1;
      }
    }
    return (i)((ArrayList)localObject).get(j);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = B.inflate(C, paramViewGroup, false);
    }
    int i = getItemb;
    int j = paramInt - 1;
    if (j >= 0) {
      j = getItemb;
    } else {
      j = i;
    }
    paramView = (ListMenuItemView)localView;
    boolean bool;
    if ((x.e()) && (i != j)) {
      bool = true;
    } else {
      bool = false;
    }
    paramView.setGroupDividerEnabled(bool);
    paramViewGroup = (n.a)localView;
    if (z) {
      paramView.setForceShowIcon(true);
    }
    paramViewGroup.a(getItem(paramInt), 0);
    return localView;
  }
  
  public void notifyDataSetChanged()
  {
    a();
    super.notifyDataSetChanged();
  }
}

/* Location:
 * Qualified Name:     base.d.b.d.i.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */