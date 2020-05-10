package d.i.i;

import android.view.WindowInsets;
import java.util.Objects;

public class w
{
  public final Object a;
  
  public w(Object paramObject)
  {
    a = paramObject;
  }
  
  public int a()
  {
    return ((WindowInsets)a).getSystemWindowInsetBottom();
  }
  
  public int b()
  {
    return ((WindowInsets)a).getSystemWindowInsetLeft();
  }
  
  public int c()
  {
    return ((WindowInsets)a).getSystemWindowInsetRight();
  }
  
  public int d()
  {
    return ((WindowInsets)a).getSystemWindowInsetTop();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof w)) {
      return false;
    }
    paramObject = (w)paramObject;
    return Objects.equals(a, a);
  }
  
  public int hashCode()
  {
    Object localObject = a;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = localObject.hashCode();
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     d.i.i.w
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */