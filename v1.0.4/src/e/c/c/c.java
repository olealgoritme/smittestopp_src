package e.c.c;

public enum c
  implements d
{
  static
  {
    LOWER_CASE_WITH_UNDERSCORES = new c.d("LOWER_CASE_WITH_UNDERSCORES", 3);
    LOWER_CASE_WITH_DASHES = new c.e("LOWER_CASE_WITH_DASHES", 4);
    c.f localf = new c.f("LOWER_CASE_WITH_DOTS", 5);
    LOWER_CASE_WITH_DOTS = localf;
    $VALUES = new c[] { IDENTITY, UPPER_CAMEL_CASE, UPPER_CAMEL_CASE_WITH_SPACES, LOWER_CASE_WITH_UNDERSCORES, LOWER_CASE_WITH_DASHES, localf };
  }
  
  public c() {}
  
  public static String modifyString(char paramChar, String paramString, int paramInt)
  {
    if (paramInt < paramString.length())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramChar);
      localStringBuilder.append(paramString.substring(paramInt));
      paramString = localStringBuilder.toString();
    }
    else
    {
      paramString = String.valueOf(paramChar);
    }
    return paramString;
  }
  
  public static String separateCamelCase(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramString1.length();
    for (int j = 0; j < i; j++)
    {
      char c = paramString1.charAt(j);
      if ((Character.isUpperCase(c)) && (localStringBuilder.length() != 0)) {
        localStringBuilder.append(paramString2);
      }
      localStringBuilder.append(c);
    }
    return localStringBuilder.toString();
  }
  
  public static String upperCaseFirstLetter(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    char c1 = paramString.charAt(0);
    int j = paramString.length();
    for (char c2 = c1; (i < j - 1) && (!Character.isLetter(c2)); c2 = c1)
    {
      localStringBuilder.append(c2);
      i++;
      c1 = paramString.charAt(i);
    }
    String str = paramString;
    if (!Character.isUpperCase(c2))
    {
      localStringBuilder.append(modifyString(Character.toUpperCase(c2), paramString, i + 1));
      str = localStringBuilder.toString();
    }
    return str;
  }
}

/* Location:
 * Qualified Name:     base.e.c.c.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */