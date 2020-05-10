package k.b.j.h.b;

public class a
{
  public String a;
  public String b;
  
  public a(String paramString1, String paramString2)
  {
    a = paramString1;
    b = paramString2;
  }
  
  public final boolean a(String paramString1, String paramString2)
  {
    if (paramString1 == paramString2) {
      return true;
    }
    if ((paramString1 != null) && (paramString2 != null)) {
      return paramString1.equals(paramString2);
    }
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof a;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (a)paramObject;
    if (paramObject != this)
    {
      bool1 = bool2;
      if (a(a, a))
      {
        bool1 = bool2;
        if (!a(b, b)) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public int hashCode()
  {
    String str = a;
    int i = 1;
    int j;
    if (str == null) {
      j = 1;
    } else {
      j = str.hashCode();
    }
    str = b;
    if (str != null) {
      i = str.hashCode();
    }
    return i * 31 + j;
  }
}

/* Location:
 * Qualified Name:     base.k.b.j.h.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */