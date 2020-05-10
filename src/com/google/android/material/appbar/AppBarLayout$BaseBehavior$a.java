package com.google.android.material.appbar;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import d.k.a.a;

public class AppBarLayout$BaseBehavior$a
  extends a
{
  public static final Parcelable.Creator<a> CREATOR = new AppBarLayout.BaseBehavior.a.a();
  public float A;
  public boolean B;
  public int z;
  
  public AppBarLayout$BaseBehavior$a(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    z = paramParcel.readInt();
    A = paramParcel.readFloat();
    boolean bool;
    if (paramParcel.readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    B = bool;
  }
  
  public AppBarLayout$BaseBehavior$a(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(x, paramInt);
    paramParcel.writeInt(z);
    paramParcel.writeFloat(A);
    paramParcel.writeByte((byte)B);
  }
}

/* Location:
 * Qualified Name:     base.com.google.android.material.appbar.AppBarLayout.BaseBehavior.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */