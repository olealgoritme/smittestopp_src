package e.c.a.a.d.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import d.b.a.r;
import e.c.a.a.b.j.s.a;
import e.c.a.a.e.o;
import e.c.a.a.e.p;

public final class z
  extends a
{
  public static final Parcelable.Creator<z> CREATOR = new a0();
  public d A;
  public int x;
  public x y;
  public o z;
  
  public z(int paramInt, x paramx, IBinder paramIBinder1, IBinder paramIBinder2)
  {
    x = paramInt;
    y = paramx;
    Object localObject = null;
    if (paramIBinder1 == null) {
      paramx = null;
    } else {
      paramx = p.a(paramIBinder1);
    }
    z = paramx;
    if (paramIBinder2 == null)
    {
      paramx = (x)localObject;
    }
    else
    {
      paramx = paramIBinder2.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
      if ((paramx instanceof d)) {
        paramx = (d)paramx;
      } else {
        paramx = new f(paramIBinder2);
      }
    }
    A = paramx;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = r.a(paramParcel);
    r.a(paramParcel, 1, x);
    r.a(paramParcel, 2, y, paramInt, false);
    Object localObject1 = z;
    Object localObject2 = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((IInterface)localObject1).asBinder();
    }
    r.a(paramParcel, 3, (IBinder)localObject1, false);
    localObject1 = A;
    if (localObject1 == null) {
      localObject1 = localObject2;
    } else {
      localObject1 = ((IInterface)localObject1).asBinder();
    }
    r.a(paramParcel, 4, (IBinder)localObject1, false);
    r.k(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.d.c.z
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */