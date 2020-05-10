package e.b.a.a;

import e.b.a.a.p.a;

public abstract class k
{
  public int a;
  public int b;
  
  public abstract String a();
  
  public final boolean b()
  {
    int i = a;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  public final boolean c()
  {
    boolean bool;
    if (a == 2) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final boolean d()
  {
    boolean bool;
    if (a == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public String e()
  {
    int i = a;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return "?";
        }
        return "Object";
      }
      return "Array";
    }
    return "root";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    int i = a;
    if (i != 0)
    {
      int j = 0;
      int k = 0;
      if (i != 1)
      {
        localStringBuilder.append('{');
        String str = a();
        if (str != null)
        {
          localStringBuilder.append('"');
          int[] arrayOfInt = a.h;
          j = arrayOfInt.length;
          i = str.length();
          while (k < i)
          {
            int m = str.charAt(k);
            if ((m < j) && (arrayOfInt[m] != 0))
            {
              localStringBuilder.append('\\');
              int n = arrayOfInt[m];
              if (n < 0)
              {
                localStringBuilder.append('u');
                localStringBuilder.append('0');
                localStringBuilder.append('0');
                localStringBuilder.append(a.a[(m >> 4)]);
                localStringBuilder.append(a.a[(m & 0xF)]);
              }
              else
              {
                localStringBuilder.append((char)n);
              }
            }
            else
            {
              localStringBuilder.append(m);
            }
            k++;
          }
          localStringBuilder.append('"');
        }
        else
        {
          localStringBuilder.append('?');
        }
        localStringBuilder.append('}');
      }
      else
      {
        localStringBuilder.append('[');
        k = b;
        if (k < 0) {
          k = j;
        }
        localStringBuilder.append(k);
        localStringBuilder.append(']');
      }
    }
    else
    {
      localStringBuilder.append("/");
    }
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.e.b.a.a.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */