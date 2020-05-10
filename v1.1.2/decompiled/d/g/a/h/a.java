package d.g.a.h;

import d.g.a.b;
import d.g.a.g;
import java.util.ArrayList;
import java.util.HashSet;

public class a
  extends h
{
  public int m0 = 0;
  public ArrayList<j> n0 = new ArrayList(4);
  public boolean o0 = true;
  
  public void a(int paramInt)
  {
    Object localObject = D;
    if (localObject == null) {
      return;
    }
    if (!((e)localObject).g(2)) {
      return;
    }
    paramInt = m0;
    j localj;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return;
          }
          localj = v.a;
        }
        else
        {
          localj = t.a;
        }
      }
      else {
        localj = u.a;
      }
    }
    else {
      localj = s.a;
    }
    h = 5;
    paramInt = m0;
    if ((paramInt != 0) && (paramInt != 1))
    {
      s.a.a(null, 0.0F);
      u.a.a(null, 0.0F);
    }
    else
    {
      t.a.a(null, 0.0F);
      v.a.a(null, 0.0F);
    }
    n0.clear();
    for (paramInt = 0; paramInt < l0; paramInt++)
    {
      localObject = k0[paramInt];
      if ((o0) || (((d)localObject).a()))
      {
        int i = m0;
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 2)
            {
              if (i != 3) {
                localObject = null;
              } else {
                localObject = v.a;
              }
            }
            else {
              localObject = t.a;
            }
          }
          else {
            localObject = u.a;
          }
        }
        else {
          localObject = s.a;
        }
        if (localObject != null)
        {
          n0.add(localObject);
          a.add(localj);
        }
      }
    }
  }
  
  public void a(d.g.a.e parame)
  {
    Object localObject1 = A;
    localObject1[0] = s;
    localObject1[2] = t;
    localObject1[1] = u;
    localObject1[3] = v;
    for (int i = 0;; i++)
    {
      localObject1 = A;
      if (i >= localObject1.length) {
        break;
      }
      i = parame.a(localObject1[i]);
    }
    i = m0;
    if ((i >= 0) && (i < 4))
    {
      localObject1 = localObject1[i];
      Object localObject2;
      for (i = 0; i < l0; i++)
      {
        localObject2 = k0[i];
        if ((o0) || (((d)localObject2).a()))
        {
          j = m0;
          if (((j == 0) || (j == 1)) && (((d)localObject2).e() == d.a.MATCH_CONSTRAINT)) {}
          do
          {
            i = 1;
            break;
            j = m0;
          } while (((j == 2) || (j == 3)) && (((d)localObject2).h() == d.a.MATCH_CONSTRAINT));
        }
      }
      i = 0;
      int j = m0;
      if ((j != 0) && (j != 1) ? D.h() == d.a.WRAP_CONTENT : D.e() == d.a.WRAP_CONTENT) {
        i = 0;
      }
      for (j = 0; j < l0; j++)
      {
        Object localObject3 = k0[j];
        if ((o0) || (((d)localObject3).a()))
        {
          localObject2 = parame.a(A[m0]);
          localObject3 = A;
          int k = m0;
          i = ((g)localObject2);
          g localg1;
          g localg2;
          if ((k != 0) && (k != 2))
          {
            localg1 = i;
            localObject3 = parame.b();
            localg2 = parame.c();
            d = 0;
            ((b)localObject3).a(localg1, (g)localObject2, localg2, 0);
            if (i != 0)
            {
              k = (int)(d.a(localg2) * -1.0F);
              localObject2 = parame.a(1, null);
              d.a((g)localObject2, k);
            }
            parame.a((b)localObject3);
          }
          else
          {
            localg2 = i;
            localObject3 = parame.b();
            localg1 = parame.c();
            d = 0;
            ((b)localObject3).b(localg2, (g)localObject2, localg1, 0);
            if (i != 0)
            {
              k = (int)(d.a(localg1) * -1.0F);
              localObject2 = parame.a(1, null);
              d.a((g)localObject2, k);
            }
            parame.a((b)localObject3);
          }
        }
      }
      j = m0;
      if (j == 0)
      {
        parame.a(u.i, s.i, 0, 6);
        if (i == 0) {
          parame.a(s.i, D.u.i, 0, 5);
        }
      }
      else if (j == 1)
      {
        parame.a(s.i, u.i, 0, 6);
        if (i == 0) {
          parame.a(s.i, D.s.i, 0, 5);
        }
      }
      else if (j == 2)
      {
        parame.a(v.i, t.i, 0, 6);
        if (i == 0) {
          parame.a(t.i, D.v.i, 0, 5);
        }
      }
      else if (j == 3)
      {
        parame.a(t.i, v.i, 0, 6);
        if (i == 0) {
          parame.a(t.i, D.t.i, 0, 5);
        }
      }
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void l()
  {
    super.l();
    n0.clear();
  }
  
  public void m()
  {
    int i = m0;
    float f1 = Float.MAX_VALUE;
    j localj1;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return;
          }
          localj1 = v.a;
        }
        else
        {
          localj1 = t.a;
          break label71;
        }
      }
      else {
        localj1 = u.a;
      }
      f1 = 0.0F;
    }
    else
    {
      localj1 = s.a;
    }
    label71:
    int j = n0.size();
    j localj2 = null;
    i = 0;
    while (i < j)
    {
      j localj3 = (j)n0.get(i);
      if (b != 1) {
        return;
      }
      int k = m0;
      float f2;
      if ((k != 0) && (k != 2))
      {
        f2 = g;
        f3 = f1;
        if (f2 <= f1) {
          break label194;
        }
        localj2 = f;
        f1 = f2;
      }
      else
      {
        f2 = g;
        f3 = f1;
        if (f2 >= f1) {
          break label194;
        }
        localj2 = f;
        f1 = f2;
      }
      float f3 = f1;
      label194:
      i++;
      f1 = f3;
    }
    f = localj2;
    g = f1;
    localj1.a();
    i = m0;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return;
          }
          t.a.a(localj2, f1);
        }
        else
        {
          v.a.a(localj2, f1);
        }
      }
      else {
        s.a.a(localj2, f1);
      }
    }
    else {
      u.a.a(localj2, f1);
    }
  }
}

/* Location:
 * Qualified Name:     d.g.a.h.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */