package e.c.c;

import com.google.gson.DefaultDateTypeAdapter;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.TreeTypeAdapter.SingleTypeFactory;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.bind.TypeAdapters.32;
import e.c.c.x.a;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class e
{
  public Excluder a = Excluder.D;
  public t b = t.DEFAULT;
  public d c = c.IDENTITY;
  public final Map<Type, f<?>> d = new HashMap();
  public final List<u> e = new ArrayList();
  public final List<u> f = new ArrayList();
  public boolean g = false;
  public int h = 2;
  public int i = 2;
  public boolean j = false;
  public boolean k = false;
  public boolean l = true;
  public boolean m = false;
  public boolean n = false;
  public boolean o = false;
  
  public Gson a()
  {
    int i1 = e.size();
    ArrayList localArrayList = new ArrayList(f.size() + i1 + 3);
    localArrayList.addAll(e);
    Collections.reverse(localArrayList);
    Object localObject = new ArrayList(f);
    Collections.reverse((List)localObject);
    localArrayList.addAll((Collection)localObject);
    i1 = h;
    int i2 = i;
    if ((i1 != 2) && (i2 != 2))
    {
      DefaultDateTypeAdapter localDefaultDateTypeAdapter1 = new DefaultDateTypeAdapter(java.util.Date.class, i1, i2);
      localObject = new DefaultDateTypeAdapter(Timestamp.class, i1, i2);
      DefaultDateTypeAdapter localDefaultDateTypeAdapter2 = new DefaultDateTypeAdapter(java.sql.Date.class, i1, i2);
      localArrayList.add(TypeAdapters.a(java.util.Date.class, localDefaultDateTypeAdapter1));
      localArrayList.add(new TypeAdapters.32(Timestamp.class, (TypeAdapter)localObject));
      localArrayList.add(new TypeAdapters.32(java.sql.Date.class, localDefaultDateTypeAdapter2));
    }
    return new Gson(a, c, d, g, j, n, l, m, o, k, b, null, h, i, e, f, localArrayList);
  }
  
  public e a(Type paramType, Object paramObject)
  {
    boolean bool1 = paramObject instanceof r;
    boolean bool2 = false;
    boolean bool3;
    if ((!bool1) && (!(paramObject instanceof i)) && (!(paramObject instanceof f)) && (!(paramObject instanceof TypeAdapter))) {
      bool3 = false;
    } else {
      bool3 = true;
    }
    e.c.a.a.b.l.c.a(bool3);
    if ((paramObject instanceof f)) {
      d.put(paramType, (f)paramObject);
    }
    if ((bool1) || ((paramObject instanceof i)))
    {
      a locala = a.get(paramType);
      List localList = e;
      bool3 = bool2;
      if (locala.getType() == locala.getRawType()) {
        bool3 = true;
      }
      localList.add(new TreeTypeAdapter.SingleTypeFactory(paramObject, locala, bool3, null));
    }
    if ((paramObject instanceof TypeAdapter)) {
      e.add(TypeAdapters.a(a.get(paramType), (TypeAdapter)paramObject));
    }
    return this;
  }
  
  public e b()
  {
    Excluder localExcluder = a.clone();
    A = true;
    a = localExcluder;
    return this;
  }
}

/* Location:
 * Qualified Name:     e.c.c.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */