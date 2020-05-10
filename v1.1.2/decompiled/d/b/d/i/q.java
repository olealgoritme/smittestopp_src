package d.b.d.i;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import d.i.d.a.a;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class q
  extends c<a>
  implements Menu
{
  public q(Context paramContext, a parama)
  {
    super(paramContext, parama);
  }
  
  public MenuItem add(int paramInt)
  {
    return a(((a)a).add(paramInt));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(((a)a).add(paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    return a(((a)a).add(paramInt1, paramInt2, paramInt3, paramCharSequence));
  }
  
  public MenuItem add(CharSequence paramCharSequence)
  {
    return a(((a)a).add(paramCharSequence));
  }
  
  public int addIntentOptions(int paramInt1, int paramInt2, int paramInt3, ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt4, MenuItem[] paramArrayOfMenuItem)
  {
    MenuItem[] arrayOfMenuItem;
    if (paramArrayOfMenuItem != null) {
      arrayOfMenuItem = new MenuItem[paramArrayOfMenuItem.length];
    } else {
      arrayOfMenuItem = null;
    }
    paramInt3 = ((a)a).addIntentOptions(paramInt1, paramInt2, paramInt3, paramComponentName, paramArrayOfIntent, paramIntent, paramInt4, arrayOfMenuItem);
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
    return a(((a)a).addSubMenu(paramInt));
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(((a)a).addSubMenu(paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    return a(((a)a).addSubMenu(paramInt1, paramInt2, paramInt3, paramCharSequence));
  }
  
  public SubMenu addSubMenu(CharSequence paramCharSequence)
  {
    return a(((a)a).addSubMenu(paramCharSequence));
  }
  
  public void clear()
  {
    Map localMap = c;
    if (localMap != null) {
      localMap.clear();
    }
    localMap = d;
    if (localMap != null) {
      localMap.clear();
    }
    ((a)a).clear();
  }
  
  public void close()
  {
    ((a)a).close();
  }
  
  public MenuItem findItem(int paramInt)
  {
    return a(((a)a).findItem(paramInt));
  }
  
  public MenuItem getItem(int paramInt)
  {
    return a(((a)a).getItem(paramInt));
  }
  
  public boolean hasVisibleItems()
  {
    return ((a)a).hasVisibleItems();
  }
  
  public boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent)
  {
    return ((a)a).isShortcutKey(paramInt, paramKeyEvent);
  }
  
  public boolean performIdentifierAction(int paramInt1, int paramInt2)
  {
    return ((a)a).performIdentifierAction(paramInt1, paramInt2);
  }
  
  public boolean performShortcut(int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    return ((a)a).performShortcut(paramInt1, paramKeyEvent, paramInt2);
  }
  
  public void removeGroup(int paramInt)
  {
    Object localObject = c;
    if (localObject != null)
    {
      localObject = ((Map)localObject).keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        if (paramInt == ((MenuItem)((Iterator)localObject).next()).getGroupId()) {
          ((Iterator)localObject).remove();
        }
      }
    }
    ((a)a).removeGroup(paramInt);
  }
  
  public void removeItem(int paramInt)
  {
    Object localObject = c;
    if (localObject != null)
    {
      localObject = ((Map)localObject).keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        if (paramInt == ((MenuItem)((Iterator)localObject).next()).getItemId()) {
          ((Iterator)localObject).remove();
        }
      }
    }
    ((a)a).removeItem(paramInt);
  }
  
  public void setGroupCheckable(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    ((a)a).setGroupCheckable(paramInt, paramBoolean1, paramBoolean2);
  }
  
  public void setGroupEnabled(int paramInt, boolean paramBoolean)
  {
    ((a)a).setGroupEnabled(paramInt, paramBoolean);
  }
  
  public void setGroupVisible(int paramInt, boolean paramBoolean)
  {
    ((a)a).setGroupVisible(paramInt, paramBoolean);
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    ((a)a).setQwertyMode(paramBoolean);
  }
  
  public int size()
  {
    return ((a)a).size();
  }
}

/* Location:
 * Qualified Name:     d.b.d.i.q
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */