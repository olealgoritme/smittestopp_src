package k.b.a;

public class s
  extends IllegalStateException
{
  public Throwable x;
  
  public s(String paramString)
  {
    super(paramString);
  }
  
  public s(String paramString, Throwable paramThrowable)
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
 * Qualified Name:     base.k.b.a.s
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */