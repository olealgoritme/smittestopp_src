package e.c.a.a.d.c;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import d.b.a.s;
import e.c.a.a.b.j.c;
import e.c.a.a.b.j.s.a;
import e.c.a.a.e.j;
import java.util.Collections;
import java.util.List;

public final class x
  extends a
{
  public static final List<c> A = ;
  public static final j B = new j();
  public static final Parcelable.Creator<x> CREATOR = new y();
  public j x;
  public List<c> y;
  public String z;
  
  public x(j paramj, List<c> paramList, String paramString)
  {
    x = paramj;
    y = paramList;
    z = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof x)) {
      return false;
    }
    paramObject = (x)paramObject;
    return (s.c(x, x)) && (s.c(y, y)) && (s.c(z, z));
  }
  
  public final int hashCode()
  {
    return x.hashCode();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = s.a(paramParcel);
    s.a(paramParcel, 1, x, paramInt, false);
    s.a(paramParcel, 2, y, false);
    s.a(paramParcel, 3, z, false);
    s.k(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.d.c.x
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */