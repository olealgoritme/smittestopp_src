package d.i.i;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.R.id;
import d.i.i.x.d;
import d.i.i.x.d.a;
import d.i.i.x.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a$a
  extends View.AccessibilityDelegate
{
  public final a a;
  
  public a$a(a parama)
  {
    a = parama;
  }
  
  public boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return a.a.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public AccessibilityNodeProvider getAccessibilityNodeProvider(View paramView)
  {
    paramView = a.a.getAccessibilityNodeProvider(paramView);
    AccessibilityNodeProvider localAccessibilityNodeProvider = null;
    if (paramView != null) {
      paramView = new e(paramView);
    } else {
      paramView = null;
    }
    if (paramView != null) {
      localAccessibilityNodeProvider = (AccessibilityNodeProvider)a;
    }
    return localAccessibilityNodeProvider;
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    a.a(paramView, paramAccessibilityEvent);
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    d locald = new d(paramAccessibilityNodeInfo);
    boolean bool = n.w(paramView);
    if (Build.VERSION.SDK_INT >= 28) {
      a.setScreenReaderFocusable(bool);
    } else {
      locald.a(1, bool);
    }
    Object localObject = (Boolean)new q(R.id.tag_accessibility_heading, Boolean.class, 28).b(paramView);
    if (localObject == null) {
      bool = false;
    } else {
      bool = ((Boolean)localObject).booleanValue();
    }
    if (Build.VERSION.SDK_INT >= 28) {
      a.setHeading(bool);
    } else {
      locald.a(2, bool);
    }
    localObject = (CharSequence)new p(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28).b(paramView);
    if (Build.VERSION.SDK_INT >= 28) {
      a.setPaneTitle((CharSequence)localObject);
    } else {
      a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", (CharSequence)localObject);
    }
    a.a(paramView, locald);
    CharSequence localCharSequence = paramAccessibilityNodeInfo.getText();
    if (Build.VERSION.SDK_INT < 26)
    {
      a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
      a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
      a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
      a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
      localObject = (SparseArray)paramView.getTag(R.id.tag_accessibility_clickable_spans);
      if (localObject != null)
      {
        paramAccessibilityNodeInfo = new ArrayList();
        for (i = 0; i < ((SparseArray)localObject).size(); i++) {
          if (((WeakReference)((SparseArray)localObject).valueAt(i)).get() == null) {
            paramAccessibilityNodeInfo.add(Integer.valueOf(i));
          }
        }
        for (i = 0; i < paramAccessibilityNodeInfo.size(); i++) {
          ((SparseArray)localObject).remove(((Integer)paramAccessibilityNodeInfo.get(i)).intValue());
        }
      }
      ClickableSpan[] arrayOfClickableSpan = d.a(localCharSequence);
      if ((arrayOfClickableSpan != null) && (arrayOfClickableSpan.length > 0))
      {
        locald.a().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", R.id.accessibility_action_clickable_span);
        localObject = (SparseArray)paramView.getTag(R.id.tag_accessibility_clickable_spans);
        paramAccessibilityNodeInfo = (AccessibilityNodeInfo)localObject;
        if (localObject == null)
        {
          paramAccessibilityNodeInfo = new SparseArray();
          paramView.setTag(R.id.tag_accessibility_clickable_spans, paramAccessibilityNodeInfo);
        }
        for (i = 0; i < arrayOfClickableSpan.length; i++)
        {
          localObject = arrayOfClickableSpan[i];
          for (int j = 0; j < paramAccessibilityNodeInfo.size(); j++) {
            if (localObject.equals((ClickableSpan)((WeakReference)paramAccessibilityNodeInfo.valueAt(j)).get()))
            {
              j = paramAccessibilityNodeInfo.keyAt(j);
              break label493;
            }
          }
          j = d.d;
          d.d = j + 1;
          label493:
          paramAccessibilityNodeInfo.put(j, new WeakReference(arrayOfClickableSpan[i]));
          ClickableSpan localClickableSpan = arrayOfClickableSpan[i];
          localObject = (Spanned)localCharSequence;
          locald.a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(((Spanned)localObject).getSpanStart(localClickableSpan)));
          locald.a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(((Spanned)localObject).getSpanEnd(localClickableSpan)));
          locald.a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(((Spanned)localObject).getSpanFlags(localClickableSpan)));
          locald.a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(j));
        }
      }
    }
    paramAccessibilityNodeInfo = (List)paramView.getTag(R.id.tag_accessibility_actions);
    paramView = paramAccessibilityNodeInfo;
    if (paramAccessibilityNodeInfo == null) {
      paramView = Collections.emptyList();
    }
    for (int i = 0; i < paramView.size(); i++) {
      locald.a((d.a)paramView.get(i));
    }
  }
  
  public void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    a.a.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return a.a.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
  }
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    return a.a(paramView, paramInt, paramBundle);
  }
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    a.a.sendAccessibilityEvent(paramView, paramInt);
  }
  
  public void sendAccessibilityEventUnchecked(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    a.a.sendAccessibilityEventUnchecked(paramView, paramAccessibilityEvent);
  }
}

/* Location:
 * Qualified Name:     base.d.i.i.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */