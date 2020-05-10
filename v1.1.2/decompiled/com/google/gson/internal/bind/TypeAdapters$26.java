package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import e.c.c.u;
import e.c.c.y.c;
import java.sql.Timestamp;
import java.util.Date;

public final class TypeAdapters$26
  implements u
{
  public <T> TypeAdapter<T> a(Gson paramGson, e.c.c.x.a<T> parama)
  {
    if (parama.getRawType() != Timestamp.class) {
      return null;
    }
    if (paramGson != null) {
      new TypeAdapter()
      {
        public Object read(e.c.c.y.a paramAnonymousa)
        {
          paramAnonymousa = (Date)a.read(paramAnonymousa);
          if (paramAnonymousa != null) {
            paramAnonymousa = new Timestamp(paramAnonymousa.getTime());
          } else {
            paramAnonymousa = null;
          }
          return paramAnonymousa;
        }
        
        public void write(c paramAnonymousc, Object paramAnonymousObject)
        {
          paramAnonymousObject = (Timestamp)paramAnonymousObject;
          a.write(paramAnonymousc, paramAnonymousObject);
        }
      };
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.26
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */