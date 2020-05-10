package d.t.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import d.k.a.a;

public class s$t
  extends a
{
  public static final Parcelable.Creator<t> CREATOR = new s.t.a();
  public Parcelable z;
  
  public s$t(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    if (paramClassLoader == null) {
      paramClassLoader = s.k.class.getClassLoader();
    }
    z = paramParcel.readParcelable(paramClassLoader);
  }
  
  public s$t(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(x, paramInt);
    paramParcel.writeParcelable(z, 0);
  }
}

/* Location:
 * Qualified Name:     base.d.t.a.s.t
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */