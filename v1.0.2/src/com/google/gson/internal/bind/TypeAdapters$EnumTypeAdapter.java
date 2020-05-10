package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import e.c.c.y.a;
import e.c.c.y.b;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public final class TypeAdapters$EnumTypeAdapter<T extends Enum<T>>
  extends TypeAdapter<T>
{
  public final Map<String, T> a = new HashMap();
  public final Map<T, String> b = new HashMap();
  
  public TypeAdapters$EnumTypeAdapter(Class<T> paramClass)
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
  
  public Object read(a parama)
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

/* Location:
 * Qualified Name:     base.com.google.gson.internal.bind.TypeAdapters.EnumTypeAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */