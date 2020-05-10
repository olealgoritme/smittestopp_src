package k.a.a.b;

import e.c.a.a.b.l.c;
import java.io.Writer;
import k.a.a.b.d.a.b;

public class b$a
  extends b
{
  public static final String b = String.valueOf('"');
  public static final char[] c = { 44, 34, 13, 10 };
  
  public int a(CharSequence paramCharSequence, int paramInt, Writer paramWriter)
  {
    if (paramInt == 0)
    {
      Object localObject1 = paramCharSequence.toString();
      Object localObject2 = c;
      if ((localObject1 != null) && (localObject2 != null))
      {
        int i = ((CharSequence)localObject1).length();
        int j = localObject2.length;
        for (paramInt = 0; paramInt < i; paramInt++)
        {
          char c1 = ((CharSequence)localObject1).charAt(paramInt);
          for (int k = 0; k < j; k++) {
            if ((localObject2[k] == c1) && ((!Character.isHighSurrogate(c1)) || (k == j - 1) || ((paramInt < i - 1) && (localObject2[(k + 1)] == ((CharSequence)localObject1).charAt(paramInt + 1)))))
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
        String str = paramCharSequence.toString();
        localObject2 = b;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(b);
        ((StringBuilder)localObject1).append(b);
        paramWriter.write(c.a(str, (String)localObject2, ((StringBuilder)localObject1).toString()));
        paramWriter.write(34);
      }
      return Character.codePointCount(paramCharSequence, 0, paramCharSequence.length());
    }
    throw new IllegalStateException("CsvEscaper should never reach the [1] index");
  }
}

/* Location:
 * Qualified Name:     base.k.a.a.b.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */