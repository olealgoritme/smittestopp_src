package k.b.a.v.e;

import java.util.Map;
import l.d.b.h.d;
import no.simula.corona.data.greendao.BluetoothContactDao;
import no.simula.corona.data.greendao.MeasurementDao;

public class c
  extends l.d.b.c
{
  public final l.d.b.i.a b;
  public final l.d.b.i.a c;
  public final MeasurementDao d;
  public final BluetoothContactDao e;
  
  public c(l.d.b.g.a parama, d paramd, Map<Class<? extends l.d.b.a<?, ?>>, l.d.b.i.a> paramMap)
  {
    super(parama);
    parama = (l.d.b.i.a)paramMap.get(MeasurementDao.class);
    if (parama != null)
    {
      parama = new l.d.b.i.a(parama);
      b = parama;
      parama.a(paramd);
      parama = (l.d.b.i.a)paramMap.get(BluetoothContactDao.class);
      if (parama != null)
      {
        parama = new l.d.b.i.a(parama);
        c = parama;
        parama.a(paramd);
        d = new MeasurementDao(b, this);
        e = new BluetoothContactDao(c, this);
        parama = d;
        a.put(i.class, parama);
        parama = e;
        a.put(a.class, parama);
        return;
      }
      throw null;
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     k.b.a.v.e.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */