package j.b.a;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.JsonObjectRequest;
import e.a.a.a.a;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

public final class k
  extends JsonObjectRequest
{
  public k(String paramString1, h.b paramb, int paramInt, String paramString2, JSONObject paramJSONObject, Response.Listener paramListener, Response.ErrorListener paramErrorListener)
  {
    super(paramInt, paramString2, paramJSONObject, paramListener, paramErrorListener);
  }
  
  public Map<String, String> getHeaders()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    StringBuilder localStringBuilder = a.a("Bearer ");
    localStringBuilder.append(x);
    localLinkedHashMap.put("Authorization", localStringBuilder.toString());
    return localLinkedHashMap;
  }
}

/* Location:
 * Qualified Name:     base.j.b.a.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */