package d.b.a;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;

import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Toolbar.f;

import java.util.ArrayList;

import d.b.e.d0;
import d.b.e.z0;
import d.i.i.n;

public class s
  extends a
{
  public d0 a;
  public boolean b;
  public Window.Callback c;
  public boolean d;
  public boolean e;
  public ArrayList<a.b> f = new ArrayList();
  public final Runnable g = new s.a(this);
  public final Toolbar.f h = new s.b(this);
  
  public s(Toolbar paramToolbar, CharSequence paramCharSequence, Window.Callback paramCallback)
  {
    a = new z0(paramToolbar, false);
    paramCallback = new s.e(this, paramCallback);
    c = paramCallback;
    a.setWindowCallback(paramCallback);
    paramToolbar.setOnMenuItemClickListener(h);
    a.setWindowTitle(paramCharSequence);
  }
  
  public void a(int paramInt)
  {
    a.c(paramInt);
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
    return a.c();
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
      a.d();
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
    if (a.n())
    {
      a.collapseActionView();
      return true;
    }
    return false;
  }
  
  public int c()
  {
    return a.h();
  }
  
  public void c(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 4;
    } else {
      i = 0;
    }
    int j = a.h();
    a.d(i & 0x4 | 0xFFFFFFFB & j);
  }
  
  public Context d()
  {
    return a.k();
  }
  
  public void d(boolean paramBoolean) {}
  
  public boolean e()
  {
    a.j().removeCallbacks(g);
    n.a(a.j(), g);
    return true;
  }
  
  public void f()
  {
    a.j().removeCallbacks(g);
  }
  
  public boolean g()
  {
    return a.d();
  }
  
  public final Menu h()
  {
    if (!d)
    {
      a.a(new s.c(this), new s.d(this));
      d = true;
    }
    return a.i();
  }
}

/* Location:
 * Qualified Name:     base.d.b.a.s
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */