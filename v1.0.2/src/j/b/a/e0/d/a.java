package j.b.a.e0.d;

import com.android.volley.VolleyError;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;
import h.k.b.g;
import j.b.a.h.b;
import java.util.LinkedHashMap;
import java.util.Map;
import no.simula.corona.ui.register.RegisterActivity;
import org.json.JSONObject;

public final class a
  implements h.b
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
 * Qualified Name:     base.j.b.a.e0.d.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */