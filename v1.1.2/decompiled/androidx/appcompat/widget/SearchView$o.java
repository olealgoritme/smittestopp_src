package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;

public class SearchView$o
  extends d.k.a.a
{
  public static final Parcelable.Creator<o> CREATOR = new a();
  public boolean z;
  
  public SearchView$o(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    z = ((Boolean)paramParcel.readValue(null)).booleanValue();
  }
  
  public SearchView$o(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("SearchView.SavedState{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" isIconified=");
    localStringBuilder.append(z);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(x, paramInt);
    paramParcel.writeValue(Boolean.valueOf(z));
  }
  
  public static final class a
    implements Parcelable.ClassLoaderCreator<SearchView.o>
  {
    public Object createFromParcel(Parcel paramParcel)
    {
      return new SearchView.o(paramParcel, null);
    }
    
    public Object createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      return new SearchView.o(paramParcel, paramClassLoader);
    }
    
    public Object[] newArray(int paramInt)
    {
      return new SearchView.o[paramInt];
    }
  }
}

/* Location:
 * Qualified Name:     androidx.appcompat.widget.SearchView.o
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */