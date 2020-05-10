package d.b.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import d.b.d.f;
import d.b.e.c1;
import d.i.a.d;
import d.i.a.l;
import d.i.a.l.a;
import d.m.a.c;

public class h
  extends c
  implements i, l.a
{
  public j x;
  public Resources y;
  
  public d.b.d.a a(a.a parama)
  {
    return null;
  }
  
  public void a(d.b.d.a parama) {}
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    j().a(paramView, paramLayoutParams);
  }
  
  public void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    paramContext = (k)j();
    paramContext.a(false);
    f0 = true;
  }
  
  public void b(d.b.d.a parama) {}
  
  public Intent c()
  {
    return r.a(this);
  }
  
  public void closeOptionsMenu()
  {
    a locala = k();
    if ((getWindow().hasFeature(0)) && ((locala == null) || (!locala.a()))) {
      super.closeOptionsMenu();
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    int i = paramKeyEvent.getKeyCode();
    a locala = k();
    if ((i == 82) && (locala != null) && (locala.a(paramKeyEvent))) {
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public <T extends View> T findViewById(int paramInt)
  {
    k localk = (k)j();
    localk.f();
    return B.findViewById(paramInt);
  }
  
  public MenuInflater getMenuInflater()
  {
    k localk = (k)j();
    if (F == null)
    {
      localk.k();
      Object localObject = E;
      if (localObject != null) {
        localObject = ((a)localObject).d();
      } else {
        localObject = A;
      }
      F = new f((Context)localObject);
    }
    return F;
  }
  
  public Resources getResources()
  {
    if (y == null) {
      c1.a();
    }
    Resources localResources1 = y;
    Resources localResources2 = localResources1;
    if (localResources1 == null) {
      localResources2 = super.getResources();
    }
    return localResources2;
  }
  
  public void invalidateOptionsMenu()
  {
    j().b();
  }
  
  public j j()
  {
    if (x == null) {
      x = j.a(this, this);
    }
    return x;
  }
  
  public a k()
  {
    k localk = (k)j();
    localk.k();
    return E;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    Object localObject;
    if (y != null)
    {
      localObject = super.getResources().getDisplayMetrics();
      y.updateConfiguration(paramConfiguration, (DisplayMetrics)localObject);
    }
    k localk = (k)j();
    if ((W) && (Q))
    {
      localk.k();
      localObject = E;
      if (localObject != null) {
        ((a)localObject).a(paramConfiguration);
      }
    }
    d.b.e.j.a().a(A);
    localk.a(false);
  }
  
  public void onContentChanged() {}
  
  public void onCreate(Bundle paramBundle)
  {
    j localj = j();
    localj.a();
    localj.a(paramBundle);
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject1 = (k)j();
    if (localObject1 != null)
    {
      j.b((j)localObject1);
      if (p0) {
        B.getDecorView().removeCallbacks(r0);
      }
      h0 = false;
      i0 = true;
      Object localObject2 = E;
      if (localObject2 != null) {
        ((a)localObject2).f();
      }
      localObject2 = n0;
      if (localObject2 != null) {
        ((k.g)localObject2).a();
      }
      localObject1 = o0;
      if (localObject1 != null) {
        ((k.g)localObject1).a();
      }
      return;
    }
    throw null;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((Build.VERSION.SDK_INT < 26) && (!paramKeyEvent.isCtrlPressed()) && (!KeyEvent.metaStateHasNoModifiers(paramKeyEvent.getMetaState())) && (paramKeyEvent.getRepeatCount() == 0) && (!KeyEvent.isModifierKey(paramKeyEvent.getKeyCode())))
    {
      Window localWindow = getWindow();
      if ((localWindow != null) && (localWindow.getDecorView() != null) && (localWindow.getDecorView().dispatchKeyShortcutEvent(paramKeyEvent)))
      {
        i = 1;
        break label78;
      }
    }
    int i = 0;
    label78:
    if (i != 0) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public final boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    boolean bool1 = super.onMenuItemSelected(paramInt, paramMenuItem);
    boolean bool2 = true;
    if (bool1) {
      return true;
    }
    Object localObject = k();
    if ((paramMenuItem.getItemId() == 16908332) && (localObject != null) && ((((a)localObject).c() & 0x4) != 0))
    {
      paramMenuItem = r.a(this);
      if (paramMenuItem != null)
      {
        if (shouldUpRecreateTask(paramMenuItem))
        {
          l locall = new l(this);
          localObject = c();
          paramMenuItem = (MenuItem)localObject;
          if (localObject == null) {
            paramMenuItem = r.a(this);
          }
          if (paramMenuItem != null)
          {
            ComponentName localComponentName = paramMenuItem.getComponent();
            localObject = localComponentName;
            if (localComponentName == null) {
              localObject = paramMenuItem.resolveActivity(y.getPackageManager());
            }
            locall.a((ComponentName)localObject);
            x.add(paramMenuItem);
          }
          locall.a();
          try
          {
            d.i.a.a.a(this);
          }
          catch (IllegalStateException paramMenuItem)
          {
            finish();
          }
        }
        else
        {
          navigateUpTo(paramMenuItem);
        }
      }
      else {
        bool2 = false;
      }
      return bool2;
    }
    return false;
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    return super.onMenuOpened(paramInt, paramMenu);
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    super.onPanelClosed(paramInt, paramMenu);
  }
  
  public void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    ((k)j()).f();
  }
  
  public void onPostResume()
  {
    super.onPostResume();
    Object localObject = (k)j();
    ((k)localObject).k();
    localObject = E;
    if (localObject != null) {
      ((a)localObject).d(true);
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle = (k)j();
    if (j0 != -100) {
      k.w0.put(z.getClass(), Integer.valueOf(j0));
    }
  }
  
  public void onStart()
  {
    super.onStart();
    k localk = (k)j();
    h0 = true;
    localk.d();
    j.a(localk);
  }
  
  public void onStop()
  {
    super.onStop();
    j().c();
  }
  
  public void onTitleChanged(CharSequence paramCharSequence, int paramInt)
  {
    super.onTitleChanged(paramCharSequence, paramInt);
    j().a(paramCharSequence);
  }
  
  public void openOptionsMenu()
  {
    a locala = k();
    if ((getWindow().hasFeature(0)) && ((locala == null) || (!locala.g()))) {
      super.openOptionsMenu();
    }
  }
  
  public void setContentView(int paramInt)
  {
    j().b(paramInt);
  }
  
  public void setContentView(View paramView)
  {
    j().a(paramView);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    j().b(paramView, paramLayoutParams);
  }
  
  public void setTheme(int paramInt)
  {
    super.setTheme(paramInt);
    jk0 = paramInt;
  }
  
  public void supportInvalidateOptionsMenu()
  {
    j().b();
  }
}

/* Location:
 * Qualified Name:     base.d.b.a.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */