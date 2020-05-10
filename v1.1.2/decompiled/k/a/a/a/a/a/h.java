package k.a.a.a.a.a;

import android.bluetooth.BluetoothAdapter;
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
  public static final Parcelable.Creator<h> CREATOR = new a();
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
  
  public static final class a
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
  
  public static final class b
  {
    public String a;
    public String b;
    public ParcelUuid c;
    public ParcelUuid d;
    public ParcelUuid e;
    public byte[] f;
    public byte[] g;
    public int h = -1;
    public byte[] i;
    public byte[] j;
    
    public b a(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    {
      if ((paramArrayOfByte1 != null) && (paramInt < 0)) {
        throw new IllegalArgumentException("invalid manufacture id");
      }
      if (paramArrayOfByte2 != null) {
        if (paramArrayOfByte1 != null)
        {
          if (paramArrayOfByte1.length != paramArrayOfByte2.length) {
            throw new IllegalArgumentException("size mismatch for manufacturerData and manufacturerDataMask");
          }
        }
        else {
          throw new IllegalArgumentException("manufacturerData is null while manufacturerDataMask is not null");
        }
      }
      h = paramInt;
      i = paramArrayOfByte1;
      j = paramArrayOfByte2;
      return this;
    }
    
    public b a(ParcelUuid paramParcelUuid)
    {
      c = paramParcelUuid;
      d = null;
      return this;
    }
    
    public b a(ParcelUuid paramParcelUuid, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    {
      if ((paramParcelUuid == null) && (paramArrayOfByte1 != null)) {
        throw new IllegalArgumentException("serviceDataUuid is null");
      }
      if (paramArrayOfByte2 != null) {
        if (paramArrayOfByte1 != null)
        {
          if (paramArrayOfByte1.length != paramArrayOfByte2.length) {
            throw new IllegalArgumentException("size mismatch for service data and service data mask");
          }
        }
        else {
          throw new IllegalArgumentException("serviceData is null while serviceDataMask is not null");
        }
      }
      e = paramParcelUuid;
      f = paramArrayOfByte1;
      g = paramArrayOfByte2;
      return this;
    }
    
    public b a(String paramString)
    {
      if ((paramString != null) && (!BluetoothAdapter.checkBluetoothAddress(paramString))) {
        throw new IllegalArgumentException(a.b("invalid device address ", paramString));
      }
      b = paramString;
      return this;
    }
    
    public h a()
    {
      return new h(a, b, c, d, e, f, g, h, i, j, null);
    }
  }
}

/* Location:
 * Qualified Name:     k.a.a.a.a.a.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */