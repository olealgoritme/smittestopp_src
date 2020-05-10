package l.b.g;

import java.io.IOException;
import l.b.a.e;
import l.b.a.l;
import l.b.a.l2.h;
import l.b.a.l2.s;
import l.b.a.o;
import l.b.a.u;

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
        l locall1 = l.a(((u)localObject1).a(1));
        paramArrayOfByte = l.a(((u)localObject1).a(2));
        l locall2 = l.a(((u)localObject1).a(3));
        Object localObject2 = l.a(((u)localObject1).a(4));
        l locall3 = l.a(((u)localObject1).a(5));
        localObject1 = new l/b/a/l2/s;
        Object localObject3 = new l/b/a/l2/a;
        o localo = l.b.a.m2.f.r;
        Object localObject4 = new l/b/a/l2/h;
        ((h)localObject4).<init>(locall1.j(), paramArrayOfByte.j(), locall2.j());
        ((l.b.a.l2.a)localObject3).<init>(localo, (e)localObject4);
        ((s)localObject1).<init>((l.b.a.l2.a)localObject3, (e)localObject2);
        localObject4 = new l/b/a/i2/f;
        localObject2 = new l/b/a/l2/a;
        localo = l.b.a.m2.f.r;
        localObject3 = new l/b/a/l2/h;
        ((h)localObject3).<init>(locall1.j(), paramArrayOfByte.j(), locall2.j());
        ((l.b.a.l2.a)localObject2).<init>(localo, (e)localObject3);
        ((l.b.a.i2.f)localObject4).<init>((l.b.a.l2.a)localObject2, locall3, null, null);
        return new c((s)localObject1, (l.b.a.i2.f)localObject4);
      }
      paramArrayOfByte = new l/b/g/b;
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
 * Qualified Name:     l.b.g.e.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */