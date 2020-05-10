package androidx.core.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;
import e.a.a.a.a;

public class NestedScrollView$c
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<c> CREATOR = new NestedScrollView.c.a();
  public int x;
  
  public NestedScrollView$c(Parcel paramParcel)
  {
    super(paramParcel);
    x = paramParcel.readInt();
  }
  
  public NestedScrollView$c(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = a.a("HorizontalScrollView.SavedState{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" scrollPosition=");
    return a.a(localStringBuilder, x, "}");
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(x);
  }
}

/* Location:
 * Qualified Name:     base.androidx.core.widget.NestedScrollView.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */