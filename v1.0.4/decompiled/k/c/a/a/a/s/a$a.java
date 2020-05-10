package k.c.a.a.a.s;

import k.c.a.a.a.k;
import k.c.a.a.a.q;
import k.c.a.a.a.t.b;

public class a$a
  implements Runnable
{
  public String A;
  public a x = null;
  public q y;
  public k.c.a.a.a.s.s.d z;
  
  public a$a(a parama1, a parama2, q paramq, k.c.a.a.a.s.s.d paramd)
  {
    x = parama2;
    y = paramq;
    z = paramd;
    parama2 = new StringBuilder("MQTT Con: ");
    parama2.append(c).y);
    A = parama2.toString();
  }
  
  public void run()
  {
    Thread.currentThread().setName(A);
    a locala = B;
    b.b(a, "connectBG:run", "220");
    locala = null;
    try
    {
      Object localObject2 = B.m.c();
      int i = localObject2.length;
      for (int j = 0;; j++)
      {
        if (j >= i)
        {
          B.m.a(y, z);
          localObject2 = B.e[B.d];
          ((i)localObject2).start();
          Object localObject3 = B;
          Object localObject4 = new k/c/a/a/a/s/d;
          ((d)localObject4).<init>(x, B.i, B.m, ((i)localObject2).b());
          f = ((d)localObject4);
          localObject3 = B.f;
          localObject4 = new java/lang/StringBuilder;
          ((StringBuilder)localObject4).<init>("MQTT Rec: ");
          ((StringBuilder)localObject4).append(B.c).y);
          ((d)localObject3).a(((StringBuilder)localObject4).toString(), B.r);
          localObject4 = B;
          localObject3 = new k/c/a/a/a/s/e;
          ((e)localObject3).<init>(x, B.i, B.m, ((i)localObject2).a());
          g = ((e)localObject3);
          localObject4 = B.g;
          localObject2 = new java/lang/StringBuilder;
          ((StringBuilder)localObject2).<init>("MQTT Snd: ");
          ((StringBuilder)localObject2).append(B.c).y);
          ((e)localObject4).a(((StringBuilder)localObject2).toString(), B.r);
          localObject2 = B.h;
          localObject4 = new java/lang/StringBuilder;
          ((StringBuilder)localObject4).<init>("MQTT Call: ");
          ((StringBuilder)localObject4).append(B.c).y);
          ((c)localObject2).a(((StringBuilder)localObject4).toString(), B.r);
          B.a(z, y);
          break;
        }
        a.a(null);
      }
      Object localObject1;
      if (localk == null) {
        return;
      }
    }
    catch (Exception localException)
    {
      localObject2 = B;
      b.a(a, "connectBG:run", "209", null, localException);
      if (localException.getClass().getName().equals("java.security.GeneralSecurityException")) {
        localObject1 = new k.c.a.a.a.p(localException);
      } else {
        localObject1 = new k((Throwable)localObject1);
      }
    }
    catch (k localk)
    {
      localObject2 = B;
      b.a(a, "connectBG:run", "212", null, localk);
    }
    B.a(y, localk);
  }
}

/* Location:
 * Qualified Name:     base.k.c.a.a.a.s.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */