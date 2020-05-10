package d.b.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.Window.Callback;
import android.widget.PopupWindow;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.id;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ViewStubCompat;
import d.b.d.a.a;
import d.b.d.c;
import d.b.d.d;
import d.b.d.e.a;
import d.i.i.n;
import java.lang.ref.WeakReference;
import java.util.List;

public class k$e
  extends d.b.d.h
{
  public k$e(k paramk, Window.Callback paramCallback)
  {
    super(paramCallback);
  }
  
  public final ActionMode a(ActionMode.Callback paramCallback)
  {
    e.a locala = new e.a(y.x, paramCallback);
    k localk = y;
    Object localObject1;
    Object localObject2;
    if (localk != null)
    {
      paramCallback = I;
      if (paramCallback != null) {
        paramCallback.a();
      }
      localObject1 = new k.d(localk, locala);
      localk.i();
      paramCallback = C;
      if (paramCallback != null)
      {
        localObject2 = paramCallback.a((a.a)localObject1);
        I = ((d.b.d.a)localObject2);
        if (localObject2 != null)
        {
          paramCallback = B;
          if (paramCallback != null) {
            paramCallback.a((d.b.d.a)localObject2);
          }
        }
      }
      if (I == null)
      {
        localk.d();
        paramCallback = I;
        if (paramCallback != null) {
          paramCallback.a();
        }
        paramCallback = B;
        if ((paramCallback == null) || (d0)) {}
      }
    }
    try
    {
      paramCallback = paramCallback.a((a.a)localObject1);
    }
    catch (AbstractMethodError paramCallback)
    {
      boolean bool;
      Object localObject3;
      int i;
      for (;;) {}
    }
    paramCallback = null;
    if (paramCallback != null)
    {
      I = paramCallback;
    }
    else
    {
      paramCallback = J;
      bool = true;
      if (paramCallback == null) {
        if (X)
        {
          localObject2 = new TypedValue();
          paramCallback = x.getTheme();
          paramCallback.resolveAttribute(R.attr.actionBarTheme, (TypedValue)localObject2, true);
          if (resourceId != 0)
          {
            localObject3 = x.getResources().newTheme();
            ((Resources.Theme)localObject3).setTo(paramCallback);
            ((Resources.Theme)localObject3).applyStyle(resourceId, true);
            paramCallback = new c(x, 0);
            paramCallback.getTheme().setTo((Resources.Theme)localObject3);
          }
          else
          {
            paramCallback = x;
          }
          J = new ActionBarContextView(paramCallback);
          localObject3 = new PopupWindow(paramCallback, null, R.attr.actionModePopupWindowStyle);
          K = ((PopupWindow)localObject3);
          s.a((PopupWindow)localObject3, 2);
          K.setContentView(J);
          K.setWidth(-1);
          paramCallback.getTheme().resolveAttribute(R.attr.actionBarSize, (TypedValue)localObject2, true);
          i = TypedValue.complexToDimensionPixelSize(data, paramCallback.getResources().getDisplayMetrics());
          J.setContentHeight(i);
          K.setHeight(-2);
          L = new o(localk);
        }
        else
        {
          paramCallback = (ViewStubCompat)P.findViewById(R.id.action_mode_bar_stub);
          if (paramCallback != null)
          {
            paramCallback.setLayoutInflater(LayoutInflater.from(localk.g()));
            J = ((ActionBarContextView)paramCallback.a());
          }
        }
      }
      if (J != null)
      {
        localk.d();
        J.b();
        localObject2 = J.getContext();
        paramCallback = J;
        if (K != null) {
          bool = false;
        }
        localObject2 = new d((Context)localObject2, paramCallback, (a.a)localObject1, bool);
        paramCallback = E;
        if (a.b((d.b.d.a)localObject2, paramCallback))
        {
          ((d)localObject2).g();
          J.a((d.b.d.a)localObject2);
          I = ((d.b.d.a)localObject2);
          if (localk.j())
          {
            J.setAlpha(0.0F);
            localObject2 = n.a(J);
            ((d.i.i.s)localObject2).a(1.0F);
            M = ((d.i.i.s)localObject2);
            paramCallback = new p(localk);
            localObject1 = (View)a.get();
            if (localObject1 != null) {
              ((d.i.i.s)localObject2).a((View)localObject1, paramCallback);
            }
          }
          else
          {
            J.setAlpha(1.0F);
            J.setVisibility(0);
            J.sendAccessibilityEvent(32);
            if ((J.getParent() instanceof View)) {
              ((View)J.getParent()).requestApplyInsets();
            }
          }
          if (K != null) {
            y.getDecorView().post(L);
          }
        }
        else
        {
          I = null;
        }
      }
    }
    paramCallback = I;
    if (paramCallback != null)
    {
      localObject1 = B;
      if (localObject1 != null) {
        ((i)localObject1).a(paramCallback);
      }
    }
    I = I;
    paramCallback = I;
    if (paramCallback != null) {
      return locala.b(paramCallback);
    }
    return null;
    throw null;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool;
    if ((!y.a(paramKeyEvent)) && (!x.dispatchKeyEvent(paramKeyEvent))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
  {
    boolean bool1 = x.dispatchKeyShortcutEvent(paramKeyEvent);
    boolean bool2 = false;
    if (!bool1)
    {
      k localk = y;
      int i = paramKeyEvent.getKeyCode();
      localk.i();
      Object localObject = C;
      if ((localObject != null) && (((a)localObject).a(i, paramKeyEvent))) {}
      do
      {
        for (;;)
        {
          i = 1;
          break label164;
          localObject = b0;
          if ((localObject == null) || (!localk.a((k.h)localObject, paramKeyEvent.getKeyCode(), paramKeyEvent, 1))) {
            break;
          }
          paramKeyEvent = b0;
          if (paramKeyEvent != null) {
            n = true;
          }
        }
        if (b0 != null) {
          break;
        }
        localObject = localk.d(0);
        localk.b((k.h)localObject, paramKeyEvent);
        bool1 = localk.a((k.h)localObject, paramKeyEvent.getKeyCode(), paramKeyEvent, 1);
        m = false;
      } while (bool1);
      i = 0;
      label164:
      if (i == 0) {}
    }
    else
    {
      bool2 = true;
    }
    return bool2;
  }
  
  public void onContentChanged() {}
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    if ((paramInt == 0) && (!(paramMenu instanceof d.b.d.i.h))) {
      return false;
    }
    return x.onCreatePanelMenu(paramInt, paramMenu);
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    x.onMenuOpened(paramInt, paramMenu);
    paramMenu = y;
    if (paramMenu != null)
    {
      if (paramInt == 108)
      {
        paramMenu.i();
        paramMenu = C;
        if (paramMenu != null) {
          paramMenu.a(true);
        }
      }
      return true;
    }
    throw null;
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    x.onPanelClosed(paramInt, paramMenu);
    paramMenu = y;
    if (paramMenu != null)
    {
      if (paramInt == 108)
      {
        paramMenu.i();
        paramMenu = C;
        if (paramMenu != null) {
          paramMenu.a(false);
        }
      }
      else if (paramInt == 0)
      {
        k.h localh = paramMenu.d(paramInt);
        if (o) {
          paramMenu.a(localh, false);
        }
      }
      return;
    }
    throw null;
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    d.b.d.i.h localh;
    if ((paramMenu instanceof d.b.d.i.h)) {
      localh = (d.b.d.i.h)paramMenu;
    } else {
      localh = null;
    }
    if ((paramInt == 0) && (localh == null)) {
      return false;
    }
    if (localh != null) {
      y = true;
    }
    boolean bool = x.onPreparePanel(paramInt, paramView, paramMenu);
    if (localh != null) {
      y = false;
    }
    return bool;
  }
  
  public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> paramList, Menu paramMenu, int paramInt)
  {
    Object localObject = y.d(0);
    if (localObject != null)
    {
      localObject = j;
      if (localObject != null)
      {
        x.onProvideKeyboardShortcuts(paramList, (Menu)localObject, paramInt);
        return;
      }
    }
    x.onProvideKeyboardShortcuts(paramList, paramMenu, paramInt);
  }
  
  public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return null;
    }
    if (y.N) {
      return a(paramCallback);
    }
    return x.onWindowStartingActionMode(paramCallback);
  }
  
  public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback, int paramInt)
  {
    if ((y.N) && (paramInt == 0)) {
      return a(paramCallback);
    }
    return x.onWindowStartingActionMode(paramCallback, paramInt);
  }
}

/* Location:
 * Qualified Name:     d.b.a.k.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */