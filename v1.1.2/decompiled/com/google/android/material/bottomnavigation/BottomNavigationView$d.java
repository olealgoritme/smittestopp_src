package com.google.android.material.bottomnavigation;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import d.k.a.a;

public class BottomNavigationView$d
  extends a
{
  public static final Parcelable.Creator<d> CREATOR = new a();
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
  
  public static final class a
    implements Parcelable.ClassLoaderCreator<BottomNavigationView.d>
  {
    public Object createFromParcel(Parcel paramParcel)
    {
      return new BottomNavigationView.d(paramParcel, null);
    }
    
    public Object createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      return new BottomNavigationView.d(paramParcel, paramClassLoader);
    }
    
    public Object[] newArray(int paramInt)
    {
      return new BottomNavigationView.d[paramInt];
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.material.bottomnavigation.BottomNavigationView.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */