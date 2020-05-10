package l.b.g;

import java.io.IOException;

public class b
  extends IOException
{
  public Exception x;
  
  public b(String paramString)
  {
    super(paramString);
  }
  
  public b(String paramString, Exception paramException)
  {
    super(paramString);
    x = paramException;
  }
  
  public Throwable getCause()
  {
    return x;
  }
}

/* Location:
 * Qualified Name:     l.b.g.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */