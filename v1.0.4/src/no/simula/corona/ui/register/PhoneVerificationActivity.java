package no.simula.corona.ui.register;

import android.app.Activity;
import android.os.Bundle;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;
import com.microsoft.identity.client.AuthenticationCallback;
import com.microsoft.identity.client.IPublicClientApplication;
import com.microsoft.identity.client.IPublicClientApplication.ApplicationCreatedListener;
import com.microsoft.identity.client.PublicClientApplication;
import com.microsoft.identity.client.exception.MsalException;
import d.b.a.h;
import h.k.b.k;
import java.util.LinkedHashMap;
import java.util.Map;
import l.a.a;
import l.a.a.b;

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
    Object localObject = new k();
    x = getApplication();
    if (paramIPublicClientApplication != null)
    {
      localObject = new PhoneVerificationActivity.a(this, (k)localObject);
      paramIPublicClientApplication.acquireToken(this, new String[] { "https://smittestopp.onmicrosoft.com/backend/Device.Write" }, (AuthenticationCallback)localObject);
    }
  }
  
  public void onError(MsalException paramMsalException)
  {
    Object localObject = String.valueOf(paramMsalException);
    a.d.a((String)localObject, new Object[0]);
    localObject = new LinkedHashMap();
    ((Map)localObject).put("where", "createMsAuthAppError");
    Crashes.trackError(paramMsalException, (Map)localObject, null);
    finish();
    overridePendingTransition(0, 0);
  }
}

/* Location:
 * Qualified Name:     base.no.simula.corona.ui.register.PhoneVerificationActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */