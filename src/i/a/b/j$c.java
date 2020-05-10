package i.a.b;

public class j$c
  implements j.f
{
  public boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    int i = paramString.length();
    if (i == 0) {
      return true;
    }
    if (paramString.trim() != paramString) {
      return true;
    }
    char c = paramString.charAt(0);
    if ((!j.a(c)) && (!j.b(c))) {
      for (int j = 1;; j++)
      {
        int m;
        if (j >= i)
        {
          if (j.a(paramString)) {
            return true;
          }
          int k = paramString.charAt(0);
          if (((k >= 48) && (k <= 57)) || (k == 45))
          {
            m = 1;
            while (m < i)
            {
              j = paramString.charAt(m);
              k = j;
              if (j < 48) {
                break;
              }
              if (j > 57)
              {
                k = j;
                break;
              }
              m++;
              k = j;
            }
            if (m == i) {
              return true;
            }
            int n = k;
            j = m;
            if (k == 46) {}
            do
            {
              j = m + 1;
              n = k;
              if (j >= i)
              {
                k = n;
                break;
              }
              n = paramString.charAt(j);
              k = n;
              if (n < 48) {
                break;
              }
              k = n;
              m = j;
            } while (n <= 57);
            k = n;
            if (j == i) {
              return true;
            }
            if (k != 69)
            {
              m = j;
              if (k != 101) {}
            }
            else
            {
              j++;
              if (j == i) {
                return false;
              }
              k = paramString.charAt(j);
              if (k != 43)
              {
                m = j;
                if (k != 45) {}
              }
              else
              {
                m = j + 1;
                paramString.charAt(m);
              }
            }
            j = m;
            if (m == i) {
              return false;
            }
            while (j < i)
            {
              m = paramString.charAt(j);
              if ((m < 48) || (m > 57)) {
                break;
              }
              j++;
            }
            if (j == i) {
              return true;
            }
          }
          return false;
        }
        c = paramString.charAt(j);
        if ((c != '}') && (c != ']') && (c != ',') && (c != ':')) {
          m = 0;
        } else {
          m = 1;
        }
        if ((m != 0) || (j.b(c))) {
          break;
        }
      }
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     base.i.a.b.j.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */