package k.a.a.b;

import e.c.a.a.b.l.c;
import java.io.Writer;
import k.a.a.b.d.a.b;

public class b$b
  extends b
{
  public static final String b = String.valueOf('"');
  public static final char[] c = { 44, 34, 13, 10 };
  
  public int a(CharSequence paramCharSequence, int paramInt, Writer paramWriter)
  {
    if (paramInt == 0)
    {
      if (paramCharSequence.charAt(0) == '"')
      {
        paramInt = paramCharSequence.length();
        int i = 1;
        if (paramCharSequence.charAt(paramInt - 1) == '"')
        {
          String str = paramCharSequence.subSequence(1, paramCharSequence.length() - 1).toString();
          Object localObject = c;
          if (!c.a(str))
          {
            if ((localObject != null) && (localObject.length != 0)) {
              paramInt = 0;
            } else {
              paramInt = 1;
            }
            if (paramInt == 0)
            {
              int j = str.length();
              int k = localObject.length;
              for (paramInt = 0; paramInt < j; paramInt++)
              {
                char c1 = str.charAt(paramInt);
                for (int m = 0; m < k; m++) {
                  if (localObject[m] == c1)
                  {
                    n = i;
                    if (!Character.isHighSurrogate(c1)) {
                      break label236;
                    }
                    if (m == k - 1)
                    {
                      n = i;
                      break label236;
                    }
                    if ((paramInt < j - 1) && (localObject[(m + 1)] == str.charAt(paramInt + 1)))
                    {
                      n = i;
                      break label236;
                    }
                  }
                }
              }
            }
          }
          int n = 0;
          label236:
          if (n != 0)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(b);
            ((StringBuilder)localObject).append(b);
            paramWriter.write(c.a(str, ((StringBuilder)localObject).toString(), b));
          }
          else
          {
            paramWriter.write(paramCharSequence.toString());
          }
          return Character.codePointCount(paramCharSequence, 0, paramCharSequence.length());
        }
      }
      paramWriter.write(paramCharSequence.toString());
      return Character.codePointCount(paramCharSequence, 0, paramCharSequence.length());
    }
    throw new IllegalStateException("CsvUnescaper should never reach the [1] index");
  }
}

/* Location:
 * Qualified Name:     base.k.a.a.b.b.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */