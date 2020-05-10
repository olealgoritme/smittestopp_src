package d.b.e;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

public class w$e
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<e> CREATOR = new w.e.a();
  public boolean x;
  
  public w$e(Parcel paramParcel)
  {
    super(paramParcel);
    boolean bool;
    if (paramParcel.readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    x = bool;
  }
  
  public w$e(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeByte((byte)x);
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.w.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */