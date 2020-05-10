package no.simula.corona.data.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import l.d.b.f;

public class BluetoothContactDao
  extends l.d.b.a<k.b.a.v.e.a, Long>
{
  public static final String TABLENAME = "BLUETOOTH_CONTACT";
  
  public BluetoothContactDao(l.d.b.i.a parama, k.b.a.v.e.c paramc)
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
    String str;
    if (paramCursor.isNull(i)) {
      str = null;
    } else {
      str = paramCursor.getString(i);
    }
    int j = paramCursor.getInt(paramInt + 3);
    i = paramCursor.getInt(paramInt + 4);
    paramInt += 5;
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
    return new k.b.a.v.e.a(localLong1, localLong2, str, j, i, paramCursor);
  }
  
  public Object a(Object paramObject)
  {
    paramObject = (k.b.a.v.e.a)paramObject;
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
    paramObject = (k.b.a.v.e.a)paramObject;
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
      paramSQLiteStatement.bindString(3, (String)localObject);
    }
    paramSQLiteStatement.bindLong(4, d);
    paramSQLiteStatement.bindLong(5, e);
    paramObject = f;
    if (paramObject != null)
    {
      long l;
      if (((Boolean)paramObject).booleanValue()) {
        l = 1L;
      } else {
        l = 0L;
      }
      paramSQLiteStatement.bindLong(6, l);
    }
  }
  
  public void a(l.d.b.g.c paramc, Object paramObject)
  {
    paramObject = (k.b.a.v.e.a)paramObject;
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
      paramc.bindString(3, (String)localObject);
    }
    paramc.bindLong(4, d);
    paramc.bindLong(5, e);
    paramObject = f;
    if (paramObject != null)
    {
      long l;
      if (((Boolean)paramObject).booleanValue()) {
        l = 1L;
      } else {
        l = 0L;
      }
      paramc.bindLong(6, l);
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
}

/* Location:
 * Qualified Name:     no.simula.corona.data.greendao.BluetoothContactDao
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */