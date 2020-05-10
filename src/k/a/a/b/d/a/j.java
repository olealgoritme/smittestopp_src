package k.a.a.b.d.a;

import e.a.a.a.a;
import java.io.Writer;

public class j
  extends b
{
  public int a(CharSequence paramCharSequence, int paramInt, Writer paramWriter)
  {
    if (paramCharSequence.charAt(paramInt) == '\\')
    {
      int i = paramInt + 1;
      if ((i < paramCharSequence.length()) && (paramCharSequence.charAt(i) == 'u'))
      {
        for (i = 2;; i++)
        {
          j = paramInt + i;
          if ((j >= paramCharSequence.length()) || (paramCharSequence.charAt(j) != 'u')) {
            break;
          }
        }
        int k = i;
        if (j < paramCharSequence.length())
        {
          k = i;
          if (paramCharSequence.charAt(j) == '+') {
            k = i + 1;
          }
        }
        i = paramInt + k;
        int j = i + 4;
        if (j <= paramCharSequence.length())
        {
          paramCharSequence = paramCharSequence.subSequence(i, j);
          try
          {
            paramWriter.write((char)Integer.parseInt(paramCharSequence.toString(), 16));
            return k + 4;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            paramWriter = new StringBuilder();
            paramWriter.append("Unable to parse unicode value: ");
            paramWriter.append(paramCharSequence);
            throw new IllegalArgumentException(paramWriter.toString(), localNumberFormatException);
          }
        }
        paramWriter = a.a("Less than 4 hex digits in unicode value: '");
        paramWriter.append(paramCharSequence.subSequence(paramInt, paramCharSequence.length()));
        paramWriter.append("' due to end of CharSequence");
        throw new IllegalArgumentException(paramWriter.toString());
      }
    }
    return 0;
  }
}

/* Location:
 * Qualified Name:     base.k.a.a.b.d.a.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */