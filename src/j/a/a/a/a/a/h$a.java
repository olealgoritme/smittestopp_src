package j.a.a.a.a.a;

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
      localObject2 = (ParcelUuid)paramParcel.readParcelable(ParcelUuid.class.getClassLoader());
      if (paramParcel.readInt() == 1)
      {
        localObject1 = new byte[paramParcel.readInt()];
        paramParcel.readByteArray((byte[])localObject1);
        if (paramParcel.readInt() == 0)
        {
          if (localObject2 != null)
          {
            e = ((ParcelUuid)localObject2);
            f = ((byte[])localObject1);
            g = null;
          }
          else
          {
            throw new IllegalArgumentException("serviceDataUuid is null!");
          }
        }
        else
        {
          byte[] arrayOfByte = new byte[paramParcel.readInt()];
          paramParcel.readByteArray(arrayOfByte);
          localb.a((ParcelUuid)localObject2, (byte[])localObject1, arrayOfByte);
        }
      }
    }
    int i = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      localObject2 = new byte[paramParcel.readInt()];
      paramParcel.readByteArray((byte[])localObject2);
      if (paramParcel.readInt() == 0)
      {
        if (i >= 0)
        {
          h = i;
          i = ((byte[])localObject2);
          j = null;
        }
        else
        {
          throw new IllegalArgumentException("invalid manufacture id");
        }
      }
      else
      {
        localObject1 = new byte[paramParcel.readInt()];
        paramParcel.readByteArray((byte[])localObject1);
        localb.a(i, (byte[])localObject2, (byte[])localObject1);
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
 * Qualified Name:     base.j.a.a.a.a.a.h.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */