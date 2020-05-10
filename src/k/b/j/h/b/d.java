package k.b.j.h.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class d
  extends BufferedReader
{
  public d(Reader paramReader)
  {
    super(paramReader);
  }
  
  public b a()
  {
    Object localObject;
    do
    {
      localObject = readLine();
    } while ((localObject != null) && (!((String)localObject).startsWith("-----BEGIN ")));
    if (localObject != null)
    {
      localObject = ((String)localObject).substring(11);
      int i = ((String)localObject).indexOf('-');
      if ((i > 0) && (((String)localObject).endsWith("-----")) && (((String)localObject).length() - i == 5))
      {
        String str1 = ((String)localObject).substring(0, i);
        String str2 = e.a.a.a.a.b("-----END ", str1);
        StringBuffer localStringBuffer = new StringBuffer();
        localObject = new ArrayList();
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
            ((ArrayList)localObject).add(new a(str3.substring(0, i), str3.substring(i + 1).trim()));
          }
          else
          {
            if (str3.indexOf(str2) != -1) {
              break;
            }
            localStringBuffer.append(str3.trim());
          }
        }
        if (str3 != null) {
          return new b(str1, (List)localObject, k.b.j.g.a.a(localStringBuffer.toString()));
        }
        throw new IOException(e.a.a.a.a.b(str2, " not found"));
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     base.k.b.j.h.b.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */