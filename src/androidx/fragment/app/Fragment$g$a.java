package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

public final class Fragment$g$a
  implements Parcelable.ClassLoaderCreator<Fragment.g>
{
  public Object createFromParcel(Parcel paramParcel)
  {
    return new Fragment.g(paramParcel, null);
  }
  
  public Object createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    return new Fragment.g(paramParcel, paramClassLoader);
  }
  
  public Object[] newArray(int paramInt)
  {
    return new Fragment.g[paramInt];
  }
}

/* Location:
 * Qualified Name:     base.androidx.fragment.app.Fragment.g.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */