package e.c.a.b.d;

import android.content.Context;
import android.os.Parcelable;
import android.view.MenuItem;
import d.b.d.i.g;
import d.b.d.i.i;
import d.b.d.i.m;
import d.b.d.i.m.a;
import d.b.d.i.r;
import d.x.l;
import java.util.ArrayList;

public class e
  implements m
{
  public int A;
  public g x;
  public d y;
  public boolean z = false;
  
  public void a(Context paramContext, g paramg)
  {
    x = paramg;
    y.U = paramg;
  }
  
  public void a(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof e.a))
    {
      d locald = y;
      int i = x;
      int j = U.size();
      for (int k = 0; k < j; k++)
      {
        paramParcelable = U.getItem(k);
        if (i == paramParcelable.getItemId())
        {
          I = i;
          J = k;
          paramParcelable.setChecked(true);
          break;
        }
      }
    }
  }
  
  public void a(g paramg, boolean paramBoolean) {}
  
  public void a(m.a parama) {}
  
  public void a(boolean paramBoolean)
  {
    if (z) {
      return;
    }
    if (paramBoolean)
    {
      y.a();
    }
    else
    {
      d locald = y;
      Object localObject = U;
      if ((localObject != null) && (H != null))
      {
        int i = ((g)localObject).size();
        if (i != H.length)
        {
          locald.a();
        }
        else
        {
          int j = I;
          for (int k = 0; k < i; k++)
          {
            localObject = U.getItem(k);
            if (((MenuItem)localObject).isChecked())
            {
              I = ((MenuItem)localObject).getItemId();
              J = k;
            }
          }
          if (j != I) {
            l.a(locald, x);
          }
          paramBoolean = locald.a(G, U.d().size());
          for (k = 0; k < i; k++)
          {
            T.z = true;
            H[k].setLabelVisibilityMode(G);
            H[k].setShifting(paramBoolean);
            H[k].a((i)U.getItem(k), 0);
            T.z = false;
          }
        }
      }
    }
  }
  
  public boolean a(g paramg, i parami)
  {
    return false;
  }
  
  public boolean a(r paramr)
  {
    return false;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean b(g paramg, i parami)
  {
    return false;
  }
  
  public Parcelable d()
  {
    e.a locala = new e.a();
    x = y.getSelectedItemId();
    return locala;
  }
  
  public int getId()
  {
    return A;
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.b.d.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */