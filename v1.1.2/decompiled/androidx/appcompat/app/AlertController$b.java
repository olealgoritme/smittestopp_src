package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
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
  public DialogInterface.OnKeyListener i;
  public ListAdapter j;
  public DialogInterface.OnClickListener k;
  public boolean l = false;
  public boolean m;
  public int n = -1;
  
  public AlertController$b(Context paramContext)
  {
    a = paramContext;
    h = true;
    b = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
}

/* Location:
 * Qualified Name:     androidx.appcompat.app.AlertController.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */