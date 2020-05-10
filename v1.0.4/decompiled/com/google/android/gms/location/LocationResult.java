package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import d.b.a.r;
import e.c.a.a.b.j.s.a;
import e.c.a.a.e.f;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class LocationResult
  extends a
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<LocationResult> CREATOR = new f();
  public static final List<Location> y = ;
  public final List<Location> x;
  
  public LocationResult(List<Location> paramList)
  {
    x = paramList;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof LocationResult)) {
      return false;
    }
    paramObject = (LocationResult)paramObject;
    if (x.size() != x.size()) {
      return false;
    }
    Iterator localIterator1 = x.iterator();
    Iterator localIterator2 = x.iterator();
    while (localIterator1.hasNext())
    {
      paramObject = (Location)localIterator2.next();
      Location localLocation = (Location)localIterator1.next();
      if (((Location)paramObject).getTime() != localLocation.getTime()) {
        return false;
      }
    }
    return true;
  }
  
  public final int hashCode()
  {
    Iterator localIterator = x.iterator();
    long l;
    for (int i = 17; localIterator.hasNext(); i = i * 31 + (int)(l ^ l >>> 32)) {
      l = ((Location)localIterator.next()).getTime();
    }
    return i;
  }
  
  public final String toString()
  {
    String str = String.valueOf(x);
    StringBuilder localStringBuilder = new StringBuilder(str.length() + 27);
    localStringBuilder.append("LocationResult[locations: ");
    localStringBuilder.append(str);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = r.a(paramParcel);
    r.a(paramParcel, 1, x, false);
    r.k(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     base.com.google.android.gms.location.LocationResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */