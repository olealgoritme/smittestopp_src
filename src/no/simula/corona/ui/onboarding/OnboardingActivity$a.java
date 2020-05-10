package no.simula.corona.ui.onboarding;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.android.volley.VolleyError;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;
import h.k.b.g;
import j.b.a.h.b;
import no.simula.corona.ui.dialogs.CoronaDialogInfo;
import org.json.JSONObject;

public final class OnboardingActivity$a
  implements h.b
{
  public void a(VolleyError paramVolleyError)
  {
    if (paramVolleyError != null)
    {
      Analytics.trackEvent("User failed provisioning");
      if (a.isFinishing()) {
        return;
      }
      CoronaDialogInfo localCoronaDialogInfo = new CoronaDialogInfo();
      Bundle localBundle = new Bundle();
      localBundle.putInt("title", 2131886111);
      localBundle.putInt("message", 2131886225);
      localCoronaDialogInfo.setArguments(localBundle);
      K = new OnboardingActivity.a.a(this);
      Crashes.trackError(paramVolleyError);
      OnboardingActivity.a(a);
      return;
    }
    g.a("error");
    throw null;
  }
  
  public void a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    Analytics.trackEvent("User provisioned");
    if (a.isFinishing()) {
      return;
    }
    OnboardingActivity.a(a);
  }
}

/* Location:
 * Qualified Name:     base.no.simula.corona.ui.onboarding.OnboardingActivity.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */