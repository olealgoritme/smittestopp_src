package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import e.a.a.a.a;
import java.util.Arrays;

public class StaggeredGridLayoutManager$d$a
  implements Parcelable
{
  public static final Parcelable.Creator<a> CREATOR = new StaggeredGridLayoutManager.d.a.a();
  public boolean A;
  public int x;
  public int y;
  public int[] z;
  
  public StaggeredGridLayoutManager$d$a() {}
  
  public StaggeredGridLayoutManager$d$a(Parcel paramParcel)
  {
    x = paramParcel.readInt();
    y = paramParcel.readInt();
    int i = paramParcel.readInt();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    A = bool;
    i = paramParcel.readInt();
    if (i > 0)
    {
      int[] arrayOfInt = new int[i];
      z = arrayOfInt;
      paramParcel.readIntArray(arrayOfInt);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = a.a("FullSpanItem{mPosition=");
    localStringBuilder.append(x);
    localStringBuilder.append(", mGapDir=");
    localStringBuilder.append(y);
    localStringBuilder.append(", mHasUnwantedGapAfter=");
    localStringBuilder.append(A);
    localStringBuilder.append(", mGapPerSpan=");
    localStringBuilder.append(Arrays.toString(z));
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(x);
    paramParcel.writeInt(y);
    paramParcel.writeInt(A);
    int[] arrayOfInt = z;
    if ((arrayOfInt != null) && (arrayOfInt.length > 0))
    {
      paramParcel.writeInt(arrayOfInt.length);
      paramParcel.writeIntArray(z);
    }
    else
    {
      paramParcel.writeInt(0);
    }
  }
}

/* Location:
 * Qualified Name:     base.androidx.recyclerview.widget.StaggeredGridLayoutManager.d.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */