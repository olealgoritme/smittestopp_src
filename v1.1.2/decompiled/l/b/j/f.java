package l.b.j;

import java.security.AccessController;
import java.security.PrivilegedAction;
import l.b.j.g.h;

public final class f
{
  public static String a;
  
  static
  {
    try
    {
      a locala = new l/b/j/f$a;
      locala.<init>();
      a = (String)AccessController.doPrivileged(locala);
    }
    catch (Exception localException1)
    {
      try
      {
        a = String.format("%n", new Object[0]);
      }
      catch (Exception localException2)
      {
        a = "\n";
      }
    }
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    char[] arrayOfChar = new char[i];
    for (int j = 0; j != i; j++) {
      arrayOfChar[j] = ((char)(char)(paramArrayOfByte[j] & 0xFF));
    }
    return new String(arrayOfChar);
  }
  
  public static byte[] a(String paramString)
  {
    int i = paramString.length();
    byte[] arrayOfByte = new byte[i];
    for (int j = 0; j != i; j++) {
      arrayOfByte[j] = ((byte)(byte)paramString.charAt(j));
    }
    return arrayOfByte;
  }
  
  public static String b(String paramString)
  {
    char[] arrayOfChar = paramString.toCharArray();
    int i = 0;
    int m;
    for (int j = 0; i != arrayOfChar.length; j = m)
    {
      int k = arrayOfChar[i];
      m = j;
      if (65 <= k)
      {
        m = j;
        if (90 >= k)
        {
          arrayOfChar[i] = ((char)(char)(k - 65 + 97));
          m = 1;
        }
      }
      i++;
    }
    if (j != 0) {
      paramString = new String(arrayOfChar);
    }
    return paramString;
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[paramArrayOfByte.length];
    int i = h.a(paramArrayOfByte, arrayOfChar);
    if (i >= 0) {
      return new String(arrayOfChar, 0, i);
    }
    throw new IllegalArgumentException("Invalid UTF-8 input");
  }
  
  public static final class a
    implements PrivilegedAction<String>
  {
    public Object run()
    {
      return System.getProperty("line.separator");
    }
  }
}

/* Location:
 * Qualified Name:     l.b.j.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */