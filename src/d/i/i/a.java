package d.i.i;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import androidx.core.R.id;
import d.i.i.x.d;
import d.i.i.x.d.a;
import d.i.i.x.f;
import d.i.i.x.f.a;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
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
    b = new a.a(this);
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
        localObject1 = b;
        localObject2 = null;
        if (localObject1 != null)
        {
          try
          {
            localObject2 = (f.a)((Class)localObject1).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (localObject2 != null) {
              break label201;
            }
            try
            {
              throw null;
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
        label201:
        bool2 = c.a(paramView, (f.a)localObject2);
        break label228;
      }
    }
    boolean bool2 = false;
    label228:
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
                  break label374;
                }
              }
            }
            paramInt = 0;
            label374:
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
}

/* Location:
 * Qualified Name:     base.d.i.i.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */