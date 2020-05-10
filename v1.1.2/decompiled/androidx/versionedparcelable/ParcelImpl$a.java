package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ParcelImpl$a
  implements Parcelable.Creator<ParcelImpl>
{
  public Object createFromParcel(Parcel paramParcel)
  {
    return new ParcelImpl(paramParcel);
  }
  
  public Object[] newArray(int paramInt)
  {
    return new ParcelImpl[paramInt];
  }
}

/* Location:
 * Qualified Name:     androidx.versionedparcelable.ParcelImpl.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */