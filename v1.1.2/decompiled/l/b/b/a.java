package l.b.b;

import java.io.IOException;

public class a
  extends IOException
{
  public Throwable x;
  
  public a(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    x = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return x;
  }
}

/* Location:
 * Qualified Name:     l.b.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */