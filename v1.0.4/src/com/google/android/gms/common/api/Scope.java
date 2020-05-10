package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import d.b.a.r;
import e.c.a.a.b.i.l;
import e.c.a.a.b.j.s.a;

public final class Scope
  extends a
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<Scope> CREATOR = new l();
  public final int x;
  public final String y;
  
  public Scope(int paramInt, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      x = paramInt;
      y = paramString;
      return;
    }
    throw new IllegalArgumentException("scopeUri must not be null or empty");
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Scope)) {
      return false;
    }
    return y.equals(y);
  }
  
  public final int hashCode()
  {
    return y.hashCode();
  }
  
  public final String toString()
  {
    return y;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = r.a(paramParcel);
    r.a(paramParcel, 1, x);
    r.a(paramParcel, 2, y, false);
    r.k(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     base.com.google.android.gms.common.api.Scope
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */