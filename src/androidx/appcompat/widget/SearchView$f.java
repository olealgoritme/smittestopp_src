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
      SearchableInfo localSearchableInfo = C0;
      if (localSearchableInfo != null) {
        try
        {
          if (localSearchableInfo.getVoiceSearchLaunchWebSearch())
          {
            paramView = h0;
            Intent localIntent = new android/content/Intent;
            localIntent.<init>(paramView);
            paramView = localSearchableInfo.getSearchActivity();
            if (paramView == null) {
              paramView = null;
            } else {
              paramView = paramView.flattenToShortString();
            }
            localIntent.putExtra("calling_package", paramView);
            localSearchView.getContext().startActivity(localIntent);
          }
          else if (localSearchableInfo.getVoiceSearchLaunchRecognizer())
          {
            paramView = localSearchView.a(i0, localSearchableInfo);
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
 * Qualified Name:     base.androidx.appcompat.widget.SearchView.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */