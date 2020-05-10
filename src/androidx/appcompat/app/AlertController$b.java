package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;

public class AlertController$b
{
  public final Context a;
  public final LayoutInflater b;
  public int c = 0;
  public Drawable d;
  public int e = 0;
  public CharSequence f;
  public View g;
  public boolean h;
  public DialogInterface.OnCancelListener i;
  public DialogInterface.OnDismissListener j;
  public DialogInterface.OnKeyListener k;
  public ListAdapter l;
  public DialogInterface.OnClickListener m;
  public boolean n = false;
  public boolean o;
  public int p = -1;
  
  public AlertController$b(Context paramContext)
  {
    a = paramContext;
    h = true;
    b = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
}

/* Location:
 * Qualified Name:     base.androidx.appcompat.app.AlertController.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */