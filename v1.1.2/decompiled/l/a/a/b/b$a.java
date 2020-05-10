package l.a.a.b;

import e.c.a.a.b.l.c;
import java.io.Writer;
import l.a.a.b.d.a.b;

public class b$a
  extends b
{
  public static final String b = String.valueOf('"');
  public static final char[] c = { 44, 34, 13, 10 };
  
  public int a(CharSequence paramCharSequence, int paramInt, Writer paramWriter)
  {
    if (paramInt == 0)
    {
      String str1 = paramCharSequence.toString();
      Object localObject = c;
      if ((str1 != null) && (localObject != null))
      {
        int i = str1.length();
        int j = localObject.length;
        for (paramInt = 0; paramInt < i; paramInt++)
        {
          char c1 = str1.charAt(paramInt);
          for (int k = 0; k < j; k++) {
            if ((localObject[k] == c1) && ((!Character.isHighSurrogate(c1)) || (k == j - 1) || ((paramInt < i - 1) && (localObject[(k + 1)] == str1.charAt(paramInt + 1)))))
            {
              paramInt = 0;
              break label149;
            }
          }
        }
      }
      paramInt = 1;
      label149:
      if (paramInt != 0)
      {
        paramWriter.write(paramCharSequence.toString());
      }
      else
      {
        paramWriter.write(34);
        String str2 = paramCharSequence.toString();
        str1 = b;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(b);
        ((StringBuilder)localObject).append(b);
        paramWriter.write(c.a(str2, str1, ((StringBuilder)localObject).toString()));
        paramWriter.write(34);
      }
      return Character.codePointCount(paramCharSequence, 0, paramCharSequence.length());
    }
    throw new IllegalStateException("CsvEscaper should never reach the [1] index");
  }
}

/* Location:
 * Qualified Name:     l.a.a.b.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */