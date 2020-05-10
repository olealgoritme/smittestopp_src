package d.t.a;

import d.i.h.b;
import java.util.ArrayList;
import java.util.List;

public class a
  implements o.a
{
  public b<a.b> a = new b(30);
  public final ArrayList<a.b> b = new ArrayList();
  public final ArrayList<a.b> c = new ArrayList();
  public final a.a d;
  public final boolean e;
  public final o f;
  public int g = 0;
  
  public a(a.a parama)
  {
    d = parama;
    e = false;
    f = new o(this);
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    int i = c.size();
    int j = paramInt2;
    for (paramInt2 = paramInt1; j < i; paramInt2 = paramInt1)
    {
      a.b localb = (a.b)c.get(j);
      int k = a;
      int m;
      if (k == 8)
      {
        paramInt1 = b;
        if (paramInt1 == paramInt2)
        {
          paramInt1 = d;
        }
        else
        {
          m = paramInt2;
          if (paramInt1 < paramInt2) {
            m = paramInt2 - 1;
          }
          paramInt1 = m;
          if (d <= m) {
            paramInt1 = m + 1;
          }
        }
      }
      else
      {
        m = b;
        paramInt1 = paramInt2;
        if (m <= paramInt2) {
          if (k == 2)
          {
            paramInt1 = d;
            if (paramInt2 < m + paramInt1) {
              return -1;
            }
            paramInt1 = paramInt2 - paramInt1;
          }
          else
          {
            paramInt1 = paramInt2;
            if (k == 1) {
              paramInt1 = paramInt2 + d;
            }
          }
        }
      }
      j++;
    }
    return paramInt2;
  }
  
  public a.b a(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    a.b localb = (a.b)a.a();
    if (localb == null)
    {
      paramObject = new a.b(paramInt1, paramInt2, paramInt3, paramObject);
    }
    else
    {
      a = paramInt1;
      b = paramInt2;
      d = paramInt3;
      c = paramObject;
      paramObject = localb;
    }
    return (a.b)paramObject;
  }
  
  public void a()
  {
    int i = c.size();
    for (int j = 0; j < i; j++)
    {
      a.a locala = d;
      a.b localb = (a.b)c.get(j);
      ((u)locala).a(localb);
    }
    a(c);
    g = 0;
  }
  
  public final void a(a.b paramb)
  {
    int i = a;
    if ((i != 1) && (i != 8))
    {
      int j = b(b, i);
      i = b;
      int k = a;
      int m;
      if (k != 2)
      {
        if (k == 4)
        {
          m = 1;
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("op should be remove or update.");
          ((StringBuilder)localObject).append(paramb);
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      else {
        m = 0;
      }
      int n = 1;
      k = 1;
      while (n < d)
      {
        int i1 = b(m * n + b, a);
        int i2 = a;
        if (i2 != 2)
        {
          if (i2 != 4) {}
          while (i1 != j + 1)
          {
            i2 = 0;
            break;
          }
        }
        for (;;)
        {
          i2 = 1;
          break label177;
          if (i1 != j) {
            break;
          }
        }
        label177:
        if (i2 != 0)
        {
          k++;
        }
        else
        {
          localObject = a(a, j, k, c);
          a((a.b)localObject, i);
          if (!e)
          {
            c = null;
            a.a(localObject);
          }
          j = i;
          if (a == 4) {
            j = i + k;
          }
          i2 = i1;
          k = 1;
          i = j;
          j = i2;
        }
        n++;
      }
      Object localObject = c;
      if (!e)
      {
        c = null;
        a.a(paramb);
      }
      if (k > 0)
      {
        paramb = a(a, j, k, localObject);
        a(paramb, i);
        if (!e)
        {
          c = null;
          a.a(paramb);
        }
      }
      return;
    }
    throw new IllegalArgumentException("should not dispatch add or move for pre layout");
  }
  
  public void a(a.b paramb, int paramInt)
  {
    ((u)d).a(paramb);
    int i = a;
    a.a locala;
    if (i != 2)
    {
      if (i == 4)
      {
        locala = d;
        i = d;
        paramb = c;
        ((u)locala).a(paramInt, i, paramb);
      }
      else
      {
        throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
      }
    }
    else
    {
      locala = d;
      i = d;
      paramb = (u)locala;
      a.a(paramInt, i, true);
      paramb = a;
      F0 = true;
      paramb = C0;
      c += i;
    }
  }
  
  public void a(List<a.b> paramList)
  {
    int i = paramList.size();
    for (int j = 0; j < i; j++) {
      c((a.b)paramList.get(j));
    }
    paramList.clear();
  }
  
  public final boolean a(int paramInt)
  {
    int i = c.size();
    for (int j = 0; j < i; j++)
    {
      a.b localb = (a.b)c.get(j);
      int k = a;
      if (k == 8)
      {
        if (a(d, j + 1) == paramInt) {
          return true;
        }
      }
      else if (k == 1)
      {
        int m = b;
        int n = d;
        for (k = m; k < n + m; k++) {
          if (a(k, j + 1) == paramInt) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public final int b(int paramInt1, int paramInt2)
  {
    int i = c.size() - 1;
    a.b localb;
    for (int j = paramInt1; i >= 0; j = paramInt1)
    {
      localb = (a.b)c.get(i);
      int k = a;
      int m;
      if (k == 8)
      {
        paramInt1 = b;
        m = d;
        if (paramInt1 < m)
        {
          k = m;
        }
        else
        {
          k = paramInt1;
          paramInt1 = m;
        }
        if ((j >= paramInt1) && (j <= k))
        {
          m = b;
          if (paramInt1 == m)
          {
            if (paramInt2 == 1) {
              d += 1;
            } else if (paramInt2 == 2) {
              d -= 1;
            }
            paramInt1 = j + 1;
          }
          else
          {
            if (paramInt2 == 1) {
              b = (m + 1);
            } else if (paramInt2 == 2) {
              b = (m - 1);
            }
            paramInt1 = j - 1;
          }
        }
        else
        {
          m = b;
          paramInt1 = j;
          if (j < m) {
            if (paramInt2 == 1)
            {
              b = (m + 1);
              d += 1;
              paramInt1 = j;
            }
            else
            {
              paramInt1 = j;
              if (paramInt2 == 2)
              {
                b = (m - 1);
                d -= 1;
                paramInt1 = j;
              }
            }
          }
        }
      }
      else
      {
        m = b;
        if (m <= j)
        {
          if (k == 1)
          {
            paramInt1 = j - d;
          }
          else
          {
            paramInt1 = j;
            if (k == 2) {
              paramInt1 = j + d;
            }
          }
        }
        else if (paramInt2 == 1)
        {
          b = (m + 1);
          paramInt1 = j;
        }
        else
        {
          paramInt1 = j;
          if (paramInt2 == 2)
          {
            b = (m - 1);
            paramInt1 = j;
          }
        }
      }
      i--;
    }
    for (paramInt1 = c.size() - 1; paramInt1 >= 0; paramInt1--)
    {
      localb = (a.b)c.get(paramInt1);
      if (a == 8)
      {
        paramInt2 = d;
        if ((paramInt2 == b) || (paramInt2 < 0))
        {
          c.remove(paramInt1);
          if (!e)
          {
            c = null;
            a.a(localb);
          }
        }
      }
      else if (d <= 0)
      {
        c.remove(paramInt1);
        if (!e)
        {
          c = null;
          a.a(localb);
        }
      }
    }
    return j;
  }
  
  public void b()
  {
    a();
    int i = b.size();
    for (int j = 0; j < i; j++)
    {
      Object localObject = (a.b)b.get(j);
      int k = a;
      a.a locala;
      int m;
      if (k != 1)
      {
        if (k != 2)
        {
          if (k != 4)
          {
            if (k == 8)
            {
              ((u)d).a((a.b)localObject);
              locala = d;
              m = b;
              k = d;
              ((u)locala).b(m, k);
            }
          }
          else
          {
            ((u)d).a((a.b)localObject);
            locala = d;
            m = b;
            k = d;
            localObject = c;
            ((u)locala).a(m, k, localObject);
          }
        }
        else
        {
          ((u)d).a((a.b)localObject);
          locala = d;
          k = b;
          m = d;
          localObject = (u)locala;
          a.a(k, m, true);
          localObject = a;
          F0 = true;
          localObject = C0;
          c += m;
        }
      }
      else
      {
        ((u)d).a((a.b)localObject);
        locala = d;
        m = b;
        k = d;
        ((u)locala).a(m, k);
      }
    }
    a(b);
    g = 0;
  }
  
  public final void b(a.b paramb)
  {
    c.add(paramb);
    int i = a;
    Object localObject;
    int j;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 4)
        {
          if (i == 8)
          {
            localObject = d;
            j = b;
            i = d;
            ((u)localObject).b(j, i);
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Unknown update op type for ");
            ((StringBuilder)localObject).append(paramb);
            throw new IllegalArgumentException(((StringBuilder)localObject).toString());
          }
        }
        else
        {
          localObject = d;
          j = b;
          i = d;
          paramb = c;
          ((u)localObject).a(j, i, paramb);
        }
      }
      else
      {
        localObject = d;
        i = b;
        j = d;
        paramb = (u)localObject;
        a.a(i, j, false);
        a.F0 = true;
      }
    }
    else
    {
      localObject = d;
      i = b;
      j = d;
      ((u)localObject).a(i, j);
    }
  }
  
  public void c(a.b paramb)
  {
    if (!e)
    {
      c = null;
      a.a(paramb);
    }
  }
  
  public boolean c()
  {
    boolean bool;
    if (b.size() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void d()
  {
    o localo = f;
    ArrayList localArrayList = b;
    if (localo != null)
    {
      int i;
      int j;
      int k;
      label79:
      int m;
      int n;
      Object localObject2;
      Object localObject3;
      label237:
      label340:
      label536:
      label541:
      int i1;
      for (;;)
      {
        i = localArrayList.size() - 1;
        for (j = 0; i >= 0; j = k)
        {
          if (geta == 8)
          {
            k = j;
            if (j != 0)
            {
              j = i;
              break label79;
            }
          }
          else
          {
            k = 1;
          }
          i--;
        }
        j = -1;
        if (j == -1) {
          break;
        }
        m = j + 1;
        Object localObject1 = (a.b)localArrayList.get(j);
        a.b localb = (a.b)localArrayList.get(m);
        i = a;
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 4)
            {
              i = d;
              n = b;
              if (i < n)
              {
                b = (n - 1);
              }
              else
              {
                k = d;
                if (i < n + k)
                {
                  d = (k - 1);
                  localObject2 = a;
                  i = b;
                  localObject3 = c;
                  localObject3 = ((a)localObject2).a(4, i, 1, localObject3);
                  break label237;
                }
              }
              localObject3 = null;
              i = b;
              k = b;
              if (i <= k)
              {
                b = (k + 1);
              }
              else
              {
                k += d;
                if (i < k)
                {
                  k -= i;
                  o.a locala = a;
                  localObject2 = c;
                  localObject2 = ((a)locala).a(4, i + 1, k, localObject2);
                  d -= k;
                  break label340;
                }
              }
              localObject2 = null;
              localArrayList.set(m, localObject1);
              if (d > 0)
              {
                localArrayList.set(j, localb);
              }
              else
              {
                localArrayList.remove(j);
                localObject1 = (a)a;
                if (!e)
                {
                  c = null;
                  a.a(localb);
                }
              }
              if (localObject3 != null) {
                localArrayList.add(j, localObject3);
              }
              if (localObject2 != null) {
                localArrayList.add(j, localObject2);
              }
            }
          }
          else
          {
            k = b;
            i = d;
            if (k < i)
            {
              if ((b == k) && (d == i - k))
              {
                i = 0;
              }
              else
              {
                i = 0;
                k = 0;
                break label541;
              }
            }
            else
            {
              if ((b != i + 1) || (d != k - i)) {
                break label536;
              }
              i = 1;
            }
            k = i;
            i = 1;
            break label541;
            i = 0;
            k = 1;
            i1 = d;
            n = b;
            if (i1 < n)
            {
              b = (n - 1);
            }
            else
            {
              i2 = d;
              if (i1 < n + i2)
              {
                d = (i2 - 1);
                a = 2;
                d = 1;
                if (d != 0) {
                  continue;
                }
                localArrayList.remove(m);
                localObject3 = (a)a;
                if (e) {
                  continue;
                }
                c = null;
                a.a(localb);
                continue;
              }
            }
            n = b;
            i1 = b;
            if (n <= i1)
            {
              b = (i1 + 1);
            }
            else
            {
              i1 += d;
              if (n < i1)
              {
                localObject3 = ((a)a).a(2, n + 1, i1 - n, null);
                d = (b - b);
                break label761;
              }
            }
            localObject3 = null;
            label761:
            if (i != 0)
            {
              localArrayList.set(j, localb);
              localArrayList.remove(m);
              localObject3 = (a)a;
              if (!e)
              {
                c = null;
                a.a(localObject1);
              }
            }
            else
            {
              if (k != 0)
              {
                if (localObject3 != null)
                {
                  i = b;
                  if (i > b) {
                    b = (i - d);
                  }
                  i = d;
                  if (i > b) {
                    d = (i - d);
                  }
                }
                i = b;
                if (i > b) {
                  b = (i - d);
                }
                i = d;
                if (i > b) {
                  d = (i - d);
                }
              }
              else
              {
                if (localObject3 != null)
                {
                  i = b;
                  if (i >= b) {
                    b = (i - d);
                  }
                  i = d;
                  if (i >= b) {
                    d = (i - d);
                  }
                }
                i = b;
                if (i >= b) {
                  b = (i - d);
                }
                i = d;
                if (i >= b) {
                  d = (i - d);
                }
              }
              localArrayList.set(j, localb);
              if (b != d) {
                localArrayList.set(m, localObject1);
              } else {
                localArrayList.remove(m);
              }
              if (localObject3 != null) {
                localArrayList.add(j, localObject3);
              }
            }
          }
        }
        else
        {
          if (d < b) {
            i = -1;
          } else {
            i = 0;
          }
          k = i;
          if (b < b) {
            k = i + 1;
          }
          i = b;
          n = b;
          if (i <= n) {
            b = (n + d);
          }
          i = b;
          n = d;
          if (i <= n) {
            d = (n + d);
          }
          b += k;
          localArrayList.set(j, localb);
          localArrayList.set(m, localObject1);
        }
      }
      int i3 = b.size();
      for (int i2 = 0; i2 < i3; i2++)
      {
        localObject3 = (a.b)b.get(i2);
        i = a;
        if (i != 1)
        {
          int i4;
          if (i != 2)
          {
            if (i != 4)
            {
              if (i == 8) {
                b((a.b)localObject3);
              }
            }
            else
            {
              i4 = b;
              int i5 = d;
              k = i4;
              i = 0;
              int i6 = -1;
              j = i4;
              while (j < i5 + i4)
              {
                if ((((u)d).a(j) == null) && (!a(j)))
                {
                  n = k;
                  m = i;
                  if (i6 == 1)
                  {
                    b(a(4, k, i, c));
                    n = j;
                    m = 0;
                  }
                  i = 0;
                  k = n;
                  n = m;
                  m = i;
                }
                else
                {
                  i1 = k;
                  n = i;
                  if (i6 == 0)
                  {
                    a(a(4, k, i, c));
                    i1 = j;
                    n = 0;
                  }
                  m = 1;
                  k = i1;
                }
                i = n + 1;
                j++;
                i6 = m;
              }
              localObject2 = localObject3;
              if (i != d)
              {
                localObject2 = c;
                if (!e)
                {
                  c = null;
                  a.a(localObject3);
                }
                localObject2 = a(4, k, i, localObject2);
              }
              if (i6 == 0) {
                a((a.b)localObject2);
              } else {
                b((a.b)localObject2);
              }
            }
          }
          else
          {
            i1 = b;
            m = d + i1;
            i = i1;
            n = 0;
            k = -1;
            while (i < m)
            {
              if ((((u)d).a(i) == null) && (!a(i)))
              {
                if (k == 1)
                {
                  b(a(2, i1, n, null));
                  k = 1;
                }
                else
                {
                  k = 0;
                }
                i4 = 0;
                j = k;
                k = i4;
              }
              else
              {
                if (k == 0)
                {
                  a(a(2, i1, n, null));
                  j = 1;
                }
                else
                {
                  j = 0;
                }
                k = 1;
              }
              if (j != 0)
              {
                i -= n;
                m -= n;
                j = 1;
              }
              else
              {
                j = n + 1;
              }
              i++;
              n = j;
            }
            localObject2 = localObject3;
            if (n != d)
            {
              if (!e)
              {
                c = null;
                a.a(localObject3);
              }
              localObject2 = a(2, i1, n, null);
            }
            if (k == 0) {
              a((a.b)localObject2);
            } else {
              b((a.b)localObject2);
            }
          }
        }
        else
        {
          b((a.b)localObject3);
        }
      }
      b.clear();
      return;
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     base.d.t.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */