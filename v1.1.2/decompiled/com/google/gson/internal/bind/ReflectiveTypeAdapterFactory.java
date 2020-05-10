package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.Excluder;
import e.c.c.u;
import e.c.c.v.e;
import e.c.c.w.g;
import e.c.c.w.t;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ReflectiveTypeAdapterFactory
  implements u
{
  public final JsonAdapterAnnotationTypeAdapterFactory A;
  public final e.c.c.w.a0.b B = e.c.c.w.a0.b.a;
  public final g x;
  public final e.c.c.d y;
  public final Excluder z;
  
  public ReflectiveTypeAdapterFactory(g paramg, e.c.c.d paramd, Excluder paramExcluder, JsonAdapterAnnotationTypeAdapterFactory paramJsonAdapterAnnotationTypeAdapterFactory)
  {
    x = paramg;
    y = paramd;
    z = paramExcluder;
    A = paramJsonAdapterAnnotationTypeAdapterFactory;
  }
  
  public <T> TypeAdapter<T> a(Gson paramGson, e.c.c.x.a<T> parama)
  {
    Class localClass = Object.class;
    Object localObject1 = parama.getRawType();
    if (!Object.class.isAssignableFrom((Class)localObject1)) {
      return null;
    }
    Object localObject2 = x.a(parama);
    Object localObject3 = new com/google/gson/internal/bind/ReflectiveTypeAdapterFactory$Adapter;
    Object localObject4 = new LinkedHashMap();
    Object localObject5;
    Object localObject6;
    if (((Class)localObject1).isInterface())
    {
      localObject5 = localObject3;
      localObject6 = localObject4;
    }
    else
    {
      localObject5 = parama.getType();
      Object localObject7 = parama;
      Object localObject8 = localObject2;
      parama = (e.c.c.x.a<T>)localObject5;
      for (;;)
      {
        localObject6 = localObject4;
        localObject5 = localObject3;
        localObject2 = localObject8;
        if (localObject1 == localClass) {
          break;
        }
        localObject2 = ((Class)localObject1).getDeclaredFields();
        int i = localObject2.length;
        int j = 0;
        Object localObject10;
        for (;;)
        {
          localObject5 = this;
          if (j >= i) {
            break label687;
          }
          localObject6 = localObject2[j];
          boolean bool1 = ((ReflectiveTypeAdapterFactory)localObject5).a((Field)localObject6, true);
          boolean bool2 = ((ReflectiveTypeAdapterFactory)localObject5).a((Field)localObject6, false);
          if ((!bool1) && (!bool2))
          {
            localObject6 = localObject2;
            localObject5 = localObject1;
            localObject2 = parama;
            parama = (e.c.c.x.a<T>)localObject3;
            localObject3 = localObject8;
            localObject1 = localObject4;
            localObject4 = localObject6;
            localObject8 = localObject5;
          }
          else
          {
            B.a((AccessibleObject)localObject6);
            Type localType = e.c.c.w.a.a(((e.c.c.x.a)localObject7).getType(), (Class)localObject1, ((Field)localObject6).getGenericType());
            Object localObject9 = (e.c.c.v.c)((Field)localObject6).getAnnotation(e.c.c.v.c.class);
            if (localObject9 == null)
            {
              localObject5 = Collections.singletonList(y.translateName((Field)localObject6));
            }
            else
            {
              localObject10 = ((e.c.c.v.c)localObject9).value();
              localObject9 = ((e.c.c.v.c)localObject9).alternate();
              if (localObject9.length != 0) {
                break label291;
              }
              localObject5 = Collections.singletonList(localObject10);
            }
            break label345;
            label291:
            localObject5 = new ArrayList(localObject9.length + 1);
            ((ArrayList)localObject5).add(localObject10);
            int k = localObject9.length;
            for (int m = 0; m < k; m++) {
              ((ArrayList)localObject5).add(localObject9[m]);
            }
            label345:
            m = ((List)localObject5).size();
            k = 0;
            localObject10 = null;
            localObject9 = localObject5;
            localObject5 = localObject6;
            for (;;)
            {
              Gson localGson = paramGson;
              localObject6 = this;
              if (k >= m) {
                break;
              }
              String str = (String)((List)localObject9).get(k);
              if (k != 0) {
                bool1 = false;
              }
              e.c.c.x.a locala = e.c.c.x.a.get(localType);
              Object localObject11 = locala.getRawType();
              boolean bool3 = t.a.containsKey(localObject11);
              localObject11 = (e.c.c.v.b)((Field)localObject5).getAnnotation(e.c.c.v.b.class);
              if (localObject11 != null) {
                localObject6 = A.a(x, localGson, locala, (e.c.c.v.b)localObject11);
              } else {
                localObject6 = null;
              }
              boolean bool4;
              if (localObject6 != null) {
                bool4 = true;
              } else {
                bool4 = false;
              }
              localObject11 = localObject6;
              if (localObject6 == null) {
                localObject11 = localGson.a(locala);
              }
              localObject11 = (a)((HashMap)localObject4).put(str, new e.c.c.w.z.c(this, str, bool1, bool2, (Field)localObject5, bool4, (TypeAdapter)localObject11, paramGson, locala, bool3));
              localObject6 = localObject10;
              if (localObject10 == null) {
                localObject6 = localObject11;
              }
              k++;
              localObject10 = localObject6;
            }
            localObject5 = localObject2;
            localObject6 = localObject1;
            localObject2 = parama;
            localObject1 = localObject4;
            parama = (e.c.c.x.a<T>)localObject3;
            localObject3 = localObject8;
            if (localObject10 != null) {
              break;
            }
            localObject8 = localObject6;
            localObject4 = localObject5;
          }
          j++;
          localObject6 = localObject8;
          localObject5 = localObject2;
          localObject10 = localObject1;
          localObject8 = localObject3;
          localObject3 = parama;
          localObject2 = localObject4;
          localObject1 = localObject6;
          parama = (e.c.c.x.a<T>)localObject5;
          localObject4 = localObject10;
        }
        paramGson = new StringBuilder();
        paramGson.append(localObject2);
        paramGson.append(" declares multiple JSON fields named ");
        paramGson.append(a);
        throw new IllegalArgumentException(paramGson.toString());
        label687:
        localObject7 = e.c.c.x.a.get(e.c.c.w.a.a(((e.c.c.x.a)localObject7).getType(), (Class)localObject1, ((Class)localObject1).getGenericSuperclass()));
        localObject1 = ((e.c.c.x.a)localObject7).getRawType();
      }
    }
    ((Adapter)localObject5).<init>((e.c.c.w.s)localObject2, (Map)localObject6);
    return (TypeAdapter<T>)localObject5;
  }
  
  public boolean a(Field paramField, boolean paramBoolean)
  {
    Object localObject1 = z;
    Object localObject2 = paramField.getType();
    boolean bool1 = ((Excluder)localObject1).a((Class)localObject2);
    boolean bool2 = true;
    int i;
    if ((!bool1) && (!((Excluder)localObject1).a((Class)localObject2, paramBoolean))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0)
    {
      if (((y & paramField.getModifiers()) == 0) && ((x == -1.0D) || (((Excluder)localObject1).a((e.c.c.v.d)paramField.getAnnotation(e.c.c.v.d.class), (e)paramField.getAnnotation(e.class)))) && (!paramField.isSynthetic())) {
        if (A)
        {
          localObject2 = (e.c.c.v.a)paramField.getAnnotation(e.c.c.v.a.class);
          if ((localObject2 == null) || (paramBoolean ? !((e.c.c.v.a)localObject2).serialize() : !((e.c.c.v.a)localObject2).deserialize())) {}
        }
        else if (((z) || (!((Excluder)localObject1).c(paramField.getType()))) && (!((Excluder)localObject1).b(paramField.getType())))
        {
          if (paramBoolean) {
            localObject1 = B;
          } else {
            localObject1 = C;
          }
          if (((List)localObject1).isEmpty()) {
            break label281;
          }
          paramField = new e.c.c.b(paramField);
          localObject1 = ((List)localObject1).iterator();
        }
      }
      while (((Iterator)localObject1).hasNext()) {
        if (((e.c.c.a)((Iterator)localObject1).next()).a(paramField))
        {
          i = 1;
          break label284;
        }
      }
      label281:
      i = 0;
      label284:
      if (i == 0) {
        return bool2;
      }
    }
    paramBoolean = false;
    return paramBoolean;
  }
  
  public static final class Adapter<T>
    extends TypeAdapter<T>
  {
    public final e.c.c.w.s<T> a;
    public final Map<String, ReflectiveTypeAdapterFactory.a> b;
    
    public Adapter(e.c.c.w.s<T> params, Map<String, ReflectiveTypeAdapterFactory.a> paramMap)
    {
      a = params;
      b = paramMap;
    }
    
    public T read(e.c.c.y.a parama)
    {
      if (parama.r() == e.c.c.y.b.NULL)
      {
        parama.o();
        return null;
      }
      Object localObject1 = a.a();
      try
      {
        parama.b();
        while (parama.h())
        {
          Object localObject2 = parama.n();
          localObject2 = (ReflectiveTypeAdapterFactory.a)b.get(localObject2);
          if ((localObject2 != null) && (c))
          {
            e.c.c.w.z.c localc = (e.c.c.w.z.c)localObject2;
            localObject2 = f.read(parama);
            if ((localObject2 != null) || (!i)) {
              d.set(localObject1, localObject2);
            }
          }
          else
          {
            parama.u();
          }
        }
        parama.f();
        return (T)localObject1;
      }
      catch (IllegalAccessException parama)
      {
        throw new AssertionError(parama);
      }
      catch (IllegalStateException parama)
      {
        throw new e.c.c.s(parama);
      }
    }
    
    public void write(e.c.c.y.c paramc, T paramT)
    {
      if (paramT == null)
      {
        paramc.g();
        return;
      }
      paramc.c();
      try
      {
        Iterator localIterator = b.values().iterator();
        while (localIterator.hasNext())
        {
          Object localObject1 = (ReflectiveTypeAdapterFactory.a)localIterator.next();
          Object localObject2 = (e.c.c.w.z.c)localObject1;
          boolean bool = b;
          int i = 0;
          if ((bool) && (d.get(paramT) != paramT)) {
            i = 1;
          }
          if (i != 0)
          {
            paramc.a(a);
            localObject1 = (e.c.c.w.z.c)localObject1;
            localObject2 = d.get(paramT);
            if (e) {
              localObject1 = f;
            } else {
              localObject1 = new TypeAdapterRuntimeTypeWrapper(g, f, h.getType());
            }
            ((TypeAdapter)localObject1).write(paramc, localObject2);
          }
        }
        paramc.e();
        return;
      }
      catch (IllegalAccessException paramc)
      {
        throw new AssertionError(paramc);
      }
    }
  }
  
  public static abstract class a
  {
    public final String a;
    public final boolean b;
    public final boolean c;
    
    public a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      a = paramString;
      b = paramBoolean1;
      c = paramBoolean2;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.ReflectiveTypeAdapterFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */