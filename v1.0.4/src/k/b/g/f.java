package k.b.g;

import java.util.Enumeration;
import k.b.a.b0;
import k.b.a.e;
import k.b.a.i1;
import k.b.a.k;
import k.b.a.n;
import k.b.a.t;
import k.b.b.b;

public class f
{
  public f(byte[] paramArrayOfByte)
  {
    Object localObject = new k(paramArrayOfByte);
    paramArrayOfByte = ((k)localObject).readObject().e();
    try
    {
      paramArrayOfByte = b.a(paramArrayOfByte);
      if ((paramArrayOfByte instanceof k.b.a.l2.f)) {
        paramArrayOfByte = (k.b.a.l2.f)paramArrayOfByte;
      } else if (paramArrayOfByte != null) {
        paramArrayOfByte = new k.b.a.l2.f(k.b.a.u.a(paramArrayOfByte));
      } else {
        paramArrayOfByte = null;
      }
      paramArrayOfByte = y.z;
      paramArrayOfByte = ((k)localObject).readObject();
      if (paramArrayOfByte != null)
      {
        localObject = k.b.a.u.a(paramArrayOfByte.e()).j();
        while (((Enumeration)localObject).hasMoreElements())
        {
          paramArrayOfByte = (e)((Enumeration)localObject).nextElement();
          if ((paramArrayOfByte instanceof k.b.a.u))
          {
            k.b.a.u.a(paramArrayOfByte);
          }
          else if ((paramArrayOfByte instanceof b0))
          {
            k.b.a.u.a((b0)paramArrayOfByte, false);
          }
          else if ((paramArrayOfByte instanceof i1))
          {
            if ((paramArrayOfByte != null) && (!(paramArrayOfByte instanceof i1)))
            {
              if ((paramArrayOfByte instanceof byte[]))
              {
                try
                {
                  paramArrayOfByte = (i1)t.a((byte[])paramArrayOfByte);
                }
                catch (Exception paramArrayOfByte)
                {
                  throw new IllegalArgumentException(e.a.a.a.a.a(paramArrayOfByte, e.a.a.a.a.a("encoding error in getInstance: ")));
                }
              }
              else
              {
                localObject = e.a.a.a.a.a("illegal object in getInstance: ");
                ((StringBuilder)localObject).append(paramArrayOfByte.getClass().getName());
                throw new IllegalArgumentException(((StringBuilder)localObject).toString());
              }
            }
            else {
              paramArrayOfByte = (i1)paramArrayOfByte;
            }
            paramArrayOfByte.d();
          }
        }
      }
      return;
    }
    catch (IllegalArgumentException paramArrayOfByte)
    {
      localObject = e.a.a.a.a.a("malformed data: ");
      ((StringBuilder)localObject).append(paramArrayOfByte.getMessage());
      throw new k.b.b.a(((StringBuilder)localObject).toString(), paramArrayOfByte);
    }
    catch (ClassCastException paramArrayOfByte)
    {
      localObject = e.a.a.a.a.a("malformed data: ");
      ((StringBuilder)localObject).append(paramArrayOfByte.getMessage());
      throw new k.b.b.a(((StringBuilder)localObject).toString(), paramArrayOfByte);
    }
  }
}

/* Location:
 * Qualified Name:     base.k.b.g.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */