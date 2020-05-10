package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import e.c.c.g;
import e.c.c.j;
import e.c.c.k;
import e.c.c.l;
import e.c.c.m;
import e.c.c.p;
import e.c.c.s;
import e.c.c.u;
import e.c.c.w.q;
import e.c.c.y.b;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
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
  public static final u Z = new u()
  {
    public <T> TypeAdapter<T> a(Gson paramAnonymousGson, e.c.c.x.a<T> paramAnonymousa)
    {
      paramAnonymousa = paramAnonymousa.getRawType();
      if ((Enum.class.isAssignableFrom(paramAnonymousa)) && (paramAnonymousa != Enum.class))
      {
        paramAnonymousGson = paramAnonymousa;
        if (!paramAnonymousa.isEnum()) {
          paramAnonymousGson = paramAnonymousa.getSuperclass();
        }
        return new TypeAdapters.EnumTypeAdapter(paramAnonymousGson);
      }
      return null;
    }
  };
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
    final Object localObject = new TypeAdapter()
    {
      public Object read(e.c.c.y.a paramAnonymousa)
      {
        throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
      }
      
      public void write(e.c.c.y.c paramAnonymousc, Object paramAnonymousObject)
      {
        paramAnonymousc = (Class)paramAnonymousObject;
        paramAnonymousObject = e.a.a.a.a.a("Attempted to serialize java.lang.Class: ");
        ((StringBuilder)paramAnonymousObject).append(paramAnonymousc.getName());
        ((StringBuilder)paramAnonymousObject).append(". Forgot to register a type adapter?");
        throw new UnsupportedOperationException(((StringBuilder)paramAnonymousObject).toString());
      }
    }.nullSafe();
    a = (TypeAdapter)localObject;
    b = new u()
    {
      public <T> TypeAdapter<T> a(Gson paramAnonymousGson, e.c.c.x.a<T> paramAnonymousa)
      {
        if (paramAnonymousa.getRawType() == x) {
          paramAnonymousGson = localObject;
        } else {
          paramAnonymousGson = null;
        }
        return paramAnonymousGson;
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = e.a.a.a.a.a("Factory[type=");
        localStringBuilder.append(x.getName());
        localStringBuilder.append(",adapter=");
        localStringBuilder.append(localObject);
        localStringBuilder.append("]");
        return localStringBuilder.toString();
      }
    };
    localObject = new TypeAdapter()
    {
      public Object read(e.c.c.y.a paramAnonymousa)
      {
        BitSet localBitSet = new BitSet();
        paramAnonymousa.a();
        Object localObject = paramAnonymousa.r();
        int i = 0;
        while (localObject != b.END_ARRAY)
        {
          int j = ((Enum)localObject).ordinal();
          boolean bool;
          if (j != 5)
          {
            if (j != 6)
            {
              if (j == 7)
              {
                bool = paramAnonymousa.j();
                break label130;
              }
              paramAnonymousa = new StringBuilder();
              paramAnonymousa.append("Invalid bitset value type: ");
              paramAnonymousa.append(localObject);
              throw new s(paramAnonymousa.toString());
            }
            if (paramAnonymousa.l() == 0) {
              break label127;
            }
          }
          else
          {
            localObject = paramAnonymousa.p();
          }
          try
          {
            j = Integer.parseInt((String)localObject);
            if (j != 0) {
              bool = true;
            } else {
              label127:
              bool = false;
            }
            label130:
            if (bool) {
              localBitSet.set(i);
            }
            i++;
            localObject = paramAnonymousa.r();
          }
          catch (NumberFormatException paramAnonymousa)
          {
            throw new s(e.a.a.a.a.b("Error: Expecting: bitset number value (1, 0), Found: ", (String)localObject));
          }
        }
        paramAnonymousa.e();
        return localBitSet;
      }
      
      public void write(e.c.c.y.c paramAnonymousc, Object paramAnonymousObject)
      {
        paramAnonymousObject = (BitSet)paramAnonymousObject;
        paramAnonymousc.b();
        int i = ((BitSet)paramAnonymousObject).length();
        for (int j = 0; j < i; j++) {
          paramAnonymousc.a(((BitSet)paramAnonymousObject).get(j));
        }
        paramAnonymousc.d();
      }
    }.nullSafe();
    c = (TypeAdapter)localObject;
    d = new u()
    {
      public <T> TypeAdapter<T> a(Gson paramAnonymousGson, e.c.c.x.a<T> paramAnonymousa)
      {
        if (paramAnonymousa.getRawType() == x) {
          paramAnonymousGson = localObject;
        } else {
          paramAnonymousGson = null;
        }
        return paramAnonymousGson;
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = e.a.a.a.a.a("Factory[type=");
        localStringBuilder.append(x.getName());
        localStringBuilder.append(",adapter=");
        localStringBuilder.append(localObject);
        localStringBuilder.append("]");
        return localStringBuilder.toString();
      }
    };
    e = new TypeAdapter()
    {
      public Object read(e.c.c.y.a paramAnonymousa)
      {
        b localb = paramAnonymousa.r();
        if (localb == b.NULL)
        {
          paramAnonymousa.o();
          paramAnonymousa = null;
        }
        else if (localb == b.STRING)
        {
          paramAnonymousa = Boolean.valueOf(Boolean.parseBoolean(paramAnonymousa.p()));
        }
        else
        {
          paramAnonymousa = Boolean.valueOf(paramAnonymousa.j());
        }
        return paramAnonymousa;
      }
      
      public void write(e.c.c.y.c paramAnonymousc, Object paramAnonymousObject)
      {
        paramAnonymousc.a((Boolean)paramAnonymousObject);
      }
    };
    f = new TypeAdapter()
    {
      public Object read(e.c.c.y.a paramAnonymousa)
      {
        if (paramAnonymousa.r() == b.NULL)
        {
          paramAnonymousa.o();
          paramAnonymousa = null;
        }
        else
        {
          paramAnonymousa = Boolean.valueOf(paramAnonymousa.p());
        }
        return paramAnonymousa;
      }
      
      public void write(e.c.c.y.c paramAnonymousc, Object paramAnonymousObject)
      {
        paramAnonymousObject = (Boolean)paramAnonymousObject;
        if (paramAnonymousObject == null) {
          paramAnonymousObject = "null";
        } else {
          paramAnonymousObject = ((Boolean)paramAnonymousObject).toString();
        }
        paramAnonymousc.c((String)paramAnonymousObject);
      }
    };
    g = new TypeAdapters.33(Boolean.TYPE, Boolean.class, e);
    h = new TypeAdapter()
    {
      public Object read(e.c.c.y.a paramAnonymousa)
      {
        if (paramAnonymousa.r() == b.NULL)
        {
          paramAnonymousa.o();
          paramAnonymousa = null;
        }
        try
        {
          paramAnonymousa = Byte.valueOf((byte)paramAnonymousa.l());
          return paramAnonymousa;
        }
        catch (NumberFormatException paramAnonymousa)
        {
          throw new s(paramAnonymousa);
        }
      }
      
      public void write(e.c.c.y.c paramAnonymousc, Object paramAnonymousObject)
      {
        paramAnonymousc.a((Number)paramAnonymousObject);
      }
    };
    i = new TypeAdapters.33(Byte.TYPE, Byte.class, h);
    j = new TypeAdapter()
    {
      public Object read(e.c.c.y.a paramAnonymousa)
      {
        if (paramAnonymousa.r() == b.NULL)
        {
          paramAnonymousa.o();
          paramAnonymousa = null;
        }
        try
        {
          paramAnonymousa = Short.valueOf((short)paramAnonymousa.l());
          return paramAnonymousa;
        }
        catch (NumberFormatException paramAnonymousa)
        {
          throw new s(paramAnonymousa);
        }
      }
      
      public void write(e.c.c.y.c paramAnonymousc, Object paramAnonymousObject)
      {
        paramAnonymousc.a((Number)paramAnonymousObject);
      }
    };
    k = new TypeAdapters.33(Short.TYPE, Short.class, j);
    l = new TypeAdapter()
    {
      public Object read(e.c.c.y.a paramAnonymousa)
      {
        if (paramAnonymousa.r() == b.NULL)
        {
          paramAnonymousa.o();
          paramAnonymousa = null;
        }
        try
        {
          paramAnonymousa = Integer.valueOf(paramAnonymousa.l());
          return paramAnonymousa;
        }
        catch (NumberFormatException paramAnonymousa)
        {
          throw new s(paramAnonymousa);
        }
      }
      
      public void write(e.c.c.y.c paramAnonymousc, Object paramAnonymousObject)
      {
        paramAnonymousc.a((Number)paramAnonymousObject);
      }
    };
    m = new TypeAdapters.33(Integer.TYPE, Integer.class, l);
    localObject = new TypeAdapter()
    {
      public Object read(e.c.c.y.a paramAnonymousa)
      {
        try
        {
          paramAnonymousa = new AtomicInteger(paramAnonymousa.l());
          return paramAnonymousa;
        }
        catch (NumberFormatException paramAnonymousa)
        {
          throw new s(paramAnonymousa);
        }
      }
      
      public void write(e.c.c.y.c paramAnonymousc, Object paramAnonymousObject)
      {
        paramAnonymousc.a(((AtomicInteger)paramAnonymousObject).get());
      }
    }.nullSafe();
    n = (TypeAdapter)localObject;
    o = new u()
    {
      public <T> TypeAdapter<T> a(Gson paramAnonymousGson, e.c.c.x.a<T> paramAnonymousa)
      {
        if (paramAnonymousa.getRawType() == x) {
          paramAnonymousGson = localObject;
        } else {
          paramAnonymousGson = null;
        }
        return paramAnonymousGson;
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = e.a.a.a.a.a("Factory[type=");
        localStringBuilder.append(x.getName());
        localStringBuilder.append(",adapter=");
        localStringBuilder.append(localObject);
        localStringBuilder.append("]");
        return localStringBuilder.toString();
      }
    };
    localObject = new TypeAdapter()
    {
      public Object read(e.c.c.y.a paramAnonymousa)
      {
        return new AtomicBoolean(paramAnonymousa.j());
      }
      
      public void write(e.c.c.y.c paramAnonymousc, Object paramAnonymousObject)
      {
        paramAnonymousc.a(((AtomicBoolean)paramAnonymousObject).get());
      }
    }.nullSafe();
    p = (TypeAdapter)localObject;
    q = new u()
    {
      public <T> TypeAdapter<T> a(Gson paramAnonymousGson, e.c.c.x.a<T> paramAnonymousa)
      {
        if (paramAnonymousa.getRawType() == x) {
          paramAnonymousGson = localObject;
        } else {
          paramAnonymousGson = null;
        }
        return paramAnonymousGson;
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = e.a.a.a.a.a("Factory[type=");
        localStringBuilder.append(x.getName());
        localStringBuilder.append(",adapter=");
        localStringBuilder.append(localObject);
        localStringBuilder.append("]");
        return localStringBuilder.toString();
      }
    };
    localObject = new TypeAdapter()
    {
      public Object read(e.c.c.y.a paramAnonymousa)
      {
        ArrayList localArrayList = new ArrayList();
        paramAnonymousa.a();
        while (paramAnonymousa.h()) {
          try
          {
            localArrayList.add(Integer.valueOf(paramAnonymousa.l()));
          }
          catch (NumberFormatException paramAnonymousa)
          {
            throw new s(paramAnonymousa);
          }
        }
        paramAnonymousa.e();
        int i = localArrayList.size();
        paramAnonymousa = new AtomicIntegerArray(i);
        for (int j = 0; j < i; j++) {
          paramAnonymousa.set(j, ((Integer)localArrayList.get(j)).intValue());
        }
        return paramAnonymousa;
      }
      
      public void write(e.c.c.y.c paramAnonymousc, Object paramAnonymousObject)
      {
        paramAnonymousObject = (AtomicIntegerArray)paramAnonymousObject;
        paramAnonymousc.b();
        int i = ((AtomicIntegerArray)paramAnonymousObject).length();
        for (int j = 0; j < i; j++) {
          paramAnonymousc.a(((AtomicIntegerArray)paramAnonymousObject).get(j));
        }
        paramAnonymousc.d();
      }
    }.nullSafe();
    r = (TypeAdapter)localObject;
    s = new u()
    {
      public <T> TypeAdapter<T> a(Gson paramAnonymousGson, e.c.c.x.a<T> paramAnonymousa)
      {
        if (paramAnonymousa.getRawType() == x) {
          paramAnonymousGson = localObject;
        } else {
          paramAnonymousGson = null;
        }
        return paramAnonymousGson;
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = e.a.a.a.a.a("Factory[type=");
        localStringBuilder.append(x.getName());
        localStringBuilder.append(",adapter=");
        localStringBuilder.append(localObject);
        localStringBuilder.append("]");
        return localStringBuilder.toString();
      }
    };
    t = new TypeAdapter()
    {
      public Object read(e.c.c.y.a paramAnonymousa)
      {
        if (paramAnonymousa.r() == b.NULL)
        {
          paramAnonymousa.o();
          paramAnonymousa = null;
        }
        try
        {
          paramAnonymousa = Long.valueOf(paramAnonymousa.m());
          return paramAnonymousa;
        }
        catch (NumberFormatException paramAnonymousa)
        {
          throw new s(paramAnonymousa);
        }
      }
      
      public void write(e.c.c.y.c paramAnonymousc, Object paramAnonymousObject)
      {
        paramAnonymousc.a((Number)paramAnonymousObject);
      }
    };
    u = new TypeAdapter()
    {
      public Object read(e.c.c.y.a paramAnonymousa)
      {
        if (paramAnonymousa.r() == b.NULL)
        {
          paramAnonymousa.o();
          paramAnonymousa = null;
        }
        else
        {
          paramAnonymousa = Float.valueOf((float)paramAnonymousa.k());
        }
        return paramAnonymousa;
      }
      
      public void write(e.c.c.y.c paramAnonymousc, Object paramAnonymousObject)
      {
        paramAnonymousc.a((Number)paramAnonymousObject);
      }
    };
    v = new TypeAdapter()
    {
      public Object read(e.c.c.y.a paramAnonymousa)
      {
        if (paramAnonymousa.r() == b.NULL)
        {
          paramAnonymousa.o();
          paramAnonymousa = null;
        }
        else
        {
          paramAnonymousa = Double.valueOf(paramAnonymousa.k());
        }
        return paramAnonymousa;
      }
      
      public void write(e.c.c.y.c paramAnonymousc, Object paramAnonymousObject)
      {
        paramAnonymousc.a((Number)paramAnonymousObject);
      }
    };
    localObject = new TypeAdapter()
    {
      public Object read(e.c.c.y.a paramAnonymousa)
      {
        b localb = paramAnonymousa.r();
        int i = localb.ordinal();
        if ((i != 5) && (i != 6))
        {
          if (i == 8)
          {
            paramAnonymousa.o();
            paramAnonymousa = null;
          }
          else
          {
            paramAnonymousa = new StringBuilder();
            paramAnonymousa.append("Expecting number, got: ");
            paramAnonymousa.append(localb);
            throw new s(paramAnonymousa.toString());
          }
        }
        else {
          paramAnonymousa = new q(paramAnonymousa.p());
        }
        return paramAnonymousa;
      }
      
      public void write(e.c.c.y.c paramAnonymousc, Object paramAnonymousObject)
      {
        paramAnonymousc.a((Number)paramAnonymousObject);
      }
    };
    w = (TypeAdapter)localObject;
    x = new u()
    {
      public <T> TypeAdapter<T> a(Gson paramAnonymousGson, e.c.c.x.a<T> paramAnonymousa)
      {
        if (paramAnonymousa.getRawType() == x) {
          paramAnonymousGson = localObject;
        } else {
          paramAnonymousGson = null;
        }
        return paramAnonymousGson;
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = e.a.a.a.a.a("Factory[type=");
        localStringBuilder.append(x.getName());
        localStringBuilder.append(",adapter=");
        localStringBuilder.append(localObject);
        localStringBuilder.append("]");
        return localStringBuilder.toString();
      }
    };
    y = new TypeAdapter()
    {
      public Object read(e.c.c.y.a paramAnonymousa)
      {
        if (paramAnonymousa.r() == b.NULL)
        {
          paramAnonymousa.o();
          paramAnonymousa = null;
        }
        else
        {
          paramAnonymousa = paramAnonymousa.p();
          if (paramAnonymousa.length() != 1) {
            break label43;
          }
          paramAnonymousa = Character.valueOf(paramAnonymousa.charAt(0));
        }
        return paramAnonymousa;
        label43:
        throw new s(e.a.a.a.a.b("Expecting character, got: ", paramAnonymousa));
      }
      
      public void write(e.c.c.y.c paramAnonymousc, Object paramAnonymousObject)
      {
        paramAnonymousObject = (Character)paramAnonymousObject;
        if (paramAnonymousObject == null) {
          paramAnonymousObject = null;
        } else {
          paramAnonymousObject = String.valueOf(paramAnonymousObject);
        }
        paramAnonymousc.c((String)paramAnonymousObject);
      }
    };
    z = new TypeAdapters.33(Character.TYPE, Character.class, y);
    A = new TypeAdapter()
    {
      public Object read(e.c.c.y.a paramAnonymousa)
      {
        b localb = paramAnonymousa.r();
        if (localb == b.NULL)
        {
          paramAnonymousa.o();
          paramAnonymousa = null;
        }
        else if (localb == b.BOOLEAN)
        {
          paramAnonymousa = Boolean.toString(paramAnonymousa.j());
        }
        else
        {
          paramAnonymousa = paramAnonymousa.p();
        }
        return paramAnonymousa;
      }
      
      public void write(e.c.c.y.c paramAnonymousc, Object paramAnonymousObject)
      {
        paramAnonymousc.c((String)paramAnonymousObject);
      }
    };
    B = new TypeAdapter()
    {
      public Object read(e.c.c.y.a paramAnonymousa)
      {
        if (paramAnonymousa.r() == b.NULL)
        {
          paramAnonymousa.o();
          paramAnonymousa = null;
        }
        try
        {
          paramAnonymousa = new BigDecimal(paramAnonymousa.p());
          return paramAnonymousa;
        }
        catch (NumberFormatException paramAnonymousa)
        {
          throw new s(paramAnonymousa);
        }
      }
      
      public void write(e.c.c.y.c paramAnonymousc, Object paramAnonymousObject)
      {
        paramAnonymousc.a((BigDecimal)paramAnonymousObject);
      }
    };
    C = new TypeAdapter()
    {
      public Object read(e.c.c.y.a paramAnonymousa)
      {
        if (paramAnonymousa.r() == b.NULL)
        {
          paramAnonymousa.o();
          paramAnonymousa = null;
        }
        try
        {
          paramAnonymousa = new BigInteger(paramAnonymousa.p());
          return paramAnonymousa;
        }
        catch (NumberFormatException paramAnonymousa)
        {
          throw new s(paramAnonymousa);
        }
      }
      
      public void write(e.c.c.y.c paramAnonymousc, Object paramAnonymousObject)
      {
        paramAnonymousc.a((BigInteger)paramAnonymousObject);
      }
    };
    D = new u()
    {
      public <T> TypeAdapter<T> a(Gson paramAnonymousGson, e.c.c.x.a<T> paramAnonymousa)
      {
        if (paramAnonymousa.getRawType() == x) {
          paramAnonymousGson = localObject;
        } else {
          paramAnonymousGson = null;
        }
        return paramAnonymousGson;
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = e.a.a.a.a.a("Factory[type=");
        localStringBuilder.append(x.getName());
        localStringBuilder.append(",adapter=");
        localStringBuilder.append(localObject);
        localStringBuilder.append("]");
        return localStringBuilder.toString();
      }
    };
    localObject = new TypeAdapter()
    {
      public Object read(e.c.c.y.a paramAnonymousa)
      {
        if (paramAnonymousa.r() == b.NULL)
        {
          paramAnonymousa.o();
          paramAnonymousa = null;
        }
        else
        {
          paramAnonymousa = new StringBuilder(paramAnonymousa.p());
        }
        return paramAnonymousa;
      }
      
      public void write(e.c.c.y.c paramAnonymousc, Object paramAnonymousObject)
      {
        paramAnonymousObject = (StringBuilder)paramAnonymousObject;
        if (paramAnonymousObject == null) {
          paramAnonymousObject = null;
        } else {
          paramAnonymousObject = ((StringBuilder)paramAnonymousObject).toString();
        }
        paramAnonymousc.c((String)paramAnonymousObject);
      }
    };
    E = (TypeAdapter)localObject;
    F = new u()
    {
      public <T> TypeAdapter<T> a(Gson paramAnonymousGson, e.c.c.x.a<T> paramAnonymousa)
      {
        if (paramAnonymousa.getRawType() == x) {
          paramAnonymousGson = localObject;
        } else {
          paramAnonymousGson = null;
        }
        return paramAnonymousGson;
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = e.a.a.a.a.a("Factory[type=");
        localStringBuilder.append(x.getName());
        localStringBuilder.append(",adapter=");
        localStringBuilder.append(localObject);
        localStringBuilder.append("]");
        return localStringBuilder.toString();
      }
    };
    localObject = new TypeAdapter()
    {
      public Object read(e.c.c.y.a paramAnonymousa)
      {
        if (paramAnonymousa.r() == b.NULL)
        {
          paramAnonymousa.o();
          paramAnonymousa = null;
        }
        else
        {
          paramAnonymousa = new StringBuffer(paramAnonymousa.p());
        }
        return paramAnonymousa;
      }
      
      public void write(e.c.c.y.c paramAnonymousc, Object paramAnonymousObject)
      {
        paramAnonymousObject = (StringBuffer)paramAnonymousObject;
        if (paramAnonymousObject == null) {
          paramAnonymousObject = null;
        } else {
          paramAnonymousObject = ((StringBuffer)paramAnonymousObject).toString();
        }
        paramAnonymousc.c((String)paramAnonymousObject);
      }
    };
    G = (TypeAdapter)localObject;
    H = new u()
    {
      public <T> TypeAdapter<T> a(Gson paramAnonymousGson, e.c.c.x.a<T> paramAnonymousa)
      {
        if (paramAnonymousa.getRawType() == x) {
          paramAnonymousGson = localObject;
        } else {
          paramAnonymousGson = null;
        }
        return paramAnonymousGson;
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = e.a.a.a.a.a("Factory[type=");
        localStringBuilder.append(x.getName());
        localStringBuilder.append(",adapter=");
        localStringBuilder.append(localObject);
        localStringBuilder.append("]");
        return localStringBuilder.toString();
      }
    };
    localObject = new TypeAdapter()
    {
      public Object read(e.c.c.y.a paramAnonymousa)
      {
        b localb1 = paramAnonymousa.r();
        b localb2 = b.NULL;
        Object localObject = null;
        if (localb1 == localb2)
        {
          paramAnonymousa.o();
          paramAnonymousa = (e.c.c.y.a)localObject;
        }
        else
        {
          paramAnonymousa = paramAnonymousa.p();
          if ("null".equals(paramAnonymousa)) {
            paramAnonymousa = (e.c.c.y.a)localObject;
          } else {
            paramAnonymousa = new URL(paramAnonymousa);
          }
        }
        return paramAnonymousa;
      }
      
      public void write(e.c.c.y.c paramAnonymousc, Object paramAnonymousObject)
      {
        paramAnonymousObject = (URL)paramAnonymousObject;
        if (paramAnonymousObject == null) {
          paramAnonymousObject = null;
        } else {
          paramAnonymousObject = ((URL)paramAnonymousObject).toExternalForm();
        }
        paramAnonymousc.c((String)paramAnonymousObject);
      }
    };
    I = (TypeAdapter)localObject;
    J = new u()
    {
      public <T> TypeAdapter<T> a(Gson paramAnonymousGson, e.c.c.x.a<T> paramAnonymousa)
      {
        if (paramAnonymousa.getRawType() == x) {
          paramAnonymousGson = localObject;
        } else {
          paramAnonymousGson = null;
        }
        return paramAnonymousGson;
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = e.a.a.a.a.a("Factory[type=");
        localStringBuilder.append(x.getName());
        localStringBuilder.append(",adapter=");
        localStringBuilder.append(localObject);
        localStringBuilder.append("]");
        return localStringBuilder.toString();
      }
    };
    localObject = new TypeAdapter()
    {
      public Object read(e.c.c.y.a paramAnonymousa)
      {
        b localb1 = paramAnonymousa.r();
        b localb2 = b.NULL;
        Object localObject = null;
        if (localb1 == localb2)
        {
          paramAnonymousa.o();
          paramAnonymousa = (e.c.c.y.a)localObject;
        }
        try
        {
          paramAnonymousa = paramAnonymousa.p();
          if ("null".equals(paramAnonymousa)) {
            paramAnonymousa = (e.c.c.y.a)localObject;
          } else {
            paramAnonymousa = new URI(paramAnonymousa);
          }
          return paramAnonymousa;
        }
        catch (URISyntaxException paramAnonymousa)
        {
          throw new k(paramAnonymousa);
        }
      }
      
      public void write(e.c.c.y.c paramAnonymousc, Object paramAnonymousObject)
      {
        paramAnonymousObject = (URI)paramAnonymousObject;
        if (paramAnonymousObject == null) {
          paramAnonymousObject = null;
        } else {
          paramAnonymousObject = ((URI)paramAnonymousObject).toASCIIString();
        }
        paramAnonymousc.c((String)paramAnonymousObject);
      }
    };
    K = (TypeAdapter)localObject;
    L = new u()
    {
      public <T> TypeAdapter<T> a(Gson paramAnonymousGson, e.c.c.x.a<T> paramAnonymousa)
      {
        if (paramAnonymousa.getRawType() == x) {
          paramAnonymousGson = localObject;
        } else {
          paramAnonymousGson = null;
        }
        return paramAnonymousGson;
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = e.a.a.a.a.a("Factory[type=");
        localStringBuilder.append(x.getName());
        localStringBuilder.append(",adapter=");
        localStringBuilder.append(localObject);
        localStringBuilder.append("]");
        return localStringBuilder.toString();
      }
    };
    localObject = new TypeAdapter()
    {
      public Object read(e.c.c.y.a paramAnonymousa)
      {
        if (paramAnonymousa.r() == b.NULL)
        {
          paramAnonymousa.o();
          paramAnonymousa = null;
        }
        else
        {
          paramAnonymousa = InetAddress.getByName(paramAnonymousa.p());
        }
        return paramAnonymousa;
      }
      
      public void write(e.c.c.y.c paramAnonymousc, Object paramAnonymousObject)
      {
        paramAnonymousObject = (InetAddress)paramAnonymousObject;
        if (paramAnonymousObject == null) {
          paramAnonymousObject = null;
        } else {
          paramAnonymousObject = ((InetAddress)paramAnonymousObject).getHostAddress();
        }
        paramAnonymousc.c((String)paramAnonymousObject);
      }
    };
    M = (TypeAdapter)localObject;
    N = new TypeAdapters.35(InetAddress.class, (TypeAdapter)localObject);
    localObject = new TypeAdapter()
    {
      public Object read(e.c.c.y.a paramAnonymousa)
      {
        if (paramAnonymousa.r() == b.NULL)
        {
          paramAnonymousa.o();
          paramAnonymousa = null;
        }
        else
        {
          paramAnonymousa = UUID.fromString(paramAnonymousa.p());
        }
        return paramAnonymousa;
      }
      
      public void write(e.c.c.y.c paramAnonymousc, Object paramAnonymousObject)
      {
        paramAnonymousObject = (UUID)paramAnonymousObject;
        if (paramAnonymousObject == null) {
          paramAnonymousObject = null;
        } else {
          paramAnonymousObject = ((UUID)paramAnonymousObject).toString();
        }
        paramAnonymousc.c((String)paramAnonymousObject);
      }
    };
    O = (TypeAdapter)localObject;
    P = new u()
    {
      public <T> TypeAdapter<T> a(Gson paramAnonymousGson, e.c.c.x.a<T> paramAnonymousa)
      {
        if (paramAnonymousa.getRawType() == x) {
          paramAnonymousGson = localObject;
        } else {
          paramAnonymousGson = null;
        }
        return paramAnonymousGson;
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = e.a.a.a.a.a("Factory[type=");
        localStringBuilder.append(x.getName());
        localStringBuilder.append(",adapter=");
        localStringBuilder.append(localObject);
        localStringBuilder.append("]");
        return localStringBuilder.toString();
      }
    };
    localObject = new TypeAdapter()
    {
      public Object read(e.c.c.y.a paramAnonymousa)
      {
        return Currency.getInstance(paramAnonymousa.p());
      }
      
      public void write(e.c.c.y.c paramAnonymousc, Object paramAnonymousObject)
      {
        paramAnonymousc.c(((Currency)paramAnonymousObject).getCurrencyCode());
      }
    }.nullSafe();
    Q = (TypeAdapter)localObject;
    R = new u()
    {
      public <T> TypeAdapter<T> a(Gson paramAnonymousGson, e.c.c.x.a<T> paramAnonymousa)
      {
        if (paramAnonymousa.getRawType() == x) {
          paramAnonymousGson = localObject;
        } else {
          paramAnonymousGson = null;
        }
        return paramAnonymousGson;
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = e.a.a.a.a.a("Factory[type=");
        localStringBuilder.append(x.getName());
        localStringBuilder.append(",adapter=");
        localStringBuilder.append(localObject);
        localStringBuilder.append("]");
        return localStringBuilder.toString();
      }
    };
    S = new u()
    {
      public <T> TypeAdapter<T> a(Gson paramAnonymousGson, e.c.c.x.a<T> paramAnonymousa)
      {
        if (paramAnonymousa.getRawType() != Timestamp.class) {
          return null;
        }
        if (paramAnonymousGson != null) {
          new TypeAdapter()
          {
            public Object read(e.c.c.y.a paramAnonymous2a)
            {
              paramAnonymous2a = (Date)a.read(paramAnonymous2a);
              if (paramAnonymous2a != null) {
                paramAnonymous2a = new Timestamp(paramAnonymous2a.getTime());
              } else {
                paramAnonymous2a = null;
              }
              return paramAnonymous2a;
            }
            
            public void write(e.c.c.y.c paramAnonymous2c, Object paramAnonymous2Object)
            {
              paramAnonymous2Object = (Timestamp)paramAnonymous2Object;
              a.write(paramAnonymous2c, paramAnonymous2Object);
            }
          };
        }
        throw null;
      }
    };
    localObject = new TypeAdapter()
    {
      public Object read(e.c.c.y.a paramAnonymousa)
      {
        if (paramAnonymousa.r() == b.NULL)
        {
          paramAnonymousa.o();
          paramAnonymousa = null;
        }
        else
        {
          paramAnonymousa.b();
          int i = 0;
          int j = 0;
          int k = 0;
          int m = 0;
          int n = 0;
          int i1 = 0;
          while (paramAnonymousa.r() != b.END_OBJECT)
          {
            String str = paramAnonymousa.n();
            int i2 = paramAnonymousa.l();
            if ("year".equals(str)) {
              i = i2;
            } else if ("month".equals(str)) {
              j = i2;
            } else if ("dayOfMonth".equals(str)) {
              k = i2;
            } else if ("hourOfDay".equals(str)) {
              m = i2;
            } else if ("minute".equals(str)) {
              n = i2;
            } else if ("second".equals(str)) {
              i1 = i2;
            }
          }
          paramAnonymousa.f();
          paramAnonymousa = new GregorianCalendar(i, j, k, m, n, i1);
        }
        return paramAnonymousa;
      }
      
      public void write(e.c.c.y.c paramAnonymousc, Object paramAnonymousObject)
      {
        paramAnonymousObject = (Calendar)paramAnonymousObject;
        if (paramAnonymousObject == null)
        {
          paramAnonymousc.g();
        }
        else
        {
          paramAnonymousc.c();
          paramAnonymousc.a("year");
          paramAnonymousc.a(((Calendar)paramAnonymousObject).get(1));
          paramAnonymousc.a("month");
          paramAnonymousc.a(((Calendar)paramAnonymousObject).get(2));
          paramAnonymousc.a("dayOfMonth");
          paramAnonymousc.a(((Calendar)paramAnonymousObject).get(5));
          paramAnonymousc.a("hourOfDay");
          paramAnonymousc.a(((Calendar)paramAnonymousObject).get(11));
          paramAnonymousc.a("minute");
          paramAnonymousc.a(((Calendar)paramAnonymousObject).get(12));
          paramAnonymousc.a("second");
          paramAnonymousc.a(((Calendar)paramAnonymousObject).get(13));
          paramAnonymousc.e();
        }
      }
    };
    T = (TypeAdapter)localObject;
    U = new TypeAdapters.34(Calendar.class, GregorianCalendar.class, (TypeAdapter)localObject);
    localObject = new TypeAdapter()
    {
      public Object read(e.c.c.y.a paramAnonymousa)
      {
        Object localObject = paramAnonymousa.r();
        b localb = b.NULL;
        String str1 = null;
        String str2 = null;
        if (localObject == localb)
        {
          paramAnonymousa.o();
          paramAnonymousa = str1;
        }
        else
        {
          localObject = new StringTokenizer(paramAnonymousa.p(), "_");
          if (((StringTokenizer)localObject).hasMoreElements()) {
            paramAnonymousa = ((StringTokenizer)localObject).nextToken();
          } else {
            paramAnonymousa = null;
          }
          if (((StringTokenizer)localObject).hasMoreElements()) {
            str1 = ((StringTokenizer)localObject).nextToken();
          } else {
            str1 = null;
          }
          if (((StringTokenizer)localObject).hasMoreElements()) {
            str2 = ((StringTokenizer)localObject).nextToken();
          }
          if ((str1 == null) && (str2 == null)) {
            paramAnonymousa = new Locale(paramAnonymousa);
          } else if (str2 == null) {
            paramAnonymousa = new Locale(paramAnonymousa, str1);
          } else {
            paramAnonymousa = new Locale(paramAnonymousa, str1, str2);
          }
        }
        return paramAnonymousa;
      }
      
      public void write(e.c.c.y.c paramAnonymousc, Object paramAnonymousObject)
      {
        paramAnonymousObject = (Locale)paramAnonymousObject;
        if (paramAnonymousObject == null) {
          paramAnonymousObject = null;
        } else {
          paramAnonymousObject = ((Locale)paramAnonymousObject).toString();
        }
        paramAnonymousc.c((String)paramAnonymousObject);
      }
    };
    V = (TypeAdapter)localObject;
    W = new u()
    {
      public <T> TypeAdapter<T> a(Gson paramAnonymousGson, e.c.c.x.a<T> paramAnonymousa)
      {
        if (paramAnonymousa.getRawType() == x) {
          paramAnonymousGson = localObject;
        } else {
          paramAnonymousGson = null;
        }
        return paramAnonymousGson;
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = e.a.a.a.a.a("Factory[type=");
        localStringBuilder.append(x.getName());
        localStringBuilder.append(",adapter=");
        localStringBuilder.append(localObject);
        localStringBuilder.append("]");
        return localStringBuilder.toString();
      }
    };
    localObject = new TypeAdapter()
    {
      public void a(e.c.c.y.c paramAnonymousc, j paramAnonymousj)
      {
        if ((paramAnonymousj != null) && (!(paramAnonymousj instanceof l)))
        {
          Object localObject;
          if ((paramAnonymousj instanceof p))
          {
            localObject = paramAnonymousj.d();
            paramAnonymousj = a;
            if ((paramAnonymousj instanceof Number)) {
              paramAnonymousc.a(((p)localObject).h());
            } else if ((paramAnonymousj instanceof Boolean)) {
              paramAnonymousc.a(((p)localObject).g());
            } else {
              paramAnonymousc.c(((p)localObject).f());
            }
          }
          else if ((paramAnonymousj instanceof g))
          {
            paramAnonymousc.b();
            paramAnonymousj = paramAnonymousj.b().iterator();
            while (paramAnonymousj.hasNext()) {
              a(paramAnonymousc, (j)paramAnonymousj.next());
            }
            paramAnonymousc.d();
          }
          else if ((paramAnonymousj instanceof m))
          {
            paramAnonymousc.c();
            localObject = paramAnonymousj.c().g().iterator();
            while (((Iterator)localObject).hasNext())
            {
              paramAnonymousj = (Map.Entry)((Iterator)localObject).next();
              paramAnonymousc.a((String)paramAnonymousj.getKey());
              a(paramAnonymousc, (j)paramAnonymousj.getValue());
            }
            paramAnonymousc.e();
          }
          else
          {
            paramAnonymousc = e.a.a.a.a.a("Couldn't write ");
            paramAnonymousc.append(paramAnonymousj.getClass());
            throw new IllegalArgumentException(paramAnonymousc.toString());
          }
        }
        else
        {
          paramAnonymousc.g();
        }
      }
      
      public j read(e.c.c.y.a paramAnonymousa)
      {
        int i = paramAnonymousa.r().ordinal();
        Object localObject;
        if (i != 0)
        {
          if (i != 2)
          {
            if (i != 5)
            {
              if (i != 6)
              {
                if (i != 7)
                {
                  if (i == 8)
                  {
                    paramAnonymousa.o();
                    return l.a;
                  }
                  throw new IllegalArgumentException();
                }
                return new p(Boolean.valueOf(paramAnonymousa.j()));
              }
              return new p(new q(paramAnonymousa.p()));
            }
            return new p(paramAnonymousa.p());
          }
          localObject = new m();
          paramAnonymousa.b();
          while (paramAnonymousa.h()) {
            ((m)localObject).a(paramAnonymousa.n(), read(paramAnonymousa));
          }
          paramAnonymousa.f();
          return (j)localObject;
        }
        g localg = new g();
        paramAnonymousa.a();
        while (paramAnonymousa.h())
        {
          j localj = read(paramAnonymousa);
          localObject = localj;
          if (localj == null) {
            localObject = l.a;
          }
          x.add(localObject);
        }
        paramAnonymousa.e();
        return localg;
      }
    };
    X = (TypeAdapter)localObject;
    Y = new TypeAdapters.35(j.class, (TypeAdapter)localObject);
  }
  
  public static <TT> u a(e.c.c.x.a<TT> parama, final TypeAdapter<TT> paramTypeAdapter)
  {
    new u()
    {
      public <T> TypeAdapter<T> a(Gson paramAnonymousGson, e.c.c.x.a<T> paramAnonymousa)
      {
        if (paramAnonymousa.equals(x)) {
          paramAnonymousGson = paramTypeAdapter;
        } else {
          paramAnonymousGson = null;
        }
        return paramAnonymousGson;
      }
    };
  }
  
  public static <TT> u a(Class<TT> paramClass, TypeAdapter<TT> paramTypeAdapter)
  {
    new u()
    {
      public <T> TypeAdapter<T> a(Gson paramAnonymousGson, e.c.c.x.a<T> paramAnonymousa)
      {
        if (paramAnonymousa.getRawType() == x) {
          paramAnonymousGson = localObject;
        } else {
          paramAnonymousGson = null;
        }
        return paramAnonymousGson;
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = e.a.a.a.a.a("Factory[type=");
        localStringBuilder.append(x.getName());
        localStringBuilder.append(",adapter=");
        localStringBuilder.append(localObject);
        localStringBuilder.append("]");
        return localStringBuilder.toString();
      }
    };
  }
  
  public static final class EnumTypeAdapter<T extends Enum<T>>
    extends TypeAdapter<T>
  {
    public final Map<String, T> a = new HashMap();
    public final Map<T, String> b = new HashMap();
    
    public EnumTypeAdapter(Class<T> paramClass)
    {
      try
      {
        for (Enum localEnum : (Enum[])paramClass.getEnumConstants())
        {
          Object localObject1 = localEnum.name();
          Object localObject2 = (e.c.c.v.c)paramClass.getField((String)localObject1).getAnnotation(e.c.c.v.c.class);
          if (localObject2 != null)
          {
            String str = ((e.c.c.v.c)localObject2).value();
            localObject2 = ((e.c.c.v.c)localObject2).alternate();
            int k = localObject2.length;
            for (int m = 0;; m++)
            {
              localObject1 = str;
              if (m >= k) {
                break;
              }
              localObject1 = localObject2[m];
              a.put(localObject1, localEnum);
            }
          }
          a.put(localObject1, localEnum);
          b.put(localEnum, localObject1);
        }
        return;
      }
      catch (NoSuchFieldException paramClass)
      {
        throw new AssertionError(paramClass);
      }
    }
    
    public Object read(e.c.c.y.a parama)
    {
      if (parama.r() == b.NULL)
      {
        parama.o();
        parama = null;
      }
      else
      {
        parama = (Enum)a.get(parama.p());
      }
      return parama;
    }
    
    public void write(e.c.c.y.c paramc, Object paramObject)
    {
      paramObject = (Enum)paramObject;
      if (paramObject == null) {
        paramObject = null;
      } else {
        paramObject = (String)b.get(paramObject);
      }
      paramc.c((String)paramObject);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */