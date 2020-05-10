package com.google.android.material.bottomsheet;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import d.k.a.a;

public class BottomSheetBehavior$c
  extends a
{
  public static final Parcelable.Creator<c> CREATOR = new a();
  public final int z;
  
  public BottomSheetBehavior$c(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    z = paramParcel.readInt();
  }
  
  public BottomSheetBehavior$c(Parcelable paramParcelable, int paramInt)
  {
    super(paramParcelable);
    z = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(x, paramInt);
    paramParcel.writeInt(z);
  }
  
  public static final class a
    implements Parcelable.ClassLoaderCreator<BottomSheetBehavior.c>
  {
    public Object createFromParcel(Parcel paramParcel)
    {
      return new BottomSheetBehavior.c(paramParcel, null);
    }
    
    public Object createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      return new BottomSheetBehavior.c(paramParcel, paramClassLoader);
    }
    
    public Object[] newArray(int paramInt)
    {
      return new BottomSheetBehavior.c[paramInt];
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.material.bottomsheet.BottomSheetBehavior.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */