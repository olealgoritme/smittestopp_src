package l.a.b.a.c;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import l.a.b.a.b.e;
import l.a.b.a.b.f;
import l.a.b.a.b.g;
import l.a.b.a.b.h;

public class r
  implements i
{
  public k0 a;
  public final CharsetDecoder b = StandardCharsets.UTF_8.newDecoder();
  public final j0[] c = new j0['Ā'];
  public final Map<Object, s> d = new HashMap();
  public final Map<Object, y<?>> e = new HashMap();
  
  public int a()
  {
    return a.c();
  }
  
  public Boolean a(Boolean paramBoolean)
  {
    int i = a.get();
    if (i != 86)
    {
      switch (i)
      {
      default: 
        throw new q(e.a.a.a.a.a("Expected boolean type but found encoding: ", i));
      case 66: 
        return Boolean.FALSE;
      case 65: 
        paramBoolean = Boolean.TRUE;
      }
      return paramBoolean;
    }
    if (e() == 0) {
      paramBoolean = Boolean.FALSE;
    } else {
      paramBoolean = Boolean.TRUE;
    }
    return paramBoolean;
  }
  
  public <V> V a(b<V> paramb, int paramInt)
  {
    Object localObject = paramb.a(this, a.l().b(paramInt));
    paramb = a;
    paramb.a(paramb.position() + paramInt);
    return (V)localObject;
  }
  
  public String a(String paramString)
  {
    int i = a.get();
    if (i != -95)
    {
      if (i != -79)
      {
        if (i == 64) {
          return paramString;
        }
        throw new l.a.b.a.a(e.a.a.a.a.a("Expected String type but found encoding: ", i));
      }
      return (String)c['±'].i();
    }
    return (String)c['¡'].i();
  }
  
  public Date a(Date paramDate)
  {
    int i = a.get();
    if (i != -125)
    {
      if (i == 64) {
        return paramDate;
      }
      throw new l.a.b.a.a(e.a.a.a.a.a("Expected Timestamp type but found encoding: ", i));
    }
    return new Date(g());
  }
  
  public l.a.b.a.b.a a(l.a.b.a.b.a parama)
  {
    int i = a.get();
    if (i != -96)
    {
      if (i != -80)
      {
        if (i == 64) {
          return parama;
        }
        throw new l.a.b.a.a(e.a.a.a.a.a("Expected Binary type but found encoding: ", i));
      }
      return (l.a.b.a.b.a)c['°'].i();
    }
    return (l.a.b.a.b.a)c[' '].i();
  }
  
  public f a(f paramf)
  {
    int i = a.get();
    if (i != -93)
    {
      if (i != -77)
      {
        if (i == 64) {
          return paramf;
        }
        throw new l.a.b.a.a(e.a.a.a.a.a("Expected Symbol type but found encoding: ", i));
      }
      return (f)c['³'].i();
    }
    return (f)c['£'].i();
  }
  
  public g a(g paramg)
  {
    int i = a.get();
    if (i != 64)
    {
      if (i == 80) {
        return g.a(e());
      }
      throw new q(e.a.a.a.a.a("Expected unsigned byte type but found encoding: ", i));
    }
    return paramg;
  }
  
  public h a(h paramh)
  {
    int i = a.get();
    if (i != 64)
    {
      if (i != 67)
      {
        if (i != 82)
        {
          if (i == 112) {
            return h.a(f());
          }
          throw new q(e.a.a.a.a.a("Expected UnsignedInteger type but found encoding: ", i));
        }
        return h.a(e() & 0xFF);
      }
      paramh = h.z;
    }
    return paramh;
  }
  
  public void a(Object paramObject, s params)
  {
    e.remove(paramObject);
    d.put(paramObject, params);
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    a = new k0.a(paramByteBuffer);
  }
  
  public <V> void a(i0<V> parami0)
  {
    Iterator localIterator = parami0.k().iterator();
    while (localIterator.hasNext())
    {
      parami0 = (j0)localIterator.next();
      c[(parami0.f() & 0xFF)] = parami0;
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    int i = a.get();
    boolean bool = false;
    if (i != 86)
    {
      switch (i)
      {
      default: 
        throw new q(e.a.a.a.a.a("Expected boolean type but found encoding: ", i));
      case 66: 
        return false;
      case 65: 
        return true;
      }
      return paramBoolean;
    }
    paramBoolean = bool;
    if (e() != 0) {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public q0 b()
  {
    return b(false);
  }
  
  public q0 b(boolean paramBoolean)
  {
    int i = e() & 0xFF;
    if (i == 0)
    {
      final Object localObject1 = a;
      i = ((k0)localObject1).get(((k0)localObject1).position());
      localObject1 = null;
      if ((83 != i) && (-128 != i))
      {
        if ((-93 != i) && (-77 != i)) {
          localObject1 = d();
        } else {
          localObject1 = a(null);
        }
      }
      else
      {
        i = a.get();
        if (i != -128)
        {
          if (i != 64) {
            if (i != 68)
            {
              if (i == 83) {
                localObject1 = l.a.b.a.b.i.a(e() & 0xFF);
              } else {
                throw new q(e.a.a.a.a.a("Expected UnsignedLong type but found encoding: ", i));
              }
            }
            else {
              localObject1 = l.a.b.a.b.i.A;
            }
          }
        }
        else {
          localObject1 = l.a.b.a.b.i.a(g());
        }
      }
      if (!paramBoolean)
      {
        localObject2 = (q0)e.get(localObject1);
        if (localObject2 != null) {
          return (q0)localObject2;
        }
      }
      q0 localq0 = b(false);
      s locals = (s)d.get(localObject1);
      Object localObject2 = locals;
      if (locals == null)
      {
        localObject2 = new a(localObject1);
        a(localObject1, (s)localObject2);
      }
      return new w((s)localObject2, localq0);
    }
    return c[i];
  }
  
  public Map c()
  {
    int i = a.get();
    if (i != -63)
    {
      if (i != -47)
      {
        if (i == 64) {
          return null;
        }
        throw new l.a.b.a.a(e.a.a.a.a.a("Expected Map type but found encoding: ", i));
      }
      return (Map)c['Ñ'].i();
    }
    return (Map)c['Á'].i();
  }
  
  public Object d()
  {
    Object localObject = a;
    int i = ((k0)localObject).get(((k0)localObject).position());
    if ((i != -32) && (i != -16)) {
      i = 0;
    } else {
      i = 1;
    }
    localObject = b();
    if (localObject != null)
    {
      if (i != 0) {
        return ((e.b)localObject).h();
      }
      return ((q0)localObject).i();
    }
    throw new q("Unknown constructor");
  }
  
  public byte e()
  {
    return a.get();
  }
  
  public int f()
  {
    return a.h();
  }
  
  public long g()
  {
    return a.f();
  }
  
  public class a
    implements s
  {
    public a(Object paramObject) {}
    
    public Class<?> b()
    {
      return r.c.class;
    }
    
    public Object b(Object paramObject)
    {
      return new r.c(localObject1, paramObject);
    }
  }
  
  public static abstract interface b<V>
  {
    public abstract V a(r paramr, k0 paramk0);
  }
  
  public static class c
    implements e
  {
    public final Object a;
    public final Object b;
    
    public c(Object paramObject1, Object paramObject2)
    {
      a = paramObject1;
      b = paramObject2;
    }
    
    public Object a()
    {
      return a;
    }
    
    public Object b()
    {
      return b;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool1 = paramObject instanceof e;
      boolean bool2 = true;
      if ((bool1) && (a == null))
      {
        if (((e)paramObject).a() == null) {}
      }
      else
      {
        do
        {
          return false;
          Object localObject = a;
          paramObject = (e)paramObject;
          if ((!localObject.equals(((e)paramObject).a())) || (b != null)) {
            break;
          }
        } while (((e)paramObject).b() != null);
        return bool2;
        bool2 = b.equals(((e)paramObject).b());
      }
      return bool2;
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.r
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */