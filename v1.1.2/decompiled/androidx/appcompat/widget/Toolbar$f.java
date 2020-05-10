package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import d.k.a.a;

public class Toolbar$f
  extends a
{
  public static final Parcelable.Creator<f> CREATOR = new a();
  public boolean A;
  public int z;
  
  public Toolbar$f(Parcel paramParcel, ClassLoader paramClassLoader)
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
  
  public Toolbar$f(Parcelable paramParcelable)
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
    implements Parcelable.ClassLoaderCreator<Toolbar.f>
  {
    public Object createFromParcel(Parcel paramParcel)
    {
      return new Toolbar.f(paramParcel, null);
    }
    
    public Object createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      return new Toolbar.f(paramParcel, paramClassLoader);
    }
    
    public Object[] newArray(int paramInt)
    {
      return new Toolbar.f[paramInt];
    }
  }
}

/* Location:
 * Qualified Name:     androidx.appcompat.widget.Toolbar.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */