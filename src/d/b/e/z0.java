package d.b.e;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window.Callback;
import android.widget.TextView;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.id;
import androidx.appcompat.R.styleable;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Toolbar.d;
import androidx.appcompat.widget.Toolbar.e;
import d.b.a.a.a;
import d.b.b.a.a;
import d.b.d.i.g;
import d.b.d.i.g.a;
import d.b.d.i.i;
import d.b.d.i.m.a;
import d.i.i.n;
import d.i.i.s;
import java.lang.ref.WeakReference;

public class z0
  implements d0
{
  public Toolbar a;
  public int b;
  public View c;
  public View d;
  public Drawable e;
  public Drawable f;
  public Drawable g;
  public boolean h;
  public CharSequence i;
  public CharSequence j;
  public CharSequence k;
  public Window.Callback l;
  public boolean m;
  public c n;
  public int o = 0;
  public int p = 0;
  public Drawable q;
  
  public z0(Toolbar paramToolbar, boolean paramBoolean)
  {
    a = paramToolbar;
    i = paramToolbar.getTitle();
    j = paramToolbar.getSubtitle();
    boolean bool;
    if (i != null) {
      bool = true;
    } else {
      bool = false;
    }
    h = bool;
    g = paramToolbar.getNavigationIcon();
    paramToolbar = x0.a(paramToolbar.getContext(), null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
    q = paramToolbar.b(R.styleable.ActionBar_homeAsUpIndicator);
    int i2;
    if (paramBoolean)
    {
      Object localObject1 = paramToolbar.e(R.styleable.ActionBar_title);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        setTitle((CharSequence)localObject1);
      }
      localObject1 = paramToolbar.e(R.styleable.ActionBar_subtitle);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        j = ((CharSequence)localObject1);
        if ((b & 0x8) != 0) {
          a.setSubtitle((CharSequence)localObject1);
        }
      }
      localObject1 = paramToolbar.b(R.styleable.ActionBar_logo);
      if (localObject1 != null)
      {
        f = ((Drawable)localObject1);
        r();
      }
      localObject1 = paramToolbar.b(R.styleable.ActionBar_icon);
      if (localObject1 != null)
      {
        e = ((Drawable)localObject1);
        r();
      }
      if (g == null)
      {
        localObject1 = q;
        if (localObject1 != null)
        {
          g = ((Drawable)localObject1);
          q();
        }
      }
      d(paramToolbar.c(R.styleable.ActionBar_displayOptions, 0));
      i2 = paramToolbar.f(R.styleable.ActionBar_customNavigationLayout, 0);
      Object localObject2;
      if (i2 != 0)
      {
        localObject1 = LayoutInflater.from(a.getContext()).inflate(i2, a, false);
        localObject2 = d;
        if ((localObject2 != null) && ((b & 0x10) != 0)) {
          a.removeView((View)localObject2);
        }
        d = ((View)localObject1);
        if ((localObject1 != null) && ((b & 0x10) != 0)) {
          a.addView((View)localObject1);
        }
        d(b | 0x10);
      }
      i2 = paramToolbar.e(R.styleable.ActionBar_height, 0);
      if (i2 > 0)
      {
        localObject1 = a.getLayoutParams();
        height = i2;
        a.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      int i3 = paramToolbar.a(R.styleable.ActionBar_contentInsetStart, -1);
      i2 = paramToolbar.a(R.styleable.ActionBar_contentInsetEnd, -1);
      if ((i3 >= 0) || (i2 >= 0))
      {
        localObject1 = a;
        i3 = Math.max(i3, 0);
        i2 = Math.max(i2, 0);
        ((Toolbar)localObject1).b();
        Q.a(i3, i2);
      }
      i2 = paramToolbar.f(R.styleable.ActionBar_titleTextStyle, 0);
      if (i2 != 0)
      {
        localObject2 = a;
        localObject1 = ((ViewGroup)localObject2).getContext();
        I = i2;
        localObject2 = y;
        if (localObject2 != null) {
          ((TextView)localObject2).setTextAppearance((Context)localObject1, i2);
        }
      }
      i2 = paramToolbar.f(R.styleable.ActionBar_subtitleTextStyle, 0);
      if (i2 != 0)
      {
        localObject2 = a;
        localObject1 = ((ViewGroup)localObject2).getContext();
        J = i2;
        localObject2 = z;
        if (localObject2 != null) {
          ((TextView)localObject2).setTextAppearance((Context)localObject1, i2);
        }
      }
      i2 = paramToolbar.f(R.styleable.ActionBar_popupTheme, 0);
      if (i2 != 0) {
        a.setPopupTheme(i2);
      }
    }
    else
    {
      if (a.getNavigationIcon() != null)
      {
        i2 = 15;
        q = a.getNavigationIcon();
      }
      else
      {
        i2 = 11;
      }
      b = i2;
    }
    b.recycle();
    if (i1 != p)
    {
      p = i1;
      if (TextUtils.isEmpty(a.getNavigationContentDescription())) {
        c(p);
      }
    }
    k = a.getNavigationContentDescription();
    a.setNavigationOnClickListener(new y0(this));
  }
  
  public s a(int paramInt, long paramLong)
  {
    s locals = n.a(a);
    float f1;
    if (paramInt == 0) {
      f1 = 1.0F;
    } else {
      f1 = 0.0F;
    }
    locals.a(f1);
    locals.a(paramLong);
    z0.a locala = new z0.a(this, paramInt);
    View localView = (View)a.get();
    if (localView != null) {
      locals.a(localView, locala);
    }
    return locals;
  }
  
  public void a(int paramInt)
  {
    a.setVisibility(paramInt);
  }
  
  public void a(Drawable paramDrawable)
  {
    g = paramDrawable;
    q();
  }
  
  public void a(Menu paramMenu, m.a parama)
  {
    if (n == null)
    {
      localc = new c(a.getContext());
      n = localc;
      F = R.id.action_menu_presenter;
    }
    c localc = n;
    B = parama;
    parama = a;
    g localg = (g)paramMenu;
    if ((localg != null) || (x != null))
    {
      parama.d();
      paramMenu = x.M;
      if (paramMenu != localg)
      {
        if (paramMenu != null)
        {
          paramMenu.a(j0);
          paramMenu.a(k0);
        }
        if (k0 == null) {
          k0 = new Toolbar.d(parama);
        }
        O = true;
        if (localg != null)
        {
          localg.a(localc, G);
          localg.a(k0, G);
        }
        else
        {
          localc.a(G, null);
          Toolbar.d locald = k0;
          localg = x;
          if (localg != null)
          {
            paramMenu = y;
            if (paramMenu != null) {
              localg.a(paramMenu);
            }
          }
          x = null;
          localc.a(true);
          k0.a(true);
        }
        x.setPopupTheme(H);
        x.setPresenter(localc);
        j0 = localc;
      }
    }
  }
  
  public void a(m.a parama, g.a parama1)
  {
    Object localObject = a;
    l0 = parama;
    m0 = parama1;
    localObject = x;
    if (localObject != null)
    {
      R = parama;
      S = parama1;
    }
  }
  
  public void a(q0 paramq0)
  {
    Object localObject = c;
    if (localObject != null)
    {
      ViewParent localViewParent = ((View)localObject).getParent();
      localObject = a;
      if (localViewParent == localObject) {
        ((ViewGroup)localObject).removeView(c);
      }
    }
    c = paramq0;
    if ((paramq0 != null) && (o == 2))
    {
      a.addView(paramq0, 0);
      localObject = (Toolbar.e)c.getLayoutParams();
      width = -2;
      height = -2;
      a = 8388691;
      paramq0.setAllowCollapse(true);
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a()
  {
    Object localObject = a.x;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (localObject != null)
    {
      localObject = Q;
      if (localObject != null)
      {
        if ((T == null) && (!((c)localObject).f())) {
          i1 = 0;
        } else {
          i1 = 1;
        }
        if (i1 != 0)
        {
          i1 = 1;
          break label65;
        }
      }
      int i1 = 0;
      label65:
      bool2 = bool1;
      if (i1 != 0) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public void b(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = a.c(k(), paramInt);
    } else {
      localDrawable = null;
    }
    f = localDrawable;
    r();
  }
  
  public void b(boolean paramBoolean)
  {
    a.setCollapsible(paramBoolean);
  }
  
  public boolean b()
  {
    return a.f();
  }
  
  public void c(int paramInt)
  {
    String str;
    if (paramInt == 0) {
      str = null;
    } else {
      str = k().getString(paramInt);
    }
    k = str;
    p();
  }
  
  public boolean c()
  {
    Object localObject = a.x;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (localObject != null)
    {
      localObject = Q;
      int i1;
      if ((localObject != null) && (((c)localObject).c())) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      bool2 = bool1;
      if (i1 != 0) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public void collapseActionView()
  {
    Object localObject = a.k0;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = y;
    }
    if (localObject != null) {
      ((i)localObject).collapseActionView();
    }
  }
  
  public void d(int paramInt)
  {
    int i1 = b ^ paramInt;
    b = paramInt;
    if (i1 != 0)
    {
      if ((i1 & 0x4) != 0)
      {
        if ((paramInt & 0x4) != 0) {
          p();
        }
        q();
      }
      if ((i1 & 0x3) != 0) {
        r();
      }
      if ((i1 & 0x8) != 0) {
        if ((paramInt & 0x8) != 0)
        {
          a.setTitle(i);
          a.setSubtitle(j);
        }
        else
        {
          a.setTitle(null);
          a.setSubtitle(null);
        }
      }
      if ((i1 & 0x10) != 0)
      {
        View localView = d;
        if (localView != null) {
          if ((paramInt & 0x10) != 0) {
            a.addView(localView);
          } else {
            a.removeView(localView);
          }
        }
      }
    }
  }
  
  public boolean d()
  {
    return a.g();
  }
  
  public void e()
  {
    m = true;
  }
  
  public boolean f()
  {
    Object localObject = a;
    if (((ViewGroup)localObject).getVisibility() == 0)
    {
      localObject = x;
      if ((localObject != null) && (P)) {
        return true;
      }
    }
    boolean bool = false;
    return bool;
  }
  
  public void g()
  {
    Object localObject = a.x;
    if (localObject != null)
    {
      localObject = Q;
      if (localObject != null) {
        ((c)localObject).a();
      }
    }
  }
  
  public CharSequence getTitle()
  {
    return a.getTitle();
  }
  
  public int h()
  {
    return b;
  }
  
  public Menu i()
  {
    return a.getMenu();
  }
  
  public ViewGroup j()
  {
    return a;
  }
  
  public Context k()
  {
    return a.getContext();
  }
  
  public int l()
  {
    return o;
  }
  
  public void m()
  {
    Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
  }
  
  public boolean n()
  {
    Toolbar.d locald = a.k0;
    boolean bool;
    if ((locald != null) && (y != null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void o()
  {
    Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
  }
  
  public final void p()
  {
    if ((b & 0x4) != 0) {
      if (TextUtils.isEmpty(k)) {
        a.setNavigationContentDescription(p);
      } else {
        a.setNavigationContentDescription(k);
      }
    }
  }
  
  public final void q()
  {
    if ((b & 0x4) != 0)
    {
      Toolbar localToolbar = a;
      Drawable localDrawable = g;
      if (localDrawable == null) {
        localDrawable = q;
      }
      localToolbar.setNavigationIcon(localDrawable);
    }
    else
    {
      a.setNavigationIcon(null);
    }
  }
  
  public final void r()
  {
    int i1 = b;
    Drawable localDrawable;
    if ((i1 & 0x2) != 0)
    {
      if ((i1 & 0x1) != 0)
      {
        localDrawable = f;
        if (localDrawable == null) {
          localDrawable = e;
        }
      }
      else
      {
        localDrawable = e;
      }
    }
    else {
      localDrawable = null;
    }
    a.setLogo(localDrawable);
  }
  
  public void setIcon(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = a.c(k(), paramInt);
    } else {
      localDrawable = null;
    }
    e = localDrawable;
    r();
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    e = paramDrawable;
    r();
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    h = true;
    i = paramCharSequence;
    if ((b & 0x8) != 0) {
      a.setTitle(paramCharSequence);
    }
  }
  
  public void setWindowCallback(Window.Callback paramCallback)
  {
    l = paramCallback;
  }
  
  public void setWindowTitle(CharSequence paramCharSequence)
  {
    if (!h)
    {
      i = paramCharSequence;
      if ((b & 0x8) != 0) {
        a.setTitle(paramCharSequence);
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.z0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */