package k.b.a;

import android.os.Build;
import android.os.Build.VERSION;
import i.c;
import i.i.b;
import i.k.b.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class k
{
  public final int a = 500;
  public final List<JSONArray> b = b.b(new JSONArray[] { new JSONArray() });
  public final List<List<Long>> c = b.b(new List[] { new ArrayList() });
  
  public final l a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = b.size();
    for (int j = 0; j < i; j++)
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("appVersion", "1.1.2");
      localJSONObject.put("platform", "android");
      localJSONObject.put("osVersion", Build.VERSION.RELEASE);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Build.MANUFACTURER);
      localStringBuilder.append(' ');
      localStringBuilder.append(Build.MODEL);
      localJSONObject.put("model", localStringBuilder.toString());
      localJSONObject.put("events", b.get(j));
      localArrayList.add(new c(c.get(j), localJSONObject));
    }
    return new l(localArrayList);
  }
  
  public final void a(Long paramLong)
  {
    if (b.a(c) < 0) {
      return;
    }
    if (paramLong != null)
    {
      List localList = c;
      ((List)localList.get(b.a(localList))).add(paramLong);
    }
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      List localList = b;
      if (((JSONArray)localList.get(b.a(localList))).length() >= a)
      {
        b.add(new JSONArray());
        c.add(new ArrayList());
      }
      ((JSONArray)localList.get(b.a(b))).put(paramJSONObject);
      return;
    }
    g.a("measurement");
    throw null;
  }
}

/* Location:
 * Qualified Name:     k.b.a.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */