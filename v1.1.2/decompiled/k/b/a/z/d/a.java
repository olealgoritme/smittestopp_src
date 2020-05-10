package k.b.a.z.d;

import com.android.volley.VolleyError;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;
import i.k.b.g;
import java.util.LinkedHashMap;
import java.util.Map;
import k.b.a.e.b;
import no.simula.corona.ui.register.RegisterActivity;
import org.json.JSONObject;

public final class a
  implements e.b
{
  public void a(VolleyError paramVolleyError)
  {
    if (paramVolleyError != null)
    {
      LinkedHashMap localLinkedHashMap = new LinkedHashMap();
      localLinkedHashMap.put("where", "PostPhoneVerProvision");
      Crashes.trackError(paramVolleyError, localLinkedHashMap, null);
      RegisterActivity.a(a);
      return;
    }
    g.a("error");
    throw null;
  }
  
  public void a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    Analytics.trackEvent("User provisioned");
    RegisterActivity.a(a);
  }
}

/* Location:
 * Qualified Name:     k.b.a.z.d.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */