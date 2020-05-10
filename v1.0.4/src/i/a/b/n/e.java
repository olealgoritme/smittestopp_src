package i.a.b.n;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

public class e
{
  public final ConcurrentHashMap<Type, f<?>> a;
  public f<i.a.b.c> b;
  public f<i.a.b.c> c;
  
  public e()
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap(100);
    a = localConcurrentHashMap;
    localConcurrentHashMap.put(Date.class, b.b);
    a.put(int[].class, a.b);
    a.put(Integer[].class, a.c);
    a.put(short[].class, a.b);
    a.put(Short[].class, a.c);
    a.put(long[].class, a.h);
    a.put(Long[].class, a.i);
    a.put(byte[].class, a.d);
    a.put(Byte[].class, a.e);
    a.put(char[].class, a.f);
    a.put(Character[].class, a.g);
    a.put(float[].class, a.j);
    a.put(Float[].class, a.k);
    a.put(double[].class, a.l);
    a.put(Double[].class, a.m);
    a.put(boolean[].class, a.n);
    a.put(Boolean[].class, a.o);
    b = new c(this);
    c = new d(this);
    a.put(i.a.b.c.class, b);
    a.put(i.a.b.b.class, b);
    a.put(i.a.b.a.class, b);
    a.put(i.a.b.d.class, b);
  }
}

/* Location:
 * Qualified Name:     base.i.a.b.n.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */