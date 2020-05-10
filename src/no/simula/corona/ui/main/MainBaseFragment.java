package no.simula.corona.ui.main;

import android.content.Context;
import androidx.fragment.app.Fragment;
import h.k.b.g;
import j.b.a.e0.b.b;
import no.simula.corona.ui.BaseFragment;

public class MainBaseFragment
  extends BaseFragment
{
  public b x;
  
  public void a() {}
  
  public void onAttach(Context paramContext)
  {
    if (paramContext != null)
    {
      super.onAttach(paramContext);
      if ((paramContext instanceof b)) {
        x = ((b)paramContext);
      }
      return;
    }
    g.a("context");
    throw null;
  }
}

/* Location:
 * Qualified Name:     base.no.simula.corona.ui.main.MainBaseFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */