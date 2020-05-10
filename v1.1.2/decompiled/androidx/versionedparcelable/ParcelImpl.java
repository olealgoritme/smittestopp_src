package androidx.versionedparcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import d.z.a;
import d.z.b;
import d.z.c;

@SuppressLint({"BanParcelableUsage"})
public class ParcelImpl
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelImpl> CREATOR = new a();
  public final c x;
  
  public ParcelImpl(Parcel paramParcel)
  {
    x = new b(paramParcel).c();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    new b(paramParcel).a(x);
  }
  
  public static final class a
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
}

/* Location:
 * Qualified Name:     androidx.versionedparcelable.ParcelImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */