package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SearchView$o
  extends d.k.a.a
{
  public static final Parcelable.Creator<o> CREATOR = new SearchView.o.a();
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
}

/* Location:
 * Qualified Name:     base.androidx.appcompat.widget.SearchView.o
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */