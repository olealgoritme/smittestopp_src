package d.i.i.x;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

public final class a
  extends ClickableSpan
{
  public final int x;
  public final d y;
  public final int z;
  
  public a(int paramInt1, d paramd, int paramInt2)
  {
    x = paramInt1;
    y = paramd;
    z = paramInt2;
  }
  
  public void onClick(View paramView)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", x);
    paramView = y;
    int i = z;
    a.performAction(i, localBundle);
  }
}

/* Location:
 * Qualified Name:     d.i.i.x.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */