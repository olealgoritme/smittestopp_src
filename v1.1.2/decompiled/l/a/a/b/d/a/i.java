package l.a.a.b.d.a;

import java.io.Writer;

public class i
  extends b
{
  public int a(CharSequence paramCharSequence, int paramInt, Writer paramWriter)
  {
    int i = paramCharSequence.length() - paramInt - 1;
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramCharSequence.charAt(paramInt);
    int k = 0;
    if ((j == 92) && (i > 0))
    {
      int m = paramInt + 1;
      if (a(paramCharSequence.charAt(m)))
      {
        int n = paramInt + 2;
        j = paramInt + 3;
        localStringBuilder.append(paramCharSequence.charAt(m));
        if ((i > 1) && (a(paramCharSequence.charAt(n))))
        {
          localStringBuilder.append(paramCharSequence.charAt(n));
          if (i > 2)
          {
            i = paramCharSequence.charAt(m);
            paramInt = k;
            if (i >= 48)
            {
              paramInt = k;
              if (i <= 51) {
                paramInt = 1;
              }
            }
            if ((paramInt != 0) && (a(paramCharSequence.charAt(j)))) {
              localStringBuilder.append(paramCharSequence.charAt(j));
            }
          }
        }
        paramWriter.write(Integer.parseInt(localStringBuilder.toString(), 8));
        return localStringBuilder.length() + 1;
      }
    }
    return 0;
  }
  
  public final boolean a(char paramChar)
  {
    boolean bool;
    if ((paramChar >= '0') && (paramChar <= '7')) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     l.a.a.b.d.a.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */