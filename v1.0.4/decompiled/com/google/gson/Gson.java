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
  public final ThreadLocal<Map<e.c.c.x.a<?>, Gson.FutureTypeAdapter<?>>> a = new ThreadLocal();
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
    localObject1 = (Gson.FutureTypeAdapter)((Map)localObject3).get(parama);
    if (localObject1 != null) {
      return (TypeAdapter<T>)localObject1;
    }
    try
    {
      Object localObject4 = new com/google/gson/Gson$FutureTypeAdapter;
      ((Gson.FutureTypeAdapter)localObject4).<init>();
      ((Map)localObject3).put(parama, localObject4);
      localObject1 = e.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        TypeAdapter localTypeAdapter = ((u)((Iterator)localObject1).next()).a(this, parama);
        if (localTypeAdapter != null)
        {
          if (a == null)
          {
            a = localTypeAdapter;
            b.put(parama, localTypeAdapter);
            return localTypeAdapter;
          }
          localObject1 = new java/lang/AssertionError;
          ((AssertionError)localObject1).<init>();
          throw ((Throwable)localObject1);
        }
      }
      localObject4 = new java/lang/IllegalArgumentException;
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      ((StringBuilder)localObject1).append("GSON (2.8.5) cannot handle ");
      ((StringBuilder)localObject1).append(parama);
      ((IllegalArgumentException)localObject4).<init>(((StringBuilder)localObject1).toString());
      throw ((Throwable)localObject4);
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
    //   42: goto +107 -> 149
    //   45: astore 5
    //   47: new 384	java/lang/AssertionError
    //   50: astore_2
    //   51: new 305	java/lang/StringBuilder
    //   54: astore 6
    //   56: aload 6
    //   58: invokespecial 306	java/lang/StringBuilder:<init>	()V
    //   61: aload 6
    //   63: ldc_w 440
    //   66: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload 6
    //   72: aload 5
    //   74: invokevirtual 443	java/lang/AssertionError:getMessage	()Ljava/lang/String;
    //   77: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload_2
    //   82: aload 6
    //   84: invokevirtual 321	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: aload 5
    //   89: invokespecial 446	java/lang/AssertionError:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   92: aload_2
    //   93: athrow
    //   94: astore 6
    //   96: new 448	e/c/c/s
    //   99: astore_2
    //   100: aload_2
    //   101: aload 6
    //   103: invokespecial 451	e/c/c/s:<init>	(Ljava/lang/Throwable;)V
    //   106: aload_2
    //   107: athrow
    //   108: astore 6
    //   110: new 448	e/c/c/s
    //   113: astore_2
    //   114: aload_2
    //   115: aload 6
    //   117: invokespecial 451	e/c/c/s:<init>	(Ljava/lang/Throwable;)V
    //   120: aload_2
    //   121: athrow
    //   122: astore_2
    //   123: iload 4
    //   125: ifeq +10 -> 135
    //   128: aload_1
    //   129: iload_3
    //   130: putfield 425	e/c/c/y/a:y	Z
    //   133: aconst_null
    //   134: areturn
    //   135: new 448	e/c/c/s
    //   138: astore 6
    //   140: aload 6
    //   142: aload_2
    //   143: invokespecial 451	e/c/c/s:<init>	(Ljava/lang/Throwable;)V
    //   146: aload 6
    //   148: athrow
    //   149: aload_1
    //   150: iload_3
    //   151: putfield 425	e/c/c/y/a:y	Z
    //   154: aload_2
    //   155: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	Gson
    //   0	156	1	parama	e.c.c.y.a
    //   0	156	2	paramType	Type
    //   4	147	3	bool	boolean
    //   6	118	4	m	int
    //   45	43	5	localAssertionError	AssertionError
    //   54	29	6	localStringBuilder	StringBuilder
    //   94	8	6	localIOException	IOException
    //   108	8	6	localIllegalStateException	IllegalStateException
    //   138	9	6	locals	s
    // Exception table:
    //   from	to	target	type
    //   13	18	41	finally
    //   21	34	41	finally
    //   47	94	41	finally
    //   96	108	41	finally
    //   110	122	41	finally
    //   135	149	41	finally
    //   13	18	45	java/lang/AssertionError
    //   21	34	45	java/lang/AssertionError
    //   13	18	94	java/io/IOException
    //   21	34	94	java/io/IOException
    //   13	18	108	java/lang/IllegalStateException
    //   21	34	108	java/lang/IllegalStateException
    //   13	18	122	java/io/EOFException
    //   21	34	122	java/io/EOFException
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
    //   65: goto +65 -> 130
    //   68: astore 6
    //   70: new 384	java/lang/AssertionError
    //   73: astore 7
    //   75: new 305	java/lang/StringBuilder
    //   78: astore_1
    //   79: aload_1
    //   80: invokespecial 306	java/lang/StringBuilder:<init>	()V
    //   83: aload_1
    //   84: ldc_w 440
    //   87: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload_1
    //   92: aload 6
    //   94: invokevirtual 443	java/lang/AssertionError:getMessage	()Ljava/lang/String;
    //   97: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload 7
    //   103: aload_1
    //   104: invokevirtual 321	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: aload 6
    //   109: invokespecial 446	java/lang/AssertionError:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   112: aload 7
    //   114: athrow
    //   115: astore_1
    //   116: new 485	e/c/c/k
    //   119: astore 6
    //   121: aload 6
    //   123: aload_1
    //   124: invokespecial 489	e/c/c/k:<init>	(Ljava/lang/Throwable;)V
    //   127: aload 6
    //   129: athrow
    //   130: aload_2
    //   131: iload_3
    //   132: putfield 520	e/c/c/y/c:C	Z
    //   135: aload_2
    //   136: iload 4
    //   138: putfield 522	e/c/c/y/c:D	Z
    //   141: aload_2
    //   142: iload 5
    //   144: putfield 413	e/c/c/y/c:F	Z
    //   147: aload_1
    //   148: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	this	Gson
    //   0	149	1	paramj	j
    //   0	149	2	paramc	e.c.c.y.c
    //   4	128	3	bool1	boolean
    //   14	123	4	bool2	boolean
    //   28	115	5	bool3	boolean
    //   68	40	6	localAssertionError1	AssertionError
    //   119	9	6	localk	k
    //   73	40	7	localAssertionError2	AssertionError
    // Exception table:
    //   from	to	target	type
    //   38	46	64	finally
    //   70	115	64	finally
    //   116	130	64	finally
    //   38	46	68	java/lang/AssertionError
    //   38	46	115	java/io/IOException
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
    //   74: goto +59 -> 133
    //   77: astore_2
    //   78: new 384	java/lang/AssertionError
    //   81: astore 7
    //   83: new 305	java/lang/StringBuilder
    //   86: astore_1
    //   87: aload_1
    //   88: invokespecial 306	java/lang/StringBuilder:<init>	()V
    //   91: aload_1
    //   92: ldc_w 440
    //   95: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload_1
    //   100: aload_2
    //   101: invokevirtual 443	java/lang/AssertionError:getMessage	()Ljava/lang/String;
    //   104: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload 7
    //   110: aload_1
    //   111: invokevirtual 321	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: aload_2
    //   115: invokespecial 446	java/lang/AssertionError:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   118: aload 7
    //   120: athrow
    //   121: astore_1
    //   122: new 485	e/c/c/k
    //   125: astore_2
    //   126: aload_2
    //   127: aload_1
    //   128: invokespecial 489	e/c/c/k:<init>	(Ljava/lang/Throwable;)V
    //   131: aload_2
    //   132: athrow
    //   133: aload_3
    //   134: iload 4
    //   136: putfield 520	e/c/c/y/c:C	Z
    //   139: aload_3
    //   140: iload 5
    //   142: putfield 522	e/c/c/y/c:D	Z
    //   145: aload_3
    //   146: iload 6
    //   148: putfield 413	e/c/c/y/c:F	Z
    //   151: aload_1
    //   152: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	Gson
    //   0	153	1	paramObject	Object
    //   0	153	2	paramType	Type
    //   0	153	3	paramc	e.c.c.y.c
    //   13	122	4	bool1	boolean
    //   24	117	5	bool2	boolean
    //   38	109	6	bool3	boolean
    //   81	38	7	localAssertionError	AssertionError
    // Exception table:
    //   from	to	target	type
    //   48	54	73	finally
    //   78	121	73	finally
    //   122	133	73	finally
    //   48	54	77	java/lang/AssertionError
    //   48	54	121	java/io/IOException
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
}

/* Location:
 * Qualified Name:     base.com.google.gson.Gson
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */