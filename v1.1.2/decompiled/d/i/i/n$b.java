package d.i.i;

import android.os.Build.VERSION;
import android.view.View;

public abstract class n$b<T>
{
  public final int a;
  public final Class<T> b;
  public final int c;
  
  public n$b(int paramInt1, Class<T> paramClass, int paramInt2)
  {
    a = paramInt1;
    b = paramClass;
    c = paramInt2;
  }
  
  public n$b(int paramInt1, Class<T> paramClass, int paramInt2, int paramInt3)
  {
    a = paramInt1;
    b = paramClass;
    c = paramInt3;
  }
  
  public abstract T a(View paramView);
  
  public T b(View paramView)
  {
    int i;
    if (Build.VERSION.SDK_INT >= c) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return (T)a(paramView);
    }
    paramView = paramView.getTag(a);
    if (b.isInstance(paramView)) {
      return paramView;
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     d.i.i.n.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */