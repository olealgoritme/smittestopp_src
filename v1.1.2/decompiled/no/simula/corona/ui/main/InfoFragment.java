package no.simula.corona.ui.main;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import i.k.b.g;
import java.util.HashMap;
import no.simula.corona.R.id;

public final class InfoFragment
  extends MainBaseFragment
{
  public HashMap y;
  
  public View a(int paramInt)
  {
    if (y == null) {
      y = new HashMap();
    }
    View localView1 = (View)y.get(Integer.valueOf(paramInt));
    View localView2 = localView1;
    if (localView1 == null)
    {
      localView2 = getView();
      if (localView2 == null) {
        return null;
      }
      localView2 = localView2.findViewById(paramInt);
      y.put(Integer.valueOf(paramInt), localView2);
    }
    return localView2;
  }
  
  public void a()
  {
    HashMap localHashMap = y;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (paramLayoutInflater != null) {
      return paramLayoutInflater.inflate(2131558454, paramViewGroup, false);
    }
    g.a("inflater");
    throw null;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    if (paramView != null)
    {
      super.onViewCreated(paramView, paramBundle);
      paramView = (TextView)a(R.id.fhi_website);
      g.a(paramView, "fhi_website");
      paramView.setMovementMethod(LinkMovementMethod.getInstance());
      paramView = (TextView)a(R.id.general_advice_public);
      g.a(paramView, "general_advice_public");
      paramView.setMovementMethod(LinkMovementMethod.getInstance());
      paramView = (TextView)a(R.id.about_smittestopp);
      g.a(paramView, "about_smittestopp");
      paramView.setMovementMethod(LinkMovementMethod.getInstance());
      paramView = (TextView)a(R.id.self_reporting);
      g.a(paramView, "self_reporting");
      paramView.setMovementMethod(LinkMovementMethod.getInstance());
      return;
    }
    g.a("view");
    throw null;
  }
}

/* Location:
 * Qualified Name:     no.simula.corona.ui.main.InfoFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */