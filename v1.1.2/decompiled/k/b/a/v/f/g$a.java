package k.b.a.v.f;

import d.u.b;
import d.w.a.d;
import d.w.a.f;

public class g$a
  extends b<e>
{
  public g$a(g paramg, d.u.g paramg1)
  {
    super(paramg1);
  }
  
  public void a(f paramf, Object paramObject)
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

/* Location:
 * Qualified Name:     k.b.a.v.f.g.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */