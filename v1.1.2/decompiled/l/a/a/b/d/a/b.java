package l.a.a.b.d.a;

import java.io.Writer;

public abstract class b
{
  public static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public abstract int a(CharSequence paramCharSequence, int paramInt, Writer paramWriter);
  
  public final b a(b... paramVarArgs)
  {
    b[] arrayOfb = new b[paramVarArgs.length + 1];
    arrayOfb[0] = this;
    System.arraycopy(paramVarArgs, 0, arrayOfb, 1, paramVarArgs.length);
    return new a(arrayOfb);
  }
}

/* Location:
 * Qualified Name:     l.a.a.b.d.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */