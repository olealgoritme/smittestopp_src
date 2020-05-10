package k.b.j.g;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class a
{
  public static final d a = new b();
  
  public static byte[] a(String paramString)
  {
    Object localObject = new ByteArrayOutputStream(paramString.length() / 4 * 3);
    try
    {
      a.a(paramString, (OutputStream)localObject);
      return ((ByteArrayOutputStream)localObject).toByteArray();
    }
    catch (Exception paramString)
    {
      localObject = e.a.a.a.a.a("unable to decode base64 string: ");
      ((StringBuilder)localObject).append(paramString.getMessage());
      throw new c(((StringBuilder)localObject).toString(), paramString);
    }
  }
}

/* Location:
 * Qualified Name:     base.k.b.j.g.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */