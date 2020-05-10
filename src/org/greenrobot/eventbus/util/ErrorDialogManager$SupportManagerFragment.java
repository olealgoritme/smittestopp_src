package org.greenrobot.eventbus.util;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import k.d.a.c;
import k.d.a.t.a;

public class ErrorDialogManager$SupportManagerFragment
  extends Fragment
{
  public c x;
  public boolean y;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    throw null;
  }
  
  public void onEventMainThread(a parama)
  {
    throw null;
  }
  
  public void onPause()
  {
    x.c(this);
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (y)
    {
      y = false;
      return;
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     base.org.greenrobot.eventbus.util.ErrorDialogManager.SupportManagerFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */