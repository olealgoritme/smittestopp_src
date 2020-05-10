package d.u;

import android.database.Cursor;
import d.w.a.b;
import d.w.a.c.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import no.simula.corona.data.legacy.MeasurementDatabase_Impl;

public class h
  extends c.a
{
  public a b;
  public final a c;
  public final String d;
  public final String e;
  
  public h(a parama, a parama1, String paramString1, String paramString2)
  {
    super(a);
    b = parama;
    c = parama1;
    d = paramString1;
    e = paramString2;
  }
  
  public void a(b paramb)
  {
    Object localObject = paramb.query("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
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
          break label46;
        }
      }
      int j = 0;
      label46:
      ((Cursor)localObject).close();
      if ((k.b.a.v.f.h)c != null)
      {
        paramb.execSQL("CREATE TABLE IF NOT EXISTS `Measurement` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `timestamp` INTEGER NOT NULL, `latitude` REAL, `longitude` REAL, `latLongAccuracy` REAL, `altitude` REAL, `altitudeAccuracy` REAL, `speed` REAL, `speedAccuracy` REAL, `isUploaded` INTEGER NOT NULL)");
        paramb.execSQL("CREATE TABLE IF NOT EXISTS `BluetoothContact` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `timestamp` INTEGER NOT NULL, `deviceId` TEXT NOT NULL, `rssi` INTEGER NOT NULL, `txPower` INTEGER NOT NULL, `isUploaded` INTEGER NOT NULL)");
        paramb.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        paramb.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '8260d2f713a01361d6ce911d0c7159cc')");
        if (j == 0)
        {
          localObject = c.a(paramb);
          if (!a)
          {
            paramb = e.a.a.a.a.a("Pre-packaged database has an invalid schema: ");
            paramb.append(b);
            throw new IllegalStateException(paramb.toString());
          }
        }
        c(paramb);
        paramb = (k.b.a.v.f.h)c;
        if (MeasurementDatabase_Impl.b(b) != null)
        {
          int k = b.g.size();
          for (j = i; j < k; j++) {
            ((g.b)b.g.get(j)).a();
          }
        }
        return;
      }
      throw null;
    }
    finally
    {
      ((Cursor)localObject).close();
    }
  }
  
  public void a(b paramb, int paramInt1, int paramInt2)
  {
    Object localObject1 = b;
    int i = 0;
    int j = 1;
    if (localObject1 != null)
    {
      Object localObject2 = d;
      if (localObject2 != null)
      {
        Object localObject3;
        Object localObject4;
        if (paramInt1 == paramInt2)
        {
          localObject1 = Collections.emptyList();
        }
        else
        {
          int k;
          if (paramInt2 > paramInt1) {
            k = 1;
          } else {
            k = 0;
          }
          localObject3 = new ArrayList();
          m = paramInt1;
          while (k != 0 ? m < paramInt2 : m > paramInt2)
          {
            localObject4 = (TreeMap)a.get(Integer.valueOf(m));
            if (localObject4 != null)
            {
              if (k != 0) {
                localObject1 = ((TreeMap)localObject4).descendingKeySet();
              } else {
                localObject1 = ((TreeMap)localObject4).keySet();
              }
              localObject1 = ((Set)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                int n = ((Integer)((Iterator)localObject1).next()).intValue();
                if (k != 0 ? (n <= paramInt2) && (n > m) : (n >= paramInt2) && (n < m)) {
                  i1 = 1;
                } else {
                  i1 = 0;
                }
                if (i1 != 0)
                {
                  ((ArrayList)localObject3).add(((TreeMap)localObject4).get(Integer.valueOf(n)));
                  i1 = 1;
                  m = n;
                  break label247;
                }
              }
              int i1 = 0;
              label247:
              if (i1 != 0) {}
            }
            else
            {
              localObject1 = null;
              break label265;
            }
          }
          localObject1 = localObject3;
        }
        label265:
        if (localObject1 != null)
        {
          if ((k.b.a.v.f.h)c != null)
          {
            localObject2 = new ArrayList();
            localObject3 = paramb.query("SELECT name FROM sqlite_master WHERE type = 'trigger'");
            try
            {
              while (((Cursor)localObject3).moveToNext()) {
                ((ArrayList)localObject2).add(((Cursor)localObject3).getString(0));
              }
              ((Cursor)localObject3).close();
              localObject3 = ((ArrayList)localObject2).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                localObject4 = (String)((Iterator)localObject3).next();
                if (((String)localObject4).startsWith("room_fts_content_sync_"))
                {
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append("DROP TRIGGER IF EXISTS ");
                  ((StringBuilder)localObject2).append((String)localObject4);
                  paramb.execSQL(((StringBuilder)localObject2).toString());
                }
              }
              localObject1 = ((List)localObject1).iterator();
              while (((Iterator)localObject1).hasNext()) {
                ((d.u.l.a)((Iterator)localObject1).next()).a(paramb);
              }
              localObject1 = c.a(paramb);
              if (a)
              {
                if ((k.b.a.v.f.h)c != null)
                {
                  c(paramb);
                  m = j;
                  break label534;
                }
                throw null;
              }
              paramb = e.a.a.a.a.a("Migration didn't properly handle: ");
              paramb.append(b);
              throw new IllegalStateException(paramb.toString());
            }
            finally
            {
              ((Cursor)localObject3).close();
            }
          }
          throw null;
        }
      }
      else
      {
        throw null;
      }
    }
    int m = 0;
    label534:
    if (m == 0)
    {
      localObject1 = b;
      if ((localObject1 != null) && (!((a)localObject1).a(paramInt1, paramInt2)))
      {
        localObject1 = (k.b.a.v.f.h)c;
        if (localObject1 != null)
        {
          paramb.execSQL("DROP TABLE IF EXISTS `Measurement`");
          paramb.execSQL("DROP TABLE IF EXISTS `BluetoothContact`");
          if (MeasurementDatabase_Impl.a(b) != null)
          {
            paramInt2 = b.g.size();
            for (paramInt1 = i; paramInt1 < paramInt2; paramInt1++) {
              ((g.b)b.g.get(paramInt1)).b();
            }
          }
          if ((k.b.a.v.f.h)c != null)
          {
            paramb.execSQL("CREATE TABLE IF NOT EXISTS `Measurement` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `timestamp` INTEGER NOT NULL, `latitude` REAL, `longitude` REAL, `latLongAccuracy` REAL, `altitude` REAL, `altitudeAccuracy` REAL, `speed` REAL, `speedAccuracy` REAL, `isUploaded` INTEGER NOT NULL)");
            paramb.execSQL("CREATE TABLE IF NOT EXISTS `BluetoothContact` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `timestamp` INTEGER NOT NULL, `deviceId` TEXT NOT NULL, `rssi` INTEGER NOT NULL, `txPower` INTEGER NOT NULL, `isUploaded` INTEGER NOT NULL)");
            paramb.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            paramb.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '8260d2f713a01361d6ce911d0c7159cc')");
          }
          else
          {
            throw null;
          }
        }
        else
        {
          throw null;
        }
      }
      else
      {
        paramb = new StringBuilder();
        paramb.append("A migration from ");
        paramb.append(paramInt1);
        paramb.append(" to ");
        paramb.append(paramInt2);
        paramb.append(" was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
        throw new IllegalStateException(paramb.toString());
      }
    }
  }
  
  public void b(b paramb)
  {
    Object localObject = paramb.query("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
    try
    {
      boolean bool = ((Cursor)localObject).moveToFirst();
      int i = 0;
      if (bool)
      {
        j = ((Cursor)localObject).getInt(0);
        if (j != 0)
        {
          j = 1;
          break label46;
        }
      }
      int j = 0;
      label46:
      ((Cursor)localObject).close();
      if (j != 0)
      {
        Cursor localCursor = paramb.query(new d.w.a.a("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
        try
        {
          if (localCursor.moveToFirst()) {
            localObject = localCursor.getString(0);
          } else {
            localObject = null;
          }
          localCursor.close();
          if ((d.equals(localObject)) || (e.equals(localObject))) {
            break label182;
          }
          throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
        }
        finally
        {
          localCursor.close();
        }
      }
      localObject = c.a(paramb);
      if (a)
      {
        if ((k.b.a.v.f.h)c != null)
        {
          c(paramb);
          label182:
          localObject = (k.b.a.v.f.h)c;
          MeasurementDatabase_Impl.a(b, paramb);
          b.d.a(paramb);
          paramb = b.g;
          if (paramb != null)
          {
            int k = paramb.size();
            for (j = i; j < k; j++) {
              ((g.b)b.g.get(j)).c();
            }
          }
          b = null;
          return;
        }
        throw null;
      }
      paramb = e.a.a.a.a.a("Pre-packaged database has an invalid schema: ");
      paramb.append(b);
      throw new IllegalStateException(paramb.toString());
    }
    finally
    {
      ((Cursor)localObject).close();
    }
  }
  
  public final void c(b paramb)
  {
    paramb.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    String str = d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '");
    localStringBuilder.append(str);
    localStringBuilder.append("')");
    paramb.execSQL(localStringBuilder.toString());
  }
  
  public static abstract class a
  {
    public final int a;
    
    public a(int paramInt)
    {
      a = paramInt;
    }
    
    public abstract h.b a(b paramb);
  }
  
  public static class b
  {
    public final boolean a;
    public final String b;
    
    public b(boolean paramBoolean, String paramString)
    {
      a = paramBoolean;
      b = paramString;
    }
  }
}

/* Location:
 * Qualified Name:     d.u.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */