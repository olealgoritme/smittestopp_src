package d.t.a;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.t;
import d.i.h.b;
import java.util.ArrayList;
import java.util.List;

public class a
  implements o.a
{
  public b<b> a = new b(30);
  public final ArrayList<b> b = new ArrayList();
  public final ArrayList<b> c = new ArrayList();
  public final a d;
  public final boolean e;
  public final o f;
  public int g = 0;
  
  public a(a parama)
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
      b localb = (b)c.get(j);
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
  
  public b a(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    b localb = (b)a.a();
    if (localb == null)
    {
      paramObject = new b(paramInt1, paramInt2, paramInt3, paramObject);
    }
    else
    {
      a = paramInt1;
      b = paramInt2;
      d = paramInt3;
      c = paramObject;
      paramObject = localb;
    }
    return (b)paramObject;
  }
  
  public void a()
  {
    int i = c.size();
    for (int j = 0; j < i; j++)
    {
      a locala = d;
      b localb = (b)c.get(j);
      ((t)locala).a(localb);
    }
    a(c);
    g = 0;
  }
  
  public final void a(b paramb)
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
          a((b)localObject, i);
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
  
  public void a(b paramb, int paramInt)
  {
    ((t)d).a(paramb);
    int i = a;
    a locala;
    if (i != 2)
    {
      if (i == 4)
      {
        locala = d;
        i = d;
        paramb = c;
        ((t)locala).a(paramInt, i, paramb);
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
      paramb = (t)locala;
      a.a(paramInt, i, true);
      paramb = a;
      F0 = true;
      paramb = C0;
      c += i;
    }
  }
  
  public void a(List<b> paramList)
  {
    int i = paramList.size();
    for (int j = 0; j < i; j++) {
      c((b)paramList.get(j));
    }
    paramList.clear();
  }
  
  public final boolean a(int paramInt)
  {
    int i = c.size();
    for (int j = 0; j < i; j++)
    {
      b localb = (b)c.get(j);
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
    b localb;
    for (int j = paramInt1; i >= 0; j = paramInt1)
    {
      localb = (b)c.get(i);
      int k = a;
      int m;
      if (k == 8)
      {
        k = b;
        paramInt1 = d;
        if (k >= paramInt1)
        {
          m = paramInt1;
          paramInt1 = k;
          k = m;
        }
        if ((j >= k) && (j <= paramInt1))
        {
          paramInt1 = b;
          if (k == paramInt1)
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
              b = (paramInt1 + 1);
            } else if (paramInt2 == 2) {
              b = (paramInt1 - 1);
            }
            paramInt1 = j - 1;
          }
        }
        else
        {
          k = b;
          paramInt1 = j;
          if (j < k) {
            if (paramInt2 == 1)
            {
              b = (k + 1);
              d += 1;
              paramInt1 = j;
            }
            else
            {
              paramInt1 = j;
              if (paramInt2 == 2)
              {
                b = (k - 1);
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
      localb = (b)c.get(paramInt1);
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
      Object localObject = (b)b.get(j);
      int k = a;
      a locala;
      int m;
      if (k != 1)
      {
        if (k != 2)
        {
          if (k != 4)
          {
            if (k == 8)
            {
              ((t)d).a((b)localObject);
              locala = d;
              k = b;
              m = d;
              ((t)locala).b(k, m);
            }
          }
          else
          {
            ((t)d).a((b)localObject);
            locala = d;
            k = b;
            m = d;
            localObject = c;
            ((t)locala).a(k, m, localObject);
          }
        }
        else
        {
          ((t)d).a((b)localObject);
          locala = d;
          k = b;
          m = d;
          localObject = (t)locala;
          a.a(k, m, true);
          localObject = a;
          F0 = true;
          localObject = C0;
          c += m;
        }
      }
      else
      {
        ((t)d).a((b)localObject);
        locala = d;
        k = b;
        m = d;
        ((t)locala).a(k, m);
      }
    }
    a(b);
    g = 0;
  }
  
  public final void b(b paramb)
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
            i = b;
            j = d;
            ((t)localObject).b(i, j);
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
          i = b;
          j = d;
          paramb = c;
          ((t)localObject).a(i, j, paramb);
        }
      }
      else
      {
        localObject = d;
        j = b;
        i = d;
        paramb = (t)localObject;
        a.a(j, i, false);
        a.F0 = true;
      }
    }
    else
    {
      localObject = d;
      j = b;
      i = d;
      ((t)localObject).a(j, i);
    }
  }
  
  public void c(b paramb)
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
      int i2;
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
              k = i;
              break label79;
            }
          }
          else
          {
            k = 1;
          }
          i--;
        }
        k = -1;
        if (k == -1) {
          break;
        }
        m = k + 1;
        Object localObject1 = (b)localArrayList.get(k);
        b localb = (b)localArrayList.get(m);
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
                j = d;
                if (i < n + j)
                {
                  d = (j - 1);
                  localObject2 = a;
                  i = b;
                  localObject3 = c;
                  localObject2 = ((a)localObject2).a(4, i, 1, localObject3);
                  break label237;
                }
              }
              localObject2 = null;
              i = b;
              j = b;
              if (i <= j)
              {
                b = (j + 1);
              }
              else
              {
                j += d;
                if (i < j)
                {
                  j -= i;
                  localObject3 = a;
                  Object localObject4 = c;
                  localObject3 = ((a)localObject3).a(4, i + 1, j, localObject4);
                  d -= j;
                  break label340;
                }
              }
              localObject3 = null;
              localArrayList.set(m, localObject1);
              if (d > 0)
              {
                localArrayList.set(k, localb);
              }
              else
              {
                localArrayList.remove(k);
                localObject1 = (a)a;
                if (!e)
                {
                  c = null;
                  a.a(localb);
                }
              }
              if (localObject2 != null) {
                localArrayList.add(k, localObject2);
              }
              if (localObject3 != null) {
                localArrayList.add(k, localObject3);
              }
            }
          }
          else
          {
            j = b;
            i = d;
            if (j < i)
            {
              if ((b == j) && (d == i - j))
              {
                i = 0;
              }
              else
              {
                i = 0;
                j = 0;
                break label541;
              }
            }
            else
            {
              if ((b != i + 1) || (d != j - i)) {
                break label536;
              }
              i = 1;
            }
            j = i;
            i = 1;
            break label541;
            i = 0;
            j = 1;
            n = d;
            i1 = b;
            if (n < i1)
            {
              b = (i1 - 1);
            }
            else
            {
              i2 = d;
              if (n < i1 + i2)
              {
                d = (i2 - 1);
                a = 2;
                d = 1;
                if (d != 0) {
                  continue;
                }
                localArrayList.remove(m);
                localObject2 = (a)a;
                if (e) {
                  continue;
                }
                c = null;
                a.a(localb);
                continue;
              }
            }
            n = b;
            i2 = b;
            if (n <= i2)
            {
              b = (i2 + 1);
            }
            else
            {
              i2 += d;
              if (n < i2)
              {
                localObject2 = ((a)a).a(2, n + 1, i2 - n, null);
                d = (b - b);
                break label761;
              }
            }
            localObject2 = null;
            label761:
            if (i != 0)
            {
              localArrayList.set(k, localb);
              localArrayList.remove(m);
              localObject2 = (a)a;
              if (!e)
              {
                c = null;
                a.a(localObject1);
              }
            }
            else
            {
              if (j != 0)
              {
                if (localObject2 != null)
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
                if (localObject2 != null)
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
              localArrayList.set(k, localb);
              if (b != d) {
                localArrayList.set(m, localObject1);
              } else {
                localArrayList.remove(m);
              }
              if (localObject2 != null) {
                localArrayList.add(k, localObject2);
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
          j = i;
          if (b < b) {
            j = i + 1;
          }
          n = b;
          i = b;
          if (n <= i) {
            b = (i + d);
          }
          i = b;
          n = d;
          if (i <= n) {
            d = (n + d);
          }
          b += j;
          localArrayList.set(k, localb);
          localArrayList.set(m, localObject1);
        }
      }
      int i3 = b.size();
      for (int i1 = 0; i1 < i3; i1++)
      {
        localObject2 = (b)b.get(i1);
        i = a;
        if (i != 1)
        {
          int i4;
          if (i != 2)
          {
            if (i != 4)
            {
              if (i == 8) {
                b((b)localObject2);
              }
            }
            else
            {
              i4 = b;
              int i5 = d;
              j = i4;
              i = 0;
              int i6 = -1;
              k = i4;
              while (k < i5 + i4)
              {
                if ((((t)d).a(k) == null) && (!a(k)))
                {
                  n = j;
                  m = i;
                  if (i6 == 1)
                  {
                    b(a(4, j, i, c));
                    n = k;
                    m = 0;
                  }
                  i = 0;
                  j = n;
                  i2 = m;
                  m = i;
                }
                else
                {
                  n = j;
                  i2 = i;
                  if (i6 == 0)
                  {
                    a(a(4, j, i, c));
                    n = k;
                    i2 = 0;
                  }
                  m = 1;
                  j = n;
                }
                i = i2 + 1;
                k++;
                i6 = m;
              }
              localObject3 = localObject2;
              if (i != d)
              {
                localObject3 = c;
                if (!e)
                {
                  c = null;
                  a.a(localObject2);
                }
                localObject3 = a(4, j, i, localObject3);
              }
              if (i6 == 0) {
                a((b)localObject3);
              } else {
                b((b)localObject3);
              }
            }
          }
          else
          {
            i2 = b;
            m = d + i2;
            i = i2;
            n = 0;
            j = -1;
            while (i < m)
            {
              if ((((t)d).a(i) == null) && (!a(i)))
              {
                if (j == 1)
                {
                  b(a(2, i2, n, null));
                  j = 1;
                }
                else
                {
                  j = 0;
                }
                i4 = 0;
                k = j;
                j = i4;
              }
              else
              {
                if (j == 0)
                {
                  a(a(2, i2, n, null));
                  k = 1;
                }
                else
                {
                  k = 0;
                }
                j = 1;
              }
              if (k != 0)
              {
                i -= n;
                m -= n;
                k = 1;
              }
              else
              {
                k = n + 1;
              }
              i++;
              n = k;
            }
            localObject3 = localObject2;
            if (n != d)
            {
              if (!e)
              {
                c = null;
                a.a(localObject2);
              }
              localObject3 = a(2, i2, n, null);
            }
            if (j == 0) {
              a((b)localObject3);
            } else {
              b((b)localObject3);
            }
          }
        }
        else
        {
          b((b)localObject2);
        }
      }
      b.clear();
      return;
    }
    throw null;
  }
  
  public static abstract interface a {}
  
  public static class b
  {
    public int a;
    public int b;
    public Object c;
    public int d;
    
    public b(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
    {
      a = paramInt1;
      b = paramInt2;
      d = paramInt3;
      c = paramObject;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if ((paramObject != null) && (b.class == paramObject.getClass()))
      {
        b localb = (b)paramObject;
        int i = a;
        if (i != a) {
          return false;
        }
        if ((i == 8) && (Math.abs(d - b) == 1) && (d == b) && (b == d)) {
          return true;
        }
        if (d != d) {
          return false;
        }
        if (b != b) {
          return false;
        }
        paramObject = c;
        if (paramObject != null)
        {
          if (!paramObject.equals(c)) {
            return false;
          }
        }
        else if (c != null) {
          return false;
        }
        return true;
      }
      return false;
    }
    
    public int hashCode()
    {
      return (a * 31 + b) * 31 + d;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      localStringBuilder.append("[");
      int i = a;
      String str;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 4)
          {
            if (i != 8) {
              str = "??";
            } else {
              str = "mv";
            }
          }
          else {
            str = "up";
          }
        }
        else {
          str = "rm";
        }
      }
      else {
        str = "add";
      }
      localStringBuilder.append(str);
      localStringBuilder.append(",s:");
      localStringBuilder.append(b);
      localStringBuilder.append("c:");
      localStringBuilder.append(d);
      localStringBuilder.append(",p:");
      localStringBuilder.append(c);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
}

/* Location:
 * Qualified Name:     d.t.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */