package no.simula.corona.ui.main;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import i.e;
import i.k.b.g;
import java.util.HashMap;
import k.b.a.z.b.b;
import m.a.a.b;
import no.simula.corona.R.id;

public final class MainFragment
  extends ControlFragmentBase
  implements k.b.a.z.b.a
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
    boolean bool = false;
    try
    {
      Object localObject1 = getActivity();
      if (localObject1 != null) {
        localObject1 = ((Activity)localObject1).getSystemService("bluetooth");
      } else {
        localObject1 = null;
      }
      if (localObject1 != null)
      {
        localObject1 = (BluetoothManager)localObject1;
        if ((paramBoolean2) && (((BluetoothManager)localObject1).getAdapter().enable() == true)) {
          i = 1;
        } else {
          i = 0;
        }
        localObject1 = (ImageView)a(R.id.imageBluetooth);
        int j;
        if (i == 0) {
          j = 2131230854;
        } else {
          j = 2131230852;
        }
        ((ImageView)localObject1).setImageResource(j);
        localImageView = (ImageView)a(R.id.imageBluetooth);
        g.a(localImageView, "imageBluetooth");
        if (i != 0) {
          localObject1 = getText(2131886134);
        } else {
          localObject1 = getText(2131886133);
        }
        localImageView.setContentDescription((CharSequence)localObject1);
        localObject1 = (ImageView)a(R.id.imageBluetooth);
        g.a(localObject1, "imageBluetooth");
        ((ImageView)localObject1).setClickable(i ^ 0x1);
      }
      else
      {
        localObject1 = new i/e;
        ((e)localObject1).<init>("null cannot be cast to non-null type android.bluetooth.BluetoothManager");
        throw ((Throwable)localObject1);
      }
    }
    catch (Exception localException1)
    {
      int i;
      ImageView localImageView;
      m.a.a.d.b(localException1);
      try
      {
        Object localObject2 = (ImageView)a(R.id.imageGps);
        if (!paramBoolean1) {
          i = 2131230863;
        } else {
          i = 2131230862;
        }
        ((ImageView)localObject2).setImageResource(i);
        localImageView = (ImageView)a(R.id.imageGps);
        g.a(localImageView, "imageGps");
        if (paramBoolean1) {
          localObject2 = getText(2131886190);
        } else {
          localObject2 = getText(2131886189);
        }
        localImageView.setContentDescription((CharSequence)localObject2);
        localObject2 = (ImageView)a(R.id.imageGps);
        g.a(localObject2, "imageGps");
        paramBoolean2 = bool;
        if (!paramBoolean1) {
          paramBoolean2 = true;
        }
        ((ImageView)localObject2).setClickable(paramBoolean2);
      }
      catch (Exception localException2)
      {
        m.a.a.d.b(localException2);
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
      Object localObject1 = (TextView)a(R.id.buttonSettings);
      g.a(localObject1, "buttonSettings");
      ((TextView)localObject1).setVisibility(4);
      localObject1 = (TextView)a(R.id.buttonShare);
      g.a(localObject1, "buttonShare");
      ((TextView)localObject1).setVisibility(4);
      ((ImageButton)a(R.id.enableTracking)).setImageResource(2131230867);
      localObject1 = (ImageButton)a(R.id.enableTracking);
      g.a(localObject1, "enableTracking");
      ((ImageButton)localObject1).setContentDescription(getString(2131886176));
      localObject1 = (ImageButton)a(R.id.enableTracking);
      g.a(localObject1, "enableTracking");
      ((ImageButton)localObject1).setClickable(false);
      boolean bool = A;
      if ((bool) && (B))
      {
        localObject1 = (TextView)a(R.id.textViewMainStatus);
        g.a(localObject1, "textViewMainStatus");
        ((TextView)localObject1).setText(getString(2131886183));
        localObject3 = (TextView)a(R.id.textViewMainStatus);
        localObject1 = getContext();
        if (localObject1 != null)
        {
          ((TextView)localObject3).setTextColor(d.i.b.a.a((Context)localObject1, 2131099735));
          localObject1 = (TextView)a(R.id.textViewTitle);
          g.a(localObject1, "textViewTitle");
          ((TextView)localObject1).setVisibility(0);
          localObject1 = (TextView)a(R.id.textViewTitle);
          g.a(localObject1, "textViewTitle");
          ((TextView)localObject1).setText(getString(2131886263));
          localObject1 = (TextView)a(R.id.textViewStatus);
          g.a(localObject1, "textViewStatus");
          ((TextView)localObject1).setText(getString(2131886214));
          localObject1 = (TextView)a(R.id.buttonShare);
          g.a(localObject1, "buttonShare");
          ((TextView)localObject1).setVisibility(0);
          ((ImageButton)a(R.id.enableTracking)).setImageResource(2131230869);
          localObject1 = (ImageButton)a(R.id.enableTracking);
          g.a(localObject1, "enableTracking");
          ((ImageButton)localObject1).setClickable(false);
          localObject1 = (ImageButton)a(R.id.enableTracking);
          g.a(localObject1, "enableTracking");
          ((ImageButton)localObject1).setContentDescription(getString(2131886176));
          return;
        }
        g.a();
        throw null;
      }
    }
    catch (Exception localException)
    {
      Object localObject3;
      Object localObject2;
      if ((A) && (!B))
      {
        localObject2 = (TextView)a(R.id.textViewMainStatus);
        g.a(localObject2, "textViewMainStatus");
        ((TextView)localObject2).setText(getString(2131886233));
        localObject2 = (TextView)a(R.id.textViewMainStatus);
        localObject3 = getContext();
        if (localObject3 != null)
        {
          ((TextView)localObject2).setTextColor(d.i.b.a.a((Context)localObject3, 2131099787));
          localObject2 = (TextView)a(R.id.textViewTitle);
          g.a(localObject2, "textViewTitle");
          ((TextView)localObject2).setVisibility(4);
          localObject2 = (TextView)a(R.id.textViewStatus);
          g.a(localObject2, "textViewStatus");
          ((TextView)localObject2).setText(getString(2131886188));
          localObject2 = (TextView)a(R.id.buttonSettings);
          g.a(localObject2, "buttonSettings");
          ((TextView)localObject2).setVisibility(0);
          ((ImageButton)a(R.id.enableTracking)).setImageResource(2131230872);
          localObject2 = (ImageButton)a(R.id.enableTracking);
          g.a(localObject2, "enableTracking");
          ((ImageButton)localObject2).setClickable(true);
          localObject2 = (ImageButton)a(R.id.enableTracking);
          g.a(localObject2, "enableTracking");
          ((ImageButton)localObject2).setContentDescription(getString(2131886185));
        }
        else
        {
          g.a();
          throw null;
        }
      }
      else if ((!A) && (B))
      {
        localObject2 = (TextView)a(R.id.textViewMainStatus);
        g.a(localObject2, "textViewMainStatus");
        ((TextView)localObject2).setText(getString(2131886233));
        localObject2 = (TextView)a(R.id.textViewMainStatus);
        localObject3 = getContext();
        if (localObject3 != null)
        {
          ((TextView)localObject2).setTextColor(d.i.b.a.a((Context)localObject3, 2131099787));
          localObject2 = (TextView)a(R.id.textViewTitle);
          g.a(localObject2, "textViewTitle");
          ((TextView)localObject2).setVisibility(4);
          localObject2 = (TextView)a(R.id.textViewStatus);
          g.a(localObject2, "textViewStatus");
          ((TextView)localObject2).setText(getString(2131886138));
          localObject2 = (TextView)a(R.id.buttonSettings);
          g.a(localObject2, "buttonSettings");
          ((TextView)localObject2).setVisibility(0);
          ((ImageButton)a(R.id.enableTracking)).setImageResource(2131230872);
          localObject2 = (ImageButton)a(R.id.enableTracking);
          g.a(localObject2, "enableTracking");
          ((ImageButton)localObject2).setClickable(true);
          localObject2 = (ImageButton)a(R.id.enableTracking);
          g.a(localObject2, "enableTracking");
          ((ImageButton)localObject2).setContentDescription(getString(2131886185));
        }
        else
        {
          g.a();
          throw null;
        }
      }
      else
      {
        localObject2 = (TextView)a(R.id.textViewMainStatus);
        g.a(localObject2, "textViewMainStatus");
        ((TextView)localObject2).setText(getString(2131886173));
        localObject2 = (TextView)a(R.id.textViewMainStatus);
        localObject3 = getContext();
        if (localObject3 != null)
        {
          ((TextView)localObject2).setTextColor(d.i.b.a.a((Context)localObject3, 2131099787));
          localObject2 = (TextView)a(R.id.textViewTitle);
          g.a(localObject2, "textViewTitle");
          ((TextView)localObject2).setVisibility(4);
          localObject2 = (TextView)a(R.id.textViewStatus);
          g.a(localObject2, "textViewStatus");
          ((TextView)localObject2).setText(getString(2131886187));
          localObject2 = (TextView)a(R.id.buttonShare);
          g.a(localObject2, "buttonShare");
          ((TextView)localObject2).setVisibility(0);
          ((ImageButton)a(R.id.enableTracking)).setImageResource(2131230868);
          localObject2 = (ImageButton)a(R.id.enableTracking);
          g.a(localObject2, "enableTracking");
          ((ImageButton)localObject2).setClickable(true);
          localObject2 = (ImageButton)a(R.id.enableTracking);
          g.a(localObject2, "enableTracking");
          ((ImageButton)localObject2).setContentDescription(getString(2131886185));
          localObject2 = (TextView)a(R.id.buttonSettings);
          g.a(localObject2, "buttonSettings");
          ((TextView)localObject2).setVisibility(0);
        }
        else
        {
          g.a();
          throw null;
          m.a.a.d.b((Throwable)localObject2);
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
      ((ImageButton)a(R.id.enableTracking)).setOnClickListener(new a(0, this));
      ((ImageView)a(R.id.imageGps)).setOnClickListener(new a(1, this));
      ((ImageView)a(R.id.imageBluetooth)).setOnClickListener(new a(2, this));
      ((TextView)a(R.id.buttonShare)).setOnClickListener(new a(3, this));
      ((TextView)a(R.id.buttonSettings)).setOnClickListener(new a(4, this));
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
        paramView = paramBundle.a();
      }
      a(bool, g.a(paramView, Boolean.valueOf(true)));
      c();
      return;
    }
    g.a("view");
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
          if (i != 2)
          {
            if (i != 3)
            {
              if (i == 4)
              {
                paramView = jdField_thisx;
                if (paramView != null) {
                  paramView.e();
                }
                return;
              }
              throw null;
            }
            Object localObject = (MainFragment)jdField_this;
            paramView = ((Fragment)localObject).getActivity();
            String str = ((MainFragment)jdField_this).getString(2131886124);
            if (paramView != null)
            {
              Intent localIntent = new Intent("android.intent.action.SEND");
              localIntent.setType("text/plain");
              localObject = ((Fragment)localObject).getString(2131886125);
              g.a(localObject, "getString(R.string.app_share_link)");
              localIntent.putExtra("android.intent.extra.TEXT", (String)localObject);
              if (localIntent.resolveActivity(paramView.getPackageManager()) != null) {
                paramView.startActivity(Intent.createChooser(localIntent, str));
              }
            }
            return;
          }
          paramView = (MainFragment)jdField_this;
          if (!A)
          {
            paramView = x;
            if (paramView != null) {
              paramView.e();
            }
          }
          return;
        }
        paramView = (MainFragment)jdField_this;
        if (!B)
        {
          paramView = x;
          if (paramView != null) {
            paramView.e();
          }
        }
        return;
      }
      paramView = (MainFragment)jdField_this;
      if ((!B) && (!A))
      {
        paramView = x;
        if (paramView != null) {
          paramView.e();
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     no.simula.corona.ui.main.MainFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */