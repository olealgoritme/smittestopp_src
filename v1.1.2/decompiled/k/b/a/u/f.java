package k.b.a.u;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import e.c.a.a.b.l.c;
import i.k.b.g;
import k.b.a.t;
import m.a.a.b;

public final class f
  extends BluetoothGattCallback
{
  public String a;
  public final h b;
  public final int c;
  public final int d;
  
  public f(h paramh, int paramInt1, int paramInt2)
  {
    b = paramh;
    c = paramInt1;
    d = paramInt2;
  }
  
  public void a(String paramString, Integer paramInteger)
  {
    if ((paramString != null) && (paramInteger != null))
    {
      h localh = b;
      if (localh != null) {
        localh.a(paramString, paramInteger.intValue(), d, System.currentTimeMillis());
      }
    }
  }
  
  public void onCharacteristicRead(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    Object localObject = null;
    if (paramBluetoothGatt != null)
    {
      if (paramBluetoothGattCharacteristic != null)
      {
        if (paramInt != 0) {
          paramBluetoothGatt.disconnect();
        }
        if (c.a(paramBluetoothGattCharacteristic))
        {
          m.a.a.d.c("onCharacteristicRead", new Object[0]);
          byte[] arrayOfByte = paramBluetoothGattCharacteristic.getValue();
          paramBluetoothGattCharacteristic = (BluetoothGattCharacteristic)localObject;
          if (arrayOfByte != null) {
            paramBluetoothGattCharacteristic = new String(arrayOfByte, i.o.a.a);
          }
          a = paramBluetoothGattCharacteristic;
          paramBluetoothGattCharacteristic = e.a.a.a.a.a("Got identifier ");
          paramBluetoothGattCharacteristic.append(a);
          paramBluetoothGattCharacteristic = paramBluetoothGattCharacteristic.toString();
          m.a.a.d.b(paramBluetoothGattCharacteristic, new Object[0]);
          paramBluetoothGattCharacteristic = new StringBuilder();
          paramBluetoothGattCharacteristic.append("storeIfRead ");
          paramBluetoothGattCharacteristic.append(c);
          paramBluetoothGattCharacteristic.append(", ");
          paramBluetoothGattCharacteristic.append(a);
          paramBluetoothGattCharacteristic = paramBluetoothGattCharacteristic.toString();
          m.a.a.d.c(paramBluetoothGattCharacteristic, new Object[0]);
          paramBluetoothGattCharacteristic = a;
          if (paramBluetoothGattCharacteristic != null) {
            a(paramBluetoothGattCharacteristic, Integer.valueOf(c));
          }
          paramBluetoothGatt.disconnect();
        }
        return;
      }
      g.a("characteristic");
      throw null;
    }
    g.a("gatt");
    throw null;
  }
  
  public void onConnectionStateChange(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    if (paramBluetoothGatt != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("status: ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", state: ");
      ((StringBuilder)localObject).append(paramInt2);
      localObject = ((StringBuilder)localObject).toString();
      m.a.a.d.c((String)localObject, new Object[0]);
      if (paramInt1 == 0)
      {
        if (paramInt2 == 2) {
          paramBluetoothGatt.discoverServices();
        } else if (paramInt2 == 0) {
          paramBluetoothGatt.close();
        }
      }
      else {
        paramBluetoothGatt.close();
      }
      return;
    }
    g.a("gatt");
    throw null;
  }
  
  public void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    if (paramBluetoothGatt != null)
    {
      String str = e.a.a.a.a.a("onServicesDiscovered status: ", paramInt);
      m.a.a.d.c(str, new Object[0]);
      if (paramInt == 0) {
        try
        {
          paramBluetoothGatt.readCharacteristic(paramBluetoothGatt.getService(t.b).getCharacteristic(t.c));
        }
        catch (NullPointerException paramBluetoothGatt)
        {
          m.a.a.d.a("onServicesDiscovered device does not display service UUID", new Object[0]);
          a(null, null);
        }
      } else {
        paramBluetoothGatt.disconnect();
      }
      return;
    }
    g.a("gatt");
    throw null;
  }
}

/* Location:
 * Qualified Name:     k.b.a.u.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */