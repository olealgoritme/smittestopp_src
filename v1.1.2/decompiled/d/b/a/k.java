package d.b.a;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.location.LocationManager;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
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
import androidx.appcompat.widget.ViewStubCompat;
import d.b.d.a.a;
import d.b.d.c;
import d.b.d.d;
import d.b.d.e.a;
import d.b.d.i.f;
import d.b.d.i.f.a;
import d.b.d.i.h.a;
import d.b.d.i.o.a;
import d.b.e.a0;
import d.b.e.b1;
import d.i.i.c.a;
import d.i.i.u;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class k
  extends j
  implements h.a, LayoutInflater.Factory2
{
  public static final int[] o0 = { 16842836 };
  public static boolean p0;
  public final Window.Callback A;
  public final i B;
  public a C;
  public MenuInflater D;
  public CharSequence E;
  public a0 F;
  public c G;
  public i H;
  public d.b.d.a I;
  public ActionBarContextView J;
  public PopupWindow K;
  public Runnable L;
  public d.i.i.s M;
  public boolean N;
  public boolean O;
  public ViewGroup P;
  public TextView Q;
  public View R;
  public boolean S;
  public boolean T;
  public boolean U;
  public boolean V;
  public boolean W;
  public boolean X;
  public boolean Y;
  public boolean Z;
  public h[] a0;
  public h b0;
  public boolean c0;
  public boolean d0;
  public int e0;
  public boolean f0;
  public f g0;
  public boolean h0;
  public int i0;
  public final Runnable j0;
  public boolean k0;
  public Rect l0;
  public Rect m0;
  public AppCompatViewInflater n0;
  public final Context x;
  public final Window y;
  public final Window.Callback z;
  
  static
  {
    if ((0 != 0) && (!p0))
    {
      Thread.setDefaultUncaughtExceptionHandler(new a(Thread.getDefaultUncaughtExceptionHandler()));
      p0 = true;
    }
  }
  
  public k(Context paramContext, Window paramWindow, i parami)
  {
    Object localObject = null;
    M = null;
    N = true;
    e0 = -100;
    j0 = new b();
    x = paramContext;
    y = paramWindow;
    B = parami;
    paramWindow = paramWindow.getCallback();
    z = paramWindow;
    if (!(paramWindow instanceof e))
    {
      paramWindow = new e(paramWindow);
      A = paramWindow;
      y.setCallback(paramWindow);
      parami = paramContext.obtainStyledAttributes(null, o0);
      paramWindow = (Window)localObject;
      if (parami.hasValue(0))
      {
        int i = parami.getResourceId(0, 0);
        paramWindow = (Window)localObject;
        if (i != 0) {
          paramWindow = d.b.e.j.a().a(paramContext, i, true);
        }
      }
      if (paramWindow != null) {
        y.setBackgroundDrawable(paramWindow);
      }
      parami.recycle();
      return;
    }
    throw new IllegalStateException("AppCompat has already installed itself into the Window");
  }
  
  public h a(Menu paramMenu)
  {
    h[] arrayOfh = a0;
    int i = 0;
    int j;
    if (arrayOfh != null) {
      j = arrayOfh.length;
    } else {
      j = 0;
    }
    while (i < j)
    {
      h localh = arrayOfh[i];
      if ((localh != null) && (j == paramMenu)) {
        return localh;
      }
      i++;
    }
    return null;
  }
  
  public void a(int paramInt, h paramh, Menu paramMenu)
  {
    Object localObject1 = paramh;
    Object localObject2 = paramMenu;
    if (paramMenu == null)
    {
      h localh = paramh;
      if (paramh == null)
      {
        localh = paramh;
        if (paramInt >= 0)
        {
          localObject1 = a0;
          localh = paramh;
          if (paramInt < localObject1.length) {
            localh = localObject1[paramInt];
          }
        }
      }
      localObject1 = localh;
      localObject2 = paramMenu;
      if (localh != null)
      {
        localObject2 = j;
        localObject1 = localh;
      }
    }
    if ((localObject1 != null) && (!o)) {
      return;
    }
    if (!d0) {
      z.onPanelClosed(paramInt, (Menu)localObject2);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    Object localObject1 = z;
    if ((localObject1 instanceof Activity))
    {
      Object localObject2 = null;
      try
      {
        localObject1 = (Activity)localObject1;
        try
        {
          localObject1 = s.b((Context)localObject1, ((Activity)localObject1).getComponentName());
          localObject2 = localObject1;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          localObject1 = new java/lang/IllegalArgumentException;
          ((IllegalArgumentException)localObject1).<init>(localNameNotFoundException);
          throw ((Throwable)localObject1);
        }
        if (paramBundle == null) {
          return;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        if (localObject2 != null)
        {
          localObject2 = C;
          if (localObject2 == null) {
            k0 = true;
          } else {
            ((a)localObject2).b(true);
          }
        }
      }
    }
    if (e0 == -100) {
      e0 = paramBundle.getInt("appcompat:local_night_mode", -100);
    }
  }
  
  public void a(View paramView)
  {
    f();
    ViewGroup localViewGroup = (ViewGroup)P.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView);
    z.onContentChanged();
  }
  
  public void a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    f();
    ViewGroup localViewGroup = (ViewGroup)P.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView, paramLayoutParams);
    z.onContentChanged();
  }
  
  public final void a(h paramh, KeyEvent paramKeyEvent)
  {
    if ((!o) && (!d0))
    {
      if (a == 0)
      {
        if ((x.getResources().getConfiguration().screenLayout & 0xF) == 4) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          return;
        }
      }
      Object localObject = h();
      if ((localObject != null) && (!((Window.Callback)localObject).onMenuOpened(a, j)))
      {
        a(paramh, true);
        return;
      }
      WindowManager localWindowManager = (WindowManager)x.getSystemService("window");
      if (localWindowManager == null) {
        return;
      }
      if (!b(paramh, paramKeyEvent)) {
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
            break label771;
          }
        }
      }
      else
      {
        paramKeyEvent = g;
        if (paramKeyEvent == null)
        {
          localObject = g();
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
          g = new g(l);
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
          if (H == null) {
            H = new i();
          }
          localObject = H;
          if (j == null)
          {
            paramKeyEvent = null;
          }
          else
          {
            if (k == null)
            {
              paramKeyEvent = new f(l, R.layout.abc_list_menu_item_layout);
              k = paramKeyEvent;
              E = ((o.a)localObject);
              localObject = j;
              ((d.b.d.i.h)localObject).a(paramKeyEvent, a);
            }
            localObject = k;
            paramKeyEvent = g;
            if (A == null)
            {
              A = ((ExpandedMenuView)y.inflate(R.layout.abc_expanded_menu_layout, paramKeyEvent, false));
              if (F == null) {
                F = new f.a((f)localObject);
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
        if ((localObject != null) && ((localObject instanceof ViewGroup))) {
          ((ViewGroup)localObject).removeView(h);
        }
        g.addView(h, paramKeyEvent);
        if (!h.hasFocus()) {
          h.requestFocus();
        }
      }
      int i = -2;
      label771:
      n = false;
      paramKeyEvent = new WindowManager.LayoutParams(i, -2, d, e, 1002, 8519680, -3);
      gravity = c;
      windowAnimations = f;
      localWindowManager.addView(g, paramKeyEvent);
      o = true;
    }
  }
  
  public void a(h paramh, boolean paramBoolean)
  {
    Object localObject;
    if ((paramBoolean) && (a == 0))
    {
      localObject = F;
      if ((localObject != null) && (((a0)localObject).a()))
      {
        b(j);
        return;
      }
    }
    WindowManager localWindowManager = (WindowManager)x.getSystemService("window");
    if ((localWindowManager != null) && (o))
    {
      localObject = g;
      if (localObject != null)
      {
        localWindowManager.removeView((View)localObject);
        if (paramBoolean) {
          a(a, paramh, null);
        }
      }
    }
    m = false;
    n = false;
    o = false;
    h = null;
    q = true;
    if (b0 == paramh) {
      b0 = null;
    }
  }
  
  public void a(d.b.d.i.h paramh)
  {
    paramh = F;
    if ((paramh != null) && (paramh.f()) && ((!ViewConfiguration.get(x).hasPermanentMenuKey()) || (F.c())))
    {
      Window.Callback localCallback = h();
      if (F.a())
      {
        F.d();
        if (!d0) {
          localCallback.onPanelClosed(108, d0j);
        }
      }
      else if ((localCallback != null) && (!d0))
      {
        if ((h0) && ((0x1 & i0) != 0))
        {
          y.getDecorView().removeCallbacks(j0);
          j0.run();
        }
        paramh = d(0);
        d.b.d.i.h localh = j;
        if ((localh != null) && (!r) && (localCallback.onPreparePanel(0, i, localh)))
        {
          localCallback.onMenuOpened(108, j);
          F.e();
        }
      }
    }
    else
    {
      paramh = d(0);
      q = true;
      a(paramh, false);
      a(paramh, null);
    }
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    E = paramCharSequence;
    Object localObject = F;
    if (localObject != null)
    {
      ((a0)localObject).setWindowTitle(paramCharSequence);
    }
    else
    {
      localObject = C;
      if (localObject != null)
      {
        ((a)localObject).b(paramCharSequence);
      }
      else
      {
        localObject = Q;
        if (localObject != null) {
          ((TextView)localObject).setText(paramCharSequence);
        }
      }
    }
  }
  
  public boolean a()
  {
    int i = e0;
    if (i == -100) {
      i = -1;
    }
    Object localObject1;
    if (i != -100)
    {
      if (i != 0)
      {
        j = i;
        break label102;
      }
      if ((Build.VERSION.SDK_INT < 23) || (((UiModeManager)x.getSystemService(UiModeManager.class)).getNightMode() != 0))
      {
        e();
        localObject1 = g0;
        bool1 = a.a();
        b = bool1;
        if (bool1)
        {
          j = 2;
          break label102;
        }
        j = 1;
        break label102;
      }
    }
    int j = -1;
    label102:
    boolean bool2 = false;
    int k = 0;
    boolean bool1 = bool2;
    label268:
    Object localObject5;
    if (j != -1)
    {
      Object localObject6 = x.getResources();
      localObject1 = ((Resources)localObject6).getConfiguration();
      int m = uiMode;
      if (j == 2) {
        j = 32;
      } else {
        j = 16;
      }
      bool1 = bool2;
      if ((m & 0x30) != j)
      {
        m = k;
        Object localObject11;
        if (f0)
        {
          Object localObject7 = x;
          m = k;
          if ((localObject7 instanceof Activity))
          {
            localObject7 = ((Context)localObject7).getPackageManager();
            try
            {
              localObject11 = new android/content/ComponentName;
              ((ComponentName)localObject11).<init>(x, x.getClass());
              int n = getActivityInfo0configChanges;
              m = k;
              if ((n & 0x200) != 0) {
                break label268;
              }
            }
            catch (PackageManager.NameNotFoundException localNameNotFoundException)
            {
              Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", localNameNotFoundException);
            }
            m = 1;
          }
        }
        if (m != 0)
        {
          ((Activity)x).recreate();
        }
        else
        {
          Object localObject8 = new Configuration((Configuration)localObject1);
          localObject1 = ((Resources)localObject6).getDisplayMetrics();
          uiMode = (j | uiMode & 0xFFFFFFCF);
          ((Resources)localObject6).updateConfiguration((Configuration)localObject8, (DisplayMetrics)localObject1);
          j = Build.VERSION.SDK_INT;
          if ((j < 26) && (j < 28))
          {
            localObject8 = null;
            localObject1 = null;
            localObject11 = null;
            Object localObject9;
            if (j >= 24)
            {
              if (!s.h)
              {
                try
                {
                  localObject1 = Resources.class.getDeclaredField("mResourcesImpl");
                  s.g = (Field)localObject1;
                  ((Field)localObject1).setAccessible(true);
                }
                catch (NoSuchFieldException localNoSuchFieldException1)
                {
                  Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", localNoSuchFieldException1);
                }
                s.h = true;
              }
              Object localObject2 = s.g;
              if (localObject2 != null)
              {
                Object localObject3;
                try
                {
                  localObject2 = ((Field)localObject2).get(localObject6);
                }
                catch (IllegalAccessException localIllegalAccessException1)
                {
                  Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", localIllegalAccessException1);
                  localObject3 = null;
                }
                if (localObject3 != null)
                {
                  if (!s.b)
                  {
                    try
                    {
                      localObject8 = localObject3.getClass().getDeclaredField("mDrawableCache");
                      s.a = (Field)localObject8;
                      ((Field)localObject8).setAccessible(true);
                    }
                    catch (NoSuchFieldException localNoSuchFieldException3)
                    {
                      Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", localNoSuchFieldException3);
                    }
                    s.b = true;
                  }
                  localObject6 = s.a;
                  localObject9 = localObject11;
                  if (localObject6 != null) {
                    try
                    {
                      localObject9 = ((Field)localObject6).get(localObject3);
                    }
                    catch (IllegalAccessException localIllegalAccessException2)
                    {
                      Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", localIllegalAccessException2);
                      localObject9 = localObject11;
                    }
                  }
                  if (localObject9 != null) {
                    s.b(localObject9);
                  }
                }
              }
            }
            else if (j >= 23)
            {
              if (!s.b)
              {
                try
                {
                  Field localField = Resources.class.getDeclaredField("mDrawableCache");
                  s.a = localField;
                  localField.setAccessible(true);
                }
                catch (NoSuchFieldException localNoSuchFieldException2)
                {
                  Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", localNoSuchFieldException2);
                }
                s.b = true;
              }
              localObject11 = s.a;
              Object localObject4 = localObject9;
              if (localObject11 != null) {
                try
                {
                  localObject4 = ((Field)localObject11).get(localObject6);
                }
                catch (IllegalAccessException localIllegalAccessException3)
                {
                  Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", localIllegalAccessException3);
                  localObject5 = localObject9;
                }
              }
              if (localObject5 != null) {
                s.b(localObject5);
              }
            }
            else
            {
              if (!s.b)
              {
                try
                {
                  localObject9 = Resources.class.getDeclaredField("mDrawableCache");
                  s.a = (Field)localObject9;
                  ((Field)localObject9).setAccessible(true);
                }
                catch (NoSuchFieldException localNoSuchFieldException4)
                {
                  Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", localNoSuchFieldException4);
                }
                s.b = true;
              }
              Object localObject10 = s.a;
              if (localObject10 != null)
              {
                try
                {
                  localObject10 = (Map)((Field)localObject10).get(localObject6);
                  localObject5 = localObject10;
                }
                catch (IllegalAccessException localIllegalAccessException4)
                {
                  Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", localIllegalAccessException4);
                }
                if (localObject5 != null) {
                  ((Map)localObject5).clear();
                }
              }
            }
          }
        }
        bool1 = true;
      }
    }
    if (i == 0)
    {
      e();
      f localf = g0;
      localf.a();
      if (c == null) {
        c = new q(localf);
      }
      if (d == null)
      {
        localObject5 = new IntentFilter();
        d = ((IntentFilter)localObject5);
        ((IntentFilter)localObject5).addAction("android.intent.action.TIME_SET");
        d.addAction("android.intent.action.TIMEZONE_CHANGED");
        d.addAction("android.intent.action.TIME_TICK");
      }
      e.x.registerReceiver(c, d);
    }
    f0 = true;
    return bool1;
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
    if ((Y) && (i == 108)) {
      return false;
    }
    if ((U) && (i == 1)) {
      U = false;
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
                return y.requestFeature(i);
              }
              k();
              V = true;
              return true;
            }
            k();
            U = true;
            return true;
          }
          k();
          W = true;
          return true;
        }
        k();
        T = true;
        return true;
      }
      k();
      S = true;
      return true;
    }
    k();
    Y = true;
    return true;
  }
  
  public boolean a(KeyEvent paramKeyEvent)
  {
    Object localObject = z;
    boolean bool1 = localObject instanceof c.a;
    boolean bool2 = true;
    boolean bool3 = true;
    if ((bool1) || ((localObject instanceof r)))
    {
      localObject = y.getDecorView();
      if ((localObject != null) && (d.i.i.n.b((View)localObject, paramKeyEvent))) {
        return true;
      }
    }
    if ((paramKeyEvent.getKeyCode() == 82) && (z.dispatchKeyEvent(paramKeyEvent))) {
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
          b((h)localObject, paramKeyEvent);
          return bool2;
        }
      }
      else
      {
        if ((paramKeyEvent.getFlags() & 0x80) == 0) {
          bool3 = false;
        }
        c0 = bool3;
      }
    }
    label387:
    label401:
    label544:
    do
    {
      do
      {
        return false;
        if (i == 4) {
          break;
        }
      } while (i != 82);
      if (I != null)
      {
        bool1 = bool2;
        break;
      }
      h localh = d(0);
      localObject = F;
      if ((localObject != null) && (((a0)localObject).f()) && (!ViewConfiguration.get(x).hasPermanentMenuKey()))
      {
        if (!F.a())
        {
          if ((!d0) && (b(localh, paramKeyEvent)))
          {
            bool3 = F.e();
            break label401;
          }
        }
        else
        {
          bool3 = F.d();
          break label401;
        }
      }
      else
      {
        if ((o) || (n)) {
          break label387;
        }
        if (m)
        {
          if (r)
          {
            m = false;
            bool3 = b(localh, paramKeyEvent);
          }
          else
          {
            bool3 = true;
          }
          if (bool3)
          {
            a(localh, paramKeyEvent);
            bool3 = true;
            break label401;
          }
        }
      }
      bool3 = false;
      break label401;
      bool3 = o;
      a(localh, true);
      bool1 = bool2;
      if (!bool3) {
        break;
      }
      paramKeyEvent = (AudioManager)x.getSystemService("audio");
      if (paramKeyEvent != null)
      {
        paramKeyEvent.playSoundEffect(0);
        bool1 = bool2;
        break;
      }
      Log.w("AppCompatDelegate", "Couldn't get audio manager");
      bool1 = bool2;
      break;
      bool3 = c0;
      c0 = false;
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
      paramKeyEvent = I;
      if (paramKeyEvent != null)
      {
        paramKeyEvent.a();
      }
      else
      {
        i();
        paramKeyEvent = C;
        if ((paramKeyEvent == null) || (!paramKeyEvent.b())) {
          break label544;
        }
      }
      j = 1;
      continue;
      j = 0;
    } while (j == 0);
    bool1 = bool2;
    return bool1;
  }
  
  public final boolean a(h paramh, int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    boolean bool1 = paramKeyEvent.isSystem();
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    if (!m)
    {
      bool1 = bool2;
      if (!b(paramh, paramKeyEvent)) {}
    }
    else
    {
      d.b.d.i.h localh = j;
      bool1 = bool2;
      if (localh != null) {
        bool1 = localh.performShortcut(paramInt1, paramKeyEvent, paramInt2);
      }
    }
    if ((bool1) && ((paramInt2 & 0x1) == 0) && (F == null)) {
      a(paramh, true);
    }
    return bool1;
  }
  
  public boolean a(d.b.d.i.h paramh, MenuItem paramMenuItem)
  {
    Window.Callback localCallback = h();
    if ((localCallback != null) && (!d0))
    {
      paramh = a(paramh.c());
      if (paramh != null) {
        return localCallback.onMenuItemSelected(a, paramMenuItem);
      }
    }
    return false;
  }
  
  public void b()
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(x);
    if (localLayoutInflater.getFactory() == null) {
      localLayoutInflater.setFactory2(this);
    } else if (!(localLayoutInflater.getFactory2() instanceof k)) {
      Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
    }
  }
  
  public void b(int paramInt)
  {
    f();
    ViewGroup localViewGroup = (ViewGroup)P.findViewById(16908290);
    localViewGroup.removeAllViews();
    LayoutInflater.from(x).inflate(paramInt, localViewGroup);
    z.onContentChanged();
  }
  
  public void b(d.b.d.i.h paramh)
  {
    if (Z) {
      return;
    }
    Z = true;
    F.g();
    Window.Callback localCallback = h();
    if ((localCallback != null) && (!d0)) {
      localCallback.onPanelClosed(108, paramh);
    }
    Z = false;
  }
  
  public final boolean b(h paramh, KeyEvent paramKeyEvent)
  {
    if (d0) {
      return false;
    }
    if (m) {
      return true;
    }
    Object localObject1 = b0;
    if ((localObject1 != null) && (localObject1 != paramh)) {
      a((h)localObject1, false);
    }
    Window.Callback localCallback = h();
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
      localObject1 = F;
      if (localObject1 != null) {
        ((a0)localObject1).b();
      }
    }
    if ((i == null) && ((i == 0) || (!(C instanceof t))))
    {
      if ((j == null) || (r))
      {
        if (j == null)
        {
          Context localContext = x;
          int j = a;
          if (j != 0)
          {
            localObject1 = localContext;
            if (j != 108) {}
          }
          else
          {
            localObject1 = localContext;
            if (F != null)
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
          localObject1 = new d.b.d.i.h((Context)localObject1);
          e = this;
          paramh.a((d.b.d.i.h)localObject1);
          if (j == null) {
            return false;
          }
        }
        if ((i != 0) && (F != null))
        {
          if (G == null) {
            G = new c();
          }
          F.a(j, G);
        }
        j.j();
        if (!localCallback.onCreatePanelMenu(a, j))
        {
          paramh.a(null);
          if (i != 0)
          {
            paramh = F;
            if (paramh != null) {
              paramh.a(null, G);
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
          paramKeyEvent = F;
          if (paramKeyEvent != null) {
            paramKeyEvent.a(null, G);
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
    b0 = paramh;
    return true;
  }
  
  public void c()
  {
    i();
    a locala = C;
    if ((locala != null) && (locala.e())) {
      return;
    }
    e(0);
  }
  
  public void c(int paramInt)
  {
    h localh = d(paramInt);
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
    if (((paramInt == 108) || (paramInt == 0)) && (F != null))
    {
      localObject = d(0);
      if (localObject != null)
      {
        m = false;
        b((h)localObject, null);
      }
    }
  }
  
  public h d(int paramInt)
  {
    Object localObject1 = a0;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (localObject1.length > paramInt) {}
    }
    else
    {
      localObject2 = new h[paramInt + 1];
      if (localObject1 != null) {
        System.arraycopy(localObject1, 0, localObject2, 0, localObject1.length);
      }
      a0 = ((h[])localObject2);
    }
    Object localObject3 = localObject2[paramInt];
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      localObject1 = new h(paramInt);
      localObject2[paramInt] = localObject1;
    }
    return (h)localObject1;
  }
  
  public void d()
  {
    d.i.i.s locals = M;
    if (locals != null) {
      locals.a();
    }
  }
  
  public final void e()
  {
    if (g0 == null)
    {
      Context localContext = x;
      if (v.d == null)
      {
        localContext = localContext.getApplicationContext();
        v.d = new v(localContext, (LocationManager)localContext.getSystemService("location"));
      }
      g0 = new f(v.d);
    }
  }
  
  public final void e(int paramInt)
  {
    i0 = (1 << paramInt | i0);
    if (!h0)
    {
      d.i.i.n.a(y.getDecorView(), j0);
      h0 = true;
    }
  }
  
  public int f(int paramInt)
  {
    Object localObject1 = J;
    int i = 0;
    int j;
    int n;
    if ((localObject1 != null) && ((((ViewGroup)localObject1).getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      localObject1 = (ViewGroup.MarginLayoutParams)J.getLayoutParams();
      boolean bool = J.isShown();
      j = 1;
      int k = 1;
      int m;
      if (bool)
      {
        if (l0 == null)
        {
          l0 = new Rect();
          m0 = new Rect();
        }
        Rect localRect = l0;
        Object localObject2 = m0;
        localRect.set(0, paramInt, 0, 0);
        b1.a(P, localRect, (Rect)localObject2);
        if (top == 0) {
          m = paramInt;
        } else {
          m = 0;
        }
        if (topMargin != m)
        {
          topMargin = paramInt;
          localObject2 = R;
          if (localObject2 == null)
          {
            localObject2 = new View(x);
            R = ((View)localObject2);
            ((View)localObject2).setBackgroundColor(x.getResources().getColor(R.color.abc_input_method_navigation_guard));
            P.addView(R, -1, new ViewGroup.LayoutParams(-1, paramInt));
          }
          else
          {
            localObject2 = ((View)localObject2).getLayoutParams();
            if (height != paramInt)
            {
              height = paramInt;
              R.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            }
          }
          m = 1;
        }
        else
        {
          m = 0;
        }
        if (R == null) {
          k = 0;
        }
        j = paramInt;
        if (!W)
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
        J.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        n = m;
        j = paramInt;
      }
    }
    else
    {
      n = 0;
      j = paramInt;
    }
    localObject1 = R;
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
    if (!O)
    {
      Object localObject1 = x.obtainStyledAttributes(R.styleable.AppCompatTheme);
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
        X = ((TypedArray)localObject1).getBoolean(R.styleable.AppCompatTheme_android_windowIsFloating, false);
        ((TypedArray)localObject1).recycle();
        y.getDecorView();
        localObject1 = LayoutInflater.from(x);
        Object localObject2;
        if (!Y)
        {
          if (X)
          {
            localObject1 = (ViewGroup)((LayoutInflater)localObject1).inflate(R.layout.abc_dialog_title_material, null);
            V = false;
            U = false;
          }
          else if (U)
          {
            localObject1 = new TypedValue();
            x.getTheme().resolveAttribute(R.attr.actionBarTheme, (TypedValue)localObject1, true);
            if (resourceId != 0) {
              localObject1 = new c(x, resourceId);
            } else {
              localObject1 = x;
            }
            localObject2 = (ViewGroup)LayoutInflater.from((Context)localObject1).inflate(R.layout.abc_screen_toolbar, null);
            localObject1 = (a0)((ViewGroup)localObject2).findViewById(R.id.decor_content_parent);
            F = ((a0)localObject1);
            ((a0)localObject1).setWindowCallback(h());
            if (V) {
              F.a(109);
            }
            if (S) {
              F.a(2);
            }
            localObject1 = localObject2;
            if (T)
            {
              F.a(5);
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
          if (W) {
            localObject1 = (ViewGroup)((LayoutInflater)localObject1).inflate(R.layout.abc_screen_simple_overlay_action_mode, null);
          } else {
            localObject1 = (ViewGroup)((LayoutInflater)localObject1).inflate(R.layout.abc_screen_simple, null);
          }
          d.i.i.n.a((View)localObject1, new l(this));
        }
        if (localObject1 != null)
        {
          if (F == null) {
            Q = ((TextView)((ViewGroup)localObject1).findViewById(R.id.title));
          }
          b1.b((View)localObject1);
          ContentFrameLayout localContentFrameLayout = (ContentFrameLayout)((ViewGroup)localObject1).findViewById(R.id.action_bar_activity_content);
          localObject2 = (ViewGroup)y.findViewById(16908290);
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
          y.setContentView((View)localObject1);
          localContentFrameLayout.setAttachListener(new n(this));
          P = ((ViewGroup)localObject1);
          localObject1 = z;
          if ((localObject1 instanceof Activity)) {
            localObject1 = ((Activity)localObject1).getTitle();
          } else {
            localObject1 = E;
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = F;
            if (localObject2 != null)
            {
              ((a0)localObject2).setWindowTitle((CharSequence)localObject1);
            }
            else
            {
              localObject2 = C;
              if (localObject2 != null)
              {
                ((a)localObject2).b((CharSequence)localObject1);
              }
              else
              {
                localObject2 = Q;
                if (localObject2 != null) {
                  ((TextView)localObject2).setText((CharSequence)localObject1);
                }
              }
            }
          }
          localObject1 = (ContentFrameLayout)P.findViewById(16908290);
          localObject2 = y.getDecorView();
          int i = ((View)localObject2).getPaddingLeft();
          int j = ((View)localObject2).getPaddingTop();
          int k = ((View)localObject2).getPaddingRight();
          int m = ((View)localObject2).getPaddingBottom();
          D.set(i, j, k, m);
          if (d.i.i.n.t((View)localObject1)) {
            ((FrameLayout)localObject1).requestLayout();
          }
          localObject2 = x.obtainStyledAttributes(R.styleable.AppCompatTheme);
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
          O = true;
          localObject1 = d(0);
          if ((!d0) && ((localObject1 == null) || (j == null))) {
            e(108);
          }
        }
        else
        {
          localObject1 = e.a.a.a.a.a("AppCompat does not support the current theme features: { windowActionBar: ");
          ((StringBuilder)localObject1).append(U);
          ((StringBuilder)localObject1).append(", windowActionBarOverlay: ");
          ((StringBuilder)localObject1).append(V);
          ((StringBuilder)localObject1).append(", android:windowIsFloating: ");
          ((StringBuilder)localObject1).append(X);
          ((StringBuilder)localObject1).append(", windowActionModeOverlay: ");
          ((StringBuilder)localObject1).append(W);
          ((StringBuilder)localObject1).append(", windowNoTitle: ");
          ((StringBuilder)localObject1).append(Y);
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
  
  public final Context g()
  {
    i();
    Object localObject1 = C;
    if (localObject1 != null) {
      localObject1 = ((a)localObject1).d();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = x;
    }
    return (Context)localObject2;
  }
  
  public final Window.Callback h()
  {
    return y.getCallback();
  }
  
  public final void i()
  {
    f();
    if ((U) && (C == null))
    {
      Object localObject = z;
      if ((localObject instanceof Activity)) {
        C = new w((Activity)z, V);
      } else if ((localObject instanceof Dialog)) {
        C = new w((Dialog)z);
      }
      localObject = C;
      if (localObject != null) {
        ((a)localObject).b(k0);
      }
    }
  }
  
  public final boolean j()
  {
    if (O)
    {
      ViewGroup localViewGroup = P;
      if ((localViewGroup != null) && (d.i.i.n.t(localViewGroup))) {
        return true;
      }
    }
    boolean bool = false;
    return bool;
  }
  
  public final void k()
  {
    if (!O) {
      return;
    }
    throw new AndroidRuntimeException("Window feature must be requested before adding content");
  }
  
  /* Error */
  public final View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 1257	d/b/a/k:n0	Landroidx/appcompat/app/AppCompatViewInflater;
    //   4: ifnonnull +148 -> 152
    //   7: aload_0
    //   8: getfield 141	d/b/a/k:x	Landroid/content/Context;
    //   11: getstatic 394	androidx/appcompat/R$styleable:AppCompatTheme	[I
    //   14: invokevirtual 397	android/content/Context:obtainStyledAttributes	([I)Landroid/content/res/TypedArray;
    //   17: getstatic 1260	androidx/appcompat/R$styleable:AppCompatTheme_viewInflaterClass	I
    //   20: invokevirtual 1264	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   23: astore 5
    //   25: aload 5
    //   27: ifnull +114 -> 141
    //   30: ldc_w 1266
    //   33: invokevirtual 1269	java/lang/Class:getName	()Ljava/lang/String;
    //   36: aload 5
    //   38: invokevirtual 1275	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   41: ifeq +6 -> 47
    //   44: goto +97 -> 141
    //   47: aload_0
    //   48: aload 5
    //   50: invokestatic 1279	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   53: iconst_0
    //   54: anewarray 694	java/lang/Class
    //   57: invokevirtual 1283	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   60: iconst_0
    //   61: anewarray 647	java/lang/Object
    //   64: invokevirtual 1289	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   67: checkcast 1266	androidx/appcompat/app/AppCompatViewInflater
    //   70: putfield 1257	d/b/a/k:n0	Landroidx/appcompat/app/AppCompatViewInflater;
    //   73: goto +79 -> 152
    //   76: astore 6
    //   78: new 1213	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 1290	java/lang/StringBuilder:<init>	()V
    //   85: astore 7
    //   87: aload 7
    //   89: ldc_w 1292
    //   92: invokevirtual 1221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload 7
    //   98: aload 5
    //   100: invokevirtual 1221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload 7
    //   106: ldc_w 1294
    //   109: invokevirtual 1221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: ldc_w 667
    //   116: aload 7
    //   118: invokevirtual 1233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: aload 6
    //   123: invokestatic 1296	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   126: pop
    //   127: aload_0
    //   128: new 1266	androidx/appcompat/app/AppCompatViewInflater
    //   131: dup
    //   132: invokespecial 1297	androidx/appcompat/app/AppCompatViewInflater:<init>	()V
    //   135: putfield 1257	d/b/a/k:n0	Landroidx/appcompat/app/AppCompatViewInflater;
    //   138: goto +14 -> 152
    //   141: aload_0
    //   142: new 1266	androidx/appcompat/app/AppCompatViewInflater
    //   145: dup
    //   146: invokespecial 1297	androidx/appcompat/app/AppCompatViewInflater:<init>	()V
    //   149: putfield 1257	d/b/a/k:n0	Landroidx/appcompat/app/AppCompatViewInflater;
    //   152: aload_0
    //   153: getfield 1257	d/b/a/k:n0	Landroidx/appcompat/app/AppCompatViewInflater;
    //   156: astore 6
    //   158: invokestatic 1300	d/b/e/a1:a	()Z
    //   161: pop
    //   162: aload 6
    //   164: aload_1
    //   165: aload_2
    //   166: aload_3
    //   167: aload 4
    //   169: iconst_0
    //   170: iconst_0
    //   171: iconst_1
    //   172: iconst_0
    //   173: invokevirtual 1304	androidx/appcompat/app/AppCompatViewInflater:createView	(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;ZZZZ)Landroid/view/View;
    //   176: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	k
    //   0	177	1	paramView	View
    //   0	177	2	paramString	String
    //   0	177	3	paramContext	Context
    //   0	177	4	paramAttributeSet	AttributeSet
    //   23	76	5	str	String
    //   76	46	6	localThrowable	Throwable
    //   156	7	6	localAppCompatViewInflater	AppCompatViewInflater
    //   85	32	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   47	73	76	finally
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return onCreateView(null, paramString, paramContext, paramAttributeSet);
  }
  
  public static final class a
    implements Thread.UncaughtExceptionHandler
  {
    public a(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler) {}
    
    public void uncaughtException(Thread paramThread, Throwable paramThrowable)
    {
      boolean bool = paramThrowable instanceof Resources.NotFoundException;
      int i = 0;
      int j = i;
      Object localObject;
      if (bool)
      {
        localObject = paramThrowable.getMessage();
        j = i;
        if (localObject != null) {
          if (!((String)localObject).contains("drawable"))
          {
            j = i;
            if (!((String)localObject).contains("Drawable")) {}
          }
          else
          {
            j = 1;
          }
        }
      }
      if (j != 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramThrowable.getMessage());
        ((StringBuilder)localObject).append(". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
        localObject = new Resources.NotFoundException(((StringBuilder)localObject).toString());
        ((Throwable)localObject).initCause(paramThrowable.getCause());
        ((Throwable)localObject).setStackTrace(paramThrowable.getStackTrace());
        a.uncaughtException(paramThread, (Throwable)localObject);
      }
      else
      {
        a.uncaughtException(paramThread, paramThrowable);
      }
    }
  }
  
  public class b
    implements Runnable
  {
    public b() {}
    
    public void run()
    {
      k localk = k.this;
      if ((i0 & 0x1) != 0) {
        localk.c(0);
      }
      localk = k.this;
      if ((i0 & 0x1000) != 0) {
        localk.c(108);
      }
      localk = k.this;
      h0 = false;
      i0 = 0;
    }
  }
  
  public final class c
    implements o.a
  {
    public c() {}
    
    public void a(d.b.d.i.h paramh, boolean paramBoolean)
    {
      b(paramh);
    }
    
    public boolean a(d.b.d.i.h paramh)
    {
      Window.Callback localCallback = h();
      if (localCallback != null) {
        localCallback.onMenuOpened(108, paramh);
      }
      return true;
    }
  }
  
  public class d
    implements a.a
  {
    public a.a a;
    
    public d(a.a parama)
    {
      a = parama;
    }
    
    public void a(d.b.d.a parama)
    {
      a.a(parama);
      parama = k.this;
      if (K != null) {
        y.getDecorView().removeCallbacks(L);
      }
      parama = k.this;
      if (J != null)
      {
        parama.d();
        localObject = k.this;
        parama = d.i.i.n.a(J);
        parama.a(0.0F);
        M = parama;
        d.i.i.s locals = M;
        localObject = new a();
        parama = (View)a.get();
        if (parama != null) {
          locals.a(parama, (d.i.i.t)localObject);
        }
      }
      parama = k.this;
      Object localObject = B;
      if (localObject != null) {
        ((i)localObject).b(I);
      }
      I = null;
    }
    
    public boolean a(d.b.d.a parama, Menu paramMenu)
    {
      return a.a(parama, paramMenu);
    }
    
    public boolean a(d.b.d.a parama, MenuItem paramMenuItem)
    {
      return a.a(parama, paramMenuItem);
    }
    
    public boolean b(d.b.d.a parama, Menu paramMenu)
    {
      return a.b(parama, paramMenu);
    }
    
    public class a
      extends u
    {
      public a() {}
      
      public void b(View paramView)
      {
        J.setVisibility(8);
        paramView = k.this;
        PopupWindow localPopupWindow = K;
        if (localPopupWindow != null) {
          localPopupWindow.dismiss();
        } else if ((J.getParent() instanceof View)) {
          d.i.i.n.y((View)J.getParent());
        }
        J.removeAllViews();
        M.a(null);
        M = null;
      }
    }
  }
  
  public class e
    extends d.b.d.h
  {
    public e(Window.Callback paramCallback)
    {
      super();
    }
    
    public final ActionMode a(ActionMode.Callback paramCallback)
    {
      e.a locala = new e.a(x, paramCallback);
      k localk = k.this;
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
              localObject2 = d.i.i.n.a(J);
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
      if ((!a(paramKeyEvent)) && (!x.dispatchKeyEvent(paramKeyEvent))) {
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
        k localk = k.this;
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
      paramMenu = k.this;
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
      paramMenu = k.this;
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
      Object localObject = d(0);
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
      if (N) {
        return a(paramCallback);
      }
      return x.onWindowStartingActionMode(paramCallback);
    }
    
    public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback, int paramInt)
    {
      if ((N) && (paramInt == 0)) {
        return a(paramCallback);
      }
      return x.onWindowStartingActionMode(paramCallback, paramInt);
    }
  }
  
  public final class f
  {
    public v a;
    public boolean b;
    public BroadcastReceiver c;
    public IntentFilter d;
    
    public f(v paramv)
    {
      a = paramv;
      b = paramv.a();
    }
    
    public void a()
    {
      BroadcastReceiver localBroadcastReceiver = c;
      if (localBroadcastReceiver != null)
      {
        x.unregisterReceiver(localBroadcastReceiver);
        c = null;
      }
    }
  }
  
  public class g
    extends ContentFrameLayout
  {
    public g(Context paramContext)
    {
      super();
    }
    
    public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      boolean bool;
      if ((!a(paramKeyEvent)) && (!super.dispatchKeyEvent(paramKeyEvent))) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      if (paramMotionEvent.getAction() == 0)
      {
        int i = (int)paramMotionEvent.getX();
        int j = (int)paramMotionEvent.getY();
        if ((i >= -5) && (j >= -5) && (i <= getWidth() + 5) && (j <= getHeight() + 5)) {
          i = 0;
        } else {
          i = 1;
        }
        if (i != 0)
        {
          paramMotionEvent = k.this;
          paramMotionEvent.a(paramMotionEvent.d(0), true);
          return true;
        }
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    
    public void setBackgroundResource(int paramInt)
    {
      setBackgroundDrawable(d.b.b.a.a.c(getContext(), paramInt));
    }
  }
  
  public static final class h
  {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public ViewGroup g;
    public View h;
    public View i;
    public d.b.d.i.h j;
    public f k;
    public Context l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public Bundle s;
    
    public h(int paramInt)
    {
      a = paramInt;
      q = false;
    }
    
    public void a(d.b.d.i.h paramh)
    {
      Object localObject = j;
      if (paramh == localObject) {
        return;
      }
      if (localObject != null) {
        ((d.b.d.i.h)localObject).a(k);
      }
      j = paramh;
      if (paramh != null)
      {
        localObject = k;
        if (localObject != null) {
          paramh.a((d.b.d.i.o)localObject, a);
        }
      }
    }
  }
  
  public final class i
    implements o.a
  {
    public i() {}
    
    public void a(d.b.d.i.h paramh, boolean paramBoolean)
    {
      d.b.d.i.h localh = paramh.c();
      int i;
      if (localh != paramh) {
        i = 1;
      } else {
        i = 0;
      }
      k localk = k.this;
      if (i != 0) {
        paramh = localh;
      }
      paramh = localk.a(paramh);
      if (paramh != null) {
        if (i != 0)
        {
          a(a, paramh, localh);
          a(paramh, true);
        }
        else
        {
          a(paramh, paramBoolean);
        }
      }
    }
    
    public boolean a(d.b.d.i.h paramh)
    {
      if (paramh == null)
      {
        Object localObject = k.this;
        if (U)
        {
          localObject = ((k)localObject).h();
          if ((localObject != null) && (!d0)) {
            ((Window.Callback)localObject).onMenuOpened(108, paramh);
          }
        }
      }
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     d.b.a.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */