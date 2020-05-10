package j.a.b.l;

import j.a.b.i;
import j.a.b.n.f;
import java.io.IOException;

public class a
{
  public int a;
  public d b;
  
  static
  {
    System.getProperty("JSON_SMART_SIMPLE");
  }
  
  public a(int paramInt)
  {
    a = paramInt;
  }
  
  public Object a(String paramString)
  {
    if (b == null) {
      b = new d(a);
    }
    d locald = b;
    if (locald != null)
    {
      f localf = cb;
      j.a.b.n.e locale = a;
      x = paramString;
      w = paramString.length();
      f = -1;
      try
      {
        locald.c();
        paramString = locald.b(localf);
        if (l)
        {
          if (!m) {
            locald.g();
          }
          if (a != '\032')
          {
            paramString = new j/a/b/l/e;
            paramString.<init>(f - 1, 1, Character.valueOf(a));
            throw paramString;
          }
        }
        e = null;
        d = null;
        return paramString;
      }
      catch (IOException paramString)
      {
        throw new e(f, paramString);
      }
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     j.a.b.l.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */