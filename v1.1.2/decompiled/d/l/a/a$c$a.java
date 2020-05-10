package d.l.a;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

public final class a$c$a
  implements Parcelable.ClassLoaderCreator<a.c>
{
  public Object createFromParcel(Parcel paramParcel)
  {
    return new a.c(paramParcel, null);
  }
  
  public Object createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    return new a.c(paramParcel, paramClassLoader);
  }
  
  public Object[] newArray(int paramInt)
  {
    return new a.c[paramInt];
  }
}

/* Location:
 * Qualified Name:     d.l.a.a.c.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */