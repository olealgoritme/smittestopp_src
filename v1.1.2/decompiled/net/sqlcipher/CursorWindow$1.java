package net.sqlcipher;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class CursorWindow$1
  implements Parcelable.Creator<CursorWindow>
{
  public CursorWindow createFromParcel(Parcel paramParcel)
  {
    return new CursorWindow(paramParcel, 0);
  }
  
  public CursorWindow[] newArray(int paramInt)
  {
    return new CursorWindow[paramInt];
  }
}

/* Location:
 * Qualified Name:     net.sqlcipher.CursorWindow.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */