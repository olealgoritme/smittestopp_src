package d.u;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import d.w.a.b;
import d.w.a.c.a;
import j.b.a.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import no.simula.corona.MeasurementDatabase_Impl;

public class h
  extends c.a
{
  public a b;
  public final h.a c;
  public final String d;
  public final String e;
  
  public h(a parama, h.a parama1, String paramString1, String paramString2)
  {
    super(a);
    b = parama;
    c = parama1;
    d = paramString1;
    e = paramString2;
  }
  
  public final void a(b paramb)
  {
    paramb = (d.w.a.f.a)paramb;
    x.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    String str = e.a.a.a.a.a("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '", d, "')");
    x.execSQL(str);
  }
  
  public void a(b paramb, int paramInt1, int paramInt2)
  {
    Object localObject1 = b;
    int i = 0;
    int j = 1;
    Object localObject3;
    if (localObject1 != null)
    {
      Object localObject2 = d;
      if (localObject2 != null)
      {
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
          if ((u)c != null)
          {
            localObject2 = new ArrayList();
            localObject3 = (d.w.a.f.a)paramb;
            localObject4 = ((d.w.a.f.a)localObject3).a("SELECT name FROM sqlite_master WHERE type = 'trigger'");
            try
            {
              while (((Cursor)localObject4).moveToNext()) {
                ((ArrayList)localObject2).add(((Cursor)localObject4).getString(0));
              }
              ((Cursor)localObject4).close();
              localObject4 = ((ArrayList)localObject2).iterator();
              while (((Iterator)localObject4).hasNext())
              {
                localObject2 = (String)((Iterator)localObject4).next();
                if (((String)localObject2).startsWith("room_fts_content_sync_"))
                {
                  localObject2 = e.a.a.a.a.b("DROP TRIGGER IF EXISTS ", (String)localObject2);
                  x.execSQL((String)localObject2);
                }
              }
              localObject1 = ((List)localObject1).iterator();
              while (((Iterator)localObject1).hasNext()) {
                ((d.u.l.a)((Iterator)localObject1).next()).a(paramb);
              }
              localObject1 = c.b(paramb);
              if (a)
              {
                if ((u)c != null)
                {
                  a(paramb);
                  m = j;
                  break label522;
                }
                throw null;
              }
              paramb = e.a.a.a.a.a("Migration didn't properly handle: ");
              paramb.append(b);
              throw new IllegalStateException(paramb.toString());
            }
            finally
            {
              ((Cursor)localObject4).close();
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
    label522:
    if (m == 0)
    {
      localObject1 = b;
      if ((localObject1 != null) && (!((a)localObject1).a(paramInt1, paramInt2)))
      {
        localObject1 = (u)c;
        if (localObject1 != null)
        {
          localObject3 = (d.w.a.f.a)paramb;
          x.execSQL("DROP TABLE IF EXISTS `Measurement`");
          x.execSQL("DROP TABLE IF EXISTS `BluetoothContact`");
          if (MeasurementDatabase_Impl.a(b) != null)
          {
            paramInt2 = b.g.size();
            for (paramInt1 = i; paramInt1 < paramInt2; paramInt1++) {
              ((g.b)b.g.get(paramInt1)).b();
            }
          }
          c.a(paramb);
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
}

/* Location:
 * Qualified Name:     base.d.u.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */