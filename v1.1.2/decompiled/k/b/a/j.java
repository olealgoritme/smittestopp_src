package k.b.a;

import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import i.k.b.g;

public final class j
  implements Response.ErrorListener
{
  public j(e.b paramb) {}
  
  public final void onErrorResponse(VolleyError paramVolleyError)
  {
    e.b localb = x;
    if (localb != null)
    {
      g.a(paramVolleyError, "error");
      localb.a(paramVolleyError);
    }
  }
}

/* Location:
 * Qualified Name:     k.b.a.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */