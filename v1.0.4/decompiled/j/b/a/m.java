package j.b.a;

import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import h.k.b.g;

public final class m
  implements Response.ErrorListener
{
  public m(h.b paramb) {}
  
  public final void onErrorResponse(VolleyError paramVolleyError)
  {
    h.b localb = x;
    if (localb != null)
    {
      g.a(paramVolleyError, "error");
      localb.a(paramVolleyError);
    }
  }
}

/* Location:
 * Qualified Name:     base.j.b.a.m
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */