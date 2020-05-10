package androidx.coordinatorlayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import d.k.a.a;

public class CoordinatorLayout$h
  extends a
{
  public static final Parcelable.Creator<h> CREATOR = new a();
  public SparseArray<Parcelable> z;
  
  public CoordinatorLayout$h(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    int i = paramParcel.readInt();
    int[] arrayOfInt = new int[i];
    paramParcel.readIntArray(arrayOfInt);
    paramParcel = paramParcel.readParcelableArray(paramClassLoader);
    z = new SparseArray(i);
    for (int j = 0; j < i; j++) {
      z.append(arrayOfInt[j], paramParcel[j]);
    }
  }
  
  public CoordinatorLayout$h(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(x, paramInt);
    Object localObject = z;
    int i = 0;
    int j;
    if (localObject != null) {
      j = ((SparseArray)localObject).size();
    } else {
      j = 0;
    }
    paramParcel.writeInt(j);
    int[] arrayOfInt = new int[j];
    localObject = new Parcelable[j];
    while (i < j)
    {
      arrayOfInt[i] = z.keyAt(i);
      localObject[i] = ((Parcelable)z.valueAt(i));
      i++;
    }
    paramParcel.writeIntArray(arrayOfInt);
    paramParcel.writeParcelableArray((Parcelable[])localObject, paramInt);
  }
  
  public static final class a
    implements Parcelable.ClassLoaderCreator<CoordinatorLayout.h>
  {
    public Object createFromParcel(Parcel paramParcel)
    {
      return new CoordinatorLayout.h(paramParcel, null);
    }
    
    public Object createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      return new CoordinatorLayout.h(paramParcel, paramClassLoader);
    }
    
    public Object[] newArray(int paramInt)
    {
      return new CoordinatorLayout.h[paramInt];
    }
  }
}

/* Location:
 * Qualified Name:     androidx.coordinatorlayout.widget.CoordinatorLayout.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */