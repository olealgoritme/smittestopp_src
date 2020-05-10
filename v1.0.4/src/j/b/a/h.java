package j.b.a;

import android.app.Application;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.microsoft.appcenter.crashes.Crashes;
import com.microsoft.azure.sdk.iot.device.DeviceClient;
import com.microsoft.azure.sdk.iot.device.InternalClient;
import com.microsoft.azure.sdk.iot.device.IotHubClientProtocol;
import com.microsoft.azure.sdk.iot.device.IotHubConnectionStatusChangeCallback;
import com.microsoft.azure.sdk.iot.device.MessageCallback;
import h.k.b.g;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import l.a.a;
import l.a.a.b;

public final class h
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
  
  public h(Application paramApplication) {}
  
  public final void a()
  {
    if ((!c) && (!e))
    {
      Object localObject = a0.a(i);
      int j;
      if (((CharSequence)localObject).length() == 0) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        a.d.b("Error: device is not provision", new Object[0]);
        return;
      }
      a.d.c("Trying to connect device", new Object[0]);
      e = true;
      try
      {
        DeviceClient localDeviceClient = new com/microsoft/azure/sdk/iot/device/DeviceClient;
        localDeviceClient.<init>((String)localObject, IotHubClientProtocol.HTTPS);
        localDeviceClient.setRetryPolicy(j.a);
        localObject = new j/b/a/i;
        ((i)localObject).<init>(this);
        localDeviceClient.registerConnectionStatusChangeCallback((IotHubConnectionStatusChangeCallback)localObject, null);
        localDeviceClient.setOperationTimeout(1000L);
        localDeviceClient.setOption("SetMinimumPollingInterval", Long.valueOf(1800000L));
        localDeviceClient.open();
        localObject = new j/b/a/h$a;
        ((h.a)localObject).<init>(this);
        localDeviceClient.setMessageCallback((MessageCallback)localObject, null);
        b = localDeviceClient;
      }
      catch (Exception localException)
      {
        e = false;
        b = null;
        a.d.a(localException);
        localObject = new LinkedHashMap();
        ((HashMap)localObject).put("where", "IoTHubDevice::connect");
        Crashes.trackError(localException, (Map)localObject, null);
      }
    }
  }
  
  public final void a(String paramString, h.b paramb)
  {
    if (paramString != null)
    {
      if (paramb != null)
      {
        Application localApplication = i;
        if (localApplication != null)
        {
          int j;
          if (a0.a(localApplication).length() == 0) {
            j = 1;
          } else {
            j = 0;
          }
          if ((j ^ 0x1) != 0) {
            paramb.a(null, true);
          }
          paramb = new h.c(this, paramb);
          if (d) {
            paramb.a(new VolleyError("Provisioning already started"));
          }
          a.d.c("Starting device provisioning", new Object[0]);
          d = true;
          paramString = new k(paramString, paramb, 1, "https://api-smittestopp-prod.azure-api.net/onboarding/register-device", null, new l(paramb), new m(paramb));
          paramString.setRetryPolicy(new DefaultRetryPolicy(10000, 0, 0.0F));
          a.add(paramString);
          return;
        }
        g.a("context");
        throw null;
      }
      g.a("listener");
      throw null;
    }
    g.a("token");
    throw null;
  }
}

/* Location:
 * Qualified Name:     base.j.b.a.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */