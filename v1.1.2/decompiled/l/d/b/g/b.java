package l.d.b.g;

import android.content.Context;
import android.util.Log;

public abstract class b
  extends android.database.sqlite.SQLiteOpenHelper
{
  public a A;
  public boolean B = true;
  public final Context x;
  public final String y;
  public final int z;
  
  public b(Context paramContext, String paramString, int paramInt)
  {
    super(paramContext, paramString, null, paramInt);
    x = paramContext;
    y = paramString;
    z = paramInt;
  }
  
  public abstract void a(a parama);
  
  public abstract void a(a parama, int paramInt1, int paramInt2);
  
  public void onCreate(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    Log.i("greenDAO", "Creating tables for schema version 1");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE TABLE ");
    localStringBuilder.append("");
    localStringBuilder.append("\"MEASUREMENT\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"TIMESTAMP\" INTEGER,\"LATITUDE\" REAL,\"LONGITUDE\" REAL,\"LAT_LONG_ACCURACY\" REAL,\"ALTITUDE\" REAL,\"ALTITUDE_ACCURACY\" REAL,\"SPEED\" REAL,\"SPEED_ACCURACY\" REAL,\"IS_UPLOADED\" INTEGER);");
    paramSQLiteDatabase.execSQL(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE TABLE ");
    localStringBuilder.append("");
    localStringBuilder.append("\"BLUETOOTH_CONTACT\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"TIMESTAMP\" INTEGER,\"DEVICE_ID\" TEXT,\"RSSI\" INTEGER NOT NULL ,\"TX_POWER\" INTEGER NOT NULL ,\"IS_UPLOADED\" INTEGER);");
    paramSQLiteDatabase.execSQL(localStringBuilder.toString());
  }
  
  public void onOpen(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase) {}
  
  public void onUpgrade(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    a(new f(paramSQLiteDatabase), paramInt1, paramInt2);
  }
  
  public class a
    extends net.sqlcipher.database.SQLiteOpenHelper
  {
    public a(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
    {
      super(paramString, null, paramInt);
      if (paramBoolean) {
        net.sqlcipher.database.SQLiteDatabase.loadLibs(paramContext);
      }
    }
    
    public void onCreate(net.sqlcipher.database.SQLiteDatabase paramSQLiteDatabase)
    {
      a(new d(paramSQLiteDatabase));
    }
    
    public void onOpen(net.sqlcipher.database.SQLiteDatabase paramSQLiteDatabase)
    {
      if (b.this != null) {
        return;
      }
      throw null;
    }
    
    public void onUpgrade(net.sqlcipher.database.SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      a(new d(paramSQLiteDatabase), paramInt1, paramInt2);
    }
  }
}

/* Location:
 * Qualified Name:     l.d.b.g.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */