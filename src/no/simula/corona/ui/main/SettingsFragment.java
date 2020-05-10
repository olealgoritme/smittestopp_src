package no.simula.corona.ui.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.microsoft.appcenter.analytics.Analytics;
import j.b.a.e0.b.b;
import j.b.a.e0.b.c;
import j.b.a.e0.b.f;
import j.b.a.e0.b.h;
import java.util.HashMap;
import l.a.a;
import l.a.a.b;
import no.simula.corona.R.id;
import no.simula.corona.SplashActivity;
import no.simula.corona.ui.dialogs.CoronaDialog;

public final class SettingsFragment
  extends ControlFragmentBase
  implements CompoundButton.OnCheckedChangeListener
{
  public final int C = 21;
  public final int D = 123;
  public RequestQueue E;
  public int F;
  public HashMap G;
  
  public View a(int paramInt)
  {
    if (G == null) {
      G = new HashMap();
    }
    View localView1 = (View)G.get(Integer.valueOf(paramInt));
    View localView2 = localView1;
    if (localView1 == null)
    {
      localView2 = getView();
      if (localView2 == null) {
        return null;
      }
      localView2 = localView2.findViewById(paramInt);
      G.put(Integer.valueOf(paramInt), localView2);
    }
    return localView2;
  }
  
  public void a()
  {
    HashMap localHashMap = G;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public void b()
  {
    Object localObject = getActivity();
    if ((localObject != null) && (((Activity)localObject).isFinishing() == true)) {
      return;
    }
    ((Switch)a(R.id.bluetoothSwith)).setOnCheckedChangeListener(null);
    ((Switch)a(R.id.gpsSwitch)).setOnCheckedChangeListener(null);
    localObject = (Switch)a(R.id.bluetoothSwith);
    h.k.b.g.a(localObject, "bluetoothSwith");
    ((Switch)localObject).setChecked(A);
    localObject = (Switch)a(R.id.gpsSwitch);
    h.k.b.g.a(localObject, "gpsSwitch");
    ((Switch)localObject).setChecked(B);
    ((Switch)a(R.id.bluetoothSwith)).setOnCheckedChangeListener(this);
    ((Switch)a(R.id.gpsSwitch)).setOnCheckedChangeListener(this);
  }
  
  public final void c()
  {
    boolean bool = y;
    Object localObject;
    if (bool)
    {
      localObject = x;
      if (localObject != null) {
        ((b)localObject).a(A ^ true);
      }
    }
    else if ((!bool) && (!A))
    {
      localObject = (Switch)a(R.id.bluetoothSwith);
      h.k.b.g.a(localObject, "bluetoothSwith");
      ((Switch)localObject).setChecked(false);
      localObject = CoronaDialog.a(2131886111, 2131886116);
      K = new c(this);
      ((DialogFragment)localObject).a(getChildFragmentManager(), "dialog_bt_on");
    }
  }
  
  public final void d()
  {
    Intent intent = new Intent(getActivity(), SplashActivity.class);
    ((Intent) intent).putExtra("deleted", true);
    startActivity((Intent)intent);
    localObject = getActivity();
    if (localObject != null) {
      ((Activity)localObject).finishAffinity();
    }
  }
  
  public final void e()
  {
    a.d.b("Verification not OK -> No Delete", new Object[0]);
    Toast.makeText(getContext(), 2131886241, 1).show();
    Button localButton = (Button)a(R.id.delete_data_button);
    h.k.b.g.a(localButton, "delete_data_button");
    localButton.setText(getString(2131886219));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == D)
    {
      if (paramInt2 == -1)
      {
        if (paramIntent != null) {
          paramIntent = paramIntent.getStringExtra("token");
        } else {
          paramIntent = null;
        }
        if (paramIntent != null)
        {
          paramIntent = new f(this, paramIntent, 1, "https://api-smittestopp-prod.azure-api.net/permissions/revoke-consent", null, new j.b.a.e0.b.g(this), new h(this));
          paramIntent.setRetryPolicy(new DefaultRetryPolicy(10000, 0, 0.0F));
          RequestQueue localRequestQueue = E;
          if (localRequestQueue != null)
          {
            localRequestQueue.add(paramIntent);
            a.d.b("Verification OK -> Delete", new Object[0]);
          }
          else
          {
            h.k.b.g.b("mQueue");
            throw null;
          }
        }
        else
        {
          Analytics.trackEvent("Got null token");
          e();
        }
      }
      else
      {
        if (paramInt2 == 0)
        {
          paramIntent = (Button)a(R.id.delete_data_button);
          h.k.b.g.a(paramIntent, "delete_data_button");
          paramIntent.setText(getString(2131886219));
          return;
        }
        Analytics.trackEvent("Get token error");
        e();
      }
      return;
    }
    if (paramInt1 == C) {
      c();
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton != null) {
      paramCompoundButton = Integer.valueOf(paramCompoundButton.getId());
    } else {
      paramCompoundButton = null;
    }
    if ((paramCompoundButton != null) && (paramCompoundButton.intValue() == 2131361942))
    {
      paramBoolean = z;
      if (paramBoolean)
      {
        paramCompoundButton = x;
        if (paramCompoundButton != null) {
          paramCompoundButton.b(B ^ true);
        }
      }
      else if ((!paramBoolean) && (!B))
      {
        paramCompoundButton = (Switch)a(R.id.gpsSwitch);
        h.k.b.g.a(paramCompoundButton, "gpsSwitch");
        paramCompoundButton.setChecked(false);
        paramCompoundButton = getContext();
        if (paramCompoundButton != null)
        {
          paramCompoundButton = Toast.makeText(paramCompoundButton, getString(2131886240), 1);
          paramCompoundButton.setGravity(17, 0, 0);
          paramCompoundButton.show();
        }
        else
        {
          h.k.b.g.a();
          throw null;
        }
      }
    }
    else if ((paramCompoundButton != null) && (paramCompoundButton.intValue() == 2131361870))
    {
      c();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (paramLayoutInflater != null)
    {
      paramBundle = Volley.newRequestQueue(getContext());
      h.k.b.g.a(paramBundle, "Volley.newRequestQueue(context)");
      E = paramBundle;
      return paramLayoutInflater.inflate(2131558458, paramViewGroup, false);
    }
    h.k.b.g.a("inflater");
    throw null;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    if (paramView != null)
    {
      super.onViewCreated(paramView, paramBundle);
      paramView = (TextView)a(R.id.support_email);
      h.k.b.g.a(paramView, "support_email");
      paramView.setMovementMethod(LinkMovementMethod.getInstance());
      paramView = getString(2131886194);
      h.k.b.g.a(paramView, "getString(R.string.not_registered)");
      if (getContext() != null)
      {
        paramView = getContext();
        if (paramView != null)
        {
          h.k.b.g.a(paramView, "context!!");
          paramView = paramView.getSharedPreferences("settings", 0).getString("phone-number", "");
          if (paramView == null) {
            paramView = "";
          }
        }
        else
        {
          h.k.b.g.a();
          throw null;
        }
      }
      int i;
      if (paramView.length() == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        paramView = (TextView)a(R.id.phone_number);
        h.k.b.g.a(paramView, "phone_number");
        paramView.setText(getString(2131886194));
      }
      else
      {
        paramBundle = (TextView)a(R.id.phone_number);
        h.k.b.g.a(paramBundle, "phone_number");
        paramBundle.setText(paramView);
      }
      paramView = (TextView)a(R.id.app_version);
      h.k.b.g.a(paramView, "app_version");
      paramView.setText("v1.0.2");
      ((Button)a(R.id.delete_data_button)).setOnClickListener(new SettingsFragment.a(0, this));
      ((Button)a(R.id.logout_button)).setOnClickListener(new SettingsFragment.a(1, this));
      F = 0;
      ((TextView)a(R.id.account)).setOnClickListener(new SettingsFragment.a(2, this));
      b();
      return;
    }
    h.k.b.g.a("view");
    throw null;
  }
}

/* Location:
 * Qualified Name:     base.no.simula.corona.ui.main.SettingsFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */