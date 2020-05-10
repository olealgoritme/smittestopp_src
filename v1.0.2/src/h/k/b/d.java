package h.k.b;

import h.k.a.a;
import h.k.a.f;
import h.k.a.h;
import h.k.a.i;
import h.k.a.j;
import h.k.a.k;
import h.k.a.l;
import h.k.a.m;
import h.k.a.n;
import h.k.a.o;
import h.k.a.p;
import h.k.a.q;
import h.k.a.r;
import h.k.a.s;
import h.k.a.t;
import h.k.a.u;
import h.k.a.v;
import h.k.a.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class d
  implements h.m.b<Object>, c
{
  public static final Map<Class<? extends Object<?>>, Integer> b;
  public static final HashMap<String, String> c;
  public static final HashMap<String, String> d;
  public static final HashMap<String, String> e;
  public final Class<?> a;
  
  static
  {
    Object localObject1 = h.i.b.a(new Class[] { a.class, l.class, p.class, q.class, r.class, s.class, t.class, u.class, v.class, w.class, h.k.a.b.class, h.k.a.c.class, h.k.a.d.class, h.k.a.e.class, f.class, h.k.a.g.class, h.class, i.class, j.class, k.class, m.class, n.class, o.class });
    Object localObject2 = new ArrayList(e.c.a.a.b.l.c.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = ((Iterator)localObject1).next();
      if (i >= 0)
      {
        ((ArrayList)localObject2).add(new h.c((Class)localObject3, Integer.valueOf(i)));
        i++;
      }
      else
      {
        throw new ArithmeticException("Index overflow has happened.");
      }
    }
    i = ((ArrayList)localObject2).size();
    if (i != 0)
    {
      if (i != 1)
      {
        localObject1 = new LinkedHashMap(e.c.a.a.b.l.c.b(((ArrayList)localObject2).size()));
        e.c.a.a.b.l.c.a((Iterable)localObject2, (Map)localObject1);
      }
      else
      {
        localObject1 = (h.c)((ArrayList)localObject2).get(0);
        if (localObject1 != null)
        {
          localObject1 = Collections.singletonMap(x, y);
          g.a(localObject1, "java.util.Collections.si…(pair.first, pair.second)");
        }
        else
        {
          g.a("pair");
          throw null;
        }
      }
    }
    else {
      localObject1 = h.i.e.x;
    }
    b = (Map)localObject1;
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("boolean", "kotlin.Boolean");
    ((HashMap)localObject1).put("char", "kotlin.Char");
    ((HashMap)localObject1).put("byte", "kotlin.Byte");
    ((HashMap)localObject1).put("short", "kotlin.Short");
    ((HashMap)localObject1).put("int", "kotlin.Int");
    ((HashMap)localObject1).put("float", "kotlin.Float");
    ((HashMap)localObject1).put("long", "kotlin.Long");
    ((HashMap)localObject1).put("double", "kotlin.Double");
    c = (HashMap)localObject1;
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("java.lang.Boolean", "kotlin.Boolean");
    ((HashMap)localObject1).put("java.lang.Character", "kotlin.Char");
    ((HashMap)localObject1).put("java.lang.Byte", "kotlin.Byte");
    ((HashMap)localObject1).put("java.lang.Short", "kotlin.Short");
    ((HashMap)localObject1).put("java.lang.Integer", "kotlin.Int");
    ((HashMap)localObject1).put("java.lang.Float", "kotlin.Float");
    ((HashMap)localObject1).put("java.lang.Long", "kotlin.Long");
    ((HashMap)localObject1).put("java.lang.Double", "kotlin.Double");
    d = (HashMap)localObject1;
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("java.lang.Object", "kotlin.Any");
    ((HashMap)localObject1).put("java.lang.String", "kotlin.String");
    ((HashMap)localObject1).put("java.lang.CharSequence", "kotlin.CharSequence");
    ((HashMap)localObject1).put("java.lang.Throwable", "kotlin.Throwable");
    ((HashMap)localObject1).put("java.lang.Cloneable", "kotlin.Cloneable");
    ((HashMap)localObject1).put("java.lang.Number", "kotlin.Number");
    ((HashMap)localObject1).put("java.lang.Comparable", "kotlin.Comparable");
    ((HashMap)localObject1).put("java.lang.Enum", "kotlin.Enum");
    ((HashMap)localObject1).put("java.lang.annotation.Annotation", "kotlin.Annotation");
    ((HashMap)localObject1).put("java.lang.Iterable", "kotlin.collections.Iterable");
    ((HashMap)localObject1).put("java.util.Iterator", "kotlin.collections.Iterator");
    ((HashMap)localObject1).put("java.util.Collection", "kotlin.collections.Collection");
    ((HashMap)localObject1).put("java.util.List", "kotlin.collections.List");
    ((HashMap)localObject1).put("java.util.Set", "kotlin.collections.Set");
    ((HashMap)localObject1).put("java.util.ListIterator", "kotlin.collections.ListIterator");
    ((HashMap)localObject1).put("java.util.Map", "kotlin.collections.Map");
    ((HashMap)localObject1).put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
    ((HashMap)localObject1).put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
    ((HashMap)localObject1).put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
    ((HashMap)localObject1).putAll(c);
    ((HashMap)localObject1).putAll(d);
    localObject2 = c.values();
    g.a(localObject2, "primitiveFqNames.values");
    Object localObject3 = ((Iterable)localObject2).iterator();
    Object localObject4;
    while (((Iterator)localObject3).hasNext())
    {
      localObject2 = (String)((Iterator)localObject3).next();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("kotlin.jvm.internal.");
      g.a(localObject2, "kotlinName");
      ((StringBuilder)localObject4).append(h.o.g.a((String)localObject2, '.', null, 2));
      ((StringBuilder)localObject4).append("CompanionObject");
      localObject4 = ((StringBuilder)localObject4).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(".Companion");
      ((HashMap)localObject1).put(localObject4, localStringBuilder.toString());
    }
    localObject2 = b.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      localObject4 = (Class)((Map.Entry)localObject3).getKey();
      i = ((Number)((Map.Entry)localObject3).getValue()).intValue();
      localObject3 = ((Class)localObject4).getName();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("kotlin.Function");
      ((StringBuilder)localObject4).append(i);
      ((HashMap)localObject1).put(localObject3, ((StringBuilder)localObject4).toString());
    }
    e = (HashMap)localObject1;
    localObject2 = new LinkedHashMap(e.c.a.a.b.l.c.b(((HashMap)localObject1).size()));
    localObject3 = ((HashMap)localObject1).entrySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)localObject3).next();
      ((HashMap)localObject2).put(((Map.Entry)localObject1).getKey(), h.o.g.a((String)((Map.Entry)localObject1).getValue(), '.', null, 2));
    }
  }
  
  public d(Class<?> paramClass) {}
  
  public Class<?> a()
  {
    return a;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (((paramObject instanceof d)) && (g.a(e.c.a.a.b.l.c.a(this), e.c.a.a.b.l.c.a((h.m.b)paramObject)))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return e.c.a.a.b.l.c.a(this).hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a.toString());
    localStringBuilder.append(" (Kotlin reflection is not available)");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.h.k.b.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */