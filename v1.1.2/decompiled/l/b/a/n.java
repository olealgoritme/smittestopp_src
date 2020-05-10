package l.b.a;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public abstract class n
  implements e
{
  public void a(OutputStream paramOutputStream)
  {
    paramOutputStream = new r(paramOutputStream);
    b().a(paramOutputStream, true);
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
  
  public abstract t b();
  
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
    return b().b(((e)paramObject).b());
  }
  
  public int hashCode()
  {
    return b().hashCode();
  }
}

/* Location:
 * Qualified Name:     l.b.a.n
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */