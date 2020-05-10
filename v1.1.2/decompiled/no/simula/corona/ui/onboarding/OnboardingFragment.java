package no.simula.corona.ui.onboarding;

import android.content.Context;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import i.k.b.g;
import java.util.HashMap;
import k.b.a.z.c.a;
import k.b.a.z.c.b;
import no.simula.corona.R.id;
import no.simula.corona.ui.BaseFragment;

public final class OnboardingFragment
  extends BaseFragment
{
  public Integer x = Integer.valueOf(0);
  public a y;
  public HashMap z;
  
  public static final OnboardingFragment a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString2 != null)
      {
        OnboardingFragment localOnboardingFragment = new OnboardingFragment();
        Bundle localBundle = new Bundle();
        localBundle.putString("mainText", paramString1);
        localBundle.putInt("pageNo", paramInt1);
        localBundle.putInt("subText", paramInt2);
        localBundle.putString("buttonTextRId", paramString2);
        localBundle.putInt("imageResId", paramInt3);
        localOnboardingFragment.setArguments(localBundle);
        return localOnboardingFragment;
      }
      g.a("buttonText");
      throw null;
    }
    g.a("title");
    throw null;
  }
  
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
      return paramLayoutInflater.inflate(2131558456, paramViewGroup, false);
    }
    g.a("inflater");
    throw null;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    if (paramView != null)
    {
      super.onViewCreated(paramView, paramBundle);
      paramView = (TextView)a(R.id.textViewWelcomeDetails);
      g.a(paramView, "textViewWelcomeDetails");
      paramView.setMovementMethod(LinkMovementMethod.getInstance());
      paramView = getArguments();
      if (paramView != null) {
        paramView = paramView.getString("mainText");
      } else {
        paramView = null;
      }
      paramBundle = getArguments();
      Integer localInteger;
      if (paramBundle != null) {
        localInteger = Integer.valueOf(paramBundle.getInt("subText"));
      } else {
        localInteger = null;
      }
      paramBundle = getArguments();
      if (paramBundle != null) {
        paramBundle = Integer.valueOf(paramBundle.getInt("imageResId"));
      } else {
        paramBundle = null;
      }
      Object localObject1 = getArguments();
      if (localObject1 != null) {
        localObject1 = ((Bundle)localObject1).getString("buttonTextRId");
      } else {
        localObject1 = null;
      }
      Object localObject2 = getArguments();
      if (localObject2 != null) {
        localObject2 = Integer.valueOf(((Bundle)localObject2).getInt("pageNo"));
      } else {
        localObject2 = null;
      }
      x = ((Integer)localObject2);
      localObject2 = (TextView)a(R.id.textViewWelcome);
      g.a(localObject2, "this.textViewWelcome");
      ((TextView)localObject2).setText(paramView);
      localObject2 = (TextView)a(R.id.textViewWelcomeDetails);
      g.a(localObject2, "this.textViewWelcomeDetails");
      if (localInteger != null) {
        paramView = getText(localInteger.intValue());
      } else {
        paramView = " ";
      }
      ((TextView)localObject2).setText(paramView);
      paramView = (ImageView)a(R.id.divider0);
      if (paramBundle != null)
      {
        paramView.setImageResource(paramBundle.intValue());
        paramView = (TextView)a(R.id.buttonCallOfAction);
        g.a(paramView, "this.buttonCallOfAction");
        paramView.setText((CharSequence)localObject1);
        ((TextView)a(R.id.buttonCallOfAction)).setOnClickListener(new b(this));
        return;
      }
      g.a();
      throw null;
    }
    g.a("view");
    throw null;
  }
}

/* Location:
 * Qualified Name:     no.simula.corona.ui.onboarding.OnboardingFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */