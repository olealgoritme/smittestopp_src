package k.b.h;

import java.io.IOException;

public class c
  extends IOException
{
  public Throwable x;
  
  public c(String paramString, Throwable paramThrowable)
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
 * Qualified Name:     base.k.b.h.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */