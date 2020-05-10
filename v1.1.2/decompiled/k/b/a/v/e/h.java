package k.b.a.v.e;

import i.k.b.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k.b.a.v.g.b;
import l.d.b.a;
import l.d.b.i.e;
import no.simula.corona.data.greendao.MeasurementDao;

public final class h
  implements Runnable
{
  public h(List paramList) {}
  
  public void run()
  {
    MeasurementDao localMeasurementDao = ax).d;
    Object localObject = y;
    if (localObject != null)
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList(e.c.a.a.b.l.c.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList2.add(Boolean.valueOf(localArrayList1.add(b.a((b)((Iterator)localObject).next()))));
      }
      if (localMeasurementDao != null)
      {
        localMeasurementDao.a(f.a(), localArrayList1, true);
        return;
      }
      throw null;
    }
    g.a("measurements");
    throw null;
  }
}

/* Location:
 * Qualified Name:     k.b.a.v.e.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */