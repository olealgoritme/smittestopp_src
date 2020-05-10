package d.m.a;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;

@SuppressLint({"BanParcelableUsage"})
public final class u
  implements Parcelable
{
  public static final Parcelable.Creator<u> CREATOR = new a();
  public final int A;
  public final int B;
  public final String C;
  public final boolean D;
  public final boolean E;
  public final boolean F;
  public final Bundle G;
  public final boolean H;
  public final int I;
  public Bundle J;
  public final String x;
  public final String y;
  public final boolean z;
  
  public u(Parcel paramParcel)
  {
    x = paramParcel.readString();
    y = paramParcel.readString();
    int i = paramParcel.readInt();
    boolean bool1 = true;
    boolean bool2;
    if (i != 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    z = bool2;
    A = paramParcel.readInt();
    B = paramParcel.readInt();
    C = paramParcel.readString();
    if (paramParcel.readInt() != 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    D = bool2;
    if (paramParcel.readInt() != 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    E = bool2;
    if (paramParcel.readInt() != 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    F = bool2;
    G = paramParcel.readBundle();
    if (paramParcel.readInt() != 0) {
      bool2 = bool1;
    } else {
      bool2 = false;
    }
    H = bool2;
    J = paramParcel.readBundle();
    I = paramParcel.readInt();
  }
  
  public u(Fragment paramFragment)
  {
    x = paramFragment.getClass().getName();
    y = mWho;
    z = mFromLayout;
    A = mFragmentId;
    B = mContainerId;
    C = mTag;
    D = mRetainInstance;
    E = mRemoving;
    F = mDetached;
    G = mArguments;
    H = mHidden;
    I = mMaxState.ordinal();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("FragmentState{");
    localStringBuilder.append(x);
    localStringBuilder.append(" (");
    localStringBuilder.append(y);
    localStringBuilder.append(")}:");
    if (z) {
      localStringBuilder.append(" fromLayout");
    }
    if (B != 0)
    {
      localStringBuilder.append(" id=0x");
      localStringBuilder.append(Integer.toHexString(B));
    }
    String str = C;
    if ((str != null) && (!str.isEmpty()))
    {
      localStringBuilder.append(" tag=");
      localStringBuilder.append(C);
    }
    if (D) {
      localStringBuilder.append(" retainInstance");
    }
    if (E) {
      localStringBuilder.append(" removing");
    }
    if (F) {
      localStringBuilder.append(" detached");
    }
    if (H) {
      localStringBuilder.append(" hidden");
    }
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(x);
    paramParcel.writeString(y);
    paramParcel.writeInt(z);
    paramParcel.writeInt(A);
    paramParcel.writeInt(B);
    paramParcel.writeString(C);
    paramParcel.writeInt(D);
    paramParcel.writeInt(E);
    paramParcel.writeInt(F);
    paramParcel.writeBundle(G);
    paramParcel.writeInt(H);
    paramParcel.writeBundle(J);
    paramParcel.writeInt(I);
  }
  
  public static final class a
    implements Parcelable.Creator<u>
  {
    public Object createFromParcel(Parcel paramParcel)
    {
      return new u(paramParcel);
    }
    
    public Object[] newArray(int paramInt)
    {
      return new u[paramInt];
    }
  }
}

/* Location:
 * Qualified Name:     d.m.a.u
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */