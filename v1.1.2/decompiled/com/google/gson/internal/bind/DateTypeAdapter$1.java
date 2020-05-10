package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import e.c.c.u;
import e.c.c.x.a;
import java.util.Date;

public final class DateTypeAdapter$1
  implements u
{
  public <T> TypeAdapter<T> a(Gson paramGson, a<T> parama)
  {
    if (parama.getRawType() == Date.class) {
      paramGson = new DateTypeAdapter();
    } else {
      paramGson = null;
    }
    return paramGson;
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.DateTypeAdapter.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */