package j.b.a.b0;

import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseData.Builder;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.AdvertiseSettings.Builder;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.os.ParcelUuid;
import h.k.b.g;
import j.b.a.a0;

public final class a
{
  public final AdvertiseData a;
  public final AdvertiseSettings b;
  public final b c;
  public final BluetoothLeAdvertiser d;
  
  public a(BluetoothLeAdvertiser paramBluetoothLeAdvertiser)
  {
    d = paramBluetoothLeAdvertiser;
    paramBluetoothLeAdvertiser = new AdvertiseData.Builder().addServiceUuid(new ParcelUuid(a0.a)).setIncludeDeviceName(false).setIncludeTxPowerLevel(true).build();
    g.a(paramBluetoothLeAdvertiser, "AdvertiseData.Builder()\n…rue)\n            .build()");
    a = paramBluetoothLeAdvertiser;
    paramBluetoothLeAdvertiser = new AdvertiseSettings.Builder().setAdvertiseMode(0).setConnectable(true).setTimeout(0).setTxPowerLevel(2).build();
    g.a(paramBluetoothLeAdvertiser, "AdvertiseSettings.Builde…IUM)\n            .build()");
    b = paramBluetoothLeAdvertiser;
    c = new b();
  }
}

/* Location:
 * Qualified Name:     base.j.b.a.b0.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */