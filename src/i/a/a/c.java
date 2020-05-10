package i.a.a;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import k.e.a.g;
import k.e.a.q;
import k.e.a.s;
import k.e.a.y;

public abstract class c<T>
{
  public static ConcurrentHashMap<Class<?>, c<?>> c = new ConcurrentHashMap();
  public HashMap<String, a> a;
  public a[] b;
  
  public static <P> c<P> a(Class<P> paramClass, i parami)
  {
    Object localObject1 = (c)c.get(paramClass);
    if (localObject1 != null) {
      return (c<P>)localObject1;
    }
    Object localObject2 = new HashMap();
    if (parami == null) {
      parami = b.a;
    }
    localObject1 = paramClass;
    a[] arrayOfa;
    Object localObject3;
    if (localObject1 == Object.class)
    {
      arrayOfa = (a[])((HashMap)localObject2).values().toArray(new a[((HashMap)localObject2).size()]);
      localObject1 = paramClass.getName();
      if (((String)localObject1).startsWith("java.util."))
      {
        parami = new StringBuilder("net.minidev.asm.");
        parami.append((String)localObject1);
        parami.append("AccAccess");
        localObject1 = parami.toString();
      }
      else
      {
        localObject1 = ((String)localObject1).concat("AccAccess");
      }
      localObject3 = new h(paramClass.getClassLoader());
      parami = null;
    }
    try
    {
      localObject2 = ((ClassLoader)localObject3).loadClass((String)localObject1);
      parami = (i)localObject2;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Object localObject4;
      Object localObject5;
      int i;
      int j;
      d locald;
      label255:
      int k;
      Object localObject6;
      Object localObject7;
      int m;
      Object localObject8;
      int n;
      Object localObject9;
      String str;
      label1980:
      label2132:
      for (;;) {}
    }
    localObject2 = new LinkedList();
    localObject4 = paramClass;
    if ((localObject4 != null) && (!localObject4.equals(Object.class)))
    {
      ((LinkedList)localObject2).addLast(localObject4);
      localObject5 = ((Class)localObject4).getInterfaces();
      i = localObject5.length;
      for (j = 0;; j++)
      {
        if (j >= i)
        {
          localObject4 = ((Class)localObject4).getSuperclass();
          break;
        }
        ((LinkedList)localObject2).addLast(localObject5[j]);
      }
    }
    ((LinkedList)localObject2).addLast(Object.class);
    if (parami == null)
    {
      locald = new d(paramClass, arrayOfa, (h)localObject3);
      localObject4 = ((LinkedList)localObject2).iterator();
      parami = (i)localObject2;
      break label1980;
      k = 0;
      if (!((Iterator)localObject4).hasNext())
      {
        localObject2 = new g(1);
        if (a.length > 10) {
          j = 1;
        } else {
          j = 0;
        }
        localObject4 = e.a.a.a.a.a(new StringBuilder("Lnet/minidev/asm/BeansAccess<L"), f, ";>;");
        ((g)localObject2).a(50, 33, e, (String)localObject4, d.i, null);
        localObject4 = ((g)localObject2).a(1, "<init>", "()V", null, null);
        ((s)localObject4).d(25, 0);
        ((s)localObject4).b(183, d.i, "<init>", "()V");
        ((s)localObject4).a(177);
        ((s)localObject4).c(1, 1);
        localObject4 = "<init>";
        localObject5 = ((g)localObject2).a(1, "set", "(Ljava/lang/Object;ILjava/lang/Object;)V", null, null);
        localObject3 = a;
        if (localObject3.length != 0)
        {
          if (localObject3.length > 14)
          {
            ((s)localObject5).d(21, 2);
            localObject3 = e.c.a.a.b.l.c.c(a.length);
            localObject6 = new q();
            ((s)localObject5).a(0, localObject3.length - 1, (q)localObject6, (q[])localObject3);
            localObject7 = a;
            m = localObject7.length;
            for (i = 0;; i++)
            {
              if (k >= m)
              {
                ((s)localObject5).a((q)localObject6);
                break;
              }
              localObject8 = localObject7[k];
              ((s)localObject5).a(localObject3[i]);
              if ((a == null) && (c == null)) {
                n = 0;
              } else {
                n = 1;
              }
              if (n == 0) {
                ((s)localObject5).a(177);
              } else {
                locald.a((s)localObject5, (a)localObject8);
              }
              k++;
            }
          }
          localObject8 = e.c.a.a.b.l.c.c(localObject3.length);
          localObject3 = a;
          n = localObject3.length;
          i = 0;
          k = 0;
          while (i < n)
          {
            localObject7 = localObject3[i];
            locald.a((s)localObject5, 2, k, localObject8[k]);
            locald.a((s)localObject5, (a)localObject7);
            ((s)localObject5).a(localObject8[k]);
            ((s)localObject5).a(3, 0, null, 0, null);
            k++;
            i++;
          }
        }
        localObject3 = h;
        if (localObject3 != null) {
          locald.a((s)localObject5, (Class)localObject3);
        } else {
          ((s)localObject5).a(177);
        }
        ((s)localObject5).c(0, 0);
        localObject7 = ((g)localObject2).a(1, "get", "(Ljava/lang/Object;I)Ljava/lang/Object;", null, null);
        localObject3 = a;
        if (localObject3.length == 0)
        {
          ((s)localObject7).a(3, 0, null, 0, null);
        }
        else
        {
          if (localObject3.length > 14)
          {
            ((s)localObject7).d(21, 2);
            localObject8 = e.c.a.a.b.l.c.c(a.length);
            localObject5 = new q();
            ((s)localObject7).a(0, localObject8.length - 1, (q)localObject5, (q[])localObject8);
            localObject3 = a;
            m = localObject3.length;
            k = 0;
            for (i = 0;; i++)
            {
              if (k >= m)
              {
                ((s)localObject7).a((q)localObject5);
                ((s)localObject7).a(3, 0, null, 0, null);
                break;
              }
              localObject6 = localObject3[k];
              ((s)localObject7).a(localObject8[i]);
              ((s)localObject7).a(3, 0, null, 0, null);
              if ((a == null) && (c == null)) {
                n = 0;
              } else {
                n = 1;
              }
              if (n == 0)
              {
                ((s)localObject7).a(1);
                ((s)localObject7).a(176);
              }
              else
              {
                ((s)localObject7).d(25, 1);
                ((s)localObject7).a(192, f);
                localObject9 = y.b(e);
                if (((a)localObject6).a())
                {
                  ((s)localObject7).a(180, f, f, ((y)localObject9).a());
                }
                else
                {
                  str = y.a(c);
                  ((s)localObject7).b(182, f, c.getName(), str);
                }
                e.c.a.a.b.l.c.a((s)localObject7, (y)localObject9);
                ((s)localObject7).a(176);
              }
              k++;
            }
          }
          localObject5 = e.c.a.a.b.l.c.c(localObject3.length);
          localObject3 = a;
          n = localObject3.length;
          k = 0;
          i = 0;
        }
        for (;;)
        {
          if (k >= n)
          {
            localObject3 = h;
            if (localObject3 != null)
            {
              locald.a((s)localObject7, (Class)localObject3);
            }
            else
            {
              ((s)localObject7).a(1);
              ((s)localObject7).a(176);
            }
            ((s)localObject7).c(0, 0);
            localObject5 = "(Ljava/lang/Object;)Z";
            if (j == 0)
            {
              localObject8 = ((g)localObject2).a(1, "set", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)V", null, null);
              localObject7 = e.c.a.a.b.l.c.c(a.length);
              localObject3 = a;
              k = localObject3.length;
              n = 0;
              i = 0;
              for (;;)
              {
                if (n >= k)
                {
                  localObject3 = h;
                  if (localObject3 != null) {
                    locald.b((s)localObject8, (Class)localObject3);
                  } else {
                    ((s)localObject8).a(177);
                  }
                  ((s)localObject8).c(0, 0);
                  break;
                }
                localObject6 = localObject3[n];
                ((s)localObject8).d(25, 2);
                ((s)localObject8).a(f);
                ((s)localObject8).b(182, "java/lang/String", "equals", "(Ljava/lang/Object;)Z");
                ((s)localObject8).a(153, localObject7[i]);
                locald.a((s)localObject8, (a)localObject6);
                ((s)localObject8).a(localObject7[i]);
                ((s)localObject8).a(3, 0, null, 0, null);
                i++;
                n++;
              }
            }
            localObject7 = "java/lang/String";
            if (j == 0)
            {
              localObject6 = ((g)localObject2).a(1, "get", "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;", null, null);
              localObject9 = e.c.a.a.b.l.c.c(a.length);
              localObject8 = a;
              k = localObject8.length;
              i = 0;
              j = 0;
              localObject3 = localObject5;
              localObject5 = localObject7;
              for (;;)
              {
                if (i >= k)
                {
                  localObject3 = h;
                  if (localObject3 != null)
                  {
                    locald.b((s)localObject6, (Class)localObject3);
                  }
                  else
                  {
                    ((s)localObject6).a(1);
                    ((s)localObject6).a(176);
                  }
                  ((s)localObject6).c(0, 0);
                  break;
                }
                Object localObject10 = localObject8[i];
                ((s)localObject6).d(25, 2);
                ((s)localObject6).a(f);
                ((s)localObject6).b(182, (String)localObject5, "equals", (String)localObject3);
                ((s)localObject6).a(153, localObject9[j]);
                ((s)localObject6).d(25, 1);
                ((s)localObject6).a(192, f);
                localObject7 = y.b(e);
                if (((a)localObject10).a())
                {
                  ((s)localObject6).a(180, f, f, ((y)localObject7).a());
                }
                else
                {
                  str = y.a(c);
                  ((s)localObject6).b(182, f, c.getName(), str);
                }
                e.c.a.a.b.l.c.a((s)localObject6, (y)localObject7);
                ((s)localObject6).a(176);
                ((s)localObject6).a(localObject9[j]);
                ((s)localObject6).a(3, 0, null, 0, null);
                j++;
                i++;
              }
            }
            localObject3 = ((g)localObject2).a(1, "newInstance", "()Ljava/lang/Object;", null, null);
            ((s)localObject3).a(187, f);
            ((s)localObject3).a(89);
            ((s)localObject3).b(183, f, (String)localObject4, "()V");
            ((s)localObject3).a(176);
            ((s)localObject3).c(2, 1);
            localObject2 = ((g)localObject2).a();
            localObject4 = b.a(d, (byte[])localObject2);
            localObject2 = parami;
            break label2132;
          }
          localObject8 = localObject3[k];
          locald.a((s)localObject7, 2, i, localObject5[i]);
          ((s)localObject7).d(25, 1);
          ((s)localObject7).a(192, f);
          localObject6 = y.b(e);
          if (((a)localObject8).a())
          {
            ((s)localObject7).a(180, f, f, ((y)localObject6).a());
          }
          else
          {
            localObject9 = c;
            if (localObject9 == null) {
              break;
            }
            localObject9 = y.a((Method)localObject9);
            ((s)localObject7).b(182, f, c.getName(), (String)localObject9);
          }
          e.c.a.a.b.l.c.a((s)localObject7, (y)localObject6);
          ((s)localObject7).a(176);
          ((s)localObject7).a(localObject5[i]);
          ((s)localObject7).a(3, 0, null, 0, null);
          i++;
          k++;
        }
        paramClass = new StringBuilder("no Getter for field ");
        paramClass.append(f);
        paramClass.append(" in class ");
        paramClass.append(c);
        throw new RuntimeException(paramClass.toString());
      }
      localObject2 = (Class)((Iterator)localObject4).next();
      localObject2 = (Iterable)e.a.get(localObject2);
      if (localObject2 != null) {
        localObject2 = ((Iterable)localObject2).iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject2).hasNext()) {
          break label255;
        }
        localObject3 = (Class)((Iterator)localObject2).next();
        if (localObject3 == null) {
          break;
        }
        for (localObject5 : ((Class)localObject3).getMethods()) {
          if ((((Method)localObject5).getModifiers() & 0x8) != 0)
          {
            localObject8 = ((Method)localObject5).getParameterTypes();
            if ((localObject8.length == 1) && (localObject8[0].equals(Object.class)))
            {
              localObject8 = ((Method)localObject5).getReturnType();
              if (!localObject8.equals(Void.TYPE)) {
                g.put(localObject8, localObject5);
              }
            }
          }
        }
      }
    }
    localObject4 = parami;
    try
    {
      parami = (c)((Class)localObject4).newInstance();
      parami.a(arrayOfa);
      c.putIfAbsent(paramClass, parami);
      localObject2 = ((LinkedList)localObject2).iterator();
      for (;;)
      {
        if (!((Iterator)localObject2).hasNext()) {
          return parami;
        }
        paramClass = (Class)((Iterator)localObject2).next();
        a(parami, (HashMap)e.b.get(paramClass));
      }
      localObject4 = ((Class)localObject1).getDeclaredFields();
    }
    catch (Exception paramClass)
    {
      parami = new StringBuilder("Error constructing accessor class: ");
      parami.append((String)localObject1);
      throw new RuntimeException(parami.toString(), paramClass);
    }
    k = localObject4.length;
    for (j = 0;; j++)
    {
      if (j >= k)
      {
        localObject1 = ((Class)localObject1).getSuperclass();
        break;
      }
      localObject5 = localObject4[j];
      localObject3 = ((Field)localObject5).getName();
      if (!((HashMap)localObject2).containsKey(localObject3))
      {
        localObject5 = new a((Class)localObject1, (Field)localObject5, parami);
        if ((a == null) && (c == null) && (b == null)) {
          i = 0;
        } else {
          i = 1;
        }
        if (i != 0) {
          ((HashMap)localObject2).put(localObject3, localObject5);
        }
      }
    }
  }
  
  public static void a(c<?> paramc, HashMap<String, String> paramHashMap)
  {
    if (paramHashMap == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    paramHashMap = paramHashMap.entrySet().iterator();
    for (;;)
    {
      if (!paramHashMap.hasNext())
      {
        a.putAll(localHashMap);
        return;
      }
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      a locala = (a)a.get(localEntry.getValue());
      if (locala != null) {
        localHashMap.put((String)localEntry.getValue(), locala);
      }
    }
  }
  
  public abstract Object a(T paramT, int paramInt);
  
  public void a(a[] paramArrayOfa)
  {
    b = paramArrayOfa;
    a = new HashMap();
    int i = paramArrayOfa.length;
    int j = 0;
    for (int k = 0;; k++)
    {
      if (j >= i) {
        return;
      }
      a locala = paramArrayOfa[j];
      d = k;
      a.put(f, locala);
      j++;
    }
  }
  
  public a[] a()
  {
    return b;
  }
}

/* Location:
 * Qualified Name:     base.i.a.a.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */