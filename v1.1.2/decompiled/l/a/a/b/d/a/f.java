package l.a.a.b.d.a;

import java.io.Writer;
import java.util.HashMap;
import java.util.HashSet;

public class f
  extends b
{
  public final HashMap<String, String> b = new HashMap();
  public final HashSet<Character> c = new HashSet();
  public final int d;
  public final int e;
  
  public f(CharSequence[]... paramVarArgs)
  {
    int i = 0;
    int j = Integer.MAX_VALUE;
    int k = j;
    if (paramVarArgs != null)
    {
      int m = paramVarArgs.length;
      i = 0;
      int i2;
      for (k = 0; i < m; k = i2)
      {
        CharSequence[] arrayOfCharSequence = paramVarArgs[i];
        b.put(arrayOfCharSequence[0].toString(), arrayOfCharSequence[1].toString());
        c.add(Character.valueOf(arrayOfCharSequence[0].charAt(0)));
        int n = arrayOfCharSequence[0].length();
        int i1 = j;
        if (n < j) {
          i1 = n;
        }
        i2 = k;
        if (n > k) {
          i2 = n;
        }
        i++;
        j = i1;
      }
      i = k;
      k = j;
    }
    d = k;
    e = i;
  }
  
  public int a(CharSequence paramCharSequence, int paramInt, Writer paramWriter)
  {
    if (c.contains(Character.valueOf(paramCharSequence.charAt(paramInt))))
    {
      int i = e;
      int j = i;
      if (paramInt + i > paramCharSequence.length()) {}
      for (j = paramCharSequence.length() - paramInt; j >= d; j--)
      {
        Object localObject = paramCharSequence.subSequence(paramInt, paramInt + j);
        localObject = (String)b.get(((CharSequence)localObject).toString());
        if (localObject != null)
        {
          paramWriter.write((String)localObject);
          return j;
        }
      }
    }
    return 0;
  }
}

/* Location:
 * Qualified Name:     l.a.a.b.d.a.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */