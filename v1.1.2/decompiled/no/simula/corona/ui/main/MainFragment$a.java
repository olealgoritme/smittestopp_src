package no.simula.corona.ui.main;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.Fragment;
import i.k.b.g;
import k.b.a.z.b.b;

public final class MainFragment$a
  implements View.OnClickListener
{
  public MainFragment$a(int paramInt, Object paramObject) {}
  
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
              paramView = y).x;
              if (paramView != null) {
                paramView.e();
              }
              return;
            }
            throw null;
          }
          Object localObject = (MainFragment)y;
          paramView = ((Fragment)localObject).getActivity();
          String str = ((MainFragment)y).getString(2131886124);
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
        paramView = (MainFragment)y;
        if (!A)
        {
          paramView = x;
          if (paramView != null) {
            paramView.e();
          }
        }
        return;
      }
      paramView = (MainFragment)y;
      if (!B)
      {
        paramView = x;
        if (paramView != null) {
          paramView.e();
        }
      }
      return;
    }
    paramView = (MainFragment)y;
    if ((!B) && (!A))
    {
      paramView = x;
      if (paramView != null) {
        paramView.e();
      }
    }
  }
}

/* Location:
 * Qualified Name:     no.simula.corona.ui.main.MainFragment.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */