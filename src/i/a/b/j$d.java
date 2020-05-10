package i.a.b;

public class j$d
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
    int j = paramString.charAt(0);
    if (((j >= 48) && (j <= 57)) || (j == 45)) {
      return true;
    }
    for (j = 0;; j++)
    {
      if (j >= i) {
        return j.a(paramString);
      }
      char c = paramString.charAt(j);
      int k;
      if ((c != '\r') && (c != '\n') && (c != '\t') && (c != ' ')) {
        k = 0;
      } else {
        k = 1;
      }
      if (k != 0) {
        return true;
      }
      if (j.a(c)) {
        return true;
      }
      if ((c != '\b') && (c != '\f') && (c != '\n')) {
        k = 0;
      } else {
        k = 1;
      }
      if (k != 0) {
        return true;
      }
      if (j.b(c)) {
        return true;
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.i.a.b.j.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */