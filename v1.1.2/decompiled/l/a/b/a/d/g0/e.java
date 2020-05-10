package l.a.b.a.d.g0;

import e.a.a.a.a;
import java.nio.ByteBuffer;
import java.util.Arrays;
import l.a.b.a.c.k0;
import l.a.b.a.c.k0.a;
import l.a.b.a.c.l;
import l.a.b.a.d.n;
import l.a.b.a.d.u;

public class e
  implements l.a.b.a.d.e
{
  public static final k0 V = new k0.a(ByteBuffer.allocate(0));
  public e A;
  public boolean B;
  public e C;
  public e D;
  public boolean E;
  public u F;
  public final byte[] G;
  public final m H;
  public l.a.b.a.b.n.e I;
  public boolean J;
  public boolean K;
  public l.a.b.a.b.n.e L;
  public l.a.b.a.b.n.e M = null;
  public int N = 0;
  public int O = 0;
  public z P;
  public boolean Q;
  public boolean R;
  public boolean S;
  public l T;
  public k0 U;
  public e x;
  public e y;
  public e z;
  
  public e(byte[] paramArrayOfByte, m paramm, e parame)
  {
    G = paramArrayOfByte;
    H = paramm;
    S += 1;
    x = parame;
    if (parame != null) {
      y = this;
    }
  }
  
  public u B()
  {
    if (F == null) {
      F = new r();
    }
    return F;
  }
  
  public boolean D()
  {
    m localm = H;
    boolean bool;
    if (((localm instanceof q)) && (K == this)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean P()
  {
    return Q ^ true;
  }
  
  public void a()
  {
    x();
  }
  
  public void a(l.a.b.a.b.n.e parame)
  {
    I = parame;
    if ((!K) && (!J)) {
      h();
    }
  }
  
  public l.a.b.a.b.n.e e()
  {
    return L;
  }
  
  public byte[] getTag()
  {
    return G;
  }
  
  public void h()
  {
    d locald = H.H.H;
    locald.c(true);
    if (!E)
    {
      C = null;
      e locale = T;
      D = locale;
      if (locale != null) {
        C = this;
      }
      T = this;
      if (S == null) {
        S = this;
      }
      E = true;
      U += 1;
    }
  }
  
  public e k()
  {
    e locale1 = C;
    d locald = H.H.H;
    if (locald != null)
    {
      if (E)
      {
        e locale2 = D;
        if (locale2 != null) {
          C = locale1;
        }
        if (locale1 != null) {
          D = locale2;
        }
        C = null;
        D = null;
        if (S == this) {
          S = locale1;
        }
        if (T == this) {
          T = locale2;
        }
        E = false;
        U -= 1;
      }
      return locale1;
    }
    throw null;
  }
  
  public void l()
  {
    H.H.H.a(this);
  }
  
  public int pending()
  {
    k0 localk0 = U;
    int i;
    if (localk0 == null) {
      i = 0;
    } else {
      i = localk0.c();
    }
    return i;
  }
  
  public n r()
  {
    return H;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = a.a("DeliveryImpl [_tag=");
    localStringBuilder.append(Arrays.toString(G));
    localStringBuilder.append(", _link=");
    localStringBuilder.append(H);
    localStringBuilder.append(", _deliveryState=");
    localStringBuilder.append(I);
    localStringBuilder.append(", _settled=");
    localStringBuilder.append(J);
    localStringBuilder.append(", _remoteSettled=");
    localStringBuilder.append(K);
    localStringBuilder.append(", _remoteDeliveryState=");
    localStringBuilder.append(L);
    localStringBuilder.append(", _flags=");
    localStringBuilder.append(O);
    localStringBuilder.append(", _defaultDeliveryState=");
    localStringBuilder.append(M);
    localStringBuilder.append(", _transportDelivery=");
    localStringBuilder.append(P);
    localStringBuilder.append(", _data Size=");
    k0 localk0 = U;
    int i;
    if (localk0 == null) {
      i = 0;
    } else {
      i = localk0.c();
    }
    localStringBuilder.append(i);
    localStringBuilder.append(", _complete=");
    localStringBuilder.append(Q);
    localStringBuilder.append(", _updated=");
    localStringBuilder.append(R);
    localStringBuilder.append(", _done=");
    localStringBuilder.append(S);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public boolean u()
  {
    return J;
  }
  
  public void x()
  {
    if (J) {
      return;
    }
    J = true;
    Object localObject = H;
    S -= 1;
    if (!K) {
      h();
    } else {
      P.a();
    }
    localObject = H;
    if (K == this) {
      ((m)localObject).d();
    }
    localObject = H;
    if (I == this) {
      I = y;
    }
    if (J == this) {
      J = x;
    }
    localObject = x;
    if (localObject != null) {
      y = y;
    }
    localObject = y;
    if (localObject != null) {
      x = x;
    }
    l();
    y = null;
    x = null;
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.d.g0.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */