package l.b.j.g;

import e.a.a.a.a;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class f
{
  public static final g a = new g();
  
  public static byte[] a(String paramString)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      a.a(paramString, localByteArrayOutputStream);
      return localByteArrayOutputStream.toByteArray();
    }
    catch (Exception localException)
    {
      paramString = a.a("exception decoding Hex string: ");
      paramString.append(localException.getMessage());
      throw new c(paramString.toString(), localException);
    }
  }
  
  public static byte[] a(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      paramString = a.a(paramString, paramInt1, paramInt2);
      return paramString;
    }
    catch (Exception localException)
    {
      paramString = a.a("exception decoding Hex string: ");
      paramString.append(localException.getMessage());
      throw new c(paramString.toString(), localException);
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      g localg = a;
      if (localg != null)
      {
        for (int i = paramInt1; i < paramInt1 + paramInt2; i++)
        {
          int j = paramArrayOfByte[i] & 0xFF;
          localByteArrayOutputStream.write(a[(j >>> 4)]);
          localByteArrayOutputStream.write(a[(j & 0xF)]);
        }
        return localByteArrayOutputStream.toByteArray();
      }
      throw null;
    }
    catch (Exception localException)
    {
      paramArrayOfByte = a.a("exception encoding Hex string: ");
      paramArrayOfByte.append(localException.getMessage());
      throw new e(paramArrayOfByte.toString(), localException);
    }
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    return l.b.j.f.a(a(paramArrayOfByte, 0, paramArrayOfByte.length));
  }
}

/* Location:
 * Qualified Name:     l.b.j.g.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */