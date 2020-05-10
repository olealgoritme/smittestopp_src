package d.b.d.i;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.util.ArrayList;

public class g
  extends BaseAdapter
{
  public final boolean A;
  public final LayoutInflater B;
  public final int C;
  public h x;
  public int y = -1;
  public boolean z;
  
  public g(h paramh, LayoutInflater paramLayoutInflater, boolean paramBoolean, int paramInt)
  {
    A = paramBoolean;
    B = paramLayoutInflater;
    x = paramh;
    C = paramInt;
    a();
  }
  
  public void a()
  {
    Object localObject = x;
    j localj = w;
    if (localj != null)
    {
      ((h)localObject).a();
      localObject = j;
      int i = ((ArrayList)localObject).size();
      for (int j = 0; j < i; j++) {
        if ((j)((ArrayList)localObject).get(j) == localj)
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
      ((h)localObject).a();
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
  
  public j getItem(int paramInt)
  {
    Object localObject;
    if (A)
    {
      localObject = x;
      ((h)localObject).a();
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
    return (j)((ArrayList)localObject).get(j);
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
    paramViewGroup = (ListMenuItemView)localView;
    boolean bool;
    if ((x.e()) && (i != j)) {
      bool = true;
    } else {
      bool = false;
    }
    paramViewGroup.setGroupDividerEnabled(bool);
    paramView = (p.a)localView;
    if (z) {
      paramViewGroup.setForceShowIcon(true);
    }
    paramView.a(getItem(paramInt), 0);
    return localView;
  }
  
  public void notifyDataSetChanged()
  {
    a();
    super.notifyDataSetChanged();
  }
}

/* Location:
 * Qualified Name:     d.b.d.i.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */