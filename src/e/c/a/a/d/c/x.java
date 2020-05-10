package e.c.a.a.d.c;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import d.b.a.r;
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
    return (r.c(x, x)) && (r.c(y, y)) && (r.c(z, z));
  }
  
  public final int hashCode()
  {
    return x.hashCode();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = r.a(paramParcel);
    r.a(paramParcel, 1, x, paramInt, false);
    r.a(paramParcel, 2, y, false);
    r.a(paramParcel, 3, z, false);
    r.k(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.d.c.x
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */