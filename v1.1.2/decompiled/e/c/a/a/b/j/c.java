package e.c.a.a.b.j;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import d.b.a.s;
import e.c.a.a.b.j.s.a;

public class c
  extends a
{
  public static final Parcelable.Creator<c> CREATOR = new t();
  public final int x;
  public final String y;
  
  public c(int paramInt, String paramString)
  {
    x = paramInt;
    y = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject != null) && ((paramObject instanceof c)))
    {
      paramObject = (c)paramObject;
      if ((x == x) && (s.c(y, y))) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    return x;
  }
  
  public String toString()
  {
    int i = x;
    String str = y;
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 12);
    localStringBuilder.append(i);
    localStringBuilder.append(":");
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = s.a(paramParcel);
    s.a(paramParcel, 1, x);
    s.a(paramParcel, 2, y, false);
    s.k(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.b.j.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */