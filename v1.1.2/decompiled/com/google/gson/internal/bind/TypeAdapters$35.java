package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import e.c.c.s;
import e.c.c.u;
import e.c.c.y.c;

public final class TypeAdapters$35
  implements u
{
  public TypeAdapters$35(Class paramClass, TypeAdapter paramTypeAdapter) {}
  
  public <T2> TypeAdapter<T2> a(final Gson paramGson, e.c.c.x.a<T2> parama)
  {
    paramGson = parama.getRawType();
    if (!x.isAssignableFrom(paramGson)) {
      return null;
    }
    new TypeAdapter()
    {
      public T1 read(e.c.c.y.a paramAnonymousa)
      {
        paramAnonymousa = y.read(paramAnonymousa);
        if ((paramAnonymousa != null) && (!paramGson.isInstance(paramAnonymousa)))
        {
          StringBuilder localStringBuilder = e.a.a.a.a.a("Expected a ");
          localStringBuilder.append(paramGson.getName());
          localStringBuilder.append(" but was ");
          localStringBuilder.append(paramAnonymousa.getClass().getName());
          throw new s(localStringBuilder.toString());
        }
        return paramAnonymousa;
      }
      
      public void write(c paramAnonymousc, T1 paramAnonymousT1)
      {
        y.write(paramAnonymousc, paramAnonymousT1);
      }
    };
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("Factory[typeHierarchy=");
    localStringBuilder.append(x.getName());
    localStringBuilder.append(",adapter=");
    localStringBuilder.append(y);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.35
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */