package k.b.a.l2;

import k.b.a.b0;
import k.b.a.d;
import k.b.a.e;
import k.b.a.h1;
import k.b.a.n;
import k.b.a.t;
import k.b.a.x;
import k.b.j.f;

public class i
  extends n
  implements d
{
  public e x;
  public int y;
  
  public i(b0 paramb0)
  {
    int i = x;
    y = i;
    if (i == 0) {
      paramb0 = m.a(paramb0, false);
    } else {
      paramb0 = x.a(paramb0, false);
    }
    x = paramb0;
  }
  
  public final void a(StringBuffer paramStringBuffer, String paramString1, String paramString2, String paramString3)
  {
    paramStringBuffer.append("    ");
    paramStringBuffer.append(paramString2);
    paramStringBuffer.append(":");
    paramStringBuffer.append(paramString1);
    paramStringBuffer.append("    ");
    paramStringBuffer.append("    ");
    paramStringBuffer.append(paramString3);
    paramStringBuffer.append(paramString1);
  }
  
  public t c()
  {
    return new h1(false, y, x);
  }
  
  public String toString()
  {
    String str1 = f.a;
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("DistributionPointName: [");
    localStringBuffer.append(str1);
    String str2;
    String str3;
    if (y == 0)
    {
      str2 = x.toString();
      str3 = "fullName";
    }
    else
    {
      str2 = x.toString();
      str3 = "nameRelativeToCRLIssuer";
    }
    a(localStringBuffer, str1, str3, str2);
    localStringBuffer.append("]");
    localStringBuffer.append(str1);
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.l2.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */