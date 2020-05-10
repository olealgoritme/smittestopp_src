package no.simula.corona;

import android.app.AlertDialog.Builder;

public final class MainActivity$e
  implements Runnable
{
  public MainActivity$e(MainActivity paramMainActivity) {}
  
  public final void run()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(x);
    localBuilder.setTitle(2131886111);
    localBuilder.setMessage(2131886152);
    localBuilder.setPositiveButton(17039370, new MainActivity.e.a(this));
    localBuilder.setOnDismissListener(new MainActivity.e.b(this));
    localBuilder.create();
    localBuilder.show();
  }
}

/* Location:
 * Qualified Name:     base.no.simula.corona.MainActivity.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */