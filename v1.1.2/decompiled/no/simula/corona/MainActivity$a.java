package no.simula.corona;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import i.k.a.a;
import k.b.a.t;

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
        t.d((MainActivity)y, true);
        return;
      }
      throw null;
    }
    ((a)y).invoke();
  }
}

/* Location:
 * Qualified Name:     no.simula.corona.MainActivity.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */