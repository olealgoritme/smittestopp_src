package no.simula.corona.ui.main;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import h.e;
import h.k.b.g;
import j.b.a.c0.a;
import j.b.a.c0.d;
import k.d.a.m;
import org.greenrobot.eventbus.ThreadMode;

public class ControlFragmentBase
  extends MainBaseFragment
{
  public boolean A;
  public boolean B;
  public boolean y;
  public boolean z;
  
  public void a() {}
  
  public void b() {}
  
  @m(sticky=true, threadMode=ThreadMode.MAIN)
  public final void onEvent(a parama)
  {
    if (parama != null)
    {
      if (!a) {
        A = false;
      }
      y = a;
      b();
      return;
    }
    g.a("event");
    throw null;
  }
  
  @m(sticky=true, threadMode=ThreadMode.MAIN)
  public final void onEvent(j.b.a.c0.b paramb)
  {
    if (paramb != null)
    {
      A = a;
      b();
      return;
    }
    g.a("event");
    throw null;
  }
  
  @m(sticky=true, threadMode=ThreadMode.MAIN)
  public final void onEvent(j.b.a.c0.c paramc)
  {
    if (paramc != null)
    {
      B = a;
      b();
      return;
    }
    g.a("event");
    throw null;
  }
  
  @m(sticky=true, threadMode=ThreadMode.MAIN)
  public final void onEvent(d paramd)
  {
    if (paramd != null)
    {
      if (!a) {
        B = false;
      }
      z = a;
      b();
      return;
    }
    g.a("event");
    throw null;
  }
  
  public void onStart()
  {
    super.onStart();
    k.d.a.c.b().b(this);
  }
  
  public void onStop()
  {
    super.onStop();
    k.d.a.c.b().c(this);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    Object localObject = null;
    if (paramView != null)
    {
      super.onViewCreated(paramView, paramBundle);
      paramView = x;
      if (paramView != null) {
        paramView = paramView.b();
      } else {
        paramView = null;
      }
      A = g.a(paramView, Boolean.valueOf(true));
      paramView = x;
      if (paramView != null) {
        paramView = paramView.i();
      } else {
        paramView = null;
      }
      B = g.a(paramView, Boolean.valueOf(true));
      paramView = getContext();
      if (paramView != null) {
        paramView = paramView.getSystemService("bluetooth");
      } else {
        paramView = null;
      }
      if (paramView != null)
      {
        paramView = ((BluetoothManager)paramView).getAdapter();
        boolean bool;
        if (paramView != null) {
          bool = paramView.isEnabled();
        } else {
          bool = false;
        }
        y = bool;
        paramBundle = getContext();
        paramView = (View)localObject;
        if (paramBundle != null) {
          paramView = paramBundle.getSystemService("location");
        }
        if (paramView != null)
        {
          z = ((LocationManager)paramView).isProviderEnabled("gps");
          return;
        }
        throw new e("null cannot be cast to non-null type android.location.LocationManager");
      }
      throw new e("null cannot be cast to non-null type android.bluetooth.BluetoothManager");
    }
    g.a("view");
    throw null;
  }
}

/* Location:
 * Qualified Name:     base.no.simula.corona.ui.main.ControlFragmentBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */