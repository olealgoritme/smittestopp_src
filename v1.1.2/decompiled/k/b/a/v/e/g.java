package k.b.a.v.e;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l.d.b.i.e;
import no.simula.corona.data.greendao.BluetoothContactDao;

public final class g
  implements Runnable
{
  public g(List paramList) {}
  
  public void run()
  {
    BluetoothContactDao localBluetoothContactDao = ax).e;
    Object localObject = y;
    if (localObject != null)
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList(e.c.a.a.b.l.c.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList2.add(Boolean.valueOf(localArrayList1.add(k.b.a.v.g.a.a((k.b.a.v.g.a)((Iterator)localObject).next()))));
      }
      if (localBluetoothContactDao != null)
      {
        localBluetoothContactDao.a(f.a(), localArrayList1, true);
        return;
      }
      throw null;
    }
    i.k.b.g.a("models");
    throw null;
  }
}

/* Location:
 * Qualified Name:     k.b.a.v.e.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */