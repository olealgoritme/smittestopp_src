package no.simula.corona.data.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import k.b.a.v.e.i;
import l.d.b.f;

public class MeasurementDao
  extends l.d.b.a<i, Long>
{
  public static final String TABLENAME = "MEASUREMENT";
  
  public MeasurementDao(l.d.b.i.a parama, k.b.a.v.e.c paramc)
  {
    super(parama, paramc);
  }
  
  public Object a(Cursor paramCursor, int paramInt)
  {
    int i = paramInt + 0;
    Long localLong1;
    if (paramCursor.isNull(i)) {
      localLong1 = null;
    } else {
      localLong1 = Long.valueOf(paramCursor.getLong(i));
    }
    i = paramInt + 1;
    Long localLong2;
    if (paramCursor.isNull(i)) {
      localLong2 = null;
    } else {
      localLong2 = Long.valueOf(paramCursor.getLong(i));
    }
    i = paramInt + 2;
    Double localDouble1;
    if (paramCursor.isNull(i)) {
      localDouble1 = null;
    } else {
      localDouble1 = Double.valueOf(paramCursor.getDouble(i));
    }
    i = paramInt + 3;
    Double localDouble2;
    if (paramCursor.isNull(i)) {
      localDouble2 = null;
    } else {
      localDouble2 = Double.valueOf(paramCursor.getDouble(i));
    }
    i = paramInt + 4;
    Double localDouble3;
    if (paramCursor.isNull(i)) {
      localDouble3 = null;
    } else {
      localDouble3 = Double.valueOf(paramCursor.getDouble(i));
    }
    i = paramInt + 5;
    Double localDouble4;
    if (paramCursor.isNull(i)) {
      localDouble4 = null;
    } else {
      localDouble4 = Double.valueOf(paramCursor.getDouble(i));
    }
    i = paramInt + 6;
    Double localDouble5;
    if (paramCursor.isNull(i)) {
      localDouble5 = null;
    } else {
      localDouble5 = Double.valueOf(paramCursor.getDouble(i));
    }
    i = paramInt + 7;
    Double localDouble6;
    if (paramCursor.isNull(i)) {
      localDouble6 = null;
    } else {
      localDouble6 = Double.valueOf(paramCursor.getDouble(i));
    }
    i = paramInt + 8;
    Double localDouble7;
    if (paramCursor.isNull(i)) {
      localDouble7 = null;
    } else {
      localDouble7 = Double.valueOf(paramCursor.getDouble(i));
    }
    paramInt += 9;
    if (paramCursor.isNull(paramInt))
    {
      paramCursor = null;
    }
    else
    {
      boolean bool;
      if (paramCursor.getShort(paramInt) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramCursor = Boolean.valueOf(bool);
    }
    return new i(localLong1, localLong2, localDouble1, localDouble2, localDouble3, localDouble4, localDouble5, localDouble6, localDouble7, paramCursor);
  }
  
  public Object a(Object paramObject)
  {
    paramObject = (i)paramObject;
    if (paramObject != null) {
      paramObject = a;
    } else {
      paramObject = null;
    }
    return paramObject;
  }
  
  public Object a(Object paramObject, long paramLong)
  {
    a = Long.valueOf(paramLong);
    return Long.valueOf(paramLong);
  }
  
  public void a(SQLiteStatement paramSQLiteStatement, Object paramObject)
  {
    paramObject = (i)paramObject;
    paramSQLiteStatement.clearBindings();
    Object localObject = a;
    if (localObject != null) {
      paramSQLiteStatement.bindLong(1, ((Long)localObject).longValue());
    }
    localObject = b;
    if (localObject != null) {
      paramSQLiteStatement.bindLong(2, ((Long)localObject).longValue());
    }
    localObject = c;
    if (localObject != null) {
      paramSQLiteStatement.bindDouble(3, ((Double)localObject).doubleValue());
    }
    localObject = d;
    if (localObject != null) {
      paramSQLiteStatement.bindDouble(4, ((Double)localObject).doubleValue());
    }
    localObject = e;
    if (localObject != null) {
      paramSQLiteStatement.bindDouble(5, ((Double)localObject).doubleValue());
    }
    localObject = f;
    if (localObject != null) {
      paramSQLiteStatement.bindDouble(6, ((Double)localObject).doubleValue());
    }
    localObject = g;
    if (localObject != null) {
      paramSQLiteStatement.bindDouble(7, ((Double)localObject).doubleValue());
    }
    localObject = h;
    if (localObject != null) {
      paramSQLiteStatement.bindDouble(8, ((Double)localObject).doubleValue());
    }
    localObject = i;
    if (localObject != null) {
      paramSQLiteStatement.bindDouble(9, ((Double)localObject).doubleValue());
    }
    paramObject = j;
    if (paramObject != null)
    {
      long l;
      if (((Boolean)paramObject).booleanValue()) {
        l = 1L;
      } else {
        l = 0L;
      }
      paramSQLiteStatement.bindLong(10, l);
    }
  }
  
  public void a(l.d.b.g.c paramc, Object paramObject)
  {
    paramObject = (i)paramObject;
    paramc.a();
    Object localObject = a;
    if (localObject != null) {
      paramc.bindLong(1, ((Long)localObject).longValue());
    }
    localObject = b;
    if (localObject != null) {
      paramc.bindLong(2, ((Long)localObject).longValue());
    }
    localObject = c;
    if (localObject != null) {
      paramc.bindDouble(3, ((Double)localObject).doubleValue());
    }
    localObject = d;
    if (localObject != null) {
      paramc.bindDouble(4, ((Double)localObject).doubleValue());
    }
    localObject = e;
    if (localObject != null) {
      paramc.bindDouble(5, ((Double)localObject).doubleValue());
    }
    localObject = f;
    if (localObject != null) {
      paramc.bindDouble(6, ((Double)localObject).doubleValue());
    }
    localObject = g;
    if (localObject != null) {
      paramc.bindDouble(7, ((Double)localObject).doubleValue());
    }
    localObject = h;
    if (localObject != null) {
      paramc.bindDouble(8, ((Double)localObject).doubleValue());
    }
    localObject = i;
    if (localObject != null) {
      paramc.bindDouble(9, ((Double)localObject).doubleValue());
    }
    paramObject = j;
    if (paramObject != null)
    {
      long l;
      if (((Boolean)paramObject).booleanValue()) {
        l = 1L;
      } else {
        l = 0L;
      }
      paramc.bindLong(10, l);
    }
  }
  
  public Object b(Cursor paramCursor, int paramInt)
  {
    
    if (paramCursor.isNull(paramInt)) {
      paramCursor = null;
    } else {
      paramCursor = Long.valueOf(paramCursor.getLong(paramInt));
    }
    return paramCursor;
  }
  
  public static class Properties
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
}

/* Location:
 * Qualified Name:     no.simula.corona.data.greendao.MeasurementDao
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */