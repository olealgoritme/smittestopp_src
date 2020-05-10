package k.b.a.l2;

import k.b.a.b;
import k.b.a.b0;
import k.b.a.c;
import k.b.a.n;
import k.b.a.r0;
import k.b.a.t;
import k.b.a.u;
import k.b.j.f;

public class p
  extends n
{
  public r A;
  public boolean B;
  public boolean C;
  public u D;
  public i x;
  public boolean y;
  public boolean z;
  
  public p(u paramu)
  {
    D = paramu;
    for (int i = 0; i != paramu.size(); i++)
    {
      Object localObject = b0.a(paramu.a(i));
      int j = x;
      if (j != 0)
      {
        if (j != 1)
        {
          if (j != 2)
          {
            if (j != 3)
            {
              if (j != 4)
              {
                if (j == 5) {
                  C = c.a((b0)localObject, false).j();
                } else {
                  throw new IllegalArgumentException("unknown tag in IssuingDistributionPoint");
                }
              }
              else {
                B = c.a((b0)localObject, false).j();
              }
            }
            else {
              A = new r(r0.a((b0)localObject, false));
            }
          }
          else {
            z = c.a((b0)localObject, false).j();
          }
        }
        else {
          y = c.a((b0)localObject, false).j();
        }
      }
      else
      {
        localObject = b0.a(((b0)localObject).j());
        if ((localObject != null) && (!(localObject instanceof i))) {
          localObject = new i((b0)localObject);
        } else {
          localObject = (i)localObject;
        }
        x = ((i)localObject);
      }
    }
  }
  
  public final String a(boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "true";
    } else {
      str = "false";
    }
    return str;
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
    return D;
  }
  
  public String toString()
  {
    String str = f.a;
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("IssuingDistributionPoint: [");
    localStringBuffer.append(str);
    Object localObject = x;
    if (localObject != null) {
      a(localStringBuffer, str, "distributionPoint", ((i)localObject).toString());
    }
    boolean bool = y;
    if (bool) {
      a(localStringBuffer, str, "onlyContainsUserCerts", a(bool));
    }
    bool = z;
    if (bool) {
      a(localStringBuffer, str, "onlyContainsCACerts", a(bool));
    }
    localObject = A;
    if (localObject != null) {
      a(localStringBuffer, str, "onlySomeReasons", ((b)localObject).d());
    }
    bool = C;
    if (bool) {
      a(localStringBuffer, str, "onlyContainsAttributeCerts", a(bool));
    }
    bool = B;
    if (bool) {
      a(localStringBuffer, str, "indirectCRL", a(bool));
    }
    localStringBuffer.append("]");
    localStringBuffer.append(str);
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.l2.p
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */