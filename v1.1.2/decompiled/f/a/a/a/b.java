package f.a.a.a;

public class b
  extends Exception
{
  public final a x;
  
  public b(String paramString, Throwable paramThrowable, a parama)
  {
    super(paramString, paramThrowable);
    x = parama;
  }
  
  public static enum a
  {
    static
    {
      CRYPTO_EXCEPTION = new a("CRYPTO_EXCEPTION", 1);
      KEYSTORE_NOT_SUPPORTED_EXCEPTION = new a("KEYSTORE_NOT_SUPPORTED_EXCEPTION", 2);
      a locala = new a("INTERNAL_LIBRARY_EXCEPTION", 3);
      INTERNAL_LIBRARY_EXCEPTION = locala;
      $VALUES = new a[] { KEYSTORE_EXCEPTION, CRYPTO_EXCEPTION, KEYSTORE_NOT_SUPPORTED_EXCEPTION, locala };
    }
    
    public a() {}
  }
}

/* Location:
 * Qualified Name:     f.a.a.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */