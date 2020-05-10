package e.c.a.b.d;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.MenuItem;
import d.b.d.i.h;
import d.b.d.i.j;
import d.b.d.i.o;
import d.b.d.i.o.a;
import d.b.d.i.t;
import d.x.l;
import java.util.ArrayList;

public class e
  implements o
{
  public int A;
  public h x;
  public d y;
  public boolean z = false;
  
  public void a(Context paramContext, h paramh)
  {
    x = paramh;
    y.U = paramh;
  }
  
  public void a(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof a))
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
  
  public void a(h paramh, boolean paramBoolean) {}
  
  public void a(o.a parama) {}
  
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
        int i = ((h)localObject).size();
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
            H[k].a((j)U.getItem(k), 0);
            T.z = false;
          }
        }
      }
    }
  }
  
  public boolean a(h paramh, j paramj)
  {
    return false;
  }
  
  public boolean a(t paramt)
  {
    return false;
  }
  
  public boolean b(h paramh, j paramj)
  {
    return false;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public Parcelable d()
  {
    a locala = new a();
    x = y.getSelectedItemId();
    return locala;
  }
  
  public int getId()
  {
    return A;
  }
  
  public static class a
    implements Parcelable
  {
    public static final Parcelable.Creator<a> CREATOR = new a();
    public int x;
    
    public a() {}
    
    public a(Parcel paramParcel)
    {
      x = paramParcel.readInt();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(x);
    }
    
    public static final class a
      implements Parcelable.Creator<e.a>
    {
      public Object createFromParcel(Parcel paramParcel)
      {
        return new e.a(paramParcel);
      }
      
      public Object[] newArray(int paramInt)
      {
        return new e.a[paramInt];
      }
    }
  }
}

/* Location:
 * Qualified Name:     e.c.a.b.d.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */