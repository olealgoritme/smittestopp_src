package no.simula.corona.ui.onboarding;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.microsoft.appcenter.analytics.Analytics;
import d.a0.a.b;
import d.m.a.c;
import h.e;
import h.k.b.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import l.a.a.b;
import no.simula.corona.ConsentActivity;
import no.simula.corona.R.id;
import no.simula.corona.ui.register.PhoneVerificationActivity;
import no.simula.corona.ui.widgets.DotPageIndicator;
import no.simula.corona.ui.widgets.NonSlidingViewPager;

public final class OnboardingActivity
  extends j.b.a.e0.a
  implements j.b.a.e0.c.a
{
  public HashMap z;
  
  public View a(int paramInt)
  {
    if (z == null) {
      z = new HashMap();
    }
    View localView1 = (View)z.get(Integer.valueOf(paramInt));
    View localView2 = localView1;
    if (localView1 == null)
    {
      localView2 = findViewById(paramInt);
      z.put(Integer.valueOf(paramInt), localView2);
    }
    return localView2;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 2) {
      ((NonSlidingViewPager)a(R.id.viewPager)).a(paramInt1 + 1, true);
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
          Toast.makeText(this, getString(2131886179), 1).show();
        }
      }
      else
      {
        throw new e("null cannot be cast to non-null type android.net.ConnectivityManager");
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 101)
    {
      if (paramInt2 == -1)
      {
        l.a.a.d.c("Confirmed consent", new Object[0]);
        Analytics.trackEvent("Confirmed consent");
        paramIntent = getSharedPreferences("settings", 0).edit();
        paramIntent.putBoolean("consented", true);
        paramIntent.apply();
        ((NonSlidingViewPager)a(R.id.viewPager)).a(3, true);
      }
      else
      {
        Analytics.trackEvent("Denied consent");
      }
    }
    else if (paramInt1 == 102) {
      if (paramInt2 == -1)
      {
        Object localObject = (NonSlidingViewPager)a(R.id.viewPager);
        g.a(localObject, "viewPager");
        ((ViewGroup)localObject).setVisibility(8);
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
        localObject = new j.b.a.h((Application)localObject);
        if (paramIntent != null)
        {
          ((j.b.a.h)localObject).a(paramIntent, new OnboardingActivity.a(this));
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
    ((NonSlidingViewPager)a(R.id.viewPager)).setAdapter(new OnboardingActivity.b(this, getSupportFragmentManager()));
    ((DotPageIndicator)a(R.id.pageIndicator)).setTotalDots(4);
    NonSlidingViewPager localNonSlidingViewPager = (NonSlidingViewPager)a(R.id.viewPager);
    paramBundle = new OnboardingActivity.c(this);
    if (r0 == null) {
      r0 = new ArrayList();
    }
    r0.add(paramBundle);
  }
}

/* Location:
 * Qualified Name:     base.no.simula.corona.ui.onboarding.OnboardingActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */