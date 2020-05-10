package k.b.a.v.e;

import android.content.Context;
import android.util.Log;
import java.util.Map;
import no.simula.corona.data.greendao.BluetoothContactDao;
import no.simula.corona.data.greendao.MeasurementDao;

public class b
  extends l.d.b.b
{
  public b(l.d.b.g.a parama)
  {
    super(parama, 1);
    parama = new l.d.b.i.a(a, MeasurementDao.class);
    b.put(MeasurementDao.class, parama);
    parama = new l.d.b.i.a(a, BluetoothContactDao.class);
    b.put(BluetoothContactDao.class, parama);
  }
  
  public static class a
    extends b.b
  {
    public a(Context paramContext, String paramString)
    {
      super(paramString);
    }
    
    public void a(l.d.b.g.a parama, int paramInt1, int paramInt2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Upgrading schema from version ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" to ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" by dropping all tables");
      Log.i("greenDAO", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("DROP TABLE ");
      localStringBuilder.append("IF EXISTS ");
      localStringBuilder.append("\"MEASUREMENT\"");
      parama.execSQL(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("DROP TABLE ");
      localStringBuilder.append("IF EXISTS ");
      localStringBuilder.append("\"BLUETOOTH_CONTACT\"");
      parama.execSQL(localStringBuilder.toString());
      a(parama);
    }
  }
  
  public static abstract class b
    extends l.d.b.g.b
  {
    public b(Context paramContext, String paramString)
    {
      super(paramString, 1);
    }
    
    public void a(l.d.b.g.a parama)
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
}

/* Location:
 * Qualified Name:     k.b.a.v.e.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */