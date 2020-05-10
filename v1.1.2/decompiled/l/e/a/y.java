package l.e.a;

import java.lang.reflect.Method;

public final class y
{
  public static final y e = new y(0, "VZCBSIFJD", 0, 1);
  public static final y f = new y(1, "VZCBSIFJD", 1, 2);
  public static final y g = new y(2, "VZCBSIFJD", 2, 3);
  public static final y h = new y(3, "VZCBSIFJD", 3, 4);
  public static final y i = new y(4, "VZCBSIFJD", 4, 5);
  public static final y j = new y(5, "VZCBSIFJD", 5, 6);
  public static final y k = new y(6, "VZCBSIFJD", 6, 7);
  public static final y l = new y(7, "VZCBSIFJD", 7, 8);
  public static final y m = new y(8, "VZCBSIFJD", 8, 9);
  public final int a;
  public final String b;
  public final int c;
  public final int d;
  
  public y(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    a = paramInt1;
    b = paramString;
    c = paramInt2;
    d = paramInt3;
  }
  
  public static String a(Class<?> paramClass)
  {
    return paramClass.getName().replace('.', '/');
  }
  
  public static String a(Method paramMethod)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('(');
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    int n = arrayOfClass.length;
    for (int i1 = 0; i1 < n; i1++) {
      a(arrayOfClass[i1], localStringBuilder);
    }
    localStringBuilder.append(')');
    a(paramMethod.getReturnType(), localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public static y a(String paramString, int paramInt1, int paramInt2)
  {
    int n = paramString.charAt(paramInt1);
    if (n != 40)
    {
      if (n != 70)
      {
        if (n != 76)
        {
          if (n != 83)
          {
            if (n != 86)
            {
              if (n != 73)
              {
                if (n != 74)
                {
                  if (n != 90)
                  {
                    if (n != 91)
                    {
                      switch (n)
                      {
                      default: 
                        throw new IllegalArgumentException();
                      case 68: 
                        return m;
                      case 67: 
                        return g;
                      }
                      return h;
                    }
                    return new y(9, paramString, paramInt1, paramInt2);
                  }
                  return f;
                }
                return l;
              }
              return j;
            }
            return e;
          }
          return i;
        }
        return new y(10, paramString, paramInt1 + 1, paramInt2 - 1);
      }
      return k;
    }
    return new y(11, paramString, paramInt1, paramInt2);
  }
  
  public static void a(Class<?> paramClass, StringBuilder paramStringBuilder)
  {
    while (paramClass.isArray())
    {
      paramStringBuilder.append('[');
      paramClass = paramClass.getComponentType();
    }
    if (paramClass.isPrimitive())
    {
      char c1;
      char c2;
      if (paramClass == Integer.TYPE)
      {
        c1 = 'I';
        c2 = c1;
      }
      else if (paramClass == Void.TYPE)
      {
        c1 = 'V';
        c2 = c1;
      }
      else if (paramClass == Boolean.TYPE)
      {
        c1 = 'Z';
        c2 = c1;
      }
      else if (paramClass == Byte.TYPE)
      {
        c1 = 'B';
        c2 = c1;
      }
      else if (paramClass == Character.TYPE)
      {
        c1 = 'C';
        c2 = c1;
      }
      else if (paramClass == Short.TYPE)
      {
        c1 = 'S';
        c2 = c1;
      }
      else if (paramClass == Double.TYPE)
      {
        c1 = 'D';
        c2 = c1;
      }
      else if (paramClass == Float.TYPE)
      {
        c1 = 'F';
        c2 = c1;
      }
      else
      {
        if (paramClass != Long.TYPE) {
          break label170;
        }
        c1 = 'J';
        c2 = c1;
      }
      paramStringBuilder.append(c2);
      return;
      label170:
      throw new AssertionError();
    }
    else
    {
      paramStringBuilder.append('L');
      paramStringBuilder.append(paramClass.getName().replace('.', '/'));
      paramStringBuilder.append(';');
    }
  }
  
  public static y[] a(String paramString)
  {
    int n = 0;
    int i1 = 1;
    int i3;
    for (int i2 = 0; paramString.charAt(i1) != ')'; i2++)
    {
      while (paramString.charAt(i1) == '[') {
        i1++;
      }
      i3 = i1 + 1;
      if (paramString.charAt(i1) == 'L') {
        i1 = paramString.indexOf(';', i3) + 1;
      } else {
        i1 = i3;
      }
    }
    y[] arrayOfy = new y[i2];
    for (i1 = 1; paramString.charAt(i1) != ')'; i1 = i2)
    {
      for (i3 = i1; paramString.charAt(i3) == '['; i3++) {}
      int i4 = i3 + 1;
      i2 = i4;
      if (paramString.charAt(i3) == 'L') {
        i2 = paramString.indexOf(';', i4) + 1;
      }
      arrayOfy[n] = a(paramString, i1, i2);
      n++;
    }
    return arrayOfy;
  }
  
  public static int b(String paramString)
  {
    int n = 1;
    int i1 = paramString.charAt(1);
    int i2 = 1;
    int i3 = 1;
    while (i1 != 41)
    {
      if (i1 != 74)
      {
        i4 = i2;
        if (i1 != 68)
        {
          while (paramString.charAt(i4) == '[') {
            i4++;
          }
          i1 = i4 + 1;
          i2 = i1;
          if (paramString.charAt(i4) == 'L') {
            i2 = paramString.indexOf(';', i1) + 1;
          }
          i3++;
          break label94;
        }
      }
      i2++;
      i3 += 2;
      label94:
      i1 = paramString.charAt(i2);
    }
    int i4 = paramString.charAt(i2 + 1);
    if (i4 == 86) {
      return i3 << 2;
    }
    if (i4 != 74)
    {
      i2 = n;
      if (i4 != 68) {}
    }
    else
    {
      i2 = 2;
    }
    return i3 << 2 | i2;
  }
  
  public static y b(Class<?> paramClass)
  {
    if (paramClass.isPrimitive())
    {
      if (paramClass == Integer.TYPE) {
        return j;
      }
      if (paramClass == Void.TYPE) {
        return e;
      }
      if (paramClass == Boolean.TYPE) {
        return f;
      }
      if (paramClass == Byte.TYPE) {
        return h;
      }
      if (paramClass == Character.TYPE) {
        return g;
      }
      if (paramClass == Short.TYPE) {
        return i;
      }
      if (paramClass == Double.TYPE) {
        return m;
      }
      if (paramClass == Float.TYPE) {
        return k;
      }
      if (paramClass == Long.TYPE) {
        return l;
      }
      throw new AssertionError();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    a(paramClass, localStringBuilder);
    paramClass = localStringBuilder.toString();
    return a(paramClass, 0, paramClass.length());
  }
  
  public static y c(String paramString)
  {
    int n;
    if (paramString.charAt(0) == '[') {
      n = 9;
    } else {
      n = 12;
    }
    return new y(n, paramString, 0, paramString.length());
  }
  
  public static int d(String paramString)
  {
    int n = 1;
    while (paramString.charAt(n) != ')')
    {
      while (paramString.charAt(n) == '[') {
        n++;
      }
      int i1 = n + 1;
      if (paramString.charAt(n) == 'L') {
        n = paramString.indexOf(';', i1) + 1;
      } else {
        n = i1;
      }
    }
    return n + 1;
  }
  
  public static y e(String paramString)
  {
    return a(paramString, 0, paramString.length());
  }
  
  public String a()
  {
    int n = a;
    if (n == 10) {
      return b.substring(c - 1, d + 1);
    }
    if (n == 12)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append('L');
      localStringBuilder.append(b.substring(c, d));
      localStringBuilder.append(';');
      return localStringBuilder.toString();
    }
    return b.substring(c, d);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof y)) {
      return false;
    }
    paramObject = (y)paramObject;
    int n = a;
    int i1 = 10;
    int i2 = n;
    if (n == 12) {
      i2 = 10;
    }
    n = a;
    if (n != 12) {
      i1 = n;
    }
    if (i2 != i1) {
      return false;
    }
    n = c;
    int i3 = d;
    int i4 = c;
    i2 = n;
    i1 = i4;
    if (i3 - n != d - i4) {
      return false;
    }
    while (i2 < i3)
    {
      if (b.charAt(i2) != b.charAt(i1)) {
        return false;
      }
      i2++;
      i1++;
    }
    return true;
  }
  
  public int hashCode()
  {
    int n = a;
    int i1 = n;
    if (n == 12) {
      i1 = 10;
    }
    i1 *= 13;
    int i2 = i1;
    if (a >= 9)
    {
      n = c;
      int i3 = d;
      for (;;)
      {
        i2 = i1;
        if (n >= i3) {
          break;
        }
        i1 = (b.charAt(n) + i1) * 17;
        n++;
      }
    }
    return i2;
  }
  
  public String toString()
  {
    return a();
  }
}

/* Location:
 * Qualified Name:     l.e.a.y
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */