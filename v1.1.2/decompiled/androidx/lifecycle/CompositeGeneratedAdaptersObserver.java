package androidx.lifecycle;

import d.o.e;
import d.o.g.a;
import d.o.j;
import d.o.l;
import d.o.p;

public class CompositeGeneratedAdaptersObserver
  implements j
{
  public final e[] x;
  
  public CompositeGeneratedAdaptersObserver(e[] paramArrayOfe)
  {
    x = paramArrayOfe;
  }
  
  public void a(l paraml, g.a parama)
  {
    p localp = new p();
    e[] arrayOfe = x;
    int i = arrayOfe.length;
    int j = 0;
    for (int k = 0; k < i; k++) {
      arrayOfe[k].a(paraml, parama, false, localp);
    }
    arrayOfe = x;
    i = arrayOfe.length;
    for (k = j; k < i; k++) {
      arrayOfe[k].a(paraml, parama, true, localp);
    }
  }
}

/* Location:
 * Qualified Name:     androidx.lifecycle.CompositeGeneratedAdaptersObserver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */