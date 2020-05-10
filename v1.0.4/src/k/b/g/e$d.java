package k.b.g;

import java.io.IOException;
import k.b.a.l2.s;
import k.b.a.r0;
import k.b.a.u;

public class e$d
  implements d
{
  public c a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = u.a(paramArrayOfByte);
      if ((paramArrayOfByte instanceof k.b.a.j2.a)) {
        paramArrayOfByte = (k.b.a.j2.a)paramArrayOfByte;
      } else if (paramArrayOfByte != null) {
        paramArrayOfByte = new k.b.a.j2.a(u.a(paramArrayOfByte));
      } else {
        paramArrayOfByte = null;
      }
      k.b.a.l2.a locala = new k/b/a/l2/a;
      locala.<init>(k.b.a.m2.f.m, paramArrayOfByte.a(0));
      k.b.a.i2.f localf = new k/b/a/i2/f;
      localf.<init>(locala, paramArrayOfByte, null, null);
      if ((r0)paramArrayOfByte.a(1) != null)
      {
        s locals = new k/b/a/l2/s;
        locals.<init>(locala, ((r0)paramArrayOfByte.a(1)).j());
        return new c(locals, localf);
      }
      paramArrayOfByte = new c(null, localf);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      throw new b(e.a.a.a.a.a(paramArrayOfByte, e.a.a.a.a.a("problem creating EC private key: ")), paramArrayOfByte);
    }
    catch (IOException paramArrayOfByte)
    {
      throw paramArrayOfByte;
    }
  }
}

/* Location:
 * Qualified Name:     base.k.b.g.e.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */