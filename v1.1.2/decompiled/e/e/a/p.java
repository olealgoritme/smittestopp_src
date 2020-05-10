package e.e.a;

import e.e.a.v.a;
import java.io.Serializable;
import java.text.ParseException;

public final class p
  implements Serializable
{
  public final e.e.a.v.c A;
  public final n B;
  public final j.a.b.d x;
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
      paramc = a.BASE64URL;
      return;
    }
    throw new IllegalArgumentException("The Base64URL-encoded object must not be null");
  }
  
  public p(j.a.b.d paramd)
  {
    if (paramd != null)
    {
      x = paramd;
      y = null;
      z = null;
      A = null;
      B = null;
      paramd = a.JSON;
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
        localObject = localc.c();
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
  
  public j.a.b.d c()
  {
    Object localObject = x;
    if (localObject != null) {
      return (j.a.b.d)localObject;
    }
    localObject = toString();
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = e.c.a.a.b.l.c.b((String)localObject);
      return (j.a.b.d)localObject;
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
      return B.c();
    }
    localObject = x;
    if (localObject != null) {
      return ((j.a.b.d)localObject).toString();
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
  
  public static enum a
  {
    static
    {
      BYTE_ARRAY = new a("BYTE_ARRAY", 2);
      BASE64URL = new a("BASE64URL", 3);
      JWS_OBJECT = new a("JWS_OBJECT", 4);
      a locala = new a("SIGNED_JWT", 5);
      SIGNED_JWT = locala;
      $VALUES = new a[] { JSON, STRING, BYTE_ARRAY, BASE64URL, JWS_OBJECT, locala };
    }
    
    public a() {}
  }
}

/* Location:
 * Qualified Name:     e.e.a.p
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */