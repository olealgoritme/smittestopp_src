package e.c.a.b.d;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class e$a
  implements Parcelable
{
  public static final Parcelable.Creator<a> CREATOR = new e.a.a();
  public int x;
  
  public e$a() {}
  
  public e$a(Parcel paramParcel)
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
 * Qualified Name:     base.e.c.a.b.d.e.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */