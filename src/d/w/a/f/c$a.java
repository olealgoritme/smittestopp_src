package d.w.a.f;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import d.u.e;
import d.u.g;
import d.u.g.b;
import d.u.h;
import d.u.h.a;
import d.u.h.b;
import d.w.a.b;
import j.b.a.u;
import java.util.List;
import no.simula.corona.MeasurementDatabase_Impl;

public class c$a
  extends SQLiteOpenHelper
{
  public final a[] x;
  public final d.w.a.c.a y;
  public boolean z;
  
  public c$a(Context paramContext, String paramString, a[] paramArrayOfa, d.w.a.c.a parama)
  {
    super(paramContext, paramString, null, a, new c.a.a(parama, paramArrayOfa));
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
  
  public b a()
  {
    try
    {
      z = false;
      Object localObject1 = super.getWritableDatabase();
      if (z)
      {
        close();
        localObject1 = a();
        return (b)localObject1;
      }
      localObject1 = a((SQLiteDatabase)localObject1);
      return (b)localObject1;
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
    d.w.a.c.a locala = y;
    a(x, paramSQLiteDatabase);
    if ((h)locala != null) {
      return;
    }
    throw null;
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject = y;
    paramSQLiteDatabase = a(x, paramSQLiteDatabase);
    h localh = (h)localObject;
    if (localh != null)
    {
      localObject = paramSQLiteDatabase.a("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
      try
      {
        boolean bool = ((Cursor)localObject).moveToFirst();
        int i = 0;
        if (bool)
        {
          j = ((Cursor)localObject).getInt(0);
          if (j == 0)
          {
            j = 1;
            break label69;
          }
        }
        int j = 0;
        label69:
        ((Cursor)localObject).close();
        c.a(paramSQLiteDatabase);
        if (j == 0)
        {
          localObject = c.b(paramSQLiteDatabase);
          if (!a)
          {
            paramSQLiteDatabase = e.a.a.a.a.a("Pre-packaged database has an invalid schema: ");
            paramSQLiteDatabase.append(b);
            throw new IllegalStateException(paramSQLiteDatabase.toString());
          }
        }
        localh.a(paramSQLiteDatabase);
        paramSQLiteDatabase = (u)c;
        if (MeasurementDatabase_Impl.b(b) != null)
        {
          int k = b.g.size();
          for (j = i; j < k; j++) {
            ((g.b)b.g.get(j)).a();
          }
        }
        return;
      }
      finally
      {
        ((Cursor)localObject).close();
      }
    }
    throw null;
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    z = true;
    d.w.a.c.a locala = y;
    paramSQLiteDatabase = a(x, paramSQLiteDatabase);
    ((h)locala).a(paramSQLiteDatabase, paramInt1, paramInt2);
  }
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    if (!z)
    {
      Object localObject1 = y;
      Object localObject3 = a(x, paramSQLiteDatabase);
      localObject1 = (h)localObject1;
      if (localObject1 != null)
      {
        paramSQLiteDatabase = ((a)localObject3).a("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        try
        {
          boolean bool = paramSQLiteDatabase.moveToFirst();
          int i = 0;
          if (bool)
          {
            j = paramSQLiteDatabase.getInt(0);
            if (j != 0)
            {
              j = 1;
              break label76;
            }
          }
          int j = 0;
          label76:
          paramSQLiteDatabase.close();
          if (j != 0)
          {
            Cursor localCursor = ((a)localObject3).a(new d.w.a.a("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
            try
            {
              if (localCursor.moveToFirst()) {
                paramSQLiteDatabase = localCursor.getString(0);
              } else {
                paramSQLiteDatabase = null;
              }
              localCursor.close();
              if ((d.equals(paramSQLiteDatabase)) || (e.equals(paramSQLiteDatabase))) {
                break label209;
              }
              throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
            }
            finally {}
          }
          paramSQLiteDatabase = c.b((b)localObject3);
          if (a)
          {
            if ((u)c != null)
            {
              ((h)localObject1).a((b)localObject3);
              label209:
              paramSQLiteDatabase = (u)c;
              MeasurementDatabase_Impl.a(b, (b)localObject3);
              b.d.a((b)localObject3);
              localObject3 = b.g;
              if (localObject3 != null)
              {
                int k = ((List)localObject3).size();
                for (j = i; j < k; j++) {
                  ((g.b)b.g.get(j)).c();
                }
              }
              b = null;
              return;
            }
            throw null;
          }
          localObject1 = e.a.a.a.a.a("Pre-packaged database has an invalid schema: ");
          ((StringBuilder)localObject1).append(b);
          throw new IllegalStateException(((StringBuilder)localObject1).toString());
        }
        finally
        {
          paramSQLiteDatabase.close();
        }
      }
      throw null;
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    z = true;
    y.a(a(x, paramSQLiteDatabase), paramInt1, paramInt2);
  }
}

/* Location:
 * Qualified Name:     base.d.w.a.f.c.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */