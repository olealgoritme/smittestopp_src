package d.g.a.h;

import d.g.a.c;
import java.util.ArrayList;

public class n
  extends d
{
  public ArrayList<d> k0 = new ArrayList();
  
  public void a(c paramc)
  {
    super.a(paramc);
    int i = k0.size();
    for (int j = 0; j < i; j++) {
      ((d)k0.get(j)).a(paramc);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    O = paramInt1;
    P = paramInt2;
    paramInt2 = k0.size();
    for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++) {
      ((d)k0.get(paramInt1)).b(I + O, J + P);
    }
  }
  
  public void k()
  {
    k0.clear();
    super.k();
  }
  
  public void n()
  {
    int i = I;
    int j = J;
    M = i;
    N = j;
    Object localObject = k0;
    if (localObject == null) {
      return;
    }
    i = ((ArrayList)localObject).size();
    for (j = 0; j < i; j++)
    {
      localObject = (d)k0.get(j);
      ((d)localObject).b(M + O, N + P);
      if (!(localObject instanceof e)) {
        ((d)localObject).n();
      }
    }
  }
  
  public void o()
  {
    n();
    Object localObject = k0;
    if (localObject == null) {
      return;
    }
    int i = ((ArrayList)localObject).size();
    for (int j = 0; j < i; j++)
    {
      localObject = (d)k0.get(j);
      if ((localObject instanceof n)) {
        ((n)localObject).o();
      }
    }
  }
}

/* Location:
 * Qualified Name:     d.g.a.h.n
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */