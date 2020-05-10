package e.c.a.a.d.c;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import e.c.a.a.b.j.s.a;
import e.c.a.a.e.u;
import e.c.a.a.e.v;

public final class s
  extends a
{
  public static final Parcelable.Creator<s> CREATOR = new t();
  public PendingIntent A;
  public e.c.a.a.e.r B;
  public d C;
  public int x;
  public q y;
  public u z;
  
  public s(int paramInt, q paramq, IBinder paramIBinder1, PendingIntent paramPendingIntent, IBinder paramIBinder2, IBinder paramIBinder3)
  {
    x = paramInt;
    y = paramq;
    Object localObject = null;
    if (paramIBinder1 == null) {
      paramq = null;
    } else {
      paramq = v.a(paramIBinder1);
    }
    z = paramq;
    A = paramPendingIntent;
    if (paramIBinder2 == null) {
      paramq = null;
    } else {
      paramq = e.c.a.a.e.s.a(paramIBinder2);
    }
    B = paramq;
    if (paramIBinder3 == null)
    {
      paramq = (q)localObject;
    }
    else
    {
      paramq = paramIBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
      if ((paramq instanceof d)) {
        paramq = (d)paramq;
      } else {
        paramq = new f(paramIBinder3);
      }
    }
    C = paramq;
  }
  
  public static s a(e.c.a.a.e.r paramr, d paramd)
  {
    IBinder localIBinder = paramr.asBinder();
    if (paramd != null) {
      paramr = paramd.asBinder();
    } else {
      paramr = null;
    }
    return new s(2, null, null, null, localIBinder, paramr);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = d.b.a.r.a(paramParcel);
    d.b.a.r.a(paramParcel, 1, x);
    d.b.a.r.a(paramParcel, 2, y, paramInt, false);
    Object localObject1 = z;
    Object localObject2 = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((IInterface)localObject1).asBinder();
    }
    d.b.a.r.a(paramParcel, 3, (IBinder)localObject1, false);
    d.b.a.r.a(paramParcel, 4, A, paramInt, false);
    localObject1 = B;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((IInterface)localObject1).asBinder();
    }
    d.b.a.r.a(paramParcel, 5, (IBinder)localObject1, false);
    localObject1 = C;
    if (localObject1 == null) {
      localObject1 = localObject2;
    } else {
      localObject1 = ((IInterface)localObject1).asBinder();
    }
    d.b.a.r.a(paramParcel, 6, (IBinder)localObject1, false);
    d.b.a.r.k(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.d.c.s
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */