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
import android.view.Window.Callback;
import android.widget.TextView;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.id;
import androidx.appcompat.R.styleable;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Toolbar.c;
import androidx.appcompat.widget.Toolbar.d;
import d.b.a.a.a;
import d.b.b.a.a;
import d.b.d.i.h;
import d.b.d.i.h.a;
import d.b.d.i.j;
import d.b.d.i.o.a;
import d.i.i.n;
import d.i.i.s;
import d.i.i.u;
import java.lang.ref.WeakReference;

public class x0
  implements b0
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
  
  public x0(Toolbar paramToolbar, boolean paramBoolean)
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
    paramToolbar = u0.a(paramToolbar.getContext(), null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
    q = paramToolbar.b(R.styleable.ActionBar_homeAsUpIndicator);
    int i2;
    if (paramBoolean)
    {
      Object localObject1 = paramToolbar.d(R.styleable.ActionBar_title);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        setTitle((CharSequence)localObject1);
      }
      localObject1 = paramToolbar.d(R.styleable.ActionBar_subtitle);
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
      b(paramToolbar.d(R.styleable.ActionBar_displayOptions, 0));
      i2 = paramToolbar.g(R.styleable.ActionBar_customNavigationLayout, 0);
      Object localObject2;
      if (i2 != 0)
      {
        localObject2 = LayoutInflater.from(a.getContext()).inflate(i2, a, false);
        localObject1 = d;
        if ((localObject1 != null) && ((b & 0x10) != 0)) {
          a.removeView((View)localObject1);
        }
        d = ((View)localObject2);
        if ((localObject2 != null) && ((b & 0x10) != 0)) {
          a.addView((View)localObject2);
        }
        b(b | 0x10);
      }
      i2 = paramToolbar.f(R.styleable.ActionBar_height, 0);
      if (i2 > 0)
      {
        localObject1 = a.getLayoutParams();
        height = i2;
        a.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      int i3 = paramToolbar.b(R.styleable.ActionBar_contentInsetStart, -1);
      i2 = paramToolbar.b(R.styleable.ActionBar_contentInsetEnd, -1);
      if ((i3 >= 0) || (i2 >= 0))
      {
        localObject1 = a;
        i3 = Math.max(i3, 0);
        i2 = Math.max(i2, 0);
        ((Toolbar)localObject1).a();
        Q.a(i3, i2);
      }
      i2 = paramToolbar.g(R.styleable.ActionBar_titleTextStyle, 0);
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
      i2 = paramToolbar.g(R.styleable.ActionBar_subtitleTextStyle, 0);
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
      i2 = paramToolbar.g(R.styleable.ActionBar_popupTheme, 0);
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
        d(p);
      }
    }
    k = a.getNavigationContentDescription();
    a.setNavigationOnClickListener(new w0(this));
  }
  
  public s a(final int paramInt, long paramLong)
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
    a locala = new a(paramInt);
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
  
  public void a(Menu paramMenu, o.a parama)
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
    h localh = (h)paramMenu;
    if ((localh != null) || (x != null))
    {
      parama.c();
      paramMenu = x.M;
      if (paramMenu != localh)
      {
        if (paramMenu != null)
        {
          paramMenu.a(j0);
          paramMenu.a(k0);
        }
        if (k0 == null) {
          k0 = new Toolbar.c(parama);
        }
        O = true;
        if (localh != null)
        {
          localh.a(localc, G);
          localh.a(k0, G);
        }
        else
        {
          localc.a(G, null);
          Toolbar.c localc1 = k0;
          localh = x;
          if (localh != null)
          {
            paramMenu = y;
            if (paramMenu != null) {
              localh.a(paramMenu);
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
  
  public void a(o.a parama, h.a parama1)
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
  
  public void a(n0 paramn0)
  {
    Object localObject = c;
    if (localObject != null)
    {
      localObject = ((View)localObject).getParent();
      Toolbar localToolbar = a;
      if (localObject == localToolbar) {
        localToolbar.removeView(c);
      }
    }
    c = paramn0;
    if ((paramn0 != null) && (o == 2))
    {
      a.addView(paramn0, 0);
      localObject = (Toolbar.d)c.getLayoutParams();
      width = -2;
      height = -2;
      a = 8388691;
      paramn0.setAllowCollapse(true);
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a()
  {
    return a.e();
  }
  
  public void b()
  {
    m = true;
  }
  
  public void b(int paramInt)
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
  
  public void b(boolean paramBoolean)
  {
    a.setCollapsible(paramBoolean);
  }
  
  public void c(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = a.c(i(), paramInt);
    } else {
      localDrawable = null;
    }
    f = localDrawable;
    r();
  }
  
  public boolean c()
  {
    Object localObject = a.x;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (localObject != null)
    {
      localObject = Q;
      if (localObject != null)
      {
        if ((U == null) && (!((c)localObject).f())) {
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
  
  public void collapseActionView()
  {
    Object localObject = a.k0;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = y;
    }
    if (localObject != null) {
      ((j)localObject).collapseActionView();
    }
  }
  
  public void d(int paramInt)
  {
    String str;
    if (paramInt == 0) {
      str = null;
    } else {
      str = i().getString(paramInt);
    }
    k = str;
    p();
  }
  
  public boolean d()
  {
    Object localObject = a.x;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (localObject != null)
    {
      localObject = Q;
      int i1;
      if ((localObject != null) && (((c)localObject).b())) {
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
  
  public boolean e()
  {
    return a.f();
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
  
  public ViewGroup h()
  {
    return a;
  }
  
  public Context i()
  {
    return a.getContext();
  }
  
  public boolean j()
  {
    Toolbar.c localc = a.k0;
    boolean bool;
    if ((localc != null) && (y != null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int k()
  {
    return b;
  }
  
  public Menu l()
  {
    return a.getMenu();
  }
  
  public int m()
  {
    return o;
  }
  
  public void n()
  {
    Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
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
      localDrawable = a.c(i(), paramInt);
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
  
  public class a
    extends u
  {
    public boolean a = false;
    
    public a(int paramInt) {}
    
    public void a(View paramView)
    {
      a = true;
    }
    
    public void b(View paramView)
    {
      if (!a) {
        a.setVisibility(paramInt);
      }
    }
    
    public void c(View paramView)
    {
      a.setVisibility(0);
    }
  }
}

/* Location:
 * Qualified Name:     d.b.e.x0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */