package d.s;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import d.v.b;
import java.util.UUID;

@SuppressLint({"BanParcelableUsage"})
public final class f
  implements Parcelable
{
  public static final Parcelable.Creator<f> CREATOR = new a();
  public final Bundle A;
  public final UUID x;
  public final int y;
  public final Bundle z;
  
  public f(Parcel paramParcel)
  {
    x = UUID.fromString(paramParcel.readString());
    y = paramParcel.readInt();
    z = paramParcel.readBundle(f.class.getClassLoader());
    A = paramParcel.readBundle(f.class.getClassLoader());
  }
  
  public f(e parame)
  {
    x = B;
    y = x.z;
    z = y;
    Bundle localBundle = new Bundle();
    A = localBundle;
    A.b(localBundle);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(x.toString());
    paramParcel.writeInt(y);
    paramParcel.writeBundle(z);
    paramParcel.writeBundle(A);
  }
  
  public static final class a
    implements Parcelable.Creator<f>
  {
    public Object createFromParcel(Parcel paramParcel)
    {
      return new f(paramParcel);
    }
    
    public Object[] newArray(int paramInt)
    {
      return new f[paramInt];
    }
  }
}

/* Location:
 * Qualified Name:     d.s.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */