package d.i.i;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;
import java.util.Objects;

public final class n$a
  implements View.OnApplyWindowInsetsListener
{
  public n$a(k paramk) {}
  
  public WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets)
  {
    paramWindowInsets = new w(Objects.requireNonNull(paramWindowInsets));
    return (WindowInsets)a.a(paramView, paramWindowInsets).a;
  }
}

/* Location:
 * Qualified Name:     d.i.i.n.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */