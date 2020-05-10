package e.c.c;

import java.lang.reflect.Field;
import java.util.Locale;

public enum c
  implements d
{
  static
  {
    LOWER_CASE_WITH_UNDERSCORES = new d("LOWER_CASE_WITH_UNDERSCORES", 3);
    LOWER_CASE_WITH_DASHES = new e("LOWER_CASE_WITH_DASHES", 4);
    f localf = new f("LOWER_CASE_WITH_DOTS", 5);
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
  
  public static enum a
  {
    public a()
    {
      super(paramInt, null);
    }
    
    public String translateName(Field paramField)
    {
      return paramField.getName();
    }
  }
  
  public static enum b
  {
    public b()
    {
      super(paramInt, null);
    }
    
    public String translateName(Field paramField)
    {
      return c.upperCaseFirstLetter(paramField.getName());
    }
  }
  
  public static enum c
  {
    public c()
    {
      super(paramInt, null);
    }
    
    public String translateName(Field paramField)
    {
      return c.upperCaseFirstLetter(c.separateCamelCase(paramField.getName(), " "));
    }
  }
  
  public static enum d
  {
    public d()
    {
      super(paramInt, null);
    }
    
    public String translateName(Field paramField)
    {
      return c.separateCamelCase(paramField.getName(), "_").toLowerCase(Locale.ENGLISH);
    }
  }
  
  public static enum e
  {
    public e()
    {
      super(paramInt, null);
    }
    
    public String translateName(Field paramField)
    {
      return c.separateCamelCase(paramField.getName(), "-").toLowerCase(Locale.ENGLISH);
    }
  }
  
  public static enum f
  {
    public f()
    {
      super(paramInt, null);
    }
    
    public String translateName(Field paramField)
    {
      return c.separateCamelCase(paramField.getName(), ".").toLowerCase(Locale.ENGLISH);
    }
  }
}

/* Location:
 * Qualified Name:     e.c.c.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */