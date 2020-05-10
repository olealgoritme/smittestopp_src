package l.a.a.b.d.a;

import java.io.Writer;

public class g
  extends c
{
  public final int b;
  public final int c;
  public final boolean d;
  
  public g(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    b = paramInt1;
    c = paramInt2;
    d = paramBoolean;
  }
  
  public static g a(int paramInt1, int paramInt2)
  {
    return new g(paramInt1, paramInt2, true);
  }
  
  public boolean a(int paramInt, Writer paramWriter)
  {
    if (d)
    {
      if ((paramInt < b) || (paramInt > c)) {
        return false;
      }
    }
    else if ((paramInt >= b) && (paramInt <= c)) {
      return false;
    }
    paramWriter.write("&#");
    paramWriter.write(Integer.toString(paramInt, 10));
    paramWriter.write(59);
    return true;
  }
}

/* Location:
 * Qualified Name:     l.a.a.b.d.a.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */