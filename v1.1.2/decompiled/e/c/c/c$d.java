package e.c.c;

import java.lang.reflect.Field;
import java.util.Locale;

public enum c$d
{
  public c$d()
  {
    super(paramString, paramInt, null);
  }
  
  public String translateName(Field paramField)
  {
    return c.separateCamelCase(paramField.getName(), "_").toLowerCase(Locale.ENGLISH);
  }
}

/* Location:
 * Qualified Name:     e.c.c.c.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */