package l.c.a.a.a.s.s;

import java.io.InputStream;

public class a
  extends InputStream
{
  public InputStream x;
  public int y;
  
  public a(InputStream paramInputStream)
  {
    x = paramInputStream;
    y = 0;
  }
  
  public int read()
  {
    int i = x.read();
    if (i != -1) {
      y += 1;
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     l.c.a.a.a.s.s.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */