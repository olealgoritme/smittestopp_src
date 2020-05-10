package d.b.d.i;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public class f$a
  extends BaseAdapter
{
  public int x = -1;
  
  public f$a(f paramf)
  {
    a();
  }
  
  public void a()
  {
    Object localObject = y.z;
    j localj = w;
    if (localj != null)
    {
      ((h)localObject).a();
      localObject = j;
      int i = ((ArrayList)localObject).size();
      for (int j = 0; j < i; j++) {
        if ((j)((ArrayList)localObject).get(j) == localj)
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
    h localh = y.z;
    localh.a();
    int i = j.size() - y.B;
    if (x < 0) {
      return i;
    }
    return i - 1;
  }
  
  public j getItem(int paramInt)
  {
    Object localObject = y.z;
    ((h)localObject).a();
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
    return (j)((ArrayList)localObject).get(paramInt);
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
    ((p.a)localView).a(getItem(paramInt), 0);
    return localView;
  }
  
  public void notifyDataSetChanged()
  {
    a();
    super.notifyDataSetChanged();
  }
}

/* Location:
 * Qualified Name:     d.b.d.i.f.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */