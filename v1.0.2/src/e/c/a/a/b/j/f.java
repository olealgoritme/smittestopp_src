package e.c.a.a.b.j;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.util.Log;

public abstract class f
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      try
      {
        u localu = (u)this;
        Intent localIntent = x;
        if (localIntent != null) {
          y.startActivityForResult(localIntent, z);
        }
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        break label44;
      }
      return;
    }
    finally
    {
      label44:
      paramDialogInterface.dismiss();
    }
    Log.e("DialogRedirect", "Failed to start resolution intent", localActivityNotFoundException);
    paramDialogInterface.dismiss();
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.b.j.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */