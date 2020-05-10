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
import d.b.d.i.g;
import d.b.d.i.h;
import d.b.d.i.j;

public class k0$a
  extends d0
{
  public final int L;
  public final int M;
  public j0 N;
  public MenuItem O;
  
  public k0$a(Context paramContext, boolean paramBoolean)
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
      Object localObject2;
      if ((localObject1 instanceof HeaderViewListAdapter))
      {
        localObject1 = (HeaderViewListAdapter)localObject1;
        i = ((HeaderViewListAdapter)localObject1).getHeadersCount();
        localObject2 = (g)((HeaderViewListAdapter)localObject1).getWrappedAdapter();
      }
      else
      {
        i = 0;
        localObject2 = (g)localObject1;
      }
      MenuItem localMenuItem = null;
      localObject1 = localMenuItem;
      if (paramMotionEvent.getAction() != 10)
      {
        int j = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
        localObject1 = localMenuItem;
        if (j != -1)
        {
          i = j - i;
          localObject1 = localMenuItem;
          if (i >= 0)
          {
            localObject1 = localMenuItem;
            if (i < ((g)localObject2).getCount()) {
              localObject1 = ((g)localObject2).getItem(i);
            }
          }
        }
      }
      localMenuItem = O;
      if (localMenuItem != localObject1)
      {
        localObject2 = x;
        if (localMenuItem != null) {
          N.b((h)localObject2, localMenuItem);
        }
        O = ((MenuItem)localObject1);
        if (localObject1 != null) {
          N.a((h)localObject2, (MenuItem)localObject1);
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
  
  public void setHoverListener(j0 paramj0)
  {
    N = paramj0;
  }
}

/* Location:
 * Qualified Name:     d.b.e.k0.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */