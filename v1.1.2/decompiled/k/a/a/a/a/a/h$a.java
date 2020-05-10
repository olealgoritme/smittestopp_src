package k.a.a.a.a.a;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable.Creator;

public final class h$a
  implements Parcelable.Creator<h>
{
  public Object createFromParcel(Parcel paramParcel)
  {
    h.b localb = new h.b();
    if (paramParcel.readInt() == 1) {
      a = paramParcel.readString();
    }
    if (paramParcel.readInt() == 1) {
      localb.a(paramParcel.readString());
    }
    Object localObject1;
    Object localObject2;
    if (paramParcel.readInt() == 1)
    {
      localObject1 = (ParcelUuid)paramParcel.readParcelable(ParcelUuid.class.getClassLoader());
      localb.a((ParcelUuid)localObject1);
      if (paramParcel.readInt() == 1)
      {
        localObject2 = (ParcelUuid)paramParcel.readParcelable(ParcelUuid.class.getClassLoader());
        if ((localObject2 != null) && (localObject1 == null)) {
          throw new IllegalArgumentException("uuid is null while uuidMask is not null!");
        }
        c = ((ParcelUuid)localObject1);
        d = ((ParcelUuid)localObject2);
      }
    }
    if (paramParcel.readInt() == 1)
    {
      ParcelUuid localParcelUuid = (ParcelUuid)paramParcel.readParcelable(ParcelUuid.class.getClassLoader());
      if (paramParcel.readInt() == 1)
      {
        localObject2 = new byte[paramParcel.readInt()];
        paramParcel.readByteArray((byte[])localObject2);
        if (paramParcel.readInt() == 0)
        {
          if (localParcelUuid != null)
          {
            e = localParcelUuid;
            f = ((byte[])localObject2);
            g = null;
          }
          else
          {
            throw new IllegalArgumentException("serviceDataUuid is null!");
          }
        }
        else
        {
          localObject1 = new byte[paramParcel.readInt()];
          paramParcel.readByteArray((byte[])localObject1);
          localb.a(localParcelUuid, (byte[])localObject2, (byte[])localObject1);
        }
      }
    }
    int i = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      localObject1 = new byte[paramParcel.readInt()];
      paramParcel.readByteArray((byte[])localObject1);
      if (paramParcel.readInt() == 0)
      {
        if (i >= 0)
        {
          h = i;
          i = ((byte[])localObject1);
          j = null;
        }
        else
        {
          throw new IllegalArgumentException("invalid manufacture id");
        }
      }
      else
      {
        localObject2 = new byte[paramParcel.readInt()];
        paramParcel.readByteArray((byte[])localObject2);
        localb.a(i, (byte[])localObject1, (byte[])localObject2);
      }
    }
    return localb.a();
  }
  
  public Object[] newArray(int paramInt)
  {
    return new h[paramInt];
  }
}

/* Location:
 * Qualified Name:     k.a.a.a.a.a.h.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */