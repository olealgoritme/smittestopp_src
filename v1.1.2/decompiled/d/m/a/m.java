package d.m.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import d.b.a.s;

public abstract class m<E>
  extends i
{
  public final p A = new r();
  public final Activity x;
  public final Context y;
  public final Handler z;
  
  public m(c paramc)
  {
    x = paramc;
    s.a(paramc, "context == null");
    y = paramc;
    s.a(localHandler, "handler == null");
    z = localHandler;
  }
}

/* Location:
 * Qualified Name:     d.m.a.m
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */