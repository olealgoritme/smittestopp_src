package e.b.a.a.s;

import java.util.ArrayList;
import java.util.Arrays;

public final class g
{
  public static final char[] l = new char[0];
  public final a a;
  public char[] b;
  public int c;
  public int d;
  public ArrayList<char[]> e;
  public boolean f;
  public int g;
  public char[] h;
  public int i;
  public String j;
  public char[] k;
  
  public g(a parama)
  {
    a = parama;
  }
  
  public final void a()
  {
    f = false;
    e.clear();
    g = 0;
    i = 0;
  }
  
  public void a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    j = null;
    k = null;
    b = paramArrayOfChar;
    c = paramInt1;
    d = paramInt2;
    if (f) {
      a();
    }
  }
  
  public final char[] a(int paramInt)
  {
    a locala = a;
    if (locala != null) {
      return locala.a(2, paramInt);
    }
    return new char[Math.max(paramInt, 1000)];
  }
  
  public String b()
  {
    if (j == null) {
      if (k != null)
      {
        j = new String(k);
      }
      else
      {
        int m = c;
        Object localObject1 = "";
        if (m >= 0)
        {
          if (d < 1)
          {
            j = "";
            return "";
          }
          j = new String(b, c, d);
        }
        else
        {
          int n = g;
          m = i;
          if (n == 0)
          {
            if (m != 0) {
              localObject1 = new String(h, 0, m);
            }
            j = ((String)localObject1);
          }
          else
          {
            localObject1 = new StringBuilder(n + m);
            Object localObject2 = e;
            if (localObject2 != null)
            {
              n = ((ArrayList)localObject2).size();
              for (m = 0; m < n; m++)
              {
                localObject2 = (char[])e.get(m);
                ((StringBuilder)localObject1).append((char[])localObject2, 0, localObject2.length);
              }
            }
            ((StringBuilder)localObject1).append(h, 0, i);
            j = ((StringBuilder)localObject1).toString();
          }
        }
      }
    }
    return j;
  }
  
  public final void b(int paramInt)
  {
    int m = d;
    d = 0;
    char[] arrayOfChar1 = b;
    b = null;
    int n = c;
    c = -1;
    paramInt += m;
    char[] arrayOfChar2 = h;
    if ((arrayOfChar2 == null) || (paramInt > arrayOfChar2.length)) {
      h = a(paramInt);
    }
    if (m > 0) {
      System.arraycopy(arrayOfChar1, n, h, 0, m);
    }
    g = 0;
    i = m;
  }
  
  public char[] c()
  {
    c = -1;
    i = 0;
    d = 0;
    b = null;
    j = null;
    k = null;
    if (f) {
      a();
    }
    char[] arrayOfChar1 = h;
    char[] arrayOfChar2 = arrayOfChar1;
    if (arrayOfChar1 == null)
    {
      arrayOfChar2 = a(0);
      h = arrayOfChar2;
    }
    return arrayOfChar2;
  }
  
  public final void d()
  {
    if (e == null) {
      e = new ArrayList();
    }
    char[] arrayOfChar = h;
    f = true;
    e.add(arrayOfChar);
    g += arrayOfChar.length;
    i = 0;
    int m = arrayOfChar.length;
    int n = m + (m >> 1);
    if (n < 1000)
    {
      m = 1000;
    }
    else
    {
      m = n;
      if (n > 262144) {
        m = 262144;
      }
    }
    h = new char[m];
  }
  
  public char[] e()
  {
    char[] arrayOfChar = h;
    int m = arrayOfChar.length;
    int n = (m >> 1) + m;
    int i1 = n;
    if (n > 262144) {
      i1 = (m >> 2) + m;
    }
    arrayOfChar = Arrays.copyOf(arrayOfChar, i1);
    h = arrayOfChar;
    return arrayOfChar;
  }
  
  public char[] f()
  {
    if (e == null) {
      e = new ArrayList();
    }
    f = true;
    e.add(h);
    int m = h.length;
    g += m;
    i = 0;
    int n = m + (m >> 1);
    if (n < 1000)
    {
      m = 1000;
    }
    else
    {
      m = n;
      if (n > 262144) {
        m = 262144;
      }
    }
    char[] arrayOfChar = new char[m];
    h = arrayOfChar;
    return arrayOfChar;
  }
  
  public char[] g()
  {
    if (c >= 0)
    {
      b(1);
    }
    else
    {
      char[] arrayOfChar = h;
      if (arrayOfChar == null) {
        h = a(0);
      } else if (i >= arrayOfChar.length) {
        d();
      }
    }
    return h;
  }
  
  public char[] h()
  {
    int m = c;
    if (m >= 0) {
      return b;
    }
    Object localObject1 = k;
    if (localObject1 != null) {
      return (char[])localObject1;
    }
    String str = j;
    if (str != null)
    {
      localObject2 = str.toCharArray();
      k = ((char[])localObject2);
      return (char[])localObject2;
    }
    if (!f)
    {
      localObject1 = h;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = l;
      }
      return (char[])localObject2;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      if (str != null) {
        localObject2 = str.toCharArray();
      }
      for (;;)
      {
        break;
        int n;
        if (m >= 0)
        {
          n = d;
          if (n < 1) {
            localObject2 = l;
          } else if (m == 0) {
            localObject2 = Arrays.copyOf(b, n);
          } else {
            localObject2 = Arrays.copyOfRange(b, m, n + m);
          }
        }
        else
        {
          m = j();
          if (m < 1)
          {
            localObject2 = l;
          }
          else
          {
            localObject2 = new char[m];
            localObject1 = e;
            if (localObject1 != null)
            {
              int i1 = ((ArrayList)localObject1).size();
              n = 0;
              m = 0;
              for (;;)
              {
                i2 = m;
                if (n >= i1) {
                  break;
                }
                localObject1 = (char[])e.get(n);
                i2 = localObject1.length;
                System.arraycopy(localObject1, 0, localObject2, m, i2);
                m += i2;
                n++;
              }
            }
            int i2 = 0;
            System.arraycopy(h, 0, localObject2, i2, i);
          }
        }
      }
      k = ((char[])localObject2);
    }
    return (char[])localObject2;
  }
  
  public void i()
  {
    c = -1;
    i = 0;
    d = 0;
    b = null;
    j = null;
    k = null;
    if (f) {
      a();
    }
  }
  
  public int j()
  {
    if (c >= 0) {
      return d;
    }
    Object localObject = k;
    if (localObject != null) {
      return localObject.length;
    }
    localObject = j;
    if (localObject != null) {
      return ((String)localObject).length();
    }
    return g + i;
  }
  
  public String toString()
  {
    return b();
  }
}

/* Location:
 * Qualified Name:     base.e.b.a.a.s.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */