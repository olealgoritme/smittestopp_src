package d.k.a;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

public final class a$b
  implements Parcelable.ClassLoaderCreator<a>
{
  public Object createFromParcel(Parcel paramParcel)
  {
    if (paramParcel.readParcelable(null) == null) {
      return a.y;
    }
    throw new IllegalStateException("superState must be null");
  }
  
  public Object createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    if (paramParcel.readParcelable(paramClassLoader) == null) {
      return a.y;
    }
    throw new IllegalStateException("superState must be null");
  }
  
  public Object[] newArray(int paramInt)
  {
    return new a[paramInt];
  }
}

/* Location:
 * Qualified Name:     base.d.k.a.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */