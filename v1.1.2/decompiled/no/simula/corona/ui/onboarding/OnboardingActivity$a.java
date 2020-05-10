package no.simula.corona.ui.onboarding;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.android.volley.VolleyError;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;
import i.k.b.g;
import k.b.a.e.b;
import no.simula.corona.ui.dialogs.CoronaDialogInfo;
import org.json.JSONObject;

public final class OnboardingActivity$a
  implements e.b
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
      localBundle.putInt("title", 2131886124);
      localBundle.putInt("message", 2131886257);
      localCoronaDialogInfo.setArguments(localBundle);
      K = new a(this);
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
  
  public static final class a
    implements DialogInterface.OnClickListener
  {
    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      OnboardingActivity.a(x.a);
    }
  }
}

/* Location:
 * Qualified Name:     no.simula.corona.ui.onboarding.OnboardingActivity.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */