package j.a.a.a.a.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class k
  implements Parcelable
{
  public static final Parcelable.Creator<k> CREATOR = new k.a();
  public int A;
  public long B;
  public int C;
  public int D;
  public boolean E;
  public boolean F;
  public boolean G;
  public long H;
  public long I;
  public boolean J;
  public int K;
  public final long x;
  public final long y;
  public int z;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(z);
    paramParcel.writeInt(A);
    paramParcel.writeLong(B);
    paramParcel.writeInt(C);
    paramParcel.writeInt(D);
    paramParcel.writeInt(J);
    paramParcel.writeInt(K);
    paramParcel.writeInt(E);
    paramParcel.writeInt(F);
    paramParcel.writeLong(x);
    paramParcel.writeLong(y);
  }
}

/* Location:
 * Qualified Name:     base.j.a.a.a.a.a.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */