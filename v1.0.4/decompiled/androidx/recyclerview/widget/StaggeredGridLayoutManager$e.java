package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class StaggeredGridLayoutManager$e
  implements Parcelable
{
  public static final Parcelable.Creator<e> CREATOR = new StaggeredGridLayoutManager.e.a();
  public int[] A;
  public int B;
  public int[] C;
  public List<StaggeredGridLayoutManager.d.a> D;
  public boolean E;
  public boolean F;
  public boolean G;
  public int x;
  public int y;
  public int z;
  
  public StaggeredGridLayoutManager$e() {}
  
  public StaggeredGridLayoutManager$e(Parcel paramParcel)
  {
    x = paramParcel.readInt();
    y = paramParcel.readInt();
    int i = paramParcel.readInt();
    z = i;
    int[] arrayOfInt;
    if (i > 0)
    {
      arrayOfInt = new int[i];
      A = arrayOfInt;
      paramParcel.readIntArray(arrayOfInt);
    }
    i = paramParcel.readInt();
    B = i;
    if (i > 0)
    {
      arrayOfInt = new int[i];
      C = arrayOfInt;
      paramParcel.readIntArray(arrayOfInt);
    }
    i = paramParcel.readInt();
    boolean bool1 = false;
    if (i == 1) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    E = bool2;
    if (paramParcel.readInt() == 1) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    F = bool2;
    boolean bool2 = bool1;
    if (paramParcel.readInt() == 1) {
      bool2 = true;
    }
    G = bool2;
    D = paramParcel.readArrayList(StaggeredGridLayoutManager.d.a.class.getClassLoader());
  }
  
  public StaggeredGridLayoutManager$e(e parame)
  {
    z = z;
    x = x;
    y = y;
    A = A;
    B = B;
    C = C;
    E = E;
    F = F;
    G = G;
    D = D;
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
    if (z > 0) {
      paramParcel.writeIntArray(A);
    }
    paramParcel.writeInt(B);
    if (B > 0) {
      paramParcel.writeIntArray(C);
    }
    paramParcel.writeInt(E);
    paramParcel.writeInt(F);
    paramParcel.writeInt(G);
    paramParcel.writeList(D);
  }
}

/* Location:
 * Qualified Name:     base.androidx.recyclerview.widget.StaggeredGridLayoutManager.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */