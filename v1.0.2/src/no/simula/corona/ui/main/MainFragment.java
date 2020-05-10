package no.simula.corona.ui.main;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import h.e;
import h.k.b.g;
import j.b.a.e0.b.b;
import java.util.HashMap;
import l.a.a.b;
import no.simula.corona.R.id;

public final class MainFragment
  extends ControlFragmentBase
  implements j.b.a.e0.b.a
{
  public HashMap C;
  
  public View a(int paramInt)
  {
    if (C == null) {
      C = new HashMap();
    }
    View localView1 = (View)C.get(Integer.valueOf(paramInt));
    View localView2 = localView1;
    if (localView1 == null)
    {
      localView2 = getView();
      if (localView2 == null) {
        return null;
      }
      localView2 = localView2.findViewById(paramInt);
      C.put(Integer.valueOf(paramInt), localView2);
    }
    return localView2;
  }
  
  public void a()
  {
    HashMap localHashMap = C;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      Object localObject = getActivity();
      if (localObject != null) {
        localObject = ((Activity)localObject).getSystemService("bluetooth");
      } else {
        localObject = null;
      }
      if (localObject != null)
      {
        localObject = (BluetoothManager)localObject;
        i = 1;
        if ((!paramBoolean2) || (((BluetoothManager)localObject).getAdapter().enable() != true)) {
          i = 0;
        }
        localObject = (ImageView)a(R.id.imageBluetooth);
        if (i == 0) {
          i = 2131230861;
        } else {
          i = 2131230859;
        }
        ((ImageView)localObject).setImageResource(i);
      }
      else
      {
        localObject = new h/e;
        ((e)localObject).<init>("null cannot be cast to non-null type android.bluetooth.BluetoothManager");
        throw ((Throwable)localObject);
      }
    }
    catch (Exception localException1)
    {
      int i;
      l.a.a.d.a(localException1);
      try
      {
        ImageView localImageView = (ImageView)a(R.id.imageGps);
        if (!paramBoolean1) {
          i = 2131230870;
        } else {
          i = 2131230869;
        }
        localImageView.setImageResource(i);
      }
      catch (Exception localException2)
      {
        l.a.a.d.a(localException2);
      }
    }
  }
  
  public void b()
  {
    boolean bool = A;
    a(B, A);
    c();
  }
  
  public final void c()
  {
    try
    {
      TextView localTextView = (TextView)a(R.id.buttonSettings);
      g.a(localTextView, "buttonSettings");
      localTextView.setVisibility(4);
      localTextView = (TextView)a(R.id.buttonShare);
      g.a(localTextView, "buttonShare");
      localTextView.setVisibility(4);
      ((ImageButton)a(R.id.enableTracking)).setImageResource(2131230873);
      if ((A) && (B))
      {
        ((TextView)a(R.id.textViewMainStatus)).setText(getString(2131886163));
        localTextView = (TextView)a(R.id.textViewMainStatus);
        localObject2 = getContext();
        if (localObject2 != null)
        {
          localTextView.setTextColor(d.i.b.a.a((Context)localObject2, 2131099735));
          ((TextView)a(R.id.textViewTitle)).setText(getString(2131886231));
          ((TextView)a(R.id.textViewStatus)).setText(getString(2131886183));
          localTextView = (TextView)a(R.id.buttonShare);
          g.a(localTextView, "buttonShare");
          localTextView.setVisibility(0);
          return;
        }
        g.a();
        throw null;
      }
    }
    catch (Exception localException)
    {
      Object localObject2;
      Object localObject1;
      if ((A) && (!B))
      {
        ((TextView)a(R.id.textViewMainStatus)).setText(getString(2131886202));
        localObject1 = (TextView)a(R.id.textViewMainStatus);
        localObject2 = getContext();
        if (localObject2 != null)
        {
          ((TextView)localObject1).setTextColor(d.i.b.a.a((Context)localObject2, 2131099787));
          ((TextView)a(R.id.textViewTitle)).setText(getString(2131886169));
          ((TextView)a(R.id.textViewStatus)).setText(getString(2131886148));
          ((TextView)a(R.id.textViewStatus)).setText(getString(2131886147));
          localObject1 = (TextView)a(R.id.buttonSettings);
          g.a(localObject1, "buttonSettings");
          ((TextView)localObject1).setVisibility(0);
        }
        else
        {
          g.a();
          throw null;
        }
      }
      else if ((!A) && (B))
      {
        ((TextView)a(R.id.textViewMainStatus)).setText(getString(2131886202));
        localObject1 = (TextView)a(R.id.textViewMainStatus);
        localObject2 = getContext();
        if (localObject2 != null)
        {
          ((TextView)localObject1).setTextColor(d.i.b.a.a((Context)localObject2, 2131099787));
          ((TextView)a(R.id.textViewTitle)).setText(getString(2131886231));
          ((TextView)a(R.id.textViewStatus)).setText(getString(2131886148));
          ((TextView)a(R.id.textViewTitle)).setText(getString(2131886123));
          localObject1 = (TextView)a(R.id.buttonSettings);
          g.a(localObject1, "buttonSettings");
          ((TextView)localObject1).setVisibility(0);
        }
        else
        {
          g.a();
          throw null;
        }
      }
      else
      {
        ((TextView)a(R.id.textViewMainStatus)).setText(getString(2131886153));
        localObject2 = (TextView)a(R.id.textViewMainStatus);
        localObject1 = getContext();
        if (localObject1 != null)
        {
          ((TextView)localObject2).setTextColor(d.i.b.a.a((Context)localObject1, 2131099787));
          ((TextView)a(R.id.textViewTitle)).setText(getString(2131886231));
          ((TextView)a(R.id.textViewStatus)).setText(getString(2131886147));
          ((TextView)a(R.id.textViewTitle)).setText(getString(2131886168));
          localObject1 = (TextView)a(R.id.buttonShare);
          g.a(localObject1, "buttonShare");
          ((TextView)localObject1).setVisibility(0);
          ((ImageButton)a(R.id.enableTracking)).setImageResource(2131230875);
          localObject1 = (TextView)a(R.id.buttonSettings);
          g.a(localObject1, "buttonSettings");
          ((TextView)localObject1).setVisibility(0);
        }
        else
        {
          g.a();
          throw null;
          l.a.a.d.a((Throwable)localObject1);
        }
      }
    }
  }
  
  public void onAttach(Context paramContext)
  {
    if (paramContext != null)
    {
      super.onAttach(paramContext);
      paramContext = x;
      if (paramContext != null) {
        paramContext.a(this);
      }
      return;
    }
    g.a("context");
    throw null;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (paramLayoutInflater != null) {
      return paramLayoutInflater.inflate(2131558455, paramViewGroup, false);
    }
    g.a("inflater");
    throw null;
  }
  
  public void onDetach()
  {
    super.onDetach();
    b localb = x;
    if (localb != null) {
      localb.a(null);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    Object localObject = null;
    if (paramView != null)
    {
      super.onViewCreated(paramView, paramBundle);
      ((ImageButton)a(R.id.enableTracking)).setOnClickListener(new MainFragment.a(0, this));
      ((ImageView)a(R.id.imageGps)).setOnClickListener(new MainFragment.a(1, this));
      ((ImageView)a(R.id.imageBluetooth)).setOnClickListener(new MainFragment.a(2, this));
      ((TextView)a(R.id.buttonShare)).setOnClickListener(new MainFragment.a(3, this));
      ((TextView)a(R.id.buttonSettings)).setOnClickListener(new MainFragment.a(4, this));
      paramView = x;
      if (paramView != null) {
        paramView = paramView.i();
      } else {
        paramView = null;
      }
      boolean bool = g.a(paramView, Boolean.valueOf(true));
      paramBundle = x;
      paramView = (View)localObject;
      if (paramBundle != null) {
        paramView = paramBundle.b();
      }
      a(bool, g.a(paramView, Boolean.valueOf(true)));
      c();
      return;
    }
    g.a("view");
    throw null;
  }
}

/* Location:
 * Qualified Name:     base.no.simula.corona.ui.main.MainFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */