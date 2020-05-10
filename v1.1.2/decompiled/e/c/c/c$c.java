package e.c.c;

import java.lang.reflect.Field;

public enum c$c
{
  public c$c()
  {
    super(paramString, paramInt, null);
  }
  
  public String translateName(Field paramField)
  {
    return c.upperCaseFirstLetter(c.separateCamelCase(paramField.getName(), " "));
  }
}

/* Location:
 * Qualified Name:     e.c.c.c.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */