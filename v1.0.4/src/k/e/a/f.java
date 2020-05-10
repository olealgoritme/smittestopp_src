package k.e.a;

public abstract class f
{
  public f(int paramInt)
  {
    if ((paramInt != 458752) && (paramInt != 393216) && (paramInt != 327680) && (paramInt != 262144)) {
      throw new IllegalArgumentException(e.a.a.a.a.a("Unsupported api ", paramInt));
    }
  }
  
  public abstract a a(int paramInt, z paramz, String paramString, boolean paramBoolean);
  
  public abstract a a(String paramString, boolean paramBoolean);
  
  public abstract s a(int paramInt, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString);
  
  public abstract void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString);
}

/* Location:
 * Qualified Name:     base.k.e.a.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */