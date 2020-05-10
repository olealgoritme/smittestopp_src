package l.b.g;

import java.io.IOException;
import l.b.a.i2.f;
import l.b.a.i2.g;
import l.b.a.i2.h;
import l.b.a.l2.s;
import l.b.a.u;
import l.b.a.y0;

public class e$k
  implements d
{
  public c a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = u.a(paramArrayOfByte);
      if (paramArrayOfByte.size() == 9)
      {
        if ((paramArrayOfByte instanceof g)) {
          paramArrayOfByte = (g)paramArrayOfByte;
        } else {
          paramArrayOfByte = new g(u.a(paramArrayOfByte));
        }
        Object localObject = new l/b/a/i2/h;
        ((h)localObject).<init>(y, z);
        l.b.a.l2.a locala = new l/b/a/l2/a;
        locala.<init>(l.b.a.i2.e.b, y0.x);
        s locals = new l/b/a/l2/s;
        locals.<init>(locala, (l.b.a.e)localObject);
        localObject = new l/b/a/i2/f;
        ((f)localObject).<init>(locala, paramArrayOfByte, null, null);
        return new c(locals, (f)localObject);
      }
      paramArrayOfByte = new l/b/g/b;
      paramArrayOfByte.<init>("malformed sequence in RSA private key");
      throw paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      throw new b(e.a.a.a.a.a(paramArrayOfByte, e.a.a.a.a.a("problem creating RSA private key: ")), paramArrayOfByte);
    }
    catch (IOException paramArrayOfByte)
    {
      throw paramArrayOfByte;
    }
  }
}

/* Location:
 * Qualified Name:     l.b.g.e.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */