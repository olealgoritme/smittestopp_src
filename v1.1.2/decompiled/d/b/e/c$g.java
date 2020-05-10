package d.b.e;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class c$g
  implements Parcelable
{
  public static final Parcelable.Creator<g> CREATOR = new a();
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
  
  public static final class a
    implements Parcelable.Creator<c.g>
  {
    public Object createFromParcel(Parcel paramParcel)
    {
      return new c.g(paramParcel);
    }
    
    public Object[] newArray(int paramInt)
    {
      return new c.g[paramInt];
    }
  }
}

/* Location:
 * Qualified Name:     d.b.e.c.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */