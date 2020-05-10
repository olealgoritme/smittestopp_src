package d.b.a;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.Window.Callback;
import d.b.d.a.a;
import d.b.d.f;
import d.b.e.a1;
import d.i.a.b;
import d.i.a.j.a;
import d.m.a.c;
import java.util.ArrayList;

public class h
  extends c
  implements i, j.a
{
  public j x;
  public int y = 0;
  public Resources z;
  
  public d.b.d.a a(a.a parama)
  {
    return null;
  }
  
  public void a(d.b.d.a parama) {}
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    k localk = (k)j();
    localk.f();
    ((ViewGroup)P.findViewById(16908290)).addView(paramView, paramLayoutParams);
    z.onContentChanged();
  }
  
  public void b(d.b.d.a parama) {}
  
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
    return y.findViewById(paramInt);
  }
  
  public Intent g()
  {
    return s.a(this);
  }
  
  public MenuInflater getMenuInflater()
  {
    k localk = (k)j();
    if (D == null)
    {
      localk.i();
      Object localObject = C;
      if (localObject != null) {
        localObject = ((a)localObject).d();
      } else {
        localObject = x;
      }
      D = new f((Context)localObject);
    }
    return D;
  }
  
  public Resources getResources()
  {
    if (z == null) {
      a1.a();
    }
    Resources localResources1 = z;
    Resources localResources2 = localResources1;
    if (localResources1 == null) {
      localResources2 = super.getResources();
    }
    return localResources2;
  }
  
  public void invalidateOptionsMenu()
  {
    j().c();
  }
  
  public j j()
  {
    if (x == null) {
      x = new k(this, getWindow(), this);
    }
    return x;
  }
  
  public a k()
  {
    k localk = (k)j();
    localk.i();
    return C;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    Object localObject = (k)j();
    if ((U) && (O))
    {
      ((k)localObject).i();
      a locala = C;
      if (locala != null) {
        locala.a(paramConfiguration);
      }
    }
    d.b.e.j.a().b(x);
    ((k)localObject).a();
    if (z != null)
    {
      localObject = super.getResources().getDisplayMetrics();
      z.updateConfiguration(paramConfiguration, (DisplayMetrics)localObject);
    }
  }
  
  public void onContentChanged() {}
  
  public void onCreate(Bundle paramBundle)
  {
    j localj = j();
    localj.b();
    localj.a(paramBundle);
    if (localj.a())
    {
      int i = y;
      if (i != 0) {
        if (Build.VERSION.SDK_INT >= 23)
        {
          onApplyThemeResource(getTheme(), y, false);
        }
        else
        {
          super.setTheme(i);
          y = i;
        }
      }
    }
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    k localk = (k)j();
    if (h0) {
      y.getDecorView().removeCallbacks(j0);
    }
    d0 = true;
    Object localObject = C;
    if (localObject != null) {
      ((a)localObject).f();
    }
    localObject = g0;
    if (localObject != null) {
      ((k.f)localObject).a();
    }
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
      paramMenuItem = s.a(this);
      if (paramMenuItem != null)
      {
        if (shouldUpRecreateTask(paramMenuItem))
        {
          d.i.a.j localj = new d.i.a.j(this);
          localObject = g();
          paramMenuItem = (MenuItem)localObject;
          if (localObject == null) {
            paramMenuItem = s.a(this);
          }
          if (paramMenuItem != null)
          {
            ComponentName localComponentName = paramMenuItem.getComponent();
            localObject = localComponentName;
            if (localComponentName == null) {
              localObject = paramMenuItem.resolveActivity(y.getPackageManager());
            }
            localj.a((ComponentName)localObject);
            x.add(paramMenuItem);
          }
          localj.a();
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
    ((k)localObject).i();
    localObject = C;
    if (localObject != null) {
      ((a)localObject).d(true);
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    int i = je0;
    if (i != -100) {
      paramBundle.putInt("appcompat:local_night_mode", i);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    ((k)j()).a();
  }
  
  public void onStop()
  {
    super.onStop();
    Object localObject = (k)j();
    ((k)localObject).i();
    a locala = C;
    if (locala != null) {
      locala.d(false);
    }
    localObject = g0;
    if (localObject != null) {
      ((k.f)localObject).a();
    }
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
    j().a(paramView, paramLayoutParams);
  }
  
  public void setTheme(int paramInt)
  {
    super.setTheme(paramInt);
    y = paramInt;
  }
  
  public void supportInvalidateOptionsMenu()
  {
    j().c();
  }
}

/* Location:
 * Qualified Name:     d.b.a.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */