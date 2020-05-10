package d.b.e;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertController.b;
import d.b.a.g;
import d.b.a.g.a;

public class w$b
  implements w.f, DialogInterface.OnClickListener
{
  public g x;
  public ListAdapter y;
  public CharSequence z;
  
  public w$b(w paramw) {}
  
  public void a(int paramInt)
  {
    Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (y == null) {
      return;
    }
    Object localObject1 = new g.a(A.getPopupContext());
    Object localObject2 = z;
    if (localObject2 != null) {
      a.f = ((CharSequence)localObject2);
    }
    localObject2 = y;
    int i = A.getSelectedItemPosition();
    AlertController.b localb = a;
    l = ((ListAdapter)localObject2);
    m = this;
    p = i;
    o = true;
    localObject1 = ((g.a)localObject1).a();
    x = ((g)localObject1);
    localObject1 = z.g;
    ((ListView)localObject1).setTextDirection(paramInt1);
    ((ListView)localObject1).setTextAlignment(paramInt2);
    x.show();
  }
  
  public void a(Drawable paramDrawable)
  {
    Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
  }
  
  public void a(ListAdapter paramListAdapter)
  {
    y = paramListAdapter;
  }
  
  public void a(CharSequence paramCharSequence)
  {
    z = paramCharSequence;
  }
  
  public boolean a()
  {
    g localg = x;
    boolean bool;
    if (localg != null) {
      bool = localg.isShowing();
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int b()
  {
    return 0;
  }
  
  public void b(int paramInt)
  {
    Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
  }
  
  public void c(int paramInt)
  {
    Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
  }
  
  public int d()
  {
    return 0;
  }
  
  public void dismiss()
  {
    g localg = x;
    if (localg != null)
    {
      localg.dismiss();
      x = null;
    }
  }
  
  public Drawable e()
  {
    return null;
  }
  
  public CharSequence f()
  {
    return z;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    A.setSelection(paramInt);
    if (A.getOnItemClickListener() != null) {
      A.performItemClick(null, paramInt, y.getItemId(paramInt));
    }
    paramDialogInterface = x;
    if (paramDialogInterface != null)
    {
      paramDialogInterface.dismiss();
      x = null;
    }
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.w.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */