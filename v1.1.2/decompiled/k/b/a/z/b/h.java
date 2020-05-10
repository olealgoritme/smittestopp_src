package k.b.a.z.b;

import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import i.k.b.g;
import no.simula.corona.ui.main.SettingsFragment;

public final class h
  implements Response.ErrorListener
{
  public h(SettingsFragment paramSettingsFragment) {}
  
  public final void onErrorResponse(VolleyError paramVolleyError)
  {
    SettingsFragment localSettingsFragment = x;
    g.a(paramVolleyError, "error");
    SettingsFragment.a(localSettingsFragment, paramVolleyError);
  }
}

/* Location:
 * Qualified Name:     k.b.a.z.b.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */