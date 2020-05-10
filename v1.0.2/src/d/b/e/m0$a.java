package d.b.e;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.appcompat.view.menu.ListMenuItemView;
import d.b.d.i.f;
import d.b.d.i.g;
import d.b.d.i.i;

public class m0$a
  extends f0
{
  public final int L;
  public final int M;
  public l0 N;
  public MenuItem O;
  
  public m0$a(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, paramBoolean);
    if (1 == paramContext.getResources().getConfiguration().getLayoutDirection())
    {
      L = 21;
      M = 22;
    }
    else
    {
      L = 22;
      M = 21;
    }
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    if (N != null)
    {
      Object localObject1 = getAdapter();
      int i;
      if ((localObject1 instanceof HeaderViewListAdapter))
      {
        localObject1 = (HeaderViewListAdapter)localObject1;
        i = ((HeaderViewListAdapter)localObject1).getHeadersCount();
        localObject1 = (f)((HeaderViewListAdapter)localObject1).getWrappedAdapter();
      }
      else
      {
        i = 0;
        localObject1 = (f)localObject1;
      }
      MenuItem localMenuItem = null;
      Object localObject2 = localMenuItem;
      if (paramMotionEvent.getAction() != 10)
      {
        int j = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
        localObject2 = localMenuItem;
        if (j != -1)
        {
          i = j - i;
          localObject2 = localMenuItem;
          if (i >= 0)
          {
            localObject2 = localMenuItem;
            if (i < ((f)localObject1).getCount()) {
              localObject2 = ((f)localObject1).getItem(i);
            }
          }
        }
      }
      localMenuItem = O;
      if (localMenuItem != localObject2)
      {
        localObject1 = x;
        if (localMenuItem != null) {
          N.b((g)localObject1, localMenuItem);
        }
        O = ((MenuItem)localObject2);
        if (localObject2 != null) {
          N.a((g)localObject1, (MenuItem)localObject2);
        }
      }
    }
    return super.onHoverEvent(paramMotionEvent);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    ListMenuItemView localListMenuItemView = (ListMenuItemView)getSelectedView();
    if ((localListMenuItemView != null) && (paramInt == L))
    {
      if ((localListMenuItemView.isEnabled()) && (localListMenuItemView.getItemData().hasSubMenu())) {
        performItemClick(localListMenuItemView, getSelectedItemPosition(), getSelectedItemId());
      }
      return true;
    }
    if ((localListMenuItemView != null) && (paramInt == M))
    {
      setSelection(-1);
      getAdapterx.a(false);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void setHoverListener(l0 paraml0)
  {
    N = paraml0;
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.m0.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */