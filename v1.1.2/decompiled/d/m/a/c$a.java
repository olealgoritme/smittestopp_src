package d.m.a;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import d.o.e0;
import d.o.f0;
import d.o.g;

public class c$a
  extends m<c>
  implements f0, d.a.c
{
  public c$a(c paramc)
  {
    super(paramc);
  }
  
  public View a(int paramInt)
  {
    return B.findViewById(paramInt);
  }
  
  public boolean a()
  {
    Window localWindow = B.getWindow();
    boolean bool;
    if ((localWindow != null) && (localWindow.peekDecorView() != null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public g getLifecycle()
  {
    return B.mFragmentLifecycleRegistry;
  }
  
  public OnBackPressedDispatcher getOnBackPressedDispatcher()
  {
    return B.getOnBackPressedDispatcher();
  }
  
  public e0 getViewModelStore()
  {
    return B.getViewModelStore();
  }
}

/* Location:
 * Qualified Name:     d.m.a.c.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */