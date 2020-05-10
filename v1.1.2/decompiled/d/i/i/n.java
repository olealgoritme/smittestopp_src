package d.i.i;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import androidx.core.R.id;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class n
{
  public static WeakHashMap<View, s> a;
  public static Field b;
  public static boolean c;
  public static ThreadLocal<Rect> d;
  
  static
  {
    new AtomicInteger(1);
    a = null;
    c = false;
    new WeakHashMap();
  }
  
  public static void A(View paramView)
  {
    float f = paramView.getTranslationY();
    paramView.setTranslationY(1.0F + f);
    paramView.setTranslationY(f);
  }
  
  public static Rect a()
  {
    if (d == null) {
      d = new ThreadLocal();
    }
    Rect localRect1 = (Rect)d.get();
    Rect localRect2 = localRect1;
    if (localRect1 == null)
    {
      localRect2 = new Rect();
      d.set(localRect2);
    }
    localRect2.setEmpty();
    return localRect2;
  }
  
  public static s a(View paramView)
  {
    if (a == null) {
      a = new WeakHashMap();
    }
    s locals1 = (s)a.get(paramView);
    s locals2 = locals1;
    if (locals1 == null)
    {
      locals2 = new s(paramView);
      a.put(paramView, locals2);
    }
    return locals2;
  }
  
  public static w a(View paramView, w paramw)
  {
    paramw = (WindowInsets)a;
    WindowInsets localWindowInsets = paramView.onApplyWindowInsets(paramw);
    paramView = paramw;
    if (!localWindowInsets.equals(paramw)) {
      paramView = new WindowInsets(localWindowInsets);
    }
    return new w(Objects.requireNonNull(paramView));
  }
  
  public static void a(View paramView, float paramFloat)
  {
    paramView.setElevation(paramFloat);
  }
  
  public static void a(View paramView, int paramInt)
  {
    paramView.offsetLeftAndRight(paramInt);
    if (paramView.getVisibility() == 0)
    {
      float f = paramView.getTranslationY();
      paramView.setTranslationY(1.0F + f);
      paramView.setTranslationY(f);
      paramView = paramView.getParent();
      if ((paramView instanceof View)) {
        A((View)paramView);
      }
    }
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      paramView.setScrollIndicators(paramInt1, paramInt2);
    }
  }
  
  public static void a(View paramView, ColorStateList paramColorStateList)
  {
    paramView.setBackgroundTintList(paramColorStateList);
    if (Build.VERSION.SDK_INT == 21)
    {
      paramColorStateList = paramView.getBackground();
      int i;
      if ((paramView.getBackgroundTintList() == null) && (paramView.getBackgroundTintMode() == null)) {
        i = 0;
      } else {
        i = 1;
      }
      if ((paramColorStateList != null) && (i != 0))
      {
        if (paramColorStateList.isStateful()) {
          paramColorStateList.setState(paramView.getDrawableState());
        }
        paramView.setBackground(paramColorStateList);
      }
    }
  }
  
  public static void a(View paramView, PorterDuff.Mode paramMode)
  {
    paramView.setBackgroundTintMode(paramMode);
    if (Build.VERSION.SDK_INT == 21)
    {
      paramMode = paramView.getBackground();
      int i;
      if ((paramView.getBackgroundTintList() == null) && (paramView.getBackgroundTintMode() == null)) {
        i = 0;
      } else {
        i = 1;
      }
      if ((paramMode != null) && (i != 0))
      {
        if (paramMode.isStateful()) {
          paramMode.setState(paramView.getDrawableState());
        }
        paramView.setBackground(paramMode);
      }
    }
  }
  
  public static void a(View paramView, Rect paramRect)
  {
    paramView.setClipBounds(paramRect);
  }
  
  public static void a(View paramView, Drawable paramDrawable)
  {
    paramView.setBackground(paramDrawable);
  }
  
  public static void a(View paramView, a parama)
  {
    a locala = parama;
    if (parama == null)
    {
      locala = parama;
      if ((b(paramView) instanceof a.a)) {
        locala = new a();
      }
    }
    if (locala == null) {
      parama = null;
    } else {
      parama = b;
    }
    paramView.setAccessibilityDelegate(parama);
  }
  
  public static void a(View paramView, k paramk)
  {
    if (paramk == null)
    {
      paramView.setOnApplyWindowInsetsListener(null);
      return;
    }
    paramView.setOnApplyWindowInsetsListener(new a(paramk));
  }
  
  public static void a(View paramView, m paramm)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      if (paramm != null) {
        paramm = a;
      } else {
        paramm = null;
      }
      paramView.setPointerIcon((PointerIcon)paramm);
    }
  }
  
  public static void a(View paramView, Runnable paramRunnable)
  {
    paramView.postOnAnimation(paramRunnable);
  }
  
  public static void a(View paramView, Runnable paramRunnable, long paramLong)
  {
    paramView.postOnAnimationDelayed(paramRunnable, paramLong);
  }
  
  public static void a(View paramView, String paramString)
  {
    paramView.setTransitionName(paramString);
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    paramView.setHasTransientState(paramBoolean);
  }
  
  public static boolean a(View paramView, KeyEvent paramKeyEvent)
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool = false;
    if (i >= 28) {
      return false;
    }
    d locald = d.a(paramView);
    if (locald != null)
    {
      if (paramKeyEvent.getAction() == 0) {
        locald.a();
      }
      paramView = locald.a(paramView, paramKeyEvent);
      if (paramKeyEvent.getAction() == 0)
      {
        i = paramKeyEvent.getKeyCode();
        if ((paramView != null) && (!KeyEvent.isModifierKey(i)))
        {
          if (b == null) {
            b = new SparseArray();
          }
          b.put(i, new WeakReference(paramView));
        }
      }
      if (paramView != null) {
        bool = true;
      }
      return bool;
    }
    throw null;
  }
  
  /* Error */
  public static android.view.View.AccessibilityDelegate b(View paramView)
  {
    // Byte code:
    //   0: getstatic 134	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 29
    //   5: if_icmplt +8 -> 13
    //   8: aload_0
    //   9: invokevirtual 275	android/view/View:getAccessibilityDelegate	()Landroid/view/View$AccessibilityDelegate;
    //   12: areturn
    //   13: getstatic 34	d/i/i/n:c	Z
    //   16: istore_1
    //   17: aconst_null
    //   18: astore_2
    //   19: iload_1
    //   20: ifeq +8 -> 28
    //   23: aload_2
    //   24: astore_0
    //   25: goto +72 -> 97
    //   28: getstatic 277	d/i/i/n:b	Ljava/lang/reflect/Field;
    //   31: ifnonnull +34 -> 65
    //   34: ldc 43
    //   36: ldc_w 279
    //   39: invokevirtual 285	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   42: astore_3
    //   43: aload_3
    //   44: putstatic 277	d/i/i/n:b	Ljava/lang/reflect/Field;
    //   47: aload_3
    //   48: iconst_1
    //   49: invokevirtual 290	java/lang/reflect/Field:setAccessible	(Z)V
    //   52: goto +13 -> 65
    //   55: astore_0
    //   56: iconst_1
    //   57: putstatic 34	d/i/i/n:c	Z
    //   60: aload_2
    //   61: astore_0
    //   62: goto +35 -> 97
    //   65: getstatic 277	d/i/i/n:b	Ljava/lang/reflect/Field;
    //   68: aload_0
    //   69: invokevirtual 291	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   72: astore_3
    //   73: aload_2
    //   74: astore_0
    //   75: aload_3
    //   76: instanceof 293
    //   79: ifeq +18 -> 97
    //   82: aload_3
    //   83: checkcast 293	android/view/View$AccessibilityDelegate
    //   86: astore_0
    //   87: goto +10 -> 97
    //   90: astore_0
    //   91: iconst_1
    //   92: putstatic 34	d/i/i/n:c	Z
    //   95: aload_2
    //   96: astore_0
    //   97: aload_0
    //   98: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	paramView	View
    //   16	4	1	bool	boolean
    //   18	78	2	localObject1	Object
    //   42	41	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   34	52	55	finally
    //   65	73	90	finally
    //   75	87	90	finally
  }
  
  public static void b(View paramView, int paramInt)
  {
    paramView.offsetTopAndBottom(paramInt);
    if (paramView.getVisibility() == 0)
    {
      float f = paramView.getTranslationY();
      paramView.setTranslationY(1.0F + f);
      paramView.setTranslationY(f);
      paramView = paramView.getParent();
      if ((paramView instanceof View)) {
        A((View)paramView);
      }
    }
  }
  
  public static boolean b(View paramView, KeyEvent paramKeyEvent)
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool = false;
    if (i >= 28) {
      return false;
    }
    d locald = d.a(paramView);
    paramView = c;
    if ((paramView == null) || (paramView.get() != paramKeyEvent))
    {
      c = new WeakReference(paramKeyEvent);
      Object localObject = null;
      if (b == null) {
        b = new SparseArray();
      }
      SparseArray localSparseArray = b;
      paramView = (View)localObject;
      if (paramKeyEvent.getAction() == 1)
      {
        i = localSparseArray.indexOfKey(paramKeyEvent.getKeyCode());
        paramView = (View)localObject;
        if (i >= 0)
        {
          paramView = (WeakReference)localSparseArray.valueAt(i);
          localSparseArray.removeAt(i);
        }
      }
      localObject = paramView;
      if (paramView == null) {
        localObject = (WeakReference)localSparseArray.get(paramKeyEvent.getKeyCode());
      }
      if (localObject != null)
      {
        paramView = (View)((WeakReference)localObject).get();
        if ((paramView != null) && (s(paramView))) {
          locald.b(paramView, paramKeyEvent);
        }
        bool = true;
      }
    }
    return bool;
  }
  
  public static ColorStateList c(View paramView)
  {
    return paramView.getBackgroundTintList();
  }
  
  public static void c(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramView.offsetLeftAndRight(paramInt);
    }
    else
    {
      Rect localRect = a();
      boolean bool = false;
      ViewParent localViewParent = paramView.getParent();
      if ((localViewParent instanceof View))
      {
        View localView = (View)localViewParent;
        localRect.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
        bool = localRect.intersects(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()) ^ true;
      }
      a(paramView, paramInt);
      if ((bool) && (localRect.intersect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()))) {
        ((View)localViewParent).invalidate(localRect);
      }
    }
  }
  
  public static Rect d(View paramView)
  {
    return paramView.getClipBounds();
  }
  
  public static void d(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramView.offsetTopAndBottom(paramInt);
    }
    else
    {
      Rect localRect = a();
      boolean bool = false;
      ViewParent localViewParent = paramView.getParent();
      if ((localViewParent instanceof View))
      {
        View localView = (View)localViewParent;
        localRect.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
        bool = localRect.intersects(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()) ^ true;
      }
      b(paramView, paramInt);
      if ((bool) && (localRect.intersect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()))) {
        ((View)localViewParent).invalidate(localRect);
      }
    }
  }
  
  public static Display e(View paramView)
  {
    return paramView.getDisplay();
  }
  
  public static void e(View paramView, int paramInt)
  {
    paramView.setImportantForAccessibility(paramInt);
  }
  
  public static float f(View paramView)
  {
    return paramView.getElevation();
  }
  
  public static void f(View paramView, int paramInt)
  {
    if ((paramView instanceof d)) {
      ((d)paramView).a(paramInt);
    } else if (paramInt == 0) {
      paramView.stopNestedScroll();
    }
  }
  
  public static boolean g(View paramView)
  {
    return paramView.getFitsSystemWindows();
  }
  
  @SuppressLint({"InlinedApi"})
  public static int h(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramView.getImportantForAutofill();
    }
    return 0;
  }
  
  public static int i(View paramView)
  {
    return paramView.getLayoutDirection();
  }
  
  public static int j(View paramView)
  {
    return paramView.getMinimumHeight();
  }
  
  public static int k(View paramView)
  {
    return paramView.getMinimumWidth();
  }
  
  public static int l(View paramView)
  {
    return paramView.getPaddingEnd();
  }
  
  public static int m(View paramView)
  {
    return paramView.getPaddingStart();
  }
  
  public static String n(View paramView)
  {
    return paramView.getTransitionName();
  }
  
  public static int o(View paramView)
  {
    return paramView.getWindowSystemUiVisibility();
  }
  
  public static float p(View paramView)
  {
    return paramView.getZ();
  }
  
  public static boolean q(View paramView)
  {
    return paramView.hasOnClickListeners();
  }
  
  public static boolean r(View paramView)
  {
    return paramView.hasOverlappingRendering();
  }
  
  public static boolean s(View paramView)
  {
    return paramView.isAttachedToWindow();
  }
  
  public static boolean t(View paramView)
  {
    return paramView.isLaidOut();
  }
  
  public static boolean u(View paramView)
  {
    return paramView.isNestedScrollingEnabled();
  }
  
  public static boolean v(View paramView)
  {
    return paramView.isPaddingRelative();
  }
  
  public static boolean w(View paramView)
  {
    paramView = (Boolean)new o(R.id.tag_screen_reader_focusable, Boolean.class, 28).b(paramView);
    boolean bool;
    if (paramView == null) {
      bool = false;
    } else {
      bool = paramView.booleanValue();
    }
    return bool;
  }
  
  public static void x(View paramView)
  {
    paramView.postInvalidateOnAnimation();
  }
  
  public static void y(View paramView)
  {
    paramView.requestApplyInsets();
  }
  
  public static void z(View paramView)
  {
    paramView.stopNestedScroll();
  }
  
  public static final class a
    implements View.OnApplyWindowInsetsListener
  {
    public a(k paramk) {}
    
    public WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets)
    {
      paramWindowInsets = new w(Objects.requireNonNull(paramWindowInsets));
      return (WindowInsets)a.a(paramView, paramWindowInsets).a;
    }
  }
  
  public static abstract class b<T>
  {
    public final int a;
    public final Class<T> b;
    public final int c;
    
    public b(int paramInt1, Class<T> paramClass, int paramInt2)
    {
      a = paramInt1;
      b = paramClass;
      c = paramInt2;
    }
    
    public b(int paramInt1, Class<T> paramClass, int paramInt2, int paramInt3)
    {
      a = paramInt1;
      b = paramClass;
      c = paramInt3;
    }
    
    public abstract T a(View paramView);
    
    public T b(View paramView)
    {
      int i;
      if (Build.VERSION.SDK_INT >= c) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        return (T)a(paramView);
      }
      paramView = paramView.getTag(a);
      if (b.isInstance(paramView)) {
        return paramView;
      }
      return null;
    }
  }
  
  public static abstract interface c
  {
    public abstract boolean a(View paramView, KeyEvent paramKeyEvent);
  }
  
  public static class d
  {
    public static final ArrayList<WeakReference<View>> d = new ArrayList();
    public WeakHashMap<View, Boolean> a = null;
    public SparseArray<WeakReference<View>> b = null;
    public WeakReference<KeyEvent> c = null;
    
    public static d a(View paramView)
    {
      d locald1 = (d)paramView.getTag(R.id.tag_unhandled_key_event_manager);
      d locald2 = locald1;
      if (locald1 == null)
      {
        locald2 = new d();
        paramView.setTag(R.id.tag_unhandled_key_event_manager, locald2);
      }
      return locald2;
    }
    
    public final View a(View paramView, KeyEvent paramKeyEvent)
    {
      Object localObject = a;
      if ((localObject != null) && (((WeakHashMap)localObject).containsKey(paramView)))
      {
        if ((paramView instanceof ViewGroup))
        {
          ViewGroup localViewGroup = (ViewGroup)paramView;
          for (int i = localViewGroup.getChildCount() - 1; i >= 0; i--)
          {
            localObject = a(localViewGroup.getChildAt(i), paramKeyEvent);
            if (localObject != null) {
              return (View)localObject;
            }
          }
        }
        if (b(paramView, paramKeyEvent)) {
          return paramView;
        }
      }
      return null;
    }
    
    public final void a()
    {
      Object localObject1 = a;
      if (localObject1 != null) {
        ((WeakHashMap)localObject1).clear();
      }
      if (d.isEmpty()) {
        return;
      }
      synchronized (d)
      {
        if (a == null)
        {
          localObject1 = new java/util/WeakHashMap;
          ((WeakHashMap)localObject1).<init>();
          a = ((WeakHashMap)localObject1);
        }
        for (int i = d.size() - 1; i >= 0; i--)
        {
          localObject1 = (View)((WeakReference)d.get(i)).get();
          if (localObject1 == null)
          {
            d.remove(i);
          }
          else
          {
            a.put(localObject1, Boolean.TRUE);
            for (localObject1 = ((View)localObject1).getParent(); (localObject1 instanceof View); localObject1 = ((ViewParent)localObject1).getParent()) {
              a.put((View)localObject1, Boolean.TRUE);
            }
          }
        }
        return;
      }
    }
    
    public final boolean b(View paramView, KeyEvent paramKeyEvent)
    {
      ArrayList localArrayList = (ArrayList)paramView.getTag(R.id.tag_unhandled_key_listeners);
      if (localArrayList != null) {
        for (int i = localArrayList.size() - 1; i >= 0; i--) {
          if (((n.c)localArrayList.get(i)).a(paramView, paramKeyEvent)) {
            return true;
          }
        }
      }
      return false;
    }
  }
}

/* Location:
 * Qualified Name:     d.i.i.n
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */