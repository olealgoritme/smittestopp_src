package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import d.o.g.a;
import d.o.j;
import d.o.l;

public class ComponentActivity$2
  implements j
{
  public ComponentActivity$2(ComponentActivity paramComponentActivity) {}
  
  public void a(l paraml, g.a parama)
  {
    if (parama == g.a.ON_STOP)
    {
      paraml = x.getWindow();
      if (paraml != null) {
        paraml = paraml.peekDecorView();
      } else {
        paraml = null;
      }
      if (paraml != null) {
        paraml.cancelPendingInputEvents();
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.androidx.activity.ComponentActivity.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */