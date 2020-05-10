package no.simula.corona;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import h.k.a.a;
import j.b.a.a0;

public final class MainActivity$a
  implements DialogInterface.OnClickListener
{
  public MainActivity$a(int paramInt, Object paramObject) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramInt = x;
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        a0.c((MainActivity)y, true);
        return;
      }
      throw null;
    }
    ((a)y).invoke();
  }
}

/* Location:
 * Qualified Name:     base.no.simula.corona.MainActivity.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */