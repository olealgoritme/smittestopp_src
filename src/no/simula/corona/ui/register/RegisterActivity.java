package no.simula.corona.ui.register;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import d.m.a.c;
import d.m.a.p;
import d.m.a.y;
import h.k.b.g;
import no.simula.corona.ui.onboarding.OnboardingFragment;

public final class RegisterActivity
  extends j.b.a.e0.a
  implements j.b.a.e0.c.a
{
  public void a(int paramInt1, int paramInt2)
  {
    startActivityForResult(new Intent(this, PhoneVerificationActivity.class), 102);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 102) {
      if (paramInt2 != -1)
      {
        if (paramInt2 != 0) {
          l();
        }
      }
      else
      {
        if (paramIntent != null) {
          paramIntent = paramIntent.getStringExtra("token");
        } else {
          paramIntent = null;
        }
        if (paramIntent != null)
        {
          Application localApplication = getApplication();
          g.a(localApplication, "this.application");
          new j.b.a.h(localApplication).a(paramIntent, new j.b.a.e0.d.a(this));
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558432);
    if (paramBundle == null)
    {
      Object localObject = getString(2131886235);
      g.a(localObject, "getString(R.string.title4)");
      paramBundle = getString(2131886214);
      g.a(paramBundle, "getString(R.string.register)");
      paramBundle = OnboardingFragment.a(3, (String)localObject, 2131886199, 2131230887, paramBundle);
      localObject = getSupportFragmentManager();
      if (localObject != null)
      {
        localObject = new d.m.a.a((p)localObject);
        g.a(localObject, "supportFragmentManager.beginTransaction()");
        ((y)localObject).a(2131361895, paramBundle, null, 1);
        ((y)localObject).a();
      }
      else
      {
        throw null;
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.no.simula.corona.ui.register.RegisterActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */