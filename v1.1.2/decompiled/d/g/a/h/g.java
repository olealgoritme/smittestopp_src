package d.g.a.h;

import d.g.a.a;
import d.g.a.b;
import java.util.ArrayList;

public class g
  extends d
{
  public float k0 = -1.0F;
  public int l0 = -1;
  public int m0 = -1;
  public c n0 = t;
  public int o0;
  public boolean p0;
  
  public g()
  {
    int i = 0;
    o0 = 0;
    p0 = false;
    B.clear();
    B.add(n0);
    int j = A.length;
    while (i < j)
    {
      A[i] = n0;
      i++;
    }
  }
  
  public c a(c.c paramc)
  {
    switch (paramc.ordinal())
    {
    default: 
      break;
    case 0: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
      return null;
    case 2: 
    case 4: 
      if (o0 == 0) {
        return n0;
      }
      break;
    case 1: 
    case 3: 
      if (o0 == 1) {
        return n0;
      }
      break;
    }
    throw new AssertionError(paramc.name());
  }
  
  public void a(int paramInt)
  {
    d locald = D;
    if (locald == null) {
      return;
    }
    if (o0 == 1)
    {
      t.a.a(1, t.a, 0);
      v.a.a(1, t.a, 0);
      paramInt = l0;
      if (paramInt != -1)
      {
        s.a.a(1, s.a, paramInt);
        u.a.a(1, s.a, l0);
      }
      else
      {
        paramInt = m0;
        if (paramInt != -1)
        {
          s.a.a(1, u.a, -paramInt);
          u.a.a(1, u.a, -m0);
        }
        else if ((k0 != -1.0F) && (locald.e() == d.a.FIXED))
        {
          paramInt = (int)(E * k0);
          s.a.a(1, s.a, paramInt);
          u.a.a(1, s.a, paramInt);
        }
      }
    }
    else
    {
      s.a.a(1, s.a, 0);
      u.a.a(1, s.a, 0);
      paramInt = l0;
      if (paramInt != -1)
      {
        t.a.a(1, t.a, paramInt);
        v.a.a(1, t.a, l0);
      }
      else
      {
        paramInt = m0;
        if (paramInt != -1)
        {
          t.a.a(1, v.a, -paramInt);
          v.a.a(1, v.a, -m0);
        }
        else if ((k0 != -1.0F) && (locald.h() == d.a.FIXED))
        {
          paramInt = (int)(F * k0);
          t.a.a(1, t.a, paramInt);
          v.a.a(1, t.a, paramInt);
        }
      }
    }
  }
  
  public void a(d.g.a.e parame)
  {
    Object localObject1 = (e)D;
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = ((d)localObject1).a(c.c.LEFT);
    Object localObject3 = ((d)localObject1).a(c.c.RIGHT);
    Object localObject4 = D;
    int i = 1;
    int j;
    if ((localObject4 != null) && (C[0] == d.a.WRAP_CONTENT)) {
      j = 1;
    } else {
      j = 0;
    }
    if (o0 == 0)
    {
      localObject2 = ((d)localObject1).a(c.c.TOP);
      localObject3 = ((d)localObject1).a(c.c.BOTTOM);
      localObject1 = D;
      if ((localObject1 != null) && (C[1] == d.a.WRAP_CONTENT)) {
        j = i;
      } else {
        j = 0;
      }
    }
    if (l0 != -1)
    {
      localObject1 = parame.a(n0);
      parame.a((d.g.a.g)localObject1, parame.a(localObject2), l0, 6);
      if (j != 0) {
        parame.b(parame.a(localObject3), (d.g.a.g)localObject1, 0, 5);
      }
    }
    else if (m0 != -1)
    {
      localObject1 = parame.a(n0);
      localObject3 = parame.a(localObject3);
      parame.a((d.g.a.g)localObject1, (d.g.a.g)localObject3, -m0, 6);
      if (j != 0)
      {
        parame.b((d.g.a.g)localObject1, parame.a(localObject2), 0, 5);
        parame.b((d.g.a.g)localObject3, (d.g.a.g)localObject1, 0, 5);
      }
    }
    else if (k0 != -1.0F)
    {
      localObject1 = parame.a(n0);
      localObject2 = parame.a(localObject2);
      localObject3 = parame.a(localObject3);
      float f = k0;
      boolean bool = p0;
      localObject4 = parame.b();
      if (bool) {
        ((b)localObject4).a(parame, 0);
      }
      d.a((d.g.a.g)localObject1, -1.0F);
      d.a((d.g.a.g)localObject2, 1.0F - f);
      d.a((d.g.a.g)localObject3, f);
      parame.a((b)localObject4);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public ArrayList<c> b()
  {
    return B;
  }
  
  public void c(d.g.a.e parame)
  {
    if (D == null) {
      return;
    }
    int i = parame.b(n0);
    if (o0 == 1)
    {
      I = i;
      J = 0;
      e(D.d());
      f(0);
    }
    else
    {
      I = 0;
      J = i;
      f(D.i());
      e(0);
    }
  }
  
  public void g(int paramInt)
  {
    if (o0 == paramInt) {
      return;
    }
    o0 = paramInt;
    B.clear();
    if (o0 == 1) {
      n0 = s;
    } else {
      n0 = t;
    }
    B.add(n0);
    int i = A.length;
    for (paramInt = 0; paramInt < i; paramInt++) {
      A[paramInt] = n0;
    }
  }
}

/* Location:
 * Qualified Name:     d.g.a.h.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */