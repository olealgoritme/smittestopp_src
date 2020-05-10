package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import e.c.c.y.a;
import e.c.c.y.c;
import java.util.Currency;

public final class TypeAdapters$25
  extends TypeAdapter<Currency>
{
  public Object read(a parama)
  {
    return Currency.getInstance(parama.p());
  }
  
  public void write(c paramc, Object paramObject)
  {
    paramc.c(((Currency)paramObject).getCurrencyCode());
  }
}

/* Location:
 * Qualified Name:     base.com.google.gson.internal.bind.TypeAdapters.25
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */