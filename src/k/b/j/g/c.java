package k.b.j.g;

public class c
  extends IllegalStateException
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
 * Qualified Name:     base.k.b.j.g.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */