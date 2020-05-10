package j.b.a;

import com.android.volley.Response.Listener;
import org.json.JSONObject;

public final class l<T>
  implements Response.Listener<JSONObject>
{
  public l(h.b paramb) {}
  
  public void onResponse(Object paramObject)
  {
    JSONObject localJSONObject = (JSONObject)paramObject;
    paramObject = x;
    if (paramObject != null) {
      ((h.b)paramObject).a(localJSONObject, false);
    }
  }
}

/* Location:
 * Qualified Name:     base.j.b.a.l
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */