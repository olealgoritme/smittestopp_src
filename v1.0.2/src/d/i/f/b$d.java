package d.i.f;

import java.util.Comparator;

public final class b$d
  implements Comparator<byte[]>
{
  public int compare(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (byte[])paramObject1;
    paramObject2 = (byte[])paramObject2;
    int i = paramObject1.length;
    int j = paramObject2.length;
    int k = 0;
    if (i != j)
    {
      i = paramObject1.length;
      j = paramObject2.length;
    }
    for (i = 0;; i++)
    {
      j = k;
      if (i >= paramObject1.length) {
        break;
      }
      if (paramObject1[i] != paramObject2[i])
      {
        k = paramObject1[i];
        j = paramObject2[i];
        i = k;
        j = i - j;
        break;
      }
    }
    return j;
  }
}

/* Location:
 * Qualified Name:     base.d.i.f.b.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */