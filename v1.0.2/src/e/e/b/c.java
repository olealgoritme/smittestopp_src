package e.e.b;

import i.a.b.d;
import i.a.b.i;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

public final class c
  implements Serializable
{
  public final Map<String, Object> x;
  
  static
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("iss");
    localHashSet.add("sub");
    localHashSet.add("aud");
    localHashSet.add("exp");
    localHashSet.add("nbf");
    localHashSet.add("iat");
    localHashSet.add("jti");
    Collections.unmodifiableSet(localHashSet);
  }
  
  public static c a(d paramd)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Iterator localIterator = paramd.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if (((String)localObject).equals("iss"))
      {
        localLinkedHashMap.put("iss", e.c.a.a.b.l.c.d(paramd, "iss"));
      }
      else if (((String)localObject).equals("sub"))
      {
        localLinkedHashMap.put("sub", e.c.a.a.b.l.c.d(paramd, "sub"));
      }
      else if (((String)localObject).equals("aud"))
      {
        localObject = paramd.get("aud");
        if ((localObject instanceof String))
        {
          localObject = new ArrayList();
          ((ArrayList)localObject).add(e.c.a.a.b.l.c.d(paramd, "aud"));
          localLinkedHashMap.put("aud", localObject);
        }
        else if ((localObject instanceof List))
        {
          localLinkedHashMap.put("aud", e.c.a.a.b.l.c.e(paramd, "aud"));
        }
        else if (localObject == null)
        {
          localLinkedHashMap.put("aud", null);
        }
      }
      else if (((String)localObject).equals("exp"))
      {
        localLinkedHashMap.put("exp", new Date(e.c.a.a.b.l.c.c(paramd, "exp") * 1000L));
      }
      else if (((String)localObject).equals("nbf"))
      {
        localLinkedHashMap.put("nbf", new Date(e.c.a.a.b.l.c.c(paramd, "nbf") * 1000L));
      }
      else if (((String)localObject).equals("iat"))
      {
        localLinkedHashMap.put("iat", new Date(e.c.a.a.b.l.c.c(paramd, "iat") * 1000L));
      }
      else if (((String)localObject).equals("jti"))
      {
        localLinkedHashMap.put("jti", e.c.a.a.b.l.c.d(paramd, "jti"));
      }
      else
      {
        localLinkedHashMap.put(localObject, paramd.get(localObject));
      }
    }
    return new c(localLinkedHashMap, null);
  }
  
  public d a()
  {
    d locald = new d();
    Iterator localIterator = x.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Map.Entry)localIterator.next();
      Object localObject2;
      if ((((Map.Entry)localObject1).getValue() instanceof Date))
      {
        localObject2 = (Date)((Map.Entry)localObject1).getValue();
        locald.put(((Map.Entry)localObject1).getKey(), Long.valueOf(((Date)localObject2).getTime() / 1000L));
      }
      else
      {
        List localList;
        if ("aud".equals(((Map.Entry)localObject1).getKey()))
        {
          localObject1 = x.get("aud");
          if ((localObject1 instanceof String)) {
            localObject1 = Collections.singletonList((String)localObject1);
          } else {
            try
            {
              localObject1 = a("aud");
              if (localObject1 != null) {
                localObject1 = Collections.unmodifiableList((List)localObject1);
              } else {
                localObject1 = Collections.emptyList();
              }
            }
            catch (ParseException localParseException)
            {
              localList = Collections.emptyList();
            }
          }
          if ((localList != null) && (!localList.isEmpty())) {
            if (localList.size() == 1)
            {
              locald.put("aud", localList.get(0));
            }
            else
            {
              localObject2 = new i.a.b.a();
              ((ArrayList)localObject2).addAll(localList);
              locald.put("aud", localObject2);
            }
          }
        }
        else if (localList.getValue() != null)
        {
          locald.put(localList.getKey(), localList.getValue());
        }
      }
    }
    return locald;
  }
  
  public List<String> a(String paramString)
  {
    Object localObject;
    if (x.get(paramString) == null) {
      localObject = null;
    }
    try
    {
      List localList = (List)x.get(paramString);
      int i = localList.size();
      String[] arrayOfString = new String[i];
      int j = 0;
      for (;;)
      {
        localObject = arrayOfString;
        if (j < i) {
          try
          {
            arrayOfString[j] = ((String)localList.get(j));
            j++;
          }
          catch (ClassCastException localClassCastException1)
          {
            throw new ParseException(e.a.a.a.a.a("The \"", paramString, "\" claim is not a list / JSON array of strings"), 0);
          }
        }
      }
      if (localClassCastException1 == null) {
        return null;
      }
      return Collections.unmodifiableList(Arrays.asList(localClassCastException1));
    }
    catch (ClassCastException localClassCastException2)
    {
      throw new ParseException(e.a.a.a.a.a("The \"", paramString, "\" claim is not a list / JSON array"), 0);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof c)) {
      return false;
    }
    paramObject = (c)paramObject;
    return Objects.equals(x, x);
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { x });
  }
  
  public String toString()
  {
    return d.a(a(), i.a);
  }
}

/* Location:
 * Qualified Name:     base.e.e.b.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */