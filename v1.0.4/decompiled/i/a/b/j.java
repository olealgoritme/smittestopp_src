package i.a.b;

public class j
{
  public static final j.d a = new j.d(null);
  public static final j.e b = new j.e(null);
  public static final j.c c = new j.c(null);
  public static final j.b d = new j.b(null);
  public static final j.a e = new j.a(null);
  
  public static boolean a(char paramChar)
  {
    return (paramChar == '{') || (paramChar == '[') || (paramChar == ',') || (paramChar == '}') || (paramChar == ']') || (paramChar == ':') || (paramChar == '\'') || (paramChar == '"');
  }
  
  public static boolean a(String paramString)
  {
    if (paramString.length() < 3) {
      return false;
    }
    int i = paramString.charAt(0);
    if (i == 110) {
      return paramString.equals("null");
    }
    if (i == 116) {
      return paramString.equals("true");
    }
    if (i == 102) {
      return paramString.equals("false");
    }
    if (i == 78) {
      return paramString.equals("NaN");
    }
    return false;
  }
  
  public static boolean b(char paramChar)
  {
    return ((paramChar >= 0) && (paramChar <= '\037')) || ((paramChar >= '') && (paramChar <= '')) || ((paramChar >= ' ') && (paramChar <= '⃿'));
  }
}

/* Location:
 * Qualified Name:     base.i.a.b.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */