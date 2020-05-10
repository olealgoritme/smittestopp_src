package k.b.a.v.e;

import java.util.List;
import k.b.a.v.g.b;
import l.d.b.a;
import l.d.b.f;
import l.d.b.j.i;
import no.simula.corona.data.greendao.MeasurementDao.Properties;

public final class d$k
  implements d.a<List<? extends b>>
{
  public Object run()
  {
    Object localObject = aa).d;
    if (localObject != null)
    {
      localObject = new l.d.b.j.g((a)localObject);
      ((l.d.b.j.g)localObject).a(MeasurementDao.Properties.IsUploaded.a(Boolean.valueOf(false)), new i[0]);
      localObject = ((l.d.b.j.g)localObject).b();
      i.k.b.g.a(localObject, "mSession.measurementDao.…ploaded.eq(false)).list()");
      return b.b((List)localObject);
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     k.b.a.v.e.d.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */