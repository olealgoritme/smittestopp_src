package e.c.c;

import java.lang.reflect.Field;

public enum c$b
{
  public c$b()
  {
    super(paramString, paramInt, null);
  }
  
  public String translateName(Field paramField)
  {
    return c.upperCaseFirstLetter(paramField.getName());
  }
}

/* Location:
 * Qualified Name:     e.c.c.c.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */