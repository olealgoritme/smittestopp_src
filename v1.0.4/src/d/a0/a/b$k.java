package d.a0.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class b$k
  extends d.k.a.a
{
  public static final Parcelable.Creator<k> CREATOR = new b.k.a();
  public Parcelable A;
  public ClassLoader B;
  public int z;
  
  public b$k(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    ClassLoader localClassLoader = paramClassLoader;
    if (paramClassLoader == null) {
      localClassLoader = k.class.getClassLoader();
    }
    z = paramParcel.readInt();
    A = paramParcel.readParcelable(localClassLoader);
    B = localClassLoader;
  }
  
  public b$k(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("FragmentPager.SavedState{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" position=");
    return e.a.a.a.a.a(localStringBuilder, z, "}");
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(x, paramInt);
    paramParcel.writeInt(z);
    paramParcel.writeParcelable(A, paramInt);
  }
}

/* Location:
 * Qualified Name:     base.d.a0.a.b.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */