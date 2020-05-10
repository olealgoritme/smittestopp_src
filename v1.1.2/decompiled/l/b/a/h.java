package l.b.a;

import java.io.IOException;

public class h
  extends IOException
{
  public Throwable x;
  
  public h(String paramString)
  {
    super(paramString);
  }
  
  public h(String paramString, Throwable paramThrowable)
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
 * Qualified Name:     l.b.a.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */