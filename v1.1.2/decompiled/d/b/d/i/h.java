package d.b.d.i;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.ActionProvider;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import d.i.i.r;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class h
  implements d.i.d.a.a
{
  public static final int[] z = { 1, 4, 5, 3, 2, 0 };
  public final Context a;
  public final Resources b;
  public boolean c;
  public boolean d;
  public a e;
  public ArrayList<j> f;
  public ArrayList<j> g;
  public boolean h;
  public ArrayList<j> i;
  public ArrayList<j> j;
  public boolean k;
  public int l;
  public CharSequence m;
  public Drawable n;
  public View o;
  public boolean p;
  public boolean q;
  public boolean r;
  public boolean s;
  public boolean t;
  public ArrayList<j> u;
  public CopyOnWriteArrayList<WeakReference<o>> v;
  public j w;
  public boolean x;
  public boolean y;
  
  public h(Context paramContext)
  {
    boolean bool1 = false;
    l = 0;
    p = false;
    q = false;
    r = false;
    s = false;
    t = false;
    u = new ArrayList();
    v = new CopyOnWriteArrayList();
    x = false;
    a = paramContext;
    b = paramContext.getResources();
    f = new ArrayList();
    g = new ArrayList();
    h = true;
    i = new ArrayList();
    j = new ArrayList();
    k = true;
    boolean bool2 = bool1;
    if (b.getConfiguration().keyboard != 1)
    {
      bool2 = bool1;
      if (r.c(ViewConfiguration.get(a), a)) {
        bool2 = true;
      }
    }
    d = bool2;
  }
  
  public MenuItem a(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    int i1 = (0xFFFF0000 & paramInt3) >> 16;
    if (i1 >= 0)
    {
      Object localObject = z;
      if (i1 < localObject.length)
      {
        i1 = localObject[i1] << 16 | 0xFFFF & paramInt3;
        paramCharSequence = new j(this, paramInt1, paramInt2, paramInt3, i1, paramCharSequence, l);
        localObject = f;
        paramInt1 = ((ArrayList)localObject).size();
        do
        {
          paramInt2 = paramInt1 - 1;
          if (paramInt2 < 0) {
            break;
          }
          paramInt1 = paramInt2;
        } while (getd > i1);
        paramInt1 = paramInt2 + 1;
        break label111;
        paramInt1 = 0;
        label111:
        ((ArrayList)localObject).add(paramInt1, paramCharSequence);
        b(true);
        return paramCharSequence;
      }
    }
    throw new IllegalArgumentException("order does not contain a valid category.");
  }
  
  public j a(int paramInt, KeyEvent paramKeyEvent)
  {
    ArrayList localArrayList = u;
    localArrayList.clear();
    a(localArrayList, paramInt, paramKeyEvent);
    if (localArrayList.isEmpty()) {
      return null;
    }
    int i1 = paramKeyEvent.getMetaState();
    KeyCharacterMap.KeyData localKeyData = new KeyCharacterMap.KeyData();
    paramKeyEvent.getKeyData(localKeyData);
    int i2 = localArrayList.size();
    if (i2 == 1) {
      return (j)localArrayList.get(0);
    }
    boolean bool = f();
    for (int i3 = 0; i3 < i2; i3++)
    {
      paramKeyEvent = (j)localArrayList.get(i3);
      int i4;
      if (bool) {
        i4 = j;
      } else {
        i4 = h;
      }
      if (((i4 == meta[0]) && ((i1 & 0x2) == 0)) || ((i4 == meta[2]) && ((i1 & 0x2) != 0)) || ((bool) && (i4 == 8) && (paramInt == 67))) {
        return paramKeyEvent;
      }
    }
    return null;
  }
  
  public void a()
  {
    ArrayList localArrayList = d();
    if (!k) {
      return;
    }
    Object localObject = v.iterator();
    int i1 = 0;
    while (((Iterator)localObject).hasNext())
    {
      WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
      o localo = (o)localWeakReference.get();
      if (localo == null) {
        v.remove(localWeakReference);
      } else {
        i1 |= localo.c();
      }
    }
    if (i1 != 0)
    {
      i.clear();
      j.clear();
      int i2 = localArrayList.size();
      for (i1 = 0; i1 < i2; i1++)
      {
        localObject = (j)localArrayList.get(i1);
        if (((j)localObject).d()) {
          i.add(localObject);
        } else {
          j.add(localObject);
        }
      }
    }
    i.clear();
    j.clear();
    j.addAll(d());
    k = false;
  }
  
  public final void a(int paramInt1, CharSequence paramCharSequence, int paramInt2, Drawable paramDrawable, View paramView)
  {
    Resources localResources = b;
    if (paramView != null)
    {
      o = paramView;
      m = null;
      n = null;
    }
    else
    {
      if (paramInt1 > 0) {
        m = localResources.getText(paramInt1);
      } else if (paramCharSequence != null) {
        m = paramCharSequence;
      }
      if (paramInt2 > 0) {
        n = d.i.b.a.c(a, paramInt2);
      } else if (paramDrawable != null) {
        n = paramDrawable;
      }
      o = null;
    }
    b(false);
  }
  
  public final void a(int paramInt, boolean paramBoolean)
  {
    if ((paramInt >= 0) && (paramInt < f.size()))
    {
      f.remove(paramInt);
      if (paramBoolean) {
        b(true);
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    SparseArray localSparseArray = paramBundle.getSparseParcelableArray(b());
    int i1 = size();
    for (int i2 = 0; i2 < i1; i2++)
    {
      MenuItem localMenuItem = getItem(i2);
      View localView = localMenuItem.getActionView();
      if ((localView != null) && (localView.getId() != -1)) {
        localView.restoreHierarchyState(localSparseArray);
      }
      if (localMenuItem.hasSubMenu()) {
        ((t)localMenuItem.getSubMenu()).a(paramBundle);
      }
    }
    i2 = paramBundle.getInt("android:menu:expandedactionview");
    if (i2 > 0)
    {
      paramBundle = findItem(i2);
      if (paramBundle != null) {
        paramBundle.expandActionView();
      }
    }
  }
  
  public void a(a parama)
  {
    e = parama;
  }
  
  public void a(o paramo)
  {
    Iterator localIterator = v.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      o localo = (o)localWeakReference.get();
      if ((localo == null) || (localo == paramo)) {
        v.remove(localWeakReference);
      }
    }
  }
  
  public void a(o paramo, Context paramContext)
  {
    v.add(new WeakReference(paramo));
    paramo.a(paramContext, this);
    k = true;
  }
  
  public void a(List<j> paramList, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = f();
    int i1 = paramKeyEvent.getModifiers();
    KeyCharacterMap.KeyData localKeyData = new KeyCharacterMap.KeyData();
    if ((!paramKeyEvent.getKeyData(localKeyData)) && (paramInt != 67)) {
      return;
    }
    int i2 = f.size();
    for (int i3 = 0; i3 < i2; i3++)
    {
      j localj = (j)f.get(i3);
      if (localj.hasSubMenu()) {
        o.a(paramList, paramInt, paramKeyEvent);
      }
      int i4;
      if (bool) {
        i4 = j;
      } else {
        i4 = h;
      }
      int i5;
      if (bool) {
        i5 = k;
      } else {
        i5 = i;
      }
      if ((i1 & 0x1100F) == (i5 & 0x1100F)) {
        i5 = 1;
      } else {
        i5 = 0;
      }
      if ((i5 != 0) && (i4 != 0))
      {
        char[] arrayOfChar = meta;
        if (((i4 == arrayOfChar[0]) || (i4 == arrayOfChar[2]) || ((bool) && (i4 == 8) && (paramInt == 67))) && (localj.isEnabled())) {
          paramList.add(localj);
        }
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    if (t) {
      return;
    }
    t = true;
    Iterator localIterator = v.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      o localo = (o)localWeakReference.get();
      if (localo == null) {
        v.remove(localWeakReference);
      } else {
        localo.a(this, paramBoolean);
      }
    }
    t = false;
  }
  
  public boolean a(MenuItem paramMenuItem, int paramInt)
  {
    return a(paramMenuItem, null, paramInt);
  }
  
  public boolean a(MenuItem paramMenuItem, o paramo, int paramInt)
  {
    paramMenuItem = (j)paramMenuItem;
    boolean bool1 = false;
    boolean bool2 = false;
    if ((paramMenuItem != null) && (paramMenuItem.isEnabled()))
    {
      Object localObject1 = p;
      if ((localObject1 == null) || (!((MenuItem.OnMenuItemClickListener)localObject1).onMenuItemClick(paramMenuItem)))
      {
        localObject1 = n;
        if (!((h)localObject1).a((h)localObject1, paramMenuItem))
        {
          localObject1 = g;
          if (localObject1 != null)
          {
            try
            {
              n.a.startActivity((Intent)localObject1);
            }
            catch (ActivityNotFoundException localActivityNotFoundException)
            {
              Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", localActivityNotFoundException);
            }
          }
          else
          {
            localObject2 = A;
            if ((localObject2 == null) || (!b.onPerformDefaultAction())) {
              break label141;
            }
          }
        }
      }
      boolean bool3 = true;
      break label144;
      label141:
      bool3 = false;
      label144:
      Object localObject2 = A;
      int i1;
      if ((localObject2 != null) && (b.hasSubMenu())) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (paramMenuItem.c())
      {
        bool3 |= paramMenuItem.expandActionView();
        bool2 = bool3;
        if (bool3)
        {
          a(true);
          bool2 = bool3;
        }
      }
      else if ((!paramMenuItem.hasSubMenu()) && (i1 == 0))
      {
        bool2 = bool3;
        if ((paramInt & 0x1) == 0)
        {
          a(true);
          bool2 = bool3;
        }
      }
      else
      {
        if ((paramInt & 0x4) == 0) {
          a(false);
        }
        Object localObject3;
        if (!paramMenuItem.hasSubMenu())
        {
          localObject3 = new t(a, this, paramMenuItem);
          o = ((t)localObject3);
          ((t)localObject3).setHeaderTitle(e);
        }
        paramMenuItem = o;
        if (i1 != 0)
        {
          localObject2 = (k.a)localObject2;
          b.onPrepareSubMenu(c.a(paramMenuItem));
        }
        if (!v.isEmpty())
        {
          if (paramo != null) {
            bool2 = paramo.a(paramMenuItem);
          }
          paramo = v.iterator();
          for (;;)
          {
            bool1 = bool2;
            if (!paramo.hasNext()) {
              break;
            }
            localObject2 = (WeakReference)paramo.next();
            localObject3 = (o)((WeakReference)localObject2).get();
            if (localObject3 == null) {
              v.remove(localObject2);
            } else if (!bool2) {
              bool2 = ((o)localObject3).a(paramMenuItem);
            }
          }
        }
        bool3 |= bool1;
        bool2 = bool3;
        if (!bool3)
        {
          a(true);
          bool2 = bool3;
        }
      }
      return bool2;
    }
    return false;
  }
  
  public boolean a(h paramh, MenuItem paramMenuItem)
  {
    a locala = e;
    boolean bool;
    if ((locala != null) && (locala.a(paramh, paramMenuItem))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean a(j paramj)
  {
    boolean bool1 = v.isEmpty();
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = bool2;
    if (!bool1) {
      if (w != paramj)
      {
        bool4 = bool2;
      }
      else
      {
        j();
        Iterator localIterator = v.iterator();
        bool4 = bool3;
        do
        {
          o localo;
          for (;;)
          {
            bool3 = bool4;
            if (!localIterator.hasNext()) {
              break label125;
            }
            WeakReference localWeakReference = (WeakReference)localIterator.next();
            localo = (o)localWeakReference.get();
            if (localo != null) {
              break;
            }
            v.remove(localWeakReference);
          }
          bool3 = localo.a(this, paramj);
          bool4 = bool3;
        } while (!bool3);
        label125:
        i();
        bool4 = bool3;
        if (bool3)
        {
          w = null;
          bool4 = bool3;
        }
      }
    }
    return bool4;
  }
  
  public MenuItem add(int paramInt)
  {
    return a(0, 0, 0, b.getString(paramInt));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(paramInt1, paramInt2, paramInt3, b.getString(paramInt4));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    return a(paramInt1, paramInt2, paramInt3, paramCharSequence);
  }
  
  public MenuItem add(CharSequence paramCharSequence)
  {
    return a(0, 0, 0, paramCharSequence);
  }
  
  public int addIntentOptions(int paramInt1, int paramInt2, int paramInt3, ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt4, MenuItem[] paramArrayOfMenuItem)
  {
    PackageManager localPackageManager = a.getPackageManager();
    int i1 = 0;
    List localList = localPackageManager.queryIntentActivityOptions(paramComponentName, paramArrayOfIntent, paramIntent, 0);
    int i2;
    if (localList != null) {
      i2 = localList.size();
    } else {
      i2 = 0;
    }
    int i3 = i1;
    if ((paramInt4 & 0x1) == 0) {
      removeGroup(paramInt1);
    }
    for (i3 = i1; i3 < i2; i3++)
    {
      ResolveInfo localResolveInfo = (ResolveInfo)localList.get(i3);
      paramInt4 = specificIndex;
      if (paramInt4 < 0) {
        paramComponentName = paramIntent;
      } else {
        paramComponentName = paramArrayOfIntent[paramInt4];
      }
      paramComponentName = new Intent(paramComponentName);
      ActivityInfo localActivityInfo = activityInfo;
      paramComponentName.setComponent(new ComponentName(applicationInfo.packageName, name));
      paramComponentName = a(paramInt1, paramInt2, paramInt3, localResolveInfo.loadLabel(localPackageManager)).setIcon(localResolveInfo.loadIcon(localPackageManager)).setIntent(paramComponentName);
      if (paramArrayOfMenuItem != null)
      {
        paramInt4 = specificIndex;
        if (paramInt4 >= 0) {
          paramArrayOfMenuItem[paramInt4] = paramComponentName;
        }
      }
    }
    return i2;
  }
  
  public SubMenu addSubMenu(int paramInt)
  {
    return addSubMenu(0, 0, 0, b.getString(paramInt));
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return addSubMenu(paramInt1, paramInt2, paramInt3, b.getString(paramInt4));
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    j localj = (j)a(paramInt1, paramInt2, paramInt3, paramCharSequence);
    paramCharSequence = new t(a, this, localj);
    o = paramCharSequence;
    paramCharSequence.setHeaderTitle(e);
    return paramCharSequence;
  }
  
  public SubMenu addSubMenu(CharSequence paramCharSequence)
  {
    return addSubMenu(0, 0, 0, paramCharSequence);
  }
  
  public String b()
  {
    return "android:menu:actionviewstates";
  }
  
  public void b(Bundle paramBundle)
  {
    int i1 = size();
    Object localObject1 = null;
    int i2 = 0;
    while (i2 < i1)
    {
      MenuItem localMenuItem = getItem(i2);
      View localView = localMenuItem.getActionView();
      Object localObject2 = localObject1;
      if (localView != null)
      {
        localObject2 = localObject1;
        if (localView.getId() != -1)
        {
          Object localObject3 = localObject1;
          if (localObject1 == null) {
            localObject3 = new SparseArray();
          }
          localView.saveHierarchyState((SparseArray)localObject3);
          localObject2 = localObject3;
          if (localMenuItem.isActionViewExpanded())
          {
            paramBundle.putInt("android:menu:expandedactionview", localMenuItem.getItemId());
            localObject2 = localObject3;
          }
        }
      }
      if (localMenuItem.hasSubMenu()) {
        ((t)localMenuItem.getSubMenu()).b(paramBundle);
      }
      i2++;
      localObject1 = localObject2;
    }
    if (localObject1 != null) {
      paramBundle.putSparseParcelableArray(b(), (SparseArray)localObject1);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (!p)
    {
      if (paramBoolean)
      {
        h = true;
        k = true;
      }
      if (!v.isEmpty())
      {
        j();
        Iterator localIterator = v.iterator();
        while (localIterator.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          o localo = (o)localWeakReference.get();
          if (localo == null) {
            v.remove(localWeakReference);
          } else {
            localo.a(paramBoolean);
          }
        }
        i();
      }
    }
    else
    {
      q = true;
      if (paramBoolean) {
        r = true;
      }
    }
  }
  
  public boolean b(j paramj)
  {
    boolean bool1 = v.isEmpty();
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    j();
    Iterator localIterator = v.iterator();
    do
    {
      o localo;
      for (;;)
      {
        bool1 = bool2;
        if (!localIterator.hasNext()) {
          break label97;
        }
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        localo = (o)localWeakReference.get();
        if (localo != null) {
          break;
        }
        v.remove(localWeakReference);
      }
      bool1 = localo.b(this, paramj);
      bool2 = bool1;
    } while (!bool1);
    label97:
    i();
    if (bool1) {
      w = paramj;
    }
    return bool1;
  }
  
  public h c()
  {
    return this;
  }
  
  public void clear()
  {
    j localj = w;
    if (localj != null) {
      a(localj);
    }
    f.clear();
    b(true);
  }
  
  public void clearHeader()
  {
    n = null;
    m = null;
    o = null;
    b(false);
  }
  
  public void close()
  {
    a(true);
  }
  
  public ArrayList<j> d()
  {
    if (!h) {
      return g;
    }
    g.clear();
    int i1 = f.size();
    for (int i2 = 0; i2 < i1; i2++)
    {
      j localj = (j)f.get(i2);
      if (localj.isVisible()) {
        g.add(localj);
      }
    }
    h = false;
    k = true;
    return g;
  }
  
  public boolean e()
  {
    return x;
  }
  
  public boolean f()
  {
    return c;
  }
  
  public MenuItem findItem(int paramInt)
  {
    int i1 = size();
    for (int i2 = 0; i2 < i1; i2++)
    {
      Object localObject = (j)f.get(i2);
      if (a == paramInt) {
        return (MenuItem)localObject;
      }
      if (((j)localObject).hasSubMenu())
      {
        localObject = o.findItem(paramInt);
        if (localObject != null) {
          return (MenuItem)localObject;
        }
      }
    }
    return null;
  }
  
  public boolean g()
  {
    return d;
  }
  
  public MenuItem getItem(int paramInt)
  {
    return (MenuItem)f.get(paramInt);
  }
  
  public void h()
  {
    k = true;
    b(true);
  }
  
  public boolean hasVisibleItems()
  {
    if (y) {
      return true;
    }
    int i1 = size();
    for (int i2 = 0; i2 < i1; i2++) {
      if (((j)f.get(i2)).isVisible()) {
        return true;
      }
    }
    return false;
  }
  
  public void i()
  {
    p = false;
    if (q)
    {
      q = false;
      b(r);
    }
  }
  
  public boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool;
    if (a(paramInt, paramKeyEvent) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void j()
  {
    if (!p)
    {
      p = true;
      q = false;
      r = false;
    }
  }
  
  public boolean performIdentifierAction(int paramInt1, int paramInt2)
  {
    return a(findItem(paramInt1), paramInt2);
  }
  
  public boolean performShortcut(int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    paramKeyEvent = a(paramInt1, paramKeyEvent);
    boolean bool;
    if (paramKeyEvent != null) {
      bool = a(paramKeyEvent, null, paramInt2);
    } else {
      bool = false;
    }
    if ((paramInt2 & 0x2) != 0) {
      a(true);
    }
    return bool;
  }
  
  public void removeGroup(int paramInt)
  {
    int i1 = size();
    for (int i2 = 0; i2 < i1; i2++) {
      if (f.get(i2)).b == paramInt) {
        break label41;
      }
    }
    i2 = -1;
    label41:
    if (i2 >= 0)
    {
      int i3 = f.size();
      for (i1 = 0; (i1 < i3 - i2) && (f.get(i2)).b == paramInt); i1++) {
        a(i2, false);
      }
      b(true);
    }
  }
  
  public void removeItem(int paramInt)
  {
    int i1 = size();
    for (int i2 = 0; i2 < i1; i2++) {
      if (f.get(i2)).a == paramInt) {
        break label41;
      }
    }
    i2 = -1;
    label41:
    a(i2, true);
  }
  
  public void setGroupCheckable(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = f.size();
    for (int i2 = 0; i2 < i1; i2++)
    {
      j localj = (j)f.get(i2);
      if (b == paramInt)
      {
        localj.b(paramBoolean2);
        localj.setCheckable(paramBoolean1);
      }
    }
  }
  
  public void setGroupDividerEnabled(boolean paramBoolean)
  {
    x = paramBoolean;
  }
  
  public void setGroupEnabled(int paramInt, boolean paramBoolean)
  {
    int i1 = f.size();
    for (int i2 = 0; i2 < i1; i2++)
    {
      j localj = (j)f.get(i2);
      if (b == paramInt) {
        localj.setEnabled(paramBoolean);
      }
    }
  }
  
  public void setGroupVisible(int paramInt, boolean paramBoolean)
  {
    int i1 = f.size();
    int i2 = 0;
    int i4;
    for (int i3 = 0; i2 < i1; i3 = i4)
    {
      j localj = (j)f.get(i2);
      i4 = i3;
      if (b == paramInt)
      {
        i4 = i3;
        if (localj.d(paramBoolean)) {
          i4 = 1;
        }
      }
      i2++;
    }
    if (i3 != 0) {
      b(true);
    }
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    c = paramBoolean;
    b(false);
  }
  
  public int size()
  {
    return f.size();
  }
  
  public static abstract interface a
  {
    public abstract void a(h paramh);
    
    public abstract boolean a(h paramh, MenuItem paramMenuItem);
  }
  
  public static abstract interface b
  {
    public abstract boolean a(j paramj);
  }
}

/* Location:
 * Qualified Name:     d.b.d.i.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */