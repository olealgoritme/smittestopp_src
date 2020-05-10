package d.t.a;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

public final class s$t$a
  implements Parcelable.ClassLoaderCreator<s.t>
{
  public Object createFromParcel(Parcel paramParcel)
  {
    return new s.t(paramParcel, null);
  }
  
  public Object createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    return new s.t(paramParcel, paramClassLoader);
  }
  
  public Object[] newArray(int paramInt)
  {
    return new s.t[paramInt];
  }
}

/* Location:
 * Qualified Name:     base.d.t.a.s.t.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */