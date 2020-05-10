package k.b.a.v.e;

import android.content.Context;
import android.util.Log;
import l.d.b.g.a;
import l.d.b.g.b;

public abstract class b$b
  extends b
{
  public b$b(Context paramContext, String paramString)
  {
    super(paramContext, paramString, 1);
  }
  
  public void a(a parama)
  {
    Log.i("greenDAO", "Creating tables for schema version 1");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE TABLE ");
    localStringBuilder.append("");
    localStringBuilder.append("\"MEASUREMENT\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"TIMESTAMP\" INTEGER,\"LATITUDE\" REAL,\"LONGITUDE\" REAL,\"LAT_LONG_ACCURACY\" REAL,\"ALTITUDE\" REAL,\"ALTITUDE_ACCURACY\" REAL,\"SPEED\" REAL,\"SPEED_ACCURACY\" REAL,\"IS_UPLOADED\" INTEGER);");
    parama.execSQL(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE TABLE ");
    localStringBuilder.append("");
    localStringBuilder.append("\"BLUETOOTH_CONTACT\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"TIMESTAMP\" INTEGER,\"DEVICE_ID\" TEXT,\"RSSI\" INTEGER NOT NULL ,\"TX_POWER\" INTEGER NOT NULL ,\"IS_UPLOADED\" INTEGER);");
    parama.execSQL(localStringBuilder.toString());
  }
}

/* Location:
 * Qualified Name:     k.b.a.v.e.b.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */