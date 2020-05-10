package d.b.e;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

@SuppressLint({"BanParcelableUsage"})
public class c$g
  implements Parcelable
{
  public static final Parcelable.Creator<g> CREATOR = new c.g.a();
  public int x;
  
  public c$g() {}
  
  public c$g(Parcel paramParcel)
  {
    x = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(x);
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.c.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */