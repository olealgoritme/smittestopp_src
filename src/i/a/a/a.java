package i.a.a;

import e.c.a.a.b.l.c;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class a
{
  public Field a;
  public Method b;
  public Method c;
  public int d;
  public Class<?> e;
  public String f;
  
  public a(Class<?> paramClass, Field paramField, i parami)
  {
    f = paramField.getName();
    int i = paramField.getModifiers();
    if ((i & 0x88) > 0) {
      return;
    }
    int j = 1;
    if ((i & 0x1) > 0) {
      a = paramField;
    }
    String str1 = paramField.getName();
    int k = str1.length();
    char[] arrayOfChar = new char[k + 3];
    arrayOfChar[0] = ((char)115);
    arrayOfChar[1] = ((char)101);
    arrayOfChar[2] = ((char)116);
    int m = str1.charAt(0);
    i = m;
    if (m >= 97)
    {
      i = m;
      if (m <= 122) {
        i = (char)(m - 32);
      }
    }
    arrayOfChar[3] = ((char)i);
    for (i = 1;; i++)
    {
      if (i >= k)
      {
        str1 = new String(arrayOfChar);
        try
        {
          b = paramClass.getDeclaredMethod(str1, new Class[] { paramField.getType() });
        }
        catch (Exception localException1) {}
        boolean bool = paramField.getType().equals(Boolean.TYPE);
        if (bool)
        {
          str2 = paramField.getName();
          k = str2.length();
          arrayOfChar = new char[k + 2];
          arrayOfChar[0] = ((char)105);
          arrayOfChar[1] = ((char)115);
          m = str2.charAt(0);
          i = m;
          if (m >= 97)
          {
            i = m;
            if (m <= 122) {
              i = (char)(m - 32);
            }
          }
          arrayOfChar[2] = ((char)i);
          for (i = j;; i++)
          {
            if (i >= k)
            {
              str2 = new String(arrayOfChar);
              break;
            }
            arrayOfChar[(i + 2)] = str2.charAt(i);
          }
        }
        String str2 = c.a(paramField.getName());
        try
        {
          c = paramClass.getDeclaredMethod(str2, new Class[0]);
        }
        catch (Exception localException2) {}
        if ((c == null) && (bool)) {
          try
          {
            c = paramClass.getDeclaredMethod(c.a(paramField.getName()), new Class[0]);
          }
          catch (Exception paramClass) {}
        }
        if ((a == null) && (c == null) && (b == null)) {
          return;
        }
        paramClass = c;
        if ((paramClass != null) && (!parami.a(paramField, paramClass))) {
          c = null;
        }
        paramClass = b;
        if ((paramClass != null) && (!parami.a(paramField, paramClass))) {
          b = null;
        }
        if ((c == null) && (b == null) && (a == null)) {
          return;
        }
        e = paramField.getType();
        paramField.getGenericType();
        return;
      }
      arrayOfChar[(i + 3)] = localException2.charAt(i);
    }
  }
  
  public boolean a()
  {
    return b == null;
  }
}

/* Location:
 * Qualified Name:     base.i.a.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */