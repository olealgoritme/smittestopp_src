package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

public final class Toolbar$f$a
  implements Parcelable.ClassLoaderCreator<Toolbar.f>
{
  public Object createFromParcel(Parcel paramParcel)
  {
    return new Toolbar.f(paramParcel, null);
  }
  
  public Object createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    return new Toolbar.f(paramParcel, paramClassLoader);
  }
  
  public Object[] newArray(int paramInt)
  {
    return new Toolbar.f[paramInt];
  }
}

/* Location:
 * Qualified Name:     androidx.appcompat.widget.Toolbar.f.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */