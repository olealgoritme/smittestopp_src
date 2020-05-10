package k.b.a.z.b;

import com.android.volley.Response.Listener;
import no.simula.corona.ui.main.SettingsFragment;
import org.json.JSONObject;

public final class g<T>
  implements Response.Listener<JSONObject>
{
  public g(SettingsFragment paramSettingsFragment) {}
  
  public void onResponse(Object paramObject)
  {
    paramObject = (JSONObject)paramObject;
    SettingsFragment localSettingsFragment = x;
    i.k.b.g.a(paramObject, "response");
    SettingsFragment.a(localSettingsFragment, (JSONObject)paramObject);
  }
}

/* Location:
 * Qualified Name:     k.b.a.z.b.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */