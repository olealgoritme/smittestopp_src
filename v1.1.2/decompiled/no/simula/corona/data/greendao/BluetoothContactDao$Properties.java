package no.simula.corona.data.greendao;

import l.d.b.f;

public class BluetoothContactDao$Properties
{
  public static final f DeviceId;
  public static final f Id = new f(0, Long.class, "id", true, "_id");
  public static final f IsUploaded = new f(5, Boolean.class, "isUploaded", false, "IS_UPLOADED");
  public static final f Rssi;
  public static final f Timestamp = new f(1, Long.class, "timestamp", false, "TIMESTAMP");
  public static final f TxPower;
  
  static
  {
    DeviceId = new f(2, String.class, "deviceId", false, "DEVICE_ID");
    Rssi = new f(3, Integer.TYPE, "rssi", false, "RSSI");
    TxPower = new f(4, Integer.TYPE, "txPower", false, "TX_POWER");
  }
}

/* Location:
 * Qualified Name:     no.simula.corona.data.greendao.BluetoothContactDao.Properties
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */