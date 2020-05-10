package d.b.d.i;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class e$a
  extends BaseAdapter
{
  public int x = -1;
  
  public e$a(e parame)
  {
    a();
  }
  
  public void a()
  {
    Object localObject = y.z;
    i locali = w;
    if (locali != null)
    {
      ((g)localObject).a();
      localObject = j;
      int i = ((ArrayList)localObject).size();
      for (int j = 0; j < i; j++) {
        if ((i)((ArrayList)localObject).get(j) == locali)
        {
          x = j;
          return;
        }
      }
    }
    x = -1;
  }
  
  public int getCount()
  {
    g localg = y.z;
    localg.a();
    int i = j.size() - y.B;
    if (x < 0) {
      return i;
    }
    return i - 1;
  }
  
  public i getItem(int paramInt)
  {
    Object localObject = y.z;
    ((g)localObject).a();
    localObject = j;
    int i = paramInt + y.B;
    int j = x;
    paramInt = i;
    if (j >= 0)
    {
      paramInt = i;
      if (i >= j) {
        paramInt = i + 1;
      }
    }
    return (i)((ArrayList)localObject).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = y;
      localView = y.inflate(D, paramViewGroup, false);
    }
    ((n.a)localView).a(getItem(paramInt), 0);
    return localView;
  }
  
  public void notifyDataSetChanged()
  {
    a();
    super.notifyDataSetChanged();
  }
}

/* Location:
 * Qualified Name:     base.d.b.d.i.e.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */