package j.a.a;

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
    Object localObject1 = paramField.getName();
    int k = ((String)localObject1).length();
    Object localObject2 = new char[k + 3];
    localObject2[0] = ((char)115);
    localObject2[1] = ((char)101);
    localObject2[2] = ((char)116);
    int m = ((String)localObject1).charAt(0);
    i = m;
    if (m >= 97)
    {
      i = m;
      if (m <= 122) {
        i = (char)(m - 32);
      }
    }
    localObject2[3] = ((char)i);
    for (i = 1;; i++)
    {
      if (i >= k)
      {
        localObject2 = new String((char[])localObject2);
        try
        {
          b = paramClass.getDeclaredMethod((String)localObject2, new Class[] { paramField.getType() });
        }
        catch (Exception localException1) {}
        boolean bool = paramField.getType().equals(Boolean.TYPE);
        if (bool)
        {
          str = paramField.getName();
          k = str.length();
          localObject1 = new char[k + 2];
          localObject1[0] = ((char)105);
          localObject1[1] = ((char)115);
          m = str.charAt(0);
          i = m;
          if (m >= 97)
          {
            i = m;
            if (m <= 122) {
              i = (char)(m - 32);
            }
          }
          localObject1[2] = ((char)i);
          for (i = j;; i++)
          {
            if (i >= k)
            {
              str = new String((char[])localObject1);
              break;
            }
            localObject1[(i + 2)] = str.charAt(i);
          }
        }
        String str = c.a(paramField.getName());
        try
        {
          c = paramClass.getDeclaredMethod(str, new Class[0]);
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
      localException2[(i + 3)] = ((String)localObject1).charAt(i);
    }
  }
  
  public boolean a()
  {
    return b == null;
  }
}

/* Location:
 * Qualified Name:     j.a.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */