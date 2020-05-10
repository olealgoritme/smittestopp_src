package no.simula.corona.ui.main;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.Fragment;
import d.m.a.c;
import j.b.a.e0.b.b;

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
                paramView.h();
              }
              return;
            }
            throw null;
          }
          c localc = ((MainFragment)y).getActivity();
          String str = ((MainFragment)y).getString(2131886111);
          if (localc != null)
          {
            paramView = new Intent("android.intent.action.SEND");
            paramView.setType("text/plain");
            paramView.putExtra("android.intent.extra.TEXT", "https://play.google.com/store/apps/details?id=no.simula.smittestopp");
            if (paramView.resolveActivity(localc.getPackageManager()) != null) {
              localc.startActivity(Intent.createChooser(paramView, str));
            }
          }
          return;
        }
        paramView = (MainFragment)y;
        if (!A)
        {
          paramView = x;
          if (paramView != null) {
            paramView.h();
          }
        }
        return;
      }
      paramView = (MainFragment)y;
      if (!B)
      {
        paramView = x;
        if (paramView != null) {
          paramView.h();
        }
      }
      return;
    }
    paramView = (MainFragment)y;
    if ((!B) && (!A))
    {
      paramView = x;
      if (paramView != null) {
        paramView.h();
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.no.simula.corona.ui.main.MainFragment.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */