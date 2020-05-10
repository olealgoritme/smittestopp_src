package k.a.b.a.b.n;

import java.util.Arrays;
import java.util.Map;
import k.a.b.a.b.f;
import k.a.b.a.b.h;
import k.a.b.a.b.j;
import k.a.b.a.d.g;
import k.a.b.a.d.g0.a0;
import k.a.b.a.d.g0.d;
import k.a.b.a.d.h.b;

public final class m
  implements l
{
  public String a;
  public String b;
  public h c = h.a(-1);
  public j d = j.a((short)-1);
  public h e;
  public f[] f;
  public f[] g;
  public f[] h;
  public f[] i;
  public Map j;
  
  public void a(String paramString)
  {
    if (paramString != null)
    {
      a = paramString;
      return;
    }
    throw new NullPointerException("the container-id field is mandatory");
  }
  
  public <E> void a(l.a<E> parama, k.a.b.a.b.a parama1, E paramE)
  {
    parama = (a0)parama;
    if (parama != null)
    {
      parama1 = (Integer)paramE;
      paramE = g.ACTIVE;
      y = paramE;
      parama1 = J;
      if (parama1 != null)
      {
        y = paramE;
        parama1.a(h.b.CONNECTION_REMOTE_OPEN, parama1);
      }
      else
      {
        Z = this;
      }
      int k = U;
      if (c.longValue() > 0L)
      {
        U = ((int)c.longValue());
        k = (int)Math.min(c.longValue(), 2147483647L);
      }
      if (V > 0) {
        k = (int)Math.min(c.longValue(), V);
      }
      X.d = k;
      if (d.longValue() > 0L) {
        d.longValue();
      }
      parama1 = e;
      if ((parama1 != null) && (parama1.longValue() > 0L)) {
        o0 = e.x;
      }
      return;
    }
    throw null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("Open{ containerId='");
    e.a.a.a.a.a(localStringBuilder, a, '\'', ", hostname='");
    e.a.a.a.a.a(localStringBuilder, b, '\'', ", maxFrameSize=");
    localStringBuilder.append(c);
    localStringBuilder.append(", channelMax=");
    localStringBuilder.append(d);
    localStringBuilder.append(", idleTimeOut=");
    localStringBuilder.append(e);
    localStringBuilder.append(", outgoingLocales=");
    Object localObject1 = f;
    Object localObject2 = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = Arrays.asList((Object[])localObject1);
    }
    localStringBuilder.append(localObject1);
    localStringBuilder.append(", incomingLocales=");
    localObject1 = g;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = Arrays.asList((Object[])localObject1);
    }
    localStringBuilder.append(localObject1);
    localStringBuilder.append(", offeredCapabilities=");
    localObject1 = h;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = Arrays.asList((Object[])localObject1);
    }
    localStringBuilder.append(localObject1);
    localStringBuilder.append(", desiredCapabilities=");
    localObject1 = i;
    if (localObject1 == null) {
      localObject1 = localObject2;
    } else {
      localObject1 = Arrays.asList((Object[])localObject1);
    }
    localStringBuilder.append(localObject1);
    localStringBuilder.append(", properties=");
    localStringBuilder.append(j);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.b.n.m
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */