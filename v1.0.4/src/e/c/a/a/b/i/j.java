package e.c.a.a.b.i;

import e.c.a.a.b.c;

public final class j
  extends UnsupportedOperationException
{
  public final c x;
  
  public j(c paramc)
  {
    x = paramc;
  }
  
  public final String getMessage()
  {
    String str = String.valueOf(x);
    StringBuilder localStringBuilder = new StringBuilder(str.length() + 8);
    localStringBuilder.append("Missing ");
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.b.i.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */