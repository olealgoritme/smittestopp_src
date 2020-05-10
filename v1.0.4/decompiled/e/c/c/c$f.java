package e.c.c;

import java.lang.reflect.Field;
import java.util.Locale;

public enum c$f
{
  public c$f()
  {
    super(paramString, paramInt, null);
  }
  
  public String translateName(Field paramField)
  {
    return c.separateCamelCase(paramField.getName(), ".").toLowerCase(Locale.ENGLISH);
  }
}

/* Location:
 * Qualified Name:     base.e.c.c.c.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */