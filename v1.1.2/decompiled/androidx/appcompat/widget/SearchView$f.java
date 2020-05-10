package androidx.appcompat.widget;

import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class SearchView$f
  implements View.OnClickListener
{
  public SearchView$f(SearchView paramSearchView) {}
  
  public void onClick(View paramView)
  {
    SearchView localSearchView = x;
    if (paramView == Q)
    {
      localSearchView.f();
    }
    else if (paramView == S)
    {
      localSearchView.e();
    }
    else if (paramView == R)
    {
      localSearchView.g();
    }
    else if (paramView == T)
    {
      paramView = C0;
      if (paramView != null) {
        try
        {
          if (paramView.getVoiceSearchLaunchWebSearch())
          {
            Intent localIntent1 = h0;
            Intent localIntent2 = new android/content/Intent;
            localIntent2.<init>(localIntent1);
            paramView = paramView.getSearchActivity();
            if (paramView == null) {
              paramView = null;
            } else {
              paramView = paramView.flattenToShortString();
            }
            localIntent2.putExtra("calling_package", paramView);
            localSearchView.getContext().startActivity(localIntent2);
          }
          else if (paramView.getVoiceSearchLaunchRecognizer())
          {
            paramView = localSearchView.a(i0, paramView);
            localSearchView.getContext().startActivity(paramView);
          }
        }
        catch (ActivityNotFoundException paramView)
        {
          Log.w("SearchView", "Could not find voice search activity");
        }
      }
    }
    else if (paramView == M)
    {
      localSearchView.d();
    }
  }
}

/* Location:
 * Qualified Name:     androidx.appcompat.widget.SearchView.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */