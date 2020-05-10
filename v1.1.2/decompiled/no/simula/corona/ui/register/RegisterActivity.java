package no.simula.corona.ui.register;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import d.b.a.h;
import d.m.a.c;
import d.m.a.p;
import d.m.a.x;
import i.k.b.g;
import java.util.HashMap;
import k.b.a.e;
import no.simula.corona.R.id;
import no.simula.corona.ui.onboarding.OnboardingFragment;

public final class RegisterActivity
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
          Object localObject = (FrameLayout)a(R.id.container);
          g.a(localObject, "container");
          ((FrameLayout)localObject).setVisibility(8);
          localObject = (ProgressBar)a(R.id.spinner);
          g.a(localObject, "spinner");
          ((ProgressBar)localObject).setVisibility(0);
          localObject = getApplication();
          g.a(localObject, "this.application");
          new e((Application)localObject).a(paramIntent, new k.b.a.z.d.a(this));
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
      Object localObject = getString(2131886267);
      g.a(localObject, "getString(R.string.title4)");
      paramBundle = getString(2131886245);
      g.a(paramBundle, "getString(R.string.register)");
      paramBundle = OnboardingFragment.a(3, (String)localObject, 2131886230, 2131230876, paramBundle);
      localObject = getSupportFragmentManager();
      if (localObject != null)
      {
        localObject = new d.m.a.a((p)localObject);
        g.a(localObject, "supportFragmentManager.beginTransaction()");
        ((x)localObject).a(2131361895, paramBundle, null, 1);
        ((x)localObject).a();
      }
      else
      {
        throw null;
      }
    }
  }
}

/* Location:
 * Qualified Name:     no.simula.corona.ui.register.RegisterActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */