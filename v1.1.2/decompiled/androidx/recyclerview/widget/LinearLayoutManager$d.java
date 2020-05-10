package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class LinearLayoutManager$d
  implements Parcelable
{
  public static final Parcelable.Creator<d> CREATOR = new a();
  public int x;
  public int y;
  public boolean z;
  
  public LinearLayoutManager$d() {}
  
  public LinearLayoutManager$d(Parcel paramParcel)
  {
    x = paramParcel.readInt();
    y = paramParcel.readInt();
    int i = paramParcel.readInt();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    z = bool;
  }
  
  public LinearLayoutManager$d(d paramd)
  {
    x = x;
    y = y;
    z = z;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(x);
    paramParcel.writeInt(y);
    paramParcel.writeInt(z);
  }
  
  public static final class a
    implements Parcelable.Creator<LinearLayoutManager.d>
  {
    public Object createFromParcel(Parcel paramParcel)
    {
      return new LinearLayoutManager.d(paramParcel);
    }
    
    public Object[] newArray(int paramInt)
    {
      return new LinearLayoutManager.d[paramInt];
    }
  }
}

/* Location:
 * Qualified Name:     androidx.recyclerview.widget.LinearLayoutManager.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */