package k.b.a.v.e;

import i.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import l.d.b.a;
import l.d.b.f;
import no.simula.corona.data.greendao.MeasurementDao.Properties;

public final class d$i
  implements Runnable
{
  public d$i(List paramList) {}
  
  public void run()
  {
    Object localObject = ax).d;
    if (localObject != null)
    {
      localObject = new l.d.b.j.g((a)localObject);
      ((l.d.b.j.g)localObject).a(MeasurementDao.Properties.Id.a(y), new l.d.b.j.i[0]);
      List localList = ((l.d.b.j.g)localObject).b();
      i.k.b.g.a(localList, "entities");
      localObject = new ArrayList(e.c.a.a.b.l.c.a(localList, 10));
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        i locali = (i)localIterator.next();
        i.k.b.g.a(locali, "it");
        j = Boolean.valueOf(true);
        ((Collection)localObject).add(h.a);
      }
      ax).d.a(localList);
      return;
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     k.b.a.v.e.d.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */