package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import e.c.c.j;
import e.c.c.u;
import e.c.c.x.a;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public final class TypeAdapters
{
  public static final TypeAdapter<String> A;
  public static final TypeAdapter<BigDecimal> B;
  public static final TypeAdapter<BigInteger> C;
  public static final u D;
  public static final TypeAdapter<StringBuilder> E;
  public static final u F;
  public static final TypeAdapter<StringBuffer> G;
  public static final u H;
  public static final TypeAdapter<URL> I;
  public static final u J;
  public static final TypeAdapter<URI> K;
  public static final u L;
  public static final TypeAdapter<InetAddress> M;
  public static final u N;
  public static final TypeAdapter<UUID> O;
  public static final u P;
  public static final TypeAdapter<Currency> Q;
  public static final u R;
  public static final u S;
  public static final TypeAdapter<Calendar> T;
  public static final u U;
  public static final TypeAdapter<Locale> V;
  public static final u W;
  public static final TypeAdapter<j> X;
  public static final u Y;
  public static final u Z = new TypeAdapters.30();
  public static final TypeAdapter<Class> a;
  public static final u b;
  public static final TypeAdapter<BitSet> c;
  public static final u d;
  public static final TypeAdapter<Boolean> e;
  public static final TypeAdapter<Boolean> f;
  public static final u g;
  public static final TypeAdapter<Number> h;
  public static final u i;
  public static final TypeAdapter<Number> j;
  public static final u k;
  public static final TypeAdapter<Number> l;
  public static final u m;
  public static final TypeAdapter<AtomicInteger> n;
  public static final u o;
  public static final TypeAdapter<AtomicBoolean> p;
  public static final u q;
  public static final TypeAdapter<AtomicIntegerArray> r;
  public static final u s;
  public static final TypeAdapter<Number> t;
  public static final TypeAdapter<Number> u;
  public static final TypeAdapter<Number> v;
  public static final TypeAdapter<Number> w;
  public static final u x;
  public static final TypeAdapter<Character> y;
  public static final u z;
  
  static
  {
    Object localObject = new TypeAdapters.1().nullSafe();
    a = (TypeAdapter)localObject;
    b = new TypeAdapters.32(Class.class, (TypeAdapter)localObject);
    localObject = new TypeAdapters.2().nullSafe();
    c = (TypeAdapter)localObject;
    d = new TypeAdapters.32(BitSet.class, (TypeAdapter)localObject);
    e = new TypeAdapters.3();
    f = new TypeAdapters.4();
    g = new TypeAdapters.33(Boolean.TYPE, Boolean.class, e);
    h = new TypeAdapters.5();
    i = new TypeAdapters.33(Byte.TYPE, Byte.class, h);
    j = new TypeAdapters.6();
    k = new TypeAdapters.33(Short.TYPE, Short.class, j);
    l = new TypeAdapters.7();
    m = new TypeAdapters.33(Integer.TYPE, Integer.class, l);
    localObject = new TypeAdapters.8().nullSafe();
    n = (TypeAdapter)localObject;
    o = new TypeAdapters.32(AtomicInteger.class, (TypeAdapter)localObject);
    localObject = new TypeAdapters.9().nullSafe();
    p = (TypeAdapter)localObject;
    q = new TypeAdapters.32(AtomicBoolean.class, (TypeAdapter)localObject);
    localObject = new TypeAdapters.10().nullSafe();
    r = (TypeAdapter)localObject;
    s = new TypeAdapters.32(AtomicIntegerArray.class, (TypeAdapter)localObject);
    t = new TypeAdapters.11();
    u = new TypeAdapters.12();
    v = new TypeAdapters.13();
    localObject = new TypeAdapters.14();
    w = (TypeAdapter)localObject;
    x = new TypeAdapters.32(Number.class, (TypeAdapter)localObject);
    y = new TypeAdapters.15();
    z = new TypeAdapters.33(Character.TYPE, Character.class, y);
    A = new TypeAdapters.16();
    B = new TypeAdapters.17();
    C = new TypeAdapters.18();
    D = new TypeAdapters.32(String.class, A);
    localObject = new TypeAdapters.19();
    E = (TypeAdapter)localObject;
    F = new TypeAdapters.32(StringBuilder.class, (TypeAdapter)localObject);
    localObject = new TypeAdapters.20();
    G = (TypeAdapter)localObject;
    H = new TypeAdapters.32(StringBuffer.class, (TypeAdapter)localObject);
    localObject = new TypeAdapters.21();
    I = (TypeAdapter)localObject;
    J = new TypeAdapters.32(URL.class, (TypeAdapter)localObject);
    localObject = new TypeAdapters.22();
    K = (TypeAdapter)localObject;
    L = new TypeAdapters.32(URI.class, (TypeAdapter)localObject);
    localObject = new TypeAdapters.23();
    M = (TypeAdapter)localObject;
    N = new TypeAdapters.35(InetAddress.class, (TypeAdapter)localObject);
    localObject = new TypeAdapters.24();
    O = (TypeAdapter)localObject;
    P = new TypeAdapters.32(UUID.class, (TypeAdapter)localObject);
    localObject = new TypeAdapters.25().nullSafe();
    Q = (TypeAdapter)localObject;
    R = new TypeAdapters.32(Currency.class, (TypeAdapter)localObject);
    S = new TypeAdapters.26();
    localObject = new TypeAdapters.27();
    T = (TypeAdapter)localObject;
    U = new TypeAdapters.34(Calendar.class, GregorianCalendar.class, (TypeAdapter)localObject);
    localObject = new TypeAdapters.28();
    V = (TypeAdapter)localObject;
    W = new TypeAdapters.32(Locale.class, (TypeAdapter)localObject);
    localObject = new TypeAdapters.29();
    X = (TypeAdapter)localObject;
    Y = new TypeAdapters.35(j.class, (TypeAdapter)localObject);
  }
  
  public static <TT> u a(a<TT> parama, TypeAdapter<TT> paramTypeAdapter)
  {
    return new TypeAdapters.31(parama, paramTypeAdapter);
  }
  
  public static <TT> u a(Class<TT> paramClass, TypeAdapter<TT> paramTypeAdapter)
  {
    return new TypeAdapters.32(paramClass, paramTypeAdapter);
  }
}

/* Location:
 * Qualified Name:     base.com.google.gson.internal.bind.TypeAdapters
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */