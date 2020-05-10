package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import d.k.a.a;

public class RecyclerView$s
  extends a
{
  public static final Parcelable.Creator<s> CREATOR = new a();
  public Parcelable z;
  
  public RecyclerView$s(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    if (paramClassLoader == null) {
      paramClassLoader = RecyclerView.LayoutManager.class.getClassLoader();
    }
    z = paramParcel.readParcelable(paramClassLoader);
  }
  
  public RecyclerView$s(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(x, paramInt);
    paramParcel.writeParcelable(z, 0);
  }
  
  public static final class a
    implements Parcelable.ClassLoaderCreator<RecyclerView.s>
  {
    public Object createFromParcel(Parcel paramParcel)
    {
      return new RecyclerView.s(paramParcel, null);
    }
    
    public Object createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      return new RecyclerView.s(paramParcel, paramClassLoader);
    }
    
    public Object[] newArray(int paramInt)
    {
      return new RecyclerView.s[paramInt];
    }
  }
}

/* Location:
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.s
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */