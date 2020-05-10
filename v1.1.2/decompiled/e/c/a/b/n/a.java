package e.c.a.b.n;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import d.f.h;

public class a
  extends d.k.a.a
{
  public static final Parcelable.Creator<a> CREATOR = new a();
  public final h<String, Bundle> z = new h();
  
  public a(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("ExtendableSavedState{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" states=");
    localStringBuilder.append(z);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(x, paramInt);
    int i = z.z;
    paramParcel.writeInt(i);
    String[] arrayOfString = new String[i];
    Bundle[] arrayOfBundle = new Bundle[i];
    for (paramInt = 0; paramInt < i; paramInt++)
    {
      arrayOfString[paramInt] = ((String)z.c(paramInt));
      arrayOfBundle[paramInt] = ((Bundle)z.e(paramInt));
    }
    paramParcel.writeStringArray(arrayOfString);
    paramParcel.writeTypedArray(arrayOfBundle, 0);
  }
  
  public static final class a
    implements Parcelable.ClassLoaderCreator<a>
  {
    public Object createFromParcel(Parcel paramParcel)
    {
      return new a(paramParcel, null, null);
    }
    
    public Object createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      return new a(paramParcel, paramClassLoader, null);
    }
    
    public Object[] newArray(int paramInt)
    {
      return new a[paramInt];
    }
  }
}

/* Location:
 * Qualified Name:     e.c.a.b.n.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */