package l.b.g;

import java.util.Enumeration;
import l.b.a.b0;
import l.b.a.e;
import l.b.a.i1;
import l.b.a.k;
import l.b.a.n;
import l.b.a.t;
import l.b.b.b;

public class f
{
  public f(byte[] paramArrayOfByte)
  {
    Object localObject = new k(paramArrayOfByte);
    paramArrayOfByte = ((k)localObject).readObject().e();
    try
    {
      paramArrayOfByte = b.a(paramArrayOfByte);
      if ((paramArrayOfByte instanceof l.b.a.l2.f)) {
        paramArrayOfByte = (l.b.a.l2.f)paramArrayOfByte;
      } else if (paramArrayOfByte != null) {
        paramArrayOfByte = new l.b.a.l2.f(l.b.a.u.a(paramArrayOfByte));
      } else {
        paramArrayOfByte = null;
      }
      paramArrayOfByte = y.z;
      paramArrayOfByte = ((k)localObject).readObject();
      if (paramArrayOfByte != null)
      {
        localObject = l.b.a.u.a(paramArrayOfByte.e()).j();
        while (((Enumeration)localObject).hasMoreElements())
        {
          paramArrayOfByte = (e)((Enumeration)localObject).nextElement();
          if ((paramArrayOfByte instanceof l.b.a.u))
          {
            l.b.a.u.a(paramArrayOfByte);
          }
          else if ((paramArrayOfByte instanceof b0))
          {
            l.b.a.u.a((b0)paramArrayOfByte, false);
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
            paramArrayOfByte.c();
          }
        }
      }
      return;
    }
    catch (IllegalArgumentException paramArrayOfByte)
    {
      localObject = e.a.a.a.a.a("malformed data: ");
      ((StringBuilder)localObject).append(paramArrayOfByte.getMessage());
      throw new l.b.b.a(((StringBuilder)localObject).toString(), paramArrayOfByte);
    }
    catch (ClassCastException paramArrayOfByte)
    {
      localObject = e.a.a.a.a.a("malformed data: ");
      ((StringBuilder)localObject).append(paramArrayOfByte.getMessage());
      throw new l.b.b.a(((StringBuilder)localObject).toString(), paramArrayOfByte);
    }
  }
}

/* Location:
 * Qualified Name:     l.b.g.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */