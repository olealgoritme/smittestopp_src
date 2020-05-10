package d.b.a;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.media.AudioManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.appcompat.R.attr;
import androidx.appcompat.R.color;
import androidx.appcompat.R.id;
import androidx.appcompat.R.layout;
import androidx.appcompat.R.style;
import androidx.appcompat.R.styleable;
import androidx.appcompat.app.AppCompatViewInflater;
import androidx.appcompat.view.menu.ExpandedMenuView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;

import java.lang.reflect.Field;
import java.util.Map;

import d.b.d.c;
import d.b.d.i.e;
import d.b.d.i.g;
import d.b.e.c0;
import d.b.e.d1;
import d.b.e.x0;
import d.i.i.c.a;
import d.o.g.b;
import d.o.m;

public class k
  extends j
  implements g.a, LayoutInflater.Factory2
{
  public static final boolean A0;
  public static final Map<Class<?>, Integer> w0 = new d.f.a();
  public static final boolean x0;
  public static final int[] y0;
  public static boolean z0;
  public final Context A;
  public Window B;
  public k.e C;
  public final i D;
  public a E;
  public MenuInflater F;
  public CharSequence G;
  public c0 H;
  public k.c I;
  public k.k J;
  public d.b.d.a K;
  public ActionBarContextView L;
  public PopupWindow M;
  public Runnable N;
  public d.i.i.s O;
  public boolean P;
  public boolean Q;
  public ViewGroup R;
  public TextView S;
  public View T;
  public boolean U;
  public boolean V;
  public boolean W;
  public boolean X;
  public boolean Y;
  public boolean Z;
  public boolean a0;
  public boolean b0;
  public k.j[] c0;
  public k.j d0;
  public boolean e0;
  public boolean f0;
  public boolean g0;
  public boolean h0;
  public boolean i0;
  public int j0;
  public int k0;
  public boolean l0;
  public boolean m0;
  public k.g n0;
  public k.g o0;
  public boolean p0;
  public int q0;
  public final Runnable r0;
  public boolean s0;
  public Rect t0;
  public Rect u0;
  public AppCompatViewInflater v0;
  public final Object z;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool = false;
    x0 = false;
    y0 = new int[] { 16842836 };
    if (i <= 25) {
      bool = true;
    }
    A0 = bool;
    if ((x0) && (!z0))
    {
      Thread.setDefaultUncaughtExceptionHandler(new k.a(Thread.getDefaultUncaughtExceptionHandler()));
      z0 = true;
    }
  }
  
  public k(Context paramContext, Window paramWindow, i parami, Object paramObject)
  {
    Object localObject = null;
    O = null;
    P = true;
    j0 = -100;
    r0 = new k.b(this);
    A = paramContext;
    D = parami;
    z = paramObject;
    if ((j0 == -100) && ((paramObject instanceof Dialog)))
    {
      for (;;)
      {
        parami = (i)localObject;
        if (paramContext == null) {
          break;
        }
        if ((paramContext instanceof h))
        {
          parami = (h)paramContext;
          break;
        }
        parami = (i)localObject;
        if (!(paramContext instanceof ContextWrapper)) {
          break;
        }
        paramContext = ((ContextWrapper)paramContext).getBaseContext();
      }
      if (parami != null) {
        j0 = jj0;
      }
    }
    if (j0 == -100)
    {
      paramContext = (Integer)w0.get(z.getClass());
      if (paramContext != null)
      {
        j0 = paramContext.intValue();
        w0.remove(z.getClass());
      }
    }
    if (paramWindow != null) {
      a(paramWindow);
    }
    d.b.e.j.b();
  }
  
  public k.j a(Menu paramMenu)
  {
    k.j[] arrayOfj = c0;
    int i = 0;
    int j;
    if (arrayOfj != null) {
      j = arrayOfj.length;
    } else {
      j = 0;
    }
    while (i < j)
    {
      k.j localj = arrayOfj[i];
      if ((localj != null) && (j == paramMenu)) {
        return localj;
      }
      i++;
    }
    return null;
  }
  
  public void a()
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(A);
    if (localLayoutInflater.getFactory() == null) {
      localLayoutInflater.setFactory2(this);
    } else if (!(localLayoutInflater.getFactory2() instanceof k)) {
      Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
    }
  }
  
  public void a(int paramInt, k.j paramj, Menu paramMenu)
  {
    Object localObject1 = paramj;
    Object localObject2 = paramMenu;
    if (paramMenu == null)
    {
      k.j localj = paramj;
      if (paramj == null)
      {
        localj = paramj;
        if (paramInt >= 0)
        {
          localObject1 = c0;
          localj = paramj;
          if (paramInt < localObject1.length) {
            localj = localObject1[paramInt];
          }
        }
      }
      localObject1 = localj;
      localObject2 = paramMenu;
      if (localj != null)
      {
        localObject2 = j;
        localObject1 = localj;
      }
    }
    if ((localObject1 != null) && (!o)) {
      return;
    }
    if (!i0) {
      C.x.onPanelClosed(paramInt, (Menu)localObject2);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    f0 = true;
    a(false);
    g();
    Object localObject = z;
    if ((localObject instanceof Activity))
    {
      paramBundle = null;
      try
      {
        localObject = (Activity)localObject;
        try
        {
          localObject = r.b((Context)localObject, ((Activity)localObject).getComponentName());
          paramBundle = (Bundle)localObject;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          localObject = new java/lang/IllegalArgumentException;
          ((IllegalArgumentException)localObject).<init>(localNameNotFoundException);
          throw ((Throwable)localObject);
        }
        g0 = true;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        if (paramBundle != null)
        {
          paramBundle = E;
          if (paramBundle == null) {
            s0 = true;
          } else {
            paramBundle.b(true);
          }
        }
      }
    }
  }
  
  public void a(View paramView)
  {
    f();
    ViewGroup localViewGroup = (ViewGroup)R.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView);
    C.x.onContentChanged();
  }
  
  public void a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    f();
    ((ViewGroup)R.findViewById(16908290)).addView(paramView, paramLayoutParams);
    C.x.onContentChanged();
  }
  
  public final void a(Window paramWindow)
  {
    if (B == null)
    {
      Object localObject = paramWindow.getCallback();
      if (!(localObject instanceof k.e))
      {
        localObject = new k.e(this, (Window.Callback)localObject);
        C = ((k.e)localObject);
        paramWindow.setCallback((Window.Callback)localObject);
        localObject = x0.a(A, null, y0);
        Drawable localDrawable = ((x0)localObject).c(0);
        if (localDrawable != null) {
          paramWindow.setBackgroundDrawable(localDrawable);
        }
        b.recycle();
        B = paramWindow;
        return;
      }
      throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }
    throw new IllegalStateException("AppCompat has already installed itself into the Window");
  }
  
  public final void a(k.j paramj, KeyEvent paramKeyEvent)
  {
    if ((!o) && (!i0))
    {
      if (a == 0)
      {
        if ((A.getResources().getConfiguration().screenLayout & 0xF) == 4) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          return;
        }
      }
      Object localObject = j();
      if ((localObject != null) && (!((Window.Callback)localObject).onMenuOpened(a, j)))
      {
        a(paramj, true);
        return;
      }
      WindowManager localWindowManager = (WindowManager)A.getSystemService("window");
      if (localWindowManager == null) {
        return;
      }
      if (!b(paramj, paramKeyEvent)) {
        return;
      }
      if ((g != null) && (!q))
      {
        paramKeyEvent = i;
        if (paramKeyEvent != null)
        {
          paramKeyEvent = paramKeyEvent.getLayoutParams();
          if ((paramKeyEvent != null) && (width == -1))
          {
            i = -1;
            break label766;
          }
        }
      }
      else
      {
        paramKeyEvent = g;
        if (paramKeyEvent == null)
        {
          localObject = h();
          TypedValue localTypedValue = new TypedValue();
          paramKeyEvent = ((Context)localObject).getResources().newTheme();
          paramKeyEvent.setTo(((Context)localObject).getTheme());
          paramKeyEvent.resolveAttribute(R.attr.actionBarPopupTheme, localTypedValue, true);
          i = resourceId;
          if (i != 0) {
            paramKeyEvent.applyStyle(i, true);
          }
          paramKeyEvent.resolveAttribute(R.attr.panelMenuListTheme, localTypedValue, true);
          i = resourceId;
          if (i != 0) {
            paramKeyEvent.applyStyle(i, true);
          } else {
            paramKeyEvent.applyStyle(R.style.Theme_AppCompat_CompactMenu, true);
          }
          localObject = new c((Context)localObject, 0);
          ((c)localObject).getTheme().setTo(paramKeyEvent);
          l = ((Context)localObject);
          paramKeyEvent = ((Context)localObject).obtainStyledAttributes(R.styleable.AppCompatTheme);
          b = paramKeyEvent.getResourceId(R.styleable.AppCompatTheme_panelBackground, 0);
          f = paramKeyEvent.getResourceId(R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
          paramKeyEvent.recycle();
          g = new k.i(this, l);
          c = 81;
        }
        else if ((q) && (paramKeyEvent.getChildCount() > 0))
        {
          g.removeAllViews();
        }
        paramKeyEvent = i;
        if (paramKeyEvent != null)
        {
          h = paramKeyEvent;
        }
        else
        {
          if (j == null) {
            break label607;
          }
          if (J == null) {
            J = new k.k(this);
          }
          localObject = J;
          if (j == null)
          {
            paramKeyEvent = null;
          }
          else
          {
            if (k == null)
            {
              paramKeyEvent = new e(l, R.layout.abc_list_menu_item_layout);
              k = paramKeyEvent;
              E = ((m.a)localObject);
              localObject = j;
              ((g)localObject).a(paramKeyEvent, a);
            }
            localObject = k;
            paramKeyEvent = g;
            if (A == null)
            {
              A = ((ExpandedMenuView)y.inflate(R.layout.abc_expanded_menu_layout, paramKeyEvent, false));
              if (F == null) {
                F = new e.a((e)localObject);
              }
              A.setAdapter(F);
              A.setOnItemClickListener((AdapterView.OnItemClickListener)localObject);
            }
            paramKeyEvent = A;
          }
          h = paramKeyEvent;
          if (paramKeyEvent == null) {
            break label607;
          }
        }
        i = 1;
        break label609;
        label607:
        i = 0;
        label609:
        if (i == 0) {
          return;
        }
        if ((h != null) && ((i != null) || (k.a().getCount() > 0))) {
          i = 1;
        } else {
          i = 0;
        }
        if (i == 0) {
          return;
        }
        localObject = h.getLayoutParams();
        paramKeyEvent = (KeyEvent)localObject;
        if (localObject == null) {
          paramKeyEvent = new ViewGroup.LayoutParams(-2, -2);
        }
        i = b;
        g.setBackgroundResource(i);
        localObject = h.getParent();
        if ((localObject instanceof ViewGroup)) {
          ((ViewGroup)localObject).removeView(h);
        }
        g.addView(h, paramKeyEvent);
        if (!h.hasFocus()) {
          h.requestFocus();
        }
      }
      int i = -2;
      label766:
      n = false;
      paramKeyEvent = new WindowManager.LayoutParams(i, -2, d, e, 1002, 8519680, -3);
      gravity = c;
      windowAnimations = f;
      localWindowManager.addView(g, paramKeyEvent);
      o = true;
    }
  }
  
  public void a(k.j paramj, boolean paramBoolean)
  {
    Object localObject;
    if ((paramBoolean) && (a == 0))
    {
      localObject = H;
      if ((localObject != null) && (((c0)localObject).b()))
      {
        b(j);
        return;
      }
    }
    WindowManager localWindowManager = (WindowManager)A.getSystemService("window");
    if ((localWindowManager != null) && (o))
    {
      localObject = g;
      if (localObject != null)
      {
        localWindowManager.removeView((View)localObject);
        if (paramBoolean) {
          a(a, paramj, null);
        }
      }
    }
    m = false;
    n = false;
    o = false;
    h = null;
    q = true;
    if (d0 == paramj) {
      d0 = null;
    }
  }
  
  public void a(g paramg)
  {
    paramg = H;
    if ((paramg != null) && (paramg.f()) && ((!ViewConfiguration.get(A).hasPermanentMenuKey()) || (H.a())))
    {
      Window.Callback localCallback = j();
      if (H.b())
      {
        H.c();
        if (!i0) {
          localCallback.onPanelClosed(108, d0j);
        }
      }
      else if ((localCallback != null) && (!i0))
      {
        if ((p0) && ((0x1 & q0) != 0))
        {
          B.getDecorView().removeCallbacks(r0);
          r0.run();
        }
        paramg = d(0);
        g localg = j;
        if ((localg != null) && (!r) && (localCallback.onPreparePanel(0, i, localg)))
        {
          localCallback.onMenuOpened(108, j);
          H.d();
        }
      }
    }
    else
    {
      paramg = d(0);
      q = true;
      a(paramg, false);
      a(paramg, null);
    }
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    G = paramCharSequence;
    Object localObject = H;
    if (localObject != null)
    {
      ((c0)localObject).setWindowTitle(paramCharSequence);
    }
    else
    {
      localObject = E;
      if (localObject != null)
      {
        ((a)localObject).b(paramCharSequence);
      }
      else
      {
        localObject = S;
        if (localObject != null) {
          ((TextView)localObject).setText(paramCharSequence);
        }
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    int i;
    if (paramInt == 8)
    {
      Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
      i = 108;
    }
    else
    {
      i = paramInt;
      if (paramInt == 9)
      {
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        i = 109;
      }
    }
    if ((a0) && (i == 108)) {
      return false;
    }
    if ((W) && (i == 1)) {
      W = false;
    }
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 5)
        {
          if (i != 10)
          {
            if (i != 108)
            {
              if (i != 109) {
                return B.requestFeature(i);
              }
              m();
              X = true;
              return true;
            }
            m();
            W = true;
            return true;
          }
          m();
          Y = true;
          return true;
        }
        m();
        V = true;
        return true;
      }
      m();
      U = true;
      return true;
    }
    m();
    a0 = true;
    return true;
  }
  
  public boolean a(KeyEvent paramKeyEvent)
  {
    Object localObject = z;
    boolean bool1 = localObject instanceof c.a;
    boolean bool2 = true;
    boolean bool3 = true;
    if ((bool1) || ((localObject instanceof q)))
    {
      localObject = B.getDecorView();
      if ((localObject != null) && (d.i.i.n.b((View)localObject, paramKeyEvent))) {
        return true;
      }
    }
    if ((paramKeyEvent.getKeyCode() == 82) && (C.x.dispatchKeyEvent(paramKeyEvent))) {
      return true;
    }
    int i = paramKeyEvent.getKeyCode();
    int j;
    if (paramKeyEvent.getAction() == 0) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0) {
      if (i != 4)
      {
        if (i == 82)
        {
          bool1 = bool2;
          if (paramKeyEvent.getRepeatCount() != 0) {
            return bool1;
          }
          localObject = d(0);
          bool1 = bool2;
          if (o) {
            return bool1;
          }
          b((k.j)localObject, paramKeyEvent);
          return bool2;
        }
      }
      else
      {
        if ((paramKeyEvent.getFlags() & 0x80) == 0) {
          bool3 = false;
        }
        e0 = bool3;
      }
    }
    label390:
    label404:
    label546:
    do
    {
      do
      {
        return false;
        if (i == 4) {
          break;
        }
      } while (i != 82);
      if (K != null)
      {
        bool1 = bool2;
        break;
      }
      k.j localj = d(0);
      localObject = H;
      if ((localObject != null) && (((c0)localObject).f()) && (!ViewConfiguration.get(A).hasPermanentMenuKey()))
      {
        if (!H.b())
        {
          if ((!i0) && (b(localj, paramKeyEvent)))
          {
            bool3 = H.d();
            break label404;
          }
        }
        else
        {
          bool3 = H.c();
          break label404;
        }
      }
      else
      {
        if ((o) || (n)) {
          break label390;
        }
        if (m)
        {
          if (r)
          {
            m = false;
            bool3 = b(localj, paramKeyEvent);
          }
          else
          {
            bool3 = true;
          }
          if (bool3)
          {
            a(localj, paramKeyEvent);
            bool3 = true;
            break label404;
          }
        }
      }
      bool3 = false;
      break label404;
      bool3 = o;
      a(localj, true);
      bool1 = bool2;
      if (!bool3) {
        break;
      }
      paramKeyEvent = (AudioManager)A.getSystemService("audio");
      if (paramKeyEvent != null)
      {
        paramKeyEvent.playSoundEffect(0);
        bool1 = bool2;
        break;
      }
      Log.w("AppCompatDelegate", "Couldn't get audio manager");
      bool1 = bool2;
      break;
      bool3 = e0;
      e0 = false;
      paramKeyEvent = d(0);
      if ((paramKeyEvent != null) && (o))
      {
        bool1 = bool2;
        if (bool3) {
          break;
        }
        a(paramKeyEvent, true);
        bool1 = bool2;
        break;
      }
      paramKeyEvent = K;
      if (paramKeyEvent != null)
      {
        paramKeyEvent.a();
      }
      else
      {
        k();
        paramKeyEvent = E;
        if ((paramKeyEvent == null) || (!paramKeyEvent.b())) {
          break label546;
        }
      }
      j = 1;
      continue;
      j = 0;
    } while (j == 0);
    bool1 = bool2;
    return bool1;
  }
  
  public final boolean a(k.j paramj, int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    boolean bool1 = paramKeyEvent.isSystem();
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    if (!m)
    {
      bool1 = bool2;
      if (!b(paramj, paramKeyEvent)) {}
    }
    else
    {
      g localg = j;
      bool1 = bool2;
      if (localg != null) {
        bool1 = localg.performShortcut(paramInt1, paramKeyEvent, paramInt2);
      }
    }
    if ((bool1) && ((paramInt2 & 0x1) == 0) && (H == null)) {
      a(paramj, true);
    }
    return bool1;
  }
  
  public boolean a(g paramg, MenuItem paramMenuItem)
  {
    Window.Callback localCallback = j();
    if ((localCallback != null) && (!i0))
    {
      paramg = a(paramg.c());
      if (paramg != null) {
        return localCallback.onMenuItemSelected(a, paramMenuItem);
      }
    }
    return false;
  }
  
  public final boolean a(boolean paramBoolean)
  {
    boolean bool1 = i0;
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    int i = j0;
    if (i == -100) {
      i = -100;
    }
    int j = -1;
    boolean bool3 = true;
    int k = j;
    if (i != -100)
    {
      if (i != -1) {
        if (i != 0)
        {
          if ((i != 1) && (i != 2))
          {
            if (i == 3)
            {
              if (o0 == null) {
                o0 = new k.f(this, A);
              }
              k = o0.c();
              break label175;
            }
            throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
          }
        }
        else
        {
          if ((Build.VERSION.SDK_INT >= 23) && (((UiModeManager)A.getSystemService(UiModeManager.class)).getNightMode() == 0))
          {
            k = j;
            break label175;
          }
          k = i().c();
          break label175;
        }
      }
      k = i;
    }
    label175:
    j = A.getApplicationContext().getResources().getConfiguration().uiMode & 0x30;
    if (k != 1)
    {
      if (k != 2) {
        k = j;
      } else {
        k = 32;
      }
    }
    else {
      k = 16;
    }
    Object localObject1;
    boolean bool4;
    if ((!m0) && ((z instanceof Activity)))
    {
      localObject1 = A.getPackageManager();
      if (localObject1 == null) {
        bool4 = false;
      } else {
        try
        {
          Object localObject2 = new android/content/ComponentName;
          ((ComponentName)localObject2).<init>(A, z.getClass());
          localObject2 = ((PackageManager)localObject1).getActivityInfo((ComponentName)localObject2, 0);
          if ((localObject2 != null) && ((configChanges & 0x200) != 0)) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          l0 = bool1;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", localNameNotFoundException);
          l0 = false;
        }
      }
    }
    else
    {
      m0 = true;
      bool4 = l0;
    }
    if (!A0)
    {
      bool1 = bool2;
      if (k == j) {}
    }
    else
    {
      bool1 = bool2;
      if (!bool4)
      {
        bool1 = bool2;
        if (!f0)
        {
          bool1 = bool2;
          if ((z instanceof ContextThemeWrapper))
          {
            Configuration localConfiguration = new Configuration();
            uiMode = (uiMode & 0xFFFFFFCF | k);
            try
            {
              ((ContextThemeWrapper)z).applyOverrideConfiguration(localConfiguration);
              bool1 = true;
            }
            catch (IllegalStateException localIllegalStateException)
            {
              Log.e("AppCompatDelegate", "updateForNightMode. Calling applyOverrideConfiguration() failed with an exception. Will fall back to using Resources.updateConfiguration()", localIllegalStateException);
              bool1 = bool2;
            }
          }
        }
      }
    }
    j = A.getResources().getConfiguration().uiMode & 0x30;
    bool2 = bool1;
    Object localObject3;
    if (!bool1)
    {
      bool2 = bool1;
      if (j != k)
      {
        bool2 = bool1;
        if (paramBoolean)
        {
          bool2 = bool1;
          if (!bool4)
          {
            bool2 = bool1;
            if (f0)
            {
              localObject3 = z;
              bool2 = bool1;
              if ((localObject3 instanceof Activity))
              {
                d.i.a.a.d((Activity)localObject3);
                bool2 = true;
              }
            }
          }
        }
      }
    }
    Object localObject7;
    if ((!bool2) && (j != k))
    {
      localObject3 = A.getResources();
      localObject1 = new Configuration(((Resources)localObject3).getConfiguration());
      uiMode = (k | getConfigurationuiMode & 0xFFFFFFCF);
      ((Resources)localObject3).updateConfiguration((Configuration)localObject1, null);
      k = Build.VERSION.SDK_INT;
      if ((k < 26) && (k < 28))
      {
        Field localField3;
        Object localObject5;
        if (k >= 24)
        {
          if (!r.h)
          {
            try
            {
              Field localField1 = Resources.class.getDeclaredField("mResourcesImpl");
              r.g = localField1;
              localField1.setAccessible(true);
            }
            catch (NoSuchFieldException localNoSuchFieldException1)
            {
              Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", localNoSuchFieldException1);
            }
            r.h = true;
          }
          Field localField2 = r.g;
          if (localField2 != null)
          {
            Object localObject4;
            try
            {
              localObject3 = localField2.get(localObject3);
            }
            catch (IllegalAccessException localIllegalAccessException1)
            {
              Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", localIllegalAccessException1);
              localObject4 = null;
            }
            if (localObject4 != null)
            {
              if (!r.b)
              {
                try
                {
                  localField2 = localObject4.getClass().getDeclaredField("mDrawableCache");
                  r.a = localField2;
                  localField2.setAccessible(true);
                }
                catch (NoSuchFieldException localNoSuchFieldException2)
                {
                  Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", localNoSuchFieldException2);
                }
                r.b = true;
              }
              localField3 = r.a;
              if (localField3 != null) {
                try
                {
                  localObject4 = localField3.get(localObject4);
                }
                catch (IllegalAccessException localIllegalAccessException2)
                {
                  Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", localIllegalAccessException2);
                }
              } else {
                localObject5 = null;
              }
              if (localObject5 != null) {
                r.b(localObject5);
              }
            }
          }
        }
        else
        {
          Field localField4;
          Object localObject6;
          if (k >= 23)
          {
            if (!r.b)
            {
              try
              {
                localField3 = Resources.class.getDeclaredField("mDrawableCache");
                r.a = localField3;
                localField3.setAccessible(true);
              }
              catch (NoSuchFieldException localNoSuchFieldException3)
              {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", localNoSuchFieldException3);
              }
              r.b = true;
            }
            localField4 = r.a;
            if (localField4 != null) {
              try
              {
                localObject5 = localField4.get(localObject5);
              }
              catch (IllegalAccessException localIllegalAccessException3)
              {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", localIllegalAccessException3);
              }
            } else {
              localObject6 = null;
            }
            if (localObject6 != null) {
              r.b(localObject6);
            }
          }
          else
          {
            if (!r.b)
            {
              try
              {
                localField4 = Resources.class.getDeclaredField("mDrawableCache");
                r.a = localField4;
                localField4.setAccessible(true);
              }
              catch (NoSuchFieldException localNoSuchFieldException4)
              {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", localNoSuchFieldException4);
              }
              r.b = true;
            }
            Field localField5 = r.a;
            if (localField5 != null)
            {
              try
              {
                localObject6 = (Map)localField5.get(localObject6);
              }
              catch (IllegalAccessException localIllegalAccessException4)
              {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", localIllegalAccessException4);
                localObject7 = null;
              }
              if (localObject7 != null) {
                ((Map)localObject7).clear();
              }
            }
          }
        }
      }
      k = k0;
      if (k != 0)
      {
        A.setTheme(k);
        if (Build.VERSION.SDK_INT >= 23) {
          A.getTheme().applyStyle(k0, true);
        }
      }
      paramBoolean = bool3;
      if (bool4)
      {
        localObject7 = z;
        paramBoolean = bool3;
        if ((localObject7 instanceof Activity))
        {
          localObject7 = (Activity)localObject7;
          if ((localObject7 instanceof d.o.l))
          {
            paramBoolean = bool3;
            if (getLifecycleb.isAtLeast(g.b.STARTED))
            {
              ((Activity)localObject7).onConfigurationChanged((Configuration)localObject1);
              paramBoolean = bool3;
            }
          }
          else
          {
            paramBoolean = bool3;
            if (h0)
            {
              ((Activity)localObject7).onConfigurationChanged((Configuration)localObject1);
              paramBoolean = bool3;
            }
          }
        }
      }
    }
    else
    {
      paramBoolean = bool2;
    }
    if (paramBoolean)
    {
      localObject7 = z;
      if (((localObject7 instanceof h)) && ((h)localObject7 == null)) {
        throw null;
      }
    }
    if (i == 0)
    {
      i().e();
    }
    else
    {
      localObject7 = n0;
      if (localObject7 != null) {
        ((k.g)localObject7).a();
      }
    }
    if (i == 3)
    {
      if (o0 == null) {
        o0 = new k.f(this, A);
      }
      o0.e();
    }
    else
    {
      localObject7 = o0;
      if (localObject7 != null) {
        ((k.g)localObject7).a();
      }
    }
    return paramBoolean;
  }
  
  public void b()
  {
    k();
    a locala = E;
    if ((locala != null) && (locala.e())) {
      return;
    }
    e(0);
  }
  
  public void b(int paramInt)
  {
    f();
    ViewGroup localViewGroup = (ViewGroup)R.findViewById(16908290);
    localViewGroup.removeAllViews();
    LayoutInflater.from(A).inflate(paramInt, localViewGroup);
    C.x.onContentChanged();
  }
  
  public void b(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    f();
    ViewGroup localViewGroup = (ViewGroup)R.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView, paramLayoutParams);
    C.x.onContentChanged();
  }
  
  public void b(g paramg)
  {
    if (b0) {
      return;
    }
    b0 = true;
    H.g();
    Window.Callback localCallback = j();
    if ((localCallback != null) && (!i0)) {
      localCallback.onPanelClosed(108, paramg);
    }
    b0 = false;
  }
  
  public final boolean b(k.j paramj, KeyEvent paramKeyEvent)
  {
    if (i0) {
      return false;
    }
    if (m) {
      return true;
    }
    Object localObject1 = d0;
    if ((localObject1 != null) && (localObject1 != paramj)) {
      a((k.j)localObject1, false);
    }
    Window.Callback localCallback = j();
    if (localCallback != null) {
      i = localCallback.onCreatePanelView(a);
    }
    int i = a;
    if ((i != 0) && (i != 108)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      localObject1 = H;
      if (localObject1 != null) {
        ((c0)localObject1).e();
      }
    }
    if ((i == null) && ((i == 0) || (!(E instanceof s))))
    {
      if ((j == null) || (r))
      {
        if (j == null)
        {
          Context localContext = A;
          int j = a;
          if (j != 0)
          {
            localObject1 = localContext;
            if (j != 108) {}
          }
          else
          {
            localObject1 = localContext;
            if (H != null)
            {
              TypedValue localTypedValue = new TypedValue();
              Resources.Theme localTheme = localContext.getTheme();
              localTheme.resolveAttribute(R.attr.actionBarTheme, localTypedValue, true);
              if (resourceId != 0)
              {
                localObject1 = localContext.getResources().newTheme();
                ((Resources.Theme)localObject1).setTo(localTheme);
                ((Resources.Theme)localObject1).applyStyle(resourceId, true);
                ((Resources.Theme)localObject1).resolveAttribute(R.attr.actionBarWidgetTheme, localTypedValue, true);
              }
              else
              {
                localTheme.resolveAttribute(R.attr.actionBarWidgetTheme, localTypedValue, true);
                localObject1 = null;
              }
              Object localObject2 = localObject1;
              if (resourceId != 0)
              {
                localObject2 = localObject1;
                if (localObject1 == null)
                {
                  localObject2 = localContext.getResources().newTheme();
                  ((Resources.Theme)localObject2).setTo(localTheme);
                }
                ((Resources.Theme)localObject2).applyStyle(resourceId, true);
              }
              localObject1 = localContext;
              if (localObject2 != null)
              {
                localObject1 = new c(localContext, 0);
                ((c)localObject1).getTheme().setTo((Resources.Theme)localObject2);
              }
            }
          }
          localObject1 = new g((Context)localObject1);
          e = this;
          paramj.a((g)localObject1);
          if (j == null) {
            return false;
          }
        }
        if ((i != 0) && (H != null))
        {
          if (I == null) {
            I = new k.c(this);
          }
          H.a(j, I);
        }
        j.j();
        if (!localCallback.onCreatePanelMenu(a, j))
        {
          paramj.a(null);
          if (i != 0)
          {
            paramj = H;
            if (paramj != null) {
              paramj.a(null, I);
            }
          }
          return false;
        }
        r = false;
      }
      j.j();
      localObject1 = s;
      if (localObject1 != null)
      {
        j.a((Bundle)localObject1);
        s = null;
      }
      if (!localCallback.onPreparePanel(0, i, j))
      {
        if (i != 0)
        {
          paramKeyEvent = H;
          if (paramKeyEvent != null) {
            paramKeyEvent.a(null, I);
          }
        }
        j.i();
        return false;
      }
      if (paramKeyEvent != null) {
        i = paramKeyEvent.getDeviceId();
      } else {
        i = -1;
      }
      boolean bool;
      if (KeyCharacterMap.load(i).getKeyboardType() != 1) {
        bool = true;
      } else {
        bool = false;
      }
      p = bool;
      j.setQwertyMode(bool);
      j.i();
    }
    m = true;
    n = false;
    d0 = paramj;
    return true;
  }
  
  public void c()
  {
    h0 = false;
    j.b(this);
    k();
    Object localObject = E;
    if (localObject != null) {
      ((a)localObject).d(false);
    }
    if ((z instanceof Dialog))
    {
      localObject = n0;
      if (localObject != null) {
        ((k.g)localObject).a();
      }
      localObject = o0;
      if (localObject != null) {
        ((k.g)localObject).a();
      }
    }
  }
  
  public void c(int paramInt)
  {
    k.j localj = d(paramInt);
    Object localObject;
    if (j != null)
    {
      localObject = new Bundle();
      j.b((Bundle)localObject);
      if (((Bundle)localObject).size() > 0) {
        s = ((Bundle)localObject);
      }
      j.j();
      j.clear();
    }
    r = true;
    q = true;
    if (((paramInt == 108) || (paramInt == 0)) && (H != null))
    {
      localObject = d(0);
      if (localObject != null)
      {
        m = false;
        b((k.j)localObject, null);
      }
    }
  }
  
  public k.j d(int paramInt)
  {
    Object localObject1 = c0;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (localObject1.length > paramInt) {}
    }
    else
    {
      localObject2 = new k.j[paramInt + 1];
      if (localObject1 != null) {
        System.arraycopy(localObject1, 0, localObject2, 0, localObject1.length);
      }
      c0 = ((k.j[])localObject2);
    }
    Object localObject3 = localObject2[paramInt];
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      localObject1 = new k.j(paramInt);
      localObject2[paramInt] = localObject1;
    }
    return (k.j)localObject1;
  }
  
  public boolean d()
  {
    return a(true);
  }
  
  public void e()
  {
    d.i.i.s locals = O;
    if (locals != null) {
      locals.a();
    }
  }
  
  public final void e(int paramInt)
  {
    q0 = (1 << paramInt | q0);
    if (!p0)
    {
      d.i.i.n.a(B.getDecorView(), r0);
      p0 = true;
    }
  }
  
  public int f(int paramInt)
  {
    Object localObject1 = L;
    int i = 0;
    int j;
    int n;
    if ((localObject1 != null) && ((((ViewGroup)localObject1).getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      localObject1 = (ViewGroup.MarginLayoutParams)L.getLayoutParams();
      boolean bool = L.isShown();
      j = 1;
      int k = 1;
      int m;
      if (bool)
      {
        if (t0 == null)
        {
          t0 = new Rect();
          u0 = new Rect();
        }
        Rect localRect = t0;
        Object localObject2 = u0;
        localRect.set(0, paramInt, 0, 0);
        d1.a(R, localRect, (Rect)localObject2);
        if (top == 0) {
          m = paramInt;
        } else {
          m = 0;
        }
        if (topMargin != m)
        {
          topMargin = paramInt;
          localObject2 = T;
          if (localObject2 == null)
          {
            localObject2 = new View(A);
            T = ((View)localObject2);
            ((View)localObject2).setBackgroundColor(A.getResources().getColor(R.color.abc_input_method_navigation_guard));
            R.addView(T, -1, new ViewGroup.LayoutParams(-1, paramInt));
          }
          else
          {
            localObject2 = ((View)localObject2).getLayoutParams();
            if (height != paramInt)
            {
              height = paramInt;
              T.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            }
          }
          m = 1;
        }
        else
        {
          m = 0;
        }
        if (T == null) {
          k = 0;
        }
        j = paramInt;
        if (!Y)
        {
          j = paramInt;
          if (k != 0) {
            j = 0;
          }
        }
        paramInt = m;
        m = k;
        k = paramInt;
        paramInt = j;
      }
      else if (topMargin != 0)
      {
        topMargin = 0;
        m = 0;
        k = j;
      }
      else
      {
        m = 0;
        k = 0;
      }
      n = m;
      j = paramInt;
      if (k != 0)
      {
        L.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        n = m;
        j = paramInt;
      }
    }
    else
    {
      n = 0;
      j = paramInt;
    }
    localObject1 = T;
    if (localObject1 != null)
    {
      if (n != 0) {
        paramInt = i;
      } else {
        paramInt = 8;
      }
      ((View)localObject1).setVisibility(paramInt);
    }
    return j;
  }
  
  public final void f()
  {
    if (!Q)
    {
      Object localObject1 = A.obtainStyledAttributes(R.styleable.AppCompatTheme);
      if (((TypedArray)localObject1).hasValue(R.styleable.AppCompatTheme_windowActionBar))
      {
        if (((TypedArray)localObject1).getBoolean(R.styleable.AppCompatTheme_windowNoTitle, false)) {
          a(1);
        } else if (((TypedArray)localObject1).getBoolean(R.styleable.AppCompatTheme_windowActionBar, false)) {
          a(108);
        }
        if (((TypedArray)localObject1).getBoolean(R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
          a(109);
        }
        if (((TypedArray)localObject1).getBoolean(R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
          a(10);
        }
        Z = ((TypedArray)localObject1).getBoolean(R.styleable.AppCompatTheme_android_windowIsFloating, false);
        ((TypedArray)localObject1).recycle();
        g();
        B.getDecorView();
        localObject1 = LayoutInflater.from(A);
        Object localObject2;
        if (!a0)
        {
          if (Z)
          {
            localObject1 = (ViewGroup)((LayoutInflater)localObject1).inflate(R.layout.abc_dialog_title_material, null);
            X = false;
            W = false;
          }
          else if (W)
          {
            localObject1 = new TypedValue();
            A.getTheme().resolveAttribute(R.attr.actionBarTheme, (TypedValue)localObject1, true);
            if (resourceId != 0) {
              localObject1 = new c(A, resourceId);
            } else {
              localObject1 = A;
            }
            localObject2 = (ViewGroup)LayoutInflater.from((Context)localObject1).inflate(R.layout.abc_screen_toolbar, null);
            localObject1 = (c0)((ViewGroup)localObject2).findViewById(R.id.decor_content_parent);
            H = ((c0)localObject1);
            ((c0)localObject1).setWindowCallback(j());
            if (X) {
              H.a(109);
            }
            if (U) {
              H.a(2);
            }
            localObject1 = localObject2;
            if (V)
            {
              H.a(5);
              localObject1 = localObject2;
            }
          }
          else
          {
            localObject1 = null;
          }
        }
        else
        {
          if (Y) {
            localObject1 = (ViewGroup)((LayoutInflater)localObject1).inflate(R.layout.abc_screen_simple_overlay_action_mode, null);
          } else {
            localObject1 = (ViewGroup)((LayoutInflater)localObject1).inflate(R.layout.abc_screen_simple, null);
          }
          d.i.i.n.a((View)localObject1, new l(this));
        }
        if (localObject1 != null)
        {
          if (H == null) {
            S = ((TextView)((ViewGroup)localObject1).findViewById(R.id.title));
          }
          d1.b((View)localObject1);
          ContentFrameLayout localContentFrameLayout = (ContentFrameLayout)((ViewGroup)localObject1).findViewById(R.id.action_bar_activity_content);
          localObject2 = (ViewGroup)B.findViewById(16908290);
          if (localObject2 != null)
          {
            while (((ViewGroup)localObject2).getChildCount() > 0)
            {
              View localView = ((ViewGroup)localObject2).getChildAt(0);
              ((ViewGroup)localObject2).removeViewAt(0);
              localContentFrameLayout.addView(localView);
            }
            ((ViewGroup)localObject2).setId(-1);
            localContentFrameLayout.setId(16908290);
            if ((localObject2 instanceof FrameLayout)) {
              ((FrameLayout)localObject2).setForeground(null);
            }
          }
          B.setContentView((View)localObject1);
          localContentFrameLayout.setAttachListener(new n(this));
          R = ((ViewGroup)localObject1);
          localObject1 = z;
          if ((localObject1 instanceof Activity)) {
            localObject1 = ((Activity)localObject1).getTitle();
          } else {
            localObject1 = G;
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = H;
            if (localObject2 != null)
            {
              ((c0)localObject2).setWindowTitle((CharSequence)localObject1);
            }
            else
            {
              localObject2 = E;
              if (localObject2 != null)
              {
                ((a)localObject2).b((CharSequence)localObject1);
              }
              else
              {
                localObject2 = S;
                if (localObject2 != null) {
                  ((TextView)localObject2).setText((CharSequence)localObject1);
                }
              }
            }
          }
          localObject1 = (ContentFrameLayout)R.findViewById(16908290);
          localObject2 = B.getDecorView();
          int i = ((View)localObject2).getPaddingLeft();
          int j = ((View)localObject2).getPaddingTop();
          int k = ((View)localObject2).getPaddingRight();
          int m = ((View)localObject2).getPaddingBottom();
          D.set(i, j, k, m);
          if (d.i.i.n.t((View)localObject1)) {
            ((FrameLayout)localObject1).requestLayout();
          }
          localObject2 = A.obtainStyledAttributes(R.styleable.AppCompatTheme);
          ((TypedArray)localObject2).getValue(R.styleable.AppCompatTheme_windowMinWidthMajor, ((ContentFrameLayout)localObject1).getMinWidthMajor());
          ((TypedArray)localObject2).getValue(R.styleable.AppCompatTheme_windowMinWidthMinor, ((ContentFrameLayout)localObject1).getMinWidthMinor());
          if (((TypedArray)localObject2).hasValue(R.styleable.AppCompatTheme_windowFixedWidthMajor)) {
            ((TypedArray)localObject2).getValue(R.styleable.AppCompatTheme_windowFixedWidthMajor, ((ContentFrameLayout)localObject1).getFixedWidthMajor());
          }
          if (((TypedArray)localObject2).hasValue(R.styleable.AppCompatTheme_windowFixedWidthMinor)) {
            ((TypedArray)localObject2).getValue(R.styleable.AppCompatTheme_windowFixedWidthMinor, ((ContentFrameLayout)localObject1).getFixedWidthMinor());
          }
          if (((TypedArray)localObject2).hasValue(R.styleable.AppCompatTheme_windowFixedHeightMajor)) {
            ((TypedArray)localObject2).getValue(R.styleable.AppCompatTheme_windowFixedHeightMajor, ((ContentFrameLayout)localObject1).getFixedHeightMajor());
          }
          if (((TypedArray)localObject2).hasValue(R.styleable.AppCompatTheme_windowFixedHeightMinor)) {
            ((TypedArray)localObject2).getValue(R.styleable.AppCompatTheme_windowFixedHeightMinor, ((ContentFrameLayout)localObject1).getFixedHeightMinor());
          }
          ((TypedArray)localObject2).recycle();
          ((FrameLayout)localObject1).requestLayout();
          Q = true;
          localObject1 = d(0);
          if ((!i0) && ((localObject1 == null) || (j == null))) {
            e(108);
          }
        }
        else
        {
          localObject1 = e.a.a.a.a.a("AppCompat does not support the current theme features: { windowActionBar: ");
          ((StringBuilder)localObject1).append(W);
          ((StringBuilder)localObject1).append(", windowActionBarOverlay: ");
          ((StringBuilder)localObject1).append(X);
          ((StringBuilder)localObject1).append(", android:windowIsFloating: ");
          ((StringBuilder)localObject1).append(Z);
          ((StringBuilder)localObject1).append(", windowActionModeOverlay: ");
          ((StringBuilder)localObject1).append(Y);
          ((StringBuilder)localObject1).append(", windowNoTitle: ");
          ((StringBuilder)localObject1).append(a0);
          ((StringBuilder)localObject1).append(" }");
          throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
        }
      }
      else
      {
        ((TypedArray)localObject1).recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
      }
    }
  }
  
  public final void g()
  {
    if (B == null)
    {
      Object localObject = z;
      if ((localObject instanceof Activity)) {
        a(((Activity)localObject).getWindow());
      }
    }
    if (B != null) {
      return;
    }
    throw new IllegalStateException("We have not been given a Window");
  }
  
  public final Context h()
  {
    k();
    Object localObject1 = E;
    if (localObject1 != null) {
      localObject1 = ((a)localObject1).d();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = A;
    }
    return (Context)localObject2;
  }
  
  public final k.g i()
  {
    if (n0 == null)
    {
      Context localContext = A;
      if (u.d == null)
      {
        localContext = localContext.getApplicationContext();
        u.d = new u(localContext, (LocationManager)localContext.getSystemService("location"));
      }
      n0 = new k.h(this, u.d);
    }
    return n0;
  }
  
  public final Window.Callback j()
  {
    return B.getCallback();
  }
  
  public final void k()
  {
    f();
    if ((W) && (E == null))
    {
      Object localObject = z;
      if ((localObject instanceof Activity)) {
        E = new v((Activity)z, X);
      } else if ((localObject instanceof Dialog)) {
        E = new v((Dialog)z);
      }
      localObject = E;
      if (localObject != null) {
        ((a)localObject).b(s0);
      }
    }
  }
  
  public final boolean l()
  {
    if (Q)
    {
      ViewGroup localViewGroup = R;
      if ((localViewGroup != null) && (d.i.i.n.t(localViewGroup))) {
        return true;
      }
    }
    boolean bool = false;
    return bool;
  }
  
  public final void m()
  {
    if (!Q) {
      return;
    }
    throw new AndroidRuntimeException("Window feature must be requested before adding content");
  }
  
  /* Error */
  public final View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 1344	d/b/a/k:v0	Landroidx/appcompat/app/AppCompatViewInflater;
    //   4: astore 5
    //   6: iconst_0
    //   7: istore 6
    //   9: aload 5
    //   11: ifnonnull +147 -> 158
    //   14: aload_0
    //   15: getfield 175	d/b/a/k:A	Landroid/content/Context;
    //   18: getstatic 492	androidx/appcompat/R$styleable:AppCompatTheme	[I
    //   21: invokevirtual 496	android/content/Context:obtainStyledAttributes	([I)Landroid/content/res/TypedArray;
    //   24: getstatic 1347	androidx/appcompat/R$styleable:AppCompatTheme_viewInflaterClass	I
    //   27: invokevirtual 1351	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   30: astore 7
    //   32: aload 7
    //   34: ifnull +113 -> 147
    //   37: ldc_w 1353
    //   40: invokevirtual 1356	java/lang/Class:getName	()Ljava/lang/String;
    //   43: aload 7
    //   45: invokevirtual 1362	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   48: ifeq +6 -> 54
    //   51: goto +96 -> 147
    //   54: aload_0
    //   55: aload 7
    //   57: invokestatic 1366	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   60: iconst_0
    //   61: anewarray 879	java/lang/Class
    //   64: invokevirtual 1370	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   67: iconst_0
    //   68: anewarray 194	java/lang/Object
    //   71: invokevirtual 1376	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   74: checkcast 1353	androidx/appcompat/app/AppCompatViewInflater
    //   77: putfield 1344	d/b/a/k:v0	Landroidx/appcompat/app/AppCompatViewInflater;
    //   80: goto +78 -> 158
    //   83: astore 8
    //   85: new 1281	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 1377	java/lang/StringBuilder:<init>	()V
    //   92: astore 5
    //   94: aload 5
    //   96: ldc_w 1379
    //   99: invokevirtual 1289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload 5
    //   105: aload 7
    //   107: invokevirtual 1289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload 5
    //   113: ldc_w 1381
    //   116: invokevirtual 1289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: ldc -8
    //   122: aload 5
    //   124: invokevirtual 1301	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: aload 8
    //   129: invokestatic 1383	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   132: pop
    //   133: aload_0
    //   134: new 1353	androidx/appcompat/app/AppCompatViewInflater
    //   137: dup
    //   138: invokespecial 1384	androidx/appcompat/app/AppCompatViewInflater:<init>	()V
    //   141: putfield 1344	d/b/a/k:v0	Landroidx/appcompat/app/AppCompatViewInflater;
    //   144: goto +14 -> 158
    //   147: aload_0
    //   148: new 1353	androidx/appcompat/app/AppCompatViewInflater
    //   151: dup
    //   152: invokespecial 1384	androidx/appcompat/app/AppCompatViewInflater:<init>	()V
    //   155: putfield 1344	d/b/a/k:v0	Landroidx/appcompat/app/AppCompatViewInflater;
    //   158: getstatic 140	d/b/a/k:x0	Z
    //   161: ifeq +126 -> 287
    //   164: aload 4
    //   166: instanceof 1386
    //   169: ifeq +24 -> 193
    //   172: iload 6
    //   174: istore 9
    //   176: aload 4
    //   178: checkcast 1386	org/xmlpull/v1/XmlPullParser
    //   181: invokeinterface 1389 1 0
    //   186: iconst_1
    //   187: if_icmple +97 -> 284
    //   190: goto +35 -> 225
    //   193: aload_1
    //   194: checkcast 1391	android/view/ViewParent
    //   197: astore 5
    //   199: aload 5
    //   201: ifnonnull +10 -> 211
    //   204: iload 6
    //   206: istore 9
    //   208: goto +76 -> 284
    //   211: aload_0
    //   212: getfield 338	d/b/a/k:B	Landroid/view/Window;
    //   215: invokevirtual 669	android/view/Window:getDecorView	()Landroid/view/View;
    //   218: astore 7
    //   220: aload 5
    //   222: ifnonnull +9 -> 231
    //   225: iconst_1
    //   226: istore 9
    //   228: goto +56 -> 284
    //   231: iload 6
    //   233: istore 9
    //   235: aload 5
    //   237: aload 7
    //   239: if_acmpeq +45 -> 284
    //   242: iload 6
    //   244: istore 9
    //   246: aload 5
    //   248: instanceof 427
    //   251: ifeq +33 -> 284
    //   254: aload 5
    //   256: checkcast 427	android/view/View
    //   259: invokestatic 1393	d/i/i/n:s	(Landroid/view/View;)Z
    //   262: ifeq +10 -> 272
    //   265: iload 6
    //   267: istore 9
    //   269: goto +15 -> 284
    //   272: aload 5
    //   274: invokeinterface 1394 1 0
    //   279: astore 5
    //   281: goto -61 -> 220
    //   284: goto +6 -> 290
    //   287: iconst_0
    //   288: istore 9
    //   290: aload_0
    //   291: getfield 1344	d/b/a/k:v0	Landroidx/appcompat/app/AppCompatViewInflater;
    //   294: astore 5
    //   296: getstatic 140	d/b/a/k:x0	Z
    //   299: istore 6
    //   301: invokestatic 1397	d/b/e/c1:a	()Z
    //   304: pop
    //   305: aload 5
    //   307: aload_1
    //   308: aload_2
    //   309: aload_3
    //   310: aload 4
    //   312: iload 9
    //   314: iload 6
    //   316: iconst_1
    //   317: iconst_0
    //   318: invokevirtual 1401	androidx/appcompat/app/AppCompatViewInflater:createView	(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;ZZZZ)Landroid/view/View;
    //   321: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	322	0	this	k
    //   0	322	1	paramView	View
    //   0	322	2	paramString	String
    //   0	322	3	paramContext	Context
    //   0	322	4	paramAttributeSet	AttributeSet
    //   4	302	5	localObject1	Object
    //   7	308	6	bool1	boolean
    //   30	208	7	localObject2	Object
    //   83	45	8	localThrowable	Throwable
    //   174	139	9	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   54	80	83	finally
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return onCreateView(null, paramString, paramContext, paramAttributeSet);
  }
}

/* Location:
 * Qualified Name:     base.d.b.a.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */