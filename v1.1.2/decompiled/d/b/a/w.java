package d.b.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.bool;
import androidx.appcompat.R.id;
import androidx.appcompat.R.styleable;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionBarOverlayLayout.d;
import androidx.appcompat.widget.Toolbar;
import d.b.d.a.a;
import d.b.d.f;
import d.b.d.g;
import d.b.d.i.h;
import d.b.d.i.h.a;
import d.b.e.b0;
import d.b.e.c;
import d.i.i.n;
import d.i.i.s;
import d.i.i.t;
import d.i.i.u;
import d.i.i.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class w
  extends a
  implements ActionBarOverlayLayout.d
{
  public static final Interpolator A = new AccelerateInterpolator();
  public static final Interpolator B = new DecelerateInterpolator();
  public Context a;
  public Context b;
  public ActionBarOverlayLayout c;
  public ActionBarContainer d;
  public b0 e;
  public ActionBarContextView f;
  public View g;
  public boolean h;
  public d i;
  public d.b.d.a j;
  public a.a k;
  public boolean l;
  public ArrayList<a.b> m;
  public boolean n;
  public int o;
  public boolean p;
  public boolean q;
  public boolean r;
  public boolean s;
  public boolean t;
  public g u;
  public boolean v;
  public boolean w;
  public final t x;
  public final t y;
  public final v z;
  
  public w(Activity paramActivity, boolean paramBoolean)
  {
    new ArrayList();
    m = new ArrayList();
    o = 0;
    p = true;
    t = true;
    x = new a();
    y = new b();
    z = new c();
    paramActivity = paramActivity.getWindow().getDecorView();
    a(paramActivity);
    if (!paramBoolean) {
      g = paramActivity.findViewById(16908290);
    }
  }
  
  public w(Dialog paramDialog)
  {
    new ArrayList();
    m = new ArrayList();
    o = 0;
    p = true;
    t = true;
    x = new a();
    y = new b();
    z = new c();
    a(paramDialog.getWindow().getDecorView());
  }
  
  public d.b.d.a a(a.a parama)
  {
    d locald = i;
    if (locald != null) {
      locald.a();
    }
    c.setHideOnContentScrollEnabled(false);
    f.b();
    locald = new d(f.getContext(), parama);
    A.j();
    try
    {
      boolean bool = B.b(locald, A);
      A.i();
      if (bool)
      {
        i = locald;
        locald.g();
        f.a(locald);
        e(true);
        f.sendAccessibilityEvent(32);
        return locald;
      }
      return null;
    }
    finally
    {
      A.i();
    }
  }
  
  public void a(int paramInt)
  {
    e.d(paramInt);
  }
  
  public void a(Configuration paramConfiguration)
  {
    f(a.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs));
  }
  
  public void a(Drawable paramDrawable)
  {
    e.a(paramDrawable);
  }
  
  public final void a(View paramView)
  {
    Object localObject = (ActionBarOverlayLayout)paramView.findViewById(R.id.decor_content_parent);
    c = ((ActionBarOverlayLayout)localObject);
    if (localObject != null) {
      ((ActionBarOverlayLayout)localObject).setActionBarVisibilityCallback(this);
    }
    View localView = paramView.findViewById(R.id.action_bar);
    if ((localView instanceof b0))
    {
      localObject = (b0)localView;
    }
    else
    {
      if (!(localView instanceof Toolbar)) {
        break label377;
      }
      localObject = ((Toolbar)localView).getWrapper();
    }
    e = ((b0)localObject);
    f = ((ActionBarContextView)paramView.findViewById(R.id.action_context_bar));
    paramView = (ActionBarContainer)paramView.findViewById(R.id.action_bar_container);
    d = paramView;
    localObject = e;
    if ((localObject != null) && (f != null) && (paramView != null))
    {
      a = ((b0)localObject).i();
      if ((e.k() & 0x4) != 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0) {
        h = true;
      }
      paramView = a;
      int i2;
      if (getApplicationInfotargetSdkVersion < 14) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      boolean bool;
      if ((i2 == 0) && (i1 == 0)) {
        bool = false;
      } else {
        bool = true;
      }
      e.a(bool);
      f(paramView.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs));
      localObject = a.obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
      if (((TypedArray)localObject).getBoolean(R.styleable.ActionBar_hideOnContentScroll, false))
      {
        paramView = c;
        if (E)
        {
          w = true;
          paramView.setHideOnContentScrollEnabled(true);
        }
        else
        {
          throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
      }
      int i1 = ((TypedArray)localObject).getDimensionPixelSize(R.styleable.ActionBar_elevation, 0);
      if (i1 != 0)
      {
        float f1 = i1;
        n.a(d, f1);
      }
      ((TypedArray)localObject).recycle();
      return;
    }
    paramView = new StringBuilder();
    paramView.append(w.class.getSimpleName());
    paramView.append(" can only be used ");
    paramView.append("with a compatible window decor layout");
    throw new IllegalStateException(paramView.toString());
    label377:
    localObject = e.a.a.a.a.a("Can't make a decor toolbar out of ");
    if (localView != null) {
      paramView = localView.getClass().getSimpleName();
    } else {
      paramView = "null";
    }
    ((StringBuilder)localObject).append(paramView);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void a(CharSequence paramCharSequence)
  {
    e.setTitle(paramCharSequence);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean == l) {
      return;
    }
    l = paramBoolean;
    int i1 = m.size();
    for (int i2 = 0; i2 < i1; i2++) {
      ((a.b)m.get(i2)).a(paramBoolean);
    }
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    Object localObject = i;
    if (localObject == null) {
      return false;
    }
    localObject = A;
    if (localObject != null)
    {
      if (paramKeyEvent != null) {
        i1 = paramKeyEvent.getDeviceId();
      } else {
        i1 = -1;
      }
      int i1 = KeyCharacterMap.load(i1).getKeyboardType();
      boolean bool = true;
      if (i1 == 1) {
        bool = false;
      }
      ((Menu)localObject).setQwertyMode(bool);
      return ((Menu)localObject).performShortcut(paramInt, paramKeyEvent, 0);
    }
    return false;
  }
  
  public void b(CharSequence paramCharSequence)
  {
    e.setWindowTitle(paramCharSequence);
  }
  
  public void b(boolean paramBoolean)
  {
    if (!h) {
      c(paramBoolean);
    }
  }
  
  public boolean b()
  {
    b0 localb0 = e;
    if ((localb0 != null) && (localb0.j()))
    {
      e.collapseActionView();
      return true;
    }
    return false;
  }
  
  public int c()
  {
    return e.k();
  }
  
  public void c(boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = 4;
    } else {
      i1 = 0;
    }
    int i2 = e.k();
    h = true;
    e.b(i1 & 0x4 | 0xFFFFFFFB & i2);
  }
  
  public Context d()
  {
    if (b == null)
    {
      TypedValue localTypedValue = new TypedValue();
      a.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, localTypedValue, true);
      int i1 = resourceId;
      if (i1 != 0) {
        b = new ContextThemeWrapper(a, i1);
      } else {
        b = a;
      }
    }
    return b;
  }
  
  public void d(boolean paramBoolean)
  {
    v = paramBoolean;
    if (!paramBoolean)
    {
      g localg = u;
      if (localg != null) {
        localg.a();
      }
    }
  }
  
  public void e(boolean paramBoolean)
  {
    Object localObject1;
    if (paramBoolean)
    {
      if (!s)
      {
        s = true;
        localObject1 = c;
        if (localObject1 != null) {
          ((ActionBarOverlayLayout)localObject1).setShowingForActionMode(true);
        }
        g(false);
      }
    }
    else if (s)
    {
      s = false;
      localObject1 = c;
      if (localObject1 != null) {
        ((ActionBarOverlayLayout)localObject1).setShowingForActionMode(false);
      }
      g(false);
    }
    if (n.t(d))
    {
      if (paramBoolean)
      {
        localObject2 = e.a(4, 100L);
        localObject1 = f.a(0, 200L);
      }
      else
      {
        localObject1 = e.a(0, 200L);
        localObject2 = f.a(8, 100L);
      }
      g localg = new g();
      a.add(localObject2);
      Object localObject2 = (View)a.get();
      long l1;
      if (localObject2 != null) {
        l1 = ((View)localObject2).animate().getDuration();
      } else {
        l1 = 0L;
      }
      localObject2 = (View)a.get();
      if (localObject2 != null) {
        ((View)localObject2).animate().setStartDelay(l1);
      }
      a.add(localObject1);
      localg.b();
    }
    else if (paramBoolean)
    {
      e.a(4);
      f.setVisibility(0);
    }
    else
    {
      e.a(0);
      f.setVisibility(8);
    }
  }
  
  public final void f(boolean paramBoolean)
  {
    n = paramBoolean;
    if (!paramBoolean)
    {
      e.a(null);
      d.setTabContainer(null);
    }
    else
    {
      d.setTabContainer(null);
      e.a(null);
    }
    int i1 = e.m();
    boolean bool = true;
    if (i1 == 2) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    Object localObject = e;
    if ((!n) && (i1 != 0)) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    ((b0)localObject).b(paramBoolean);
    localObject = c;
    if ((!n) && (i1 != 0)) {
      paramBoolean = bool;
    } else {
      paramBoolean = false;
    }
    ((ActionBarOverlayLayout)localObject).setHasNonEmbeddedTabs(paramBoolean);
  }
  
  public final void g(boolean paramBoolean)
  {
    boolean bool = r;
    int i1;
    if ((!s) && (bool)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    Object localObject1;
    float f1;
    float f2;
    Object localObject2;
    if (i1 != 0)
    {
      if (!t)
      {
        t = true;
        localObject1 = u;
        if (localObject1 != null) {
          ((g)localObject1).a();
        }
        d.setVisibility(0);
        if ((o == 0) && ((v) || (paramBoolean)))
        {
          d.setTranslationY(0.0F);
          f1 = -d.getHeight();
          f2 = f1;
          if (paramBoolean)
          {
            localObject1 = new int[2];
            Object tmp118_116 = localObject1;
            tmp118_116[0] = 0;
            Object tmp122_118 = tmp118_116;
            tmp122_118[1] = 0;
            tmp122_118;
            d.getLocationInWindow((int[])localObject1);
            f2 = f1 - localObject1[1];
          }
          d.setTranslationY(f2);
          localObject1 = new g();
          localObject2 = n.a(d);
          ((s)localObject2).b(0.0F);
          ((s)localObject2).a(z);
          if (!e) {
            a.add(localObject2);
          }
          if (p)
          {
            localObject2 = g;
            if (localObject2 != null)
            {
              ((View)localObject2).setTranslationY(f2);
              localObject2 = n.a(g);
              ((s)localObject2).b(0.0F);
              if (!e) {
                a.add(localObject2);
              }
            }
          }
          localObject2 = B;
          if (!e) {
            c = ((Interpolator)localObject2);
          }
          if (!e) {
            b = 250L;
          }
          localObject2 = y;
          if (!e) {
            d = ((t)localObject2);
          }
          u = ((g)localObject1);
          ((g)localObject1).b();
        }
        else
        {
          d.setAlpha(1.0F);
          d.setTranslationY(0.0F);
          if (p)
          {
            localObject1 = g;
            if (localObject1 != null) {
              ((View)localObject1).setTranslationY(0.0F);
            }
          }
          y.b(null);
        }
        localObject1 = c;
        if (localObject1 != null) {
          n.y((View)localObject1);
        }
      }
    }
    else if (t)
    {
      t = false;
      localObject1 = u;
      if (localObject1 != null) {
        ((g)localObject1).a();
      }
      if ((o == 0) && ((v) || (paramBoolean)))
      {
        d.setAlpha(1.0F);
        d.setTransitioning(true);
        localObject1 = new g();
        f1 = -d.getHeight();
        f2 = f1;
        if (paramBoolean)
        {
          localObject2 = new int[2];
          Object tmp506_504 = localObject2;
          tmp506_504[0] = 0;
          Object tmp510_506 = tmp506_504;
          tmp510_506[1] = 0;
          tmp510_506;
          d.getLocationInWindow((int[])localObject2);
          f2 = f1 - localObject2[1];
        }
        localObject2 = n.a(d);
        ((s)localObject2).b(f2);
        ((s)localObject2).a(z);
        if (!e) {
          a.add(localObject2);
        }
        if (p)
        {
          localObject2 = g;
          if (localObject2 != null)
          {
            localObject2 = n.a((View)localObject2);
            ((s)localObject2).b(f2);
            if (!e) {
              a.add(localObject2);
            }
          }
        }
        localObject2 = A;
        if (!e) {
          c = ((Interpolator)localObject2);
        }
        if (!e) {
          b = 250L;
        }
        localObject2 = x;
        if (!e) {
          d = ((t)localObject2);
        }
        u = ((g)localObject1);
        ((g)localObject1).b();
      }
      else
      {
        x.b(null);
      }
    }
  }
  
  public class a
    extends u
  {
    public a() {}
    
    public void b(View paramView)
    {
      paramView = w.this;
      if (p)
      {
        paramView = g;
        if (paramView != null)
        {
          paramView.setTranslationY(0.0F);
          d.setTranslationY(0.0F);
        }
      }
      d.setVisibility(8);
      d.setTransitioning(false);
      paramView = w.this;
      u = null;
      a.a locala = k;
      if (locala != null)
      {
        locala.a(j);
        j = null;
        k = null;
      }
      paramView = c;
      if (paramView != null) {
        n.y(paramView);
      }
    }
  }
  
  public class b
    extends u
  {
    public b() {}
    
    public void b(View paramView)
    {
      paramView = w.this;
      u = null;
      d.requestLayout();
    }
  }
  
  public class c
    implements v
  {
    public c() {}
  }
  
  public class d
    extends d.b.d.a
    implements h.a
  {
    public final h A;
    public a.a B;
    public WeakReference<View> C;
    public final Context z;
    
    public d(Context paramContext, a.a parama)
    {
      z = paramContext;
      B = parama;
      this$1 = new h(paramContext);
      l = 1;
      A = w.this;
      e = this;
    }
    
    public void a()
    {
      Object localObject = w.this;
      if (i != this) {
        return;
      }
      boolean bool1 = q;
      boolean bool2 = r;
      int i = 1;
      if ((bool1) || (bool2)) {
        i = 0;
      }
      if (i == 0)
      {
        localObject = w.this;
        j = this;
        k = B;
      }
      else
      {
        B.a(this);
      }
      B = null;
      e(false);
      localObject = f;
      if (H == null) {
        ((ActionBarContextView)localObject).b();
      }
      e.h().sendAccessibilityEvent(32);
      localObject = w.this;
      c.setHideOnContentScrollEnabled(w);
      w.this.i = null;
    }
    
    public void a(int paramInt)
    {
      String str = a.getResources().getString(paramInt);
      f.setSubtitle(str);
    }
    
    public void a(View paramView)
    {
      f.setCustomView(paramView);
      C = new WeakReference(paramView);
    }
    
    public void a(h paramh)
    {
      if (B == null) {
        return;
      }
      g();
      paramh = f.A;
      if (paramh != null) {
        paramh.g();
      }
    }
    
    public void a(CharSequence paramCharSequence)
    {
      f.setSubtitle(paramCharSequence);
    }
    
    public void a(boolean paramBoolean)
    {
      y = paramBoolean;
      f.setTitleOptional(paramBoolean);
    }
    
    public boolean a(h paramh, MenuItem paramMenuItem)
    {
      paramh = B;
      if (paramh != null) {
        return paramh.a(this, paramMenuItem);
      }
      return false;
    }
    
    public View b()
    {
      Object localObject = C;
      if (localObject != null) {
        localObject = (View)((WeakReference)localObject).get();
      } else {
        localObject = null;
      }
      return (View)localObject;
    }
    
    public void b(int paramInt)
    {
      String str = a.getResources().getString(paramInt);
      f.setTitle(str);
    }
    
    public void b(CharSequence paramCharSequence)
    {
      f.setTitle(paramCharSequence);
    }
    
    public Menu c()
    {
      return A;
    }
    
    public MenuInflater d()
    {
      return new f(z);
    }
    
    public CharSequence e()
    {
      return f.getSubtitle();
    }
    
    public CharSequence f()
    {
      return f.getTitle();
    }
    
    public void g()
    {
      if (i != this) {
        return;
      }
      A.j();
      try
      {
        B.a(this, A);
        return;
      }
      finally
      {
        A.i();
      }
    }
    
    public boolean h()
    {
      return f.O;
    }
  }
}

/* Location:
 * Qualified Name:     d.b.a.w
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */