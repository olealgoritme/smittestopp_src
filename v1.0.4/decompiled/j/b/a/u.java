package j.b.a;

import android.database.sqlite.SQLiteDatabase;
import d.u.h.a;
import d.u.h.b;
import d.u.m.d;
import d.u.m.d.a;
import d.w.a.b;
import d.w.a.f.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import no.simula.corona.MeasurementDatabase_Impl;

public class u
  extends h.a
{
  public u(MeasurementDatabase_Impl paramMeasurementDatabase_Impl, int paramInt)
  {
    super(paramInt);
  }
  
  public void a(b paramb)
  {
    x.execSQL("CREATE TABLE IF NOT EXISTS `Measurement` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `timestamp` INTEGER NOT NULL, `latitude` REAL, `longitude` REAL, `latLongAccuracy` REAL, `altitude` REAL, `altitudeAccuracy` REAL, `speed` REAL, `speedAccuracy` REAL, `isUploaded` INTEGER NOT NULL)");
    paramb = (a)paramb;
    x.execSQL("CREATE TABLE IF NOT EXISTS `BluetoothContact` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `timestamp` INTEGER NOT NULL, `deviceId` TEXT NOT NULL, `rssi` INTEGER NOT NULL, `txPower` INTEGER NOT NULL, `isUploaded` INTEGER NOT NULL)");
    x.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    x.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '8260d2f713a01361d6ce911d0c7159cc')");
  }
  
  public h.b b(b paramb)
  {
    Object localObject = new HashMap(10);
    ((HashMap)localObject).put("id", new d.a("id", "INTEGER", false, 1, null, 1));
    ((HashMap)localObject).put("timestamp", new d.a("timestamp", "INTEGER", true, 0, null, 1));
    ((HashMap)localObject).put("latitude", new d.a("latitude", "REAL", false, 0, null, 1));
    ((HashMap)localObject).put("longitude", new d.a("longitude", "REAL", false, 0, null, 1));
    ((HashMap)localObject).put("latLongAccuracy", new d.a("latLongAccuracy", "REAL", false, 0, null, 1));
    ((HashMap)localObject).put("altitude", new d.a("altitude", "REAL", false, 0, null, 1));
    ((HashMap)localObject).put("altitudeAccuracy", new d.a("altitudeAccuracy", "REAL", false, 0, null, 1));
    ((HashMap)localObject).put("speed", new d.a("speed", "REAL", false, 0, null, 1));
    ((HashMap)localObject).put("speedAccuracy", new d.a("speedAccuracy", "REAL", false, 0, null, 1));
    ((HashMap)localObject).put("isUploaded", new d.a("isUploaded", "INTEGER", true, 0, null, 1));
    localObject = new d("Measurement", (Map)localObject, new HashSet(0), new HashSet(0));
    d locald = d.a(paramb, "Measurement");
    if (!((d)localObject).equals(locald))
    {
      paramb = new StringBuilder();
      paramb.append("Measurement(no.simula.corona.Measurement).\n Expected:\n");
      paramb.append(localObject);
      paramb.append("\n Found:\n");
      paramb.append(locald);
      return new h.b(false, paramb.toString());
    }
    localObject = new HashMap(6);
    ((HashMap)localObject).put("id", new d.a("id", "INTEGER", false, 1, null, 1));
    ((HashMap)localObject).put("timestamp", new d.a("timestamp", "INTEGER", true, 0, null, 1));
    ((HashMap)localObject).put("deviceId", new d.a("deviceId", "TEXT", true, 0, null, 1));
    ((HashMap)localObject).put("rssi", new d.a("rssi", "INTEGER", true, 0, null, 1));
    ((HashMap)localObject).put("txPower", new d.a("txPower", "INTEGER", true, 0, null, 1));
    ((HashMap)localObject).put("isUploaded", new d.a("isUploaded", "INTEGER", true, 0, null, 1));
    localObject = new d("BluetoothContact", (Map)localObject, new HashSet(0), new HashSet(0));
    locald = d.a(paramb, "BluetoothContact");
    if (!((d)localObject).equals(locald))
    {
      paramb = new StringBuilder();
      paramb.append("BluetoothContact(no.simula.corona.BluetoothContact).\n Expected:\n");
      paramb.append(localObject);
      paramb.append("\n Found:\n");
      paramb.append(locald);
      return new h.b(false, paramb.toString());
    }
    return new h.b(true, null);
  }
}

/* Location:
 * Qualified Name:     base.j.b.a.u
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */