package no.simula.corona;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;

public final class MainActivity$e
  implements Runnable
{
  public MainActivity$e(MainActivity paramMainActivity) {}
  
  public final void run()
  {
    if (!x.isFinishing())
    {
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(x);
      localBuilder.setTitle(2131886124);
      localBuilder.setMessage(2131886172);
      localBuilder.setPositiveButton(17039370, new a(this));
      localBuilder.setOnDismissListener(new b(this));
      localBuilder.create();
      localBuilder.show();
    }
  }
  
  public static final class a
    implements DialogInterface.OnClickListener
  {
    public a(MainActivity.e parame) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      MainActivity.a(x.x);
    }
  }
  
  public static final class b
    implements DialogInterface.OnDismissListener
  {
    public b(MainActivity.e parame) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      MainActivity.a(x.x);
    }
  }
}

/* Location:
 * Qualified Name:     no.simula.corona.MainActivity.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */