package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import e.c.c.y.a;
import e.c.c.y.b;
import e.c.c.y.c;
import java.util.Locale;
import java.util.StringTokenizer;

public final class TypeAdapters$28
  extends TypeAdapter<Locale>
{
  public Object read(a parama)
  {
    b localb = parama.r();
    Object localObject = b.NULL;
    String str1 = null;
    String str2 = null;
    if (localb == localObject)
    {
      parama.o();
      parama = str1;
    }
    else
    {
      localObject = new StringTokenizer(parama.p(), "_");
      if (((StringTokenizer)localObject).hasMoreElements()) {
        parama = ((StringTokenizer)localObject).nextToken();
      } else {
        parama = null;
      }
      if (((StringTokenizer)localObject).hasMoreElements()) {
        str1 = ((StringTokenizer)localObject).nextToken();
      } else {
        str1 = null;
      }
      if (((StringTokenizer)localObject).hasMoreElements()) {
        str2 = ((StringTokenizer)localObject).nextToken();
      }
      if ((str1 == null) && (str2 == null)) {
        parama = new Locale(parama);
      } else if (str2 == null) {
        parama = new Locale(parama, str1);
      } else {
        parama = new Locale(parama, str1, str2);
      }
    }
    return parama;
  }
  
  public void write(c paramc, Object paramObject)
  {
    paramObject = (Locale)paramObject;
    if (paramObject == null) {
      paramObject = null;
    } else {
      paramObject = ((Locale)paramObject).toString();
    }
    paramc.c((String)paramObject);
  }
}

/* Location:
 * Qualified Name:     base.com.google.gson.internal.bind.TypeAdapters.28
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */