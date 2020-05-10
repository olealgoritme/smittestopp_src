package k.a.b.a.d.g0;

import e.c.a.a.b.l.c;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;
import k.a.b.a.b.f;
import k.a.b.a.b.l.c.a;
import k.a.b.a.c.r;
import k.a.b.a.c.x;
import k.a.b.a.d.w;

public class v
  implements k.a.b.a.d.v, c.a<Void>, t, d0
{
  public static final Logger y = Logger.getLogger(v.class.getName());
  public final r b;
  public final x c;
  public final a0 d;
  public boolean e;
  public boolean f;
  public final int g;
  public final j h;
  public ByteBuffer i;
  public boolean j;
  public k.a.b.a.b.a k;
  public u l;
  public boolean m;
  public boolean n;
  public boolean o;
  public k.a.b.a.d.v.a p;
  public k.a.b.a.d.v.b q;
  public String r;
  public boolean s;
  public f[] t;
  public f u;
  public v.b v;
  public boolean w;
  public w x;
  
  public v(a0 parama0, int paramInt)
  {
    Object localObject = new r();
    b = ((r)localObject);
    localObject = new x((r)localObject);
    c = ((x)localObject);
    e = false;
    f = false;
    p = k.a.b.a.d.v.a.PN_SASL_NONE;
    q = k.a.b.a.d.v.b.PN_SASL_IDLE;
    w = true;
    d = parama0;
    g = paramInt;
    c.a(b, (x)localObject);
    l = new u(this, b, paramInt, d);
    h = new j(c, paramInt, (byte)1, d);
  }
  
  public void a()
  {
    v = v.b.CLIENT;
    f[] arrayOff = t;
    if (arrayOff != null) {
      u = arrayOff[0];
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    a();
    u = f.a("PLAIN");
    paramString1 = paramString1.getBytes(StandardCharsets.UTF_8);
    byte[] arrayOfByte = paramString2.getBytes(StandardCharsets.UTF_8);
    paramString2 = new byte[paramString1.length + arrayOfByte.length + 2];
    System.arraycopy(paramString1, 0, paramString2, 1, paramString1.length);
    System.arraycopy(arrayOfByte, 0, paramString2, paramString1.length + 2, arrayOfByte.length);
    k = new k.a.b.a.b.a(paramString2);
  }
  
  public final void a(v.b paramb)
  {
    if (paramb == v) {
      return;
    }
    StringBuilder localStringBuilder = e.a.a.a.a.a("Role is ");
    localStringBuilder.append(v);
    localStringBuilder.append(" but should be ");
    localStringBuilder.append(paramb);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public void a(String... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      t = new f[paramVarArgs.length];
      for (int i1 = 0; i1 < paramVarArgs.length; i1++) {
        t[i1] = f.a(paramVarArgs[i1]);
      }
    }
    if (v == v.b.CLIENT) {
      u = f.a(paramVarArgs[0]);
    }
  }
  
  public boolean b()
  {
    boolean bool;
    if ((s) && ((v == v.b.CLIENT) || (m))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("SaslImpl [_outcome=");
    localStringBuilder.append(p);
    localStringBuilder.append(", state=");
    localStringBuilder.append(q);
    localStringBuilder.append(", done=");
    localStringBuilder.append(s);
    localStringBuilder.append(", role=");
    localStringBuilder.append(v);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public l0 wrap(b0 paramb0, f0 paramf0)
  {
    return new v.a(this, new v.d(this, paramb0, paramf0, null), new o(paramf0, paramb0));
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.d.g0.v
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */