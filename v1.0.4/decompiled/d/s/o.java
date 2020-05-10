package d.s;

import android.os.Bundle;
import android.os.Parcelable;
import e.a.a.a.a;
import java.io.Serializable;

public abstract class o<T>
{
  public static final o<Integer> b = new o.c(false);
  public static final o<Integer> c = new o.d(false);
  public static final o<int[]> d = new o.e(true);
  public static final o<Long> e = new o.f(false);
  public static final o<long[]> f = new o.g(true);
  public static final o<Float> g = new o.h(false);
  public static final o<float[]> h = new o.i(true);
  public static final o<Boolean> i = new o.j(false);
  public static final o<boolean[]> j = new o.k(true);
  public static final o<String> k = new o.a(true);
  public static final o<String[]> l = new o.b(true);
  public final boolean a;
  
  public o(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  public static o a(Object paramObject)
  {
    if ((paramObject instanceof Integer)) {
      return b;
    }
    if ((paramObject instanceof int[])) {
      return d;
    }
    if ((paramObject instanceof Long)) {
      return e;
    }
    if ((paramObject instanceof long[])) {
      return f;
    }
    if ((paramObject instanceof Float)) {
      return g;
    }
    if ((paramObject instanceof float[])) {
      return h;
    }
    if ((paramObject instanceof Boolean)) {
      return i;
    }
    if ((paramObject instanceof boolean[])) {
      return j;
    }
    if ((!(paramObject instanceof String)) && (paramObject != null))
    {
      if ((paramObject instanceof String[])) {
        return l;
      }
      if ((paramObject.getClass().isArray()) && (Parcelable.class.isAssignableFrom(paramObject.getClass().getComponentType()))) {
        return new o.m(paramObject.getClass().getComponentType());
      }
      if ((paramObject.getClass().isArray()) && (Serializable.class.isAssignableFrom(paramObject.getClass().getComponentType()))) {
        return new o.o(paramObject.getClass().getComponentType());
      }
      if ((paramObject instanceof Parcelable)) {
        return new o.n(paramObject.getClass());
      }
      if ((paramObject instanceof Enum)) {
        return new o.l(paramObject.getClass());
      }
      if ((paramObject instanceof Serializable)) {
        return new o.p(paramObject.getClass());
      }
      StringBuilder localStringBuilder = a.a("Object of type ");
      localStringBuilder.append(paramObject.getClass().getName());
      localStringBuilder.append(" is not supported for navigation arguments.");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return k;
  }
  
  public abstract T a(Bundle paramBundle, String paramString);
  
  public abstract T a(String paramString);
  
  public abstract String a();
  
  public abstract void a(Bundle paramBundle, String paramString, T paramT);
  
  public String toString()
  {
    return a();
  }
}

/* Location:
 * Qualified Name:     base.d.s.o
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */