package d.i.i;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.R.id;
import d.i.i.x.d;
import d.i.i.x.d.a;
import d.i.i.x.e;
import d.i.i.x.f;
import d.i.i.x.f.a;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class a
{
  public static final View.AccessibilityDelegate c = new View.AccessibilityDelegate();
  public final View.AccessibilityDelegate a;
  public final View.AccessibilityDelegate b;
  
  public a()
  {
    a = localAccessibilityDelegate;
    b = new a(this);
  }
  
  public void a(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    a.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public void a(View paramView, d paramd)
  {
    a.onInitializeAccessibilityNodeInfo(paramView, a);
  }
  
  public boolean a(View paramView, int paramInt, Bundle paramBundle)
  {
    Object localObject1 = (List)paramView.getTag(R.id.tag_accessibility_actions);
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = Collections.emptyList();
    }
    boolean bool1 = false;
    for (int i = 0; i < ((List)localObject2).size(); i++)
    {
      d.a locala = (d.a)((List)localObject2).get(i);
      if (((AccessibilityNodeInfo.AccessibilityAction)a).getId() == paramInt)
      {
        if (c == null) {
          break;
        }
        localObject2 = null;
        localObject1 = b;
        if (localObject1 != null)
        {
          try
          {
            localObject2 = (f.a)((Class)localObject1).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            try
            {
              a = paramBundle;
            }
            catch (Exception localException1) {}
            localObject3 = b;
          }
          catch (Exception localException2)
          {
            localObject2 = null;
          }
          Object localObject3;
          if (localObject3 == null) {
            localObject3 = "null";
          } else {
            localObject3 = ((Class)localObject3).getName();
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Failed to execute command with argument class ViewCommandArgument: ");
          localStringBuilder.append((String)localObject3);
          Log.e("A11yActionCompat", localStringBuilder.toString(), localException2);
        }
        bool2 = c.a(paramView, (f.a)localObject2);
        break label227;
      }
    }
    boolean bool2 = false;
    label227:
    boolean bool3 = bool2;
    if (!bool2) {
      bool3 = a.performAccessibilityAction(paramView, paramInt, paramBundle);
    }
    bool2 = bool3;
    if (!bool3)
    {
      bool2 = bool3;
      if (paramInt == R.id.accessibility_action_clickable_span)
      {
        paramInt = paramBundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1);
        paramBundle = (SparseArray)paramView.getTag(R.id.tag_accessibility_clickable_spans);
        bool3 = bool1;
        if (paramBundle != null)
        {
          paramBundle = (WeakReference)paramBundle.get(paramInt);
          bool3 = bool1;
          if (paramBundle != null)
          {
            localObject2 = (ClickableSpan)paramBundle.get();
            if (localObject2 != null)
            {
              paramBundle = d.a(paramView.createAccessibilityNodeInfo().getText());
              for (paramInt = 0; (paramBundle != null) && (paramInt < paramBundle.length); paramInt++) {
                if (localObject2.equals(paramBundle[paramInt]))
                {
                  paramInt = 1;
                  break label373;
                }
              }
            }
            paramInt = 0;
            label373:
            bool3 = bool1;
            if (paramInt != 0)
            {
              ((ClickableSpan)localObject2).onClick(paramView);
              bool3 = true;
            }
          }
        }
        bool2 = bool3;
      }
    }
    return bool2;
  }
  
  public static final class a
    extends View.AccessibilityDelegate
  {
    public final a a;
    
    public a(a parama)
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
}

/* Location:
 * Qualified Name:     d.i.i.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */