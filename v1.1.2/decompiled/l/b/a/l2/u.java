package l.b.a.l2;

import java.math.BigInteger;
import l.b.a.b0;
import l.b.a.k2.c;
import l.b.a.l;
import l.b.a.n;
import l.b.a.r0;
import l.b.a.t;

public class u
  extends n
{
  public l.b.a.u x;
  public l y;
  public k z;
  
  public u(l.b.a.u paramu)
  {
    x = paramu;
    if ((paramu.a(0) instanceof b0))
    {
      y = l.a((b0)paramu.a(0), true);
      i = 0;
    }
    else
    {
      y = new l(0L);
      i = -1;
    }
    int j;
    if (y.a(BigInteger.valueOf(0L)))
    {
      j = 1;
    }
    else
    {
      if (y.a(BigInteger.valueOf(1L)))
      {
        j = 0;
        k = 1;
        break label117;
      }
      if (!y.a(BigInteger.valueOf(2L))) {
        break label359;
      }
      j = 0;
    }
    int k = 0;
    label117:
    l.a(paramu.a(i + 1));
    a.a(paramu.a(i + 2));
    c.a(paramu.a(i + 3));
    Object localObject = (l.b.a.u)paramu.a(i + 4);
    v.a(((l.b.a.u)localObject).a(0));
    v.a(((l.b.a.u)localObject).a(1));
    c.a(paramu.a(i + 5));
    int m = i + 6;
    s.a(paramu.a(m));
    int n = paramu.size() - m - 1;
    int i = n;
    if (n != 0) {
      if (j == 0) {
        i = n;
      } else {
        throw new IllegalArgumentException("version 1 certificate contains extra data");
      }
    }
    while (i > 0)
    {
      localObject = (b0)paramu.a(m + i);
      j = x;
      if ((j != 1) && (j != 2))
      {
        if (j == 3)
        {
          if (k == 0) {
            z = k.a(l.b.a.u.a((b0)localObject, true));
          } else {
            throw new IllegalArgumentException("version 2 certificate cannot contain extensions");
          }
        }
        else
        {
          paramu = e.a.a.a.a.a("Unknown tag encountered in structure: ");
          paramu.append(x);
          throw new IllegalArgumentException(paramu.toString());
        }
      }
      else {
        r0.a((b0)localObject, false);
      }
      i--;
    }
    return;
    label359:
    throw new IllegalArgumentException("version number not recognised");
  }
  
  public t b()
  {
    return x;
  }
}

/* Location:
 * Qualified Name:     l.b.a.l2.u
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */