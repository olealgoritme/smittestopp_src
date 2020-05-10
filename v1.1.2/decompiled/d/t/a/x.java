package d.t.a;

import androidx.recyclerview.widget.RecyclerView.h.c;
import androidx.recyclerview.widget.RecyclerView.w;
import d.f.a;
import d.f.e;
import d.f.h;
import d.i.h.b;

public class x
{
  public final a<RecyclerView.w, a> a = new a();
  public final e<RecyclerView.w> b = new e();
  
  public void a(RecyclerView.w paramw)
  {
    for (int i = b.c() - 1; i >= 0; i--) {
      if (paramw == b.a(i))
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
    paramw = (a)a.remove(paramw);
    if (paramw != null) {
      a.a(paramw);
    }
  }
  
  public void a(RecyclerView.w paramw, RecyclerView.h.c paramc)
  {
    a locala1 = (a)a.getOrDefault(paramw, null);
    a locala2 = locala1;
    if (locala1 == null)
    {
      locala2 = a.a();
      a.put(paramw, locala2);
    }
    b = paramc;
    a |= 0x4;
  }
  
  public static class a
  {
    public static b<a> d = new b(20);
    public int a;
    public RecyclerView.h.c b;
    public RecyclerView.h.c c;
    
    public static a a()
    {
      a locala1 = (a)d.a();
      a locala2 = locala1;
      if (locala1 == null) {
        locala2 = new a();
      }
      return locala2;
    }
    
    public static void a(a parama)
    {
      a = 0;
      b = null;
      c = null;
      d.a(parama);
    }
  }
  
  public static abstract interface b {}
}

/* Location:
 * Qualified Name:     d.t.a.x
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */