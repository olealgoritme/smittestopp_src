package j.a.b;

import j.a.a.i;
import j.a.b.k.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class h
{
  public static final a a = new a();
  
  public static class a
    implements i
  {
    public boolean a(Field paramField, Method paramMethod)
    {
      paramField = (a)paramMethod.getAnnotation(a.class);
      return (paramField == null) || (!paramField.value());
    }
  }
}

/* Location:
 * Qualified Name:     j.a.b.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */