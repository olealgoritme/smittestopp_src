package k.b.i.b.g;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public final class a
  implements Serializable
{
  public int A;
  public u B;
  public List<u> C;
  public Map<Integer, LinkedList<u>> D;
  public Stack<u> E;
  public Map<Integer, u> F;
  public int G;
  public boolean H;
  public transient int I;
  public transient k x;
  public final int y;
  public final List<c> z;
  
  public a(a parama)
  {
    x = new k(x.a);
    y = y;
    A = A;
    B = B;
    Object localObject = new ArrayList();
    C = ((List)localObject);
    ((List)localObject).addAll(C);
    D = new TreeMap();
    Iterator localIterator = D.keySet().iterator();
    while (localIterator.hasNext())
    {
      localObject = (Integer)localIterator.next();
      D.put(localObject, (LinkedList)((LinkedList)D.get(localObject)).clone());
    }
    localObject = new Stack();
    E = ((Stack)localObject);
    ((Stack)localObject).addAll(E);
    z = new ArrayList();
    localObject = z.iterator();
    while (((Iterator)localObject).hasNext()) {
      z.add(((c)((Iterator)localObject).next()).clone());
    }
    F = new TreeMap(F);
    G = G;
    I = I;
    H = H;
  }
  
  public a(a parama, k.b.a.o paramo)
  {
    x = new k(new m(paramo));
    y = y;
    A = A;
    B = B;
    paramo = new ArrayList();
    C = paramo;
    paramo.addAll(C);
    D = new TreeMap();
    paramo = D.keySet().iterator();
    while (paramo.hasNext())
    {
      Integer localInteger = (Integer)paramo.next();
      D.put(localInteger, (LinkedList)((LinkedList)D.get(localInteger)).clone());
    }
    paramo = new Stack();
    E = paramo;
    paramo.addAll(E);
    z = new ArrayList();
    paramo = z.iterator();
    while (paramo.hasNext()) {
      z.add(((c)paramo.next()).clone());
    }
    paramo = new TreeMap(F);
    F = paramo;
    int i = G;
    G = i;
    I = I;
    H = H;
    if (C != null)
    {
      if (D != null)
      {
        if (E != null)
        {
          if (z != null)
          {
            if (paramo != null)
            {
              if (k.b.c.e.a.a(y, i)) {
                return;
              }
              throw new IllegalStateException("index in BDS state out of bounds");
            }
            throw new IllegalStateException("keep == null");
          }
          throw new IllegalStateException("treeHashInstances == null");
        }
        throw new IllegalStateException("stack == null");
      }
      throw new IllegalStateException("retain == null");
    }
    throw new IllegalStateException("authenticationPath == null");
  }
  
  public a(a parama, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, j paramj)
  {
    x = new k(x.a);
    y = y;
    A = A;
    B = B;
    Object localObject = new ArrayList();
    C = ((List)localObject);
    ((List)localObject).addAll(C);
    D = new TreeMap();
    localObject = D.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      D.put(localInteger, (LinkedList)((LinkedList)D.get(localInteger)).clone());
    }
    localObject = new Stack();
    E = ((Stack)localObject);
    ((Stack)localObject).addAll(E);
    z = new ArrayList();
    localObject = z.iterator();
    while (((Iterator)localObject).hasNext()) {
      z.add(((c)((Iterator)localObject).next()).clone());
    }
    F = new TreeMap(F);
    G = G;
    I = I;
    H = false;
    b(paramArrayOfByte1, paramArrayOfByte2, paramj);
  }
  
  public a(k paramk, int paramInt1, int paramInt2, int paramInt3)
  {
    x = paramk;
    y = paramInt1;
    I = paramInt3;
    A = paramInt2;
    if ((paramInt2 <= paramInt1) && (paramInt2 >= 2))
    {
      paramInt2 = paramInt1 - paramInt2;
      if (paramInt2 % 2 == 0)
      {
        C = new ArrayList();
        D = new TreeMap();
        E = new Stack();
        z = new ArrayList();
        for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++) {
          z.add(new c(paramInt1));
        }
        F = new TreeMap();
        G = 0;
        H = false;
        return;
      }
    }
    throw new IllegalArgumentException("illegal value for BDS parameter k");
  }
  
  public final void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, j paramj)
  {
    if (paramj != null)
    {
      Object localObject1 = (i)((i.b)((i.b)new i.b().b(a)).a(b)).b();
      Object localObject2 = (g)((g.b)((g.b)new g.b().b(a)).a(b)).b();
      int i = 0;
      j localj = paramj;
      paramj = (j)localObject2;
      while (i < 1 << y)
      {
        localObject2 = (j.b)((j.b)new j.b().b(a)).a(b);
        e = i;
        f = f;
        g = g;
        localj = (j)((j.b)((o.a)localObject2).a(d)).b();
        localObject2 = x;
        ((k)localObject2).a(((k)localObject2).a(paramArrayOfByte2, localj), paramArrayOfByte1);
        Object localObject3 = x.a(localj);
        localObject2 = (i.b)((i.b)new i.b().b(a)).a(b);
        e = i;
        f = f;
        g = g;
        localObject2 = (i)((i.b)((o.a)localObject2).a(d)).b();
        localObject1 = k.b.c.e.a.a(x, (n)localObject3, (i)localObject2);
        localObject3 = (g.b)((g.b)new g.b().b(a)).a(b);
        f = i;
        for (paramj = (g)((g.b)((o.a)localObject3).a(d)).b(); !E.isEmpty(); paramj = (g)((g.b)((o.a)localObject3).a(d)).b())
        {
          int j = E.peek()).x;
          int k = x;
          if (j != k) {
            break;
          }
          k = i / (1 << k);
          if (k == 1) {
            C.add(localObject1);
          }
          if (k == 3)
          {
            j = x;
            if (j < y - A)
            {
              localObject3 = (c)z.get(j);
              x = ((u)localObject1);
              j = x;
              z = j;
              if (j == y) {
                C = true;
              }
            }
          }
          if ((k >= 3) && ((k & 0x1) == 1))
          {
            j = x;
            k = y;
            if ((j >= k - A) && (j <= k - 2)) {
              if (D.get(Integer.valueOf(j)) == null)
              {
                localObject3 = new LinkedList();
                ((LinkedList)localObject3).add(localObject1);
                D.put(Integer.valueOf(x), localObject3);
              }
              else
              {
                ((LinkedList)D.get(Integer.valueOf(x))).add(localObject1);
              }
            }
          }
          localObject3 = (g.b)((g.b)new g.b().b(a)).a(b);
          e = f;
          f = ((g - 1) / 2);
          paramj = (g)((g.b)((o.a)localObject3).a(d)).b();
          localObject1 = k.b.c.e.a.a(x, (u)E.pop(), (u)localObject1, paramj);
          localObject1 = new u(x + 1, ((u)localObject1).a());
          localObject3 = (g.b)((g.b)new g.b().b(a)).a(b);
          e = (f + 1);
          f = g;
        }
        E.push(localObject1);
        i++;
        localObject1 = localObject2;
      }
      B = ((u)E.pop());
      return;
    }
    throw new NullPointerException("otsHashAddress == null");
  }
  
  public final void b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, j paramj)
  {
    if (paramj != null)
    {
      if (!H)
      {
        int i = G;
        if (i <= I - 1)
        {
          int j = y;
          int k = 0;
          for (int m = 0; m < j; m++) {
            if ((i >> m & 0x1) == 0) {
              break label69;
            }
          }
          m = 0;
          label69:
          if (((G >> m + 1 & 0x1) == 0) && (m < y - 1)) {
            F.put(Integer.valueOf(m), C.get(m));
          }
          Object localObject1 = (i)((i.b)((i.b)new i.b().b(a)).a(b)).b();
          Object localObject2 = (g)((g.b)((g.b)new g.b().b(a)).a(b)).b();
          Object localObject3;
          if (m == 0)
          {
            localObject2 = (j.b)((j.b)new j.b().b(a)).a(b);
            e = G;
            f = f;
            g = g;
            localObject2 = (j)((j.b)((o.a)localObject2).a(d)).b();
            paramj = x;
            paramj.a(paramj.a(paramArrayOfByte2, (j)localObject2), paramArrayOfByte1);
            paramj = x.a((j)localObject2);
            localObject3 = (i.b)((i.b)new i.b().b(a)).a(b);
            e = G;
            f = f;
            g = g;
            localObject1 = (i)((i.b)((o.a)localObject3).a(d)).b();
            paramj = k.b.c.e.a.a(x, paramj, (i)localObject1);
            C.set(0, paramj);
            j = k;
          }
          else
          {
            localObject1 = (g.b)((g.b)new g.b().b(a)).a(b);
            j = m - 1;
            e = j;
            f = (G >> m);
            localObject1 = (g)((g.b)((o.a)localObject1).a(d)).b();
            localObject2 = x;
            ((k)localObject2).a(((k)localObject2).a(paramArrayOfByte2, paramj), paramArrayOfByte1);
            localObject2 = k.b.c.e.a.a(x, (u)C.get(j), (u)F.get(Integer.valueOf(j)), (o)localObject1);
            localObject2 = new u(x + 1, ((u)localObject2).a());
            C.set(m, localObject2);
            F.remove(Integer.valueOf(j));
            for (j = 0; j < m; j++)
            {
              if (j < y - A)
              {
                localObject1 = C;
                localObject2 = z.get(j)).x;
              }
              else
              {
                localObject1 = C;
                localObject2 = ((LinkedList)D.get(Integer.valueOf(j))).removeFirst();
              }
              ((List)localObject1).set(j, localObject2);
            }
            i = Math.min(m, y - A);
            for (m = 0;; m++)
            {
              j = k;
              localObject2 = paramj;
              if (m >= i) {
                break;
              }
              j = (1 << m) * 3 + (G + 1);
              if (j < 1 << y)
              {
                localObject2 = (c)z.get(m);
                x = null;
                z = y;
                A = j;
                B = true;
                C = false;
              }
            }
          }
          while (j < y - A >> 1)
          {
            localObject3 = z.iterator();
            for (localObject1 = null; ((Iterator)localObject3).hasNext(); localObject1 = paramj)
            {
              label841:
              paramj = (c)((Iterator)localObject3).next();
              if ((C) || (!B) || ((localObject1 != null) && (paramj.a() >= ((c)localObject1).a()) && ((paramj.a() != ((c)localObject1).a()) || (A >= A)))) {
                break label841;
              }
            }
            if (localObject1 != null)
            {
              Object localObject4 = E;
              Object localObject5 = x;
              if ((!C) && (B))
              {
                paramj = (j.b)((j.b)new j.b().b(a)).a(b);
                e = A;
                f = f;
                g = g;
                paramj = (j)((j.b)paramj.a(d)).b();
                localObject3 = (i.b)((i.b)new i.b().b(a)).a(b);
                e = A;
                Object localObject6 = (i)((i.b)localObject3).b();
                localObject3 = (g.b)((g.b)new g.b().b(a)).a(b);
                f = A;
                localObject3 = (g)((g.b)localObject3).b();
                ((k)localObject5).a(((k)localObject5).a(paramArrayOfByte2, paramj), paramArrayOfByte1);
                paramj = k.b.c.e.a.a((k)localObject5, ((k)localObject5).a(paramj), (i)localObject6);
                while ((!((Stack)localObject4).isEmpty()) && (peekx == x) && (peekx != y))
                {
                  localObject6 = (g.b)((g.b)new g.b().b(a)).a(b);
                  e = f;
                  f = ((g - 1) / 2);
                  localObject3 = (g)((g.b)((o.a)localObject6).a(d)).b();
                  paramj = k.b.c.e.a.a((k)localObject5, (u)((Stack)localObject4).pop(), paramj, (o)localObject3);
                  paramj = new u(x + 1, paramj.a());
                  localObject6 = (g.b)((g.b)new g.b().b(a)).a(b);
                  e = (f + 1);
                  f = g;
                  localObject3 = (g)((g.b)((o.a)localObject6).a(d)).b();
                }
                localObject6 = x;
                if (localObject6 == null)
                {
                  x = paramj;
                }
                else if (x == x)
                {
                  localObject4 = (g.b)((g.b)new g.b().b(a)).a(b);
                  e = f;
                  f = ((g - 1) / 2);
                  localObject3 = (g)((g.b)((o.a)localObject4).a(d)).b();
                  paramj = k.b.c.e.a.a((k)localObject5, x, paramj, (o)localObject3);
                  paramj = new u(x.x + 1, paramj.a());
                  x = paramj;
                  localObject5 = (g.b)((g.b)new g.b().b(a)).a(b);
                  e = (f + 1);
                  f = g;
                  localObject3 = (g)((g.b)((o.a)localObject5).a(d)).b();
                }
                else
                {
                  ((Stack)localObject4).push(paramj);
                }
                if (x.x == y)
                {
                  C = true;
                }
                else
                {
                  z = x;
                  A += 1;
                }
              }
              else
              {
                throw new IllegalStateException("finished or not initialized");
              }
            }
            j++;
          }
          G += 1;
          return;
        }
        throw new IllegalStateException("index out of bounds");
      }
      throw new IllegalStateException("index already used");
    }
    throw new NullPointerException("otsHashAddress == null");
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.b.g.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */