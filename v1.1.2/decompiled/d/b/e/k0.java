package d.b.e;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import d.b.d.i.g;
import d.b.d.i.h;
import d.b.d.i.j;
import java.lang.reflect.Method;

public class k0
  extends i0
  implements j0
{
  public static Method d0;
  public j0 c0;
  
  static
  {
    try
    {
      d0 = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[] { Boolean.TYPE });
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
    }
  }
  
  public k0(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public d0 a(Context paramContext, boolean paramBoolean)
  {
    paramContext = new a(paramContext, paramBoolean);
    paramContext.setHoverListener(this);
    return paramContext;
  }
  
  public void a(h paramh, MenuItem paramMenuItem)
  {
    j0 localj0 = c0;
    if (localj0 != null) {
      localj0.a(paramh, paramMenuItem);
    }
  }
  
  public void b(h paramh, MenuItem paramMenuItem)
  {
    j0 localj0 = c0;
    if (localj0 != null) {
      localj0.b(paramh, paramMenuItem);
    }
  }
  
  public static class a
    extends d0
  {
    public final int L;
    public final int M;
    public j0 N;
    public MenuItem O;
    
    public a(Context paramContext, boolean paramBoolean)
    {
      super(paramBoolean);
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
}

/* Location:
 * Qualified Name:     d.b.e.k0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */