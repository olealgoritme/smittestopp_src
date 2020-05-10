package k.a.a.a.a.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import e.a.a.a.a;

public final class k
  implements Parcelable
{
  public static final Parcelable.Creator<k> CREATOR = new a();
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
  
  public static final class a
    implements Parcelable.Creator<k>
  {
    public Object createFromParcel(Parcel paramParcel)
    {
      return new k(paramParcel, null);
    }
    
    public Object[] newArray(int paramInt)
    {
      return new k[paramInt];
    }
  }
  
  public static final class b
  {
    public int a = 0;
    public int b = 1;
    public long c = 0L;
    public int d = 1;
    public int e = 3;
    public boolean f = true;
    public int g = 255;
    public boolean h = true;
    public boolean i = true;
    public boolean j = true;
    public long k = 10000L;
    public long l = 10000L;
    public long m = 0L;
    public long n = 0L;
    
    public b a(int paramInt)
    {
      if ((paramInt >= -1) && (paramInt <= 2))
      {
        a = paramInt;
        return this;
      }
      throw new IllegalArgumentException(a.a("invalid scan mode ", paramInt));
    }
    
    public k a()
    {
      if ((m == 0L) && (n == 0L))
      {
        int i1 = a;
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            n = 500L;
            m = 4500L;
          }
          else
          {
            n = 0L;
            m = 0L;
          }
        }
        else
        {
          n = 2000L;
          m = 3000L;
        }
      }
      return new k(a, b, c, d, e, f, g, h, i, j, k, l, n, m, null);
    }
  }
}

/* Location:
 * Qualified Name:     k.a.a.a.a.a.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */