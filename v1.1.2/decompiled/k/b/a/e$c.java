package k.b.a;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.android.volley.VolleyError;
import com.microsoft.appcenter.analytics.Analytics;
import e.g.a;
import e.g.a.b;
import i.k.b.g;
import k.b.a.v.c;
import org.json.JSONObject;

public final class e$c
  implements e.b
{
  public e$c(e.b paramb) {}
  
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
    e.b localb = b;
    Object localObject1 = a.i;
    if (paramJSONObject != null)
    {
      if (localObject1 != null)
      {
        Object localObject2 = (c)t.a;
        if (localObject2 != null)
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
            localObject1 = ((a)((c)localObject2).a((Context)localObject1)).edit();
            localObject2 = paramJSONObject.getString("DeviceId");
            localObject1 = (a.b)localObject1;
            ((a.b)localObject1).putString("device-id-string", (String)localObject2);
            ((SharedPreferences.Editor)localObject1).putString("host-name", paramJSONObject.getString("HostName"));
            ((SharedPreferences.Editor)localObject1).putString("access-key", paramJSONObject.getString("SharedAccessKey"));
            ((SharedPreferences.Editor)localObject1).putString("connection-data", paramJSONObject.getString("ConnectionString"));
            a.apply();
          }
          localb.a(paramJSONObject, paramBoolean);
          return;
        }
        throw null;
      }
      g.a("context");
      throw null;
    }
    g.a();
    throw null;
  }
}

/* Location:
 * Qualified Name:     k.b.a.e.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */