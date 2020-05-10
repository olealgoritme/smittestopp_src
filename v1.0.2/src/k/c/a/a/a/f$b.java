package k.c.a.a.a;

public class f$b
  implements h
{
  public final boolean a;
  
  public f$b(f paramf, boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  public void a(boolean paramBoolean, String paramString) {}
  
  public void connectionLost(Throwable paramThrowable)
  {
    if (a)
    {
      paramThrowable = b;
      if (A != null)
      {
        G = true;
        f.a(paramThrowable);
      }
      else
      {
        throw null;
      }
    }
  }
  
  public void deliveryComplete(c paramc) {}
  
  public void messageArrived(String paramString, l paraml) {}
}

/* Location:
 * Qualified Name:     base.k.c.a.a.a.f.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */