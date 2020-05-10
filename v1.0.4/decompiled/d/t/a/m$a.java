package d.t.a;

import java.util.Comparator;

public final class m$a
  implements Comparator<m.c>
{
  public int compare(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (m.c)paramObject1;
    paramObject2 = (m.c)paramObject2;
    s locals = d;
    int i = 1;
    int j = 0;
    if (locals == null) {
      k = 1;
    } else {
      k = 0;
    }
    int m;
    if (d == null) {
      m = 1;
    } else {
      m = 0;
    }
    if (k != m)
    {
      if (d == null)
      {
        k = i;
        break label98;
      }
    }
    else
    {
      boolean bool = a;
      if (bool == a) {
        break label101;
      }
      k = i;
      if (!bool) {
        break label98;
      }
    }
    int k = -1;
    label98:
    break label144;
    label101:
    k = b - b;
    if (k == 0)
    {
      m = c - c;
      k = j;
      if (m != 0) {
        k = m;
      }
    }
    label144:
    return k;
  }
}

/* Location:
 * Qualified Name:     base.d.t.a.m.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */