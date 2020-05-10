package k.b.a.u;

import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseData.Builder;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.AdvertiseSettings.Builder;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.os.ParcelUuid;
import i.k.b.g;
import k.b.a.t;

public final class a
{
  public final AdvertiseData a;
  public final AdvertiseSettings b;
  public final b c;
  public final BluetoothLeAdvertiser d;
  
  public a(BluetoothLeAdvertiser paramBluetoothLeAdvertiser)
  {
    d = paramBluetoothLeAdvertiser;
    paramBluetoothLeAdvertiser = new AdvertiseData.Builder().addServiceUuid(new ParcelUuid(t.b)).setIncludeDeviceName(false).setIncludeTxPowerLevel(true).build();
    g.a(paramBluetoothLeAdvertiser, "AdvertiseData.Builder()\n…rue)\n            .build()");
    a = paramBluetoothLeAdvertiser;
    paramBluetoothLeAdvertiser = new AdvertiseSettings.Builder().setAdvertiseMode(0).setConnectable(true).setTimeout(0).setTxPowerLevel(2).build();
    g.a(paramBluetoothLeAdvertiser, "AdvertiseSettings.Builde…IUM)\n            .build()");
    b = paramBluetoothLeAdvertiser;
    c = new b();
  }
}

/* Location:
 * Qualified Name:     k.b.a.u.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */