package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

@SuppressLint({"BanParcelableUsage"})
public class Fragment$g
  implements Parcelable
{
  public static final Parcelable.Creator<g> CREATOR = new Fragment.g.a();
  public final Bundle x;
  
  public Fragment$g(Bundle paramBundle)
  {
    x = paramBundle;
  }
  
  public Fragment$g(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    paramParcel = paramParcel.readBundle();
    x = paramParcel;
    if ((paramClassLoader != null) && (paramParcel != null)) {
      paramParcel.setClassLoader(paramClassLoader);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeBundle(x);
  }
}

/* Location:
 * Qualified Name:     base.androidx.fragment.app.Fragment.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */