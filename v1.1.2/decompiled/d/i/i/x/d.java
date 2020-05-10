package d.i.i.x;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class d
{
  public static int d;
  public final AccessibilityNodeInfo a;
  public int b = -1;
  public int c = -1;
  
  public d(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    a = paramAccessibilityNodeInfo;
  }
  
  public static String a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          default: 
            switch (paramInt)
            {
            default: 
              return "ACTION_UNKNOWN";
            case 16908361: 
              return "ACTION_PAGE_RIGHT";
            case 16908360: 
              return "ACTION_PAGE_LEFT";
            case 16908359: 
              return "ACTION_PAGE_DOWN";
            case 16908358: 
              return "ACTION_PAGE_UP";
            case 16908357: 
              return "ACTION_HIDE_TOOLTIP";
            }
            return "ACTION_SHOW_TOOLTIP";
          case 16908349: 
            return "ACTION_SET_PROGRESS";
          case 16908348: 
            return "ACTION_CONTEXT_CLICK";
          case 16908347: 
            return "ACTION_SCROLL_RIGHT";
          case 16908346: 
            return "ACTION_SCROLL_DOWN";
          case 16908345: 
            return "ACTION_SCROLL_LEFT";
          case 16908344: 
            return "ACTION_SCROLL_UP";
          case 16908343: 
            return "ACTION_SCROLL_TO_POSITION";
          }
          return "ACTION_SHOW_ON_SCREEN";
        case 16908354: 
          return "ACTION_MOVE_WINDOW";
        case 2097152: 
          return "ACTION_SET_TEXT";
        case 524288: 
          return "ACTION_COLLAPSE";
        case 262144: 
          return "ACTION_EXPAND";
        case 131072: 
          return "ACTION_SET_SELECTION";
        case 65536: 
          return "ACTION_CUT";
        case 32768: 
          return "ACTION_PASTE";
        case 16384: 
          return "ACTION_COPY";
        case 8192: 
          return "ACTION_SCROLL_BACKWARD";
        case 4096: 
          return "ACTION_SCROLL_FORWARD";
        case 2048: 
          return "ACTION_PREVIOUS_HTML_ELEMENT";
        case 1024: 
          return "ACTION_NEXT_HTML_ELEMENT";
        case 512: 
          return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
        case 256: 
          return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
        case 128: 
          return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
        case 64: 
          return "ACTION_ACCESSIBILITY_FOCUS";
        case 32: 
          return "ACTION_LONG_CLICK";
        case 16: 
          return "ACTION_CLICK";
        case 8: 
          return "ACTION_CLEAR_SELECTION";
        }
        return "ACTION_SELECT";
      }
      return "ACTION_CLEAR_FOCUS";
    }
    return "ACTION_FOCUS";
  }
  
  public static ClickableSpan[] a(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof Spanned)) {
      return (ClickableSpan[])((Spanned)paramCharSequence).getSpans(0, paramCharSequence.length(), ClickableSpan.class);
    }
    return null;
  }
  
  public Bundle a()
  {
    return a.getExtras();
  }
  
  public final List<Integer> a(String paramString)
  {
    ArrayList localArrayList1 = a.getExtras().getIntegerArrayList(paramString);
    ArrayList localArrayList2 = localArrayList1;
    if (localArrayList1 == null)
    {
      localArrayList2 = new ArrayList();
      a.getExtras().putIntegerArrayList(paramString, localArrayList2);
    }
    return localArrayList2;
  }
  
  public final void a(int paramInt, boolean paramBoolean)
  {
    Bundle localBundle = a();
    if (localBundle != null)
    {
      int i = localBundle.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0);
      int j;
      if (paramBoolean) {
        j = paramInt;
      } else {
        j = 0;
      }
      localBundle.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", j | i & paramInt);
    }
  }
  
  public void a(a parama)
  {
    a.addAction((AccessibilityNodeInfo.AccessibilityAction)a);
  }
  
  public void a(Object paramObject)
  {
    AccessibilityNodeInfo localAccessibilityNodeInfo = a;
    if (paramObject == null) {
      paramObject = null;
    } else {
      paramObject = (AccessibilityNodeInfo.CollectionItemInfo)a;
    }
    localAccessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo)paramObject);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof d)) {
      return false;
    }
    paramObject = (d)paramObject;
    AccessibilityNodeInfo localAccessibilityNodeInfo = a;
    if (localAccessibilityNodeInfo == null)
    {
      if (a != null) {
        return false;
      }
    }
    else if (!localAccessibilityNodeInfo.equals(a)) {
      return false;
    }
    if (c != c) {
      return false;
    }
    return b == b;
  }
  
  public int hashCode()
  {
    AccessibilityNodeInfo localAccessibilityNodeInfo = a;
    int i;
    if (localAccessibilityNodeInfo == null) {
      i = 0;
    } else {
      i = localAccessibilityNodeInfo.hashCode();
    }
    return i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    Object localObject1 = new Rect();
    a.getBoundsInParent((Rect)localObject1);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("; boundsInParent: ");
    ((StringBuilder)localObject2).append(localObject1);
    localStringBuilder.append(((StringBuilder)localObject2).toString());
    a.getBoundsInScreen((Rect)localObject1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("; boundsInScreen: ");
    ((StringBuilder)localObject2).append(localObject1);
    localStringBuilder.append(((StringBuilder)localObject2).toString());
    localStringBuilder.append("; packageName: ");
    localStringBuilder.append(a.getPackageName());
    localStringBuilder.append("; className: ");
    localStringBuilder.append(a.getClassName());
    localStringBuilder.append("; text: ");
    boolean bool = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    int i = 0;
    Object localObject4;
    int j;
    if ((bool ^ true))
    {
      localObject3 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
      List localList1 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
      localObject4 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
      List localList2 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
      localObject2 = new SpannableString(TextUtils.substring(a.getText(), 0, a.getText().length()));
      for (j = 0;; j++)
      {
        localObject1 = localObject2;
        if (j >= ((List)localObject3).size()) {
          break;
        }
        ((SpannableString)localObject2).setSpan(new a(((Integer)localList2.get(j)).intValue(), this, a().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer)((List)localObject3).get(j)).intValue(), ((Integer)localList1.get(j)).intValue(), ((Integer)((List)localObject4).get(j)).intValue());
      }
    }
    localObject1 = a.getText();
    localStringBuilder.append((CharSequence)localObject1);
    localStringBuilder.append("; contentDescription: ");
    localStringBuilder.append(a.getContentDescription());
    localStringBuilder.append("; viewId: ");
    localStringBuilder.append(a.getViewIdResourceName());
    localStringBuilder.append("; checkable: ");
    localStringBuilder.append(a.isCheckable());
    localStringBuilder.append("; checked: ");
    localStringBuilder.append(a.isChecked());
    localStringBuilder.append("; focusable: ");
    localStringBuilder.append(a.isFocusable());
    localStringBuilder.append("; focused: ");
    localStringBuilder.append(a.isFocused());
    localStringBuilder.append("; selected: ");
    localStringBuilder.append(a.isSelected());
    localStringBuilder.append("; clickable: ");
    localStringBuilder.append(a.isClickable());
    localStringBuilder.append("; longClickable: ");
    localStringBuilder.append(a.isLongClickable());
    localStringBuilder.append("; enabled: ");
    localStringBuilder.append(a.isEnabled());
    localStringBuilder.append("; password: ");
    localStringBuilder.append(a.isPassword());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("; scrollable: ");
    ((StringBuilder)localObject1).append(a.isScrollable());
    localStringBuilder.append(((StringBuilder)localObject1).toString());
    localStringBuilder.append("; [");
    Object localObject3 = a.getActionList();
    if (localObject3 != null)
    {
      localObject2 = new ArrayList();
      int k = ((List)localObject3).size();
      for (j = 0;; j++)
      {
        localObject1 = localObject2;
        m = i;
        if (j >= k) {
          break;
        }
        ((ArrayList)localObject2).add(new a(((List)localObject3).get(j), 0, null, null, null));
      }
    }
    localObject1 = Collections.emptyList();
    for (int m = i; m < ((List)localObject1).size(); m++)
    {
      localObject4 = (a)((List)localObject1).get(m);
      localObject3 = a(((AccessibilityNodeInfo.AccessibilityAction)a).getId());
      localObject2 = localObject3;
      if (((String)localObject3).equals("ACTION_UNKNOWN"))
      {
        localObject2 = localObject3;
        if (((AccessibilityNodeInfo.AccessibilityAction)a).getLabel() != null) {
          localObject2 = ((AccessibilityNodeInfo.AccessibilityAction)a).getLabel().toString();
        }
      }
      localStringBuilder.append((String)localObject2);
      if (m != ((List)localObject1).size() - 1) {
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public static class a
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
    
    public a(int paramInt, CharSequence paramCharSequence)
    {
      this(null, paramInt, paramCharSequence, null, null);
    }
    
    public a(int paramInt, CharSequence paramCharSequence, Class<? extends f.a> paramClass)
    {
      this(null, paramInt, paramCharSequence, null, paramClass);
    }
    
    public a(Object paramObject, int paramInt, CharSequence paramCharSequence, f paramf, Class<? extends f.a> paramClass)
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
  
  public static class b
  {
    public final Object a;
    
    public b(Object paramObject)
    {
      a = paramObject;
    }
    
    public static b a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
    {
      return new b(AccessibilityNodeInfo.CollectionItemInfo.obtain(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2));
    }
  }
}

/* Location:
 * Qualified Name:     d.i.i.x.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */