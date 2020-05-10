package no.simula.corona.ui.register;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;
import com.microsoft.identity.client.AuthenticationCallback;
import com.microsoft.identity.client.IAuthenticationResult;
import com.microsoft.identity.client.exception.MsalException;
import h.k.b.k;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import l.a.a.b;
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
    l.a.a.d.a((String)localObject, new Object[0]);
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
      h.k.b.g.a(localObject1, "longLivingApp");
      Object localObject2 = paramIAuthenticationResult.getAccessToken();
      h.k.b.g.a(localObject2, "result.accessToken");
      localObject2 = h.o.g.a((CharSequence)localObject2, new String[] { "." }, false, 0, 6);
      if (((List)localObject2).size() == 3) {
        try
        {
          Object localObject3 = Base64.decode((String)((List)localObject2).get(1), 2);
          h.k.b.g.a(localObject3, "Base64.decode(parts[1], Base64.NO_WRAP)");
          Charset localCharset = h.o.a.a;
          localObject2 = new java/lang/String;
          ((String)localObject2).<init>((byte[])localObject3, localCharset);
          localObject3 = new org/json/JSONObject;
          ((JSONObject)localObject3).<init>((String)localObject2);
          if (((JSONObject)localObject3).has("signInNames.phoneNumber"))
          {
            localObject2 = ((JSONObject)localObject3).getString("signInNames.phoneNumber");
            h.k.b.g.a(localObject2, "phone.getString(\"signInNames.phoneNumber\")");
            localObject1 = ((Context)localObject1).getSharedPreferences("settings", 0).edit();
            ((SharedPreferences.Editor)localObject1).putString("phone-number", (String)localObject2);
            ((SharedPreferences.Editor)localObject1).apply();
          }
        }
        catch (Exception localException)
        {
          localObject2 = new LinkedHashMap();
          ((HashMap)localObject2).put("where", "storePhoneNumber");
          Crashes.trackError(localException, (Map)localObject2, null);
        }
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("token", paramIAuthenticationResult.getAccessToken());
      localObject2 = (Application)b.x;
      h.k.b.g.a(localObject2, "longLivingApp");
      paramIAuthenticationResult = paramIAuthenticationResult.getAccessToken();
      h.k.b.g.a(paramIAuthenticationResult, "result.accessToken");
      localObject2 = ((Context)localObject2).getSharedPreferences("settings", 0).edit();
      ((SharedPreferences.Editor)localObject2).putString("token", paramIAuthenticationResult);
      ((SharedPreferences.Editor)localObject2).putLong("timestamp", System.currentTimeMillis());
      ((SharedPreferences.Editor)localObject2).apply();
      a.setResult(-1, localIntent);
    }
    a.finish();
    a.overridePendingTransition(0, 0);
  }
}

/* Location:
 * Qualified Name:     base.no.simula.corona.ui.register.PhoneVerificationActivity.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */