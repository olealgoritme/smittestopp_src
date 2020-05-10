package com.google.gson;

import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SqlDateTypeAdapter;
import com.google.gson.internal.bind.TimeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.bind.TypeAdapters.32;
import com.google.gson.internal.bind.TypeAdapters.33;
import e.c.c.f;
import e.c.c.j;
import e.c.c.k;
import e.c.c.l;
import e.c.c.s;
import e.c.c.u;
import e.c.c.w.g;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public final class Gson
{
  public static final e.c.c.x.a<?> k = e.c.c.x.a.get(Object.class);
  public final ThreadLocal<Map<e.c.c.x.a<?>, FutureTypeAdapter<?>>> a = new ThreadLocal();
  public final Map<e.c.c.x.a<?>, TypeAdapter<?>> b = new ConcurrentHashMap();
  public final g c;
  public final JsonAdapterAnnotationTypeAdapterFactory d;
  public final List<u> e;
  public final boolean f;
  public final boolean g;
  public final boolean h;
  public final boolean i;
  public final boolean j;
  
  public Gson()
  {
    this(Excluder.D, e.c.c.c.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, e.c.c.t.DEFAULT, null, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
  }
  
  public Gson(Excluder paramExcluder, e.c.c.d paramd, Map<Type, f<?>> paramMap, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, e.c.c.t paramt, String paramString, int paramInt1, int paramInt2, List<u> paramList1, List<u> paramList2, List<u> paramList3)
  {
    c = new g(paramMap);
    f = paramBoolean1;
    g = paramBoolean3;
    h = paramBoolean4;
    i = paramBoolean5;
    j = paramBoolean6;
    paramString = new ArrayList();
    paramString.add(TypeAdapters.Y);
    paramString.add(ObjectTypeAdapter.b);
    paramString.add(paramExcluder);
    paramString.addAll(paramList3);
    paramString.add(TypeAdapters.D);
    paramString.add(TypeAdapters.m);
    paramString.add(TypeAdapters.g);
    paramString.add(TypeAdapters.i);
    paramString.add(TypeAdapters.k);
    if (paramt == e.c.c.t.DEFAULT) {
      paramMap = TypeAdapters.t;
    } else {
      paramMap = new Gson.3();
    }
    paramString.add(new TypeAdapters.33(Long.TYPE, Long.class, paramMap));
    paramList1 = Double.TYPE;
    if (paramBoolean7) {
      paramt = TypeAdapters.v;
    } else {
      paramt = new Gson.1(this);
    }
    paramString.add(new TypeAdapters.33(paramList1, Double.class, paramt));
    paramList1 = Float.TYPE;
    if (paramBoolean7) {
      paramt = TypeAdapters.u;
    } else {
      paramt = new Gson.2(this);
    }
    paramString.add(new TypeAdapters.33(paramList1, Float.class, paramt));
    paramString.add(TypeAdapters.x);
    paramString.add(TypeAdapters.o);
    paramString.add(TypeAdapters.q);
    paramString.add(new TypeAdapters.32(AtomicLong.class, new Gson.4(paramMap).nullSafe()));
    paramString.add(new TypeAdapters.32(AtomicLongArray.class, new Gson.5(paramMap).nullSafe()));
    paramString.add(TypeAdapters.s);
    paramString.add(TypeAdapters.z);
    paramString.add(TypeAdapters.F);
    paramString.add(TypeAdapters.H);
    paramString.add(new TypeAdapters.32(BigDecimal.class, TypeAdapters.B));
    paramString.add(new TypeAdapters.32(BigInteger.class, TypeAdapters.C));
    paramString.add(TypeAdapters.J);
    paramString.add(TypeAdapters.L);
    paramString.add(TypeAdapters.P);
    paramString.add(TypeAdapters.R);
    paramString.add(TypeAdapters.W);
    paramString.add(TypeAdapters.N);
    paramString.add(TypeAdapters.d);
    paramString.add(DateTypeAdapter.b);
    paramString.add(TypeAdapters.U);
    paramString.add(TimeTypeAdapter.b);
    paramString.add(SqlDateTypeAdapter.b);
    paramString.add(TypeAdapters.S);
    paramString.add(ArrayTypeAdapter.c);
    paramString.add(TypeAdapters.b);
    paramString.add(new CollectionTypeAdapterFactory(c));
    paramString.add(new MapTypeAdapterFactory(c, paramBoolean2));
    paramMap = new JsonAdapterAnnotationTypeAdapterFactory(c);
    d = paramMap;
    paramString.add(paramMap);
    paramString.add(TypeAdapters.Z);
    paramString.add(new ReflectiveTypeAdapterFactory(c, paramd, paramExcluder, d));
    e = Collections.unmodifiableList(paramString);
  }
  
  public static void a(double paramDouble)
  {
    if ((!Double.isNaN(paramDouble)) && (!Double.isInfinite(paramDouble))) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramDouble);
    localStringBuilder.append(" is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public <T> TypeAdapter<T> a(u paramu, e.c.c.x.a<T> parama)
  {
    Object localObject1 = paramu;
    if (!e.contains(paramu)) {
      localObject1 = d;
    }
    int m = 0;
    paramu = e.iterator();
    while (paramu.hasNext())
    {
      Object localObject2 = (u)paramu.next();
      if (m == 0)
      {
        if (localObject2 == localObject1) {
          m = 1;
        }
      }
      else
      {
        localObject2 = ((u)localObject2).a(this, parama);
        if (localObject2 != null) {
          return (TypeAdapter<T>)localObject2;
        }
      }
    }
    paramu = new StringBuilder();
    paramu.append("GSON cannot serialize ");
    paramu.append(parama);
    throw new IllegalArgumentException(paramu.toString());
  }
  
  public <T> TypeAdapter<T> a(e.c.c.x.a<T> parama)
  {
    Object localObject1 = b;
    if (parama == null) {
      localObject3 = k;
    } else {
      localObject3 = parama;
    }
    Object localObject3 = (TypeAdapter)((Map)localObject1).get(localObject3);
    if (localObject3 != null) {
      return (TypeAdapter<T>)localObject3;
    }
    localObject1 = (Map)a.get();
    int m = 0;
    localObject3 = localObject1;
    if (localObject1 == null)
    {
      localObject3 = new HashMap();
      a.set(localObject3);
      m = 1;
    }
    localObject1 = (FutureTypeAdapter)((Map)localObject3).get(parama);
    if (localObject1 != null) {
      return (TypeAdapter<T>)localObject1;
    }
    try
    {
      FutureTypeAdapter localFutureTypeAdapter = new com/google/gson/Gson$FutureTypeAdapter;
      localFutureTypeAdapter.<init>();
      ((Map)localObject3).put(parama, localFutureTypeAdapter);
      Object localObject4 = e.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject1 = ((u)((Iterator)localObject4).next()).a(this, parama);
        if (localObject1 != null)
        {
          if (a == null)
          {
            a = ((TypeAdapter)localObject1);
            b.put(parama, localObject1);
            return (TypeAdapter<T>)localObject1;
          }
          localObject1 = new java/lang/AssertionError;
          ((AssertionError)localObject1).<init>();
          throw ((Throwable)localObject1);
        }
      }
      localObject1 = new java/lang/IllegalArgumentException;
      localObject4 = new java/lang/StringBuilder;
      ((StringBuilder)localObject4).<init>();
      ((StringBuilder)localObject4).append("GSON (2.8.5) cannot handle ");
      ((StringBuilder)localObject4).append(parama);
      ((IllegalArgumentException)localObject1).<init>(((StringBuilder)localObject4).toString());
      throw ((Throwable)localObject1);
    }
    finally
    {
      ((Map)localObject3).remove(parama);
      if (m != 0) {
        a.remove();
      }
    }
  }
  
  public e.c.c.y.c a(Writer paramWriter)
  {
    if (g) {
      paramWriter.write(")]}'\n");
    }
    paramWriter = new e.c.c.y.c(paramWriter);
    if (i)
    {
      A = "  ";
      B = ": ";
    }
    F = f;
    return paramWriter;
  }
  
  /* Error */
  public <T> T a(e.c.c.y.a parama, Type paramType)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 425	e/c/c/y/a:y	Z
    //   4: istore_3
    //   5: iconst_1
    //   6: istore 4
    //   8: aload_1
    //   9: iconst_1
    //   10: putfield 425	e/c/c/y/a:y	Z
    //   13: aload_1
    //   14: invokevirtual 429	e/c/c/y/a:r	()Le/c/c/y/b;
    //   17: pop
    //   18: iconst_0
    //   19: istore 4
    //   21: aload_0
    //   22: aload_2
    //   23: invokestatic 432	e/c/c/x/a:get	(Ljava/lang/reflect/Type;)Le/c/c/x/a;
    //   26: invokevirtual 434	com/google/gson/Gson:a	(Le/c/c/x/a;)Lcom/google/gson/TypeAdapter;
    //   29: aload_1
    //   30: invokevirtual 438	com/google/gson/TypeAdapter:read	(Le/c/c/y/a;)Ljava/lang/Object;
    //   33: astore_2
    //   34: aload_1
    //   35: iload_3
    //   36: putfield 425	e/c/c/y/a:y	Z
    //   39: aload_2
    //   40: areturn
    //   41: astore_2
    //   42: goto +108 -> 150
    //   45: astore_2
    //   46: new 384	java/lang/AssertionError
    //   49: astore 5
    //   51: new 305	java/lang/StringBuilder
    //   54: astore 6
    //   56: aload 6
    //   58: invokespecial 306	java/lang/StringBuilder:<init>	()V
    //   61: aload 6
    //   63: ldc_w 440
    //   66: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload 6
    //   72: aload_2
    //   73: invokevirtual 443	java/lang/AssertionError:getMessage	()Ljava/lang/String;
    //   76: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload 5
    //   82: aload 6
    //   84: invokevirtual 321	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: aload_2
    //   88: invokespecial 446	java/lang/AssertionError:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   91: aload 5
    //   93: athrow
    //   94: astore_2
    //   95: new 448	e/c/c/s
    //   98: astore 6
    //   100: aload 6
    //   102: aload_2
    //   103: invokespecial 451	e/c/c/s:<init>	(Ljava/lang/Throwable;)V
    //   106: aload 6
    //   108: athrow
    //   109: astore 6
    //   111: new 448	e/c/c/s
    //   114: astore_2
    //   115: aload_2
    //   116: aload 6
    //   118: invokespecial 451	e/c/c/s:<init>	(Ljava/lang/Throwable;)V
    //   121: aload_2
    //   122: athrow
    //   123: astore_2
    //   124: iload 4
    //   126: ifeq +10 -> 136
    //   129: aload_1
    //   130: iload_3
    //   131: putfield 425	e/c/c/y/a:y	Z
    //   134: aconst_null
    //   135: areturn
    //   136: new 448	e/c/c/s
    //   139: astore 6
    //   141: aload 6
    //   143: aload_2
    //   144: invokespecial 451	e/c/c/s:<init>	(Ljava/lang/Throwable;)V
    //   147: aload 6
    //   149: athrow
    //   150: aload_1
    //   151: iload_3
    //   152: putfield 425	e/c/c/y/a:y	Z
    //   155: aload_2
    //   156: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	Gson
    //   0	157	1	parama	e.c.c.y.a
    //   0	157	2	paramType	Type
    //   4	148	3	bool	boolean
    //   6	119	4	m	int
    //   49	43	5	localAssertionError	AssertionError
    //   54	53	6	localObject	Object
    //   109	8	6	localIllegalStateException	IllegalStateException
    //   139	9	6	locals	s
    // Exception table:
    //   from	to	target	type
    //   13	18	41	finally
    //   21	34	41	finally
    //   46	94	41	finally
    //   95	109	41	finally
    //   111	123	41	finally
    //   136	150	41	finally
    //   13	18	45	java/lang/AssertionError
    //   21	34	45	java/lang/AssertionError
    //   13	18	94	java/io/IOException
    //   21	34	94	java/io/IOException
    //   13	18	109	java/lang/IllegalStateException
    //   21	34	109	java/lang/IllegalStateException
    //   13	18	123	java/io/EOFException
    //   21	34	123	java/io/EOFException
  }
  
  public <T> T a(String paramString, Class<T> paramClass)
  {
    paramString = a(paramString, paramClass);
    return (T)e.c.c.w.t.a(paramClass).cast(paramString);
  }
  
  public <T> T a(String paramString, Type paramType)
  {
    if (paramString == null) {
      return null;
    }
    paramString = new e.c.c.y.a(new StringReader(paramString));
    y = j;
    paramType = a(paramString, paramType);
    if (paramType != null) {
      try
      {
        if (paramString.r() != e.c.c.y.b.END_DOCUMENT)
        {
          paramString = new e/c/c/k;
          paramString.<init>("JSON document was not fully consumed.");
          throw paramString;
        }
      }
      catch (IOException paramString)
      {
        throw new k(paramString);
      }
      catch (e.c.c.y.d paramString)
      {
        throw new s(paramString);
      }
    }
    return paramType;
  }
  
  public String a(j paramj)
  {
    StringWriter localStringWriter = new StringWriter();
    try
    {
      a(paramj, a(localStringWriter));
      return localStringWriter.toString();
    }
    catch (IOException paramj)
    {
      throw new k(paramj);
    }
  }
  
  public String a(Object paramObject)
  {
    if (paramObject == null) {
      return a(l.a);
    }
    return a(paramObject, paramObject.getClass());
  }
  
  public String a(Object paramObject, Type paramType)
  {
    StringWriter localStringWriter = new StringWriter();
    try
    {
      a(paramObject, paramType, a(localStringWriter));
      return localStringWriter.toString();
    }
    catch (IOException paramObject)
    {
      throw new k((Throwable)paramObject);
    }
  }
  
  /* Error */
  public void a(j paramj, e.c.c.y.c paramc)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 520	e/c/c/y/c:C	Z
    //   4: istore_3
    //   5: aload_2
    //   6: iconst_1
    //   7: putfield 520	e/c/c/y/c:C	Z
    //   10: aload_2
    //   11: getfield 522	e/c/c/y/c:D	Z
    //   14: istore 4
    //   16: aload_2
    //   17: aload_0
    //   18: getfield 97	com/google/gson/Gson:h	Z
    //   21: putfield 522	e/c/c/y/c:D	Z
    //   24: aload_2
    //   25: getfield 413	e/c/c/y/c:F	Z
    //   28: istore 5
    //   30: aload_2
    //   31: aload_0
    //   32: getfield 93	com/google/gson/Gson:f	Z
    //   35: putfield 413	e/c/c/y/c:F	Z
    //   38: getstatic 525	com/google/gson/internal/bind/TypeAdapters:X	Lcom/google/gson/TypeAdapter;
    //   41: aload_2
    //   42: aload_1
    //   43: invokevirtual 528	com/google/gson/TypeAdapter:write	(Le/c/c/y/c;Ljava/lang/Object;)V
    //   46: aload_2
    //   47: iload_3
    //   48: putfield 520	e/c/c/y/c:C	Z
    //   51: aload_2
    //   52: iload 4
    //   54: putfield 522	e/c/c/y/c:D	Z
    //   57: aload_2
    //   58: iload 5
    //   60: putfield 413	e/c/c/y/c:F	Z
    //   63: return
    //   64: astore_1
    //   65: goto +66 -> 131
    //   68: astore_1
    //   69: new 384	java/lang/AssertionError
    //   72: astore 6
    //   74: new 305	java/lang/StringBuilder
    //   77: astore 7
    //   79: aload 7
    //   81: invokespecial 306	java/lang/StringBuilder:<init>	()V
    //   84: aload 7
    //   86: ldc_w 440
    //   89: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload 7
    //   95: aload_1
    //   96: invokevirtual 443	java/lang/AssertionError:getMessage	()Ljava/lang/String;
    //   99: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload 6
    //   105: aload 7
    //   107: invokevirtual 321	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: aload_1
    //   111: invokespecial 446	java/lang/AssertionError:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   114: aload 6
    //   116: athrow
    //   117: astore 6
    //   119: new 485	e/c/c/k
    //   122: astore_1
    //   123: aload_1
    //   124: aload 6
    //   126: invokespecial 489	e/c/c/k:<init>	(Ljava/lang/Throwable;)V
    //   129: aload_1
    //   130: athrow
    //   131: aload_2
    //   132: iload_3
    //   133: putfield 520	e/c/c/y/c:C	Z
    //   136: aload_2
    //   137: iload 4
    //   139: putfield 522	e/c/c/y/c:D	Z
    //   142: aload_2
    //   143: iload 5
    //   145: putfield 413	e/c/c/y/c:F	Z
    //   148: aload_1
    //   149: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	Gson
    //   0	150	1	paramj	j
    //   0	150	2	paramc	e.c.c.y.c
    //   4	129	3	bool1	boolean
    //   14	124	4	bool2	boolean
    //   28	116	5	bool3	boolean
    //   72	43	6	localAssertionError	AssertionError
    //   117	8	6	localIOException	IOException
    //   77	29	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   38	46	64	finally
    //   69	117	64	finally
    //   119	131	64	finally
    //   38	46	68	java/lang/AssertionError
    //   38	46	117	java/io/IOException
  }
  
  /* Error */
  public void a(Object paramObject, Type paramType, e.c.c.y.c paramc)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: invokestatic 432	e/c/c/x/a:get	(Ljava/lang/reflect/Type;)Le/c/c/x/a;
    //   5: invokevirtual 434	com/google/gson/Gson:a	(Le/c/c/x/a;)Lcom/google/gson/TypeAdapter;
    //   8: astore_2
    //   9: aload_3
    //   10: getfield 520	e/c/c/y/c:C	Z
    //   13: istore 4
    //   15: aload_3
    //   16: iconst_1
    //   17: putfield 520	e/c/c/y/c:C	Z
    //   20: aload_3
    //   21: getfield 522	e/c/c/y/c:D	Z
    //   24: istore 5
    //   26: aload_3
    //   27: aload_0
    //   28: getfield 97	com/google/gson/Gson:h	Z
    //   31: putfield 522	e/c/c/y/c:D	Z
    //   34: aload_3
    //   35: getfield 413	e/c/c/y/c:F	Z
    //   38: istore 6
    //   40: aload_3
    //   41: aload_0
    //   42: getfield 93	com/google/gson/Gson:f	Z
    //   45: putfield 413	e/c/c/y/c:F	Z
    //   48: aload_2
    //   49: aload_3
    //   50: aload_1
    //   51: invokevirtual 528	com/google/gson/TypeAdapter:write	(Le/c/c/y/c;Ljava/lang/Object;)V
    //   54: aload_3
    //   55: iload 4
    //   57: putfield 520	e/c/c/y/c:C	Z
    //   60: aload_3
    //   61: iload 5
    //   63: putfield 522	e/c/c/y/c:D	Z
    //   66: aload_3
    //   67: iload 6
    //   69: putfield 413	e/c/c/y/c:F	Z
    //   72: return
    //   73: astore_1
    //   74: goto +61 -> 135
    //   77: astore_2
    //   78: new 384	java/lang/AssertionError
    //   81: astore_1
    //   82: new 305	java/lang/StringBuilder
    //   85: astore 7
    //   87: aload 7
    //   89: invokespecial 306	java/lang/StringBuilder:<init>	()V
    //   92: aload 7
    //   94: ldc_w 440
    //   97: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload 7
    //   103: aload_2
    //   104: invokevirtual 443	java/lang/AssertionError:getMessage	()Ljava/lang/String;
    //   107: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload_1
    //   112: aload 7
    //   114: invokevirtual 321	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: aload_2
    //   118: invokespecial 446	java/lang/AssertionError:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   121: aload_1
    //   122: athrow
    //   123: astore_1
    //   124: new 485	e/c/c/k
    //   127: astore_2
    //   128: aload_2
    //   129: aload_1
    //   130: invokespecial 489	e/c/c/k:<init>	(Ljava/lang/Throwable;)V
    //   133: aload_2
    //   134: athrow
    //   135: aload_3
    //   136: iload 4
    //   138: putfield 520	e/c/c/y/c:C	Z
    //   141: aload_3
    //   142: iload 5
    //   144: putfield 522	e/c/c/y/c:D	Z
    //   147: aload_3
    //   148: iload 6
    //   150: putfield 413	e/c/c/y/c:F	Z
    //   153: aload_1
    //   154: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	Gson
    //   0	155	1	paramObject	Object
    //   0	155	2	paramType	Type
    //   0	155	3	paramc	e.c.c.y.c
    //   13	124	4	bool1	boolean
    //   24	119	5	bool2	boolean
    //   38	111	6	bool3	boolean
    //   85	28	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   48	54	73	finally
    //   78	123	73	finally
    //   124	135	73	finally
    //   48	54	77	java/lang/AssertionError
    //   48	54	123	java/io/IOException
  }
  
  public j b(Object paramObject)
  {
    if (paramObject == null) {
      return l.a;
    }
    Class localClass = paramObject.getClass();
    e.c.c.w.z.b localb = new e.c.c.w.z.b();
    a(paramObject, localClass, localb);
    return localb.j();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("{serializeNulls:");
    localStringBuilder.append(f);
    localStringBuilder.append(",factories:");
    localStringBuilder.append(e);
    localStringBuilder.append(",instanceCreators:");
    localStringBuilder.append(c);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public static class FutureTypeAdapter<T>
    extends TypeAdapter<T>
  {
    public TypeAdapter<T> a;
    
    public T read(e.c.c.y.a parama)
    {
      TypeAdapter localTypeAdapter = a;
      if (localTypeAdapter != null) {
        return (T)localTypeAdapter.read(parama);
      }
      throw new IllegalStateException();
    }
    
    public void write(e.c.c.y.c paramc, T paramT)
    {
      TypeAdapter localTypeAdapter = a;
      if (localTypeAdapter != null)
      {
        localTypeAdapter.write(paramc, paramT);
        return;
      }
      throw new IllegalStateException();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.gson.Gson
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */