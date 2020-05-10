package d.b.a;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.PopupWindow;

import androidx.appcompat.R.attr;
import androidx.appcompat.R.id;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ViewStubCompat;

import java.util.List;

import d.b.d.c;
import d.b.d.d;
import d.b.d.e.a;
import d.b.d.h;
import d.b.d.i.g;
import d.i.i.n;
import d.i.i.s;
import d.i.i.t;

public class k$e
  extends h
{
  public k$e(k paramk, Window.Callback paramCallback)
  {
    super(paramCallback);
  }
  
  public final ActionMode a(ActionMode.Callback paramCallback)
  {
    e.a locala = new e.a(y.A, paramCallback);
    k localk = y;
    Object localObject2;
    if (localk != null)
    {
      paramCallback = K;
      if (paramCallback != null) {
        paramCallback.a();
      }
      localObject1 = new k.d(localk, locala);
      localk.k();
      paramCallback = E;
      if (paramCallback != null)
      {
        localObject2 = paramCallback.a((a.a)localObject1);
        K = ((d.b.d.a)localObject2);
        if (localObject2 != null)
        {
          paramCallback = D;
          if (paramCallback != null) {
            paramCallback.a((d.b.d.a)localObject2);
          }
        }
      }
      if (K == null)
      {
        localk.e();
        paramCallback = K;
        if (paramCallback != null) {
          paramCallback.a();
        }
        paramCallback = D;
        if ((paramCallback == null) || (i0)) {}
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
      K = paramCallback;
    }
    else
    {
      paramCallback = L;
      bool = true;
      if (paramCallback == null) {
        if (Z)
        {
          localObject2 = new TypedValue();
          paramCallback = A.getTheme();
          paramCallback.resolveAttribute(R.attr.actionBarTheme, (TypedValue)localObject2, true);
          if (resourceId != 0)
          {
            localObject3 = A.getResources().newTheme();
            ((Resources.Theme)localObject3).setTo(paramCallback);
            ((Resources.Theme)localObject3).applyStyle(resourceId, true);
            paramCallback = new c(A, 0);
            paramCallback.getTheme().setTo((Resources.Theme)localObject3);
          }
          else
          {
            paramCallback = A;
          }
          L = new ActionBarContextView(paramCallback);
          localObject3 = new PopupWindow(paramCallback, null, R.attr.actionModePopupWindowStyle);
          M = ((PopupWindow)localObject3);
          r.a((PopupWindow)localObject3, 2);
          M.setContentView(L);
          M.setWidth(-1);
          paramCallback.getTheme().resolveAttribute(R.attr.actionBarSize, (TypedValue)localObject2, true);
          i = TypedValue.complexToDimensionPixelSize(data, paramCallback.getResources().getDisplayMetrics());
          L.setContentHeight(i);
          M.setHeight(-2);
          N = new o(localk);
        }
        else
        {
          paramCallback = (ViewStubCompat)R.findViewById(R.id.action_mode_bar_stub);
          if (paramCallback != null)
          {
            paramCallback.setLayoutInflater(LayoutInflater.from(localk.h()));
            L = ((ActionBarContextView)paramCallback.a());
          }
        }
      }
      if (L != null)
      {
        localk.e();
        L.b();
        paramCallback = L.getContext();
        localObject2 = L;
        if (M != null) {
          bool = false;
        }
        paramCallback = new d(paramCallback, (ActionBarContextView)localObject2, (a.a)localObject1, bool);
        localObject2 = E;
        if (a.b(paramCallback, (Menu)localObject2))
        {
          paramCallback.g();
          L.a(paramCallback);
          K = paramCallback;
          if (localk.l())
          {
            L.setAlpha(0.0F);
            localObject1 = n.a(L);
            ((s)localObject1).a(1.0F);
            O = ((s)localObject1);
            localObject2 = new p(localk);
            paramCallback = (View)a.get();
            if (paramCallback != null) {
              ((s)localObject1).a(paramCallback, (t)localObject2);
            }
          }
          else
          {
            L.setAlpha(1.0F);
            L.setVisibility(0);
            L.sendAccessibilityEvent(32);
            if ((L.getParent() instanceof View)) {
              ((View)L.getParent()).requestApplyInsets();
            }
          }
          if (M != null) {
            B.getDecorView().post(N);
          }
        }
        else
        {
          K = null;
        }
      }
    }
    Object localObject1 = K;
    if (localObject1 != null)
    {
      paramCallback = D;
      if (paramCallback != null) {
        paramCallback.a((d.b.d.a)localObject1);
      }
    }
    K = K;
    paramCallback = K;
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
      localk.k();
      Object localObject = E;
      if ((localObject != null) && (((a)localObject).a(i, paramKeyEvent))) {}
      do
      {
        for (;;)
        {
          i = 1;
          break label164;
          localObject = d0;
          if ((localObject == null) || (!localk.a((k.j)localObject, paramKeyEvent.getKeyCode(), paramKeyEvent, 1))) {
            break;
          }
          paramKeyEvent = d0;
          if (paramKeyEvent != null) {
            n = true;
          }
        }
        if (d0 != null) {
          break;
        }
        localObject = localk.d(0);
        localk.b((k.j)localObject, paramKeyEvent);
        bool1 = localk.a((k.j)localObject, paramKeyEvent.getKeyCode(), paramKeyEvent, 1);
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
    if ((paramInt == 0) && (!(paramMenu instanceof g))) {
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
        paramMenu.k();
        paramMenu = E;
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
    k localk = y;
    if (localk != null)
    {
      if (paramInt == 108)
      {
        localk.k();
        paramMenu = E;
        if (paramMenu != null) {
          paramMenu.a(false);
        }
      }
      else if (paramInt == 0)
      {
        paramMenu = localk.d(paramInt);
        if (o) {
          localk.a(paramMenu, false);
        }
      }
      return;
    }
    throw null;
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    g localg;
    if ((paramMenu instanceof g)) {
      localg = (g)paramMenu;
    } else {
      localg = null;
    }
    if ((paramInt == 0) && (localg == null)) {
      return false;
    }
    if (localg != null) {
      y = true;
    }
    boolean bool = x.onPreparePanel(paramInt, paramView, paramMenu);
    if (localg != null) {
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
    if (y.P) {
      return a(paramCallback);
    }
    return x.onWindowStartingActionMode(paramCallback);
  }
  
  public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback, int paramInt)
  {
    if ((y.P) && (paramInt == 0)) {
      return a(paramCallback);
    }
    return x.onWindowStartingActionMode(paramCallback, paramInt);
  }
}

/* Location:
 * Qualified Name:     base.d.b.a.k.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */