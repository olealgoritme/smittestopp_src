package no.simula.corona.ui.register;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;
import com.microsoft.identity.client.AuthenticationCallback;
import com.microsoft.identity.client.IAuthenticationResult;
import com.microsoft.identity.client.exception.MsalException;
import i.k.b.k;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k.b.a.t;
import k.b.a.v.c;
import org.json.JSONObject;

public final class PhoneVerificationActivity$a
  implements AuthenticationCallback
{
  public PhoneVerificationActivity$a(k paramk) {}
  
  public void onCancel()
  {
    Analytics.trackEvent("Acquire Token Cancelled");
    a.setResult(0);
    a.finish();
    a.overridePendingTransition(0, 0);
  }
  
  public void onError(MsalException paramMsalException)
  {
    Object localObject = String.valueOf(paramMsalException);
    m.a.a.d.a((String)localObject, new Object[0]);
    localObject = new LinkedHashMap();
    ((Map)localObject).put("where", "PhoneVerAcquireToken");
    Crashes.trackError(paramMsalException, (Map)localObject, null);
    a.finish();
    a.overridePendingTransition(0, 0);
  }
  
  public void onSuccess(IAuthenticationResult paramIAuthenticationResult)
  {
    Analytics.trackEvent("Acquired token");
    if (paramIAuthenticationResult != null)
    {
      Object localObject1 = (Application)b.x;
      i.k.b.g.a(localObject1, "longLivingApp");
      Object localObject2 = paramIAuthenticationResult.getAccessToken();
      i.k.b.g.a(localObject2, "result.accessToken");
      Object localObject3 = (c)t.a;
      if (localObject3 != null)
      {
        localObject2 = i.o.g.a((CharSequence)localObject2, new String[] { "." }, false, 0, 6);
        if (((List)localObject2).size() == 3) {
          try
          {
            Object localObject4 = Base64.decode((String)((List)localObject2).get(1), 2);
            i.k.b.g.a(localObject4, "Base64.decode(parts[1], Base64.NO_WRAP)");
            Charset localCharset = i.o.a.a;
            localObject2 = new java/lang/String;
            ((String)localObject2).<init>((byte[])localObject4, localCharset);
            localObject4 = new org/json/JSONObject;
            ((JSONObject)localObject4).<init>((String)localObject2);
            if (((JSONObject)localObject4).has("signInNames.phoneNumber"))
            {
              localObject2 = ((JSONObject)localObject4).getString("signInNames.phoneNumber");
              i.k.b.g.a(localObject2, "phone.getString(\"signInNames.phoneNumber\")");
              localObject1 = (e.g.a.b)((e.g.a)((c)localObject3).a((Context)localObject1)).edit();
              ((e.g.a.b)localObject1).putString("phone-number", (String)localObject2);
              a.apply();
            }
          }
          catch (Exception localException)
          {
            localObject3 = new LinkedHashMap();
            ((HashMap)localObject3).put("where", "storePhoneNumber");
            Crashes.trackError(localException, (Map)localObject3, null);
          }
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("token", paramIAuthenticationResult.getAccessToken());
        localObject3 = (Application)b.x;
        i.k.b.g.a(localObject3, "longLivingApp");
        paramIAuthenticationResult = paramIAuthenticationResult.getAccessToken();
        i.k.b.g.a(paramIAuthenticationResult, "result.accessToken");
        localObject3 = (e.g.a.b)((e.g.a)((c)t.a).a((Context)localObject3)).edit();
        ((e.g.a.b)localObject3).putString("token", paramIAuthenticationResult);
        ((SharedPreferences.Editor)localObject3).putLong("timestamp", System.currentTimeMillis());
        a.apply();
        a.setResult(-1, localIntent);
      }
      else
      {
        throw null;
      }
    }
    a.finish();
    a.overridePendingTransition(0, 0);
  }
}

/* Location:
 * Qualified Name:     no.simula.corona.ui.register.PhoneVerificationActivity.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */