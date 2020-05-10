package com.google.android.material.bottomappbar;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import d.k.a.a;

public class BottomAppBar$a
  extends a
{
  public static final Parcelable.Creator<a> CREATOR = new BottomAppBar.a.a();
  public boolean A;
  public int z;
  
  public BottomAppBar$a(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    z = paramParcel.readInt();
    boolean bool;
    if (paramParcel.readInt() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    A = bool;
  }
  
  public BottomAppBar$a(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(x, paramInt);
    paramParcel.writeInt(z);
    paramParcel.writeInt(A);
  }
}

/* Location:
 * Qualified Name:     base.com.google.android.material.bottomappbar.BottomAppBar.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */