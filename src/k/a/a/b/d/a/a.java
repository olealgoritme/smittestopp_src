package k.a.a.b.d.a;

import java.io.Writer;

public class a
  extends b
{
  public final b[] b;
  
  public a(b... paramVarArgs)
  {
    if (paramVarArgs == null) {
      paramVarArgs = null;
    } else {
      paramVarArgs = (Object[])paramVarArgs.clone();
    }
    b = ((b[])paramVarArgs);
  }
  
  public int a(CharSequence paramCharSequence, int paramInt, Writer paramWriter)
  {
    b[] arrayOfb = b;
    int i = arrayOfb.length;
    for (int j = 0; j < i; j++)
    {
      int k = arrayOfb[j].a(paramCharSequence, paramInt, paramWriter);
      if (k != 0) {
        return k;
      }
    }
    return 0;
  }
}

/* Location:
 * Qualified Name:     base.k.a.a.b.d.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */