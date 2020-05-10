package d.w.a.g;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.util.Pair;
import d.u.h;
import d.w.a.c;
import d.w.a.c.a;
import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class b
  implements c
{
  public final a a;
  
  public b(Context paramContext, String paramString, c.a parama)
  {
    a = new a(paramContext, paramString, new a[1], parama);
  }
  
  public String getDatabaseName()
  {
    return a.getDatabaseName();
  }
  
  public d.w.a.b getWritableDatabase()
  {
    return a.a();
  }
  
  public void setWriteAheadLoggingEnabled(boolean paramBoolean)
  {
    a.setWriteAheadLoggingEnabled(paramBoolean);
  }
  
  public static class a
    extends SQLiteOpenHelper
  {
    public final a[] x;
    public final c.a y;
    public boolean z;
    
    public a(Context paramContext, String paramString, final a[] paramArrayOfa, c.a parama)
    {
      super(paramString, null, a, new a(parama, paramArrayOfa));
      y = parama;
      x = paramArrayOfa;
    }
    
    public static a a(a[] paramArrayOfa, SQLiteDatabase paramSQLiteDatabase)
    {
      a locala = paramArrayOfa[0];
      if (locala != null)
      {
        int i;
        if (x == paramSQLiteDatabase) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {}
      }
      else
      {
        paramArrayOfa[0] = new a(paramSQLiteDatabase);
      }
      return paramArrayOfa[0];
    }
    
    public d.w.a.b a()
    {
      try
      {
        z = false;
        Object localObject1 = super.getWritableDatabase();
        if (z)
        {
          close();
          localObject1 = a();
          return (d.w.a.b)localObject1;
        }
        localObject1 = a((SQLiteDatabase)localObject1);
        return (d.w.a.b)localObject1;
      }
      finally {}
    }
    
    public a a(SQLiteDatabase paramSQLiteDatabase)
    {
      return a(x, paramSQLiteDatabase);
    }
    
    public void close()
    {
      try
      {
        super.close();
        x[0] = null;
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public void onConfigure(SQLiteDatabase paramSQLiteDatabase)
    {
      c.a locala = y;
      a(x, paramSQLiteDatabase);
      if ((h)locala != null) {
        return;
      }
      throw null;
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      y.a(a(x, paramSQLiteDatabase));
    }
    
    public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      z = true;
      c.a locala = y;
      paramSQLiteDatabase = a(x, paramSQLiteDatabase);
      ((h)locala).a(paramSQLiteDatabase, paramInt1, paramInt2);
    }
    
    public void onOpen(SQLiteDatabase paramSQLiteDatabase)
    {
      if (!z) {
        y.b(a(x, paramSQLiteDatabase));
      }
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      z = true;
      y.a(a(x, paramSQLiteDatabase), paramInt1, paramInt2);
    }
    
    public class a
      implements DatabaseErrorHandler
    {
      public a(a[] paramArrayOfa) {}
      
      public void onCorruption(SQLiteDatabase paramSQLiteDatabase)
      {
        c.a locala = b.a.this;
        a locala1 = b.a.a(paramArrayOfa, paramSQLiteDatabase);
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
  }
}

/* Location:
 * Qualified Name:     d.w.a.g.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */