package k.b.a.v.f;

import d.u.b;
import d.u.k;
import d.w.a.d;

public final class g
  implements f
{
  public final d.u.g a;
  public final b<e> b;
  public final k c;
  public final k d;
  
  public g(d.u.g paramg)
  {
    a = paramg;
    b = new a(paramg);
    c = new b(paramg);
    d = new c(paramg);
  }
  
  public class a
    extends b<e>
  {
    public a(d.u.g paramg)
    {
      super();
    }
    
    public void a(d.w.a.f paramf, Object paramObject)
    {
      paramObject = (e)paramObject;
      Object localObject = a;
      if (localObject == null) {
        paramf.bindNull(1);
      } else {
        paramf.bindLong(1, ((Integer)localObject).intValue());
      }
      paramf.bindLong(2, b);
      localObject = c;
      if (localObject == null) {
        paramf.bindNull(3);
      } else {
        paramf.bindDouble(3, ((Double)localObject).doubleValue());
      }
      localObject = d;
      if (localObject == null) {
        paramf.bindNull(4);
      } else {
        paramf.bindDouble(4, ((Double)localObject).doubleValue());
      }
      localObject = e;
      if (localObject == null) {
        paramf.bindNull(5);
      } else {
        paramf.bindDouble(5, ((Double)localObject).doubleValue());
      }
      localObject = f;
      if (localObject == null) {
        paramf.bindNull(6);
      } else {
        paramf.bindDouble(6, ((Double)localObject).doubleValue());
      }
      localObject = g;
      if (localObject == null) {
        paramf.bindNull(7);
      } else {
        paramf.bindDouble(7, ((Double)localObject).doubleValue());
      }
      localObject = h;
      if (localObject == null) {
        paramf.bindNull(8);
      } else {
        paramf.bindDouble(8, ((Double)localObject).doubleValue());
      }
      localObject = i;
      if (localObject == null) {
        paramf.bindNull(9);
      } else {
        paramf.bindDouble(9, ((Double)localObject).doubleValue());
      }
      paramf.bindLong(10, j);
    }
    
    public String b()
    {
      return "INSERT OR ABORT INTO `Measurement` (`id`,`timestamp`,`latitude`,`longitude`,`latLongAccuracy`,`altitude`,`altitudeAccuracy`,`speed`,`speedAccuracy`,`isUploaded`) VALUES (?,?,?,?,?,?,?,?,?,?)";
    }
  }
  
  public class b
    extends k
  {
    public b(d.u.g paramg)
    {
      super();
    }
    
    public String b()
    {
      return "DELETE from measurement WHERE isUploaded is 1";
    }
  }
  
  public class c
    extends k
  {
    public c(d.u.g paramg)
    {
      super();
    }
    
    public String b()
    {
      return "DELETE FROM measurement";
    }
  }
}

/* Location:
 * Qualified Name:     k.b.a.v.f.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */