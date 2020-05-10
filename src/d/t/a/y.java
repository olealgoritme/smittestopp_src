package d.t.a;

import d.f.a;
import d.f.e;
import d.f.h;

public class y
{
  public final a<s.x, y.a> a = new a();
  public final e<s.x> b = new e();
  
  public void a(s.x paramx)
  {
    for (int i = b.c() - 1; i >= 0; i--) {
      if (paramx == b.a(i))
      {
        e locale = b;
        Object[] arrayOfObject = z;
        Object localObject1 = arrayOfObject[i];
        Object localObject2 = e.B;
        if (localObject1 == localObject2) {
          break;
        }
        arrayOfObject[i] = localObject2;
        x = true;
        break;
      }
    }
    paramx = (y.a)a.remove(paramx);
    if (paramx != null) {
      y.a.a(paramx);
    }
  }
  
  public void a(s.x paramx, s.h.c paramc)
  {
    y.a locala1 = (y.a)a.getOrDefault(paramx, null);
    y.a locala2 = locala1;
    if (locala1 == null)
    {
      locala2 = y.a.a();
      a.put(paramx, locala2);
    }
    b = paramc;
    a |= 0x4;
  }
}

/* Location:
 * Qualified Name:     base.d.t.a.y
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */