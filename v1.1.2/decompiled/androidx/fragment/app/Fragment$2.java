package androidx.fragment.app;

import android.view.View;
import d.o.g.a;
import d.o.j;
import d.o.l;

public class Fragment$2
  implements j
{
  public Fragment$2(Fragment paramFragment) {}
  
  public void a(l paraml, g.a parama)
  {
    if (parama == g.a.ON_STOP)
    {
      paraml = x.mView;
      if (paraml != null) {
        paraml.cancelPendingInputEvents();
      }
    }
  }
}

/* Location:
 * Qualified Name:     androidx.fragment.app.Fragment.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */