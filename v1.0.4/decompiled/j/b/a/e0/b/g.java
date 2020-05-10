package j.b.a.e0.b;

import com.android.volley.Response.Listener;
import no.simula.corona.ui.main.SettingsFragment;
import org.json.JSONObject;

public final class g<T>
  implements Response.Listener<JSONObject>
{
  public g(SettingsFragment paramSettingsFragment) {}
  
  public void onResponse(Object paramObject)
  {
    JSONObject localJSONObject = (JSONObject)paramObject;
    paramObject = x;
    h.k.b.g.a(localJSONObject, "response");
    SettingsFragment.a((SettingsFragment)paramObject, localJSONObject);
  }
}

/* Location:
 * Qualified Name:     base.j.b.a.e0.b.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */