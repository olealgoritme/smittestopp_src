package e.c.a.b.d;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class e$a
  implements Parcelable
{
  public static final Parcelable.Creator<a> CREATOR = new a();
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
  
  public static final class a
    implements Parcelable.Creator<e.a>
  {
    public Object createFromParcel(Parcel paramParcel)
    {
      return new e.a(paramParcel);
    }
    
    public Object[] newArray(int paramInt)
    {
      return new e.a[paramInt];
    }
  }
}

/* Location:
 * Qualified Name:     e.c.a.b.d.e.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */