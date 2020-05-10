package j.a.a.a.a.a;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import e.a.a.a.a;
import e.c.a.a.b.l.c;
import java.util.Arrays;

public final class h
  implements Parcelable
{
  public static final Parcelable.Creator<h> CREATOR = new h.a();
  public final ParcelUuid A;
  public final ParcelUuid B;
  public final byte[] C;
  public final byte[] D;
  public final int E;
  public final byte[] F;
  public final byte[] G;
  public final String x;
  public final String y;
  public final ParcelUuid z;
  
  static
  {
    new h(null, null, null, null, null, null, null, -1, null, null, null);
  }
  
  public final boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    boolean bool = true;
    if (paramArrayOfByte1 == null)
    {
      if (paramArrayOfByte3 == null) {
        bool = false;
      }
      return bool;
    }
    if ((paramArrayOfByte3 != null) && (paramArrayOfByte3.length >= paramArrayOfByte1.length))
    {
      if (paramArrayOfByte2 == null)
      {
        for (i = 0; i < paramArrayOfByte1.length; i++) {
          if (paramArrayOfByte3[i] != paramArrayOfByte1[i]) {
            return false;
          }
        }
        return true;
      }
      for (int i = 0; i < paramArrayOfByte1.length; i++) {
        if ((paramArrayOfByte2[i] & paramArrayOfByte3[i]) != (paramArrayOfByte2[i] & paramArrayOfByte1[i])) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (h.class == paramObject.getClass()))
    {
      paramObject = (h)paramObject;
      if ((!c.b(x, x)) || (!c.b(y, y)) || (E != E) || (!c.a(F, F)) || (!c.a(G, G)) || (!c.b(B, B)) || (!c.a(C, C)) || (!c.a(D, D)) || (!c.b(z, z)) || (!c.b(A, A))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { x, y, Integer.valueOf(E), Integer.valueOf(Arrays.hashCode(F)), Integer.valueOf(Arrays.hashCode(G)), B, Integer.valueOf(Arrays.hashCode(C)), Integer.valueOf(Arrays.hashCode(D)), z, A });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = a.a("BluetoothLeScanFilter [deviceName=");
    localStringBuilder.append(x);
    localStringBuilder.append(", deviceAddress=");
    localStringBuilder.append(y);
    localStringBuilder.append(", mUuid=");
    localStringBuilder.append(z);
    localStringBuilder.append(", uuidMask=");
    localStringBuilder.append(A);
    localStringBuilder.append(", serviceDataUuid=");
    Object localObject = B;
    if (localObject == null) {
      localObject = "null";
    } else {
      localObject = localObject.toString();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", serviceData=");
    localStringBuilder.append(Arrays.toString(C));
    localStringBuilder.append(", serviceDataMask=");
    localStringBuilder.append(Arrays.toString(D));
    localStringBuilder.append(", manufacturerId=");
    localStringBuilder.append(E);
    localStringBuilder.append(", manufacturerData=");
    localStringBuilder.append(Arrays.toString(F));
    localStringBuilder.append(", manufacturerDataMask=");
    localStringBuilder.append(Arrays.toString(G));
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Object localObject = x;
    int i = 0;
    int j;
    if (localObject == null) {
      j = 0;
    } else {
      j = 1;
    }
    paramParcel.writeInt(j);
    localObject = x;
    if (localObject != null) {
      paramParcel.writeString((String)localObject);
    }
    if (y == null) {
      j = 0;
    } else {
      j = 1;
    }
    paramParcel.writeInt(j);
    localObject = y;
    if (localObject != null) {
      paramParcel.writeString((String)localObject);
    }
    if (z == null) {
      j = 0;
    } else {
      j = 1;
    }
    paramParcel.writeInt(j);
    localObject = z;
    if (localObject != null)
    {
      paramParcel.writeParcelable((Parcelable)localObject, paramInt);
      if (A == null) {
        j = 0;
      } else {
        j = 1;
      }
      paramParcel.writeInt(j);
      localObject = A;
      if (localObject != null) {
        paramParcel.writeParcelable((Parcelable)localObject, paramInt);
      }
    }
    if (B == null) {
      j = 0;
    } else {
      j = 1;
    }
    paramParcel.writeInt(j);
    localObject = B;
    if (localObject != null)
    {
      paramParcel.writeParcelable((Parcelable)localObject, paramInt);
      if (C == null) {
        paramInt = 0;
      } else {
        paramInt = 1;
      }
      paramParcel.writeInt(paramInt);
      localObject = C;
      if (localObject != null)
      {
        paramParcel.writeInt(localObject.length);
        paramParcel.writeByteArray(C);
        if (D == null) {
          paramInt = 0;
        } else {
          paramInt = 1;
        }
        paramParcel.writeInt(paramInt);
        localObject = D;
        if (localObject != null)
        {
          paramParcel.writeInt(localObject.length);
          paramParcel.writeByteArray(D);
        }
      }
    }
    paramParcel.writeInt(E);
    if (F == null) {
      paramInt = 0;
    } else {
      paramInt = 1;
    }
    paramParcel.writeInt(paramInt);
    localObject = F;
    if (localObject != null)
    {
      paramParcel.writeInt(localObject.length);
      paramParcel.writeByteArray(F);
      if (G == null) {
        paramInt = i;
      } else {
        paramInt = 1;
      }
      paramParcel.writeInt(paramInt);
      localObject = G;
      if (localObject != null)
      {
        paramParcel.writeInt(localObject.length);
        paramParcel.writeByteArray(G);
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.j.a.a.a.a.a.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */