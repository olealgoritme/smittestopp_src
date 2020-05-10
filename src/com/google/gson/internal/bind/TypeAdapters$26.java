package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import e.c.c.u;
import e.c.c.x.a;
import java.sql.Timestamp;
import java.util.Date;

public final class TypeAdapters$26
  implements u
{
  public <T> TypeAdapter<T> a(Gson paramGson, a<T> parama)
  {
    if (parama.getRawType() != Timestamp.class) {
      return null;
    }
    if (paramGson != null) {
      return new TypeAdapters.26.1(this, paramGson.a(a.get(Date.class)));
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     base.com.google.gson.internal.bind.TypeAdapters.26
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */