package e.c.a.a.b.i.k;

import android.util.Log;
import e.c.a.a.b.a;
import e.c.a.a.b.i.a.f;
import e.c.a.a.b.j.q;
import java.util.Set;

public final class z
  implements Runnable
{
  public z(x paramx, e.c.a.a.f.b.k paramk) {}
  
  public final void run()
  {
    x localx = y;
    Object localObject1 = x;
    if (localx != null)
    {
      Object localObject2 = y;
      if (((a)localObject2).b())
      {
        Object localObject3 = z;
        localObject1 = z;
        if (!((a)localObject1).b())
        {
          localObject3 = String.valueOf(localObject1);
          localObject2 = new StringBuilder(((String)localObject3).length() + 48);
          ((StringBuilder)localObject2).append("Sign-in succeeded with resolve account failure: ");
          ((StringBuilder)localObject2).append((String)localObject3);
          Log.wtf("SignInCoordinator", ((StringBuilder)localObject2).toString(), new Exception());
          ((c.c)g).b((a)localObject1);
          f.e();
          break label244;
        }
        localObject2 = g;
        localObject3 = ((q)localObject3).b();
        localObject1 = d;
        localObject2 = (c.c)localObject2;
        if (localObject2 != null)
        {
          if ((localObject3 != null) && (localObject1 != null))
          {
            c = ((e.c.a.a.b.j.k)localObject3);
            d = ((Set)localObject1);
            if (e) {
              a.a((e.c.a.a.b.j.k)localObject3, (Set)localObject1);
            }
          }
          else
          {
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            ((c.c)localObject2).b(new a(4));
          }
        }
        else {
          throw null;
        }
      }
      else
      {
        ((c.c)g).b((a)localObject2);
      }
      f.e();
      label244:
      return;
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.b.i.k.z
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */