package no.simula.corona.data.greendao;

import l.d.b.f;

public class MeasurementDao$Properties
{
  public static final f Altitude;
  public static final f AltitudeAccuracy;
  public static final f Id = new f(0, Long.class, "id", true, "_id");
  public static final f IsUploaded = new f(9, Boolean.class, "isUploaded", false, "IS_UPLOADED");
  public static final f LatLongAccuracy;
  public static final f Latitude;
  public static final f Longitude;
  public static final f Speed;
  public static final f SpeedAccuracy;
  public static final f Timestamp = new f(1, Long.class, "timestamp", false, "TIMESTAMP");
  
  static
  {
    Latitude = new f(2, Double.class, "latitude", false, "LATITUDE");
    Longitude = new f(3, Double.class, "longitude", false, "LONGITUDE");
    LatLongAccuracy = new f(4, Double.class, "latLongAccuracy", false, "LAT_LONG_ACCURACY");
    Altitude = new f(5, Double.class, "altitude", false, "ALTITUDE");
    AltitudeAccuracy = new f(6, Double.class, "altitudeAccuracy", false, "ALTITUDE_ACCURACY");
    Speed = new f(7, Double.class, "speed", false, "SPEED");
    SpeedAccuracy = new f(8, Double.class, "speedAccuracy", false, "SPEED_ACCURACY");
  }
}

/* Location:
 * Qualified Name:     no.simula.corona.data.greendao.MeasurementDao.Properties
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */