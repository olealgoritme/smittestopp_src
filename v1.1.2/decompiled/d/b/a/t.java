package d.b.a;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window.Callback;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Toolbar.e;
import d.b.d.i.h.a;
import d.b.d.i.o.a;
import d.b.e.b0;
import d.b.e.x0;
import d.i.i.n;
import java.util.ArrayList;

public class t
  extends a
{
  public b0 a;
  public boolean b;
  public Window.Callback c;
  public boolean d;
  public boolean e;
  public ArrayList<a.b> f = new ArrayList();
  public final Runnable g = new a();
  public final Toolbar.e h = new b();
  
  public t(Toolbar paramToolbar, CharSequence paramCharSequence, Window.Callback paramCallback)
  {
    a = new x0(paramToolbar, false);
    paramCallback = new e(paramCallback);
    c = paramCallback;
    a.setWindowCallback(paramCallback);
    paramToolbar.setOnMenuItemClickListener(h);
    a.setWindowTitle(paramCharSequence);
  }
  
  public void a(int paramInt)
  {
    a.d(paramInt);
  }
  
  public void a(Configuration paramConfiguration) {}
  
  public void a(Drawable paramDrawable)
  {
    a.a(paramDrawable);
  }
  
  public void a(CharSequence paramCharSequence)
  {
    a.setTitle(paramCharSequence);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean == e) {
      return;
    }
    e = paramBoolean;
    int i = f.size();
    for (int j = 0; j < i; j++) {
      ((a.b)f.get(j)).a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    return a.d();
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    Menu localMenu = h();
    if (localMenu != null)
    {
      if (paramKeyEvent != null) {
        i = paramKeyEvent.getDeviceId();
      } else {
        i = -1;
      }
      int i = KeyCharacterMap.load(i).getKeyboardType();
      boolean bool = true;
      if (i == 1) {
        bool = false;
      }
      localMenu.setQwertyMode(bool);
      return localMenu.performShortcut(paramInt, paramKeyEvent, 0);
    }
    return false;
  }
  
  public boolean a(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 1) {
      a.e();
    }
    return true;
  }
  
  public void b(CharSequence paramCharSequence)
  {
    a.setWindowTitle(paramCharSequence);
  }
  
  public void b(boolean paramBoolean) {}
  
  public boolean b()
  {
    if (a.j())
    {
      a.collapseActionView();
      return true;
    }
    return false;
  }
  
  public int c()
  {
    return a.k();
  }
  
  public void c(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 4;
    } else {
      i = 0;
    }
    int j = a.k();
    a.b(i & 0x4 | 0xFFFFFFFB & j);
  }
  
  public Context d()
  {
    return a.i();
  }
  
  public void d(boolean paramBoolean) {}
  
  public boolean e()
  {
    a.h().removeCallbacks(g);
    n.a(a.h(), g);
    return true;
  }
  
  public void f()
  {
    a.h().removeCallbacks(g);
  }
  
  public boolean g()
  {
    return a.e();
  }
  
  public final Menu h()
  {
    if (!d)
    {
      a.a(new c(), new d());
      d = true;
    }
    return a.l();
  }
  
  public class a
    implements Runnable
  {
    public a() {}
    
    public void run()
    {
      t localt = t.this;
      Menu localMenu = localt.h();
      d.b.d.i.h localh;
      if ((localMenu instanceof d.b.d.i.h)) {
        localh = (d.b.d.i.h)localMenu;
      } else {
        localh = null;
      }
      if (localh != null) {
        localh.j();
      }
      try
      {
        localMenu.clear();
        if ((!c.onCreatePanelMenu(0, localMenu)) || (!c.onPreparePanel(0, null, localMenu))) {
          localMenu.clear();
        }
        return;
      }
      finally
      {
        if (localh != null) {
          localh.i();
        }
      }
    }
  }
  
  public class b
    implements Toolbar.e
  {
    public b() {}
  }
  
  public final class c
    implements o.a
  {
    public boolean x;
    
    public c() {}
    
    public void a(d.b.d.i.h paramh, boolean paramBoolean)
    {
      if (x) {
        return;
      }
      x = true;
      a.g();
      Window.Callback localCallback = c;
      if (localCallback != null) {
        localCallback.onPanelClosed(108, paramh);
      }
      x = false;
    }
    
    public boolean a(d.b.d.i.h paramh)
    {
      Window.Callback localCallback = c;
      if (localCallback != null)
      {
        localCallback.onMenuOpened(108, paramh);
        return true;
      }
      return false;
    }
  }
  
  public final class d
    implements h.a
  {
    public d() {}
    
    public void a(d.b.d.i.h paramh)
    {
      t localt = t.this;
      if (c != null) {
        if (a.a()) {
          c.onPanelClosed(108, paramh);
        } else if (c.onPreparePanel(0, null, paramh)) {
          c.onMenuOpened(108, paramh);
        }
      }
    }
    
    public boolean a(d.b.d.i.h paramh, MenuItem paramMenuItem)
    {
      return false;
    }
  }
  
  public class e
    extends d.b.d.h
  {
    public e(Window.Callback paramCallback)
    {
      super();
    }
    
    public View onCreatePanelView(int paramInt)
    {
      if (paramInt == 0) {
        return new View(a.i());
      }
      return x.onCreatePanelView(paramInt);
    }
    
    public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
    {
      boolean bool = x.onPreparePanel(paramInt, paramView, paramMenu);
      if (bool)
      {
        paramView = t.this;
        if (!b)
        {
          a.b();
          b = true;
        }
      }
      return bool;
    }
  }
}

/* Location:
 * Qualified Name:     d.b.a.t
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */