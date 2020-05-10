package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import e.c.c.u;
import e.c.c.x.a;
import java.sql.Date;

public final class SqlDateTypeAdapter$1
  implements u
{
  public <T> TypeAdapter<T> a(Gson paramGson, a<T> parama)
  {
    if (parama.getRawType() == Date.class) {
      paramGson = new SqlDateTypeAdapter();
    } else {
      paramGson = null;
    }
    return paramGson;
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.SqlDateTypeAdapter.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */