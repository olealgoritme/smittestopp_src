package no.simula.corona.ui.main;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
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
import i.e;
import java.util.HashMap;
import k.b.a.t;
import k.b.a.z.b.f;
import k.b.a.z.b.h;
import m.a.a.b;
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
    i.k.b.g.a(localObject, "bluetoothSwith");
    ((Switch)localObject).setChecked(A);
    localObject = (Switch)a(R.id.gpsSwitch);
    i.k.b.g.a(localObject, "gpsSwitch");
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
        ((k.b.a.z.b.b)localObject).a(A ^ true);
      }
    }
    else if ((!bool) && (!A))
    {
      localObject = (Switch)a(R.id.bluetoothSwith);
      i.k.b.g.a(localObject, "bluetoothSwith");
      ((Switch)localObject).setChecked(false);
      localObject = CoronaDialog.a(2131886124, 2131886130);
      K = new k.b.a.z.b.c(this);
      ((DialogFragment)localObject).a(getChildFragmentManager(), "dialog_bt_on");
    }
  }
  
  public final void d()
  {
    Object localObject = getContext();
    if (localObject != null)
    {
      i.k.b.g.a(localObject, "context!!");
      localObject = k.b.a.v.b.a((Context)localObject);
      ((k.b.a.v.a)localObject).f();
      ((k.b.a.v.a)localObject).e();
      ((k.b.a.v.a)localObject).close();
      return;
    }
    i.k.b.g.a();
    throw null;
  }
  
  public final void e()
  {
    Object localObject = new Intent(getActivity(), SplashActivity.class);
    ((Intent)localObject).putExtra("deleted", true);
    startActivity((Intent)localObject);
    localObject = getActivity();
    if (localObject != null) {
      ((Activity)localObject).finishAffinity();
    }
  }
  
  public final void f()
  {
    m.a.a.d.b("Verification not OK -> No Delete", new Object[0]);
    Toast.makeText(getContext(), 2131886273, 1).show();
    Button localButton = (Button)a(R.id.delete_data_button);
    i.k.b.g.a(localButton, "delete_data_button");
    localButton.setText(getString(2131886249));
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
          f localf = new f(this, paramIntent, 1, "https://pubapi.prod.corona.nntb.no/permissions/revoke-consent", null, new k.b.a.z.b.g(this), new h(this));
          localf.setRetryPolicy(new DefaultRetryPolicy(10000, 0, 0.0F));
          paramIntent = E;
          if (paramIntent != null)
          {
            paramIntent.add(localf);
            m.a.a.d.b("Verification OK -> Delete", new Object[0]);
          }
          else
          {
            i.k.b.g.b("mQueue");
            throw null;
          }
        }
        else
        {
          Analytics.trackEvent("Got null token");
          f();
        }
      }
      else
      {
        if (paramInt2 == 0)
        {
          paramIntent = (Button)a(R.id.delete_data_button);
          i.k.b.g.a(paramIntent, "delete_data_button");
          paramIntent.setText(getString(2131886249));
          return;
        }
        Analytics.trackEvent("Get token error");
        f();
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
    if ((paramCompoundButton != null) && (paramCompoundButton.intValue() == 2131361944))
    {
      if (getContext() == null)
      {
        paramBoolean = false;
      }
      else
      {
        paramCompoundButton = getContext();
        if (paramCompoundButton == null) {
          break label205;
        }
        i.k.b.g.a(paramCompoundButton, "context!!");
        paramBoolean = t.a(paramCompoundButton, "android.permission.ACCESS_FINE_LOCATION");
      }
      if (!paramBoolean)
      {
        paramCompoundButton = (Switch)a(R.id.gpsSwitch);
        i.k.b.g.a(paramCompoundButton, "gpsSwitch");
        paramCompoundButton.setChecked(false);
      }
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
        i.k.b.g.a(paramCompoundButton, "gpsSwitch");
        paramCompoundButton.setChecked(false);
        paramCompoundButton = getContext();
        if (paramCompoundButton != null)
        {
          paramCompoundButton = Toast.makeText(paramCompoundButton, getString(2131886272), 1);
          paramCompoundButton.setGravity(17, 0, 0);
          paramCompoundButton.show();
        }
        else
        {
          i.k.b.g.a();
          throw null;
          label205:
          i.k.b.g.a();
          throw null;
        }
      }
    }
    else if ((paramCompoundButton != null) && (paramCompoundButton.intValue() == 2131361871))
    {
      c();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (paramLayoutInflater != null)
    {
      paramBundle = Volley.newRequestQueue(getContext());
      i.k.b.g.a(paramBundle, "Volley.newRequestQueue(context)");
      E = paramBundle;
      return paramLayoutInflater.inflate(2131558458, paramViewGroup, false);
    }
    i.k.b.g.a("inflater");
    throw null;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    if (paramView != null)
    {
      super.onViewCreated(paramView, paramBundle);
      paramView = (TextView)a(R.id.support_email);
      i.k.b.g.a(paramView, "support_email");
      paramView.setMovementMethod(LinkMovementMethod.getInstance());
      paramView = getString(2131886225);
      i.k.b.g.a(paramView, "getString(R.string.not_registered)");
      if (getContext() != null)
      {
        paramView = getContext();
        if (paramView != null)
        {
          i.k.b.g.a(paramView, "context!!");
          paramView = ((e.g.a)((k.b.a.v.c)t.a).a(paramView)).getString("phone-number", "");
          if (paramView == null) {
            paramView = "";
          }
        }
        else
        {
          i.k.b.g.a();
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
        i.k.b.g.a(paramView, "phone_number");
        paramView.setText(getString(2131886225));
      }
      else
      {
        paramBundle = (TextView)a(R.id.phone_number);
        i.k.b.g.a(paramBundle, "phone_number");
        paramBundle.setText(paramView);
      }
      paramView = (TextView)a(R.id.app_version);
      i.k.b.g.a(paramView, "app_version");
      paramView.setText("v1.1.2");
      ((Button)a(R.id.delete_data_button)).setOnClickListener(new a(0, this));
      ((Button)a(R.id.logout_button)).setOnClickListener(new a(1, this));
      F = 0;
      ((TextView)a(R.id.account)).setOnClickListener(new a(2, this));
      b();
      return;
    }
    i.k.b.g.a("view");
    throw null;
  }
  
  public static final class a
    implements View.OnClickListener
  {
    public a(int paramInt, Object paramObject) {}
    
    public final void onClick(View paramView)
    {
      int i = x;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2)
          {
            if (((SettingsFragment)jdField_this).getContext() != null)
            {
              paramView = (SettingsFragment)jdField_this;
              if (F == 4)
              {
                paramView = paramView.getContext();
                if (paramView != null)
                {
                  paramView = paramView.getSystemService("clipboard");
                  if (paramView != null)
                  {
                    ClipboardManager localClipboardManager = (ClipboardManager)paramView;
                    paramView = ((SettingsFragment)jdField_this).getContext();
                    if (paramView != null)
                    {
                      i.k.b.g.a(paramView, "context!!");
                      Object localObject = (e.g.a)((k.b.a.v.c)t.a).a(paramView);
                      paramView = "";
                      localObject = ((e.g.a)localObject).getString("device-id-string", "");
                      if (localObject != null) {
                        paramView = (View)localObject;
                      }
                      localClipboardManager.setPrimaryClip(ClipData.newPlainText(null, paramView));
                      paramView = ((SettingsFragment)jdField_this).getContext();
                      if (paramView != null)
                      {
                        Toast.makeText(paramView, "Copied device id", 0).show();
                        jdField_thisF = 0;
                        break label222;
                      }
                      i.k.b.g.a();
                      throw null;
                    }
                    i.k.b.g.a();
                    throw null;
                  }
                  throw new e("null cannot be cast to non-null type android.content.ClipboardManager");
                }
                i.k.b.g.a();
                throw null;
              }
            }
            paramView = (SettingsFragment)jdField_this;
            F += 1;
            label222:
            return;
          }
          throw null;
        }
        SettingsFragment.e((SettingsFragment)jdField_this);
        return;
      }
      SettingsFragment.b((SettingsFragment)jdField_this);
    }
  }
}

/* Location:
 * Qualified Name:     no.simula.corona.ui.main.SettingsFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */