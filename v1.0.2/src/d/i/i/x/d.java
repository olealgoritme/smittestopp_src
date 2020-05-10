package d.i.i.x;

import android.graphics.Rect;
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
  
  public void a(d.a parama)
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
    Object localObject3;
    if ((bool ^ true))
    {
      localObject3 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
      List localList1 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
      List localList2 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
      localObject4 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
      localObject2 = new SpannableString(TextUtils.substring(a.getText(), 0, a.getText().length()));
      for (j = 0;; j++)
      {
        localObject1 = localObject2;
        if (j >= ((List)localObject3).size()) {
          break;
        }
        ((SpannableString)localObject2).setSpan(new a(((Integer)((List)localObject4).get(j)).intValue(), this, a().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer)((List)localObject3).get(j)).intValue(), ((Integer)localList1.get(j)).intValue(), ((Integer)localList2.get(j)).intValue());
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
    Object localObject4 = a.getActionList();
    if (localObject4 != null)
    {
      localObject2 = new ArrayList();
      int k = ((List)localObject4).size();
      for (int m = 0;; m++)
      {
        localObject1 = localObject2;
        j = i;
        if (m >= k) {
          break;
        }
        ((ArrayList)localObject2).add(new d.a(((List)localObject4).get(m), 0, null, null, null));
      }
    }
    localObject1 = Collections.emptyList();
    for (int j = i; j < ((List)localObject1).size(); j++)
    {
      localObject3 = (d.a)((List)localObject1).get(j);
      localObject4 = a(((AccessibilityNodeInfo.AccessibilityAction)a).getId());
      localObject2 = localObject4;
      if (((String)localObject4).equals("ACTION_UNKNOWN"))
      {
        localObject2 = localObject4;
        if (((AccessibilityNodeInfo.AccessibilityAction)a).getLabel() != null) {
          localObject2 = ((AccessibilityNodeInfo.AccessibilityAction)a).getLabel().toString();
        }
      }
      localStringBuilder.append((String)localObject2);
      if (j != ((List)localObject1).size() - 1) {
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.d.i.i.x.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */