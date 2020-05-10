package d.i.i.x;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;

public class d$a
{
  public static final a d;
  public static final a e;
  public static final a f;
  public static final a g;
  public final Object a;
  public final Class<? extends f.a> b;
  public final f c;
  
  static
  {
    Object localObject1 = null;
    new a(1, null);
    new a(2, null);
    new a(4, null);
    new a(8, null);
    new a(16, null);
    new a(32, null);
    new a(64, null);
    new a(128, null);
    new a(256, null, f.b.class);
    new a(512, null, f.b.class);
    new a(1024, null, f.c.class);
    new a(2048, null, f.c.class);
    d = new a(4096, null);
    e = new a(8192, null);
    new a(16384, null);
    new a(32768, null);
    new a(65536, null);
    new a(131072, null, f.g.class);
    new a(262144, null);
    new a(524288, null);
    new a(1048576, null);
    new a(2097152, null, f.h.class);
    if (Build.VERSION.SDK_INT >= 23) {
      localObject2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN;
    } else {
      localObject2 = null;
    }
    new a(localObject2, 16908342, null, null, null);
    if (Build.VERSION.SDK_INT >= 23) {
      localObject2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION;
    } else {
      localObject2 = null;
    }
    new a(localObject2, 16908343, null, null, f.e.class);
    if (Build.VERSION.SDK_INT >= 23) {
      localObject2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP;
    } else {
      localObject2 = null;
    }
    f = new a(localObject2, 16908344, null, null, null);
    if (Build.VERSION.SDK_INT >= 23) {
      localObject2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT;
    } else {
      localObject2 = null;
    }
    new a(localObject2, 16908345, null, null, null);
    if (Build.VERSION.SDK_INT >= 23) {
      localObject2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN;
    } else {
      localObject2 = null;
    }
    g = new a(localObject2, 16908346, null, null, null);
    if (Build.VERSION.SDK_INT >= 23) {
      localObject2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT;
    } else {
      localObject2 = null;
    }
    new a(localObject2, 16908347, null, null, null);
    if (Build.VERSION.SDK_INT >= 29) {
      localObject2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP;
    } else {
      localObject2 = null;
    }
    new a(localObject2, 16908358, null, null, null);
    if (Build.VERSION.SDK_INT >= 29) {
      localObject2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN;
    } else {
      localObject2 = null;
    }
    new a(localObject2, 16908359, null, null, null);
    if (Build.VERSION.SDK_INT >= 29) {
      localObject2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT;
    } else {
      localObject2 = null;
    }
    new a(localObject2, 16908360, null, null, null);
    if (Build.VERSION.SDK_INT >= 29) {
      localObject2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT;
    } else {
      localObject2 = null;
    }
    new a(localObject2, 16908361, null, null, null);
    if (Build.VERSION.SDK_INT >= 23) {
      localObject2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;
    } else {
      localObject2 = null;
    }
    new a(localObject2, 16908348, null, null, null);
    if (Build.VERSION.SDK_INT >= 24) {
      localObject2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
    } else {
      localObject2 = null;
    }
    new a(localObject2, 16908349, null, null, f.f.class);
    if (Build.VERSION.SDK_INT >= 26) {
      localObject2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW;
    } else {
      localObject2 = null;
    }
    new a(localObject2, 16908354, null, null, f.d.class);
    if (Build.VERSION.SDK_INT >= 28) {
      localObject2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;
    } else {
      localObject2 = null;
    }
    new a(localObject2, 16908356, null, null, null);
    Object localObject2 = localObject1;
    if (Build.VERSION.SDK_INT >= 28) {
      localObject2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
    }
    new a(localObject2, 16908357, null, null, null);
  }
  
  public d$a(int paramInt, CharSequence paramCharSequence)
  {
    this(null, paramInt, paramCharSequence, null, null);
  }
  
  public d$a(int paramInt, CharSequence paramCharSequence, Class<? extends f.a> paramClass)
  {
    this(null, paramInt, paramCharSequence, null, paramClass);
  }
  
  public d$a(Object paramObject, int paramInt, CharSequence paramCharSequence, f paramf, Class<? extends f.a> paramClass)
  {
    c = paramf;
    if (paramObject == null) {
      a = new AccessibilityNodeInfo.AccessibilityAction(paramInt, paramCharSequence);
    } else {
      a = paramObject;
    }
    b = paramClass;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof a)) {
      return false;
    }
    a locala = (a)paramObject;
    paramObject = a;
    if (paramObject == null)
    {
      if (a != null) {
        return false;
      }
    }
    else if (!paramObject.equals(a)) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    Object localObject = a;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     d.i.i.x.d.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */