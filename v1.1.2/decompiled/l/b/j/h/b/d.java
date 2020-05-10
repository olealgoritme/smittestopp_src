package l.b.j.h.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class d
  extends BufferedReader
{
  public d(Reader paramReader)
  {
    super(paramReader);
  }
  
  public b a()
  {
    String str1;
    do
    {
      str1 = readLine();
    } while ((str1 != null) && (!str1.startsWith("-----BEGIN ")));
    if (str1 != null)
    {
      str1 = str1.substring(11);
      int i = str1.indexOf('-');
      if ((i > 0) && (str1.endsWith("-----")) && (str1.length() - i == 5))
      {
        String str2 = str1.substring(0, i);
        str1 = e.a.a.a.a.b("-----END ", str2);
        StringBuffer localStringBuffer = new StringBuffer();
        ArrayList localArrayList = new ArrayList();
        String str3;
        for (;;)
        {
          str3 = readLine();
          if (str3 == null) {
            break;
          }
          if (str3.indexOf(":") >= 0)
          {
            i = str3.indexOf(':');
            localArrayList.add(new a(str3.substring(0, i), str3.substring(i + 1).trim()));
          }
          else
          {
            if (str3.indexOf(str1) != -1) {
              break;
            }
            localStringBuffer.append(str3.trim());
          }
        }
        if (str3 != null) {
          return new b(str2, localArrayList, l.b.j.g.a.a(localStringBuffer.toString()));
        }
        throw new IOException(e.a.a.a.a.b(str1, " not found"));
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     l.b.j.h.b.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */