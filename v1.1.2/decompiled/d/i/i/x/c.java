package d.i.i.x;

import android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener;
import e.c.a.b.m.d;
import e.c.a.b.m.d.a;

public final class c
  implements AccessibilityManager.TouchExplorationStateChangeListener
{
  public final b a;
  
  public c(b paramb)
  {
    a = paramb;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof c)) {
      return false;
    }
    paramObject = (c)paramObject;
    return a.equals(a);
  }
  
  public int hashCode()
  {
    return a.hashCode();
  }
  
  public void onTouchExplorationStateChanged(boolean paramBoolean)
  {
    d.a(a).a, paramBoolean);
  }
}

/* Location:
 * Qualified Name:     d.i.i.x.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */