package e.c.a.a.d.c;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import e.c.a.a.b.i.d.a;
import e.c.a.a.b.i.d.b;
import e.c.a.a.b.j.d;
import e.c.a.a.b.j.h;

public class v
  extends h<g>
{
  public final String x;
  public final w<g> y = new w(this);
  
  public v(Context paramContext, Looper paramLooper, d.a parama, d.b paramb, String paramString, d paramd)
  {
    super(paramContext, paramLooper, 23, paramd, parama, paramb);
    x = paramString;
  }
  
  public int c()
  {
    return 11925000;
  }
  
  public Bundle j()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("client_name", x);
    return localBundle;
  }
  
  public String l()
  {
    return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
  }
  
  public String m()
  {
    return "com.google.android.location.internal.GoogleLocationManagerService.START";
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.d.c.v
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */