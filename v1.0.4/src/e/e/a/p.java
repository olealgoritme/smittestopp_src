package e.e.a;

import e.e.a.v.a;
import java.io.Serializable;
import java.text.ParseException;

public final class p
  implements Serializable
{
  public final e.e.a.v.c A;
  public final n B;
  public final i.a.b.d x;
  public final String y;
  public final byte[] z;
  
  public p(e.e.a.v.c paramc)
  {
    if (paramc != null)
    {
      x = null;
      y = null;
      z = null;
      A = paramc;
      B = null;
      paramc = p.a.BASE64URL;
      return;
    }
    throw new IllegalArgumentException("The Base64URL-encoded object must not be null");
  }
  
  public p(i.a.b.d paramd)
  {
    if (paramd != null)
    {
      x = paramd;
      y = null;
      z = null;
      A = null;
      B = null;
      paramd = p.a.JSON;
      return;
    }
    throw new IllegalArgumentException("The JSON object must not be null");
  }
  
  public e.e.a.v.c a()
  {
    e.e.a.v.c localc = A;
    if (localc != null) {
      return localc;
    }
    Object localObject = z;
    if (localObject == null) {
      if (localc != null)
      {
        localObject = localc.b();
      }
      else
      {
        localObject = toString();
        if (localObject != null) {
          localObject = ((String)localObject).getBytes(e.e.a.v.d.a);
        } else {
          localObject = null;
        }
      }
    }
    return e.e.a.v.c.a((byte[])localObject);
  }
  
  public i.a.b.d b()
  {
    Object localObject = x;
    if (localObject != null) {
      return (i.a.b.d)localObject;
    }
    localObject = toString();
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = e.c.a.a.b.l.c.b((String)localObject);
      return (i.a.b.d)localObject;
    }
    catch (ParseException localParseException) {}
    return null;
  }
  
  public String toString()
  {
    Object localObject = y;
    if (localObject != null) {
      return (String)localObject;
    }
    localObject = B;
    if (localObject != null)
    {
      if (((g)localObject).a() != null) {
        return B.a();
      }
      return B.b();
    }
    localObject = x;
    if (localObject != null) {
      return ((i.a.b.d)localObject).toString();
    }
    byte[] arrayOfByte = z;
    localObject = null;
    if (arrayOfByte != null)
    {
      if (arrayOfByte != null) {
        localObject = new String(arrayOfByte, e.e.a.v.d.a);
      }
      return (String)localObject;
    }
    localObject = A;
    if (localObject != null) {
      return ((a)localObject).e();
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     base.e.e.a.p
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */