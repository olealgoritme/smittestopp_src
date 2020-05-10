package d.k.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public abstract class a
  implements Parcelable
{
  public static final Parcelable.Creator<a> CREATOR = new a.b();
  public static final a y = new a.a();
  public final Parcelable x;
  
  public a(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    paramParcel = paramParcel.readParcelable(paramClassLoader);
    if (paramParcel == null) {
      paramParcel = y;
    }
    x = paramParcel;
  }
  
  public a(Parcelable paramParcelable)
  {
    if (paramParcelable != null)
    {
      if (paramParcelable == y) {
        paramParcelable = null;
      }
      x = paramParcelable;
      return;
    }
    throw new IllegalArgumentException("superState must not be null");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(x, paramInt);
  }
}

/* Location:
 * Qualified Name:     base.d.k.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */