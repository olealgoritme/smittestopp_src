package j.b.a.b0;

/*
 *
 * orig: j/b/a/b0/d.java
 */

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattServerCallback;
import e.c.a.a.b.l.c;
import h.k.b.g;
import l.a.a.b;

public final class d
  extends BluetoothGattServerCallback
{
  public void onCharacteristicReadRequest(BluetoothDevice paramBluetoothDevice, int paramInt1, int paramInt2, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    if (paramBluetoothDevice != null)
    {
      if (paramBluetoothGattCharacteristic != null)
      {
        if ((c.a(paramBluetoothGattCharacteristic)) && (a.c != null))
        {
          if (paramInt2 == 0)
          {
            localObject = e.a.a.a.a.a("Requesting characteristic UUID: ");
            ((StringBuilder)localObject).append(paramBluetoothGattCharacteristic.getUuid());
            paramBluetoothGattCharacteristic = ((StringBuilder)localObject).toString();
            l.a.a.d.a(paramBluetoothGattCharacteristic, new Object[0]);
            paramBluetoothGattCharacteristic = new StringBuilder();
            paramBluetoothGattCharacteristic.append("Responding: + ");
            paramBluetoothGattCharacteristic.append(new String(a.a, h.o.a.a));
            paramBluetoothGattCharacteristic = paramBluetoothGattCharacteristic.toString();
            l.a.a.d.a(paramBluetoothGattCharacteristic, new Object[0]);
          }
          Object localObject = a;
          paramBluetoothGattCharacteristic = a;
          if (paramInt2 > paramBluetoothGattCharacteristic.length)
          {
            paramBluetoothGattCharacteristic = c;
            if (paramBluetoothGattCharacteristic != null)
            {
              paramBluetoothGattCharacteristic.sendResponse(paramBluetoothDevice, paramInt1, 0, 0, new byte[0]);
              return;
            }
            g.a();
            throw null;
          }
          localObject = new byte[paramBluetoothGattCharacteristic.length - paramInt2];
          int i = paramBluetoothGattCharacteristic.length;
          for (int j = paramInt2; j < i; j++) {
            localObject[(j - paramInt2)] = ((byte)a.a[j]);
          }
          paramBluetoothGattCharacteristic = a.c;
          if (paramBluetoothGattCharacteristic != null)
          {
            paramBluetoothGattCharacteristic.sendResponse(paramBluetoothDevice, paramInt1, 0, paramInt2, (byte[])localObject);
            return;
          }
          g.a();
          throw null;
        }
        return;
      }
      g.a("characteristic");
      throw null;
    }
    g.a("device");
    throw null;
  }
}