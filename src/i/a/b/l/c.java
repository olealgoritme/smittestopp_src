package i.a.b.l;

import java.math.BigInteger;

public abstract class c
  extends b
{
  public int w;
  
  public c(int paramInt)
  {
    super(paramInt);
  }
  
  public Object a(boolean[] paramArrayOfBoolean)
  {
    int i = f;
    c();
    f();
    int j = a;
    boolean bool1 = true;
    if ((j != 46) && (j != 69) && (j != 101))
    {
      g();
      j = a;
      if ((j >= 0) && (j < 126) && (paramArrayOfBoolean[j] == 0) && (j != 26))
      {
        b(paramArrayOfBoolean);
        a(i, f);
        if (this.i) {
          return e;
        }
        throw new e(f, 1, e);
      }
      a(i, f);
      paramArrayOfBoolean = e;
      int k = paramArrayOfBoolean.length();
      int m;
      if (paramArrayOfBoolean.charAt(0) == '-')
      {
        m = 20;
        if ((!g) && (k >= 3) && (paramArrayOfBoolean.charAt(1) == '0')) {
          throw new e(f, 6, paramArrayOfBoolean);
        }
        i = 1;
        j = 1;
      }
      else
      {
        if ((!g) && (k >= 2) && (paramArrayOfBoolean.charAt(0) == '0')) {
          throw new e(f, 6, paramArrayOfBoolean);
        }
        m = 19;
        i = 0;
        j = 0;
      }
      if (k < m)
      {
        m = k;
        k = 0;
      }
      else
      {
        if (k > m)
        {
          paramArrayOfBoolean = new BigInteger(paramArrayOfBoolean, 10);
          break label491;
        }
        m = k - 1;
        k = 1;
      }
      long l1 = 0L;
      for (;;)
      {
        if (i >= m)
        {
          long l2 = l1;
          if (k != 0)
          {
            boolean bool2 = l1 < -922337203685477580L;
            if (!bool2)
            {
              if (bool2)
              {
                bool2 = bool1;
                break label378;
              }
              if (j != 0)
              {
                if (paramArrayOfBoolean.charAt(i) > '8')
                {
                  bool2 = bool1;
                  break label378;
                }
              }
              else if (paramArrayOfBoolean.charAt(i) > '7')
              {
                bool2 = bool1;
                break label378;
              }
            }
            bool2 = false;
            label378:
            if (bool2) {
              paramArrayOfBoolean = new BigInteger(paramArrayOfBoolean, 10);
            } else {
              l2 = l1 * 10L + ('0' - paramArrayOfBoolean.charAt(i));
            }
          }
          else if (j != 0)
          {
            if ((p) && (l2 >= -2147483648L)) {
              paramArrayOfBoolean = Integer.valueOf((int)l2);
            } else {
              paramArrayOfBoolean = Long.valueOf(l2);
            }
          }
          else
          {
            l1 = -l2;
            if ((p) && (l1 <= 2147483647L)) {
              paramArrayOfBoolean = Integer.valueOf((int)l1);
            } else {
              paramArrayOfBoolean = Long.valueOf(l1);
            }
          }
          label491:
          return paramArrayOfBoolean;
        }
        l1 = l1 * 10L + ('0' - paramArrayOfBoolean.charAt(i));
        i++;
      }
    }
    if (a == '.')
    {
      c();
      f();
    }
    j = a;
    if ((j != 69) && (j != 101))
    {
      g();
      j = a;
      if ((j >= 0) && (j < 126) && (paramArrayOfBoolean[j] == 0) && (j != 26))
      {
        b(paramArrayOfBoolean);
        a(i, f);
        if (this.i) {
          return e;
        }
        throw new e(f, 1, e);
      }
      a(i, f);
      return b();
    }
    c.a('E');
    c();
    j = a;
    if ((j != 43) && (j != 45) && ((j < 48) || (j > 57)))
    {
      b(paramArrayOfBoolean);
      a(i, f);
      if (this.i)
      {
        if (!g) {
          a();
        }
        return e;
      }
      throw new e(f, 1, e);
    }
    c.a(a);
    c();
    f();
    g();
    j = a;
    if ((j >= 0) && (j < 126) && (paramArrayOfBoolean[j] == 0) && (j != 26))
    {
      b(paramArrayOfBoolean);
      a(i, f);
      if (this.i) {
        return e;
      }
      throw new e(f, 1, e);
    }
    a(i, f);
    return b();
  }
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public void e()
  {
    if ((!this.j) && (a == '\''))
    {
      if (this.i)
      {
        localObject = b.r;
        i = f;
        b((boolean[])localObject);
        a(i, f);
        return;
      }
      throw new e(f, 0, Character.valueOf(a));
    }
    int i = a;
    int j = f;
    Object localObject = (d)this;
    j = x.indexOf(i, j + 1);
    if (j != -1)
    {
      i = f;
      e = x.substring(i + 1, j);
      int m;
      if (e.indexOf('\\') == -1)
      {
        int k;
        if (!n) {
          k = e.length();
        }
        for (i = 0;; i++)
        {
          if (i >= k)
          {
            f = j;
            c();
            return;
          }
          m = e.charAt(i);
          if (m >= 0)
          {
            if (m <= 31) {
              break;
            }
            if ((m == 127) && (q)) {
              throw new e(f + i, 0, Character.valueOf(m));
            }
          }
        }
        throw new e(f + i, 0, Character.valueOf(m));
      }
      c.b = -1;
      i = a;
      for (;;)
      {
        c();
        j = a;
        if ((j != 34) && (j != 39))
        {
          if (j != 92)
          {
            if (j != 127)
            {
              switch (j)
              {
              default: 
                break;
              case 26: 
                throw new e(f - 1, 3, null);
              case 0: 
              case 1: 
              case 2: 
              case 3: 
              case 4: 
              case 5: 
              case 6: 
              case 7: 
              case 8: 
              case 9: 
              case 10: 
              case 11: 
              case 12: 
              case 13: 
              case 14: 
              case 15: 
              case 16: 
              case 17: 
              case 18: 
              case 19: 
              case 20: 
              case 21: 
              case 22: 
              case 23: 
              case 24: 
              case 25: 
              case 27: 
              case 28: 
              case 29: 
              case 30: 
              case 31: 
                if (n) {
                  continue;
                }
                throw new e(f, 0, Character.valueOf(a));
              }
            }
            else
            {
              if (n) {
                continue;
              }
              if (q) {
                break label528;
              }
            }
            c.a(a);
            continue;
            label528:
            throw new e(f, 0, Character.valueOf(a));
          }
          else
          {
            c();
            j = a;
            if (j != 34)
            {
              if (j != 39)
              {
                if (j != 47)
                {
                  if (j != 92)
                  {
                    if (j != 98)
                    {
                      if (j != 102)
                      {
                        if (j != 110)
                        {
                          if (j != 114)
                          {
                            if (j != 120)
                            {
                              if (j != 116)
                              {
                                if (j == 117) {
                                  c.a(a(4));
                                }
                              }
                              else {
                                c.a('\t');
                              }
                            }
                            else {
                              c.a(a(2));
                            }
                          }
                          else {
                            c.a('\r');
                          }
                        }
                        else {
                          c.a('\n');
                        }
                      }
                      else {
                        c.a('\f');
                      }
                    }
                    else {
                      c.a('\b');
                    }
                  }
                  else {
                    c.a('\\');
                  }
                }
                else {
                  c.a('/');
                }
              }
              else {
                c.a('\'');
              }
            }
            else {
              c.a('"');
            }
          }
        }
        else
        {
          m = a;
          if (i == m)
          {
            c();
            e = c.toString();
            return;
          }
          c.a(m);
        }
      }
    }
    throw new e(w, 3, null);
  }
}

/* Location:
 * Qualified Name:     base.i.a.b.l.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */