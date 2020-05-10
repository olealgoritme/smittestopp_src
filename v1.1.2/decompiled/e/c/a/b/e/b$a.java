package e.c.a.b.e;

import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.View.OnClickListener;

public class b$a
  implements View.OnClickListener
{
  public b$a(b paramb) {}
  
  public void onClick(View paramView)
  {
    paramView = x;
    if ((A) && (paramView.isShowing()))
    {
      b localb = x;
      if (!C)
      {
        paramView = localb.getContext().obtainStyledAttributes(new int[] { 16843611 });
        B = paramView.getBoolean(0, true);
        paramView.recycle();
        C = true;
      }
      if (B) {
        x.cancel();
      }
    }
  }
}

/* Location:
 * Qualified Name:     e.c.a.b.e.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */