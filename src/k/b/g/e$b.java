package k.b.g;

import java.io.IOException;
import k.b.a.e;
import k.b.a.l;
import k.b.a.l2.h;
import k.b.a.l2.s;
import k.b.a.o;
import k.b.a.u;

public class e$b
  implements d
{
  public c a(byte[] paramArrayOfByte)
  {
    try
    {
      Object localObject1 = u.a(paramArrayOfByte);
      if (((u)localObject1).size() == 6)
      {
        paramArrayOfByte = l.a(((u)localObject1).a(1));
        l locall1 = l.a(((u)localObject1).a(2));
        l locall2 = l.a(((u)localObject1).a(3));
        Object localObject2 = l.a(((u)localObject1).a(4));
        localObject1 = l.a(((u)localObject1).a(5));
        s locals = new k/b/a/l2/s;
        Object localObject3 = new k/b/a/l2/a;
        Object localObject4 = k.b.a.m2.f.r;
        Object localObject5 = new k/b/a/l2/h;
        ((h)localObject5).<init>(paramArrayOfByte.j(), locall1.j(), locall2.j());
        ((k.b.a.l2.a)localObject3).<init>((o)localObject4, (e)localObject5);
        locals.<init>((k.b.a.l2.a)localObject3, (e)localObject2);
        localObject2 = new k/b/a/i2/f;
        localObject4 = new k/b/a/l2/a;
        localObject5 = k.b.a.m2.f.r;
        localObject3 = new k/b/a/l2/h;
        ((h)localObject3).<init>(paramArrayOfByte.j(), locall1.j(), locall2.j());
        ((k.b.a.l2.a)localObject4).<init>((o)localObject5, (e)localObject3);
        ((k.b.a.i2.f)localObject2).<init>((k.b.a.l2.a)localObject4, (e)localObject1, null, null);
        return new c(locals, (k.b.a.i2.f)localObject2);
      }
      paramArrayOfByte = new k/b/g/b;
      paramArrayOfByte.<init>("malformed sequence in DSA private key");
      throw paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      throw new b(e.a.a.a.a.a(paramArrayOfByte, e.a.a.a.a.a("problem creating DSA private key: ")), paramArrayOfByte);
    }
    catch (IOException paramArrayOfByte)
    {
      throw paramArrayOfByte;
    }
  }
}

/* Location:
 * Qualified Name:     base.k.b.g.e.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */