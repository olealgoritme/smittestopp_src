package k.b.a;

import com.android.volley.VolleyError;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.analytics.EventProperties;
import com.microsoft.appcenter.crashes.Crashes;
import i.k.b.g;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  implements e.b
{
  public void a(VolleyError paramVolleyError)
  {
    if (paramVolleyError != null)
    {
      LinkedHashMap localLinkedHashMap = new LinkedHashMap();
      localLinkedHashMap.put("where", "DataCollector retryProvisioning");
      Crashes.trackError(paramVolleyError, localLinkedHashMap, null);
      return;
    }
    g.a("error");
    throw null;
  }
  
  public void a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    paramJSONObject = new EventProperties();
    paramJSONObject.set("where", "DataCollector retryProvisioning");
    Analytics.trackEvent("Provisioned", paramJSONObject);
  }
}

/* Location:
 * Qualified Name:     k.b.a.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */