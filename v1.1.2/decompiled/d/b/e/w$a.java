package d.b.e;

import android.content.res.Resources.Theme;
import android.database.DataSetObserver;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

public class w$a
  implements ListAdapter, SpinnerAdapter
{
  public SpinnerAdapter x;
  public ListAdapter y;
  
  public w$a(SpinnerAdapter paramSpinnerAdapter, Resources.Theme paramTheme)
  {
    x = paramSpinnerAdapter;
    if ((paramSpinnerAdapter instanceof ListAdapter)) {
      y = ((ListAdapter)paramSpinnerAdapter);
    }
    if (paramTheme != null) {
      if ((Build.VERSION.SDK_INT >= 23) && ((paramSpinnerAdapter instanceof ThemedSpinnerAdapter)))
      {
        paramSpinnerAdapter = (ThemedSpinnerAdapter)paramSpinnerAdapter;
        if (paramSpinnerAdapter.getDropDownViewTheme() != paramTheme) {
          paramSpinnerAdapter.setDropDownViewTheme(paramTheme);
        }
      }
      else if ((paramSpinnerAdapter instanceof q0))
      {
        paramSpinnerAdapter = (q0)paramSpinnerAdapter;
        if (paramSpinnerAdapter.getDropDownViewTheme() == null) {
          paramSpinnerAdapter.setDropDownViewTheme(paramTheme);
        }
      }
    }
  }
  
  public boolean areAllItemsEnabled()
  {
    ListAdapter localListAdapter = y;
    if (localListAdapter != null) {
      return localListAdapter.areAllItemsEnabled();
    }
    return true;
  }
  
  public int getCount()
  {
    SpinnerAdapter localSpinnerAdapter = x;
    int i;
    if (localSpinnerAdapter == null) {
      i = 0;
    } else {
      i = localSpinnerAdapter.getCount();
    }
    return i;
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    SpinnerAdapter localSpinnerAdapter = x;
    if (localSpinnerAdapter == null) {
      paramView = null;
    } else {
      paramView = localSpinnerAdapter.getDropDownView(paramInt, paramView, paramViewGroup);
    }
    return paramView;
  }
  
  public Object getItem(int paramInt)
  {
    Object localObject = x;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((SpinnerAdapter)localObject).getItem(paramInt);
    }
    return localObject;
  }
  
  public long getItemId(int paramInt)
  {
    SpinnerAdapter localSpinnerAdapter = x;
    long l;
    if (localSpinnerAdapter == null) {
      l = -1L;
    } else {
      l = localSpinnerAdapter.getItemId(paramInt);
    }
    return l;
  }
  
  public int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    SpinnerAdapter localSpinnerAdapter = x;
    if (localSpinnerAdapter == null) {
      paramView = null;
    } else {
      paramView = localSpinnerAdapter.getDropDownView(paramInt, paramView, paramViewGroup);
    }
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  public boolean hasStableIds()
  {
    SpinnerAdapter localSpinnerAdapter = x;
    boolean bool;
    if ((localSpinnerAdapter != null) && (localSpinnerAdapter.hasStableIds())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isEmpty()
  {
    boolean bool;
    if (getCount() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isEnabled(int paramInt)
  {
    ListAdapter localListAdapter = y;
    if (localListAdapter != null) {
      return localListAdapter.isEnabled(paramInt);
    }
    return true;
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    SpinnerAdapter localSpinnerAdapter = x;
    if (localSpinnerAdapter != null) {
      localSpinnerAdapter.registerDataSetObserver(paramDataSetObserver);
    }
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    SpinnerAdapter localSpinnerAdapter = x;
    if (localSpinnerAdapter != null) {
      localSpinnerAdapter.unregisterDataSetObserver(paramDataSetObserver);
    }
  }
}

/* Location:
 * Qualified Name:     d.b.e.w.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */