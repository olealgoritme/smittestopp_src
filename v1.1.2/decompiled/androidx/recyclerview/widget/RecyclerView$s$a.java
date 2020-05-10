package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

public final class RecyclerView$s$a
  implements Parcelable.ClassLoaderCreator<RecyclerView.s>
{
  public Object createFromParcel(Parcel paramParcel)
  {
    return new RecyclerView.s(paramParcel, null);
  }
  
  public Object createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    return new RecyclerView.s(paramParcel, paramClassLoader);
  }
  
  public Object[] newArray(int paramInt)
  {
    return new RecyclerView.s[paramInt];
  }
}

/* Location:
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.s.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */