package k.b.a.v.f;

import d.u.h.a;
import d.u.h.b;
import d.u.m.d;
import d.u.m.d.a;
import d.w.a.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import no.simula.corona.data.legacy.MeasurementDatabase_Impl;

public class h
  extends h.a
{
  public h(MeasurementDatabase_Impl paramMeasurementDatabase_Impl, int paramInt)
  {
    super(paramInt);
  }
  
  public h.b a(b paramb)
  {
    Object localObject1 = new HashMap(10);
    ((HashMap)localObject1).put("id", new d.a("id", "INTEGER", false, 1, null, 1));
    ((HashMap)localObject1).put("timestamp", new d.a("timestamp", "INTEGER", true, 0, null, 1));
    ((HashMap)localObject1).put("latitude", new d.a("latitude", "REAL", false, 0, null, 1));
    ((HashMap)localObject1).put("longitude", new d.a("longitude", "REAL", false, 0, null, 1));
    ((HashMap)localObject1).put("latLongAccuracy", new d.a("latLongAccuracy", "REAL", false, 0, null, 1));
    ((HashMap)localObject1).put("altitude", new d.a("altitude", "REAL", false, 0, null, 1));
    ((HashMap)localObject1).put("altitudeAccuracy", new d.a("altitudeAccuracy", "REAL", false, 0, null, 1));
    ((HashMap)localObject1).put("speed", new d.a("speed", "REAL", false, 0, null, 1));
    ((HashMap)localObject1).put("speedAccuracy", new d.a("speedAccuracy", "REAL", false, 0, null, 1));
    ((HashMap)localObject1).put("isUploaded", new d.a("isUploaded", "INTEGER", true, 0, null, 1));
    localObject1 = new d("Measurement", (Map)localObject1, new HashSet(0), new HashSet(0));
    Object localObject2 = d.a(paramb, "Measurement");
    if (!((d)localObject1).equals(localObject2))
    {
      paramb = new StringBuilder();
      paramb.append("Measurement(no.simula.corona.data.legacy.Measurement).\n Expected:\n");
      paramb.append(localObject1);
      paramb.append("\n Found:\n");
      paramb.append(localObject2);
      return new h.b(false, paramb.toString());
    }
    localObject1 = new HashMap(6);
    ((HashMap)localObject1).put("id", new d.a("id", "INTEGER", false, 1, null, 1));
    ((HashMap)localObject1).put("timestamp", new d.a("timestamp", "INTEGER", true, 0, null, 1));
    ((HashMap)localObject1).put("deviceId", new d.a("deviceId", "TEXT", true, 0, null, 1));
    ((HashMap)localObject1).put("rssi", new d.a("rssi", "INTEGER", true, 0, null, 1));
    ((HashMap)localObject1).put("txPower", new d.a("txPower", "INTEGER", true, 0, null, 1));
    ((HashMap)localObject1).put("isUploaded", new d.a("isUploaded", "INTEGER", true, 0, null, 1));
    localObject1 = new d("BluetoothContact", (Map)localObject1, new HashSet(0), new HashSet(0));
    paramb = d.a(paramb, "BluetoothContact");
    if (!((d)localObject1).equals(paramb))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("BluetoothContact(no.simula.corona.data.legacy.BluetoothContact).\n Expected:\n");
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append("\n Found:\n");
      ((StringBuilder)localObject2).append(paramb);
      return new h.b(false, ((StringBuilder)localObject2).toString());
    }
    return new h.b(true, null);
  }
}

/* Location:
 * Qualified Name:     k.b.a.v.f.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */