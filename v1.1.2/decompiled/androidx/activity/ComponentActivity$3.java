package androidx.activity;

import android.app.Activity;
import d.o.e0;
import d.o.g.a;
import d.o.j;
import d.o.l;

public class ComponentActivity$3
  implements j
{
  public ComponentActivity$3(ComponentActivity paramComponentActivity) {}
  
  public void a(l paraml, g.a parama)
  {
    if ((parama == g.a.ON_DESTROY) && (!x.isChangingConfigurations())) {
      x.getViewModelStore().a();
    }
  }
}

/* Location:
 * Qualified Name:     androidx.activity.ComponentActivity.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */