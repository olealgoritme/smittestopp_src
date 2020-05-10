package d.w.a.g;

import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.util.Pair;
import d.w.a.c.a;
import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class b$a$a
  implements DatabaseErrorHandler
{
  public b$a$a(c.a parama, a[] paramArrayOfa) {}
  
  public void onCorruption(SQLiteDatabase paramSQLiteDatabase)
  {
    c.a locala = a;
    a locala1 = b.a.a(b, paramSQLiteDatabase);
    paramSQLiteDatabase = null;
    Object localObject1 = null;
    Object localObject2;
    if (locala != null)
    {
      localObject2 = e.a.a.a.a.a("Corruption reported by sqlite on database: ");
      ((StringBuilder)localObject2).append(locala1.b());
      Log.e("SupportSQLite", ((StringBuilder)localObject2).toString());
      if (!locala1.isOpen()) {
        locala.a(locala1.b());
      }
    }
    try
    {
      try
      {
        localObject2 = locala1.a();
        paramSQLiteDatabase = (SQLiteDatabase)localObject2;
      }
      finally
      {
        break label97;
      }
    }
    catch (SQLiteException localSQLiteException)
    {
      label97:
      label198:
      for (;;) {}
    }
    localObject1 = paramSQLiteDatabase;
    try
    {
      locala1.close();
    }
    catch (IOException localIOException)
    {
      if (paramSQLiteDatabase == null) {
        break label198;
      }
      paramSQLiteDatabase = paramSQLiteDatabase.iterator();
      while (paramSQLiteDatabase.hasNext()) {
        locala.a((String)nextsecond);
      }
      locala.a(locala1.b());
    }
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        locala.a((String)nextsecond);
      }
    }
    locala.a(locala1.b());
    throw paramSQLiteDatabase;
    return;
    throw null;
  }
}

/* Location:
 * Qualified Name:     d.w.a.g.b.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */