package k.b.a.v.e;

import i.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import l.d.b.f;
import l.d.b.j.i;
import no.simula.corona.data.greendao.BluetoothContactDao.Properties;

public final class d$h
  implements Runnable
{
  public d$h(List paramList) {}
  
  public void run()
  {
    Object localObject = ax).e;
    if (localObject != null)
    {
      localObject = new l.d.b.j.g((l.d.b.a)localObject);
      ((l.d.b.j.g)localObject).a(BluetoothContactDao.Properties.Id.a(y), new i[0]);
      List localList = ((l.d.b.j.g)localObject).b();
      i.k.b.g.a(localList, "entities");
      localObject = new ArrayList(e.c.a.a.b.l.c.a(localList, 10));
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        i.k.b.g.a(locala, "it");
        f = Boolean.valueOf(true);
        ((Collection)localObject).add(h.a);
      }
      ax).e.a(localList);
      return;
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     k.b.a.v.e.d.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */