package d.b.d.i;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;

public abstract class m
  implements r, o, AdapterView.OnItemClickListener
{
  public Rect x;
  
  public static int a(ListAdapter paramListAdapter, ViewGroup paramViewGroup, Context paramContext, int paramInt)
  {
    int i = 0;
    int j = View.MeasureSpec.makeMeasureSpec(0, 0);
    int k = View.MeasureSpec.makeMeasureSpec(0, 0);
    int m = paramListAdapter.getCount();
    Object localObject1 = null;
    int n = 0;
    int i1 = 0;
    Object localObject2 = paramViewGroup;
    paramViewGroup = (ViewGroup)localObject1;
    while (i < m)
    {
      int i2 = paramListAdapter.getItemViewType(i);
      int i3 = i1;
      if (i2 != i1)
      {
        paramViewGroup = null;
        i3 = i2;
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new FrameLayout(paramContext);
      }
      paramViewGroup = paramListAdapter.getView(i, paramViewGroup, (ViewGroup)localObject1);
      paramViewGroup.measure(j, k);
      i2 = paramViewGroup.getMeasuredWidth();
      if (i2 >= paramInt) {
        return paramInt;
      }
      i1 = n;
      if (i2 > n) {
        i1 = i2;
      }
      i++;
      n = i1;
      i1 = i3;
      localObject2 = localObject1;
    }
    return n;
  }
  
  public static boolean b(h paramh)
  {
    int i = paramh.size();
    boolean bool1 = false;
    boolean bool2;
    for (int j = 0;; j++)
    {
      bool2 = bool1;
      if (j >= i) {
        break;
      }
      MenuItem localMenuItem = paramh.getItem(j);
      if ((localMenuItem.isVisible()) && (localMenuItem.getIcon() != null))
      {
        bool2 = true;
        break;
      }
    }
    return bool2;
  }
  
  public abstract void a(int paramInt);
  
  public void a(Context paramContext, h paramh) {}
  
  public abstract void a(View paramView);
  
  public abstract void a(PopupWindow.OnDismissListener paramOnDismissListener);
  
  public abstract void a(h paramh);
  
  public boolean a(h paramh, j paramj)
  {
    return false;
  }
  
  public abstract void b(int paramInt);
  
  public abstract void b(boolean paramBoolean);
  
  public boolean b(h paramh, j paramj)
  {
    return false;
  }
  
  public abstract void c(int paramInt);
  
  public abstract void c(boolean paramBoolean);
  
  public boolean f()
  {
    return true;
  }
  
  public int getId()
  {
    return 0;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = (ListAdapter)paramAdapterView.getAdapter();
    if ((paramView instanceof HeaderViewListAdapter)) {
      paramAdapterView = (g)((HeaderViewListAdapter)paramView).getWrappedAdapter();
    } else {
      paramAdapterView = (g)paramView;
    }
    paramAdapterView = x;
    paramView = (MenuItem)paramView.getItem(paramInt);
    if (f()) {
      paramInt = 0;
    } else {
      paramInt = 4;
    }
    paramAdapterView.a(paramView, this, paramInt);
  }
}

/* Location:
 * Qualified Name:     d.b.d.i.m
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */