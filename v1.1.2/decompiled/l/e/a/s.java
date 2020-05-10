package l.e.a;

public abstract class s
{
  public final int a;
  public s b;
  
  public s(int paramInt)
  {
    if ((paramInt != 458752) && (paramInt != 393216) && (paramInt != 327680) && (paramInt != 262144)) {
      throw new IllegalArgumentException(e.a.a.a.a.a("Unsupported api ", paramInt));
    }
    a = paramInt;
    b = null;
  }
  
  public abstract a a(int paramInt, z paramz, String paramString, boolean paramBoolean);
  
  public abstract a a(int paramInt, z paramz, q[] paramArrayOfq1, q[] paramArrayOfq2, int[] paramArrayOfInt, String paramString, boolean paramBoolean);
  
  public abstract a a(String paramString, boolean paramBoolean);
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(int paramInt1, int paramInt2, q paramq, q... paramVarArgs);
  
  public abstract void a(int paramInt1, int paramInt2, Object[] paramArrayOfObject1, int paramInt3, Object[] paramArrayOfObject2);
  
  public abstract void a(int paramInt, String paramString);
  
  public abstract void a(int paramInt, String paramString1, String paramString2, String paramString3);
  
  public abstract void a(int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean);
  
  public abstract void a(int paramInt, q paramq);
  
  public abstract void a(Object paramObject);
  
  public abstract void a(String paramString1, String paramString2, String paramString3, q paramq1, q paramq2, int paramInt);
  
  public abstract void a(q paramq);
  
  public abstract a b(int paramInt, z paramz, String paramString, boolean paramBoolean);
  
  public abstract void b(int paramInt1, int paramInt2);
  
  @Deprecated
  public void b(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    int i;
    if (a < 327680) {
      i = 256;
    } else {
      i = 0;
    }
    boolean bool;
    if (paramInt == 185) {
      bool = true;
    } else {
      bool = false;
    }
    a(paramInt | i, paramString1, paramString2, paramString3, bool);
  }
  
  public abstract void b(int paramInt, q paramq);
  
  public abstract void c(int paramInt1, int paramInt2);
  
  public abstract void d(int paramInt1, int paramInt2);
}

/* Location:
 * Qualified Name:     l.e.a.s
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */