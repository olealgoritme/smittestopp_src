package d.l.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import d.k.a.a;

public class a$c
  extends a
{
  public static final Parcelable.Creator<c> CREATOR = new a.c.a();
  public int A;
  public int B;
  public int C;
  public int D;
  public int z = 0;
  
  public a$c(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    z = paramParcel.readInt();
    A = paramParcel.readInt();
    B = paramParcel.readInt();
    C = paramParcel.readInt();
    D = paramParcel.readInt();
  }
  
  public a$c(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(x, paramInt);
    paramParcel.writeInt(z);
    paramParcel.writeInt(A);
    paramParcel.writeInt(B);
    paramParcel.writeInt(C);
    paramParcel.writeInt(D);
  }
}

/* Location:
 * Qualified Name:     base.d.l.a.a.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */