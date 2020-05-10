package com.google.android.material.bottomnavigation;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import d.k.a.a;

public class BottomNavigationView$d
  extends a
{
  public static final Parcelable.Creator<d> CREATOR = new BottomNavigationView.d.a();
  public Bundle z;
  
  public BottomNavigationView$d(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    z = paramParcel.readBundle(paramClassLoader);
  }
  
  public BottomNavigationView$d(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(x, paramInt);
    paramParcel.writeBundle(z);
  }
}

/* Location:
 * Qualified Name:     base.com.google.android.material.bottomnavigation.BottomNavigationView.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */