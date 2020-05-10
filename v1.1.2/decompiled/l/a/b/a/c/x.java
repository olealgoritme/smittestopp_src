package l.a.b.a.c;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class x
{
  public y0 a;
  public final r b;
  public final Map<Class, a> c = new HashMap();
  public Map<Object, a> d = new HashMap();
  public Map<Class, a> e = new HashMap();
  public final h f;
  public final j g;
  public final t0 h;
  public final l0 i;
  public final c0 j;
  public final u0 k;
  public final f0 l;
  public final k m;
  public final a0 n;
  public final t o;
  public final p0 p;
  public final g q;
  public final o0 r;
  public final n0 s;
  public final e0 t;
  public final g0 u;
  public final e v;
  
  public x(r paramr)
  {
    b = paramr;
    new h0(this, paramr);
    f = new h(this, paramr);
    g = new j(this, paramr);
    h = new t0(this, paramr);
    i = new l0(this, paramr);
    new w0(this, paramr);
    j = new c0(this, paramr);
    k = new u0(this, paramr);
    l = new f0(this, paramr);
    new v0(this, paramr);
    new f(this, paramr);
    m = new k(this, paramr);
    n = new a0(this, paramr);
    o = new t(this, paramr);
    p = new p0(this, paramr);
    new s0(this, paramr);
    new o(this, paramr);
    new p(this, paramr);
    new n(this, paramr);
    q = new g(this, paramr);
    r = new o0(this, paramr);
    s = new n0(this, paramr);
    t = new e0(this, paramr);
    u = new g0(this, paramr);
    v = new e(this, paramr, f, g, i, j, l, n, o, m);
  }
  
  public a a(Class paramClass)
  {
    return a(paramClass, null);
  }
  
  public final a<?> a(Class<?> paramClass, Object paramObject)
  {
    a locala = (a)c.get(paramClass);
    Object localObject = locala;
    if (locala == null)
    {
      if (paramClass.isArray())
      {
        paramObject = v;
      }
      else if (List.class.isAssignableFrom(paramClass))
      {
        paramObject = t;
      }
      else if (Map.class.isAssignableFrom(paramClass))
      {
        paramObject = u;
      }
      else
      {
        if (l.a.b.a.b.e.class.isAssignableFrom(paramClass))
        {
          localObject = (a)e.get(paramClass);
          paramClass = (Class<?>)localObject;
          if (localObject == null)
          {
            paramClass = (Class<?>)localObject;
            if (paramObject != null)
            {
              localObject = ((l.a.b.a.b.e)paramObject).a();
              paramObject = (a)d.get(localObject);
              paramClass = (Class<?>)paramObject;
              if (paramObject == null)
              {
                paramClass = new v(this, localObject);
                d.put(localObject, paramClass);
              }
            }
          }
          localObject = paramClass;
          break label188;
        }
        paramObject = null;
      }
      c.put(paramClass, paramObject);
      localObject = paramObject;
    }
    label188:
    return (a<?>)localObject;
  }
  
  public a a(Object paramObject)
  {
    Class localClass;
    if (paramObject == null) {
      localClass = Void.class;
    } else {
      localClass = paramObject.getClass();
    }
    return a(localClass, paramObject);
  }
  
  public void a()
  {
    a.a((byte)64);
  }
  
  public void a(Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      a();
    } else if (Boolean.TRUE.equals(paramBoolean)) {
      a.a((byte)65);
    } else {
      a.a((byte)66);
    }
  }
  
  public void a(String paramString)
  {
    if (paramString == null)
    {
      a();
    }
    else
    {
      j0 localj0 = s.a(paramString);
      localj0.c();
      localj0.b(paramString);
    }
  }
  
  public void a(Date paramDate)
  {
    if (paramDate == null)
    {
      a();
    }
    else
    {
      p0 localp0 = p;
      long l1 = paramDate.getTime();
      if (localp0 == null) {
        break label47;
      }
      a.a((byte)-125);
      a.a(l1);
    }
    return;
    label47:
    throw null;
  }
  
  public void a(l.a.b.a.b.a parama)
  {
    if (parama == null)
    {
      a();
    }
    else
    {
      if (q == null) {
        break label173;
      }
      int i1 = c;
      byte[] arrayOfByte;
      int i2;
      if (i1 <= 255)
      {
        a.b(i1 + 2);
        a.a((byte)-96);
        byte b1 = (byte)c;
        a.a(b1);
        arrayOfByte = a;
        i2 = b;
        i1 = c;
        a.a(arrayOfByte, i2, i1);
      }
      else
      {
        a.b(i1 + 5);
        a.a((byte)-80);
        i1 = c;
        a.c(i1);
        arrayOfByte = a;
        i1 = b;
        i2 = c;
        a.a(arrayOfByte, i1, i2);
      }
    }
    return;
    label173:
    throw null;
  }
  
  public void a(l.a.b.a.b.f paramf)
  {
    if (paramf == null)
    {
      a();
    }
    else
    {
      if (r == null) {
        break label131;
      }
      if (paramf.length() <= 255)
      {
        a.b(paramf.length() + 2);
        a.a((byte)-93);
        byte b1 = (byte)paramf.length();
        a.a(b1);
        paramf.a(a);
      }
      else
      {
        a.b(paramf.length() + 5);
        a.a((byte)-77);
        int i1 = paramf.length();
        a.c(i1);
        paramf.a(a);
      }
    }
    return;
    label131:
    throw null;
  }
  
  public void a(l.a.b.a.b.h paramh)
  {
    if (paramh == null)
    {
      a();
    }
    else
    {
      if (k == null) {
        break label101;
      }
      int i1 = x;
      if (i1 == 0)
      {
        a.a((byte)67);
      }
      else if ((i1 > 0) && (i1 <= 255))
      {
        a.a((byte)82);
        byte b1 = (byte)i1;
        a.a(b1);
      }
      else
      {
        a.a((byte)112);
        a.c(i1);
      }
    }
    return;
    label101:
    throw null;
  }
  
  public <V> void a(a<V> parama)
  {
    Class localClass = parama.b();
    c.put(localClass, parama);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      a.a((byte)65);
    } else {
      a.a((byte)66);
    }
  }
  
  public void b(Object paramObject)
  {
    if (paramObject != null)
    {
      Object localObject = (a)c.get(paramObject.getClass());
      if (localObject != null)
      {
        ((a)localObject).c(paramObject);
      }
      else if (paramObject.getClass().isArray())
      {
        localObject = paramObject.getClass().getComponentType();
        if (((Class)localObject).isPrimitive())
        {
          if (localObject == Boolean.TYPE)
          {
            paramObject = (boolean[])paramObject;
            localObject = v.a((boolean[])paramObject);
            ((j0)localObject).c();
            ((e.b)localObject).a((boolean[])paramObject);
          }
          else if (localObject == Byte.TYPE)
          {
            localObject = (byte[])paramObject;
            paramObject = v;
            if (paramObject != null)
            {
              if (localObject.length < 254) {
                paramObject = j;
              } else {
                paramObject = k;
              }
              ((j0)paramObject).c();
              ((e.b)paramObject).a((byte[])localObject);
            }
            else
            {
              throw null;
            }
          }
          else if (localObject == Short.TYPE)
          {
            localObject = (short[])paramObject;
            paramObject = v;
            if (paramObject != null)
            {
              if (localObject.length < 127) {
                paramObject = j;
              } else {
                paramObject = k;
              }
              ((j0)paramObject).c();
              ((e.b)paramObject).a((short[])localObject);
            }
            else
            {
              throw null;
            }
          }
          else if (localObject == Integer.TYPE)
          {
            paramObject = (int[])paramObject;
            localObject = v.b((int[])paramObject);
            ((j0)localObject).c();
            ((e.b)localObject).a((int[])paramObject);
          }
          else if (localObject == Long.TYPE)
          {
            localObject = (long[])paramObject;
            paramObject = v.b((long[])localObject);
            ((j0)paramObject).c();
            ((e.b)paramObject).a((long[])localObject);
          }
          else if (localObject == Float.TYPE)
          {
            localObject = (float[])paramObject;
            paramObject = v;
            if (paramObject != null)
            {
              if (localObject.length < 63) {
                paramObject = j;
              } else {
                paramObject = k;
              }
              ((j0)paramObject).c();
              ((e.b)paramObject).a((float[])localObject);
            }
            else
            {
              throw null;
            }
          }
          else if (localObject == Double.TYPE)
          {
            localObject = (double[])paramObject;
            paramObject = v;
            if (paramObject != null)
            {
              if (localObject.length < 31) {
                paramObject = j;
              } else {
                paramObject = k;
              }
              ((j0)paramObject).c();
              ((e.b)paramObject).a((double[])localObject);
            }
            else
            {
              throw null;
            }
          }
          else if (localObject == Character.TYPE)
          {
            localObject = (char[])paramObject;
            paramObject = v;
            if (paramObject != null)
            {
              if (localObject.length < 63) {
                paramObject = j;
              } else {
                paramObject = k;
              }
              ((j0)paramObject).c();
              ((e.b)paramObject).a((char[])localObject);
            }
            else
            {
              throw null;
            }
          }
          else
          {
            paramObject = e.a.a.a.a.a("Cannot write arrays of type ");
            ((StringBuilder)paramObject).append(((Class)localObject).getName());
            throw new IllegalArgumentException(((StringBuilder)paramObject).toString());
          }
        }
        else
        {
          localObject = (Object[])paramObject;
          paramObject = v.a((Object[])localObject);
          ((j0)paramObject).c();
          ((r0)paramObject).b(localObject);
        }
      }
      else if ((paramObject instanceof List))
      {
        localObject = (List)paramObject;
        paramObject = t.a(localObject);
        ((r0)paramObject).c();
        ((r0)paramObject).b(localObject);
      }
      else if ((paramObject instanceof Map))
      {
        paramObject = (Map)paramObject;
        localObject = u.a(paramObject);
        ((r0)localObject).c();
        ((r0)localObject).b(paramObject);
      }
      else if ((paramObject instanceof l.a.b.a.b.e))
      {
        paramObject = (l.a.b.a.b.e)paramObject;
        a.a((byte)0);
        b(((l.a.b.a.b.e)paramObject).a());
        b(((l.a.b.a.b.e)paramObject).b());
      }
      else
      {
        throw new IllegalArgumentException(e.a.a.a.a.a(paramObject, e.a.a.a.a.a("Do not know how to write Objects of class ")));
      }
    }
    else
    {
      a.a((byte)64);
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.x
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */