package androidx.navigation.fragment;

import android.app.Dialog;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.NavController;
import d.o.g.a;
import d.o.j;
import d.o.l;

public class DialogFragmentNavigator$1
  implements j
{
  public DialogFragmentNavigator$1(DialogFragmentNavigator paramDialogFragmentNavigator) {}
  
  public void a(l paraml, g.a parama)
  {
    if (parama == g.a.ON_STOP)
    {
      paraml = (DialogFragment)paraml;
      parama = G;
      if (parama != null)
      {
        if (!parama.isShowing()) {
          NavHostFragment.a(paraml).b();
        }
      }
      else
      {
        parama = new StringBuilder();
        parama.append("DialogFragment ");
        parama.append(paraml);
        parama.append(" does not have a Dialog.");
        throw new IllegalStateException(parama.toString());
      }
    }
  }
}

/* Location:
 * Qualified Name:     androidx.navigation.fragment.DialogFragmentNavigator.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */