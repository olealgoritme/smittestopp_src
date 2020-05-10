package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import e.c.c.u;
import e.c.c.x.a;
import java.sql.Time;

public final class TimeTypeAdapter$1
  implements u
{
  public <T> TypeAdapter<T> a(Gson paramGson, a<T> parama)
  {
    if (parama.getRawType() == Time.class) {
      paramGson = new TimeTypeAdapter();
    } else {
      paramGson = null;
    }
    return paramGson;
  }
}

/* Location:
 * Qualified Name:     base.com.google.gson.internal.bind.TimeTypeAdapter.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */