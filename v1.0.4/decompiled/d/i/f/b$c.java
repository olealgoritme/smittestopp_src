package d.i.f;

import d.f.h;
import java.util.ArrayList;

public final class b$c
  implements c.c<b.g>
{
  public b$c(String paramString) {}
  
  public void a(b.g paramg)
  {
    synchronized (b.c)
    {
      ArrayList localArrayList = (ArrayList)b.d.get(a);
      if (localArrayList == null) {
        return;
      }
      b.d.remove(a);
      for (int i = 0; i < localArrayList.size(); i++) {
        ((c.c)localArrayList.get(i)).a(paramg);
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     base.d.i.f.b.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */