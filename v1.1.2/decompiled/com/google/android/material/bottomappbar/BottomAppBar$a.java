package com.google.android.material.bottomappbar;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import d.k.a.a;

public class BottomAppBar$a
  extends a
{
  public static final Parcelable.Creator<a> CREATOR = new a();
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
  
  public static final class a
    implements Parcelable.ClassLoaderCreator<BottomAppBar.a>
  {
    public Object createFromParcel(Parcel paramParcel)
    {
      return new BottomAppBar.a(paramParcel, null);
    }
    
    public Object createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      return new BottomAppBar.a(paramParcel, paramClassLoader);
    }
    
    public Object[] newArray(int paramInt)
    {
      return new BottomAppBar.a[paramInt];
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.material.bottomappbar.BottomAppBar.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */