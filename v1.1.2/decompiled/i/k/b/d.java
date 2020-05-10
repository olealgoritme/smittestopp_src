package i.k.b;

import i.k.a.a;
import i.k.a.f;
import i.k.a.h;
import i.k.a.i;
import i.k.a.j;
import i.k.a.k;
import i.k.a.l;
import i.k.a.m;
import i.k.a.n;
import i.k.a.o;
import i.k.a.p;
import i.k.a.q;
import i.k.a.r;
import i.k.a.s;
import i.k.a.t;
import i.k.a.u;
import i.k.a.v;
import i.k.a.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class d
  implements i.m.b<Object>, c
{
  public static final Map<Class<? extends Object<?>>, Integer> b;
  public static final HashMap<String, String> c;
  public static final HashMap<String, String> d;
  public static final HashMap<String, String> e;
  public final Class<?> a;
  
  static
  {
    Object localObject1 = i.i.b.a(new Class[] { a.class, l.class, p.class, q.class, r.class, s.class, t.class, u.class, v.class, w.class, i.k.a.b.class, i.k.a.c.class, i.k.a.d.class, i.k.a.e.class, f.class, i.k.a.g.class, h.class, i.class, j.class, k.class, m.class, n.class, o.class });
    Object localObject2 = new ArrayList(e.c.a.a.b.l.c.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = ((Iterator)localObject1).next();
      if (i >= 0)
      {
        ((ArrayList)localObject2).add(new i.c((Class)localObject3, Integer.valueOf(i)));
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
        localObject1 = (i.c)((ArrayList)localObject2).get(0);
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
      localObject1 = i.i.e.x;
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
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("kotlin.jvm.internal.");
      g.a(localObject3, "kotlinName");
      ((StringBuilder)localObject4).append(i.o.g.a((String)localObject3, '.', null, 2));
      ((StringBuilder)localObject4).append("CompanionObject");
      localObject4 = ((StringBuilder)localObject4).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject3);
      localStringBuilder.append(".Companion");
      ((HashMap)localObject1).put(localObject4, localStringBuilder.toString());
    }
    localObject2 = b.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (Map.Entry)((Iterator)localObject2).next();
      localObject3 = (Class)((Map.Entry)localObject4).getKey();
      i = ((Number)((Map.Entry)localObject4).getValue()).intValue();
      localObject4 = ((Class)localObject3).getName();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("kotlin.Function");
      ((StringBuilder)localObject3).append(i);
      ((HashMap)localObject1).put(localObject4, ((StringBuilder)localObject3).toString());
    }
    e = (HashMap)localObject1;
    localObject2 = new LinkedHashMap(e.c.a.a.b.l.c.b(((HashMap)localObject1).size()));
    Object localObject3 = ((HashMap)localObject1).entrySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)localObject3).next();
      ((HashMap)localObject2).put(((Map.Entry)localObject1).getKey(), i.o.g.a((String)((Map.Entry)localObject1).getValue(), '.', null, 2));
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
    if (((paramObject instanceof d)) && (g.a(e.c.a.a.b.l.c.a(this), e.c.a.a.b.l.c.a((i.m.b)paramObject)))) {
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
 * Qualified Name:     i.k.b.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */