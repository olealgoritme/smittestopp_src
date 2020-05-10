package g.e;

import g.a.d.c;
import g.a.d.d;
import g.c.k.a;
import g.d.b;
import java.nio.ByteBuffer;

public abstract interface d$a
{
  static
  {
    c.F_GETFL.intValue();
    c.F_SETFL.intValue();
    d.O_NONBLOCK.intValue();
  }
  
  public abstract int a(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract int a(int paramInt1, int paramInt2, int paramInt3, b paramb, a parama);
  
  public abstract int a(int paramInt1, int paramInt2, int paramInt3, ByteBuffer paramByteBuffer, int paramInt4);
  
  public abstract int a(int paramInt1, int paramInt2, int paramInt3, ByteBuffer paramByteBuffer, a parama);
  
  public abstract int a(int paramInt1, e parame, int paramInt2);
  
  public abstract int a(int paramInt, e parame, a parama);
  
  public abstract String a(int paramInt);
  
  public abstract int b(int paramInt1, e parame, int paramInt2);
  
  public abstract int b(int paramInt, e parame, a parama);
}

/* Location:
 * Qualified Name:     base.g.e.d.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */