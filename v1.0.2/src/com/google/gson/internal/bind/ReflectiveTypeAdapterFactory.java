package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.Excluder;
import e.c.c.u;
import e.c.c.v.e;
import e.c.c.w.g;
import e.c.c.w.s;
import e.c.c.w.t;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
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
    Class localClass1 = Object.class;
    Class localClass2 = parama.getRawType();
    if (!Object.class.isAssignableFrom(localClass2)) {
      return null;
    }
    Object localObject1 = x.a(parama);
    Object localObject2 = new com/google/gson/internal/bind/ReflectiveTypeAdapterFactory$Adapter;
    Object localObject3 = new LinkedHashMap();
    Object localObject4;
    Object localObject5;
    if (localClass2.isInterface())
    {
      localObject4 = localObject2;
      localObject5 = localObject3;
    }
    else
    {
      localObject4 = parama.getType();
      Object localObject6 = parama;
      Object localObject7 = localObject1;
      parama = (e.c.c.x.a<T>)localObject2;
      localObject2 = localObject4;
      for (;;)
      {
        localObject5 = localObject3;
        localObject4 = parama;
        localObject1 = localObject7;
        if (localClass2 == localClass1) {
          break;
        }
        localObject1 = localClass2.getDeclaredFields();
        int i = localObject1.length;
        int j = 0;
        Object localObject9;
        for (;;)
        {
          localObject4 = this;
          if (j >= i) {
            break label668;
          }
          localObject5 = localObject1[j];
          boolean bool1 = ((ReflectiveTypeAdapterFactory)localObject4).a((Field)localObject5, true);
          boolean bool2 = ((ReflectiveTypeAdapterFactory)localObject4).a((Field)localObject5, false);
          if ((!bool1) && (!bool2))
          {
            localObject4 = localObject1;
            localObject5 = localObject7;
            localObject7 = localObject2;
            localObject1 = localObject3;
            localObject3 = localObject5;
            localObject2 = localObject4;
          }
          else
          {
            B.a((AccessibleObject)localObject5);
            Type localType = e.c.c.w.a.a(((e.c.c.x.a)localObject6).getType(), localClass2, ((Field)localObject5).getGenericType());
            Object localObject8 = (e.c.c.v.c)((Field)localObject5).getAnnotation(e.c.c.v.c.class);
            if (localObject8 == null)
            {
              localObject4 = Collections.singletonList(y.translateName((Field)localObject5));
            }
            else
            {
              localObject9 = ((e.c.c.v.c)localObject8).value();
              localObject8 = ((e.c.c.v.c)localObject8).alternate();
              if (localObject8.length != 0) {
                break label288;
              }
              localObject4 = Collections.singletonList(localObject9);
            }
            break label342;
            label288:
            localObject4 = new ArrayList(localObject8.length + 1);
            ((ArrayList)localObject4).add(localObject9);
            int k = localObject8.length;
            for (int m = 0; m < k; m++) {
              ((ArrayList)localObject4).add(localObject8[m]);
            }
            label342:
            k = ((List)localObject4).size();
            m = 0;
            localObject9 = null;
            localObject8 = localObject4;
            localObject4 = localObject5;
            for (;;)
            {
              Gson localGson = paramGson;
              localObject5 = this;
              if (m >= k) {
                break;
              }
              String str = (String)((List)localObject8).get(m);
              if (m != 0) {
                bool1 = false;
              }
              e.c.c.x.a locala = e.c.c.x.a.get(localType);
              Object localObject10 = locala.getRawType();
              boolean bool3 = t.a.containsKey(localObject10);
              localObject10 = (e.c.c.v.b)((Field)localObject4).getAnnotation(e.c.c.v.b.class);
              if (localObject10 != null) {
                localObject5 = A.a(x, localGson, locala, (e.c.c.v.b)localObject10);
              } else {
                localObject5 = null;
              }
              boolean bool4;
              if (localObject5 != null) {
                bool4 = true;
              } else {
                bool4 = false;
              }
              localObject10 = localObject5;
              if (localObject5 == null) {
                localObject10 = localGson.a(locala);
              }
              localObject10 = (ReflectiveTypeAdapterFactory.a)((HashMap)localObject3).put(str, new e.c.c.w.z.c(this, str, bool1, bool2, (Field)localObject4, bool4, (TypeAdapter)localObject10, paramGson, locala, bool3));
              localObject5 = localObject9;
              if (localObject9 == null) {
                localObject5 = localObject10;
              }
              m++;
              localObject9 = localObject5;
            }
            localObject4 = localObject2;
            localObject5 = localObject3;
            localObject3 = localObject7;
            if (localObject9 != null) {
              break;
            }
            localObject2 = localObject1;
            localObject1 = localObject5;
            localObject7 = localObject4;
          }
          j++;
          localObject4 = localObject7;
          localObject5 = localObject1;
          localObject7 = localObject3;
          localObject1 = localObject2;
          localObject2 = localObject4;
          localObject3 = localObject5;
        }
        paramGson = new StringBuilder();
        paramGson.append(localObject4);
        paramGson.append(" declares multiple JSON fields named ");
        paramGson.append(a);
        throw new IllegalArgumentException(paramGson.toString());
        label668:
        localObject6 = e.c.c.x.a.get(e.c.c.w.a.a(((e.c.c.x.a)localObject6).getType(), localClass2, localClass2.getGenericSuperclass()));
        localClass2 = ((e.c.c.x.a)localObject6).getRawType();
      }
    }
    ((ReflectiveTypeAdapterFactory.Adapter)localObject4).<init>((s)localObject1, (Map)localObject5);
    return (TypeAdapter<T>)localObject4;
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
}

/* Location:
 * Qualified Name:     base.com.google.gson.internal.bind.ReflectiveTypeAdapterFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */