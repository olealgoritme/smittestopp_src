package e.e.a;

public final class d
  extends a
{
  public static final d A = new d("A192CBC-HS384", r.OPTIONAL, 384);
  public static final d B = new d("A256CBC-HS512", r.REQUIRED, 512);
  public static final d C = new d("A128CBC+HS256", r.OPTIONAL, 256);
  public static final d D = new d("A256CBC+HS512", r.OPTIONAL, 512);
  public static final d E = new d("A128GCM", r.RECOMMENDED, 128);
  public static final d F = new d("A192GCM", r.OPTIONAL, 192);
  public static final d G = new d("A256GCM", r.RECOMMENDED, 256);
  public static final d z = new d("A128CBC-HS256", r.REQUIRED, 256);
  
  public d(String paramString)
  {
    super(paramString, null);
  }
  
  public d(String paramString, r paramr, int paramInt)
  {
    super(paramString, paramr);
  }
}

/* Location:
 * Qualified Name:     base.e.e.a.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */