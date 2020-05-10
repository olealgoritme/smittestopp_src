package k.b.a;

import com.android.volley.Response.Listener;
import org.json.JSONObject;

public final class i<T>
  implements Response.Listener<JSONObject>
{
  public i(e.b paramb) {}
  
  public void onResponse(Object paramObject)
  {
    JSONObject localJSONObject = (JSONObject)paramObject;
    paramObject = x;
    if (paramObject != null) {
      ((e.b)paramObject).a(localJSONObject, false);
    }
  }
}

/* Location:
 * Qualified Name:     k.b.a.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */