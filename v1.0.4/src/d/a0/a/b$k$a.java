package d.a0.a;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

public final class b$k$a
  implements Parcelable.ClassLoaderCreator<b.k>
{
  public Object createFromParcel(Parcel paramParcel)
  {
    return new b.k(paramParcel, null);
  }
  
  public Object createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    return new b.k(paramParcel, paramClassLoader);
  }
  
  public Object[] newArray(int paramInt)
  {
    return new b.k[paramInt];
  }
}

/* Location:
 * Qualified Name:     base.d.a0.a.b.k.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */