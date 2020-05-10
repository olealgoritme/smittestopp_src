package d.m.a;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
public final class s
  implements Parcelable
{
  public static final Parcelable.Creator<s> CREATOR = new s.a();
  public int A;
  public String B = null;
  public ArrayList<u> x;
  public ArrayList<String> y;
  public b[] z;
  
  public s() {}
  
  public s(Parcel paramParcel)
  {
    x = paramParcel.createTypedArrayList(u.CREATOR);
    y = paramParcel.createStringArrayList();
    z = ((b[])paramParcel.createTypedArray(b.CREATOR));
    A = paramParcel.readInt();
    B = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedList(x);
    paramParcel.writeStringList(y);
    paramParcel.writeTypedArray(z, paramInt);
    paramParcel.writeInt(A);
    paramParcel.writeString(B);
  }
}

/* Location:
 * Qualified Name:     base.d.m.a.s
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */