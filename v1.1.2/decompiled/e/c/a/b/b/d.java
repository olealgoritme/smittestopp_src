package e.c.a.b.b;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.c;

public class d<V extends View>
  extends CoordinatorLayout.c<V>
{
  public e a;
  public int b = 0;
  public int c = 0;
  
  public d() {}
  
  public d(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int a()
  {
    e locale = a;
    int i;
    if (locale != null) {
      i = d;
    } else {
      i = 0;
    }
    return i;
  }
  
  public boolean a(int paramInt)
  {
    e locale = a;
    boolean bool = false;
    if (locale != null)
    {
      if (d != paramInt)
      {
        d = paramInt;
        locale.a();
        bool = true;
      }
      return bool;
    }
    b = paramInt;
    return false;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    b(paramCoordinatorLayout, paramV, paramInt);
    if (a == null) {
      a = new e(paramV);
    }
    paramCoordinatorLayout = a;
    b = a.getTop();
    c = a.getLeft();
    paramCoordinatorLayout.a();
    paramInt = b;
    if (paramInt != 0)
    {
      paramCoordinatorLayout = a;
      if (d != paramInt)
      {
        d = paramInt;
        paramCoordinatorLayout.a();
      }
      b = 0;
    }
    paramInt = c;
    if (paramInt != 0)
    {
      paramCoordinatorLayout = a;
      if (e != paramInt)
      {
        e = paramInt;
        paramCoordinatorLayout.a();
      }
      c = 0;
    }
    return true;
  }
  
  public void b(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    paramCoordinatorLayout.b(paramV, paramInt);
  }
}

/* Location:
 * Qualified Name:     e.c.a.b.b.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */