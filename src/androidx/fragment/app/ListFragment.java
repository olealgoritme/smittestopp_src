package androidx.fragment.app;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ListFragment
  extends Fragment
{
  public ListAdapter A;
  public ListView B;
  public View C;
  public TextView D;
  public View E;
  public View F;
  public boolean G;
  public final Handler x = new Handler();
  public final Runnable y = new ListFragment.a(this);
  public final AdapterView.OnItemClickListener z = new ListFragment.b(this);
  
  public final void a()
  {
    if (B != null) {
      return;
    }
    Object localObject1 = getView();
    if (localObject1 != null)
    {
      Object localObject2;
      if ((localObject1 instanceof ListView))
      {
        B = ((ListView)localObject1);
      }
      else
      {
        localObject2 = (TextView)((View)localObject1).findViewById(16711681);
        D = ((TextView)localObject2);
        if (localObject2 == null) {
          C = ((View)localObject1).findViewById(16908292);
        } else {
          ((TextView)localObject2).setVisibility(8);
        }
        E = ((View)localObject1).findViewById(16711682);
        F = ((View)localObject1).findViewById(16711683);
        localObject1 = ((View)localObject1).findViewById(16908298);
        if (!(localObject1 instanceof ListView))
        {
          if (localObject1 == null) {
            throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
          }
          throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
        }
        localObject2 = (ListView)localObject1;
        B = ((ListView)localObject2);
        localObject1 = C;
        if (localObject1 != null) {
          ((ListView)localObject2).setEmptyView((View)localObject1);
        }
      }
      G = true;
      B.setOnItemClickListener(z);
      localObject1 = A;
      boolean bool = false;
      if (localObject1 != null)
      {
        A = null;
        int i;
        if (0 != 0) {
          i = 1;
        } else {
          i = 0;
        }
        A = ((ListAdapter)localObject1);
        localObject2 = B;
        if (localObject2 != null)
        {
          ((ListView)localObject2).setAdapter((ListAdapter)localObject1);
          if ((!G) && (i == 0))
          {
            if (requireView().getWindowToken() != null) {
              bool = true;
            }
            a(true, bool);
          }
        }
      }
      else if (E != null)
      {
        a(false, false);
      }
      x.post(y);
      return;
    }
    throw new IllegalStateException("Content view not yet created");
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    a();
    View localView = E;
    if (localView != null)
    {
      if (G == paramBoolean1) {
        return;
      }
      G = paramBoolean1;
      if (paramBoolean1)
      {
        if (paramBoolean2)
        {
          localView.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
          F.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
        }
        else
        {
          localView.clearAnimation();
          F.clearAnimation();
        }
        E.setVisibility(8);
        F.setVisibility(0);
      }
      else
      {
        if (paramBoolean2)
        {
          localView.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
          F.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
        }
        else
        {
          localView.clearAnimation();
          F.clearAnimation();
        }
        E.setVisibility(0);
        F.setVisibility(8);
      }
      return;
    }
    throw new IllegalStateException("Can't be used with a custom content view");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramBundle = requireContext();
    paramLayoutInflater = new FrameLayout(paramBundle);
    paramViewGroup = new LinearLayout(paramBundle);
    paramViewGroup.setId(16711682);
    paramViewGroup.setOrientation(1);
    paramViewGroup.setVisibility(8);
    paramViewGroup.setGravity(17);
    paramViewGroup.addView(new ProgressBar(paramBundle, null, 16842874), new FrameLayout.LayoutParams(-2, -2));
    paramLayoutInflater.addView(paramViewGroup, new FrameLayout.LayoutParams(-1, -1));
    paramViewGroup = new FrameLayout(paramBundle);
    paramViewGroup.setId(16711683);
    TextView localTextView = new TextView(paramBundle);
    localTextView.setId(16711681);
    localTextView.setGravity(17);
    paramViewGroup.addView(localTextView, new FrameLayout.LayoutParams(-1, -1));
    paramBundle = new ListView(paramBundle);
    paramBundle.setId(16908298);
    paramBundle.setDrawSelectorOnTop(false);
    paramViewGroup.addView(paramBundle, new FrameLayout.LayoutParams(-1, -1));
    paramLayoutInflater.addView(paramViewGroup, new FrameLayout.LayoutParams(-1, -1));
    paramLayoutInflater.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    x.removeCallbacks(y);
    B = null;
    G = false;
    F = null;
    E = null;
    C = null;
    D = null;
    super.onDestroyView();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a();
  }
}

/* Location:
 * Qualified Name:     base.androidx.fragment.app.ListFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */