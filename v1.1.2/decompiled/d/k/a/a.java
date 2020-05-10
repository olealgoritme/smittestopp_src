package d.k.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;

public abstract class a
  implements Parcelable
{
  public static final Parcelable.Creator<a> CREATOR = new b();
  public static final a y = new a();
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
  
  public static final class a
    extends a
  {
    public a()
    {
      super();
    }
  }
  
  public static final class b
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
}

/* Location:
 * Qualified Name:     d.k.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */