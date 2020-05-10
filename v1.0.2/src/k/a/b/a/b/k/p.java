package k.a.b.a.b.k;

import java.util.Date;
import k.a.b.a.b.f;
import k.a.b.a.b.h;

public final class p
  implements t
{
  public Object a;
  public k.a.b.a.b.a b;
  public String c;
  public String d;
  public String e;
  public Object f;
  public f g;
  public f h;
  public Date i;
  public Date j;
  public String k;
  public h l;
  public String m;
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("Properties{messageId=");
    localStringBuilder.append(a);
    localStringBuilder.append(", userId=");
    localStringBuilder.append(b);
    localStringBuilder.append(", to='");
    e.a.a.a.a.a(localStringBuilder, c, '\'', ", subject='");
    e.a.a.a.a.a(localStringBuilder, d, '\'', ", replyTo='");
    e.a.a.a.a.a(localStringBuilder, e, '\'', ", correlationId=");
    localStringBuilder.append(f);
    localStringBuilder.append(", contentType=");
    localStringBuilder.append(g);
    localStringBuilder.append(", contentEncoding=");
    localStringBuilder.append(h);
    localStringBuilder.append(", absoluteExpiryTime=");
    localStringBuilder.append(i);
    localStringBuilder.append(", creationTime=");
    localStringBuilder.append(j);
    localStringBuilder.append(", groupId='");
    e.a.a.a.a.a(localStringBuilder, k, '\'', ", groupSequence=");
    localStringBuilder.append(l);
    localStringBuilder.append(", replyToGroupId='");
    localStringBuilder.append(m);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.b.k.p
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */