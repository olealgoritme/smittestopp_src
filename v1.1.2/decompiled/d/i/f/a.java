package d.i.f;

import android.util.Base64;
import java.util.List;

public final class a
{
  public final String a;
  public final String b;
  public final String c;
  public final List<List<byte[]>> d;
  public final int e;
  public final String f;
  
  public a(String paramString1, String paramString2, String paramString3, List<List<byte[]>> paramList)
  {
    if (paramString1 != null)
    {
      a = paramString1;
      if (paramString2 != null)
      {
        b = paramString2;
        if (paramString3 != null)
        {
          c = paramString3;
          if (paramList != null)
          {
            d = paramList;
            e = 0;
            paramString1 = new StringBuilder(paramString1);
            paramString1.append("-");
            paramString1.append(b);
            paramString1.append("-");
            paramString1.append(c);
            f = paramString1.toString();
            return;
          }
          throw null;
        }
        throw null;
      }
      throw null;
    }
    throw null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = e.a.a.a.a.a("FontRequest {mProviderAuthority: ");
    ((StringBuilder)localObject).append(a);
    ((StringBuilder)localObject).append(", mProviderPackage: ");
    ((StringBuilder)localObject).append(b);
    ((StringBuilder)localObject).append(", mQuery: ");
    ((StringBuilder)localObject).append(c);
    ((StringBuilder)localObject).append(", mCertificates:");
    localStringBuilder.append(((StringBuilder)localObject).toString());
    for (int i = 0; i < d.size(); i++)
    {
      localStringBuilder.append(" [");
      localObject = (List)d.get(i);
      for (int j = 0; j < ((List)localObject).size(); j++)
      {
        localStringBuilder.append(" \"");
        localStringBuilder.append(Base64.encodeToString((byte[])((List)localObject).get(j), 0));
        localStringBuilder.append("\"");
      }
      localStringBuilder.append(" ]");
    }
    localStringBuilder.append("}");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mCertificatesArray: ");
    ((StringBuilder)localObject).append(e);
    localStringBuilder.append(((StringBuilder)localObject).toString());
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     d.i.f.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */