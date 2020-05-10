package l.a.a.b.d.a;

import e.a.a.a.a;
import java.io.Writer;
import java.util.Locale;

public class e
  extends c
{
  public final int b;
  public final int c;
  public final boolean d;
  
  public e(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    b = paramInt1;
    c = paramInt2;
    d = paramBoolean;
  }
  
  public static e a(int paramInt1, int paramInt2)
  {
    return new e(paramInt1, paramInt2, false);
  }
  
  public boolean a(int paramInt, Writer paramWriter)
  {
    boolean bool1 = d;
    boolean bool2 = false;
    if (bool1)
    {
      bool1 = bool2;
      if (paramInt < b) {
        return bool1;
      }
      if (paramInt > c) {
        return bool2;
      }
    }
    else if ((paramInt >= b) && (paramInt <= c))
    {
      return bool2;
    }
    if (paramInt > 65535)
    {
      char[] arrayOfChar = Character.toChars(paramInt);
      StringBuilder localStringBuilder = a.a("\\u");
      localStringBuilder.append(Integer.toHexString(arrayOfChar[0]).toUpperCase(Locale.ENGLISH));
      localStringBuilder.append("\\u");
      localStringBuilder.append(Integer.toHexString(arrayOfChar[1]).toUpperCase(Locale.ENGLISH));
      paramWriter.write(localStringBuilder.toString());
    }
    else
    {
      paramWriter.write("\\u");
      paramWriter.write(b.a[(paramInt >> 12 & 0xF)]);
      paramWriter.write(b.a[(paramInt >> 8 & 0xF)]);
      paramWriter.write(b.a[(paramInt >> 4 & 0xF)]);
      paramWriter.write(b.a[(paramInt & 0xF)]);
    }
    bool1 = true;
    return bool1;
  }
}

/* Location:
 * Qualified Name:     l.a.a.b.d.a.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */