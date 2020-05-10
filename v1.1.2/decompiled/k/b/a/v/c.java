package k.b.a.v;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import i.h;
import i.k.b.g;
import java.util.ArrayList;
import java.util.Iterator;
import k.b.a.y.b;
import m.a.a.b;

public final class c
  extends d
{
  public final SharedPreferences a(Context paramContext)
  {
    if (paramContext != null)
    {
      if (b.b == null) {
        b.b = b.a(paramContext, "alias_prefs");
      }
      e.g.a locala = new e.g.a(paramContext, b.b, b);
      if (!paramContext.getSharedPreferences(a, 0).getBoolean(g, false))
      {
        Object localObject1 = paramContext.getSharedPreferences(a, 0);
        Object localObject2 = new ArrayList(new i.i.a(new String[] { "host-name", "access-key", "connection-data", "device-id-string", "token", "phone-number", "timestamp", "firstland" }, true));
        SharedPreferences.Editor localEditor1 = a.edit();
        SharedPreferences.Editor localEditor2 = ((SharedPreferences)localObject1).edit();
        ArrayList localArrayList = new ArrayList(e.c.a.a.b.l.c.a((Iterable)localObject2, 10));
        localObject2 = ((ArrayList)localObject2).iterator();
        int j;
        for (int i = 0; ((Iterator)localObject2).hasNext(); i = j)
        {
          String str1 = (String)((Iterator)localObject2).next();
          j = i;
          if (((SharedPreferences)localObject1).contains(str1))
          {
            String str2 = e.a.a.a.a.b(str1, " found");
            m.a.a.d.a(str2, new Object[0]);
            if (g.a(str1, "timestamp"))
            {
              long l = ((SharedPreferences)localObject1).getLong(str1, 0L);
              localEditor1.putString(e.g.a.b(str1), e.g.a.a(locala, Long.toString(l)));
            }
            else if (g.a(str1, "firstland"))
            {
              boolean bool = ((SharedPreferences)localObject1).getBoolean(str1, true);
              localEditor1.putString(e.g.a.b(str1), e.g.a.a(locala, Boolean.toString(bool)));
            }
            else
            {
              str2 = ((SharedPreferences)localObject1).getString(str1, "");
              localEditor1.putString(e.g.a.b(str1), e.g.a.a(locala, str2));
            }
            localEditor2.remove(str1);
            j = i + 1;
          }
          localArrayList.add(h.a);
        }
        localEditor1.apply();
        localEditor2.apply();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(" keys migrated");
        localObject1 = ((StringBuilder)localObject1).toString();
        m.a.a.d.a((String)localObject1, new Object[0]);
        paramContext = paramContext.getSharedPreferences(a, 0).edit();
        paramContext.putBoolean(g, true);
        paramContext.apply();
      }
      return locala;
    }
    g.a("context");
    throw null;
  }
}

/* Location:
 * Qualified Name:     k.b.a.v.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */