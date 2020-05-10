package d.b.d.i;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

import java.util.Iterator;
import java.util.Map;

import d.i.d.a.a;

public class o
  extends c
  implements Menu
{
  public final a d;
  
  public o(Context paramContext, a parama)
  {
    super(paramContext);
    if (parama != null)
    {
      d = parama;
      return;
    }
    throw new IllegalArgumentException("Wrapped Object can not be null.");
  }
  
  public MenuItem add(int paramInt)
  {
    return a(d.add(paramInt));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(d.add(paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    return a(d.add(paramInt1, paramInt2, paramInt3, paramCharSequence));
  }
  
  public MenuItem add(CharSequence paramCharSequence)
  {
    return a(d.add(paramCharSequence));
  }
  
  public int addIntentOptions(int paramInt1, int paramInt2, int paramInt3, ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt4, MenuItem[] paramArrayOfMenuItem)
  {
    MenuItem[] arrayOfMenuItem;
    if (paramArrayOfMenuItem != null) {
      arrayOfMenuItem = new MenuItem[paramArrayOfMenuItem.length];
    } else {
      arrayOfMenuItem = null;
    }
    paramInt3 = d.addIntentOptions(paramInt1, paramInt2, paramInt3, paramComponentName, paramArrayOfIntent, paramIntent, paramInt4, arrayOfMenuItem);
    if (arrayOfMenuItem != null)
    {
      paramInt1 = 0;
      paramInt2 = arrayOfMenuItem.length;
      while (paramInt1 < paramInt2)
      {
        paramArrayOfMenuItem[paramInt1] = a(arrayOfMenuItem[paramInt1]);
        paramInt1++;
      }
    }
    return paramInt3;
  }
  
  public SubMenu addSubMenu(int paramInt)
  {
    return a(d.addSubMenu(paramInt));
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(d.addSubMenu(paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    return a(d.addSubMenu(paramInt1, paramInt2, paramInt3, paramCharSequence));
  }
  
  public SubMenu addSubMenu(CharSequence paramCharSequence)
  {
    return a(d.addSubMenu(paramCharSequence));
  }
  
  public void clear()
  {
    Map localMap = b;
    if (localMap != null) {
      localMap.clear();
    }
    localMap = c;
    if (localMap != null) {
      localMap.clear();
    }
    d.clear();
  }
  
  public void close()
  {
    d.close();
  }
  
  public MenuItem findItem(int paramInt)
  {
    return a(d.findItem(paramInt));
  }
  
  public MenuItem getItem(int paramInt)
  {
    return a(d.getItem(paramInt));
  }
  
  public boolean hasVisibleItems()
  {
    return d.hasVisibleItems();
  }
  
  public boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent)
  {
    return d.isShortcutKey(paramInt, paramKeyEvent);
  }
  
  public boolean performIdentifierAction(int paramInt1, int paramInt2)
  {
    return d.performIdentifierAction(paramInt1, paramInt2);
  }
  
  public boolean performShortcut(int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    return d.performShortcut(paramInt1, paramKeyEvent, paramInt2);
  }
  
  public void removeGroup(int paramInt)
  {
    Object localObject = b;
    if (localObject != null)
    {
      localObject = ((Map)localObject).keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        if (paramInt == ((MenuItem)((Iterator)localObject).next()).getGroupId()) {
          ((Iterator)localObject).remove();
        }
      }
    }
    d.removeGroup(paramInt);
  }
  
  public void removeItem(int paramInt)
  {
    Object localObject = b;
    if (localObject != null)
    {
      localObject = ((Map)localObject).keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        if (paramInt == ((MenuItem)((Iterator)localObject).next()).getItemId()) {
          ((Iterator)localObject).remove();
        }
      }
    }
    d.removeItem(paramInt);
  }
  
  public void setGroupCheckable(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    d.setGroupCheckable(paramInt, paramBoolean1, paramBoolean2);
  }
  
  public void setGroupEnabled(int paramInt, boolean paramBoolean)
  {
    d.setGroupEnabled(paramInt, paramBoolean);
  }
  
  public void setGroupVisible(int paramInt, boolean paramBoolean)
  {
    d.setGroupVisible(paramInt, paramBoolean);
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    d.setQwertyMode(paramBoolean);
  }
  
  public int size()
  {
    return d.size();
  }
}

/* Location:
 * Qualified Name:     base.d.b.d.i.o
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */