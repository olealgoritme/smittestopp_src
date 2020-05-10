package com.microsoft.identity.common.internal.util;

import android.util.Pair;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import e.c.c.e;
import e.c.c.y.c;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QueryParamsAdapter
  extends TypeAdapter<List<Pair<String, String>>>
{
  public static final Gson mGson;
  
  static
  {
    e locale = new e();
    locale.a(QueryParamsAdapter.class, new QueryParamsAdapter());
    mGson = locale.a();
  }
  
  public static List<Pair<String, String>> _fromJson(String paramString)
  {
    Type localType = new QueryParamsAdapter.2().getType();
    return (List)mGson.a(paramString, localType);
  }
  
  public static String _toJson(List<Pair<String, String>> paramList)
  {
    Type localType = new QueryParamsAdapter.1().getType();
    return mGson.a(paramList, localType);
  }
  
  public List<Pair<String, String>> read(e.c.c.y.a parama)
  {
    parama.b();
    ArrayList localArrayList = new ArrayList();
    while (parama.h()) {
      localArrayList.add(new Pair(parama.n(), parama.p()));
    }
    parama.f();
    return localArrayList;
  }
  
  public void write(c paramc, List<Pair<String, String>> paramList)
  {
    paramc.c();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Pair localPair = (Pair)paramList.next();
      paramc.a((String)first);
      paramc.c((String)second);
    }
    paramc.e();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.util.QueryParamsAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */