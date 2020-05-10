package e.h.a.a;

import android.util.Base64;
import java.util.Arrays;

public class a$a
{
  public final byte[] a;
  public final byte[] b;
  public final byte[] c;
  
  public a$a(String paramString)
  {
    paramString = paramString.split(":");
    if (paramString.length == 3)
    {
      b = Base64.decode(paramString[0], 2);
      c = Base64.decode(paramString[1], 2);
      a = Base64.decode(paramString[2], 2);
      return;
    }
    throw new IllegalArgumentException("Cannot parse iv:ciphertext:mac");
  }
  
  public a$a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length];
    a = arrayOfByte;
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
    paramArrayOfByte1 = new byte[paramArrayOfByte2.length];
    b = paramArrayOfByte1;
    System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, 0, paramArrayOfByte2.length);
    paramArrayOfByte1 = new byte[paramArrayOfByte3.length];
    c = paramArrayOfByte1;
    System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte1, 0, paramArrayOfByte3.length);
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length];
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramArrayOfByte1.length, paramArrayOfByte2.length);
    return arrayOfByte;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (a.class != paramObject.getClass()) {
      return false;
    }
    paramObject = (a)paramObject;
    if (!Arrays.equals(a, a)) {
      return false;
    }
    if (!Arrays.equals(b, b)) {
      return false;
    }
    return Arrays.equals(c, c);
  }
  
  public int hashCode()
  {
    int i = Arrays.hashCode(a);
    int j = Arrays.hashCode(b);
    return Arrays.hashCode(c) + (j + (i + 31) * 31) * 31;
  }
  
  public String toString()
  {
    String str1 = Base64.encodeToString(b, 2);
    String str2 = Base64.encodeToString(a, 2);
    String str3 = Base64.encodeToString(c, 2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append(":");
    localStringBuilder.append(str3);
    localStringBuilder.append(":");
    localStringBuilder.append(str2);
    return String.format(localStringBuilder.toString(), new Object[0]);
  }
}

/* Location:
 * Qualified Name:     e.h.a.a.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */