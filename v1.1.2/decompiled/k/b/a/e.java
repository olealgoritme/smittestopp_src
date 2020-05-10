package k.b.a;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;
import com.microsoft.azure.sdk.iot.device.DeviceClient;
import com.microsoft.azure.sdk.iot.device.InternalClient;
import com.microsoft.azure.sdk.iot.device.IotHubClientProtocol;
import com.microsoft.azure.sdk.iot.device.IotHubConnectionStatusChangeCallback;
import com.microsoft.azure.sdk.iot.device.IotHubMessageResult;
import com.microsoft.azure.sdk.iot.device.Message;
import com.microsoft.azure.sdk.iot.device.MessageCallback;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k.b.a.v.c;
import org.json.JSONObject;

public final class e
{
  public final RequestQueue a;
  public DeviceClient b;
  public boolean c;
  public boolean d;
  public boolean e;
  public String f;
  public final String g;
  public final String h;
  public final Application i;
  
  public e(Application paramApplication) {}
  
  public final void a()
  {
    if ((!c) && (!e))
    {
      Object localObject = t.a(i);
      int j;
      if (((CharSequence)localObject).length() == 0) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        m.a.a.d.b("Error: device is not provision", new Object[0]);
        return;
      }
      m.a.a.d.c("Trying to connect device", new Object[0]);
      e = true;
      try
      {
        DeviceClient localDeviceClient = new com/microsoft/azure/sdk/iot/device/DeviceClient;
        localDeviceClient.<init>((String)localObject, IotHubClientProtocol.HTTPS);
        localDeviceClient.setRetryPolicy(g.a);
        localObject = new k/b/a/f;
        ((f)localObject).<init>(this);
        localDeviceClient.registerConnectionStatusChangeCallback((IotHubConnectionStatusChangeCallback)localObject, null);
        localDeviceClient.setOperationTimeout(1000L);
        localDeviceClient.setOption("SetMinimumPollingInterval", Long.valueOf(1800000L));
        localDeviceClient.open();
        localObject = new k/b/a/e$a;
        ((a)localObject).<init>(this);
        localDeviceClient.setMessageCallback((MessageCallback)localObject, null);
        b = localDeviceClient;
      }
      catch (Exception localException)
      {
        e = false;
        b = null;
        m.a.a.d.b(localException);
        localObject = new LinkedHashMap();
        ((HashMap)localObject).put("where", "IoTHubDevice::connect");
        Crashes.trackError(localException, (Map)localObject, null);
      }
    }
  }
  
  public final void a(String paramString, final b paramb)
  {
    if (paramString != null)
    {
      if (paramb != null)
      {
        Application localApplication = i;
        if (localApplication != null)
        {
          int j;
          if (t.a(localApplication).length() == 0) {
            j = 1;
          } else {
            j = 0;
          }
          if ((j ^ 0x1) != 0) {
            paramb.a(null, true);
          }
          paramb = new c(this, paramb);
          if (d) {
            paramb.a(new VolleyError("Provisioning already started"));
          }
          m.a.a.d.c("Starting device provisioning", new Object[0]);
          d = true;
          paramString = new h(paramString, paramb, 1, "https://pubapi.prod.corona.nntb.no/onboarding/register-device", null, new i(paramb), new j(paramb));
          paramString.setRetryPolicy(new DefaultRetryPolicy(10000, 0, 0.0F));
          a.add(paramString);
          return;
        }
        i.k.b.g.a("context");
        throw null;
      }
      i.k.b.g.a("listener");
      throw null;
    }
    i.k.b.g.a("token");
    throw null;
  }
  
  public final class a
    implements MessageCallback
  {
    public IotHubMessageResult execute(Message paramMessage, Object paramObject)
    {
      if (paramMessage != null) {
        paramMessage = paramMessage.getProperty("versionAndroid");
      } else {
        paramMessage = null;
      }
      if (paramMessage == null) {
        return IotHubMessageResult.ABANDON;
      }
      if (i.o.g.a(paramMessage, new String[] { "." }, false, 0, 6).size() == 3)
      {
        a.f = paramMessage;
        return IotHubMessageResult.COMPLETE;
      }
      return IotHubMessageResult.ABANDON;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(VolleyError paramVolleyError);
    
    public abstract void a(JSONObject paramJSONObject, boolean paramBoolean);
  }
  
  public static final class c
    implements e.b
  {
    public c(e.b paramb) {}
    
    public void a(VolleyError paramVolleyError)
    {
      if (paramVolleyError != null)
      {
        paramb.a(paramVolleyError);
        return;
      }
      i.k.b.g.a("error");
      throw null;
    }
    
    public void a(JSONObject paramJSONObject, boolean paramBoolean)
    {
      e.b localb = paramb;
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
              localObject1 = ((e.g.a)((c)localObject2).a((Context)localObject1)).edit();
              localObject2 = paramJSONObject.getString("DeviceId");
              localObject1 = (e.g.a.b)localObject1;
              ((e.g.a.b)localObject1).putString("device-id-string", (String)localObject2);
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
        i.k.b.g.a("context");
        throw null;
      }
      i.k.b.g.a();
      throw null;
    }
  }
}

/* Location:
 * Qualified Name:     k.b.a.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */