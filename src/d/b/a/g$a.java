package d.b.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertController.RecycleListView;
import androidx.appcompat.app.AlertController.b;
import androidx.appcompat.app.AlertController.d;

public class g$a
{
  public final AlertController.b a;
  public final int b;
  
  public g$a(Context paramContext)
  {
    a = new AlertController.b(new ContextThemeWrapper(paramContext, g.a(paramContext, i)));
    b = i;
  }
  
  public g a()
  {
    g localg = new g(a.a, b);
    AlertController.b localb = a;
    AlertController localAlertController = z;
    Object localObject1 = g;
    Object localObject2;
    int i;
    if (localObject1 != null)
    {
      G = ((View)localObject1);
    }
    else
    {
      localObject1 = f;
      if (localObject1 != null)
      {
        e = ((CharSequence)localObject1);
        localObject2 = E;
        if (localObject2 != null) {
          ((TextView)localObject2).setText((CharSequence)localObject1);
        }
      }
      localObject2 = d;
      if (localObject2 != null)
      {
        C = ((Drawable)localObject2);
        B = 0;
        localObject1 = D;
        if (localObject1 != null)
        {
          ((ImageView)localObject1).setVisibility(0);
          D.setImageDrawable((Drawable)localObject2);
        }
      }
      i = c;
      if (i != 0) {
        localAlertController.a(i);
      }
      i = e;
      if (i != 0) {
        if (localAlertController != null)
        {
          localObject1 = new TypedValue();
          a.getTheme().resolveAttribute(i, (TypedValue)localObject1, true);
          localAlertController.a(resourceId);
        }
        else
        {
          throw null;
        }
      }
    }
    if (l != null)
    {
      localObject2 = (AlertController.RecycleListView)b.inflate(L, null);
      if (o) {
        i = N;
      } else {
        i = O;
      }
      localObject1 = l;
      if (localObject1 == null) {
        localObject1 = new AlertController.d(a, i, 16908308, null);
      }
      H = ((ListAdapter)localObject1);
      I = p;
      if (m != null) {
        ((ListView)localObject2).setOnItemClickListener(new f(localb, localAlertController));
      }
      if (o) {
        ((ListView)localObject2).setChoiceMode(1);
      }
      g = ((ListView)localObject2);
    }
    localg.setCancelable(a.h);
    if (a.h) {
      localg.setCanceledOnTouchOutside(true);
    }
    localg.setOnCancelListener(a.i);
    localg.setOnDismissListener(a.j);
    localObject1 = a.k;
    if (localObject1 != null) {
      localg.setOnKeyListener((DialogInterface.OnKeyListener)localObject1);
    }
    return localg;
  }
}

/* Location:
 * Qualified Name:     base.d.b.a.g.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */