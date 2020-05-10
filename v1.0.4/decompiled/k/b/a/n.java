package k.b.a;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public abstract class n
  implements e
{
  public void a(OutputStream paramOutputStream)
  {
    paramOutputStream = new r(paramOutputStream);
    c().a(paramOutputStream, true);
  }
  
  public void a(OutputStream paramOutputStream, String paramString)
  {
    r.a(paramOutputStream, paramString).a(this);
  }
  
  public byte[] a(String paramString)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    a(localByteArrayOutputStream, paramString);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public abstract t c();
  
  public byte[] e()
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    a(localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof e)) {
      return false;
    }
    paramObject = (e)paramObject;
    return c().b(((e)paramObject).c());
  }
  
  public int hashCode()
  {
    return c().hashCode();
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.n
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */