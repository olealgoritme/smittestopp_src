package j.b.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.android.volley.VolleyError;
import com.microsoft.appcenter.analytics.Analytics;
import h.k.b.g;
import org.json.JSONObject;

public final class h$c
  implements h.b
{
  public h$c(h.b paramb) {}
  
  public void a(VolleyError paramVolleyError)
  {
    if (paramVolleyError != null)
    {
      b.a(paramVolleyError);
      return;
    }
    g.a("error");
    throw null;
  }
  
  public void a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    h.b localb = b;
    Object localObject = a.i;
    if (paramJSONObject != null)
    {
      if (localObject != null)
      {
        boolean bool = paramJSONObject.has("DeviceId");
        paramBoolean = true;
        if ((bool ^ true | paramJSONObject.has("HostName") ^ true | paramJSONObject.has("SharedAccessKey") ^ true | paramJSONObject.has("ConnectionString") ^ true))
        {
          Analytics.trackEvent("Invalid provision response");
          paramBoolean = false;
        }
        else
        {
          localObject = ((Context)localObject).getSharedPreferences("settings", 0).edit();
          ((SharedPreferences.Editor)localObject).putString("device-id-string", paramJSONObject.getString("DeviceId"));
          ((SharedPreferences.Editor)localObject).putString("host-name", paramJSONObject.getString("HostName"));
          ((SharedPreferences.Editor)localObject).putString("access-key", paramJSONObject.getString("SharedAccessKey"));
          ((SharedPreferences.Editor)localObject).putString("connection-data", paramJSONObject.getString("ConnectionString"));
          ((SharedPreferences.Editor)localObject).apply();
        }
        localb.a(paramJSONObject, paramBoolean);
        return;
      }
      g.a("context");
      throw null;
    }
    g.a();
    throw null;
  }
}