package no.simula.corona.ui.main;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import h.e;
import h.k.b.g;

public final class SettingsFragment$a
  implements View.OnClickListener
{
  public SettingsFragment$a(int paramInt, Object paramObject) {}
  
  public final void onClick(View paramView)
  {
    int i = x;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          if (((SettingsFragment)y).getContext() != null)
          {
            paramView = (SettingsFragment)y;
            if (F == 4)
            {
              paramView = paramView.getContext();
              if (paramView != null)
              {
                paramView = paramView.getSystemService("clipboard");
                if (paramView != null)
                {
                  ClipboardManager localClipboardManager = (ClipboardManager)paramView;
                  paramView = ((SettingsFragment)y).getContext();
                  if (paramView != null)
                  {
                    g.a(paramView, "context!!");
                    Object localObject = paramView.getSharedPreferences("settings", 0);
                    paramView = "";
                    localObject = ((SharedPreferences)localObject).getString("device-id-string", "");
                    if (localObject != null) {
                      paramView = (View)localObject;
                    }
                    localClipboardManager.setPrimaryClip(ClipData.newPlainText(null, paramView));
                    paramView = ((SettingsFragment)y).getContext();
                    if (paramView != null)
                    {
                      Toast.makeText(paramView, "Copied device id", 0).show();
                      y).F = 0;
                      break label218;
                    }
                    g.a();
                    throw null;
                  }
                  g.a();
                  throw null;
                }
                throw new e("null cannot be cast to non-null type android.content.ClipboardManager");
              }
              g.a();
              throw null;
            }
          }
          paramView = (SettingsFragment)y;
          F += 1;
          label218:
          return;
        }
        throw null;
      }
      SettingsFragment.e((SettingsFragment)y);
      return;
    }
    SettingsFragment.b((SettingsFragment)y);
  }
}

/* Location:
 * Qualified Name:     base.no.simula.corona.ui.main.SettingsFragment.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */