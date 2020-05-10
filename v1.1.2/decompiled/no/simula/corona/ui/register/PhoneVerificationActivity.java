package no.simula.corona.ui.register;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Base64;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;
import com.microsoft.identity.client.AuthenticationCallback;
import com.microsoft.identity.client.IAuthenticationResult;
import com.microsoft.identity.client.IPublicClientApplication;
import com.microsoft.identity.client.IPublicClientApplication.ApplicationCreatedListener;
import com.microsoft.identity.client.PublicClientApplication;
import com.microsoft.identity.client.exception.MsalException;
import d.b.a.h;
import i.k.b.k;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k.b.a.t;
import k.b.a.v.c;
import org.json.JSONObject;

public final class PhoneVerificationActivity
  extends h
  implements IPublicClientApplication.ApplicationCreatedListener
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558431);
    Analytics.trackEvent("Verify Phone Number");
    setResult(0);
    PublicClientApplication.create(getApplicationContext(), "f427f831-60ae-4ea3-9de6-11977b46cf01", "https://smittestopp.b2clogin.com/tfp/smittestopp.onmicrosoft.com/B2C_1A_phone_SUSI", "msauthsimulasmittestopp://something/somethingelse", this);
  }
  
  public void onCreated(IPublicClientApplication paramIPublicClientApplication)
  {
    Analytics.trackEvent("Start Acquire Token");
    final Object localObject = new k();
    x = getApplication();
    if (paramIPublicClientApplication != null)
    {
      localObject = new a(this, (k)localObject);
      paramIPublicClientApplication.acquireToken(this, new String[] { "https://smittestopp.onmicrosoft.com/backend/Device.Write" }, (AuthenticationCallback)localObject);
    }
  }
  
  public void onError(MsalException paramMsalException)
  {
    Object localObject = String.valueOf(paramMsalException);
    m.a.a.d.a((String)localObject, new Object[0]);
    localObject = new LinkedHashMap();
    ((Map)localObject).put("where", "createMsAuthAppError");
    Crashes.trackError(paramMsalException, (Map)localObject, null);
    finish();
    overridePendingTransition(0, 0);
  }
  
  public static final class a
    implements AuthenticationCallback
  {
    public a(k paramk) {}
    
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
        Object localObject1 = (Application)localObjectx;
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
          localObject3 = (Application)localObjectx;
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
}

/* Location:
 * Qualified Name:     no.simula.corona.ui.register.PhoneVerificationActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */