package d.w.a.f;

import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.util.Pair;
import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class c$a$a
  implements DatabaseErrorHandler
{
  public c$a$a(d.w.a.c.a parama, a[] paramArrayOfa) {}
  
  public void onCorruption(SQLiteDatabase paramSQLiteDatabase)
  {
    d.w.a.c.a locala = a;
    a locala1 = c.a.a(b, paramSQLiteDatabase);
    paramSQLiteDatabase = null;
    Object localObject1 = null;
    Object localObject2;
    if (locala != null)
    {
      localObject2 = e.a.a.a.a.a("Corruption reported by sqlite on database: ");
      ((StringBuilder)localObject2).append(locala1.a());
      Log.e("SupportSQLite", ((StringBuilder)localObject2).toString());
      if (!x.isOpen()) {
        locala.a(locala1.a());
      }
    }
    try
    {
      try
      {
        localObject2 = x.getAttachedDbs();
        paramSQLiteDatabase = (SQLiteDatabase)localObject2;
      }
      finally
      {
        break label103;
      }
    }
    catch (SQLiteException localSQLiteException)
    {
      label103:
      label204:
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
        break label204;
      }
      paramSQLiteDatabase = paramSQLiteDatabase.iterator();
      while (paramSQLiteDatabase.hasNext()) {
        locala.a((String)nextsecond);
      }
      locala.a(locala1.a());
    }
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        locala.a((String)nextsecond);
      }
    }
    locala.a(locala1.a());
    throw paramSQLiteDatabase;
    return;
    throw null;
  }
}

/* Location:
 * Qualified Name:     base.d.w.a.f.c.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */