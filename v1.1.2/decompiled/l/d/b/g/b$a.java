package l.d.b.g;

import android.content.Context;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;

public class b$a
  extends SQLiteOpenHelper
{
  public b$a(b paramb, Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramString, null, paramInt);
    if (paramBoolean) {
      SQLiteDatabase.loadLibs(paramContext);
    }
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    a.a(new d(paramSQLiteDatabase));
  }
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    if (a != null) {
      return;
    }
    throw null;
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    a.a(new d(paramSQLiteDatabase), paramInt1, paramInt2);
  }
}

/* Location:
 * Qualified Name:     l.d.b.g.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */