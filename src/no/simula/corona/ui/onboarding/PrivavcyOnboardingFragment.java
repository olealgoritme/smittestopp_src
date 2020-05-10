package no.simula.corona.ui.onboarding;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import h.k.b.g;
import j.b.a.e0.c.a;
import j.b.a.e0.c.c;
import java.util.HashMap;
import no.simula.corona.R.id;
import no.simula.corona.ui.BaseFragment;

public final class PrivavcyOnboardingFragment
  extends BaseFragment
{
  public Integer x = Integer.valueOf(0);
  public a y;
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
      localView2 = getView();
      if (localView2 == null) {
        return null;
      }
      localView2 = localView2.findViewById(paramInt);
      z.put(Integer.valueOf(paramInt), localView2);
    }
    return localView2;
  }
  
  public void a()
  {
    HashMap localHashMap = z;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public void onAttach(Context paramContext)
  {
    if (paramContext != null)
    {
      super.onAttach(paramContext);
      if ((paramContext instanceof a)) {
        y = ((a)paramContext);
      }
      return;
    }
    g.a("context");
    throw null;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (paramLayoutInflater != null) {
      return paramLayoutInflater.inflate(2131558457, paramViewGroup, false);
    }
    g.a("inflater");
    throw null;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    Object localObject = null;
    if (paramView != null)
    {
      super.onViewCreated(paramView, paramBundle);
      paramView = getArguments();
      if (paramView != null) {
        paramView = paramView.getString("mainText");
      } else {
        paramView = null;
      }
      paramBundle = getArguments();
      if (paramBundle != null) {
        paramBundle = paramBundle.getString("buttonTextRId");
      } else {
        paramBundle = null;
      }
      Bundle localBundle = getArguments();
      if (localBundle != null) {
        localObject = Integer.valueOf(localBundle.getInt("pageNo"));
      }
      x = ((Integer)localObject);
      localObject = (TextView)a(R.id.textViewWelcome);
      g.a(localObject, "this.textViewWelcome");
      ((TextView)localObject).setText(paramView);
      ((TextView)a(R.id.buttonCallOfAction)).setText(paramBundle);
      ((TextView)a(R.id.buttonCallOfAction)).setOnClickListener(new c(this));
      return;
    }
    g.a("view");
    throw null;
  }
}

/* Location:
 * Qualified Name:     base.no.simula.corona.ui.onboarding.PrivavcyOnboardingFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */