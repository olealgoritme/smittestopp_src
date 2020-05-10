package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import d.k.a.a;

public class Toolbar$g
  extends a
{
  public static final Parcelable.Creator<g> CREATOR = new Toolbar.g.a();
  public boolean A;
  public int z;
  
  public Toolbar$g(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    z = paramParcel.readInt();
    boolean bool;
    if (paramParcel.readInt() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    A = bool;
  }
  
  public Toolbar$g(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(x, paramInt);
    paramParcel.writeInt(z);
    paramParcel.writeInt(A);
  }
}

/* Location:
 * Qualified Name:     base.androidx.appcompat.widget.Toolbar.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */