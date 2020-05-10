package no.simula.corona.ui.onboarding;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.android.volley.VolleyError;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;
import d.b.a.h;
import d.m.a.c;
import d.m.a.p;
import d.m.a.x;
import i.k.b.g;
import java.util.HashMap;
import k.b.a.e.b;
import k.b.a.t;
import m.a.a.b;
import no.simula.corona.ConsentActivity;
import no.simula.corona.R.id;
import no.simula.corona.ui.dialogs.CoronaDialogInfo;
import no.simula.corona.ui.register.PhoneVerificationActivity;
import no.simula.corona.ui.widgets.DotPageIndicator;
import org.json.JSONObject;

public final class OnboardingActivity
  extends k.b.a.z.a
  implements k.b.a.z.c.a
{
  public HashMap A;
  
  public View a(int paramInt)
  {
    if (A == null) {
      A = new HashMap();
    }
    View localView1 = (View)A.get(Integer.valueOf(paramInt));
    View localView2 = localView1;
    if (localView1 == null)
    {
      localView2 = findViewById(paramInt);
      A.put(Integer.valueOf(paramInt), localView2);
    }
    return localView2;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 2) {
      b(paramInt1 + 1);
    }
    if (paramInt1 == 2) {
      startActivityForResult(new Intent(this, ConsentActivity.class), 101);
    }
    if (paramInt1 == 3)
    {
      boolean bool = false;
      Object localObject = getSystemService("connectivity");
      if (localObject != null)
      {
        localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
        if (localObject != null) {
          bool = ((NetworkInfo)localObject).isConnected();
        }
        if (bool) {
          startActivityForResult(new Intent(this, PhoneVerificationActivity.class), 102);
        } else {
          Toast.makeText(this, getString(2131886198), 1).show();
        }
      }
      else
      {
        throw new i.e("null cannot be cast to non-null type android.net.ConnectivityManager");
      }
    }
  }
  
  public final void b(int paramInt)
  {
    Object localObject1;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            localObject1 = getString(2131886264);
            g.a(localObject1, "context.getString(R.string.title1)");
            localObject2 = getString(2131886245);
            g.a(localObject2, "context.getString(R.string.register)");
            localObject1 = OnboardingFragment.a(paramInt, (String)localObject1, 2131886228, 2131230877, (String)localObject2);
          }
          else
          {
            localObject1 = getString(2131886267);
            g.a(localObject1, "context.getString(R.string.title4)");
            localObject2 = getString(2131886245);
            g.a(localObject2, "context.getString(R.string.register)");
            localObject1 = OnboardingFragment.a(paramInt, (String)localObject1, 2131886230, 2131230876, (String)localObject2);
          }
        }
        else
        {
          String str = getString(2131886266);
          g.a(str, "context.getString(R.string.title3)");
          localObject2 = getString(2131886244);
          g.a(localObject2, "context.getString(R.string.read_privavcy)");
          localObject1 = new PrivavcyOnboardingFragment();
          Bundle localBundle = new Bundle();
          localBundle.putString("mainText", str);
          localBundle.putInt("pageNo", paramInt);
          localBundle.putString("buttonTextRId", (String)localObject2);
          ((Fragment)localObject1).setArguments(localBundle);
        }
      }
      else
      {
        localObject1 = getString(2131886265);
        g.a(localObject1, "context.getString(R.string.title2)");
        localObject2 = getString(2131886224);
        g.a(localObject2, "context.getString(R.string.next)");
        localObject1 = OnboardingFragment.a(paramInt, (String)localObject1, 2131886229, 2131230878, (String)localObject2);
      }
    }
    else
    {
      localObject2 = getString(2131886264);
      g.a(localObject2, "context.getString(R.string.title1)");
      localObject1 = getString(2131886224);
      g.a(localObject1, "context.getString(R.string.next)");
      localObject1 = OnboardingFragment.a(paramInt, (String)localObject2, 2131886228, 2131230877, (String)localObject1);
    }
    Object localObject2 = getSupportFragmentManager();
    if (localObject2 != null)
    {
      localObject2 = new d.m.a.a((p)localObject2);
      g.a(localObject2, "supportFragmentManager.beginTransaction()");
      ((x)localObject2).a(2131361938, (Fragment)localObject1);
      ((x)localObject2).a();
      ((DotPageIndicator)a(R.id.pageIndicator)).setSelected(paramInt);
      return;
    }
    throw null;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 101)
    {
      if (paramInt2 == -1)
      {
        m.a.a.d.c("Confirmed consent", new Object[0]);
        Analytics.trackEvent("Confirmed consent");
        t.a(this, true);
        b(3);
      }
      else
      {
        Analytics.trackEvent("Denied consent");
      }
    }
    else if (paramInt1 == 102) {
      if (paramInt2 == -1)
      {
        Object localObject = (FrameLayout)a(R.id.fragmentHost);
        g.a(localObject, "fragmentHost");
        ((FrameLayout)localObject).setVisibility(8);
        localObject = (DotPageIndicator)a(R.id.pageIndicator);
        g.a(localObject, "pageIndicator");
        ((View)localObject).setVisibility(8);
        localObject = (ProgressBar)a(R.id.spinner);
        g.a(localObject, "spinner");
        ((ProgressBar)localObject).setVisibility(0);
        if (paramIntent != null) {
          paramIntent = paramIntent.getStringExtra("token");
        } else {
          paramIntent = null;
        }
        localObject = getApplication();
        g.a(localObject, "this.application");
        localObject = new k.b.a.e((Application)localObject);
        if (paramIntent != null)
        {
          ((k.b.a.e)localObject).a(paramIntent, new a(this));
        }
        else
        {
          g.a();
          throw null;
        }
      }
      else
      {
        if (paramInt2 == 0) {
          return;
        }
        l();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558430);
    ((DotPageIndicator)a(R.id.pageIndicator)).setTotalDots(4);
    b(0);
  }
  
  public static final class a
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
}

/* Location:
 * Qualified Name:     no.simula.corona.ui.onboarding.OnboardingActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */