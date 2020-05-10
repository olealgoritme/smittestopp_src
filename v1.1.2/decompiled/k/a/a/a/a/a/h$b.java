package k.a.a.a.a.a;

import android.bluetooth.BluetoothAdapter;
import android.os.ParcelUuid;
import e.a.a.a.a;

public final class h$b
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

/* Location:
 * Qualified Name:     k.a.a.a.a.a.h.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */