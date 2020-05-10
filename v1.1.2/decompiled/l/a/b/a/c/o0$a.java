package l.a.b.a.c;

import java.nio.ByteBuffer;
import java.util.Map;
import l.a.b.a.b.f;

public class o0$a
  implements r.b<f>
{
  public o0$a(o0 paramo0) {}
  
  public Object a(r paramr, k0 paramk0)
  {
    Object localObject = (f)a.c.get(paramk0);
    paramr = (r)localObject;
    if (localObject == null)
    {
      localObject = new byte[paramk0.a()];
      paramk0.a((byte[])localObject);
      paramr = f.a(new String((byte[])localObject, o0.e));
      a.c.put(new k0.a(ByteBuffer.wrap((byte[])localObject)), paramr);
    }
    return paramr;
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.o0.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */